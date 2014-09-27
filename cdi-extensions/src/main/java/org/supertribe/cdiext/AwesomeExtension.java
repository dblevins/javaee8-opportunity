/* =====================================================================
 *
 * Copyright (c) 2011 David Blevins.  All rights reserved.
 *
 * =====================================================================
 */
package org.supertribe.cdiext;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;


public class AwesomeExtension implements Extension {

    public void after(@Observes AfterBeanDiscovery annotatedType, BeanManager beanManager) {
        System.out.println(annotatedType);
    }

}
