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
package org.eclipse.daanse.xmla.model.record.discover.mdschema.members;

import java.util.Optional;

import org.eclipse.daanse.xmla.api.common.enums.CubeSourceEnum;
import org.eclipse.daanse.xmla.api.common.enums.MemberTypeEnum;
import org.eclipse.daanse.xmla.api.common.enums.TreeOpEnum;
import org.eclipse.daanse.xmla.api.discover.mdschema.members.MdSchemaMembersRestrictions;

public record MdSchemaMembersRestrictionsR(Optional<String> catalogName, Optional<String> schemaName,
        Optional<String> cubeName, Optional<String> dimensionUniqueName, Optional<String> hierarchyUniqueName,
        Optional<String> levelUniqueName, Optional<Integer> levelNumber, Optional<String> memberName,
        Optional<String> memberUniqueName, Optional<MemberTypeEnum> memberType, Optional<String> memberCaption,
        Optional<CubeSourceEnum> cubeSource, Optional<TreeOpEnum> treeOp) implements MdSchemaMembersRestrictions {
}
