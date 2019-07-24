//Generates code from RDFa

var fs = require('fs');

require("node-jquery-xhr");

$.ajax({
    url: "http://rdf-translator.appspot.com/convert/detect/json-ld/pygmentize/http%3A%2F%2Fwww.w3.org%2FTR%2Fskos-reference%2Fskos.rdf",
    success: function (object) {
        var graph = object["@graph"];
        for (var i = 0; i < graph.length; i++) {
            var node = graph[i];
            var type = node["@type"];
            if (JSON.stringify(type).indexOf("Class") != -1) {
                if (node["@id"] == "schema:DataType") continue;
                if (node["@id"] == "schema:Number") continue;
                if (node["@id"] == "schema:Integer") continue;
                if (node["@id"] == "schema:Float") continue;
                if (node["@id"] == "schema:URL") continue;
                fs.writeFile("src/main/java/org/w3/skos/" + node["@id"].split(":")[1] + ".java", codeGenerate(graph, node));
            }
        }
    }
});

function codeGenerate(graph, node) {
    var classId = node["@id"];
    var className = classId.split(":")[1];
    //console.log(node);
    var text = "";
    text += "package org.w3.skos;\n\n" +
        "import org.stjs.javascript.Date;\n" +
        "import org.cassproject.schema.general.EcRemoteLinkedData;\n\n";
    text += "/**\n";
    text += " * " + classId.replace("skos:", "www.w3.org/2004/02/skos/core/") + "\n";
    if (node["rdfs:comment"] != null)
    text += " * " + node["rdfs:comment"] + "\n";
    if (node["skos:definition"] != null)
    text += " * " + node["skos:definition"]["@value"] + "\n";
    if (node["skos:scopeNote"] != null)
    text += " * " + node["skos:scopeNote"]["@value"] + "\n";
    text += " * @author w3.org\n";
    text += " * @class " + className + "\n";
    text += " * @module org.w3.skos\n";

    if (node["rdfs:subClassOf"] != null)
        if (node["rdfs:subClassOf"].toString().indexOf(",") != -1)
            node["rdfs:subClassOf"] = node["rdfs:subClassOf"][0];
    if (node["rdfs:subClassOf"] != null)
        text += " * @extends " + node["rdfs:subClassOf"]["@id"].split(":")[1] + "\n";
    text += " */\n";
    text += "public class " + className;
    if (node["rdfs:subClassOf"] != null)
        text += " extends " + node["rdfs:subClassOf"]["@id"].split(":")[1] + "\n";
    else
        text += " extends EcRemoteLinkedData\n";
    text += "{\n";
    text += "\t/**\n";
    text += "\t * Constructor, automatically sets @context and @type.\n";
    text += "\t * @constructor\n";
    text += "\t */\n";
    if (node["rdfs:subClassOf"] != null)
    {
		text += "\tpublic " + className + "()\n";
		text += "\t{\n";
		text += "\t\tcontext=\"https://schema.cassproject.org/0.4/skos/\";\n";
		text += "\t\ttype=\"" + className + "\";\n";
		text += "\t}\n\n";
    }else{
		text += "\tpublic " + className + "()\n";
		text += "\t{\n";
		text += "\t\tsuper(\"https://schema.cassproject.org/0.4/skos/\",\"" + className + "\");\n";
		text += "\t}\n\n";
	}

    for (var i = 0; i < graph.length; i++) {
        var gn = graph[i];
        var gi = gn["@id"];
        var gt = gn["@type"];
        var gd = gn["rdfs:domain"];
        if (JSON.stringify(gt).indexOf("rdf:Property") == -1)
            continue;
        //console.log(gn);
        if (gd == null)
            continue;
        //console.log(gd);
        if (gd.toString().indexOf(",") == -1) {
            if (gd["@id"] != classId)
                continue;
        } else {
            var ok = false;
            for (var j = 0; j < gd.length; j++) {
                if (gd[j]["@id"] == classId)
                    ok = true;
            }
            if (!ok) continue;
        }
        text += "\t/**\n";
        text += "\t * " + gi.replace("skos:", "www.w3.org/2004/02/skos/core/") + "\n";
        text += "\t * " + gn["skos:definition"]["@value"] + "\n";
        text += "\t * @property " + gi.replace("skos:","") + "\n";
        text += "\t * @type ";
        var gr = gn["rdfs:range"];
        //console.log(gr.toString());
        if (gr.toString().indexOf(",") == -1) {
            text += gr["@id"].split(":")[1] + "\n";
        } else {
            for (var j = 0; j < gr.length; j++) {
                if (j > 0)
                    text += " | ";
                text += gr[j]["@id"].split(":");
            }
            text += "\n";
        }
        text += "\t */\n";
        if (gr.toString().indexOf(",") == -1) {
            text += "\tpublic ";
            text += sub(gr["@id"].split(":")[1]) + " " + gi.replace("skos:","") + ";\n\n";
        } else {
            text += "\tpublic Object " + gi.replace("skos:","") + ";\n\n";
        }
    }
    text += "}";
    return text;
}

function sub(s) {
    if (s == "Text")
        return "String";
    if (s == "Number")
        return "Double";
    if (s == "URL")
        return "String";
    if (s == "DateTime")
        return "String";
    if (s == "Date")
        return "String";
    if (s == "Time")
        return "String";
    return s;
}
