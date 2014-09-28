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

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import java.util.Collection;

/**
 * Simple repository interface for {@link User} instances. The interface is used to declare so called query methods,
 * methods to retrieve single entities or collections of them.
 *
 * @author David Blevins
 */
interface SimpleUserRepository extends CrudRepository<User, Long> {

    /**
     * Find the user with the given username. This method will be translated into a query using the
     * {@link javax.persistence.NamedQuery} annotation at the {@link User} class.
     *
     * @param lastname
     * @return
     */
    User findByTheUsersName(String username) throws FinderException;

    /**
     * Find all users with the given lastname. This method will be translated into a query by constructing it directly
     * from the method name as there is no other query declared.
     *
     * @param lastname
     * @return
     */
    Collection<User> findByLastname(String lastname) throws FinderException;

    /**
     * Returns all users with the given firstname. This method will be translated into a query using the one declared in
     * the {@link Query} annotation declared one.
     *
     * @param firstname
     * @return
     */
    Collection<User> findByFirstname(String firstname) throws FinderException;

    /**
     * Returns all users with the given name as first- or lastname. Makes use of the {@link Param} annotation to use named
     * parameters in queries. This makes the query to method relation much more refactoring safe as the order of the
     * method parameters is completely irrelevant.
     *
     * @param name
     * @return
     */
    Collection<User> findByFirstnameOrLastname(String name) throws FinderException;

    User create(String username, String firstname, String lastname) throws CreateException;

    User findByPrimaryKey(Long primarykey) throws FinderException;

    Collection<User> findAll() throws FinderException;

}
