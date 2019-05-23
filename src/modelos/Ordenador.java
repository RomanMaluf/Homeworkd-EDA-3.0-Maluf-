/**
 * Clase Ordenador
 * Para que el Usuario ingrese un numero
 * Y el Ordenador lo Adivine
 */
package modelos;

import funciones.FuncionApp;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roman Elias Maluf
 */
public class Ordenador {
        //Atributos
    private String pensado;
    private String ingresado;
    private int bien;
    private int regular;
    private int intentos;
    
    //Constructor

    public Ordenador() {
    }
    
    //METODOS
    
    
    public void adivinaOrdenador() throws InterruptedException{
        int[] comparacion = {0,0,0};
        int unidad = 1;
        this.intentos = 0;
        Scanner scn = new Scanner(System.in);
        
        boolean flag = false;
        
        do {
            if (this.ingresado == null) {
                System.out.println("Ingrese su Numero y Recuerde que debe ser de 4 Cifras DISTINTAS");
                this.ingresado = scn.nextLine();
            }else if (!FuncionApp.validaNumero(this.ingresado)) {
                   
                  System.out.println("Prueba de Nuevo");
                  this.ingresado = scn.nextLine();
            }else{
                  

                if (intentos == 0) {
                    System.out.println("Numero Ingresado Correctamente");
                  System.out.println("El ordenador esta tratando de Adivinar Su numero");
                    this.pensado=FuncionApp.GeneraNum(4);
                     this.intentos++;
                }
                    Thread.sleep(1000);
               
                flag = FuncionApp.compareNum(ingresado, pensado, comparacion); //Comparo los numeros
                this.bien=comparacion[0]; this.regular = comparacion[1];
                if (flag) {
                    System.out.println("Felicitaciones Lo has Logrado!..... Numero de Intentos : "+intentos);
                    System.out.println("Preseiona Enter para volver al menu....");
                    scn.nextLine();
                 
                }else{
                    this.pensado = comparaXUnidad(comparacion ,ingresado, pensado, unidad);
                    
                     unidad++;
                     if (unidad == 5) {
                    unidad = 1;
                    }
                }
            }
            
        } while (!flag);
        
    }
    
    
    /**
     *
     * @param unidad Defino la metrica a medir (Unidad,Decena,Centena,Millar)
     * @param numero El numero a Desglozar
     *
     * @return Devuelve un Array con los valores de 
     * Las suma que debe reaizar array[0] 
     * La resta que debe realizar array[1] 
     * El valor de (Unidad,Decena,Centena,Millar) Segun Corresponda
     */
    public int[] desglozarNumero(int unidad, int numero) {
        int[] result = {0, 0, 0};
        int mll = numero / 1000;        //Cantidad de Miles
        int ce = (numero - (mll * 1000)) / 100; //Cantidad de Centenas
        int dc = (numero - (mll * 1000 + ce * 100)) / 10; //Cantidad  de Decenas
        int un = (numero - (mll * 1000 + ce * 100 + dc * 10)); //Cantidad de Unidades
        switch (unidad) {
            case 1:
                result[0] = 1; //Suma
                result[1] = 10; //Resta
                result[2] = un; //Metrica
                break;
            case 2:
                result[0] = 10;
                result[1] = 100;
                result[2] = dc;
                break;
            case 3:
                result[0] = 100;
                result[1] = 1000;
                result[2] = ce;
                break;
            case 4:
                result[0] = 1000;
                result[1] = 9000;
                result[2] = mll;
                break;
        }

        return result;
    }
    
    public String comparaXUnidad(int[] array, String pensado, String adivina, int unidad) {
        String aux;         //Variable auxiliar para guardar el numero cambiado y comparar
        int a = Integer.parseInt(adivina); //Parseo el numero a entero para Realizar sumas y restas
        /**
         * [0] Guarda la cantidad de numeros que estan "Bien"
         * [1] Guarda la cantidad de numeros que estan "Regular"
         */
        int[] arrayAux = {0, 0}; 
        /**
        Guardar En Array 
        Posicion [0] = El numero para Sumar
        Posicion [1] = El numero para restar en caso de que llegue a 10 asi vuelve a 0
        Posicion [2] = El valor de la unidad Metrica eligda Valor de(Unidad,Decena,Centena,Millar)
         */
        int[] operaciones = desglozarNumero(unidad, a);
        for (int i = 0; i < 10; i++) {
            
            if (operaciones[2] >= 0 && operaciones[2] <= 9) {

                a = a + operaciones[0];
                operaciones[2]++;
            }
            if (operaciones[2] > 9) {
                a = a - operaciones[1];
                operaciones[2] = 0;
            }
            this.intentos++; //Sumo a los intentos
            aux = a + ""; //Cambio el Numero a comparar
            /*
            Los comparo y almaceno los valores de :
            Cantidad de numeros Bien en arrayAux[0]
            Cantidad de numeros Regular en arrayAux[1]
             */
           FuncionApp.compareNum(aux, pensado, arrayAux);

            if (arrayAux[0] > array[0]) {  //Si el nuevo numero contiene mayor cantidad de numeros Bien que el anterior lo devuelvo
                array[0] = 0;
                array[1] = 0;
                return aux;
            }
            if (arrayAux[0] < array[0]) { //Si el numero nuevo contiene menor canitdad de numeros Bien que el anterior, retorno el anterior
                a = a - operaciones[0];
                aux = a + "";
                array[0] = 0;
                array[1] = 0;

                return aux;

            }                             
            //Por si no cumple con ninguna de las 2 condiciones anteriores 
            //Seteo los valores de Bien y Regular a 0
            //Para volver a Empezar con el siguiente FOR
            arrayAux[0] = 0;
            arrayAux[1] = 0;
        }

        return "";
    }

    
    //Getters and Setters

    public String getPensado() {
        return pensado;
    }

    public void setPensado(String pensado) {
        this.pensado = pensado;
    }

    public String getIngresado() {
        return ingresado;
    }

    public void setIngresado(String ingresado) {
        this.ingresado = ingresado;
    }

    public int getBien() {
        return bien;
    }

    public void setBien(int bien) {
        this.bien = bien;
    }

    public int getRegular() {
        return regular;
    }

    public void setRegular(int regular) {
        this.regular = regular;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
    
    
    
    
}
