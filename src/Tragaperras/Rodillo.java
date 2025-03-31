package Tragaperras;

import java.util.Random;

/**
 * Clase que representa un rodillo en la máquina tragamonedas.
 */
public class Rodillo {
    private Simbolo[] simbolos; // Array de símbolos que contiene el rodillo
    private Random aleatorio; // Generador de números aleatorios

    /**
     * Constructor de la clase Rodillo.
     * @param simbolos Array de símbolos que se utilizarán en el rodillo.
     */
    public Rodillo(Simbolo[] simbolos) {
        this.simbolos = simbolos; // Inicializar el array de símbolos
        this.aleatorio = new Random(); // Crear una instancia de Random
    }

    /**
     * Gira el rodillo y devuelve un símbolo aleatorio.
     * @return Un símbolo aleatorio del rodillo.
     */
    public Simbolo girar() {
        int indice = aleatorio.nextInt(simbolos.length); // Seleccionar un índice aleatorio
        return simbolos[indice]; // Retornar el símbolo correspondiente
    }
}
