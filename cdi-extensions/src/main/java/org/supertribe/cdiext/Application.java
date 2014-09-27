/* =====================================================================
 *
 * Copyright (c) 2011 David Blevins.  All rights reserved.
 *
 * =====================================================================
 */
package org.supertribe.cdiext;

import javax.inject.Inject;
import java.net.URI;

public class Application {

    @Inject
    @PleaseAndThankYou("user.dir")
    private URI uri;

    @Inject
    @PleaseAndThankYou("user.dir")
    private String string;

    public URI getUri() {
        return uri;
    }

    public String getMessage() {
        return "Hello";
    }
}
