/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian
 */
public class Carrito {
    
     private  List<Producto> lista =new ArrayList<Producto>();

    public Carrito() {
       
    }

    public List<Producto> getLista() {
        return lista;
    }

    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }

        public void addItem(Producto p) {
        lista.add(p);
    }
        public void removeItem(Producto p) {
            lista.remove(p);
        }
    
   
    public List getProductos()
    {
         int i=1;
    if(lista.isEmpty()==false){   
     for(Producto obj:lista){
         
         System.out.println("Producto numero: "+i);
         System.out.println("identificador producto: "+obj.getId());
         System.out.println("nombre: "+obj.getNombre());
         System.out.println("categoria: "+obj.getCategoria());
         System.out.println("precio: $"+obj.getPrecio());
         i++;
         
     }
     i--;
     System.out.println("total de productos:"+i);
     return lista;
    }else{
         System.out.println("El Carrito esta vacio");
         return null;
        }   
    }
    public float getCostoTotal()
    {
        float costo=0;
    if(lista.isEmpty()==false){   
     for(Producto obj:lista){
         
        
         costo=costo+obj.getPrecio();
     }
   
     return costo;
    }else{
         
         return costo;
       
        }   
    }
    
 
 /*   public void getProducto(int id){
        Producto producto = new Producto();
        producto.setId(id);
        if(lista.contains(producto))
        {
            for(Producto obj:lista)
                if(obj.getId()==id)
                {
                    System.out.println("Producto encontrado");
                    System.out.println("identificador producto: "+obj.getId());
                    System.out.println("nombre: "+obj.getNombre());
                    System.out.println("categoria: "+obj.getCategoria());
                    System.out.println("precio: $"+obj.getPrecio());
                }
        }else
         System.out.println("Producto no encontrado");
    }*/
    public Producto getProducto(int id){
        
        
            for(Producto obj:lista)
                if(obj.getId()==id)
                {
                    System.out.println("Producto encontrado");
                    System.out.println("identificador producto: "+obj.getId());
                    System.out.println("nombre: "+obj.getNombre());
                    System.out.println("categoria: "+obj.getCategoria());
                    System.out.println("precio: $"+obj.getPrecio());
                    return obj;
                }
        else
         System.out.println("Producto no encontrado");
            return null;
    }
    
    public void borrarProducto(int id){
        Producto producto = new Producto();
        producto.setId(id);
        if(lista.contains(producto))
        {
                    lista.remove(producto);
                    System.out.println("producto borrado");
        }
      else
            System.out.println("producto no encontrado");
    }
    
    public void limpiarCarrito(){
            lista.clear();
            System.out.println("Se ha vaciado el carrito ");
   
    }
    
    
    
  
    public void guardarProducto(Producto producto){
        lista.add(producto);
        System.out.println("Producto "+producto.getNombre()+ " agregado al carrito");
    }
}
