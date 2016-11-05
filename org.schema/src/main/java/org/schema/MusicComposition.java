package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/MusicComposition
 * A musical composition.
 * @author schema.org
 * @module schema.org
 * @class MusicComposition
 * @extends CreativeWork
 */
public class MusicComposition extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MusicComposition()
	{
		context="http://schema.org/";
		type="MusicComposition";
	}

	/**
	 * Schema.org/musicArrangement
	 * An arrangement derived from the composition.
	 * @property musicArrangement
	 * @type MusicComposition
	 */
	public MusicComposition musicArrangement;

	/**
	 * Schema.org/composer
	 * The person or organization who wrote a composition, or who is the composer of a work performed at some event.
	 * @property composer
	 * @type schema,Organization | schema,Person	 */
	public Object composer;

	/**
	 * Schema.org/recordedAs
	 * An audio recording of the work.
	 * @property recordedAs
	 * @type MusicRecording
	 */
	public MusicRecording recordedAs;

	/**
	 * Schema.org/musicCompositionForm
	 * The type of composition (e.g. overture, sonata, symphony, etc.).
	 * @property musicCompositionForm
	 * @type Text
	 */
	public String musicCompositionForm;

	/**
	 * Schema.org/musicalKey
	 * The key, mode, or scale this composition uses.
	 * @property musicalKey
	 * @type Text
	 */
	public String musicalKey;

	/**
	 * Schema.org/iswcCode
	 * The International Standard Musical Work Code for the composition.
	 * @property iswcCode
	 * @type Text
	 */
	public String iswcCode;

	/**
	 * Schema.org/includedComposition
	 * Smaller compositions included in this work (e.g. a movement in a symphony).
	 * @property includedComposition
	 * @type MusicComposition
	 */
	public MusicComposition includedComposition;

	/**
	 * Schema.org/lyrics
	 * The words in the song.
	 * @property lyrics
	 * @type CreativeWork
	 */
	public CreativeWork lyrics;

	/**
	 * Schema.org/firstPerformance
	 * The date and place the work was first performed.
	 * @property firstPerformance
	 * @type Event
	 */
	public Event firstPerformance;

	/**
	 * Schema.org/lyricist
	 * The person who wrote the words.
	 * @property lyricist
	 * @type Person
	 */
	public Person lyricist;

}