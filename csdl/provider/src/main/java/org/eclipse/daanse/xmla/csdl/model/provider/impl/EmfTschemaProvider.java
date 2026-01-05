/*
 * Copyright (c) 2026 Contributors to the Eclipse Foundation.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *
 */
package org.eclipse.daanse.xmla.csdl.model.provider.impl;

import java.io.IOException;
import java.util.Map;

import org.eclipse.daanse.xmla.csdl.model.provider.Constants;
import org.eclipse.daanse.xmla.csdl.model.provider.EmfTschemaProviderConfig;
import org.eclipse.daanse.xmla.csdl.model.provider.OlapTSchemaSupplier;
import org.eclipse.daanse.xmla.csdl.model.v2.edm.EdmPackage;
import org.eclipse.daanse.xmla.csdl.model.v2.edm.TSchema;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.gecko.emf.osgi.constants.EMFNamespaces;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = OlapTSchemaSupplier.class, scope = ServiceScope.SINGLETON, configurationPid = Constants.PID_EMF_TSCHEMA_PROVIDER)
@Designate(factory = true, ocd = EmfTschemaProviderConfig.class)
public class EmfTschemaProvider implements OlapTSchemaSupplier {

    @Reference(target = "(" + EMFNamespaces.EMF_MODEL_NAME + "=" + EdmPackage.eNAME + ")")
    private ResourceSet resourceSet;

    private TSchema tSchema;

    @Activate
    public void activate(EmfTschemaProviderConfig config) throws IOException {

        String url = config.resource_url();

        URI uri = URI.createFileURI(url);
        Resource resource = resourceSet.getResource(uri, true);
        resource.load(Map.of());
        EcoreUtil.resolveAll(resource);
        EList<EObject> contents = resource.getContents();

        for (EObject eObject : contents) {
            if (eObject instanceof TSchema rcm) {
                tSchema = rcm;
            }
        }

    }

    @Deactivate
    public void deactivate() {
        cleanAllResources();
    }

    @Override
    public TSchema get() {
        return tSchema;
    }

    private void cleanAllResources() {
        resourceSet.getResources().forEach(Resource::unload);
    }
}
