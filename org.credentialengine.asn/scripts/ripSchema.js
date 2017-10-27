//Generates code from RDFa

var fs = require('fs');

require("node-jquery-xhr");

$.ajax({
    url: "http://credreg.net/ctdlasn/schema/encoding/json",
    success: function (object) {
        var graph = object["@graph"];
        for (var i = 0; i < graph.length; i++) {
            var node = graph[i];
            var type = node["@type"];
            if (type == "rdf:Class") {
                if (node["@id"] == "schema:DataType") continue;
                if (node["@id"] == "schema:Number") continue;
                if (node["@id"] == "schema:Integer") continue;
                if (node["@id"] == "schema:Float") continue;
                if (node["@id"] == "schema:URL") continue;
                fs.writeFile("src/main/java/org/credentialengine/" + node["@id"].split(":")[1] + ".java", codeGenerate(graph, node));
            }
        }
    }
});

function codeGenerate(graph, node) {
    var classId = node["@id"];
    var className = classId.split(":")[1];
    //console.log(node);
    var text = "";
    text += "package org.credentialengine;\n\n" +
        "import org.stjs.javascript.Date;\n" +
        "import org.cassproject.schema.general.EcRemoteLinkedData;\n\n";
    text += "/**\n";
    text += " * " + classId.replace("ceterms:", "credentialengine.org/") + "\n";
    text += " * " + node["rdfs:comment"]["en-US"] + "\n";
    if (node["dct:description"] != null)
    text += " * " + node["dct:description"]["en-US"] + "\n";
    text += " * @author credentialengine.org\n";
    text += " * @class " + className + "\n";
    text += " * @module org.credentialengine\n";

    if (node["rdfs:subClassOf"] != null)
        if (node["rdfs:subClassOf"].toString().indexOf("]") != -1)
            node["rdfs:subClassOf"] = node["rdfs:subClassOf"][0];
    if (node["rdfs:subClassOf"] != null)
        text += " * @extends " + node["rdfs:subClassOf"][0].split(":")[1] + "\n";
    text += " */\n";
    text += "public class " + className;
    if (node["rdfs:subClassOf"] != null)
        text += " extends " + (node["rdfs:subClassOf"][0].split(":")[0] == "schema" ? "org.schema.":"")+node["rdfs:subClassOf"][0].split(":")[1] + "\n";
    else
        text += " extends EcRemoteLinkedData\n";
    text += "{\n";
    text += "\t/**\n";
    text += "\t * Constructor, automatically sets @context and @type.\n";
    text += "\t * @constructor\n";
    text += "\t */\n";
    text += "\tpublic " + className + "()\n";
    text += "\t{\n";
    if (node["rdfs:subClassOf"] != null)
    {
        text += "\t\tcontext=\"http://schema.eduworks.com/simpleCtdl\";\n";
        text += "\t\ttype=\"" + className + "\";\n";
    }
    else
    {
        text += "\t\tsuper(\"http://schema.eduworks.com/simpleCtdl\"";
        text += ",\"" + className + "\");\n";
    }
    text += "\t}\n\n";

    for (var i = 0; i < graph.length; i++) {
        var gn = graph[i];
        var gi = gn["@id"];
        var gt = gn["@type"];
        var gd = gn["rdfs:domainIncludes"];
        if (gt != "rdf:Property")
            continue;
    //    console.log(gn);
        if (gd == null)
            continue;
    //    console.log(gd);
        if (gd.toString().indexOf(",") == -1) {
            if (gd != classId)
                continue;
        } else {
            var ok = false;
            for (var j = 0; j < gd.length; j++) {
                if (gd[j] == classId)
                    ok = true;
            }
            if (!ok) continue;
        }
        text += "\t/**\n";
        text += "\t * " + gi.replace("ceterms:", "http://purl.org/ctdl/terms/") + "\n";
        text += "\t * " + gn["rdfs:comment"]["en-US"] + "\n";
    if (gn["dct:description"] != null)
        text += "\t * " + gn["dct:description"]["en-US"] + "\n";
        text += "\t * @property " + gn["@id"].split(":")[1] + "\n";
        text += "\t * @type ";
        var gr = gn["rdfs:rangeIncludes"];
	if (gr != null)
	{
        console.log(JSON.stringify(gr));
	if (gr.length === undefined) {
            text += gr.split(":")[1] + "\n";
        } else {
            for (var j = 0; j < gr.length; j++) {
                if (j > 0)
                    text += " | ";
                text += gr[j].split(":")[1];
            }
            text += "\n";
        }
        text += "\t */\n";
        if (gr.length == 1) {
            text += "\tpublic ";
            text += (gr[0].split(":")[0] == "schema" ? "org.schema.":"")+sub(gr[0].split(":")[1]) + " " + gn["@id"].split(":")[1] + ";\n\n";
        } else {
            text += "\tpublic Object " + gn["@id"].split(":")[1] + ";\n\n";
        }
	}
    }
    text += "}";
    return text;
}

function sub(s) {
    if (s == "Text")
        return "String";
    if (s == "string")
        return "String";
    if (s == "langString")
        return "String";
    if (s == "Number")
        return "Double";
    if (s == "Image")
        return "ImageObject";
    if (s == "URL")
        return "String";
    if (s == "anyURI")
        return "String";
    if (s == "dateTime")
        return "String";
    if (s == "Literal")
        return "String";
    if (s == "Date")
        return "String";
    if (s == "date")
        return "String";
    if (s == "language")
        return "String";
    if (s == "float")
        return "Float";
    if (s == "Time")
        return "String";
    if (s == "duration")
        return "String";
    return s;
}
