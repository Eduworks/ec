package cass.rollup;

import cass.rollup.InquiryPacket.IPType;
import cass.rollup.processors.AssertionProcessor;
import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.stjs.javascript.Array;
import org.stjs.javascript.Date;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;

/**
 * Creates child packets for an InquiryPacket based on its context.
 *
 * @author fritz.ray@eduworks.com
 * @author tom.buskirk@eduworks.com
 * @class RelationshipPacketGenerator
 * @module org.cassproject
 */
public class RelationshipPacketGenerator {
	/**
	 * Method to call when any operation fails.
	 *
	 * @property failure
	 * @type function(string)
	 */
	public Callback1<String> failure;
	/**
	 * Method to call when the operation succeeds.
	 *
	 * @property success
	 * @type function()
	 */
	public Callback0 success;
	/**
	 * Method to call when the generator has log statements to emit.
	 *
	 * @property logFunction
	 * @type function(any)
	 */
	public Callback1<Object> logFunction;
	/**
	 * List of packets representing the narrows relation.
	 *
	 * @property narrowsPackets
	 * @type InquiryPacket[]
	 */
	public Array<InquiryPacket> narrowsPackets;
	/**
	 * List of packets representing the broadens relation.
	 *
	 * @property broadensPackets
	 * @type InquiryPacket[]
	 */
	public Array<InquiryPacket> broadensPackets;
	/**
	 * List of packets representing the required relation.
	 *
	 * @property requiredPackets
	 * @type InquiryPacket[]
	 */
	public Array<InquiryPacket> requiredPackets;
	/**
	 * List of packets representing the isRequiredBy relation.
	 *
	 * @property isRequiredByPackets
	 * @type InquiryPacket[]
	 */
	public Array<InquiryPacket> isRequiredByPackets;
	public Object relationLookup;
	/**
	 * Async counter to keep track of number of outstanding requests.
	 *
	 * @property numberOfRelationsToProcess
	 * @type integer
	 */
	private int numberOfRelationsToProcess = 0;
	/**
	 * Number of relations that have been processed.
	 *
	 * @property numberOfRelationsProcessed
	 * @type integer
	 */
	private int numberOfRelationsProcessed = 0;
	/**
	 * Alignments to ignore, as they have already been processed.
	 *
	 * @property processedAlignments;
	 * @type Object (Map<String,String>)
	 */
	private Map<String, String> processedAlignments;
	/**
	 * Assertion Processor that invoked this generator.
	 *
	 * @property ep
	 * @type AssertionProcessor
	 */
	private AssertionProcessor ep;
	/**
	 * Inquiry Packet that this generator is creating relationships for.
	 *
	 * @property ip
	 * @type InquiryPacket
	 */
	private InquiryPacket ip;

	/**
	 * Constructor for the RelationshipPacketGenerator
	 *
	 * @param {InquiryPacket}      ip Inquiry Packet to generate and fill with relationship packets.
	 * @param {AssertionProcessor} ep Assertion processor to tell to resume when complete.
	 * @param {object}             processedAlignments An object to fill with keys to ensure that relations are not processed twice.
	 * @constructor
	 */
	public RelationshipPacketGenerator(InquiryPacket ip, AssertionProcessor ep, Map<String, String> processedAlignments) {
		this.ip = ip;
		this.ep = ep;
		this.processedAlignments = processedAlignments;
		narrowsPackets = new Array<InquiryPacket>();
		broadensPackets = new Array<InquiryPacket>();
		requiredPackets = new Array<InquiryPacket>();
		isRequiredByPackets = new Array<InquiryPacket>();
	}

	protected void log(Object string) {
		if (logFunction != null)
			logFunction.$invoke("" + new Date().getTime() % 100000 + ": " + string);
	}

	private void processEventFailure(String message, InquiryPacket ip) {
		ip.numberOfQueriesRunning--;
		failure.$invoke(message);
	}

	private void pushRequiredPacketsToIp() {
		if (requiredPackets.$length() > 0) {
			final AssertionProcessor meEp = ep;
			final InquiryPacket meIp = ip;
			InquiryPacket rootRequiredPacket = new InquiryPacket(ip.subject, null, null, ip.context, new Callback1<InquiryPacket>() {
				@Override
				public void $invoke(InquiryPacket p1) {
					if (meEp != null)
						meEp.continueProcessingFirstPass(meIp);
				}
			}, ip.failure, null, IPType.RELATION_REQUIRES);
			rootRequiredPacket.subPackets = requiredPackets;
			ip.subPackets.push(rootRequiredPacket);
		}
	}

	private void pushIsRequiredByPacketsToIp() {
		if (isRequiredByPackets.$length() > 0) {
			final AssertionProcessor meEp = ep;
			final InquiryPacket meIp = ip;
			InquiryPacket rootRequiredPacket = new InquiryPacket(ip.subject, null, null, ip.context, new Callback1<InquiryPacket>() {
				@Override
				public void $invoke(InquiryPacket p1) {
					if (meEp != null)
						meEp.continueProcessingFirstPass(meIp);
				}
			}, ip.failure, null, IPType.RELATION_ISREQUIREDBY);
			rootRequiredPacket.subPackets = isRequiredByPackets;
			ip.subPackets.push(rootRequiredPacket);
		}
	}

	private void pushNarrowsPacketsToIp() {
		if (narrowsPackets.$length() > 0) {
			final AssertionProcessor meEp = ep;
			final InquiryPacket meIp = ip;
			InquiryPacket rootNarrowsPacket = new InquiryPacket(ip.subject, null, null, ip.context, new Callback1<InquiryPacket>() {
				@Override
				public void $invoke(InquiryPacket p1) {
					if (meEp != null)
						meEp.continueProcessingFirstPass(meIp);
				}
			}, ip.failure, null, IPType.RELATION_NARROWS);
			rootNarrowsPacket.subPackets = narrowsPackets;
			ip.subPackets.push(rootNarrowsPacket);
		}
	}

	private void pushBroadensPacketsToIp() {
		if (broadensPackets.$length() > 0) {
			final AssertionProcessor meEp = ep;
			final InquiryPacket meIp = ip;
			InquiryPacket rootBroadensPacket = new InquiryPacket(ip.subject, null, null, ip.context, new Callback1<InquiryPacket>() {
				@Override
				public void $invoke(InquiryPacket p1) {
					if (meEp != null)
						meEp.continueProcessingFirstPass(meIp);
				}
			}, ip.failure, null, IPType.RELATION_BROADENS);
			rootBroadensPacket.subPackets = broadensPackets;
			ip.subPackets.push(rootBroadensPacket);
		}
	}

	private void finishRelationProcessing() {
		pushRequiredPacketsToIp();
		pushIsRequiredByPacketsToIp();
		pushNarrowsPacketsToIp();
		pushBroadensPacketsToIp();
		success.$invoke();
	}

	private void processGetRelatedCompetencySuccess(EcCompetency relatedCompetency, EcAlignment alignment) {
		numberOfRelationsProcessed++;
		final AssertionProcessor meEp = ep;
		final InquiryPacket meIp = ip;

		if (processedAlignments.$get(alignment.shortId()) != null) {
			ip.numberOfQueriesRunning--;
			checkForFinish();
			return;
		}
		processedAlignments.$put(alignment.shortId(), "done");

		log("Adding new " + alignment.relationType + " relationship packet");

		if (EcAlignment.IS_EQUIVALENT_TO.equals(alignment.relationType)) {
			InquiryPacket ip2 = null;
			ip.equivalentPackets.push(ip2 = new InquiryPacket(ip.subject, relatedCompetency, null, ip.context, new Callback1<InquiryPacket>() {
				@Override
				public void $invoke(InquiryPacket p1) {
					if (meEp != null)
						meEp.continueProcessingFirstPass(meIp);
				}
			}, ip.failure, null, IPType.COMPETENCY));
			// ip2.equivalentPackets.push(ip);
		} else if (EcAlignment.REQUIRES.equals(alignment.relationType)) {
			if (ip.hasId(alignment.source))
				requiredPackets.push(new InquiryPacket(ip.subject, relatedCompetency, null, ip.context, new Callback1<InquiryPacket>() {
					@Override
					public void $invoke(InquiryPacket p1) {
						if (meEp != null)
							meEp.continueProcessingFirstPass(meIp);
					}
				}, ip.failure, null, IPType.COMPETENCY));
			else
				isRequiredByPackets.push(new InquiryPacket(ip.subject, relatedCompetency, null, ip.context, new Callback1<InquiryPacket>() {
					@Override
					public void $invoke(InquiryPacket p1) {
						if (meEp != null)
							meEp.continueProcessingFirstPass(meIp);
					}
				}, ip.failure, null, IPType.COMPETENCY));
		} else if (EcAlignment.NARROWS.equals(alignment.relationType)) {
			if (ip.hasId(alignment.source))
				narrowsPackets.push(new InquiryPacket(ip.subject, relatedCompetency, null, ip.context, new Callback1<InquiryPacket>() {
					@Override
					public void $invoke(InquiryPacket p1) {
						if (meEp != null)
							meEp.continueProcessingFirstPass(meIp);
					}
				}, ip.failure, null, IPType.COMPETENCY));
			else
				broadensPackets.push(new InquiryPacket(ip.subject, relatedCompetency, null, ip.context, new Callback1<InquiryPacket>() {
					@Override
					public void $invoke(InquiryPacket p1) {
						if (meEp != null)
							meEp.continueProcessingFirstPass(meIp);
					}
				}, ip.failure, null, IPType.COMPETENCY));
		}
		ip.numberOfQueriesRunning--;
		checkForFinish();
	}

	private void checkForFinish() {
		if (numberOfRelationsProcessed >= numberOfRelationsToProcess)
			finishRelationProcessing();
	}

	private void processFindCompetencyRelationshipSuccess(final EcAlignment alignment, final InquiryPacket ip) {
		ip.numberOfQueriesRunning--;
		String relatedCompetencyId = null;
		if (ip.hasId(alignment.source) && ip.hasId(alignment.target)) {
			//No need to process. The packet contains both ends of the relation.
			numberOfRelationsProcessed++;
			checkForFinish();
			return;
		} else if (ip.hasId(alignment.source))
			relatedCompetencyId = alignment.target;
		else if (ip.hasId(alignment.target))
			relatedCompetencyId = alignment.source;
		else {
			numberOfRelationsProcessed++;
			checkForFinish();
			return;
		}
		log("Relationship found (" + alignment.relationType + ") source: " + alignment.source + " target: " + alignment.target);

		ip.numberOfQueriesRunning++;
		final RelationshipPacketGenerator rpg = this;
		EcCompetency.get(relatedCompetencyId, new Callback1<EcCompetency>() {
			@Override
			public void $invoke(EcCompetency p1) {
				rpg.processGetRelatedCompetencySuccess(p1, alignment);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				rpg.processEventFailure(p1, ip);
			}
		});
	}

	/**
	 * Method to invoke to begin relation processing.
	 *
	 * @method go
	 */
	public void go() {
		final RelationshipPacketGenerator rpg = this;
		if (ip.getContext().relation == null)
			success.$invoke();
		else {
			numberOfRelationsToProcess = 0;
			for (int i = 0; i < ip.competency.$length(); i++) {
				Array<EcAlignment> relationsRelatedToThisCompetency = (Array<EcAlignment>) JSObjectAdapter.$get(relationLookup, ip.competency.$get(i).shortId());
				if (relationsRelatedToThisCompetency == null)
					relationsRelatedToThisCompetency = new Array<>();
				numberOfRelationsToProcess += relationsRelatedToThisCompetency.$length();
				numberOfRelationsProcessed = 0;
				for (int j = 0; j < relationsRelatedToThisCompetency.$length(); j++) {
					ip.numberOfQueriesRunning++;
					rpg.processFindCompetencyRelationshipSuccess(relationsRelatedToThisCompetency.$get(j), rpg.ip);
				}
				if (relationsRelatedToThisCompetency.$length() == 0) {
					checkForFinish();
				}
			}
//			numberOfRelationsToProcess = ip.getContext().relation.$length();
//			numberOfRelationsProcessed = 0;
//			for (int i = 0; i < ip.getContext().relation.$length(); i++)
//			{
//				ip.numberOfQueriesRunning++;
//				EcAlignment.get(ip.getContext().relation.$get(i), new Callback1<EcAlignment>()
//				{
//					@Override
//					public void $invoke(EcAlignment p1)
//					{
//						rpg.processFindCompetencyRelationshipSuccess(p1, rpg.ip);
//					}
//				}, new Callback1<String>()
//				{
//					@Override
//					public void $invoke(String p1)
//					{
//						rpg.processEventFailure(p1, rpg.ip);
//					}
//				});
//			}
		}
	}

}
