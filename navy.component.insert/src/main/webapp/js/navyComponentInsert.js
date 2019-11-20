var TARGET_CASS_SERVER = "https://cass.asid.eduworks.com/api/";
var ADD_COMP_MODE = "addComponentsToRating";
var ADD_COMP_OCC_TASKS_MODE = "addComponentOccTasksToRating";
var REL_PREFIX = "https://cass.asid.eduworks.com/api/data/schema.cassproject.org.0.4.Relation/";

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

var functionalAreaMap;
var payGradeMap;
var workActivityMap;
var jobFamilyMap;
var dodOccupationMap;
var currentComponentMap;

var ratingComponentMap;

var occTaskRelationsList;
var occTasksRelationsToCreate;
var occTaskRelationsCreated;
var compList;
var compsToAdd;
var compsAdded;
var ratingsMap;
var ratingsKeys;
var ratingsKeyIdx;
var frameworkComponentMode;
var frameworkComponentContainerNamePrefix;
var frameworkComponentContainerDescPrefix;
var frameworkComponentContainerIdPrefix;
var currentRatingCompContainerComp;
var compHasOccTasks;

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

function createCompetencyContainerObject(idPrefix,ratingId,name,desc) {
    var c = new EcCompetency();
    c.assignId(repo.selectedServer,idPrefix + "---" + genPartialIdPiece(ratingId));
    c.setName(name);
    if (desc) c.setDescription(desc);
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

function genPartialIdPiece(compId) {
    if (compId.lastIndexOf("/") <= -1) return compId;
    return compId.substr(compId.lastIndexOf("/") + 1)
}

function generateRelationId(targetId, sourceId) {
    return genPartialIdPiece(sourceId) + "---" + genPartialIdPiece(targetId);
}

function insertRelations(targetId,sourceList,relType) {
    var relIdList = [];
    if (sourceList) {
        for (var i=0;i<sourceList.length;i++) {
            var a = new EcAlignment();
            a.relationType = relType;
            a.target = targetId;
            a.source = sourceList[i];
            //a.id = generateRelationId(targetId,sourceList[i]);
            a.assignId(repo.selectedServer, generateRelationId(targetId,sourceList[i]));
            //a.generateId(repo.selectedServer);
            relIdList.push(a.shortId());
            repo.saveTo(a,consoleLogSuccess,logError);
        }
    }
    return relIdList;
}

function generateRelations(targetId,sourceList,relType) {
    var relationList = [];
    if (sourceList) {
        for (var i=0;i<sourceList.length;i++) {
            var a = new EcAlignment();
            a.relationType = relType;
            a.target = targetId;
            a.source = sourceList[i];
            //a.id = generateRelationId(targetId,sourceList[i]);
            a.assignId(repo.selectedServer, generateRelationId(targetId,sourceList[i]));
            //a.generateId(repo.selectedServer);
            relationList.push(a);
        }
    }
    return relationList;
}

function getProbableRelationId(targetId, sourceId) {
    return REL_PREFIX + generateRelationId(targetId,sourceId);
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

function addRelationsToCurrentRatingRelations(relList) {
    if (relList && relList.length > 0) {
        for (var i=0;i<relList.length;i++) {
            currentRatingObj.addRelation(relList[i].shortId());
        }
    }
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
    currentRatingIdx = 0;
    insertRating();
}

// function buildOccTaskFrameworkSearchQuery(occTaskArray) {
//     var query = "(";
//     for (var i=0;i<occTaskArray.length;i++) {
//         if (i > 0) query += " OR ";
//         query += 'competency:"' + occTaskArray[i] + '"';
//     }
//     query += ")";
//     return query;
// }

function buildDataMap(componentMap) {
    log("Building data map...");
    for (var i=0;i<fileJson.length;i++) {
        var fileItem = fileJson[i];
        componentMap[fileItem["externalId"]] = fileItem;
    }
}

function initializeNewComponentTrackers(componentMap) {
    compsToAdd = Object.keys(componentMap).length;
    compsAdded = 0;
    compList = [];
    ratingComponentMap = {};
    ratingsMap = {};
}

function buildNewComponentData(componentMap) {
    var cmKeys = Object.keys(componentMap);
    for (var i=0;i<cmKeys.length;i++ ) {
        var cm = componentMap[cmKeys[i]];
        var id = cm["externalId"];
        var name = cm["name"];
        var dcTermType = cm["dcTermsType"];
        var code = null;
        if (cm["code"]) code = cm["code"];
        compList.push(createCompetencyObject(id,name,null,dcTermType,code));
    }
}

function handleSaveComponentOccTaskRelationsSuccess() {
    console.log("handleSaveComponentOccTaskRelationsSuccess");
    occTaskRelationsCreated++;
    saveComponentOccTaskRelations();
}

function handleSaveComponentOccTaskRelationsFailure(err) {
    console.log("handleSaveComponentOccTaskRelationsFailure: " + err);
    occTaskRelationsCreated++;
    saveComponentOccTaskRelations();
}

function saveComponentOccTaskRelations() {
    log("Current occTaskRelationsCreated: " + occTaskRelationsCreated);
    if (occTaskRelationsCreated >= occTasksRelationsToCreate) {
        log("All Occ Task relations created!");
    }
    else {
        repo.saveTo(occTaskRelationsList[occTaskRelationsCreated],handleSaveComponentOccTaskRelationsSuccess,handleSaveComponentOccTaskRelationsFailure);
    }
}

function addComponentOccTasksRelations() {
    clearLogArea();
    log("Generating component occ task relations...");
    occTaskRelationsList = [];
    var cmKeys = Object.keys(currentComponentMap);
    for (var i=0;i<cmKeys.length;i++ ) {
        var cmKey = cmKeys[i];
        log("Adding occ task relations for (" + i + "): " + cmKey);
        var comp = currentComponentMap[cmKey];
        var occTasks = comp["occupationalTasks"];
        var compOccTaskRelations = [];
        if (occTasks && occTasks.length > 0) {
            compOccTaskRelations = generateRelations(cmKey,occTasks,EcAlignment.NARROWS);
        }
        occTaskRelationsList = occTaskRelationsList.concat(compOccTaskRelations);
        log("Occ Tasks Relations for this component: " + compOccTaskRelations.length);
        log("Current Total Occ Tasks Relations: " + occTaskRelationsList.length);
    }
    occTasksRelationsToCreate = occTaskRelationsList.length;
    occTaskRelationsCreated = 0;
    clearLogArea();
    log("GRAND TOTAL OCC TASK RELATIONS: " + occTaskRelationsList.length);
    saveComponentOccTaskRelations();
}

function checkAllCompsSaved() {
    if (compsAdded >= compsToAdd) {
        log("All new components added!");
        if (compHasOccTasks) addComponentOccTasksRelations();
    }
}

function handleSaveCompSuccess() {
    log("Compenent saved: " + compsAdded);
    compsAdded++;
    checkAllCompsSaved();
}

function handleSaveCompFailure(err) {
    log("handleSaveCompFailure: " + err);
    compsAdded++;
    checkAllCompsSaved();
}

function saveCompList() {
    log("Saving component list:" + compList.length);
    for (var i=0;i<compList.length;i++) {
        repo.saveTo(compList[i],handleSaveCompSuccess,handleSaveCompFailure);
    }
}


function getStyledRatingCode(rating) {
    if (rating["ceasn:codedNotation"]) {
        return " (" + rating["ceasn:codedNotation"] + ")";
    }
    else return "";
}

function handleSaveRatingSuccess(str) {
    log("Rating saved!");
    console.log("Success saved rating...");
    ratingsKeyIdx++;
    addComponentsToRatings();
}

function handleSaveRatingFailure(err) {
    console.log("FAILED saved rating:" + err);
    ratingsKeyIdx++;
    addComponentsToRatings();
}

function handleMultiPutRatingCompContRelSuccess(str) {
    log("Rating component container relations saved!");
    console.log("Success multiput rating component container relations...");
    repo.saveTo(currentRatingObj,handleSaveRatingSuccess,handleSaveRatingFailure);
}

function handleMultiPutRatingCompContRelFailure(err) {
    console.log("FAILED multiput rating component container relations:" + err);
    ratingsKeyIdx++;
    addComponentsToRatings();
}

function addComponentsToRatings() {
    if (ratingsKeyIdx >= ratingsKeys.length) {
        log ("All components added to ratings...");
    }
    else {
        log("Building rating component container: " + ratingsKeyIdx);
        var ratingKey = ratingsKeys[ratingsKeyIdx];
        currentRatingObj = ratingsMap[ratingKey];
        log("currentRatingObj: " + currentRatingObj.getName());
        currentRatingCompContainerComp = createCompetencyContainerObject(frameworkComponentContainerIdPrefix,currentRatingObj.shortId(),
            frameworkComponentContainerNamePrefix + getStyledRatingCode(currentRatingObj),
             frameworkComponentContainerDescPrefix + ' ' + currentRatingObj.getName());
        repo.saveTo(currentRatingCompContainerComp, consoleLogSuccess, logError);
        currentRatingObj.addCompetency(currentRatingCompContainerComp.shortId());
        var ratingComps = ratingComponentMap[ratingKey];
        log("Adding components to rating: " + ratingComps.length);
        addIdsToCurrentRatingCompetencies(ratingComps);
        var ratingCompContRels = generateRelations(currentRatingCompContainerComp.shortId(),ratingComps,EcAlignment.NARROWS);
        addRelationsToCurrentRatingRelations(ratingCompContRels);
        log("Saving rating component container relations...");
        repo.multiput(ratingCompContRels,handleMultiPutRatingCompContRelSuccess,handleMultiPutRatingCompContRelFailure);
    }
}

function addComponentOccTaskRelationsToCurrentRatingObj(compId,compOccTasks) {
    for (var i=0;i<compOccTasks.length;i++) {
        var occTask = compOccTasks[i];
        if (currentRatingObj.competency.includes(occTask)) {
            log("Rating contains occ task: " + occTask);
            var relId = getProbableRelationId(compId,occTask);
            // console.log("RelId to add: " + relId);
            currentRatingObj.addRelation(relId);
        }
        // else {
        //     console.log("NO MATCH FOR: " + occTask);
        //     console.log(">> currentRatingObj: " + currentRatingObj.shortId());
        // }
    }
}

function addComponentOccTaskRelationsToRatings() {
    if (ratingsKeyIdx >= ratingsKeys.length) {
        log ("All components occ task relations added to ratings...");
    }
    else {
        log("Adding component occ tasks relations to rating: " + ratingsKeyIdx);
        console.log("Adding component occ tasks relations to rating: " + ratingsKeyIdx);
        var ratingKey = ratingsKeys[ratingsKeyIdx];
        currentRatingObj = ratingsMap[ratingKey];
        log("currentRatingObj: " + currentRatingObj.getName());
        var ratingComps = ratingComponentMap[ratingKey];
        for (var i=0;i<ratingComps.length;i++) {
            log("Searching for matching occ tasks for comp: " + ratingComps[i]);
            var compOccTasks = currentComponentMap[ratingComps[i]]["occupationalTasks"];
            addComponentOccTaskRelationsToCurrentRatingObj(ratingComps[i],compOccTasks);
        }
        repo.saveTo(currentRatingObj,
            function(p1) {
                ratingsKeyIdx++;
                addComponentOccTaskRelationsToRatings();
            },
            function(p1) {
                ratingsKeyIdx++;
                addComponentOccTaskRelationsToRatings();
            }
        );
    }
}

function addComponentToRatingComponentMap(fwId,compId) {
    if (!ratingComponentMap[fwId]) {
        ratingComponentMap[fwId] = [];
    }
    if (!ratingComponentMap[fwId].includes(compId)) {
        ratingComponentMap[fwId].push(compId);
    }
}

function ratingHasAnyOccTask(rating,occTaskList) {
    if (rating.competency && rating.competency.length > 0) {
        for (var i=0;i<occTaskList.length;i++) {
            if (rating.competency.includes(occTaskList[i])) return true;
        }
    }
    return false;
}

function handleBuildRatingListSuccessIndirect(fwa) {
    log("Matching ratings/frameworks to components via occ tasks...");
    ratingComponentMap = {};
    ratingsMap = {};
    console.log("NUMBER OF FRAMEWORKS: " + fwa.length);
    for (var i=0;i<fwa.length;i++) {
        if (!ratingsMap[fwa[i].shortId()]) ratingsMap[fwa[i].shortId()] = fwa[i];
        log ("Checking rating/framework: " + fwa[i].getName());
        var compKeys = Object.keys(currentComponentMap);
        for (var j=0;j<compKeys.length;j++) {
            var compKey = compKeys[j];
            var compOccTasks = currentComponentMap[compKey]["occupationalTasks"];
            if (ratingHasAnyOccTask(fwa[i],compOccTasks)) {
                log("Adding component to rating: " + compKey);
                addComponentToRatingComponentMap(fwa[i].shortId(),compKey);
            }
        }
    }
    console.log("ratingComponentMap");
    console.log(ratingComponentMap);
    if (frameworkComponentMode == ADD_COMP_MODE) {
        ratingsKeys = Object.keys(ratingComponentMap);
        ratingsKeyIdx = 0;
        addComponentsToRatings();
    }
    else if (frameworkComponentMode == ADD_COMP_OCC_TASKS_MODE) {
        ratingsKeys = Object.keys(ratingComponentMap);
        ratingsKeyIdx = 0;
        addComponentOccTaskRelationsToRatings();
    }
}

function handleBuildRatingListSuccessDirect(fwa) {
    log("Matching ratings/frameworks to components directly...");
    ratingComponentMap = {};
    ratingsMap = {};
    console.log("NUMBER OF FRAMEWORKS: " + fwa.length);
    for (var i=0;i<fwa.length;i++) {
        if (!ratingsMap[fwa[i].shortId()]) ratingsMap[fwa[i].shortId()] = fwa[i];
        log ("Checking rating/framework: " + fwa[i].getName());
        var compKeys = Object.keys(currentComponentMap);
        for (var j=0;j<compKeys.length;j++) {
            var compKey = compKeys[j];
            var compRatings = currentComponentMap[compKey]["ratings"];
            if (compRatings.includes(fwa[i].shortId())) {
                log("Adding component to rating: " + compKey);
                addComponentToRatingComponentMap(fwa[i].shortId(),compKey);
            }
        }
    }
    console.log("ratingComponentMap");
    console.log(ratingComponentMap);
    ratingsKeys = Object.keys(ratingComponentMap);
    ratingsKeyIdx = 0;
    addComponentsToRatings();
}

function handleBuildRatingListFailure(err) {
    log("Could not build rating/framework list: " + err);
}

function findAndHookComponentRelatedRatingsIndirect() {
    log("Building rating/framework list...");
    EcFramework.search(repo,"*",handleBuildRatingListSuccessIndirect,handleBuildRatingListFailure,{size:10000});
}

function findAndHookComponentRelatedRatingsDirect() {
    log("Building rating/framework list...");
    EcFramework.search(repo,"*",handleBuildRatingListSuccessDirect,handleBuildRatingListFailure,{size:10000});
}

/**
 * All of these create* functions are redundant and could be moved to a single function.
 * Was trying to do something with them that ended up being unnecessary.
 */

function createNewFunctionalAreas() {
    log("Creating new functional areas...");
    initializeNewComponentTrackers(functionalAreaMap);
    log("Building functional area competency objects...");
    buildNewComponentData(functionalAreaMap);
    console.log("createNewFunctionalAreas - compList: ");
    console.log(compList);
    currentComponentMap = functionalAreaMap;
    saveCompList();
}

function createNewPayGrades() {
    log("Creating new pay grades...");
    initializeNewComponentTrackers(payGradeMap);
    log("Building pay grade competency objects...");
    buildNewComponentData(payGradeMap);
    console.log("createNewPayGrades - compList: ");
    console.log(compList);
    currentComponentMap = payGradeMap;
    saveCompList();
}

function createNewWorkActivities() {
    log("Creating new work activities...");
    initializeNewComponentTrackers(workActivityMap);
    log("Building work activity competency objects...");
    buildNewComponentData(workActivityMap);
    console.log("createNewWorkActivities - compList: ");
    console.log(compList);
    currentComponentMap = workActivityMap;
    saveCompList();
}

function createNewJobFamilies() {
    log("Creating new job families...");
    initializeNewComponentTrackers(jobFamilyMap);
    log("Building job family competency objects...");
    buildNewComponentData(jobFamilyMap);
    console.log("createNewJobFamilies - compList: ");
    console.log(compList);
    currentComponentMap = jobFamilyMap;
    saveCompList();
}

function createNewDodOccupations() {
    log("Creating new DOD Occupations...");
    initializeNewComponentTrackers(dodOccupationMap);
    log("Building DOD Occupation competency objects...");
    buildNewComponentData(dodOccupationMap);
    console.log("createNewDodOccupations - compList: ");
    console.log(compList);
    currentComponentMap = dodOccupationMap;
    saveCompList();
}

function insertFunctionalAreas1() {
    log("Inserting Functional Area data(1)...");
    log("Number of Functional Areas found: " + fileJson.length);
    functionalAreaMap = {};
    compHasOccTasks = true;
    buildDataMap(functionalAreaMap);
    createNewFunctionalAreas();
}

function insertFunctionalAreas2() {
    log("Inserting Functional Area data(2)...");
    log("Number of Functional Areas found: " + fileJson.length);
    functionalAreaMap = {};
    buildDataMap(functionalAreaMap);
    currentComponentMap = functionalAreaMap;
    frameworkComponentMode = ADD_COMP_MODE;
    frameworkComponentContainerNamePrefix = "Functional Areas";
    frameworkComponentContainerDescPrefix = "Functional Areas for";
    frameworkComponentContainerIdPrefix = "FA-Cont";
    findAndHookComponentRelatedRatingsIndirect();
}

function insertFunctionalAreas3() {
    log("Inserting Functional Area data(3)...");
    log("Number of Functional Areas found: " + fileJson.length);
    functionalAreaMap = {};
    buildDataMap(functionalAreaMap);
    currentComponentMap = functionalAreaMap;
    frameworkComponentMode = ADD_COMP_OCC_TASKS_MODE;
    findAndHookComponentRelatedRatingsIndirect();
}

function insertPayGrades1() {
    log("Inserting Pay Grade data(1)...");
    log("Number of Pay Grades found: " + fileJson.length);
    payGradeMap = {};
    compHasOccTasks = true;
    ratingComponentMap = {};
    buildDataMap(payGradeMap);
    createNewPayGrades();
}

function insertPayGrades2() {
    log("Inserting Pay Grade data(2)...");
    log("Number of Pay Grades found: " + fileJson.length);
    payGradeMap = {};
    buildDataMap(payGradeMap);
    currentComponentMap = payGradeMap;
    frameworkComponentMode = ADD_COMP_MODE;
    frameworkComponentContainerNamePrefix = "Pay Grades";
    frameworkComponentContainerDescPrefix = "Pay Grades for";
    frameworkComponentContainerIdPrefix = "PG-Cont";
    findAndHookComponentRelatedRatingsIndirect();
}

function insertPayGrades3() {
    log("Inserting Pay Grade data(3)...");
    log("Number of Pay Grades found: " + fileJson.length);
    payGradeMap = {};
    buildDataMap(payGradeMap);
    currentComponentMap = payGradeMap;
    frameworkComponentMode = ADD_COMP_OCC_TASKS_MODE;
    findAndHookComponentRelatedRatingsIndirect();
}

function insertWorkActivities1() {
    log("Inserting Work Activity data(1)...");
    log("Number of Work Activities found: " + fileJson.length);
    workActivityMap = {};
    compHasOccTasks = true;
    ratingComponentMap = {};
    buildDataMap(workActivityMap);
    createNewWorkActivities();
}

function insertWorkActivities2() {
    log("Inserting Work Activity data(2)...");
    log("Number of Work Activities found: " + fileJson.length);
    workActivityMap = {};
    buildDataMap(workActivityMap);
    currentComponentMap = workActivityMap;
    frameworkComponentMode = ADD_COMP_MODE;
    frameworkComponentContainerNamePrefix = "Work Activities";
    frameworkComponentContainerDescPrefix = "Work Activities for";
    frameworkComponentContainerIdPrefix = "WA-Cont";
    findAndHookComponentRelatedRatingsIndirect();
}

function insertWorkActivities3() {
    log("Inserting Work Activity data(3)...");
    log("Number of Work Activities found: " + fileJson.length);
    workActivityMap = {};
    buildDataMap(workActivityMap);
    currentComponentMap = workActivityMap;
    frameworkComponentMode = ADD_COMP_OCC_TASKS_MODE;
    findAndHookComponentRelatedRatingsIndirect();
}

function insertWorkActivities4() {
    log("Inserting Work Activity data(4)...");
    log("Number of Work Activities found: " + fileJson.length);
    // workActivityMap = {};
    // ratingComponentMap = {};
    // buildDataMap(workActivityMap);
    log("TODO FINISH insertWorkActivities4");
}

function insertWorkActivities5() {
    log("Inserting Work Activity data(5)...");
    log("Number of Work Activities found: " + fileJson.length);
    // workActivityMap = {};
    // ratingComponentMap = {};
    // buildDataMap(workActivityMap);
    log("TODO FINISH insertWorkActivities5");
}

function insertJobFamilies1() {
    log("Inserting Job Family data(1)...");
    log("Number of Job Families found: " + fileJson.length);
    jobFamilyMap = {};
    compHasOccTasks = false;;
    buildDataMap(jobFamilyMap);
    createNewJobFamilies();
}

function insertJobFamilies2() {
    log("Inserting Job Family data(2)...");
    log("Number of Job Families found: " + fileJson.length);
    jobFamilyMap = {};
    buildDataMap(jobFamilyMap);
    currentComponentMap = jobFamilyMap;
    frameworkComponentContainerNamePrefix = "Job Families";
    frameworkComponentContainerDescPrefix = "Job Families for";
    frameworkComponentContainerIdPrefix = "JF-Cont";
    findAndHookComponentRelatedRatingsDirect();
}

function insertDodOccupations1() {
    log("Inserting DOD Occupation data(1)...");
    log("Number of DOD Occupations found: " + fileJson.length);
    dodOccupationMap = {};
    compHasOccTasks = false;;
    buildDataMap(dodOccupationMap);
    createNewDodOccupations();
}

function insertDodOccupations2() {
    log("Inserting DOD Occupation data(2)...");
    log("Number of DOD Occupations found: " + fileJson.length);
    dodOccupationMap = {};
    buildDataMap(dodOccupationMap);
    currentComponentMap = dodOccupationMap;
    frameworkComponentContainerNamePrefix = "DOD Occupations";
    frameworkComponentContainerDescPrefix = "DOD Occupations for";
    frameworkComponentContainerIdPrefix = "DO-Cont";
    findAndHookComponentRelatedRatingsDirect();
}

function insertData() {
    if (insertType === "skills") insertSkills();
    else if (insertType === "abilities") insertAbilities();
    else if (insertType === "occTasks") insertOccTasks();
    else if (insertType === "jobs") insertJobs();
    else if (insertType === "necs") insertNecs();
    else if (insertType === "ratings") insertRatings();
    //second data set
    else if (insertType === "functionalAreas1") insertFunctionalAreas1();
    else if (insertType === "functionalAreas2") insertFunctionalAreas2();
    else if (insertType === "functionalAreas3") insertFunctionalAreas3();
    else if (insertType === "payGrades1") insertPayGrades1();
    else if (insertType === "payGrades2") insertPayGrades2();
    else if (insertType === "payGrades3") insertPayGrades3();
    else if (insertType === "workActivities1") insertWorkActivities1();
    else if (insertType === "workActivities2") insertWorkActivities2();
    else if (insertType === "workActivities3") insertWorkActivities3();
    else if (insertType === "workActivities4") insertWorkActivities4();
    else if (insertType === "workActivities5") insertWorkActivities5();
    else if (insertType === "jobFamilies1") insertJobFamilies1();
    else if (insertType === "jobFamilies2") insertJobFamilies2();
    else if (insertType === "dodOccupations1") insertDodOccupations1();
    else if (insertType === "dodOccupations2") insertDodOccupations2();
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

function fixOccTaskType() {
    log("Finding type:OccupationalTask....");
    EcCompetency.search(repo,"dcterms\\:type:OccupationalTask",
        function(aoa) {
            var cnt = 0;
            for (var i=0;i<aoa.length;i++) {
                if (aoa[i]['dcterms:type'] === 'OccupationalTask') {
                    var c = aoa[i];
                    log("Fixing type: " + c.shortId());
                    c["dcterms:type"]="Occupational Task";
                    repo.saveTo(c,consoleLogSuccess,logError);
                    cnt ++;
                }
            }
            console.log("Record Count: " + cnt);
        },
        function(msg) {
            console.log('FAILURE: ' + msg);
        },
        {"size":2000}
    );
}


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



var alignmentList = [];
var alignmentsDeleted = 0;
var alignmentsToDelete = 0;

function deleteAlignments() {
    if (alignmentsDeleted >= alignmentsToDelete) {
        console.log("Complete!");
    }
    else {
        repo.deleteRegistered(alignmentList[alignmentsDeleted],
            function(succ) {
                console.log("Delete Success: " + alignmentsDeleted);
                alignmentsDeleted++;
                deleteAlignments();
            },
            function(err) {
                console.log("Delete failed: " + alignmentsDeleted);
                alignmentsDeleted++;
                deleteAlignments();
            }
        );
    }
}

// function buildAlignmentListAndDelete() {
//     EcAlignment.search(repo,'source:"https://credentialengineregistry.org/navy/resources"',
//         function(aoa) {
//             var cnt = 0;
//             console.log('SUCCESS:!!!');
//             for (var i=0;i<aoa.length;i++) {
//                 if (aoa[i]["source"].startsWith("https://credentialengineregistry.org/navy/resources")) {
//                     alignmentList.push(aoa[i]);
//                     cnt ++;
//                 }
//             }
//             console.log("Record Count: " + cnt);
//             alignmentsDeleted = 0;
//             alignmentsToDelete = alignmentList.length;
//             deleteAlignments();
//         },
//         function(msg) {
//             console.log('FAILURE: ' + msg);
//         },
//         {"size":10000}
//     );
// }

// function buildAlignmentListAndDelete() {
//     EcFramework.search(repo,"@id:\"https://credentialengineregistry.org\"",
//         function(aoa) {
//             var cnt = 0;
//             console.log('SUCCESS:!!!');
//             for (var i=0;i<aoa.length;i++) {
//                 if (aoa[i].shortId().startsWith("https://credentialengineregistry.org")) {
//                     alignmentList.push(aoa[i]);
//                     cnt ++;
//                 }
//             }
//             console.log("Record Count: " + cnt);
//             alignmentsDeleted = 0;
//             alignmentsToDelete = alignmentList.length;
//             deleteAlignments();
//         },
//         function(msg) {
//             console.log('FAILURE: ' + msg);
//         },
//         {"size":100}
//     );
// }