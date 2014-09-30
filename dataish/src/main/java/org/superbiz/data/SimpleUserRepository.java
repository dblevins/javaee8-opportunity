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

import org.fullcircle.data.api.CrudRepository;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import java.util.Collection;
import java.util.List;

@javax.ejb.Singleton
public abstract class SimpleUserRepository {

    /**
     * Find the user with the given username. This method will be translated into a query using the
     * {@link javax.persistence.NamedQuery} annotation at the {@link User} class.
     *
     * @param lastname
     * @return
     */
    public User findByTheUsersName(String username);

    /**
     * Find all users with the given lastname. This method will be translated into a query by constructing it directly
     * from the method name as there is no other query declared.
     *
     * @param lastname
     * @return
     */
    public List<User> findByLastname(String lastname);

    /**
     * Returns all users with the given firstname. This method will be translated into a query using the one declared in
     * the {@link org.fullcircle.data.api.Query} annotation declared one.
     *
     * @param firstname
     * @return
     */
    public List<User> findByFirstname(String firstname);

    /**
     * Returns all users with the given name as first- or lastname. Makes use of the {@link org.fullcircle.data.api.Param} annotation to use named
     * parameters in queries. This makes the query to method relation much more refactoring safe as the order of the
     * method parameters is completely irrelevant.
     *
     * @param name
     * @return
     */
    public List<User> findByFirstnameOrLastname(String name) {
        final List<User> users = new ArrayList<User>();
        users.addAll(findByFirstname(name));
        users.addAll(findByLastname(name));
    };

    public User create(String username, String firstname, String lastname) {
        return create(new User())
    };

    public User create(User user) {

    };

    User findByPrimaryKey(Long primarykey) throws FinderException;

    Collection<User> findAll() throws FinderException;

}
