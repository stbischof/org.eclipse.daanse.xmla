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

import java.util.List;

public interface Measure {

    String name();

    String id();

    String description();

    String aggregateFunction();

    String dataType();

    DataItem source();

    Boolean visible();

    String measureExpression();

    String displayFolder();

    String formatString();

    String backColor();

    String foreColor();

    String fontName();

    String fontSize();

    String fontFlags();

    List<Translation> translations();

    List<Annotation> annotations();
}
