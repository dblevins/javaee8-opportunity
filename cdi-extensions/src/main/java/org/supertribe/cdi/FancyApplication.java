/* =====================================================================
 *
 * Copyright (c) 2011 David Blevins.  All rights reserved.
 *
 * =====================================================================
 */
package org.supertribe.cdi;

import org.supertribe.cdi.conf.Configuration;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URI;

public class FancyApplication {

    @Inject
    @Configuration("java.vendor.url")
    private URI javaVendor;

    @Inject
    @Configuration("user.name")
    private String user;

    public URI getJavaVendor() {
        return javaVendor;
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return "Hello";
    }


    public static void main(String[] args) throws IOException {
        System.getProperties().store(System.out, "");
    }

}
