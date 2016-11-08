//Generates code from RDFa

var fs = require('fs');

require("node-jquery-xhr");

$.ajax({
    url: "https://www.w3.org/2012/pyRdfa/extract?uri=http%3A%2F%2Fschema.org%2Fdocs%2Fschema_org_rdfa.html&format=json&rdfagraph=output&vocab_expansion=false&rdfa_lite=false&embedded_rdf=true&space_preserve=true&vocab_cache=true&vocab_cache_report=false&vocab_cache_refresh=false",
    success: function (object) {
        var graph = object["@graph"];
        for (var i = 0; i < graph.length; i++) {
            var node = graph[i];
            var type = node["@type"];
            if (type == "rdfs:Class") {
                if (node["@id"] == "schema:DataType") continue;
                if (node["@id"] == "schema:Number") continue;
                if (node["@id"] == "schema:Integer") continue;
                if (node["@id"] == "schema:Float") continue;
                if (node["@id"] == "schema:URL") continue;
                fs.writeFile("src/main/java/org/schema/" + node["@id"].split(":")[1] + ".java", codeGenerate(graph, node));
            }
        }
    }
});

function codeGenerate(graph, node) {
    var classId = node["@id"];
    var className = classId.split(":")[1];
    //console.log(node);
    var text = "";
    text += "package org.schema;\n\n" +
        "import org.stjs.javascript.Date;\n" +
        "import org.cassproject.schema.general.EcRemoteLinkedData;\n\n";
    text += "/**\n";
    text += " * " + classId.replace("schema:", "Schema.org/") + "\n";
    text += " * " + node["rdfs:comment"] + "\n";
    text += " * @author schema.org\n";
    text += " * @class " + className + "\n";
    text += " * @module org.schema\n";

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
    text += "\tpublic " + className + "()\n";
    text += "\t{\n";
    text += "\t\tcontext=\"http://schema.org/\";\n";
    text += "\t\ttype=\"" + className + "\";\n";
    text += "\t}\n\n";

    for (var i = 0; i < graph.length; i++) {
        var gn = graph[i];
        var gi = gn["@id"];
        var gt = gn["@type"];
        var gd = gn["schema:domainIncludes"];
        if (gt != "rdf:Property")
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
        text += "\t * " + gi.replace("schema:", "Schema.org/") + "\n";
        text += "\t * " + gn["rdfs:comment"] + "\n";
        text += "\t * @property " + gn["rdfs:label"] + "\n";
        text += "\t * @type ";
        var gr = gn["schema:rangeIncludes"];
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
            text += sub(gr["@id"].split(":")[1]) + " " + gn["rdfs:label"] + ";\n\n";
        } else {
            text += "\tpublic Object " + gn["rdfs:label"] + ";\n\n";
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
