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
package org.supertribe.persistence.impl;


import org.supertribe.persistence.api.Find;
import org.supertribe.persistence.api.Merge;
import org.supertribe.persistence.api.QueryName;
import org.supertribe.persistence.api.Persist;
import org.supertribe.persistence.api.QueryParam;
import org.supertribe.persistence.api.Remove;
import org.supertribe.persistence.api.ValidationException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * Beautiful Source of DRY CRUD
 *
 * DRY: Don't Repeat Yourself
 * CRUD: Create Remove Update Delete
 *
 * @version $Revision$ $Date$
 */
public class PersistenceHandler {

    public static Object invoke(EntityManager em, Method method, Object[] args) throws Throwable {

        if (method.isAnnotationPresent(QueryName.class)) {

            return invokeNamedQuery(em, method, args);

        }

        if (method.isAnnotationPresent(Find.class)) {

            return findByPrimaryKey(em, method, args);

        }

        if (method.isAnnotationPresent(Merge.class)) {

            return merge(em, method, args);

        }

        if (method.isAnnotationPresent(Remove.class)) {

            return remove(em, method, args);

        }

        if (method.isAnnotationPresent(Persist.class)) {

            return persist(em, method, args);

        }

        throw new AbstractMethodError("No handler logic for method: " + method.toString());
    }

    /**
     * CREATE
     *
     * Persist the specified entity
     *
     * @param em
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public static Object persist(EntityManager em, Method method, Object[] args) throws Throwable {
        final Iterable<Parameter> params = Reflection.params(method, args);
        final Parameter parameter = params.iterator().next();

        if (parameter.getValue() == null)
            throw new ValidationException(parameter.getType().getSimpleName() + " object is null");

        em.persist(parameter.getValue());

        return parameter.getValue();
    }

    /**
     * READ:
     *
     * Find an entity by primary key
     *
     * @param em
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public static Object findByPrimaryKey(EntityManager em, Method method, Object[] args) throws Throwable {
        final Class<?> entityClass = method.getReturnType();
        final Object primaryKey = args[0];

        if (primaryKey == null) {
            throw new ValidationException("Invalid id");
        }
        return em.find(entityClass, primaryKey);
    }


    /**
     * READ:
     *
     * Execute a NamedQuery
     *
     * @param em
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public static Object invokeNamedQuery(EntityManager em, Method method, Object[] args) throws Throwable {
        final QueryName queryName = method.getAnnotation(QueryName.class);

        final TypedQuery<?> typedQuery = em.createNamedQuery(queryName.value(), getEntityType(method));

        for (Parameter parameter : Reflection.params(method, args)) {
            final QueryParam queryParam = parameter.getAnnotation(QueryParam.class);

            if (parameter.getValue() == null) {
                throw new ValidationException(queryParam.value() + " is null");
            }

            typedQuery.setParameter(queryParam.value(), parameter.getValue());
        }

        return (isList(method)) ? typedQuery.getResultList() : typedQuery.getSingleResult();
    }

    /**
     * UPDATE
     *
     * Perform a merge on the passed in entity
     *
     * @param em
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public static Object merge(EntityManager em, Method method, Object[] args) throws Throwable {
        final Iterable<Parameter> params = Reflection.params(method, args);
        final Parameter parameter = params.iterator().next();

        if (parameter.getValue() == null)
            throw new ValidationException(parameter.getType().getSimpleName() + " object is null");

        return em.merge(parameter.getValue());
    }

    /**
     * DELETE
     *
     * Remove the specified entity
     *
     * @param em
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public static Object remove(EntityManager em, Method method, Object[] args) throws Throwable {
        final Iterable<Parameter> params = Reflection.params(method, args);
        final Parameter parameter = params.iterator().next();

        if (parameter.getValue() == null)
            throw new ValidationException(parameter.getType().getSimpleName() + " object is null");

        em.remove(em.merge(parameter.getValue()));

        return null;
    }

    /**
     * Is the return value a list?
     * @param method
     * @return
     */
    private static boolean isList(Method method) {
        return Collection.class.isAssignableFrom(method.getReturnType());
    }

    /**
     * Determine the type of entity being returned
     * @param method
     * @return
     */
    private static Class<?> getEntityType(Method method) {
        if (isList(method)) {
            return Generics.getCollectionType(method.getGenericReturnType());
        } else {
            return method.getReturnType();
        }
    }

}
