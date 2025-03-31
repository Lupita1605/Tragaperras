package Tragaperras;

import javax.swing.ImageIcon;
import java.awt.Image;

/**
 * Clase que representa un símbolo en la máquina tragamonedas.
 */
public class Simbolo {
    private ImageIcon imagen; // Imagen del símbolo

    /**
     * Constructor de la clase Simbolo.
     * @param rutaImagen La ruta de la imagen del símbolo.
     */
    public Simbolo(String rutaImagen) {
        this.imagen = new ImageIcon(rutaImagen); // Inicializar la imagen del símbolo
    }

    /**
     * Obtiene la imagen del símbolo.
     * @return La imagen del símbolo.
     */
    public ImageIcon getImagen() {
        return imagen; // Retornar la imagen del símbolo
    }

    /**
     * Redimensiona la imagen del símbolo.
     * @param ancho El ancho deseado.
     * @param alto El alto deseado.
     * @return La imagen redimensionada.
     */
    public ImageIcon getImagenRedimensionada(int ancho, int alto) {
        Image img = imagen.getImage();
        Image imgRedimensionada = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imgRedimensionada);
    }
}
