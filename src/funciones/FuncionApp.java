/**
 * Clase que Contiene las funciones Generales 
 * Utilizadas por el sistema
 */
package funciones;

/**
 *
 * @author Roman Elias Maluf
 */
public class FuncionApp {
    
     /**
     * Funcion para Generar un Numero Random de 4 Cifras que no se repitan.
     *
     * @param longitud Recibo por parametro la longitud del numero 
     * @return Devuelve el numero generado
     */
    public static String GeneraNum(int longitud) {
        String number = "";
        while (number.length() < longitud) {
            String rdm = (int) (Math.random() * 10) + "";
                                                            //Suponiendo que consita en Advinar un numero Entero (Nunca puede empezar con 0)
            if (number.length() < 1 && !rdm.equals("0")) {  //El primer Numero Debe ser disntito de 0 (CERO)
                number += rdm;
            } else if (number.length() >= 1 && !number.contains(rdm)) { //Para los demas agrego cualquier numero que no se repita
                number += rdm;
            }
        }
        return number;
    }

 /**
     * Metodo para comparar 2 numeros
     *
     * @param pensado Numero Pensado por la Maquina
     * @param ingresado Numero Ingresado por el Usuario o el Ordenador
     * @param comparacion Array para guardar los numeros que estan bien y los
     * que esten Regular
     *
     * @return Devuelve un booleano True los 4 numeros son iguales False los
     * numeros son distintos
     */
    public static boolean compareNum(String ingresado, String pensado, int[] comparacion) {

        for (int i = 0; i < pensado.length(); i++) {
            for (int j = 0; j < pensado.length(); j++) {
                if (ingresado.charAt(i) == pensado.charAt(j)) {
                    if (i == j) {
                        comparacion[0]++;       //Si contiene el numero en la misma Posicion Suma Bien
                    } else {
                        comparacion[1]++;       //Si contiene el numero en distinta Posicion Suma Regular
                    }
                }
            }
        }
        return (comparacion[0] == 4);
    }


}

