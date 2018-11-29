/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestJunit;

/**
 *
 * @author Cristian
 */
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
public class IgnoreTest {
    @Ignore  
    @Test
    public void testMath1() {
        assertThat(1 + 1, is(2));
    }
    //@Ignore se encarga de ignorar el test
    @Ignore
    @Test
    public void testMath2() {
        assertThat(1 + 2, is(5));
}
    
}