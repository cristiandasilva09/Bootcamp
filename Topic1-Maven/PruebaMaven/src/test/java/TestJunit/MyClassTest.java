/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestJunit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristian
 */
public class MyClassTest {
    
    public MyClassTest() {
    }
@Test
  public void testmultiplicacion() {
    MyClass tester = new MyClass();
    int x=99;
    int y =5;
    if(x>100){
        fail("X no puede ser mayor a 100");
    }
    tester.multiplicacion(x, y);
  }


    
}
