/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.clases;

import com.globant.bootcamp.clases.Cart;
import com.globant.bootcamp.clases.Product;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristian
 */
public class CartTest {

    public CartTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGetProducts() {
        Cart c = new Cart();
        Product producto1 = new Product(1, "Harina", 1, 100);
        Product producto2 = new Product(2, "pan", 1, 80);
        c.addItem(producto1);
        c.addItem(producto2);
        int i = c.getList().size();
        assertEquals(i, c.getList().size(), 0);

    }

    @Test
    public void testGetTotalCost() {
        Cart c = new Cart();
        Product producto1 = new Product(1, "Harina", 1, 100);
        Product producto2 = new Product(2, "pan", 1, 80);
        c.addItem(producto1);
        c.addItem(producto2);
        float costo = 0;
        for (Product obj : c.getList()) {

            costo = costo + obj.getPrice();
        }

        assertEquals(costo, c.getTotalCost(), 0);
    }

    @Test
    public void testGetTotalCostError() {
        Cart c = new Cart();
        Product producto1 = new Product(1, "Harina", 1, 100);
        Product producto2 = new Product(2, "pan", 1, 80);
        c.addItem(producto1);
        c.addItem(producto2);
        float costo = 0;
        assertEquals(costo, c.getTotalCost(), 0);
    }

    @Test
    public void testGetProductsVoid() {
        Cart c = new Cart();
        Product producto1 = new Product(1, "Harina", 1, 100);
        int i = c.getList().size();
        assertEquals(2, i, 0);

    }

    @Test
    public void testGetProduct() {
        Cart c = new Cart();
        Product producto1 = new Product(1, "Harina", 1, 100);
        c.addItem(producto1);

        assertFalse(c.getList().contains(producto1));
    }

    @Test
    public void testGetProductError() {
        Cart c = new Cart();
        Product producto1 = new Product(1, "Harina", 1, 100);
        Product producto3 = new Product(3, "fideos", 1, 50);
        c.addItem(producto1);

        assertFalse(c.getList().contains(producto3));
    }

    /**
     * Test of borrarProducto method, of class CarritoApi.
     */
    @Test
    public void testDeleteProduct() {
        Cart c = new Cart();
        Product producto1 = new Product(1, "Harina", 1, 100);
        c.addItem(producto1);
        c.removeItem(producto1);
        assertFalse(c.getList().contains(producto1));
    }

    @Test
    public void testDeleteProductError() {
        Cart c = new Cart();
        Product producto1 = new Product(1, "Harina", 1, 100);
        c.addItem(producto1);
        //c.removeItem(producto1);
        assertFalse(c.getList().contains(producto1));
    }

    /**
     * Test of limpiarCarrito method, of class CarritoApi.
     */
    @Test
    public void testCleanCart() {
        Cart cd = new Cart();
        int test = cd.getList().size();
        int val = 0;
        //lista.add(producto1);
        /*Producto producto1 = new Producto(1,"Harina",1,100); 
        Producto producto2 = new Producto(2,"pan",1,80);
        c.addItem(producto2);*/

        assertEquals(val, test, 0);
    }

    @Test
    public void testCleanCartError() {
        Cart cd = new Cart();
        Product producto2 = new Product(2, "pan", 1, 80);
        cd.addItem(producto2);
        int test = cd.getList().size();
        int val = 0;
        assertEquals(val, test, 0);
    }

    /**
     * Test of guardarProducto method, of class CarritoApi.
     */
    @Test
    public void testSaveProduct() {
        Cart c = new Cart();
        Product producto2 = new Product(2, "pan", 1, 80);
        c.addItem(producto2);
        assertFalse(c.getList().contains(producto2));
    }

    @Test
    public void testSaveProductError() {
        Cart c = new Cart();
        Product producto2 = new Product(2, "pan", 1, 80);
        //c.addItem(producto2);
        assertFalse(c.getList().contains(producto2));
    }

}
