/**
 * Clase Ordenador
 * Para que el Usuario ingrese un numero
 * Y el Ordenador lo Adivine
 */
package modelos;

import funciones.FuncionApp;
import java.util.Scanner;

/**
 *
 * @author Roman Elias Maluf
 */
public class Ordenador {
    //Atributos

    private String[] pensado;
    private int[] bien;
    private int[] regular;
    private int intentos;

    //Constructor
    public Ordenador() {
        this.pensado = new String[50];
        this.bien = new int[50];
        this.regular = new int[50];
    }

    //METODOS Y FUNCIONES
    
    /**
     * Metodo para que el ordenador Adivine el numero que el usuario esta Pensando
     * Si el Usuario se equivoca con alguna Validacion de numero Bien o Regular
     * Entra en un bucle infinito
     */
    public void adivinaOrdenador() {
        this.intentos = 0; 
        Scanner scn = new Scanner(System.in);
        this.pensado[intentos] = FuncionApp.GeneraNum(4);  //Primero Numero a Probar
        int original = Integer.parseInt(this.pensado[intentos]);
        String actual = "";
        boolean flag = false;  //Bandera Para Compara con numeros anteriores
        boolean primera = true; //Boolean por si es la primera Vez
        do { //Entra siempre Al menos 1 ves
            
            /**
             * Entra si es La primera Ves
             * Si no es la primera Ves, Tiene que cumpler con todos los numeros anteriores
             */
            if (primera || ( (!primera) && (flag) )) {
                if (intentos > 0) {
                    this.pensado[intentos] = actual;
                }
                System.out.println("Ordenador Pregunta por " + pensado[intentos] + " ?");
                System.out.println("Bien : ");
                this.bien[intentos] = scn.nextInt();
                System.out.println("Regulares: ");
                this.regular[intentos] = scn.nextInt();
                primera = false;
                flag = false;
                if (this.bien[intentos] == 4) { //Si los 4 numeros estan bien... Es correcto sale del metodo
                    System.out.println("El ordenador a Adivinado Su numero....Numero de Intentos : " + (intentos + 1));
                    System.out.println("Enter para volver al Menu Principal");
                    scn.nextLine();
                    break;
                }

            }
            original++; //Sumo Un numero
            if (original > 9876) { //Su supero el ultimo numero entero de 4 cifras todas distintas
                original = 1023;    //Retorno al primer numero entero de 4 cifras con todas distintas
            }
            actual = Integer.toString(original);    //Lo parseo
            if (FuncionApp.validaNumeroOrdenador(actual)) { //Valido que sea correcto y no repita ningun numero
                for (int i = 0; i < actual.length(); i++) {
                    for (int j = 0; j < actual.length(); j++) {

                        if (actual.charAt(i) == this.pensado[intentos].charAt(j)) { //Comparo
                            if (i == j) {
                                this.bien[intentos + 1]++;                      //Bien
                            } else {
                                this.regular[intentos + 1]++;                   //Regulares
                            }
                        }
                    }
                }
                if ((bien[intentos] != bien[intentos + 1]) && (regular[intentos] != regular[intentos + 1])) { //Si es distinto con respecto del anterior preguntado
                    this.bien[intentos + 1] = 0;            //Vuelvo valores a 0 para seguir pregutando
                    this.regular[intentos + 1] = 0;
                } else {                                    //Si no
                    this.intentos++;                    //Sumo intentos
                    if (intentos >= 1) {
                        flag = comparaAnteriores(actual);       //Si ya hay mas de 1 numero Comparo con todos los numeros anteriores
                        if (!flag) {            //Si no cumple con las condiciones de los numeros anteriores

                            this.intentos--;   //Resto el intento y vuelvo a empezar

                        }
                    }
                }

            }

        } while (true);

    }
    
    /**
     * Funcion para comparar el numero Actual
     * con todos los numeros Anteriores
     * @param actual recibe el numero Actual
     * @return Devuelve true Siempre que cumpla con todas las condiciones anteriores
     */
    public boolean comparaAnteriores(String actual) {
        boolean result = true;
        int[] aciertos = new int[50];
        int[] regulares = new int[50];
        for (int i = 0; i < intentos; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (actual.charAt(j) == pensado[i].charAt(k) && (j == k)) {
                        aciertos[i]++;

                    } else if (actual.charAt(j) == pensado[i].charAt(k)) {
                        regulares[i]++;

                    }
                }
            }
            if (aciertos[i] != bien[i] || regulares[i] != regular[i]) {
                return false;
            } else if (i == intentos - 1) {
                return result;
            }
        }

        return result;
    }

    //Getters and Setters
    public String[] getPensado() {
        return pensado;
    }

    public void setPensado(String[] pensado) {
        this.pensado = pensado;
    }

    public int[] getBien() {
        return bien;
    }

    public void setBien(int[] bien) {
        this.bien = bien;
    }

    public int[] getRegular() {
        return regular;
    }

    public void setRegular(int[] regular) {
        this.regular = regular;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

}
