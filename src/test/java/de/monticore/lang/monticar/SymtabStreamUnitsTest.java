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
package de.monticore.lang.monticar;

import de.monticore.ModelingLanguageFamily;
import de.monticore.io.paths.ModelPath;
import de.monticore.lang.monticar.streamunits._symboltable.ComponentStreamUnitsSymbol;
import de.monticore.lang.monticar.streamunits._symboltable.NamedStreamUnitsSymbol;
import de.monticore.lang.monticar.streamunits._symboltable.StreamUnitsLanguage;
import de.monticore.lang.monticar.streamunits._symboltable.StreamValuePrecision;
import de.monticore.symboltable.GlobalScope;
import de.monticore.symboltable.Scope;
import de.se_rwth.commons.logging.Log;
import org.junit.Ignore;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Sascha on 16.05.2017.
 */
public class SymtabStreamUnitsTest {
    protected static Scope createSymTab(String... modelPath) {
        ModelingLanguageFamily fam = new ModelingLanguageFamily();
        fam.addModelingLanguage(new StreamUnitsLanguage());
        final ModelPath mp = new ModelPath();
        for (String m : modelPath) {
            mp.addEntry(Paths.get(m));
        }
        GlobalScope scope = new GlobalScope(mp, fam);
        return scope;
    }

    @Test
    public void testResolveComponentStreamUnitsSymbol() {
        Scope symTab = createSymTab("src/test/resources/unitstreams/streams");
        Log.debug(symTab.toString(),"SymTab:");
        ComponentStreamUnitsSymbol comp = symTab.<ComponentStreamUnitsSymbol>resolve(
                "basicLibrary.AndTest", ComponentStreamUnitsSymbol.KIND).orElse(null);
        assertNotNull(comp);
    }

    @Test
    public void testResolveNamedStreamUnitsSymbol() {
        Scope symTab = createSymTab("src/test/resources/unitstreams/streams");

        NamedStreamUnitsSymbol namedStreamSymbol = symTab.<NamedStreamUnitsSymbol>resolve(
                "advancedLibrary.RSFlipFlopTest.In_S", NamedStreamUnitsSymbol.KIND).orElse(null);
        assertNotNull(namedStreamSymbol);
    }


    @Test
    public void testResolvePrecisionStreamUnit() {
        Scope symTab = createSymTab("src/test/resources/unitstreams/streams");

        NamedStreamUnitsSymbol namedStreamSymbol = symTab.<NamedStreamUnitsSymbol>resolve(
                "advancedLibrary.CounterTest.in1", NamedStreamUnitsSymbol.KIND).orElse(null);
        assertNotNull(namedStreamSymbol);
        assertEquals("1/2 ",((StreamValuePrecision)namedStreamSymbol.getValue(0)).getPrecision().toString());
    }

    @Ignore("ModelPath#resolveModel does not support loading a collection, which should be done when resolving many")
    @Test
    public void testResolveNamedManyStreamUnitsSymbol() {
        Scope symTab = createSymTab("src/test/resources/unitstreams/streams", "src/test/resources/unitstreams/streams2");

        Collection<NamedStreamUnitsSymbol> namedStreamSymbols = symTab.<NamedStreamUnitsSymbol>resolveMany(
                "advancedLibrary.RSFlipFlopTest.In_S", NamedStreamUnitsSymbol.KIND);
        assertEquals(2, namedStreamSymbols.size());
    }
}
