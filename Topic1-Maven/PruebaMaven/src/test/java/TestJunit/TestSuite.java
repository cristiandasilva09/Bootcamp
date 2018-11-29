/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestJunit;

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
 OperacionesTest.class,
  MyClassTest.class,
  IgnoreTest.class
})
public class TestSuite {
        public static void main(String[]args){
            System.out.println("5 tests en clase OPeraciones");
            System.out.println("1 test en clase MyClass");
            System.out.println("2 tests  ignorados en clase IgnoreTest");
        }
}
