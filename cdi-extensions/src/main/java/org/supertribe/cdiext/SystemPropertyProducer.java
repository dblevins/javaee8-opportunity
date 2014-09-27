/* =====================================================================
 *
 * Copyright (c) 2011 David Blevins.  All rights reserved.
 *
 * =====================================================================
 */
package org.supertribe.cdiext;

import javax.enterprise.inject.Produces;
import java.io.File;
import java.net.URI;

public class SystemPropertyProducer {

    @Produces
    @PleaseAndThankYou("user.dir")
    public String userDir() {
        return System.getProperty("user.dir");
    }

    @Produces
    @PleaseAndThankYou("user.dir")
    public URI asUri() {
        return new File(System.getProperty("user.dir")).toURI();
    }

}
