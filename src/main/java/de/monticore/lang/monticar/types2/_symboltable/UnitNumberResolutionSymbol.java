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

import de.monticore.lang.monticar.si._symboltable.SIUnitKind;
import de.monticore.lang.monticar.types2._ast.ASTUnitNumberResolution;
import de.monticore.symboltable.CommonSymbol;
import de.monticore.symboltable.Scope;
import de.monticore.symboltable.types.JFieldSymbol;
import de.monticore.symboltable.types.JMethodSymbol;
import de.monticore.symboltable.types.JTypeSymbol;
import de.monticore.symboltable.types.references.JTypeReference;
import org.jscience.mathematics.number.Rational;
import siunit.monticoresiunit.si._ast.ASTUnitNumber;

import javax.measure.unit.Unit;
import java.util.List;
import java.util.Optional;

/**
 * @author Sascha
 */
public class UnitNumberResolutionSymbol extends CommonSymbol implements JTypeSymbol {
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


    //Methods below are required as this is a JTypeSymbol
    //TODO change methods if they are actually needed

    @Override
    public boolean isGeneric() {
        return false;
    }

    @Override
    public List<? extends JTypeSymbol> getFormalTypeParameters() {
        return null;
    }

    @Override
    public Optional<? extends JTypeReference<? extends JTypeSymbol>> getSuperClass() {
        return null;
    }

    @Override
    public List<? extends JTypeReference<? extends JTypeSymbol>> getInterfaces() {
        return null;
    }

    @Override
    public List<? extends JTypeReference<? extends JTypeSymbol>> getSuperTypes() {
        return null;
    }

    @Override
    public List<? extends JFieldSymbol> getFields() {
        return null;
    }

    @Override
    public Optional<? extends JFieldSymbol> getField(String s) {
        return null;
    }

    @Override
    public List<? extends JMethodSymbol> getMethods() {
        return null;
    }

    @Override
    public Optional<? extends JMethodSymbol> getMethod(String s) {
        return null;
    }

    @Override
    public List<? extends JMethodSymbol> getConstructors() {
        return null;
    }

    @Override
    public List<? extends JTypeSymbol> getInnerTypes() {
        return null;
    }

    @Override
    public Optional<? extends JTypeSymbol> getInnerType(String s) {
        return null;
    }

    @Override
    public boolean isAbstract() {
        return false;
    }

    @Override
    public boolean isFinal() {
        return false;
    }

    @Override
    public boolean isInterface() {
        return false;
    }

    @Override
    public boolean isEnum() {
        return false;
    }

    @Override
    public boolean isClass() {
        return true;
    }

    @Override
    public boolean isInnerType() {
        return false;
    }

    @Override
    public boolean isPrivate() {
        return false;
    }

    @Override
    public boolean isProtected() {
        return false;
    }

    @Override
    public boolean isPublic() {
        return false;
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
