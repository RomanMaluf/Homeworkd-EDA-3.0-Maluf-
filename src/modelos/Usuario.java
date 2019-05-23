/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import funciones.FuncionApp;
import java.util.Scanner;

/**
 *
 * @author Roman Elias Maluf
 */
public class Usuario {
    //Atributos
    private String pensado;
    private String ingresado;
    private int bien;
    private int regular;
    private int intentos;
    
    //Constructor
    public Usuario() {
    }

    
    //Metodos De la Clase
    
    /**
     * Metodo Para que el Usuario Pueda Adivinar un numero
     */
    public void adivinaUsuario(){
        int[] comparacion = {0,0};
        this.intentos = 0;
        this.pensado = FuncionApp.GeneraNum(4); //Genero el Numero pensado por el Usuario
        Scanner scn =new Scanner(System.in);       
        System.out.println("El ordenador ya a Pensado su Numero... Intente Adivinarlo");
        System.out.println("Ingrese su Numero y Recuerde que debe ser de 4 Cifras DISTINTAS"); 
        boolean flag = false;
        do {
            this.ingresado = scn.nextLine();
            if (!validaNumero()) {
                  System.out.println("Prueba de Nuevo");
            }else{
                
                this.intentos++;
                flag = FuncionApp.compareNum(ingresado, pensado, comparacion);
                this.bien=comparacion[0]; this.regular = comparacion[1];
                if (flag) {
                    System.out.println("Felicitaciones Lo has Logrado!..... Numero de Intentos : "+intentos);
                    System.out.println("Preseiona Enter para volver al menu....");
                    scn.nextLine();
                }else{
                    System.out.println("Sigue Intentando... Bien : "+bien+" Regular : "+regular);
                    comparacion[0]=0;comparacion[1]=0;
                }
            }
        } while (!flag);   
    }
    
    public boolean validaNumero(){
        if (ingresado.isEmpty()) {
                System.out.println("Deben Ingresar un Numero");
                return false;
            }else if (ingresado.charAt(0) == '0') {
                System.out.println("El numero no debe empezar con 0");
                return false;
            }else if (ingresado.length() < 4){
            System.out.println("El Numero Ingresado es menor a 4 cifras"); 
            return false;
            }else if (ingresado.length() > 4) {
                System.out.println("El Numero Ingresado es mayor a 4 cifras"); 
                return false;
            }else{
                   for (int i = 0; i < ingresado.length(); i++) {
                       for (int j = 0; j < ingresado.length(); j++) {
                           if (i !=j) {
                                if (ingresado.charAt(i) == ingresado.charAt(j)) {
                                    System.out.println("Las 4 Cifras deben ser distintas");
                                    return false;
                                }
                           }
                       }
            }
 
            
            }
        return true;
    }
    
    //Getters And Setters
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
