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
package de.monticore.lang.monticar.helper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Sascha Schneiders
 */
public class IndentPrinterParameter {
    protected ArrayList<Object> params = new ArrayList<>();
    protected ArrayList<String> groups;

    protected IndentPrinterParameter(ArrayList<String> groups, Object... params) {
        this.groups = groups;
        for (Object p : params) {
            this.params.add(p);
        }
    }

    @Override
    public String toString() {
        return (new IndentPrinter.IndentPrinterHandler(groups, params, new LinkedHashMap<>()).toString());
    }

    public <A> IndentPrinter.IndentPrinterHandler handle(Class<? extends A> clazz, Function<A, String> handle1) {
        Map<Class, Function<Object, String>> map = new LinkedHashMap<>();
        map.put(clazz, (Function<Object, String>) handle1);
        return new IndentPrinter.IndentPrinterHandler(groups, params, map);
    }

//    public <A, B> IndentPrinterHandler handle(Supplier<A> handle1, Supplier<B> handle2) {
//      return new IndentPrinterHandler(groups, params, handle1, handle2);
//    }
}
