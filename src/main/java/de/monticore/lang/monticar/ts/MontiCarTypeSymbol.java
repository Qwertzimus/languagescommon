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
package de.monticore.lang.monticar.ts;

import de.monticore.lang.monticar.ts.references.MontiCarTypeSymbolReference;
import de.monticore.symboltable.SymbolKind;

public class MontiCarTypeSymbol extends CommonMCTypeSymbol<MontiCarTypeSymbol, MontiCarTypeSymbolReference> {

    public static final MontiCarTypeSymbolKind KIND = new MontiCarTypeSymbolKind();

    public MontiCarTypeSymbol(String name) {
        this(name, MontiCarTypeSymbol.KIND);
    }

    protected MontiCarTypeSymbol(String name, MCTypeSymbolKind typeKind) {
        super(name, typeKind);
    }

    public static class MontiCarTypeSymbolKind extends MCTypeSymbolKind {

        private static final String NAME = MontiCarTypeSymbolKind.class.getCanonicalName();

        protected MontiCarTypeSymbolKind() {
        }

        @Override
        public String getName() {
            return NAME;
        }

        @Override
        public boolean isKindOf(SymbolKind kind) {
            return NAME.equals(kind.getName()) || super.isKindOf(kind);
        }
    }
}
