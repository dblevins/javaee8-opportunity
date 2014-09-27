/* =====================================================================
 *
 * Copyright (c) 2011 David Blevins.  All rights reserved.
 *
 * =====================================================================
 */
package org.supertribe.cdiext;

import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

public class AwesomeExtensionTest {

    @Inject
    private Application application;

    @Test
    public void test() throws Exception {
        EJBContainer.createEJBContainer().getContext().bind("inject", this);

        assertNotNull(application);
    }

}
