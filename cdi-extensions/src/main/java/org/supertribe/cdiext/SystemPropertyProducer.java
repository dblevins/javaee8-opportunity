/* =====================================================================
 *
 * Copyright (c) 2011 David Blevins.  All rights reserved.
 *
 * =====================================================================
 */
package org.supertribe.cdiext;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URI;

public class SystemPropertyProducer {

    @Produces
    @PleaseAndThankYou("user.dir")
    public String userDir(final InjectionPoint injectionPoint) {

        return System.getProperty("user.dir");
    }

    @Produces
    @PleaseAndThankYou("user.dir")
    public URI asUri() {
        return new File(System.getProperty("user.dir")).toURI();
    }


    private PleaseAndThankYou getAnnotation(final InjectionPoint injectionPoint) {
        for (Annotation annotation : injectionPoint.getQualifiers()) {
            if (annotation instanceof PleaseAndThankYou) {
                return (PleaseAndThankYou) annotation;
            }
        }
        return null;
    }
}
