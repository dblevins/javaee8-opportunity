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
package org.superbiz.embedded;

import org.junit.Assert;
import org.junit.Test;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MicroserviceTest {

    @EJB
    private Microservice microservice;

    @Test
    public void test() throws Exception {

        EJBContainer.createEJBContainer(Main.getOpts()).getContext().bind("inject", this);

        Assert.assertNotNull(microservice);


        final String expected = "" +
                "[\"\\\"Go after your dreams, there is going to be technology behind it\\\" says @eyeseewaters at #Devoxx4Kids #JavaOne\"," +
                "" +
                "\"#Devoxx4Kids stickers ready for #JavaOne. 150 kids, Is it the biggest kid+technology focused event in the USA?\"," +
                "" +
                "\"Today is #Devoxx4kids day in San Francisco together with Oracle, JavaOne, and 150 kids... expect more tweets :)\"]";

        final String actual = get("http://127.0.0.1:4204/microservice/api/messages");

        Assert.assertEquals(expected, actual);

    }

    private static String get(final String spec) throws IOException {
        final URL url = new URL(spec);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final byte[] buffer = new byte[1024];
        int length;

        try (final InputStream inputStream = url.openStream()) {

            while ((length = inputStream.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }

            out.flush();
        }

        return new String(out.toByteArray());
    }
}
