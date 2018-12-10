/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.clases;

import com.globant.bootcamp.clases.Product;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristian
 */
public class ProductTest {
    
    public ProductTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

       @Test
    public void testChangeProductPrice() {
        Product producto2 = new Product(2,"pan",1,80);
       producto2.changeProductPrice(producto2, 0);
        assertEquals(0,producto2.getPrice(),0);
                
    }

   @Test
    public void testChangeProductPriceError() {
       Product producto2 = new Product(2,"pan",1,80);
      Product producto5 = new Product(5,"desodorante",2,80);
       producto2.changeProductPrice(producto2, 0);
        assertEquals(producto5.getPrice(),producto2.getPrice(),0);
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
