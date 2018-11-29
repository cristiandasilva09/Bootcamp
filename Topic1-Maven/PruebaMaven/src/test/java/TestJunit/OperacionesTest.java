/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestJunit;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Cristian
 */

public class OperacionesTest {
    private Operaciones operaciones;
 
    public OperacionesTest() {
    }
    //@Before marca un método que se ejecuta siempre antes que cualquier test
    //de esta manera no necesitamos instanciar un objeto operaciones
    //para cada test
    @Before
   public void init() {
        operaciones = new Operaciones();
    }
     //@After nos premite realizar tareas de limpieza
     //después de realizar cada uno de los test.   
     @After
    public void finish() {
        operaciones = null;
    }
    /**
     * Test of suma method, of class Operaciones.
     */
    @Test
    public void testSuma() {
        System.out.println("suma");
        //assertEquals(valorEsperado, valorReal, error) 
        //compara el valor esperado con el real dentro de un error.
        assertEquals(2,operaciones.suma(1, 1), 0);
        
    }

    /**
     * Test of resta method, of class Operaciones.
     */
    @Test
    public void testResta() {
        
        assertEquals(2,operaciones.resta(3, 1), 0);
       
        }

    /**
     * Test of multiplicacion method, of class Operaciones.
     */
    @Test
    public void testMultiplicacion() {
  
        assertEquals(6,operaciones.multiplicacion(3, 2), 0);
        }
    

    /**
     * Test of division method, of class Operaciones.
     */
    @Test
    public void testDivision() {
        System.out.println("division");
      
        assertEquals(5,operaciones.division(10, 2), 0);
    }

    /**
     * Test of getUltimaResultado method, of class Operaciones.
     */
    @Test
    public void testGetUltimaResultado() {
        System.out.println("getUltimaResultado");
        float expResult = 0.0F;
        float result = operaciones.getUltimaResultado();
        assertEquals(expResult, result, 0.0);
       if(expResult!=result){
           //fail indica cuando el test tuvo algun fallo 
           fail("The test case is a prototype.");
        }
    }
    
}
