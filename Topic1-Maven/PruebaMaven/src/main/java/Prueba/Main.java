/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

/**
 *
 * @author Cristian
 */
public class Main {
    	 
    public static void main(String[]args){
       
        
       
      
        //creamos un EntityManager factory para poder gestionar las entidades mapeadas
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyConnectionBD");
        //una vez creada la factoria podemos crear un EntityManager encargado de gestionar lso objetos
        EntityManager em =emf.createEntityManager();
        //creamos un objeto de la clase persona y buscamos su registro en la bd 
        Persona p1 = em.find(Persona.class,1);
        Persona p2 = em.find(Persona.class,2);
        System.out.println("---------------------------------------");
        System.out.println("Prueba de Proyecto Maven:");
        System.out.println("Primer persona guardada en la BD: "+p1);
        System.out.println("Segunda persona guardada en la BD: "+p2);
        System.out.println("---------------------------------------");
       //Cerramos las sesiones de los entity para terminar el proceso
        em.close();
        emf.close();
        
     }
}
