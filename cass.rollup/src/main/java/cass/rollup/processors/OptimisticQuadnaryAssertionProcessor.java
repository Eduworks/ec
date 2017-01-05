package cass.rollup.processors;

import cass.rollup.InquiryPacket;
import cass.rollup.InquiryPacket.IPType;
import cass.rollup.InquiryPacket.ResultType;

public class OptimisticQuadnaryAssertionProcessor extends CombinatorAssertionProcessor
{

    public boolean transferIndeterminateOptimistically = true;

    private void determineCombinatorAndResult(InquiryPacket ip)
    {
        if (ip.anyChildPacketsAreFalse())
        {
            ip.result = ResultType.FALSE;
        } else if (ip.anyIndeterminantChildPackets())
        {
            ip.result = ResultType.INDETERMINANT;
        } else if (ip.anyChildPacketsAreUnknown())
        {
            ip.result = ResultType.UNKNOWN;
        } else
        {
            ip.result = ResultType.TRUE;
        }
    }

    private void determineCombinatorNarrowsResult(InquiryPacket ip)
    {
        if (ip.anyChildPacketsAreTrue())
        {
            ip.result = ResultType.TRUE;
        } else if (transferIndeterminateOptimistically && ip.anyIndeterminantChildPackets())
        {
            ip.result = ResultType.FALSE;
        } else
        {
            ip.result = ResultType.UNKNOWN;
        }
    }

    private void determineCombinatorBroadensResult(InquiryPacket ip)
    {
        if (ip.anyChildPacketsAreFalse())
        {
            ip.result = ResultType.FALSE;
        } else if (transferIndeterminateOptimistically && ip.anyIndeterminantChildPackets())
        {
            ip.result = ResultType.TRUE;
        }else if (ip.allChildPacketsAreTrue())
        {
            ip.result = ResultType.TRUE;
        } else
        {
            ip.result = ResultType.UNKNOWN;
        }
    }

    private void determineCombinatorRequiresResult(InquiryPacket ip)
    {
        if (ip.anyChildPacketsAreFalse())
        {
            ip.result = ResultType.FALSE;
        } else if (transferIndeterminateOptimistically && ip.anyIndeterminantChildPackets())
        {
            ip.result = ResultType.TRUE;
        } else
        {
            ip.result = ResultType.UNKNOWN;
        }
    }

    private void determineCombinatorIsRequiredByResult(InquiryPacket ip)
    {
        if (ip.anyChildPacketsAreTrue())
        {
            ip.result = ResultType.TRUE;
        } else if (transferIndeterminateOptimistically && ip.anyIndeterminantChildPackets())
        {
            ip.result = ResultType.FALSE;
        } else
        {
            ip.result = ResultType.UNKNOWN;
        }
    }

    private void determineCombinatorOrResult(InquiryPacket ip)
    {
        if (ip.anyChildPacketsAreTrue())
        {
            ip.result = ResultType.TRUE;
        } else if (ip.anyIndeterminantChildPackets())
        {
            ip.result = ResultType.INDETERMINANT;
        } else if (ip.allChildPacketsUnknown())
        {
            ip.result = ResultType.UNKNOWN;
        } else
        {
            ip.result = ResultType.FALSE;
        }
    }

    private ResultType getPacketAssertionResult(InquiryPacket ip)
    {
        if (ip.positive.$length() > 0 && ip.negative.$length() == 0)
        {
            return ResultType.TRUE;
        } else if (ip.positive.$length() == 0 && ip.negative.$length() > 0)
        {
            return ResultType.FALSE;
        } else if (ip.positive.$length() > 0 && ip.negative.$length() > 0)
        {
            return ResultType.INDETERMINANT;
        } else
        {
            return ResultType.UNKNOWN;
        }
    }

    private void determineResultForUnknownAssertionResult(InquiryPacket ip)
    {
        if (ip.allChildPacketsUnknown())
        {
            ip.result = ResultType.UNKNOWN;
        } else if (ip.allEquivalentPacketsUnknown())
        {
            if (ip.allSubPacketsTrueOrUnknown())
            {
                ip.result = ResultType.TRUE;
            } else if (ip.allSubPacketsFalseOrUnknown())
            {
                ip.result = ResultType.FALSE;
            } else
            {
                ip.result = ResultType.INDETERMINANT;
            }
        } else if (ip.allEquivalentPacketsTrueOrUnknown())
        {
            if (ip.allSubPacketsTrueOrUnknown())
            {
                ip.result = ResultType.TRUE;
            } else
            {
                ip.result = ResultType.INDETERMINANT;
            }
        } else if (ip.allEquivalentPacketsFalseOrUnknown())
        {
            if (ip.allSubPacketsFalseOrUnknown())
            {
                ip.result = ResultType.FALSE;
            } else
            {
                ip.result = ResultType.INDETERMINANT;
            }
        } else
        {
            ip.result = ResultType.INDETERMINANT;
        }
    }

    private void determineResultForTrueAssertionResult(InquiryPacket ip)
    {
        if (ip.allEquivalentPacketsTrueOrUnknown())
        {
            if (ip.allSubPacketsTrueOrUnknown())
            {
                ip.result = ResultType.TRUE;
            } else
            {
                ip.result = ResultType.INDETERMINANT;
            }
        } else
        {
            ip.result = ResultType.INDETERMINANT;
        }
    }

    private void determineResultForFalseAssertionResult(InquiryPacket ip)
    {
        if (ip.allEquivalentPacketsFalseOrUnknown())
        {
            if (ip.allSubPacketsFalseOrUnknown())
            {
                ip.result = ResultType.FALSE;
            } else
            {
                ip.result = ResultType.INDETERMINANT;
            }
        } else
        {
            ip.result = ResultType.INDETERMINANT;
        }
    }

    /**
     * IF IP type is COMPETENCY|ROLLUPRULE: assertionResult = ( IF number of
     * positive assertions > 0 && number of negative assertions = 0 THEN
     * assertionResult = TRUE IF number of positive assertions = 0 && number of
     * negative assertions > 0 THEN assertionResult = FALSE IF number of
     * positive assertions > 0 && number of negative assertions > 0 THEN
     * assertionResult = INDETERMINANT IF number of positive assertions = 0 &&
     * number of negative assertions = 0 THEN assertionResult = UNKNOWN )
     *
     * IF assertionResult = INDETERMINANT THEN INDETERMINANT ELSE IF any
     * equivalent packets = INDETERMINANT THEN INDETERMINANT ELSE IF any sub
     * packets = INDETERMINANT THEN INDETERMINANT
     *
     * ELSE IF assertionResult = UNKNOWN: IF all equivalent packets = UNKNOWN IF
     * all sub packets = UNKNOWN THEN UNKNOWN IF all sub packets = TRUE|UNKNOWN
     * THEN TRUE IF all sub packets = FALSE|UNKNOWN THEN FALSE ELSE
     * INDETERMINANT
     *
     * ELSE IF all equivalent packets = TRUE|UNKNOWN IF all sub packets =
     * TRUE|UNKNOWN THEN TRUE ELSE INDETERMINANT
     *
     * ELSE IF all equivalent packets = FALSE|UNKNOWN IF all sub packets =
     * FALSE|UNKNOWN THEN FALSE ELSE INDETERMINANT
     *
     * ELSE INDETERMINANT
     *
     *
     * ELSE IF assertionResult = TRUE: IF all equivalent packets = TRUE|UNKNOWN
     * IF all sub packets = TRUE|UNKNOWN THEN TRUE ELSE INDETERMINANT
     *
     * ELSE INDETERMINANT
     *
     * ELSE IF assertionResult = FALSE: IF all equivalent packets =
     * FALSE|UNKNOWN IF all sub packets = FALSE|UNKNOWN THEN FALSE ELSE
     * INDETERMINANT
     *
     * ELSE INDETERMINANT
     *
     */
    private void determineCompetencyOrRollupRuleResult(InquiryPacket ip)
    {
        ResultType assertionResult = getPacketAssertionResult(ip);
        if (ResultType.INDETERMINANT.equals(assertionResult) || ip.anyIndeterminantChildPackets())
        {
            ip.result = ResultType.INDETERMINANT;
        } else if (ResultType.UNKNOWN.equals(assertionResult))
        {
            determineResultForUnknownAssertionResult(ip);
        } else if (ResultType.TRUE.equals(assertionResult))
        {
            determineResultForTrueAssertionResult(ip);
        } else
        {
            determineResultForFalseAssertionResult(ip);
        }
    }

    protected void determineResult(InquiryPacket ip)
    {
        if (ip.numberOfQueriesRunning == 0)
        {
            if (IPType.RELATION_AND.equals(ip.type))
            {
                determineCombinatorAndResult(ip);
            } else if (IPType.RELATION_OR.equals(ip.type))
            {
                determineCombinatorOrResult(ip);
            } else if (IPType.RELATION_NARROWS.equals(ip.type))
            {
                determineCombinatorNarrowsResult(ip);
            } else if (IPType.RELATION_BROADENS.equals(ip.type))
            {
                determineCombinatorBroadensResult(ip);
            } else if (IPType.RELATION_REQUIRES.equals(ip.type))
            {
                determineCombinatorRequiresResult(ip);
            } else if (IPType.RELATION_ISREQUIREDBY.equals(ip.type))
            {
                determineCombinatorIsRequiredByResult(ip);
            } else
            {
                determineCompetencyOrRollupRuleResult(ip);
            }
        } else
        {
            log(ip, "We are not finished accumulating data to answer this query. Error: " + ip.numberOfQueriesRunning);
        }
    }

}
