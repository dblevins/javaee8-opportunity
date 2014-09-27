/* =====================================================================
 *
 * Copyright (c) 2011 David Blevins.  All rights reserved.
 *
 * =====================================================================
 */
package org.supertribe.cdiext;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;


public class AwesomeExtension implements Extension {

    public void observe(@Observes BeforeBeanDiscovery discovery) {
//        System.out.println(discovery);
//
//
//        discovery.
    }


}
