/*
 * This file is part of GatorMail, a servlet based webmail.
 * Copyright (C) 2005 The Open Systems Group / University of Florida
 *
 * GatorMail is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * GatorMail is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with GatorMail; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package edu.ufl.osg.webmail.forms;

import org.apache.struts.action.ActionForm;

/**
 * Holds values required for folder entries.
 *
 * @author laura2
 * @version $Revision: 1.1 $
 * @since Oct 7, 2005
 */
public class EmptyFolderForm extends ActionForm{
    private String folderName;
    private String sure;
    private String permanent;
    private String action;

    public String getPermanent() {
        return permanent;
    }

    public void setPermanent(final String permanent) {
        this.permanent = permanent;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(final String folderName) {
        this.folderName = folderName;
    }

    public String getSure() {
        return sure;
    }

    public void setSure(final String sure) {
        this.sure = sure;
    }

    public String getAction() {
        return action;
    }

    public void setAction(final String action) {
        this.action = action;
    }
}