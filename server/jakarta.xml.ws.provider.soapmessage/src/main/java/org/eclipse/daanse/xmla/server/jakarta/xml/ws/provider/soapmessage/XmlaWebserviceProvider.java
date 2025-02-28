/*
* Copyright (c) 2023 Contributors to the Eclipse Foundation.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* Contributors:
*   SmartCity Jena - initial
*   Stefan Bischof (bipolis.org) - initial
*/
package org.eclipse.daanse.xmla.server.jakarta.xml.ws.provider.soapmessage;

import jakarta.annotation.Resource;
import jakarta.xml.soap.SOAPConstants;
import jakarta.xml.soap.SOAPException;
import jakarta.xml.soap.SOAPFactory;
import jakarta.xml.soap.SOAPFault;
import jakarta.xml.soap.SOAPMessage;
import jakarta.xml.ws.Provider;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.ServiceMode;
import jakarta.xml.ws.WebServiceContext;
import jakarta.xml.ws.WebServiceProvider;
import jakarta.xml.ws.handler.MessageContext;
import org.eclipse.daanse.jakarta.xml.ws.api.whiteboard.annotations.RequireSoapWhiteboard;
import org.eclipse.daanse.jakarta.xml.ws.api.whiteboard.prototypes.SOAPWhiteboardEndpoint;
import org.eclipse.daanse.xmla.api.XmlaService;
import org.eclipse.daanse.xmla.server.adapter.soapmessage.XmlaApiAdapter;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@WebServiceProvider()
@ServiceMode(value = Service.Mode.MESSAGE)
@RequireSoapWhiteboard
@Component(service = Provider.class)
@Designate(factory = true, ocd = XmlaWebserviceProvider.Config.class)
@SOAPWhiteboardEndpoint(contextpath = "xmla")
public class XmlaWebserviceProvider implements Provider<SOAPMessage> {
    private static final Logger LOGGER = LoggerFactory.getLogger(XmlaWebserviceProvider.class);
    private static final String USER_AGENT = "User-agent";

    @ObjectClassDefinition()
    @interface Config {

        @AttributeDefinition(required = true)
        String osgiSoapEndpointContextpath();
    }

    private XmlaApiAdapter wsAdapter;
    @Resource
    private WebServiceContext context;

    @Reference
    private XmlaService xmlaService;

    @Activate
    public void activate() {
        wsAdapter = new XmlaApiAdapter(xmlaService);
    }

    @Override
    public SOAPMessage invoke(SOAPMessage request) {

        Map<String, Object> headers = (Map<String, Object>) context.getMessageContext()
                .get(MessageContext.HTTP_REQUEST_HEADERS);

        LOGGER.debug("===== The provider got a request =====");
        return wsAdapter.handleRequest(request, headers);
    }

    private SOAPFault getFault(Exception ex) {
        try {
            SOAPFault fault = SOAPFactory.newInstance().createFault();
            fault.setFaultCode(SOAPConstants.SOAP_SENDER_FAULT);
            fault.setFaultString(ex.toString());
            return fault;
        } catch (SOAPException e) {
            throw new IllegalStateException(e);
        }
    }

}
