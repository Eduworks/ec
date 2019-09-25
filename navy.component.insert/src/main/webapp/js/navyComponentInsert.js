var TARGET_CASS_SERVER = "https://cass.asid.eduworks.com/api/";

var fileJson;
var repo;
var insertType;
var logCtr = 0;
var currentOccTaskIdx;
var currentJobIdx;

var currentRatingIdx;
var currentRatingObj;
var currentRatingJobs;
var currentRatingNecs;
var currentRatingSkillsAndAbilities;
var currentRatingOccTasks;
var currentRatingRelationsToAdd;
var currentRatingJobsContainerComp;
var currentRatingNecsContainerComp;
var numberOfJobsToProcess;
var numberOfJobsProcessed;
var numberOfOccTasksToProcess;
var numberOfOccTasksProcessed;

function initRepo() {
    repo = new EcRepository();
    repo.selectedServer = TARGET_CASS_SERVER;
}

function clearLogArea() {
    $("#logArea").val("");
}

function log(s) {
    logCtr++;
    if (logCtr % 1000 === 0) clearLogArea();
    var oldLog = $("#logArea").val();
    var today  = new Date();
    $("#logArea").val(oldLog + "(" + today.toLocaleString() + "): " + s + "\n");
}

function createCompetencyObject(id,name,desc,dcTermType,code) {
    var c = new EcCompetency();
    if (id) c.id = id;
    else c.generateId(repo.selectedServer);
    c.setName(name);
    if (desc) c.setDescription(desc);
    if (dcTermType) c['dcterms:type'] = dcTermType;
    if (code) c['ceasn:codedNotation'] = code;
    return c;
}

function createFrameworkObject(id,name,desc,dcTermType,code) {
    var fw = new EcFramework();
    if (id) fw.id = id;
    else fw.generateId(repo.selectedServer);
    fw.setName(name);
    if (desc) fw.setDescription(desc);
    if (dcTermType) fw['dcterms:type'] = dcTermType;
    if (code) fw['ceasn:codedNotation'] = code;
    return fw;
}

function consoleLogSuccess(obj) {
    console.log("CASS Save Success: " + obj);
}

function logError(err) {
    log(err);
}

function insertRelations(targetId,sourceList,relType) {
    var relIdList = [];
    if (sourceList) {
        for (var i=0;i<sourceList.length;i++) {
            var a = new EcAlignment();
            a.relationType = relType;
            a.target = targetId;
            a.source = sourceList[i];
            a.generateId(repo.selectedServer);
            relIdList.push(a.shortId());
            repo.saveTo(a,consoleLogSuccess,logError);
        }
    }
    return relIdList;
}

function insertSkills() {
    log("Inserting Skills data...");
    log("Number of Skills found: " + fileJson.length);
    //for (var i=0;i<1;i++) {
    for (var i=0;i<fileJson.length;i++) {
        var id = fileJson[i]["externalId"];
        var name = fileJson[i]["name"];
        var dcTermType = fileJson[i]["dcTermsType"];
        log("Generating skill: " + id);
        var c = createCompetencyObject(id,name,null,dcTermType,null);
        repo.saveTo(c,consoleLogSuccess,logError);
    }
}

function insertAbilities() {
    log("Inserting Abilities data...");
    log("Number of Abilities found: " + fileJson.length);
    for (var i=0;i<fileJson.length;i++) {
        var id = fileJson[i]["externalId"];
        var name = fileJson[i]["name"];
        var dcTermType = fileJson[i]["dcTermsType"];
        log("Generating ability: " + id);
        var c = createCompetencyObject(id,name,null,dcTermType,null);
        repo.saveTo(c,consoleLogSuccess,logError);
    }
}

function insertOccTask() {
    if (currentOccTaskIdx >= fileJson.length) {
        log("Completed generating occupational tasks...");
    }
    else {
        var id = fileJson[currentOccTaskIdx]["externalId"];
        log("Generating occupational task (" + currentOccTaskIdx + "): " + id);
        var name = fileJson[currentOccTaskIdx]["name"];
        var dcTermType = fileJson[currentOccTaskIdx]["dcTermsType"];
        var code = null;
        if (fileJson[currentOccTaskIdx]["code"]) code = fileJson[currentOccTaskIdx]["code"];
        var c = createCompetencyObject(id,name,null,dcTermType,code);
        var skills = fileJson[currentOccTaskIdx]["skills"];
        var abilities = fileJson[currentOccTaskIdx]["abilities"];
        log("Generating skill relations...");
        insertRelations(id,skills,EcAlignment.NARROWS);
        log("Generating ability relations...");
        insertRelations(id,abilities,EcAlignment.NARROWS);
        repo.saveTo(c,
            function(p1) {
                currentOccTaskIdx++;
                insertOccTask();
            },
            function(p1) {
                currentOccTaskIdx++;
                insertOccTask();
            }
        );
    }
}

function insertOccTasks() {
    log("Inserting Occupational Tasks data...");
    log("Number of Occupational Tasks found: " + fileJson.length);
    currentOccTaskIdx = 0;
    insertOccTask();
}

function insertNecs() {
    log("Inserting NECs data...");
    log("Number of NECs found: " + fileJson.length);
    for (var i=0;i<fileJson.length;i++) {
        var id = fileJson[i]["externalId"];
        var name = fileJson[i]["name"];
        var dcTermType = fileJson[i]["dcTermsType"];
        var code = null;
        if (fileJson[i]["code"]) code = fileJson[i]["code"];
        var desc = null;
        if (fileJson[i]["description"]) desc = fileJson[i]["description"];
        log("Generating NEC: " + id);
        var c = createCompetencyObject(id,name,desc,dcTermType,code);
        repo.saveTo(c,consoleLogSuccess,logError);
    }
}

function distinct(value, index, self) {
    return self.indexOf(value) === index;
}

function insertJob() {
    if (currentJobIdx >= fileJson.length) {
        log("Completed generating jobs...");
    }
    else {
        var id = fileJson[currentJobIdx]["externalId"];
        log("Generating job (" + currentJobIdx + "): " + id);
        var name = fileJson[currentJobIdx]["name"];
        var dcTermType = fileJson[currentJobIdx]["dcTermsType"];
        var code = null;
        if (fileJson[currentJobIdx]["code"]) code = fileJson[currentJobIdx]["code"];
        var c = createCompetencyObject(id,name,null,dcTermType,code);
        var occTasks = fileJson[currentJobIdx]["occupationalTasks"];
        var occTasksDistinct = occTasks.filter(distinct);
        log("Generating occupation task relations(" + occTasksDistinct.length + ")...");
        insertRelations(id,occTasksDistinct,EcAlignment.NARROWS);
        repo.saveTo(c,
            function(p1) {
                currentJobIdx++;
                insertJob();
            },
            function(p1) {
                currentJobIdx++;
                insertJob();
            }
        );
    }
}

function insertJobs() {
    log("Inserting Jobs data...");
    log("Number of Jobs found: " + fileJson.length);
    currentJobIdx = 0;
    insertJob();
}

function addIdsToCurrentRatingRelations(idList) {
    if (idList && idList.length > 0) {
        for (var i=0;i<idList.length;i++) {
            currentRatingObj.addRelation(idList[i]);
        }
    }
}

function addIdsToCurrentRatingCompetencies(idList) {
    if (idList && idList.length > 0) {
        for (var i=0;i<idList.length;i++) {
            currentRatingObj.addCompetency(idList[i]);
        }
    }
}

function buildAndPopulateRatingContainers(code,name) {
    var jcn = "Jobs";
    var ncn = "NECs";
    if (code) {
        jcn += " (" + code + ")";
        ncn += " (" + code + ")";
    }
    if (currentRatingJobs && currentRatingJobs.length > 0) {
        addIdsToCurrentRatingCompetencies(currentRatingJobs);
        currentRatingJobsContainerComp = createCompetencyObject(null,jcn,"Jobs for " + name,null,null);
        repo.saveTo(currentRatingJobsContainerComp,consoleLogSuccess,logError);
        currentRatingObj.addCompetency(currentRatingJobsContainerComp.shortId());
        var jobContainerRelations = insertRelations(currentRatingJobsContainerComp.shortId(),currentRatingJobs,EcAlignment.NARROWS);
        addIdsToCurrentRatingRelations(jobContainerRelations);
    }
    if (currentRatingNecs && currentRatingNecs.length > 0) {
        addIdsToCurrentRatingCompetencies(currentRatingNecs);
        currentRatingNecsContainerComp = createCompetencyObject(null, ncn, "NECs for " + name, null, null);
        repo.saveTo(currentRatingNecsContainerComp, consoleLogSuccess, logError);
        currentRatingObj.addCompetency(currentRatingNecsContainerComp.shortId());
        var necContainerRelations = insertRelations(currentRatingNecsContainerComp.shortId(),currentRatingNecs,EcAlignment.NARROWS);
        addIdsToCurrentRatingRelations(necContainerRelations);
    }
}

function findCurrentRatingOccTaskSkillsAndAbilitiesSuccess(arrayOfAlignments) {
    //log("Adding Skills and Abilities to Rating: " + arrayOfAlignments.length);
    if (arrayOfAlignments && arrayOfAlignments.length > 0) {
        for (var i=0;i<arrayOfAlignments.length;i++) {
            currentRatingRelationsToAdd.push(arrayOfAlignments[i].shortId());
            currentRatingSkillsAndAbilities.push(arrayOfAlignments[i].source);
        }
    }
    numberOfOccTasksProcessed ++;
    if (numberOfOccTasksProcessed >= numberOfOccTasksToProcess) saveCurrentRating();
}

function findCurrentRatingOccTaskSkillsAndAbilitiesFailure(err) {
    log("findCurrentRatingOccTaskSkillsAndAbilitiesFailure: " + err);
    numberOfOccTasksProcessed ++;
    if (numberOfOccTasksProcessed >= numberOfOccTasksToProcess) saveCurrentRating();
}

function findAllCurrentRatingOccTaskSubItems() {
    currentRatingOccTasks = currentRatingOccTasks.filter(distinct);
    log("Finding Occuptational Tasks Sub Items: " + currentRatingOccTasks.length);
    numberOfOccTasksToProcess = currentRatingOccTasks.length;
    for (var i=0;i<currentRatingOccTasks.length;i++) {
        EcAlignment.search(repo,"target:\"" + currentRatingOccTasks[i] + "\"",
            findCurrentRatingOccTaskSkillsAndAbilitiesSuccess,
            findCurrentRatingOccTaskSkillsAndAbilitiesFailure,
            {"size":10000}
        );
    }
}

function findCurrentRatingJobOccTasksSuccess(arrayOfAlignments) {
    log("Adding Occupational Tasks to Rating: " + arrayOfAlignments.length);
    if (arrayOfAlignments && arrayOfAlignments.length > 0) {
        for (var i=0;i<arrayOfAlignments.length;i++) {
            currentRatingRelationsToAdd.push(arrayOfAlignments[i].shortId());
            currentRatingOccTasks.push(arrayOfAlignments[i].source);
        }
    }
    numberOfJobsProcessed ++;
    if (numberOfJobsProcessed >= numberOfJobsToProcess) findAllCurrentRatingOccTaskSubItems();
}

function findCurrentRatingJobOccTasksFailure(err) {
    log("fincCurrentRatingJobOccTasksFailure: " + err);
    numberOfJobsProcessed ++;
    if (numberOfJobsProcessed >= numberOfJobsToProcess) findAllCurrentRatingOccTaskSubItems();
}

function findAllCurrentRatingJobsSubItems() {
    log("Finding Jobs Sub Items: " + currentRatingJobs.length);
    numberOfJobsToProcess = currentRatingJobs.length;
    for (var i=0;i<currentRatingJobs.length;i++) {
        EcAlignment.search(repo,"target:\"" + currentRatingJobs[i] + "\"",
           findCurrentRatingJobOccTasksSuccess,
           findCurrentRatingJobOccTasksFailure,
           {"size":10000}
        );
    }
}

function saveCurrentRating() {
    log("Saving rating (" + currentRatingIdx + "): " + currentRatingObj.shortId());
    addIdsToCurrentRatingCompetencies(currentRatingOccTasks);
    addIdsToCurrentRatingCompetencies(currentRatingSkillsAndAbilities);
    addIdsToCurrentRatingRelations(currentRatingRelationsToAdd);
    //console.log(currentRatingObj);
    repo.saveTo(currentRatingObj,
        function(p1) {
            currentRatingIdx++;
            insertRating();
        },
        function(p1) {
            currentRatingIdx++;
            insertRating();
        }
    );
}

function resetRatingDataStores() {
    numberOfJobsToProcess = 0;
    numberOfJobsProcessed = 0;
    numberOfOccTasksToProcess = 0;
    numberOfOccTasksProcessed = 0;
    currentRatingObj = {};
    currentRatingJobsContainerComp = {};
    currentRatingNecsContainerComp = {};
    currentRatingJobs = [];
    currentRatingNecs = [];
    currentRatingOccTasks = [];
    currentRatingSkillsAndAbilities = [];
    currentRatingRelationsToAdd = [];
}

function insertRating() {
    if (currentRatingIdx >= fileJson.length) {
        log("Completed generating ratings...");
    }
    else {
        resetRatingDataStores();
        var id = fileJson[currentRatingIdx]["externalId"];
        log("Generating rating (" + currentRatingIdx + "): " + id);
        var name = fileJson[currentRatingIdx]["name"];
        var dcTermType = fileJson[currentRatingIdx]["dcTermsType"];
        var code = null;
        if (fileJson[currentRatingIdx]["code"]) code = fileJson[currentRatingIdx]["code"];
        currentRatingObj = createFrameworkObject(id,name,null,dcTermType,code);
        if (fileJson[currentRatingIdx]["necs"]) currentRatingNecs = fileJson[currentRatingIdx]["necs"];
        if (fileJson[currentRatingIdx]["jobs"]) currentRatingJobs = fileJson[currentRatingIdx]["jobs"];
        buildAndPopulateRatingContainers(code,name);
        findAllCurrentRatingJobsSubItems();
    }
}

function insertRatings() {
    log("Inserting Ratings data...");
    log("Number of Ratings found: " + fileJson.length);
    //currentRatingIdx = 0;
    currentRatingIdx = 1;
    insertRating();
}

function insertData() {
    if (insertType === "skills") insertSkills();
    else if (insertType === "abilities") insertAbilities();
    else if (insertType === "occTasks") insertOccTasks();
    else if (insertType === "jobs") insertJobs();
    else if (insertType === "necs") insertNecs();
    else if (insertType === "ratings") insertRatings();
}

function insertFile() {
    clearLogArea();
    insertType = $("#insertType").val();
    log("Insert Type: " + insertType);
    var f = $("#dataFile").prop('files')[0];
    if (f) {
        log("Reading file...");
        var reader = new FileReader();
        reader.readAsText(f, "UTF-8");
        reader.onload = function (evt) {
            log("File read.");
            fileJson = JSON.parse(evt.target.result);
            console.log(fileJson);
            insertData();
        }
    }
    else log("No File Chosen!!!");
}

initRepo();


function testAddComp() {
    var c = createCompetencyObject(null,'Test Name','Test Desc','tomtype','TTT');
    console.log(c.shortId());
    console.log(c);
    repo.saveTo(c,function(p1) {
        console.log("Item saved...");
    },function(err) {
        console.log("Error: " + err);
    });
}