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
package org.supertribe.embedded.rest;

import javax.ejb.Lock;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

import static javax.ejb.LockType.READ;

@Path("/api")
@Singleton
@Lock(READ)
public class Microservice {

    @GET
    @Path("/messages")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getMessages() {
        return Arrays.asList(

                "\"Go after your dreams, there is going to be technology behind it\" says @eyeseewaters at #Devoxx4Kids #JavaOne",

                "#Devoxx4Kids stickers ready for #JavaOne. 150 kids, Is it the biggest kid+technology focused event in the USA?",

                "Today is #Devoxx4kids day in San Francisco together with Oracle, JavaOne, and 150 kids... expect more tweets :)"
        );
    }

}
