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
import java.util.Optional;

/**
 * This complex type represents an Action in a Perspective.
 */
public interface PerspectiveAction {

    /**
     * @return The ID of the Action.
     */
    String actionID();

    /**
     * @return A collection of Annotation objects.
     */
    Optional<List<Annotation>> annotations();

}
