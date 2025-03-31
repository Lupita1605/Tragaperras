package Tragaperras;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la máquina tragamonedas.
 */
public class MaquinaTragamonedas {
    private Rodillo[] rodillos; // Array de rodillos en la máquina
    private int apuesta; // Apuesta actual del jugador

    /**
     * Constructor de la clase MaquinaTragamonedas.
     * @param rodillos Array de rodillos que componen la máquina tragamonedas.
     */
    public MaquinaTragamonedas(Rodillo[] rodillos) {
        this.rodillos = rodillos; // Inicializar el array de rodillos
    }

    /**
     * Establece la apuesta del jugador.
     * @param apuesta La cantidad de la apuesta.
     */
    public void setApuesta(int apuesta) {
        this.apuesta = apuesta; // Inicializar la apuesta
    }

    /**
     * Gira todos los rodillos y devuelve los símbolos resultantes.
     * @return Una lista de símbolos resultantes del giro.
     */
    public List<Simbolo> girar() {
        List<Simbolo> resultado = new ArrayList<>(); // Lista para almacenar los resultados
        for (Rodillo rodillo : rodillos) {
            resultado.add(rodillo.girar()); // Girar cada rodillo y añadir el símbolo resultante
        }
        return resultado; // Retornar la lista de resultados
    }

    /**
     * Calcula las ganancias basadas en los símbolos resultantes.
     * @param resultado Lista de símbolos resultantes del giro.
     * @return La cantidad de ganancias.
     */
    public int calcularGanancias(List<Simbolo> resultado) {
        // Lógica simple para calcular ganancias
        // Si todos los símbolos son iguales, el jugador gana 10 veces su apuesta
        if (resultado.stream().allMatch(simbolo -> simbolo.getImagen().equals(resultado.get(0).getImagen()))) {
            return apuesta * 10; // Ganancia
        }
        return 0; // Sin ganancia
    }
}
