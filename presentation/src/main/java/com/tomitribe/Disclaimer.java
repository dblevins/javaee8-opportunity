/*
 * Tomitribe Confidential
 *
 * Copyright Tomitribe Corporation. 2014
 *
 * The source code for this program is not published or otherwise divested 
 * of its trade secrets, irrespective of what has been deposited with the 
 * U.S. Copyright Office.
 */
package com.tomitribe;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.Startup;

import static javax.ejb.LockType.READ;

@Startup
@Lock(READ)
public class Disclaimer {

    @PostConstruct
    public void coverEverything() {

        throw new TopicTooLargeException();

    }
}
