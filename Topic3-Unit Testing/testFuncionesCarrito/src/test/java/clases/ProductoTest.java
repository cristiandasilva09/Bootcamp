/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristian
 */
public class ProductoTest {
    
    public ProductoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

       @Test
    public void testModificarPrecioProducto() {
        Producto producto2 = new Producto(2,"pan",1,80);
       producto2.modificarPrecioProducto(producto2, 0);
        assertEquals(0,producto2.getPrecio(),0);
                
    }

   @Test
    public void testModificarPrecioProductoError() {
       Producto producto2 = new Producto(2,"pan",1,80);
      Producto producto5 = new Producto(5,"desodorante",2,80);
       producto2.modificarPrecioProducto(producto2, 0);
        assertEquals(producto5.getPrecio(),producto2.getPrecio(),0);
    }
  /*  @Test 
    public void testModificarProducto(){
     Producto producto2 = new Producto(2,"pan",1,80);
     Producto producto5 = new Producto(5,"desodorante",2,80);
     producto5.modificarProducto(producto5, "pan", 1,80);
     if(producto2.equals(producto5))   
     fail("Los productos son diferentes");
    }
    @Test 
    public void testModificarProductoError(){
     Producto producto2 = new Producto(2,"pan",1,80);
     Producto producto5 = new Producto(5,"desodorante",2,80);
     producto5.modificarProducto(producto5, "pan", 3,150);
     if(!producto2.equals(producto5))   
     fail("Los productos son diferentes");
    }*/
    
}
