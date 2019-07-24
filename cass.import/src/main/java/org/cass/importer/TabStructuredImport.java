package org.cass.importer;

import com.eduworks.ec.crypto.EcCrypto;
import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.repository.EcRepository;
import org.stjs.javascript.Array;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

public class TabStructuredImport {

    /**
     * Method to create competencies (and relationships if the parameters are passed in)
     * based on a CSV file and references to which columns correspond to which pieces
     * of data.
     *
     * @param {Object}                        text
     *                                        Text to extract competencies from
     * @param {String}                        serverUrl
     *                                        URL Prefix for the created competencies (and relationships?)
     * @param {EcIdentity}                    owner
     *                                        EcIdentity that will own the created competencies (and relationships?)
     * @param {Callback2<Array<EcCompetency>, Array<EcAlignment>>} success
     *                                        Callback triggered after the competencies (and relationships?) have been created
     * @param {Callback1<Object>}             [failure]
     *                                        Callback triggered if an error during creating the competencies
     * @param {Callback1<Object>}             [incremental]
     *                                        Callback triggered incrementally during creation of competencies to indicate progress,
     *                                        returns an object indicating the number of competencies (and relationships?) created so far
     * @param {EcRepository}                  repo
     *                                        Repository to save any new data to, or to use to generate IDs.
     * @memberOf TabStructuredImport
     * @method importCompetencies
     * @static
     */
    public static void importCompetencies(String text, final String serverUrl, final EcIdentity owner,
                                          final Callback2<Array<EcCompetency>, Array<EcAlignment>> success, final Callback1<String> failure,
                                          final Callback1<Object> incremental, final EcRepository repo, boolean hashNameForId) {
        Array<String> lines = (Array<String>) (Object) text.split("\n");
        Array<EcCompetency> competencies = new Array<>();
        Array<EcAlignment> alignments = new Array<>();
        for (int i = 0;i < lines.$length();i++)
        parseLinesIntoHierarchy(lines, competencies, alignments, i, serverUrl, hashNameForId);
        success.$invoke(competencies,alignments);
    }

    private static void parseLinesIntoHierarchy(Array<String> lines, Array<EcCompetency> competencies, Array<EcAlignment> alignments, int index, String serverUrl, boolean hashNameForId) {
        //I can find a parent by looking for the first line above it with fewer tabs.
        int parentI = -1;
        for (int i = index - 1; i >= 0; i--) {
            if (tabs(lines.$get(i)) < tabs(lines.$get(index))) {
                parentI = i;
                break;
            }
        }
        //Reuse competencies if you can.
        EcCompetency c = null;
        for (int i = 0; i < competencies.$length(); i++) {
            if (competencies.$get(i).getName().trim() == lines.$get(index).trim()) {
                c = competencies.$get(i);
                break;
            }
        }
        if (c == null) {
            c = new EcCompetency();
            if (hashNameForId)
                c.assignId(serverUrl, EcCrypto.md5(lines.$get(index).trim()));
            else
                c.generateId(serverUrl);
            c.setName(lines.$get(index));
            competencies.push(c);
        }
        //Don't worry about simplifying the name yet. We'll do a post-pass to clean it up and extract descriptions and the like.
        if (parentI != -1) {
            EcCompetency parent = null;
            for (int i = 0; i < competencies.$length(); i++) {
                if (competencies.$get(i).getName().trim() == lines.$get(parentI).trim()) {
                    parent = competencies.$get(i);
                    break;
                }
            }
            if (parent != null) {
                EcAlignment a = new EcAlignment();
                a.generateId(serverUrl);
                a.relationType = EcAlignment.NARROWS;
                a.source = c.shortId();
                a.target = parent.shortId();
                alignments.push(a);
            }
        }
    }

    private static int tabs(String line) {
        int tabs = 0;
        //Count the number of tabs at the start of the line.
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '\t' || c == ' ')
                tabs++;
            else
                return tabs;
        }
        return tabs;
    }
}
