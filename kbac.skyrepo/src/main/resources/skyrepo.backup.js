skyrepoMigrate = function () {
    if (!fileExists("skyrepo"))
        return;
    var settings = elasticMapping();
    var indices = EcObject.keys(settings);
    var types = idxIndices(".", "skyrepo");
    for (var i = 0; i < indices.length; i++)
        types = types.concat(EcObject.keys(settings[indices[i]].mappings));
    for (var i = 0; i < types.length; i++) {
        try {
            var counter = 0;
            var keys = idxKeys(".", "skyrepo", types[i]);
            for (var j = 0; j < keys.length; j++) {
                if (++counter % 100 == 0)
                    console.log(types[i] + ": Migrated " + counter + "/" + keys.length + " versions of records out of local database and into ElasticSearch.");
                var data = JSON.parse(idxGet(".", "skyrepo", types[i], keys[j]));
                var split = [keys[j].substring(0, keys[j].lastIndexOf("/")), keys[j].substring(keys[j].lastIndexOf("/") + 1)];
                skyrepoPutInternalPermanent(data, split[0], split[1], types[i]);
                if (skyrepoGetPermanent(split[0], split[1], types[i])["found"] == false) {
                    console.log("Failed to migrate record. Halting. " + [split[0], split[1], types[i], JSON.stringify(data, null, 2), JSON.stringify(skyrepoGetPermanent(split[0], split[1], types[i]), null, 2)]);
                }
            }
        }
        catch (e) {
            console.log("Could not migrate " + types[i]);
        }
    }
    if (counter > 0) {
        fileSave(fileLoad("skyrepo"), "skyrepoOld");
        fileDelete("skyrepo");
        fileSave(fileLoad("skyrepo.p"), "skyrepoOld.p");
        fileDelete("skyrepo.p");
        fileSave(fileLoad("skyrepo.t"), "skyrepoOld.t");
        fileDelete("skyrepo.t");
    }
};

var skyrepoMigrateAutoExecute = skyrepoMigrate;

skyrepoReindex = function () {
    skyrepoDebug = true;
    if (this.params.secret != skyIdSecret())
        error("You must provide secret=`cat skyId.secret` to invoke reindex.", 401);

    var firstQueryPost = {
        query: {
            query_string: {query: "*:*"}
        },
        explain: "false",
        size: "50",
        sort: "_doc"
    };
    var firstQueryUrl = elasticEndpoint + "/_search?scroll=1m&version";
    var results = httpPost(JSON.stringify(firstQueryPost), firstQueryUrl, "application/json", "false");
    var scroll = results["_scroll_id"];
    var counter = 0;
    while (results != null && scroll != null && scroll != "") {
        scroll = results["_scroll_id"];
        var hits = results.hits.hits;
        if (hits.length == 0)
            break;
        for (var i = 0; i < hits.length; i++) {
            if (++counter % 1000 == 0)
                console.log("Reindexed " + counter + " records.");
            if (hits[i]["_type"] == "permanent") {
                skyrepoPutInternalPermanent(JSON.parse(hits[i]["_source"].data), hits[i]["_id"].replace("." + hits[i]["_version"], "").replace(/\.$/, ""), hits[i]["_version"], hits[i]["_type"]);
            }
        }
        results = httpGet(elasticEndpoint + "/_search/scroll?scroll=1m&scroll_id=" + scroll);
    }
    skyrepoDebug = false;
}
bindWebService("/util/reindex", skyrepoReindex);

skyrepoBackup = function () {
    if (this.params.secret != skyIdSecret())
        error("You must provide secret=`cat skyId.secret` to invoke backup.", 401);
    var backup = {permanent: {}, indexed: {}};
    var settings = elasticMapping();
    var indices = EcObject.keys(settings);

    var firstQueryPost = {
        query: {
            query_string: {query: "*:*"}
        },
        explain: "false",
        size: "50",
        sort: "_doc"
    };
    var firstQueryUrl = elasticEndpoint + "/_search?scroll=1m&version";
    var results = httpPost(JSON.stringify(firstQueryPost), firstQueryUrl, "application/json", "false");
    var scroll = results["_scroll_id"];
    while (results != null && scroll != null && scroll != "") {
        scroll = results["_scroll_id"];
        var hits = results.hits.hits;
        if (hits.length == 0)
            break;
        for (var i = 0; i < hits.length; i++) {
            var key = hits[i]["_type"] + "/" + hits[i]["_id"] + "/" + hits[i]["_version"];
            if (hits[i]["_type"] == "permanent")
                if (backup.permanent[key] == null)
                    backup.permanent[key] = hits[i]["_source"];
                else if (backup.indexed[key] == null)
                    backup.indexed[key] = hits[i]["_source"];
        }
        results = httpGet(elasticEndpoint + "/_search/scroll?scroll=1m&scroll_id=" + scroll);
    }
    return JSON.stringify(backup, null, 2);
}
bindWebService("/util/backup", skyrepoBackup);

skyrepoRestore = function () {
    var log = [];
    if (this.params.secret != skyIdSecret())
        error("You must provide secret=`cat skyId.secret` to invoke a restore.", 401);

    var file = getFileFromPost.call(this, "data");
    if (file == undefined || file == null)
        error("Unable to find restore file. Please attach via a multi part POST request with the name = 'data'.", 400);
    if (EcArray.isArray(file))
        file = file[0];
    file = JSON.parse(fileToString(file));
    var keys = EcObject.keys(file.indexed);
    for (var i = 0; i < keys.length; i++) {
        var parts = keys[i].split("/");
        log.push(skyrepoPutInternalIndex(file.indexed[keys[i]], parts[1], parts[2], parts[0]));
    }
    keys = EcObject.keys(file.permanent);
    for (var i = 0; i < keys.length; i++) {
        var parts = keys[i].split("/");
        log.push(skyrepoPutInternalPermanent(file.permanent[keys[i]], parts[1], parts[2], parts[0]));
    }
    return JSON.stringify(log, null, 2);
}
bindWebService("/util/restore", skyrepoRestore);

skyrepoPurge = function () {
    if (this.params.secret != skyIdSecret())
        error("You must provide secret=`cat skyId.secret` to invoke purge.", 401);
    var log = [];
    var settings = elasticMapping();
    var indices = EcObject.keys(settings);
    var types = [];
    for (var i = 0; i < indices.length; i++) {
        types = types.concat(EcObject.keys(settings[indices[i]].mappings));
        log.push(httpDelete(elasticEndpoint + "/" + indices[i]));
    }
    return JSON.stringify(log, null, 2);
}
bindWebService("/util/purge", skyrepoPurge);