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
package org.eclipse.daanse.xmla.api.common.enums;

import java.util.stream.Stream;

/**
 * The context for the set. The set can be static or dynamic.
 */
public enum SetEvaluationContextEnum {

    STATIC(1),

    DYNAMIC(2);

    private final int value;

    SetEvaluationContextEnum(int v) {
        this.value = v;
    }

    public int getValue() {
        return value;
    }

    public static SetEvaluationContextEnum fromValue(String v) {
        if (v == null) {
            return null;
        }
        int vi = Integer.parseInt(v);
        return Stream.of(SetEvaluationContextEnum.values()).filter(e -> (e.value == vi)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        new StringBuilder("SetEvaluationContextEnum Illegal argument ").append(v).toString()));
    }
}
