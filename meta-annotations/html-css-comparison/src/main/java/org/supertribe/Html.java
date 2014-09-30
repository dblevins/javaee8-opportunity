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
package org.supertribe;

import org.supertribe.style.Margin;
import org.supertribe.style.Width;

@org.supertribe.style.Lang("en")
public class Html {


    @org.supertribe.style.Font(size = 12, weight = "normal", family = {"'Helvetica Neue'", "Helvetica", "Arial", "sans-serif"})
    @Margin(left = 0, right = 0, top = 0, bottom = 0)
    @org.supertribe.style.Background("#FFFFFF")
    public void body() {
    }

    @org.supertribe.style.Font(size = 40)
    @org.supertribe.style.Width("1000px")
    public void title() {
    }

    @org.supertribe.style.Font(size = 12)
    @org.supertribe.style.Width("100%")
    @org.supertribe.style.Height("19px")
    public void table() {
    }

    @org.supertribe.style.Font(size = 15)
    @org.supertribe.style.Width("100%")
    @org.supertribe.style.Height("19px")
    public void row1() {
    }

    @org.supertribe.style.Font(size = 15)
    @org.supertribe.style.Width("100%")
    @org.supertribe.style.Height("19px")
    public void row2() {
    }

    @Font(size = 15)
    @Width("100%")
    @Height("19px")
    public void row3() {
    }
}
