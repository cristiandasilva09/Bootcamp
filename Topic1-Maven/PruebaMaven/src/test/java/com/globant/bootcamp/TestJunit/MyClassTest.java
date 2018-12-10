/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.TestJunit;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

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
    assertTrue(x<=100);
  }


    
}
