/*
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
package org.supertribe.dataish;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UsersTest {

    @EJB
    private Users repository;
    private User user;

    @Test
    public void findSavedUserById() throws Exception {

        assertUserEquals(user, repository.findByPrimaryKey(user.getId()));
    }

    @Test
    public void findSavedUserByLastname() throws Exception {

        List<User> users = repository.findByLastname("Tarantino");

        assertNotNull(users);
        assertUserEquals(user, users.get(0));
    }

    @Test
    public void findByFirstnameOrLastname() throws Exception {

        List<User> users = repository.findByFirstnameOrLastname("Quentin");

        assertNotNull(users);
        assertUserEquals(user, users.get(0));
    }

    private void assertUserEquals(final User actual, final User expected) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getLastname(), actual.getLastname());
        assertEquals(expected.getUsername(), actual.getUsername());
        assertEquals(expected.getFirstname(), actual.getFirstname());
    }

    @Before
    public void setup() throws Exception {
        bootstrap();

        user = repository.create("qtarantino", "Quentin", "Tarantino");
    }

    @After
    public void teardown() {
        for (final User user : repository.findAll()) {
            repository.removeUser(user);
        }
    }

    private void bootstrap() throws NamingException {
        final Properties p = new Properties();
        p.put("userDatabase", "new://Resource?type=DataSource");
        p.put("userDatabase.JdbcDriver", "org.hsqldb.jdbcDriver");
        p.put("userDatabase.JdbcUrl", "jdbc:hsqldb:mem:moviedb" + System.nanoTime());

        EJBContainer.createEJBContainer().getContext().bind("inject", this);
    }
}
