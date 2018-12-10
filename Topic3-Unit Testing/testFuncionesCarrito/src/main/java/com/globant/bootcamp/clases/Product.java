/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.clases;

/**
 *
 * @author Cristian
 */
public class Product {

    private int id;
    private String name;
    private int category;
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
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
        final Product other = (Product) obj;
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

    public void setPrice(float price) {
        this.price = price;
    }

    public Product() {
    }

    public Product(int id, String name, int category, float price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
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
    public void changeProductPrice(Product p, float price) {

        p.setPrice(price);
        System.out.println("Precio del producto modificado $" + p.getPrice());

    }

}
