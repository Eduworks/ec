var fs = require('fs');

if (global.XMLHttpRequest === undefined)
    var XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;
else
    var XMLHttpRequest = global.XMLHttpRequest;

require("text-encoding");
if (global.forge === undefined)
    if (typeof __webpack_require__ === 'function')
        var forge = require("forge");
    else
        var forge = require("node-forge");
else
    var forge = global.forge;
var FormData = require('form-data');
var pemJwk = require('pem-jwk');
var window = {
    scriptPath: "./ec.crypto/src/test/resources/",
    crypto: null
};
var Worker = require("tiny-worker");

var document = {};
var view = {};
var localStorage = {};
//String.prototype.endsWith = function(suffix) {
//    return this.indexOf(suffix, this.length - suffix.length) !== -1;
//};
function isFunction(functionToCheck) {
    return functionToCheck && {}.toString.call(functionToCheck) === '[object Function]';
}

function load(lib) {
    if (fs.existsSync(lib)) {
        return fs.readFileSync(lib);
    } else if (fs.existsSync(module.filename.replace("index.js", "") + lib)) {
        return fs.readFileSync(module.filename.replace("index.js", "") + lib);
    } else if (fs.existsSync("./node_modules/cassproject/" + lib)) {
        return fs.readFileSync("./node_modules/cassproject/" + lib);
    } else if (fs.existsSync("/usr/lib/node_modules/" + lib)) {
        return fs.readFileSync("/usr/lib/node_modules/" + lib);
    }
}

var Assert = {
    assertTrue: function (val, val2) {
        if (val2 == null || val2 === undefined) {
            if (val == false) {
                console.log("PROBLEM: " + val + " == false");
                console.trace();
                process.exit(1);
            }
        } else if (val2 == false)
        {
            console.log("PROBLEM: " + val + " - " + val2 + " == false");
            console.trace();
            process.exit(1);
        }
    },
    assertFalse: function (val, val2) {
        if (val2 == null || val2 === undefined) {
            if (val == true) {
                console.log("PROBLEM: " + val + " == true");
                console.trace();
                process.exit(1);
            }
        } else if (val2 == true)
        {
            console.log("PROBLEM: " + val + " - " + val2 + " != true");
            console.trace();
            process.exit(1);
        }

    },
    assertEquals: function (val, val2, val3) {
        if (val2 == undefined && val3 == undefined)
            return;
        if (val3 != null && val3 !== undefined) {
            if (val2 != val3) {
                console.log("PROBLEM: " + val + " - " + val2 + " != " + val3);
                console.trace();
                process.exit(1);
            }
        } else if (val != val2) {
            console.log("PROBLEM: " + val + " != " + val2);
            console.trace();
            process.exit(1);
        }
    },
    assertSame: function (val, val2, val3) {
        if (val2 == undefined && val3 == undefined)
            return;
        if (val3 != null && val3 !== undefined) {
            if (val2 != val3) {
                console.log("PROBLEM: " + val + " - " + val2 + " != " + val3);
                console.trace();
                process.exit(1);
            }
        } else if (val != val2) {
            console.log("PROBLEM: " + val + " != " + val2);
            console.trace();
            process.exit(1);
        }
    },
    assertNotSame: function (val, val2, val3) {
        if (val2 == undefined && val3 == undefined)
            return;
        if (val3 != null && val3 !== undefined) {
            if (val2 == val3) {
                console.log("PROBLEM: " + val + " - " + val2 + " != " + val3);
                console.trace();
                process.exit(1);
            }
        } else if (val == val2) {
            console.log("PROBLEM: " + val + " != " + val2);
            console.trace();
            process.exit(1);
        }
    },
    assertFail: function(val){
        console.log("PROBLEM: " + val);
        console.trace();
        process.exit(1);
    },
    fail: function(val){
        console.log("PROBLEM: " + val);
        console.trace();
        process.exit(1);
    }
};

var failure = function(val){
    console.log("PROBLEM: " + val);
    console.trace();
    process.exit(1);
}

var esprima = require('esprima');
var results = [];
eval(load.call(this, "ec.base/src/main/resources/random.js") + "");
eval(load.call(this, "ec.base/src/main/resources/blobHelper.js") + "");
eval(load.call(this, "ec.base/target/classes/stjs.js") + "");
eval(load.call(this, "cass.rollup/src/test/resources/antlr4/RollupLexer.js") + "");
eval(load.call(this, "cass.rollup/src/test/resources/antlr4/RollupListener.js") + "");
eval(load.call(this, "cass.rollup/src/test/resources/antlr4/RollupParser.js") + "");
RollupLexer = require("./RollupLexer.js");
RollupParser = require("./RollupParser");
RollupListener = require("./RollupListener");
var evaldis = "";
var alldat = function (a) {
    evaldis = (load.call(this, a + "/target/classes/" + a + ".js") + "");
    evaldis += (load.call(this, a + "/target/generated-test-js/" + a + ".js") + "");
    results.push(esprima.parse(load.call(this, a + "/target/generated-test-js/" + a + ".js") + ""));
}
alldat.call(this, "ec.base");
eval(evaldis);
alldat.call(this, "ec.crypto");
eval(evaldis);
alldat.call(this, "ec.task");
eval(evaldis);
alldat.call(this, "org.json-ld");
eval(evaldis);
alldat.call(this, "org.cassproject.schema.general");
eval(evaldis);
alldat.call(this, "org.schema");
eval(evaldis);
alldat.call(this, "org.cassproject.schema.ebac");
eval(evaldis);
alldat.call(this, "org.credentialengine");
eval(evaldis);
alldat.call(this, "org.angles.schema.angles");
eval(evaldis);
alldat.call(this, "ebac.identity");
eval(evaldis);
alldat.call(this, "ebac.repository");
eval(evaldis);
alldat.call(this, "com.eduworks.schema");
eval(evaldis);
alldat.call(this, "org.cassproject.schema.cass");
eval(evaldis);
alldat.call(this, "org.w3.skos");
eval(evaldis);
alldat.call(this, "cass.competency");
eval(evaldis);
alldat.call(this, "cass.rollup");
eval(evaldis);
alldat.call(this, "cass.rollup.ctdl");
eval(evaldis);
alldat.call(this, "cass.import");
eval(evaldis);
alldat.call(this, "cass.adapter");
eval(evaldis);
alldat.call(this, "cfd.competency");
eval(evaldis);
alldat.call(this, "pebl.eXtension.schema");
eval(evaldis);
alldat.call(this, "asd.europe.org.s_series");
eval(evaldis);
var testSomething = function(j){
    console.log("!!!!!!!!!!!!!!!!!!!!!"+j+"!!!!!!!!!!!!!!!!!!!");
    if (results.length == j)
        process.exit(0);
    EcRemote.async = true;
    for (var i = 0; i < results[j].body.length; i++)
        if (results[j].body[i].declarations != null) {
            EcRepository.repos = [];
            var obj = eval("new " + results[j].body[i].declarations[0].id.name + "();");
            if (obj.setup != null)
                obj.setup();
            if (obj.begin != null)
                obj.begin();
            for (var k in obj) {
                if (!isFunction(obj[k])) continue;
                if (k == "setup") continue;
                if (k == "breakdown") continue;
                if (k == "deleteById") continue;
                if (k == "newAssertion") continue;
                if (k == "failure") continue;
                if (k == "newFalseAssertion") continue;
                if (k == "newCompetency") continue;
                if (k == "newRollupRule") continue;
                if (k == "newRelation") continue;
                if (k == "newAchieveAction") continue;
                if (k == "newCreativeRelation") continue;
                if (k == "getTestProcessor") continue;
                if (k == "performTest") continue;
                if (k == "newFramework") continue;
                if (k == "afterTest") continue;
                if (k == "begin") continue;
                if (k == "equals") continue;
                if (k == "getClass") continue;
                console.log("----------------" + results[j].body[i].declarations[0].id.name + "." + k + "---------------------");
                eval("obj." + k + "();");
            }
            //decls += "\nglobal." + results[j].body[i].declarations[0].id.name + " = " + results[j].body[i].declarations[0].id.name;
        }
    setTimeout(function(){testSomething(j+1)},1000);
}
testSomething(0);