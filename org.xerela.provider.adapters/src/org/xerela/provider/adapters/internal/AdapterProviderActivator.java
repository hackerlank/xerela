/*
 * The contents of this file are subject to the Mozilla Public License
 * Version 1.1 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 * 
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 * 
 * The Original Code is Ziptie Client Framework.
 * 
 * The Initial Developer of the Original Code is AlterPoint.
 * Portions created by AlterPoint are Copyright (C) 2006,
 * AlterPoint, Inc. All Rights Reserved.
 * 
 * Contributor(s):
 */

package org.xerela.provider.adapters.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.xerela.net.adapters.IAdapterService;
import org.xerela.provider.adapters.AdapterProvider;
import org.xerela.provider.adapters.IAdapterProvider;

/**
 * AdapterProviderActivator
 */
public class AdapterProviderActivator implements BundleActivator
{
    private static AdapterProvider adapters;
    private static ServiceTracker adapterTracker;

    private ServiceRegistration registration;

    /** {@inheritDoc} */
    public void start(BundleContext context) throws Exception
    {
        adapterTracker = new ServiceTracker(context, IAdapterService.class.getName(), null);
        adapterTracker.open();

        adapters = new AdapterProvider();
        registration = context.registerService(IAdapterProvider.class.getName(), adapters, null);
    }

    /** {@inheritDoc} */
    public void stop(BundleContext context) throws Exception
    {
        registration.unregister();

        adapters = null;

        adapterTracker.close();
        adapterTracker = null;
    }

    /**
     * Get the adapter provider singleton.
     * @return The adapter provider instance.
     */
    public static IAdapterProvider getAdapterProvider()
    {
        return adapters;
    }

    /**
     * Lookup the adapter service.
     * @return the adapter service.
     */
    public static IAdapterService getAdapterService()
    {
        return (IAdapterService) adapterTracker.getService();
    }
}
