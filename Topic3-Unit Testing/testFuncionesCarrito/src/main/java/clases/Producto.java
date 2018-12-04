/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;



/**
 *
 * @author Cristian
 */
public class Producto {
    private int id;
    private String nombre;
    private int categoria;
    private float precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public float getPrecio() {
        return precio;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.id;
        return hash;
    }
    
    



  
    
    

    public void setPrecio(float precio) {
        this.precio = precio;
    }

     
    
    public Producto() {
    }

    public Producto(int id, String nombre, int categoria, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }
    
 /*     funcion creada por si es necesario usarla, de ser asi se agregara tambien al 
        topic2
    public void modificarProducto(Producto p, String nombre,int categoria, float precio){
        p.setNombre(nombre);
        p.setCategoria(categoria);
        p.setPrecio(precio);
        System.out.println("Producto modificado con exito");
        System.out.println("Nombre: "+p.getNombre());
        System.out.println("Categoria: "+p.getCategoria());
        System.out.println("Precio: "+p.getPrecio());
    }*/
            public void modificarPrecioProducto( Producto p, float precio){
            
            p.setPrecio(precio);
            System.out.println("Precio del producto modificado $"+p.getPrecio());
                   
    }  
    
}
