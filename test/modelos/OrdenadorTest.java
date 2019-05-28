/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

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
public class OrdenadorTest {
    
    public OrdenadorTest() {
    }


    /**
     * Test of comparaAnteriores method, of class Ordenador.
     */
    @Test
    public void testComparaAnteriores() {
        System.out.println("comparaAnteriores");
        String actual = "6103";
        Ordenador instance = new Ordenador();
        String[] numero = {"4710","5021"};
        int[] bien = {0,0};
        int[] regular = {2,2};
        instance.setPensado(numero);
        instance.setBien(bien);
        instance.setRegular(regular);
        boolean expResult = true;
        boolean result = instance.comparaAnteriores(actual);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPensado method, of class Ordenador.
     */
    @Test
    public void testGetPensado() {
        System.out.println("getPensado");
        Ordenador instance = new Ordenador();
        String[] pensados = {"2103","3042"};
        instance.setPensado(pensados);
        String[] expResult = {"2103","3042"};
        String[] result = instance.getPensado();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of setPensado method, of class Ordenador.
     */
    @Test
    public void testSetPensado() {
        System.out.println("setPensado");
        String[] pensado = {"2031","7983"};
        Ordenador instance = new Ordenador();
        instance.setPensado(pensado);
        assertArrayEquals(pensado, instance.getPensado());
    }

    /**
     * Test of getBien method, of class Ordenador.
     */
    @Test
    public void testGetBien() {
        System.out.println("getBien");
        Ordenador instance = new Ordenador();
        int[] expResult = {0,2,4};
        instance.setBien(expResult);
        int[] result = instance.getBien();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of setBien method, of class Ordenador.
     */
    @Test
    public void testSetBien() {
        System.out.println("setBien");
        int[] bien = {0,2,4};
        Ordenador instance = new Ordenador();
        instance.setBien(bien);
        assertArrayEquals(bien, instance.getBien());
    }

    /**
     * Test of getRegular method, of class Ordenador.
     */
    @Test
    public void testGetRegular() {
        System.out.println("getRegular");
        Ordenador instance = new Ordenador();
        int[] expResult = {1234,1023};
        instance.setRegular(expResult);
        int[] result = instance.getRegular();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of setRegular method, of class Ordenador.
     */
    @Test
    public void testSetRegular() {
        System.out.println("setRegular");
        int[] regular = {9876,8967};
        Ordenador instance = new Ordenador();
        instance.setRegular(regular);
        assertArrayEquals(instance.getRegular(),regular);
    }

    /**
     * Test of getIntentos method, of class Ordenador.
     */
    @Test
    public void testGetIntentos() {
        System.out.println("getIntentos");
        Ordenador instance = new Ordenador();
        int expResult = 0;
        instance.setIntentos(expResult);
        int result = instance.getIntentos();
        assertEquals(expResult, result);

    }

    /**
     * Test of setIntentos method, of class Ordenador.
     */
    @Test
    public void testSetIntentos() {
        System.out.println("setIntentos");
        int intentos = 0;
        Ordenador instance = new Ordenador();
        instance.setIntentos(intentos);
        assertEquals(intentos,instance.getIntentos());
    }
    
}
