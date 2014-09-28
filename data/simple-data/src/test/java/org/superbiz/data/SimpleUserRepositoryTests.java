/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.superbiz.data;

import org.junit.Before;
import org.junit.Test;

import javax.ejb.CreateException;
import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @version $Revision: 607077 $ $Date: 2007-12-27 06:55:23 -0800 (Thu, 27 Dec 2007) $
 */
public class SimpleUserRepositoryTests {

    @EJB
    private SimpleUserRepository repository;
    private User user;

    @Before
    public void setup() throws Exception {
        EJBContainer.createEJBContainer().getContext().bind("inject", this);

        user = repository.create("qtarantino", "Quentin", "Tarantino");
    }

    @Test
    public void findSavedUserById() throws Exception {

        assertEquals(user, repository.findByPrimaryKey(user.getId()));
    }

    @Test
    public void findSavedUserByLastname() throws Exception {

        Collection<User> users = repository.findByLastname("Tarantino");

        assertNotNull(users);
        assertTrue(users.contains(user));
    }

    @Test
   	public void findByFirstnameOrLastname() throws Exception {

        Collection<User> users = repository.findByFirstnameOrLastname("Quentin");

   		assertTrue(users.contains(user));
   	}
}
