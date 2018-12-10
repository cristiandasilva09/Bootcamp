/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.TestJunit;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Cristian
 */
public class OperationsTest {

    private Operations operations;

    public OperationsTest() {
    }

    //@Before marca un método que se ejecuta siempre antes que cualquier test
    //de esta manera no necesitamos instanciar un objeto operaciones
    //para cada test
    @Before
    public void init() {
        operations = new Operations();
    }
    //@After nos premite realizar tareas de limpieza
    //después de realizar cada uno de los test.   

    @After
    public void finish() {
        operations = null;
    }

    /**
     * Test of suma method, of class Operaciones.
     */
    @Test
    public void testSuma() {
        //assertEquals(valorEsperado, valorReal, error) 
        //compara el valor esperado con el real dentro de un error.
        assertEquals(2, operations.sum(1, 1), 0);

    }

    /**
     * Test of resta method, of class Operaciones.
     */
    @Test
    public void testSubstract() {

        assertEquals(2, operations.substract(3, 1), 0);

    }

    /**
     * Test of multiplicacion method, of class Operaciones.
     */
    @Test
    public void testmMltiplication() {

        assertEquals(6, operations.multiplication(3, 2), 0);
    }

    /**
     * Test of division method, of class Operaciones.
     */
    @Test
    public void testDivision() {

        assertEquals(5, operations.division(10, 2), 0);
    }

    /**
     * Test of getUltimaResultado method, of class Operaciones.
     */
    @Test
    public void testGetLastResult() {
        float expResult = 0.0F;
        float result = operations.getLastResult();
        assertEquals(expResult, result, 0.0);
        if (expResult != result) {
            //fail indica cuando el test tuvo algun fallo 
            fail("The test case is a prototype.");
        }
    }

}
