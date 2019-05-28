/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Roman Elias Maluf
 */
public class FuncionAppTest {
    
    public FuncionAppTest() {
    }

    

    /**
     * Test of compareNum method, of class FuncionApp.
     */
    @Test
    public void testCompareNum() {
        System.out.println("Compara el Numero 8674 con el 8674");
        String ingresado = "8674";
        String pensado = "8674";
        int[] comparacion = {0,0,0};
        int[] arrayEsperado = {4,0,0};
        boolean expResult = true;
        boolean result = FuncionApp.compareNum(ingresado, pensado, comparacion);
        assertEquals(expResult, result);
        assertArrayEquals(comparacion,arrayEsperado);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of validaNumero method, of class FuncionApp.
     */
    @Test
    public void testValidaNumero() {
        System.out.println("valida Numero 81730, resultado esperado Falso");
        String ingresado = "81730";
        boolean expResult = false;
        boolean result = FuncionApp.validaNumero(ingresado);
        assertEquals(expResult, result);
    }

    /**
     * Test of validaNumeroOrdenador method, of class FuncionApp.
     */
    @Test
    public void testValidaNumeroOrdenador() {
        System.out.println("validaNumeroOrdenador");
        String ingresado = "8070";
        boolean expResult = false;
        boolean result = FuncionApp.validaNumeroOrdenador(ingresado);
        assertEquals(expResult, result);
    }
    
}
