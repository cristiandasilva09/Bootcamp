/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
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
        
       Carrito c = new Carrito();
       Producto producto1 = new Producto(1,"Harina",1,100);
       Producto producto2 = new Producto(2,"pan",1,80);
       Producto producto3 = new Producto(3,"fideos",1,50);
       Producto producto4 = new Producto(4,"aceite",1,50);
       Producto producto5 = new Producto(5,"desodorante",2,90);
       
     
      /* c.getProductos();
       c.addItem(producto5);
       c.addItem(producto4);*/
      
 while(op != 7){
      try{
      System.out.println("----------------------------");    
      System.out.println("Seleccione opcion");
     System.out.println("1 ver Carrito");
     System.out.println("2 seleccionar Producto");
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
                        List lista=new ArrayList();
                        lista=c.getProductos();
                     break;
            case 2:  
                      
                      if(c.getLista().size()>0){
                       
                      System.out.println("Seleccione identificador de producto ");
                       
                       int op2=Integer.parseInt(scanner.nextLine());
                        if(op2==1)
                        { Producto prod1= new Producto();
                             prod1=c.getProducto(1);
                            }
                        if(op2==2)
                        { Producto prod2= new Producto();
                             prod2=c.getProducto(2);
                            }
                        if(op2==3)
                         { Producto prod3= new Producto();
                             prod3=c.getProducto(3);
                            }
                        if(op2==4)
                        { Producto prod4= new Producto();
                             prod4=c.getProducto(4);
                            }
                        if(op2==5)
                        { Producto prod5= new Producto();
                             prod5=c.getProducto(5);
                             
                        }
                        if((op2!=1)||(op2!=2)||(op2!=3)||(op2!=4)||(op2!=5)){
                            System.out.println("Identificador de producto no encontrado");
                            break;
                        }
                        }
                        else
                      {System.out.println("El carrito esta vacio");
                         break;}
                         
                     break;
            case 3: 
                    float costo=c.getCostoTotal();
                     System.out.println("costo del carrito:"+costo);
                     break;
            case 4:  c.limpiarCarrito();
                     break;
            case 5:  System.out.println("----------------------------");    
                       System.out.println("Seleccione opcion");
                       System.out.println("1 harina");
                       System.out.println("2 pan");
                       System.out.println("3 fideos");
                       System.out.println("4 aceite");
                       System.out.println("5 desodorante");
                       System.out.println("----------------------------");
                       int op5=Integer.parseInt(scanner.nextLine());
                        if(op5==1){
                          c.guardarProducto(producto1);
                         break;
                        }
                        if(op5==1){
                          c.guardarProducto(producto1);
                         break;
                        }
                        if(op5==2){
                          c.guardarProducto(producto2);
                         break;
                        }
                        if(op5==3){
                          c.guardarProducto(producto3);
                         break;
                        }
                        if(op5==4){
                          c.guardarProducto(producto4);
                         break;
                        }
                        if(op5==5){
                          c.guardarProducto(producto5);
                         break;
                        }
                   
                         if((op5!=1)||(op5!=2)||(op5!=3)||(op5!=4)||(op5!=5)){
                            System.out.println("Identificador de producto no encontrado");
                            break;
                        }
                     break;
            case 6:  
                    if(c.getLista().size()>0){
                        c.getProductos();
                       
                      System.out.println("Seleccione identificador de producto a borrar");
                       
                       int op6=Integer.parseInt(scanner.nextLine());
                        if(op6==1)
                        c.borrarProducto(1);
                        if(op6==2)
                        c.borrarProducto(2);
                        if(op6==3)
                        c.borrarProducto(3);
                        if(op6==4)
                        c.borrarProducto(4);
                        if(op6==5)
                        c.borrarProducto(5);
                        if((op6!=1)||(op6!=2)||(op6!=3)||(op6!=4)||(op6!=5)){
                            System.out.println("Identificador de producto no encontrado");
                            break;
                        }
                        }
                        else
                        System.out.println("El carrito esta vacio");
                         break;
           case 7: 
		   System.out.println("Adios!");
		 break;
            	default:
			System.out.println("Número no reconocido");break;
				     
                    }
         }catch(Exception e){
				System.out.println("Uoop! Error!");
			}
       }
        //testeo del modificar precio producto
        
       producto3.modificarPrecioProducto(producto3,100);
    }
    
}
