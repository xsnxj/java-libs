/*
 * component:   "openEHR Reference Implementation"
 * description: "Class ItemStructure"
 * keywords:    "datastructure"
 *
 * author:      "Rong Chen <rong@acode.se>"
 * support:     "Acode HB <support@acode.se>"
 * copyright:   "Copyright (c) 2004 Acode HB, Sweden"
 * license:     "See notice at bottom of class"
 *
 * file:        "$URL$"
 * revision:    "$LastChangedRevision$"
 * last_change: "$LastChangedDate$"
 */
package org.openehr.rm.datastructure.itemstructure;

import org.apache.commons.lang.StringUtils;
import org.openehr.rm.common.archetyped.Archetyped;
import org.openehr.rm.common.archetyped.FeederAudit;
import org.openehr.rm.common.archetyped.Link;
import org.openehr.rm.support.identification.ObjectID;
import org.openehr.rm.datastructure.DataStructure;
import org.openehr.rm.datastructure.itemstructure.representation.Item;
import org.openehr.rm.datatypes.text.DvText;

import java.util.Set;

/**
 * Abstract parent class of all spatial data types.
 *
 * @author Rong Chen
 * @version 1.0
 */
public abstract class ItemStructure extends DataStructure {

    /**
     * Construct a ItemStructure
     *
     * @param uid
     * @param archetypeNodeId
     * @param name
     * @param archetypeDetails
     * @param feederAudit
     * @param links
     * @param representation
     * @throws IllegalArgumentException if representation null
     */
    protected ItemStructure(ObjectID uid, String archetypeNodeId, DvText name,
                            Archetyped archetypeDetails,
                            FeederAudit feederAudit, Set<Link> links,
                            Item representation) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit,
                links);
        if (representation == null) {
            throw new IllegalArgumentException("null representation");
        }
        this.representation = representation;
    }

    /**
     * Return the representation of this ItemStructrue
     *
     * @return representation
     */
    public Item getRepresentation() {
        return representation;
    }

    /**
     * Check if given path is valid
     *
     * @param path
     * @throws IllegalArgumentException if path null or empty or
     *                                  not contains or not starts with PATH_SEPARATOR
     */
    static void checkPath(String path) {
        if (StringUtils.isEmpty(path)
                || path.indexOf(PATH_SEPARATOR) < 0
                || !path.startsWith(PATH_SEPARATOR)) {
            throw new IllegalArgumentException("null or empty path");
        }
    }

    // POJO start
    protected ItemStructure() {
    }

    void setRepresentation(Item representation) {
        this.representation = representation;
    }
    // POJO end

    /* fields */
    private Item representation;
}

/*
 *  ***** BEGIN LICENSE BLOCK *****
 *  Version: MPL 1.1/GPL 2.0/LGPL 2.1
 *
 *  The contents of this file are subject to the Mozilla Public License Version
 *  1.1 (the 'License'); you may not use this file except in compliance with
 *  the License. You may obtain a copy of the License at
 *  http://www.mozilla.org/MPL/
 *
 *  Software distributed under the License is distributed on an 'AS IS' basis,
 *  WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 *  for the specific language governing rights and limitations under the
 *  License.
 *
 *  The Original Code is ItemStructure.java
 *
 *  The Initial Developer of the Original Code is Rong Chen.
 *  Portions created by the Initial Developer are Copyright (C) 2003-2004
 *  the Initial Developer. All Rights Reserved.
 *
 *  Contributor(s):
 *
 * Software distributed under the License is distributed on an 'AS IS' basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 *  ***** END LICENSE BLOCK *****
 */