/*
 *Ejercicio 1:
 *El juego para adivinar un numero de cuatro cifras (que no se repiten) 
 *consiste en que el "pensador" piensa un numero de 4 cifras (como "1234" o "9072"). 
 *El "adivinador" prueba de adivinar el numero diciendo un numero de 4 cifras y el "pensador" 
 *le dice cuantas cifras están en el lugar correcto y cuantas en el lugar incorrecto
 */
package main;

import java.util.Scanner;
import modelos.Ordenador;
import modelos.Usuario;



/**
 *
 * @author Roman Elias Maluf
 */
public class AdivinaCuatro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       menu(); //Ejecuto el Menu del juego
 
    }
     public static int menu() {
    
        int opcion = 0;   
        Scanner scn = new Scanner(System.in);
            
    while(opcion != 3) {  //Mientras la opcion no sea Salir sigo en el juego
        System.out.println
        ("Bienvenido Al Juego ***Adivina Cuatro Cifras***" +
        "\n 1- Adivine un número generado por el ordenador"+
        "\n 2- Piense un número para que el ordenador adivine"+
        "\n 3- Salir");
        
        opcion = scn.nextInt();
        
        switch(opcion){
            case 1:
                Usuario user = new Usuario();
                user.adivinaUsuario();
                break;
         
            case 2:
               //Voy al Modelo Ordenador
                Ordenador computer = new Ordenador();
                computer.adivinaOrdenador();
                break;
            
            case 3:
                System.out.println("Gracias por jugar");
                return 1;
            default:
                System.out.println("Opcion Incorrecta. Vuelva a Intentar");
        }   
    }   

    
        return 0;
    }
    
   
}
