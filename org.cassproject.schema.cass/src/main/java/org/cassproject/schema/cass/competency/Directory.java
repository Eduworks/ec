package org.cassproject.schema.cass.competency;

import org.cassproject.schema.cass.Cass;
import org.stjs.javascript.Array;
import org.schema.CreativeWork;

/**
 * A Directory is a collection of frameworks and resources.
 *
 * @author kristin.wood@eduworks.com
 * @class Directory
 * @module org.cassproject
 * @extends CreativeWork
 */

public class Directory extends CreativeWork{
    private static final String TYPE_0_6 = "https://schema.cassproject.org/0.4/Directory";
    public static final String myType = TYPE_0_6;
    /**
     * URLs of frameworks included in this directory.
     *
     * @property framework
     * @type string[]
     */
    public Array<String> framework;
    /**
     * URLs of resources included in this directory.
     *
     * @property resource
     * @type string[]
     */
    public Array<String> resource;
    /**
     * URLs of subdirectories included in this directory.
     *
     * @property subdirectory
     * @type string[]
     */
    public Array<String> subdirectory;

    public Directory() {
        setContextAndType(Cass.context, myType);
    }

    @Override
    protected void upgrade() {
        super.upgrade();
    }

    @Override
    public Array<String> getTypes() {
        Array<String> a = new Array<String>();
        a.push(TYPE_0_6);
        return a;
    }
}
