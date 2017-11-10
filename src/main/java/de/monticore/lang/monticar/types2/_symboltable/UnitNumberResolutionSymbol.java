/**
 *
 *  ******************************************************************************
 *  MontiCAR Modeling Family, www.se-rwth.de
 *  Copyright (c) 2017, Software Engineering Group at RWTH Aachen,
 *  All rights reserved.
 *
 *  This project is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 3.0 of the License, or (at your option) any later version.
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this project. If not, see <http://www.gnu.org/licenses/>.
 * *******************************************************************************
 */
package de.monticore.lang.monticar.types2._symboltable;

import de.monticore.lang.monticar.ts.MCTypeSymbol;
import de.monticore.lang.monticar.ts.references.MCTypeReference;
import de.monticore.lang.monticar.types2._ast.ASTUnitNumberResolution;
import de.monticore.symboltable.CommonSymbol;
import de.monticore.symboltable.Scope;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Sascha
 */
public class UnitNumberResolutionSymbol extends CommonSymbol implements MCTypeSymbol {
    public static final UnitNumberResolutionKind KIND = UnitNumberResolutionKind.INSTANCE;

    ASTUnitNumberResolution unitNumberResolution;

    protected UnitNumberResolutionSymbol(String name, ASTUnitNumberResolution astUnitNumberResolution) {
        super(name, KIND);
        this.unitNumberResolution = astUnitNumberResolution;
    }

    public void setUnitNumberResolution(ASTUnitNumberResolution unitNumberResolution) {
        this.unitNumberResolution = unitNumberResolution;
    }

    public ASTUnitNumberResolution getUnitNumberResolution() {
        return unitNumberResolution;
    }

    @Override
    public List<? extends MCTypeSymbol> getFormalTypeParameters() {
        return Collections.emptyList();
    }

    @Override
    public Optional<? extends MCTypeReference<? extends MCTypeSymbol>> getSuperClass() {
        return Optional.empty();
    }

    @Override
    public List<? extends MCTypeReference<? extends MCTypeSymbol>> getInterfaces() {
        return Collections.emptyList();
    }

    @Override
    public List<? extends MCTypeReference<? extends MCTypeSymbol>> getSuperTypes() {
        return Collections.emptyList();
    }

    @Override
    public boolean isFormalTypeParameter() {
        return false;
    }

    @Override
    public Scope getSpannedScope() {
        return null;
    }
}
