/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.TestJunit;

/**
 *
 * @author Cristian
 */
public class Operations {
    private float lastResult;
    //operaciones a sumeterse a test
    public float sum(float a, float b) {
        return lastResult = a + b;
    }
    public float substract(float a, float b) {
        return lastResult = a - b;
    }
    public float multiplication(float a,
        float b) {
        return lastResult = a * b;
    }
    public float division(float a, float b) {
        return lastResult = a / b;
    }
    public float getLastResult() {
        return lastResult;
}
   
}