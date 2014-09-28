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

import javax.ejb.embeddable.EJBContainer;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws Exception {

        EJBContainer.createEJBContainer(getOpts());

        // Log we're done
        Logger.getLogger(Microservice.class.getName()).log(Level.INFO, "Microservice STARTED");

        // Prevent the VM from exiting
        new Semaphore(0).acquire();
    }

    public static Map<?, ?> getOpts() throws IOException {
        final Properties properties = new Properties();
        properties.load(Main.class.getResourceAsStream("/META-INF/system.properties"));
        properties.putAll(System.getProperties());

        return properties;
    }
}
