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
*/
package org.eclipse.daanse.xmla.model.record;

import java.util.Optional;

import org.eclipse.daanse.xmla.api.RequestMetaData;

public record RequestMetaDataR(Optional<String> userAgent, Optional<String> sessionId) implements RequestMetaData {

}
