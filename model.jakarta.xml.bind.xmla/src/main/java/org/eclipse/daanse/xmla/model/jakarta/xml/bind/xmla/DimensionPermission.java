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
package org.eclipse.daanse.xmla.model.jakarta.xml.bind.xmla;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DimensionPermission", propOrder = { "attributePermissions", "allowedRowsExpression" })
public class DimensionPermission extends Permission {

    @XmlElement(name = "AttributePermission")
    @XmlElementWrapper(name = "AttributePermissions")
    protected List<AttributePermission> attributePermissions;
    @XmlElement(name = "AllowedRowsExpression", namespace = "http://schemas.microsoft"
            + ".com/analysisservices/2011/engine/300/300")
    protected String allowedRowsExpression;

    public List<AttributePermission> getAttributePermissions() {
        return attributePermissions;
    }

    public void setAttributePermissions(List<AttributePermission> value) {
        this.attributePermissions = value;
    }

    public String getAllowedRowsExpression() {
        return allowedRowsExpression;
    }

    public void setAllowedRowsExpression(String value) {
        this.allowedRowsExpression = value;
    }

}
