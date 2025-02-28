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
package org.eclipse.daanse.xmla.api.xmla;

import java.util.Optional;

/**
 * This complex type represents a binding to a DimensionAttribute.
 */
public interface AttributeBinding extends Binding {

    /**
     * @return The ID of the Attribute.
     */
    String attributeID();

    /**
     * @return Indicates the part of the Attribute to bind to. Enumeration values are as follows: All:
     *         All Level Key: Member keys Name: Member name Value: Member value Translation: Member
     *         translations UnaryOperator: Unary operators SkippedLevels: Skipped levels CustomRollup:
     *         Custom rollup formulas CustomRollupProperties: Custom rollup properties
     */
    AttributeBindingTypeEnum type();

    /**
     * @return When the binding is to a collection of objects, the ordinal indicates the ordinal number
     *         within that collection to bind to. (Applies to KeyColumns and Translation objects).
     */
    Optional<Integer> ordinal();
}
