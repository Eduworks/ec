package cass.rollup.processors;

import org.cass.competency.EcCompetency;
import org.cass.competency.EcRollupRule;
import org.cass.profile.EcAssertion;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Date;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.crypto.EcPk;

import cass.rollup.InquiryPacket;
import cass.rollup.InquiryPacket.IPType;
import cass.rollup.RelationshipPacketGenerator;
import cass.rollup.rule.RollupRuleInterface;
import cass.rollup.rule.RollupRuleProcessor;
import com.eduworks.ec.array.EcAsyncHelper;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback2;

//Requires Subject, AssertionDate, ExpirationDate
public abstract class CombinatorAssertionProcessor extends AssertionProcessor {

    private void processFoundAssertion(EcRemoteLinkedData searchData, final InquiryPacket ip, final Callback0 success, final Callback1<String> failure) {
        final EcAssertion a = new EcAssertion();
        a.copyFrom(searchData);
        final EcAsyncHelper<EcPk> eah = new EcAsyncHelper<>();
        final CombinatorAssertionProcessor me = this;
        eah.each(ip.subject, new Callback2<EcPk, Callback0>() {
            @Override
            public void $invoke(EcPk p1, final Callback0 p2) {
                me.checkSubject(a, p1, ip, p2, new Callback1<String>() {
                    @Override
                    public void $invoke(String p1) {
                        p2.$invoke();
                    }
                });
            }
        }, new Callback1<Array<EcPk>>() {
            @Override
            public void $invoke(Array<EcPk> p1) {
                success.$invoke();
            }
        });
    }

    private void checkSubject(final EcAssertion a, final EcPk currentSubject, final InquiryPacket ip, final Callback0 success, final Callback1<String> failure) {
        final CombinatorAssertionProcessor me = this;
        a.getSubjectAsync(new Callback1<EcPk>() {
            @Override
            public void $invoke(EcPk sub) {
                if (sub.equals(currentSubject)) {
                    me.log(ip, "Matching Assertion found.");
                    a.getAssertionDateAsync(new Callback1<Long>() {
                        @Override
                        public void $invoke(Long assertionDate) {
                            if (assertionDate > (long) new Date().getTime()) {
                                me.log(ip, "Assertion is made for a future date.");
                                success.$invoke();
                                return;
                            }
                            a.getExpirationDateAsync(new Callback1<Long>() {
                                @Override
                                public void $invoke(Long expirationDate) {
                                    if (expirationDate <= (long) new Date().getTime()) {
                                        me.log(ip, "Assertion is expired. Skipping.");
                                        success.$invoke();
                                        return;
                                    }
                                    me.logFoundAssertion(a, ip);
                                    a.getNegativeAsync(new Callback1<Boolean>() {
                                        @Override
                                        public void $invoke(Boolean p1) {
                                            if (p1) {
                                                me.log(ip, "Found valid negative assertion");
                                                ip.negative.push(a);
                                            } else {
                                                me.log(ip, "Found valid positive assertion");
                                                ip.positive.push(a);
                                            }
                                            success.$invoke();
                                        }
                                    }, new Callback1<String>() {
                                        @Override
                                        public void $invoke(String p1) {
                                            me.log(ip, "Found valid positive assertion");
                                            ip.positive.push(a);
                                            success.$invoke();
                                        }
                                    });
                                }
                            }, failure);
                        }
                    }, failure);
                } else {
                    failure.$invoke("Incorrect subject.");
                }
            }
        }, failure);
    }

    private void processFindAssertionsSuccess(Array data, InquiryPacket ip) {
        if (data.$length() == 0) {
            log(ip, "No results found.");
        } else {
            log(ip, "Total number of assertions found: " + data.$length());
        }
        ip.numberOfQueriesRunning--;
        checkStep(ip);
    }

    protected void findSubjectAssertionsForCompetency(final InquiryPacket ip) {
        ip.hasCheckedAssertionsForCompetency = true;

        if (!IPType.COMPETENCY.equals(ip.type) && !IPType.ROLLUPRULE.equals(ip.type)) {
            log(ip, "No assertions for combinator types");
            checkStep(ip);
            return;
        }
        final CombinatorAssertionProcessor me = this;

        if (IPType.COMPETENCY.equals(ip.type)) {
            for (int h = 0; h < ip.competency.$length(); h++) {
                ip.numberOfQueriesRunning++;
                EcCompetency competency = ip.competency.$get(h);
                Array<EcAssertion> assertionsForThisCompetency = (Array<EcAssertion>) JSObjectAdapter.$get(assertions, competency.shortId());
                EcAsyncHelper<EcAssertion> eah = new EcAsyncHelper<>();
                eah.each(assertionsForThisCompetency, new Callback2<EcAssertion, Callback0>() {
                    public void $invoke(EcAssertion p1, final Callback0 p2) {
                        me.processFoundAssertion(p1, ip, p2, new Callback1<String>() {
                            @Override
                            public void $invoke(String p1) {
                                p2.$invoke();
                            }
                        });
                    }
                }, new Callback1<Array<EcAssertion>>() {
                    public void $invoke(Array<EcAssertion> p1) {
                        me.processFindAssertionsSuccess(p1, ip);
                    }
                });
            }
        }
        else
        for (int i = 0; i < repositories.$length(); i++) {
            EcRepository currentRepository = repositories.$get(i);
            if (IPType.ROLLUPRULE.equals(ip.type)) {
                ip.numberOfQueriesRunning++;
                log(ip, "Searching: " + currentRepository.selectedServer);
                currentRepository.search(buildAssertionSearchQuery(ip, null), new Callback1<EcRemoteLinkedData>() {
                    @Override
                    public void $invoke(EcRemoteLinkedData p1) {
                    }
                }, new Callback1<Array<EcRemoteLinkedData>>() {
                    @Override
                    public void $invoke(Array<EcRemoteLinkedData> p1) {
                        EcAsyncHelper<EcRemoteLinkedData> eah = new EcAsyncHelper<>();
                        eah.each(p1, new Callback2<EcRemoteLinkedData, Callback0>() {
                            @Override
                            public void $invoke(EcRemoteLinkedData p1, final Callback0 p2) {
                                me.processFoundAssertion(p1, ip, p2, new Callback1<String>() {
                                    @Override
                                    public void $invoke(String p1) {
                                        p2.$invoke();
                                    }
                                });
                            }
                        }, new Callback1<Array<EcRemoteLinkedData>>() {
                            @Override
                            public void $invoke(Array<EcRemoteLinkedData> p1) {
                                me.processFindAssertionsSuccess(p1, ip);
                            }
                        });
                    }
                }, new Callback1<String>() {
                    @Override
                    public void $invoke(String p1) {
                        me.processEventFailure(p1, ip);
                    }
                });
            }
        }
    }

    protected void findCompetencyRelationships(final InquiryPacket ip) {
        ip.hasCheckedRelationshipsForCompetency = true;

        if (!IPType.COMPETENCY.equals(ip.type)) {
            log(ip, "No relationships for combinator types");
            checkStep(ip);
            return;
        }
        final CombinatorAssertionProcessor ep = this;
        for (int i = 0; i < ip.competency.$length(); i++) {
            log(ip, "Finding relationships for competency: " + ip.competency.$get(i));
            findCompetencyRelationship(ip, ep, ip.competency.$get(i));
        }
    }

    protected void findCompetencyRelationship(final InquiryPacket ip, final CombinatorAssertionProcessor ep, final EcCompetency c) {
        RelationshipPacketGenerator rpg = new RelationshipPacketGenerator(ip, ep, processedEquivalencies);
        rpg.failure = ip.failure;
        rpg.logFunction = logFunction;
        rpg.success = new Callback0() {
            @Override
            public void $invoke() {
                ep.processRelationshipPacketsGenerated(ip, c);
            }
        };
        log(ip, "Executing relationship packet generator");
        ip.numberOfQueriesRunning++;
        rpg.go();
    }

    protected void processFindRollupRuleSuccess(EcRollupRule rr, final InquiryPacket ip) {
        // TODO, need to take another pass with antlr...Nested competencies
        // checks is messed up
        // Things like this will fail [(competency:Addition1 OR
        // competency:Addition2) AND confidence>0.6]
        final AssertionProcessor ep = this;
        if (!ip.hasId(rr.competency)) {
            ep.processRollupRuleInterpretSkipped(ip);
            return;
        }
        log(ip, "Found rollup rule: " + rr.rule);
        RollupRuleProcessor rrp = new RollupRuleProcessor(ip, this);
        rrp.positive = ip.positive;
        rrp.negative = ip.negative;
        RollupRuleInterface rri = new RollupRuleInterface(rr.rule, rrp);
        rri.logFunction = logFunction;
        rri.success = new Callback1<Boolean>() {
            @Override
            public void $invoke(Boolean p1) {
                ep.processRollupRuleInterpretSuccess(p1, ip);
            }
        };
        rri.failure = ip.failure;
        log(ip, "Executing rollup rule interpreter");
        rri.go();
    }

}
