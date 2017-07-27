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
/* generated from model null*/
/* generated by template symboltable.Symbol*/



package de.monticore.lang.monticar.stream._symboltable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class NamedStreamSymbol extends NamedStreamSymbolTOP {

  protected boolean expected = true;
  protected int id = 0;

  protected NamedStreamSymbol(String name) {
    super(name);
  }

  public NamedStreamSymbol(String name, int id) {
    super(name);
    this.id = id;
  }

  public NamedStreamSymbol(String name, int id, boolean expected, final Collection<Object> timedValues) {
    this(name, id);
    this.expected = expected;
    this.timeValues.addAll(timedValues);
  }

  protected List<Object> timeValues = new ArrayList<>();

  public void add(Object value) {
    timeValues.add(value);
  }

  public Object getValue(int index) {
    return timeValues.get(index);
  }

  public int getValueSize() {
    return timeValues.size();
  }

  public Stream<Object> stream() {
    return timeValues.stream();
  }

  /**
   * all stream.nonunitstreams.streams defined in one file have the same id,
   * so that you can match the input stream.nonunitstreams.streams to the corresponding
   * output stream.nonunitstreams.streams if several test cases are defined
   * @return
   */
  public int getId() {
    return this.id;
  }

  /**
   * it says whether the stream is expected (e.g. as an assert of an test)
   * or whether the stream is the result of a simulation
   * @return true if it is expected in an test; false if it is the result of a simulation
   */
  public boolean isExpected() {
    return expected;
  }

}
