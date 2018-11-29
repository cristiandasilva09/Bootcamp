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
public class Operaciones {
    private float ultimoResultado;
    //operaciones a sumeterse a test
    public float suma(float primerSumando, float segundoSumando) {
        return ultimoResultado = primerSumando + segundoSumando;
    }
    public float resta(float minuendo, float sustraendo) {
        return ultimoResultado = minuendo - sustraendo;
    }
    public float multiplicacion(float primerFactor,
        float segundoFactor) {
        return ultimoResultado = primerFactor * segundoFactor;
    }
    public float division(float dividendo, float divisor) {
        return ultimoResultado = dividendo / divisor;
    }
    public float getUltimaResultado() {
        return ultimoResultado;
}
   
}