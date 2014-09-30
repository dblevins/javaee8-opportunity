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

import javax.ejb.EntityBean;

/**
 * CMP 2.0 EntityBeans, since 2001
 * Anyone who lives long enough will eventually become like their parents
 */
public abstract class SimpleConfiguration implements EntityBean {

    public SimpleConfiguration() {
    }

    public Long ejbCreate(String username, String firstname, String lastname) {
        this.setUsername(username);
        this.setFirstname(firstname);
        this.setLastname(lastname);
        return null;
    }

    public abstract Long getId();

    public abstract void setId(Long id);

    public abstract String getUsername();

    public abstract void setUsername(String username);

    public abstract String getFirstname();

    public abstract void setFirstname(String firstname);

    public abstract String getLastname();

    public abstract void setLastname(String lastname);
}
