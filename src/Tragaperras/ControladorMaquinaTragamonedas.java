package Tragaperras;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;

/**
 * Clase que actúa como controlador en el patrón MVC.
 * Esta clase conecta la lógica del modelo (MaquinaTragamonedas) con la vista (VistaMaquinaTragamonedas).
 */
public class ControladorMaquinaTragamonedas {
    private MaquinaTragamonedas modelo; // Modelo de la máquina tragamonedas
    private VistaMaquinaTragamonedas vista; // Vista de la máquina tragamonedas

    /**
     * Constructor de la clase ControladorMaquinaTragamonedas.
     * @param modelo El modelo de la máquina tragamonedas.
     * @param vista La vista de la máquina tragamonedas.
     */
    public ControladorMaquinaTragamonedas(MaquinaTragamonedas modelo, VistaMaquinaTragamonedas vista) {
        this.modelo = modelo; // Inicializar el modelo
        this.vista = vista; // Inicializar la vista
        // Añadir un listener al botón de girar
        this.vista.addSpinListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejarGiro(); // Manejar el evento de girar
            }
        });
    }

    /**
     * Maneja el evento de girar los rodillos.
     * Obtiene la apuesta, gira los rodillos y actualiza la vista con los resultados.
     */
    private void manejarGiro() {
        int apuesta = vista.getApuesta(); // Obtener la apuesta del usuario
        modelo.setApuesta(apuesta); // Establecer la apuesta en el modelo
        List<Simbolo> resultado = modelo.girar(); // Girar los rodillos y obtener los resultados
        int ganancias = modelo.calcularGanancias(resultado); // Calcular las ganancias
        
        // Actualizar la vista con las imágenes redimensionadas
        ImageIcon[] imagenes = resultado.stream().map(simbolo -> simbolo.getImagenRedimensionada(100, 100)).toArray(ImageIcon[]::new);
        vista.actualizarEmojis(imagenes); // Actualizar las imágenes en la vista
        
        // Mostrar solo las ganancias en el área de resultados
        vista.mostrarResultado("Ganancias: " + ganancias);

        // Actualizar los cuadros de emojis con 'X' o '$'
        for (int i = 0; i < vista.getEtiquetasEmojis().length; i++) {
            if (ganancias > 0) {
                vista.getEtiquetasEmojis()[i].setText("$"); // Mostrar símbolo de dólar si hay ganancias
                vista.getEtiquetasEmojis()[i].setForeground(Color.GREEN); // Cambiar a verde
            } else {
                vista.getEtiquetasEmojis()[i].setText("X"); // Mostrar 'X' si no hay ganancias
                vista.getEtiquetasEmojis()[i].setForeground(Color.RED); // Cambiar a rojo
            }
        }
    }
}
