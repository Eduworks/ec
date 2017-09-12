package org.schema;

/**
 * Schema.org/PublicationEvent
 * A PublicationEvent corresponds indifferently to the event of publication for a CreativeWork of any type e.g. a broadcast event, an on-demand event, a book/journal publication via a variety of delivery media.
 *
 * @author schema.org
 * @class PublicationEvent
 * @module org.schema
 * @extends Event
 */
public class PublicationEvent extends Event {
	/**
	 * Schema.org/isAccessibleForFree
	 * A flag to signal that the publication is accessible for free.
	 *
	 * @property isAccessibleForFree
	 * @type Boolean
	 */
	public Boolean isAccessibleForFree;
	/**
	 * Schema.org/publishedOn
	 * A broadcast service associated with the publication event.
	 *
	 * @property publishedOn
	 * @type BroadcastService
	 */
	public BroadcastService publishedOn;
	/**
	 * Schema.org/free
	 * A flag to signal that the publication or event is accessible for free.
	 *
	 * @property free
	 * @type Boolean
	 */
	public Boolean free;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public PublicationEvent() {
		context = "http://schema.org/";
		type = "PublicationEvent";
	}

}