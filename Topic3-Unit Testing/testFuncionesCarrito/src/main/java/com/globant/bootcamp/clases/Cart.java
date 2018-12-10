/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian
 */
public class Cart {

    private List<Product> list = new ArrayList<Product>();

    public Cart() {

    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    public void addItem(Product p) {
        list.add(p);
    }

    public void removeItem(Product p) {
        list.remove(p);
    }

    public List getProducts() {
        int i = 1;
        if (list.isEmpty() == false) {
            for (Product obj : list) {

                System.out.println("Producto numero: " + i);
                System.out.println("identificador producto: " + obj.getId());
                System.out.println("nombre: " + obj.getName());
                System.out.println("categoria: " + obj.getCategory());
                System.out.println("precio: $" + obj.getPrice());
                i++;

            }
            i--;
            System.out.println("total de productos:" + i);
            return list;
        } else {
            System.out.println("El Carrito esta vacio");
            return null;
        }
    }

    public float getTotalCost() {
        float cost = 0;
        if (list.isEmpty() == false) {
            for (Product obj : list) {

                cost = cost + obj.getPrice();
            }

            return cost;
        } else {

            return cost;

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
    public Product getProduct(int id) {

        for (Product obj : list) {
            if (obj.getId() == id) {
                System.out.println("Producto encontrado");
                System.out.println("identificador producto: " + obj.getId());
                System.out.println("nombre: " + obj.getName());
                System.out.println("categoria: " + obj.getCategory());
                System.out.println("precio: $" + obj.getPrice());
                return obj;
            } else {
                System.out.println("Producto no encontrado");
            }
        }
        return null;
    }

    public void deleteProduct(int id) {
        Product product = new Product();
        product.setId(id);
        if (list.contains(product)) {
            list.remove(product);
            System.out.println("producto borrado");
        } else {
            System.out.println("producto no encontrado");
        }
    }

    public void cleanCart() {
        list.clear();
        System.out.println("Se ha vaciado el carrito ");

    }

    public void saveProduct(Product producto) {
        list.add(producto);
        System.out.println("Producto " + producto.getName() + " agregado al carrito");
    }
}
