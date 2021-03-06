/*
 * This file is part of GatorMail, a servlet based webmail.
 * Copyright (C) 2002, 2003 William A. McArthur, Jr.
 * Copyright (C) 2003 The Open Systems Group / University of Florida
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

package edu.ufl.osg.webmail;

import javax.mail.Authenticator;
import javax.mail.Session;
import javax.servlet.ServletRequest;


/**
 * Provider interface used during login to authenticate and setup the JavaMail
 * session.
 *
 * @author sandymac
 * @version $Revision: 1.2 $
 */
public interface SessionProvider {
    /**
     * Returns an object with information about the user. The request parameter
     * is so that the {@link SessionProvider} plugin can access thing like cookies.
     *
     * @param  username            The user's username.
     * @param  password            The user's password.
     * @param  request             The ServletRequest.
     * @return                     A user object.
     */
    public User getUser(String username, String password, ServletRequest request);

    /**
     * Returns a JavaMail Authenticator to be used when the JavaMail session
     * connects.
     *
     * @param  user                User from which the username/password is
     *                             read.
     * @return                     The Authenticator to be used to connect.
     */
    public Authenticator getAuthenticator(User user);

    /**
     * Gets a JavaMail session to connect to the mail store.
     *
     * @param  authenticator       JavaMail Authenticator to be used during
     *                             connect.
     * @return                     A JavaMail session.
     */
    public Session getSession(Authenticator authenticator);
}