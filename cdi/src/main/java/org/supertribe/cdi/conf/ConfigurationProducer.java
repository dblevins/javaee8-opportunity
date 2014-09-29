/* =====================================================================
 *
 * Copyright (c) 2011 David Blevins.  All rights reserved.
 *
 * =====================================================================
 */
package org.supertribe.cdi.conf;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

@ApplicationScoped
public class ConfigurationProducer {

    private final Properties properties = new Properties();

    public ConfigurationProducer() throws IOException {

        final String environment = System.getProperties().getProperty("environment", "test");

        final URL resource = this.getClass().getResource("/" + environment + ".properties");

        try (final InputStream inputStream = resource.openStream()) {
            properties.load(inputStream);
        }
    }

    @Produces
    @Configuration("")
    public String asString(final InjectionPoint injectionPoint) {

        final Configuration annotation = getAnnotation(injectionPoint, Configuration.class);

        final String value = annotation.value();

        return properties.getProperty(value);
    }

    @Produces
    @Configuration("")
    public URI asUri(final InjectionPoint injectionPoint) {
        return URI.create(asString(injectionPoint));
    }

    @Produces
    @Configuration("")
    public File asFile(final InjectionPoint injectionPoint) {
        return new File(asString(injectionPoint));
    }

    private <A extends Annotation> A getAnnotation(final InjectionPoint injectionPoint, final Class<A> clazz) {
        for (Annotation annotation : injectionPoint.getQualifiers()) {
            if (clazz.isAssignableFrom(annotation.annotationType())) {
                return (A) annotation;
            }
        }
        return null;
    }
}
