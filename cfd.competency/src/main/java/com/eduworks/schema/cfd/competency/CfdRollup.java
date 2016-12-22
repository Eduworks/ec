package com.eduworks.schema.cfd.competency;


/**
 * Competency is Under construction.
 * 
 * Working model of competency with CFD Rollup extension.
 * 
 * @author debbie.brown@eduworks.com
 * @author devlin.junker@eduworks.com
 * @class Rollup
 * @module com.eduworks
 * @extends org.cassproject.schema.cass.competency.Competency
 */
public class CfdRollup extends CfdCompetency{
	 
	/**
	 * Sub-type of Competency that this is (Will be replaced later)
	 * @property subtype
	 * @type string
	 */
	public final String subtype = "Assessment";

}
