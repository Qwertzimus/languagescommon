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
//package de.monticore.lang.montiarc;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import de.monticore.lang.monticar.helper.SIPrinter;
//import de.monticore.lang.monticar.si._ast.ASTEMAUnit;
//import de.monticore.lang.monticar.si._parser.SIParser;
//import org.junit.Test;
//
///**
// * Created by MichaelvonWenckstern on 27.01.2017.
// */
//public class SIPrinterTest {
//  @Test
//  public void testKm() throws Exception {
//    SIParser parser = new SIParser();
//    ASTEMAUnit astUnit = parser.parseString_EMAUnit("km").orElse(null);
//    assertNotNull(astUnit);
//    assertEquals("km", SIPrinter.printUnitAST(astUnit));
//  }
//
//  @Test
//  public void testKmPerHour() throws Exception {
//    SIParser parser = new SIParser();
//    ASTEMAUnit astUnit = parser.parseString_EMAUnit("km/h").orElse(null);
//    assertNotNull(astUnit);
//    assertEquals("km/h", SIPrinter.printUnitAST(astUnit));
//  }
//
//  @Test
//  public void testVoltTimesAmpere() throws Exception {
//    SIParser parser = new SIParser();
//    ASTEMAUnit astUnit = parser.parseString_EMAUnit("V*A").orElse(null);
//    assertNotNull(astUnit);
//    assertEquals("V*A", SIPrinter.printUnitAST(astUnit));
//  }
//
//  @Test
//  public void testSquareMeter() throws Exception {
//    SIParser parser = new SIParser();
//    ASTEMAUnit astUnit = parser.parseString_EMAUnit("m^2").orElse(null);
//    assertNotNull(astUnit);
//    assertEquals("m^2", SIPrinter.printUnitAST(astUnit));
//  }
//
//  @Test
//  public void testKgTimesSquareMeterDividedByCubicSeconds() throws Exception {
//    SIParser parser = new SIParser();
//    ASTEMAUnit astUnit = parser.parseString_EMAUnit("kg*m^2/s^3").orElse(null);
//    assertNotNull(astUnit);
//    assertEquals("kg*m^2/s^3", SIPrinter.printUnitAST(astUnit));
//  }
//
//  @Test
//  public void testAccelerationNegExponent() throws Exception {
//    SIParser parser = new SIParser();
//    ASTEMAUnit astUnit = parser.parseString_EMAUnit("m*s^-2").orElse(null);
//    assertNotNull(astUnit);
//    assertEquals("m*s^-2", SIPrinter.printUnitAST(astUnit));
//  }
//
//  @Test
//  public void testNegExponent() throws Exception {
//    SIParser parser = new SIParser();
//    ASTEMAUnit astUnit = parser.parseString_EMAUnit("m/s^-2").orElse(null);
//    assertNotNull(astUnit);
//    assertEquals("m/s^-2", SIPrinter.printUnitAST(astUnit));
//  }
//}
