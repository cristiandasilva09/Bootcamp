/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristian
 */
public class CarritoTest {
    
    public CarritoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

     @Test
    public void testGetProductos() {
        Carrito c = new Carrito();
        Producto producto1 = new Producto(1,"Harina",1,100);
        Producto producto2 = new Producto(2,"pan",1,80);
        c.addItem(producto1);
        c.addItem(producto2);
        int i=c.getLista().size();
        assertEquals(i,c.getLista().size(),0);
        
    }
    @Test 
    public void testGetCostoTotal(){
            Carrito c = new Carrito();
        Producto producto1 = new Producto(1,"Harina",1,100);
        Producto producto2 = new Producto(2,"pan",1,80);
        c.addItem(producto1);
        c.addItem(producto2);
        float costo=0;
        for(Producto obj:c.getLista()){
         
         costo=costo+obj.getPrecio();
     }

        assertEquals(costo,c.getCostoTotal(),0);
    }
       @Test 
    public void testGetCostoTotalError(){
            Carrito c = new Carrito();
        Producto producto1 = new Producto(1,"Harina",1,100);
        Producto producto2 = new Producto(2,"pan",1,80);
        c.addItem(producto1);
        c.addItem(producto2);
        float costo=0;
        assertEquals(costo,c.getCostoTotal(),0);
    }
    
     @Test
    public void testGetProductosVacio() {
        Carrito c = new Carrito();
        Producto producto1 = new Producto(1,"Harina",1,100);
          int i=c.getLista().size();
        assertEquals(2,i,0);
        
    }
    


    @Test
    public void testGetProducto() {
        Carrito c = new Carrito();
        Producto producto1 = new Producto(1,"Harina",1,100);
         c.addItem(producto1);
         
        if(c.getLista().contains(producto1)==false)
        fail("La lista no contiene el producto");
    }
    @Test
    public void testGetProductoError() {
        Carrito c = new Carrito();
        Producto producto1 = new Producto(1,"Harina",1,100);
         Producto producto3 = new Producto(3,"fideos",1,50);
         c.addItem(producto1);
         
        if(c.getLista().contains(producto3)==false)
        fail("La lista no contiene el producto");
    }
    

    /**
     * Test of borrarProducto method, of class CarritoApi.
     */
    @Test
    public void testBorrarProducto() {
        Carrito c = new Carrito();
        Producto producto1 = new Producto(1,"Harina",1,100);
         c.addItem(producto1);
         c.removeItem(producto1);
        if(c.getLista().contains(producto1))
        fail("El producto sigue estando en el carrito");
    }
    @Test
    public void testBorrarProductoError() {
        Carrito c = new Carrito();
        Producto producto1 = new Producto(1,"Harina",1,100);
         c.addItem(producto1);
         //c.removeItem(producto1);
        if(c.getLista().contains(producto1))
        fail("El producto sigue estando en el carrito");
    }

    /**
     * Test of limpiarCarrito method, of class CarritoApi.
     */
    @Test
    public void testLimpiarCarrito() {
          Carrito cd = new Carrito();
          int test = cd.getLista().size();
          int val=0;
        //lista.add(producto1);
        /*Producto producto1 = new Producto(1,"Harina",1,100); 
        Producto producto2 = new Producto(2,"pan",1,80);
        c.addItem(producto2);*/
   
        assertEquals(val,test,0);
    }
     @Test
    public void testLimpiarError() {
        Carrito cd = new Carrito();
        Producto producto2 = new Producto(2,"pan",1,80);
        cd.addItem(producto2);
        int test = cd.getLista().size();
          int val=0;
        assertEquals(val,test,0);
    }
    

    /**
     * Test of guardarProducto method, of class CarritoApi.
     */
    @Test
    public void testGuardarProducto() {
        Carrito c = new Carrito();
        Producto producto2 = new Producto(2,"pan",1,80);
        c.addItem(producto2);
        if(c.getLista().contains(producto2)==false)
        fail("El producto no ha sido guardado");
    }
    @Test
    public void testGuardarProductoError() {
        Carrito c = new Carrito();
        Producto producto2 = new Producto(2,"pan",1,80);
        //c.addItem(producto2);
        if(c.getLista().contains(producto2)==false)
        fail("El producto no ha sido guardado");
    }
    
}
