/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.TestJunit;

import java.util.logging.Logger;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Cristian
 */
// Suite nos permite crear un Array de clases de pruebas
// de esta manera no habrá que correr cada clase de manera individual
//basta con agregar "NombreClase".class y se agregara al arreglo de clses.
@RunWith(Suite.class)
@Suite.SuiteClasses({
 OperationsTest.class,
  MyClassTest.class,
  IgnoreTest.class
})
public class TestSuite {
        public static void main(String[]args){
        Logger log =  Logger.getLogger(TestSuite.class.toString());
            
            log.info("5 tests en clase OPeraciones");
            log.info("1 test en clase MyClass");
            log.info("2 tests  ignorados en clase IgnoreTest");
        }
}
