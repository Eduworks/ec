package cass.rollup.coprocessor.ims;

import cass.rollup.InquiryPacket;
import cass.rollup.coprocessor.AssertionCoprocessor;
import com.eduworks.ec.array.EcAsyncHelper;
import forge.sha256;
import org.cass.profile.EcAssertion;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Date;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

public class OpenBadgeCoprocessor extends AssertionCoprocessor {

    public String email = null;
    public Double confidenceOfBadges = 1.0;

    @Override
    public void collectAssertions(final InquiryPacket ip, final Array<String> listOfCompetencies, final Callback1<Array<EcAssertion>> success) {
        if (listOfCompetencies.$length() == 0) {
            super.collectAssertions(ip, listOfCompetencies, success);
            return;
        }
        final Array<EcAssertion> assertions = new Array<>();
        final OpenBadgeCoprocessor me = this;
        EcAsyncHelper<EcRepository> eah = new EcAsyncHelper();
        eah.each(me.assertionProcessor.repositories, new Callback2<EcRepository, Callback0>() {
            @Override
            public void $invoke(final EcRepository currentRepository, final Callback0 callback0) {
                String searchQuery = "@type:\"BadgeClass\"";
                for (int i = 0; i < listOfCompetencies.$length(); i++) {
                    if (i == 0)
                        searchQuery += " AND (";
                    if (i > 0)
                        searchQuery += " OR ";
                    searchQuery += "alignment.targetUrl:\"" + listOfCompetencies.$get(i) + "\"";
                }
                if (listOfCompetencies.$length() > 0)
                    searchQuery += ")";

                me.assertionProcessor.log(ip, "Querying repositories for badges regarding " + listOfCompetencies.$length() + " query: " + searchQuery);
                Object params = new Object();
                JSObjectAdapter.$put(params, "size", 5000);
                currentRepository.searchWithParams(searchQuery, params, null, new Callback1<Array<EcRemoteLinkedData>>() {
                    public void $invoke(final Array<EcRemoteLinkedData> p1) {
                        me.assertionProcessor.log(ip, p1.$length() + " badgeClasses found.");
                        EcAsyncHelper<EcRemoteLinkedData> badgeClassHelper = new EcAsyncHelper<>();
                        badgeClassHelper.each(p1, new Callback2<EcRemoteLinkedData, Callback0>() {
                            @Override
                            public void $invoke(final EcRemoteLinkedData badgeClass, final Callback0 badgeClassDone) {
                                currentRepository.search("@context:\"https://w3id.org/openbadges/v2\" AND @type:Assertion AND badge:\"" + badgeClass.id + "\"", null, new Callback1<Array<EcRemoteLinkedData>>() {
                                    @Override
                                    public void $invoke(Array<EcRemoteLinkedData> badgeAssertions) {
                                        for (int j = 0; j < badgeAssertions.$length(); j++) {
                                            String hash = sha256.hex(email + JSObjectAdapter.$get(JSObjectAdapter.$get(badgeAssertions.$get(j), "recipient"), "salt"));
                                            if ("sha256$" + hash.toLowerCase() != JSObjectAdapter.$get(JSObjectAdapter.$get(badgeAssertions.$get(j), "recipient"), "identity"))
                                                badgeAssertions.splice(j--, 1);
                                        }
                                        for (int j = 0;j < badgeAssertions.$length();j++)
                                        {
                                            Array alignments = (Array) JSObjectAdapter.$get(badgeClass,"alignment");
                                            if (alignments != null)
                                                for (int k = 0;k < alignments.$length();k++)
                                                {
                                                    Object alignment = alignments.$get(k);
                                                    EcAssertion a = new EcAssertion();
                                                    a.setSubject(ip.subject.$get(0));
                                                    a.competency = (String) JSObjectAdapter.$get(alignment,"targetUrl");
                                                    a.framework = (String) JSObjectAdapter.$get(alignment,"targetFramework");
                                                    a.confidence = confidenceOfBadges;
                                                    Array<String> evidence = new Array<>();
                                                    evidence.push(badgeAssertions.$get(j).id);
                                                    a.setEvidence(evidence);
                                                    a.setAssertionDate((Long) (Object) new Date((String) JSObjectAdapter.$get(badgeAssertions.$get(j),"issuedOn")).getTime());
                                                    assertions.push(a);
                                                }
                                        }
                                        badgeClassDone.$invoke();
                                    }
                                }, ip.failure);
                            }
                        }, new Callback1<Array<EcRemoteLinkedData>>() {
                            @Override
                            public void $invoke(Array<EcRemoteLinkedData> strings) {
                                callback0.$invoke();
                            }
                        });
                    }
                }, ip.failure);
            }
        }, new Callback1<Array<EcRepository>>() {
            @Override
            public void $invoke(Array<EcRepository> strings) {
                success.$invoke(assertions);
            }
        });
    }
}
