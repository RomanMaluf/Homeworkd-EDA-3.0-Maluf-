/**
 * Clase Ordenador
 * Para que el Usuario ingrese un numero
 * Y el Ordenador lo Adivine
 */
package modelos;

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
    
    
    public void adivinaOrdenador(){
    
    
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
