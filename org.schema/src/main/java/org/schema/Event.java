package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Event
 * An event happening at a certain time and location, such as a concert, lecture, or festival. Ticketing information may be added via the [[offers]] property. Repeated events may be structured as separate Event objects.
 * @author schema.org
 * @class Event
 * @module org.schema
 * @extends Thing
 */
public class Event extends Thing
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Event()
	{
		context="http://schema.org/";
		type="Event";
	}

	/**
	 * Schema.org/workFeatured
	 * A work featured in some event, e.g. exhibited in an ExhibitionEvent.
       Specific subproperties are available for workPerformed (e.g. a play), or a workPresented (a Movie at a ScreeningEvent).
	 * @property workFeatured
	 * @type CreativeWork
	 */
	public CreativeWork workFeatured;

	/**
	 * Schema.org/contributor
	 * A secondary contributor to the CreativeWork or Event.
	 * @property contributor
	 * @type schema,Organization | schema,Person
	 */
	public Object contributor;

	/**
	 * Schema.org/attendees
	 * A person attending the event.
	 * @property attendees
	 * @type schema,Organization | schema,Person
	 */
	public Object attendees;

	/**
	 * Schema.org/performers
	 * The main performer or performers of the event&#x2014;for example, a presenter, musician, or actor.
	 * @property performers
	 * @type schema,Organization | schema,Person
	 */
	public Object performers;

	/**
	 * Schema.org/composer
	 * The person or organization who wrote a composition, or who is the composer of a work performed at some event.
	 * @property composer
	 * @type schema,Organization | schema,Person
	 */
	public Object composer;

	/**
	 * Schema.org/performer
	 * A performer at the event&#x2014;for example, a presenter, musician, musical group or actor.
	 * @property performer
	 * @type schema,Organization | schema,Person
	 */
	public Object performer;

	/**
	 * Schema.org/isAccessibleForFree
	 * A flag to signal that the publication is accessible for free.
	 * @property isAccessibleForFree
	 * @type Boolean
	 */
	public Boolean isAccessibleForFree;

	/**
	 * Schema.org/director
	 * A director of e.g. tv, radio, movie, video gaming etc. content, or of an event. Directors can be associated with individual items or with a series, episode, clip.
	 * @property director
	 * @type Person
	 */
	public Person director;

	/**
	 * Schema.org/eventStatus
	 * An eventStatus of an event represents its status; particularly useful when an event is cancelled or rescheduled.
	 * @property eventStatus
	 * @type EventStatusType
	 */
	public EventStatusType eventStatus;

	/**
	 * Schema.org/superEvent
	 * An event that this event is a part of. For example, a collection of individual music performances might each have a music festival as their superEvent.
	 * @property superEvent
	 * @type Event
	 */
	public Event superEvent;

	/**
	 * Schema.org/translator
	 * Organization or person who adapts a creative work to different languages, regional differences and technical requirements of a target market, or that translates during some event.
	 * @property translator
	 * @type schema,Organization | schema,Person
	 */
	public Object translator;

	/**
	 * Schema.org/offers
	 * An offer to provide this item&#x2014;for example, an offer to sell a product, rent the DVD of a movie, perform a service, or give away tickets to an event.
	 * @property offers
	 * @type Offer
	 */
	public Offer offers;

	/**
	 * Schema.org/review
	 * A review of the item.
	 * @property review
	 * @type Review
	 */
	public Review review;

	/**
	 * Schema.org/duration
	 * The duration of the item (movie, audio recording, event, etc.) in [ISO 8601 date format](http://en.wikipedia.org/wiki/ISO_8601).
	 * @property duration
	 * @type Duration
	 */
	public Duration duration;

	/**
	 * Schema.org/subEvent
	 * An Event that is part of this event. For example, a conference event includes many presentations, each of which is a subEvent of the conference.
	 * @property subEvent
	 * @type Event
	 */
	public Event subEvent;

	/**
	 * Schema.org/actor
	 * An actor, e.g. in tv, radio, movie, video games etc., or in an event. Actors can be associated with individual items or with a series, episode, clip.
	 * @property actor
	 * @type Person
	 */
	public Person actor;

	/**
	 * Schema.org/attendee
	 * A person or organization attending the event.
	 * @property attendee
	 * @type schema,Organization | schema,Person
	 */
	public Object attendee;

	/**
	 * Schema.org/funder
	 * A person or organization that supports (sponsors) something through some kind of financial contribution.
	 * @property funder
	 * @type schema,Organization | schema,Person
	 */
	public Object funder;

	/**
	 * Schema.org/typicalAgeRange
	 * The typical expected age range, e.g. '7-9', '11-'.
	 * @property typicalAgeRange
	 * @type Text
	 */
	public String typicalAgeRange;

	/**
	 * Schema.org/doorTime
	 * The time admission will commence.
	 * @property doorTime
	 * @type DateTime
	 */
	public String doorTime;

	/**
	 * Schema.org/sponsor
	 * A person or organization that supports a thing through a pledge, promise, or financial contribution. e.g. a sponsor of a Medical Study or a corporate sponsor of an event.
	 * @property sponsor
	 * @type schema,Organization | schema,Person
	 */
	public Object sponsor;

	/**
	 * Schema.org/location
	 * The location of for example where the event is happening, an organization is located, or where an action takes place.
	 * @property location
	 * @type schema,PostalAddress | schema,Place | schema,Text
	 */
	public Object location;

	/**
	 * Schema.org/recordedIn
	 * The CreativeWork that captured all or part of this Event.
	 * @property recordedIn
	 * @type CreativeWork
	 */
	public CreativeWork recordedIn;

	/**
	 * Schema.org/organizer
	 * An organizer of an Event.
	 * @property organizer
	 * @type schema,Organization | schema,Person
	 */
	public Object organizer;

	/**
	 * Schema.org/aggregateRating
	 * The overall rating, based on a collection of reviews or ratings, of the item.
	 * @property aggregateRating
	 * @type AggregateRating
	 */
	public AggregateRating aggregateRating;

	/**
	 * Schema.org/startDate
	 * The start date and time of the item (in [ISO 8601 date format](http://en.wikipedia.org/wiki/ISO_8601)).
	 * @property startDate
	 * @type schema,DateTime | schema,Date
	 */
	public Object startDate;

	/**
	 * Schema.org/previousStartDate
	 * Used in conjunction with eventStatus for rescheduled or cancelled events. This property contains the previously scheduled start date. For rescheduled events, the startDate property should be used for the newly scheduled start date. In the (rare) case of an event that has been postponed and rescheduled multiple times, this field may be repeated.
	 * @property previousStartDate
	 * @type Date
	 */
	public String previousStartDate;

	/**
	 * Schema.org/workPerformed
	 * A work performed in some event, for example a play performed in a TheaterEvent.
	 * @property workPerformed
	 * @type CreativeWork
	 */
	public CreativeWork workPerformed;

	/**
	 * Schema.org/endDate
	 * The end date and time of the item (in [ISO 8601 date format](http://en.wikipedia.org/wiki/ISO_8601)).
	 * @property endDate
	 * @type schema,DateTime | schema,Date
	 */
	public Object endDate;

	/**
	 * Schema.org/inLanguage
	 * The language of the content or performance or used in an action. Please use one of the language codes from the [IETF BCP 47 standard](http://tools.ietf.org/html/bcp47). See also [[availableLanguage]].
	 * @property inLanguage
	 * @type schema,Language | schema,Text
	 */
	public Object inLanguage;

	/**
	 * Schema.org/subEvents
	 * Events that are a part of this event. For example, a conference event includes many presentations, each subEvents of the conference.
	 * @property subEvents
	 * @type Event
	 */
	public Event subEvents;

}