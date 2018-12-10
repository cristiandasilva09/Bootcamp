/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Cristian
 */
public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int op = -1; //opción elegida del usuario

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Cart c = new Cart();
        Product producto1 = new Product(1, "Harina", 1, 100);
        Product producto2 = new Product(2, "pan", 1, 80);
        Product producto3 = new Product(3, "fideos", 1, 50);
        Product producto4 = new Product(4, "aceite", 1, 50);
        Product producto5 = new Product(5, "desodorante", 2, 90);

        /* c.getProducts();
       c.addItem(producto5);
       c.addItem(producto4);*/
        while (op != 7) {
            try {
                System.out.println("----------------------------");
                System.out.println("Seleccione opcion");
                System.out.println("1 ver Carrito");
                System.out.println("2 seleccionar Product");
                System.out.println("3 Ver costo total");
                System.out.println("4 limpiar carrito");
                System.out.println("5 agregar producto");
                System.out.println("6 eliminar producto ");
                System.out.println("7 salir ");
                System.out.println("----------------------------");

                //Recoger una variable por consola
                op = Integer.parseInt(scanner.nextLine());
                switch (op) {
                    case 1:
                        List lista = new ArrayList();
                        lista = c.getProducts();
                        break;
                    case 2:

                        if (c.getList().size() > 0) {

                            System.out.println("Seleccione identificador de producto ");

                            int op2 = Integer.parseInt(scanner.nextLine());
                            if (op2 == 1) {
                                Product prod1 = new Product();
                                prod1 = c.getProduct(1);
                            }
                            if (op2 == 2) {
                                Product prod2 = new Product();
                                prod2 = c.getProduct(2);
                            }
                            if (op2 == 3) {
                                Product prod3 = new Product();
                                prod3 = c.getProduct(3);
                            }
                            if (op2 == 4) {
                                Product prod4 = new Product();
                                prod4 = c.getProduct(4);
                            }
                            if (op2 == 5) {
                                Product prod5 = new Product();
                                prod5 = c.getProduct(5);

                            }
                            if ((op2 != 1) || (op2 != 2) || (op2 != 3) || (op2 != 4) || (op2 != 5)) {
                                System.out.println("Identificador de producto no encontrado");
                                break;
                            }
                        } else {
                            System.out.println("El carrito esta vacio");
                            break;
                        }

                        break;
                    case 3:
                        float costo = c.getTotalCost();
                        System.out.println("costo del carrito:" + costo);
                        break;
                    case 4:
                        c.cleanCart();
                        break;
                    case 5:
                        System.out.println("----------------------------");
                        System.out.println("Seleccione opcion");
                        System.out.println("1 harina");
                        System.out.println("2 pan");
                        System.out.println("3 fideos");
                        System.out.println("4 aceite");
                        System.out.println("5 desodorante");
                        System.out.println("----------------------------");
                        int op5 = Integer.parseInt(scanner.nextLine());
                        if (op5 == 1) {
                            c.saveProduct(producto1);
                            break;
                        }
                        if (op5 == 1) {
                            c.saveProduct(producto1);
                            break;
                        }
                        if (op5 == 2) {
                            c.saveProduct(producto2);
                            break;
                        }
                        if (op5 == 3) {
                            c.saveProduct(producto3);
                            break;
                        }
                        if (op5 == 4) {
                            c.saveProduct(producto4);
                            break;
                        }
                        if (op5 == 5) {
                            c.saveProduct(producto5);
                            break;
                        }

                        if ((op5 != 1) || (op5 != 2) || (op5 != 3) || (op5 != 4) || (op5 != 5)) {
                            System.out.println("Identificador de producto no encontrado");
                            break;
                        }
                        break;
                    case 6:
                        if (c.getList().size() > 0) {
                            c.getProducts();

                            System.out.println("Seleccione identificador de producto a borrar");

                            int op6 = Integer.parseInt(scanner.nextLine());
                            if (op6 == 1) {
                                c.deleteProduct(1);
                            }
                            if (op6 == 2) {
                                c.deleteProduct(2);
                            }
                            if (op6 == 3) {
                                c.deleteProduct(3);
                            }
                            if (op6 == 4) {
                                c.deleteProduct(4);
                            }
                            if (op6 == 5) {
                                c.deleteProduct(5);
                            }
                            if ((op6 != 1) || (op6 != 2) || (op6 != 3) || (op6 != 4) || (op6 != 5)) {
                                System.out.println("Identificador de producto no encontrado");
                                break;
                            }
                        } else {
                            System.out.println("El carrito esta vacio");
                        }
                        break;
                    case 7:
                        System.out.println("Adios!");
                        break;
                    default:
                        System.out.println("Número no reconocido");
                        break;

                }
            } catch (Exception e) {
                System.out.println("Uoop! Error!");
            }
        }
        //testeo del modificar precio producto

        producto3.changeProductPrice(producto3, 100);
    }

}
