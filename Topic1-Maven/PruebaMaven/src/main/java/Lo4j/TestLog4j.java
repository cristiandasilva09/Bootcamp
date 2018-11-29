/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lo4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author Cristian
 */
public class TestLog4j {
    private static final Logger log = LogManager.getLogger(TestLog4j.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     System.out.println("---------------------------------------");   
     System.out.println("Prueba de log4j");
     log.info("Mensaje con Info");
      log.fatal("Mensaje con Fatal");
      log.warn("Mensaje con Warn");
      log.error("Mensaje con Error");
      log.debug("Mensaje con Debug");
      System.out.println("---------------------------------------");
    }
    
}
