package Tragaperras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Clase que representa la vista de la máquina tragamonedas.
 * Esta clase se encarga de mostrar la interfaz gráfica del usuario
 * y de interactuar con el controlador.
 */
public class VistaMaquinaTragamonedas extends JFrame {
    private JTextField campoApuesta; // Campo de texto para ingresar la apuesta
    private JButton botonGirar; // Botón para girar los rodillos
    private JTextArea areaResultado; // Área de texto para mostrar los resultados
    private JLabel[] etiquetasEmojis; // Array de etiquetas para mostrar los emojis
    private Timer temporizadorCambioColor; // Temporizador para cambiar el color de los bordes
    private Random aleatorio; // Generador de números aleatorios para seleccionar colores
    /**
     * Constructor de la clase VistaMaquinaTragamonedas.
     * Inicializa la interfaz gráfica y configura el temporizador.
     */
    public VistaMaquinaTragamonedas() {
        setTitle("Máquina Tragamonedas"); // Título de la ventana
        setSize(400, 300); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierre de la aplicación al cerrar la ventana
        setLayout(new GridBagLayout()); // Uso de GridBagLayout para una disposición flexible

        GridBagConstraints gbc = new GridBagConstraints(); // Configuración de restricciones para el layout
        gbc.fill = GridBagConstraints.HORIZONTAL; // Llenar el espacio horizontalmente
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre componentes
        // Inicializar los labels para los emojis
        etiquetasEmojis = new JLabel[3]; // Crear un array para 3 emojis
        for (int i = 0; i < etiquetasEmojis.length; i++) {
            etiquetasEmojis[i] = new JLabel("", SwingConstants.CENTER); // Crear etiqueta centrada
            etiquetasEmojis[i].setPreferredSize(new Dimension(100, 100)); // Tamaño fijo para los cuadros
            etiquetasEmojis[i].setOpaque(true); // Hacer que el JLabel sea opaco
            etiquetasEmojis[i].setBackground(Color.WHITE); // Color de fondo inicial
            etiquetasEmojis[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Borde inicial
            gbc.gridx = i; // Colocar en la columna correspondiente
            gbc.gridy = 0; // Fila 0 para los emojis
            add(etiquetasEmojis[i], gbc); // Añadir el label al JFrame
        }

        // Etiqueta y campo de entrada para la apuesta
        gbc.gridx = 0; // Colocar en la primera columna
        gbc.gridy = 1; // Fila 1 para la etiqueta
        add(new JLabel("Ingrese su apuesta:"), gbc); // Añadir etiqueta de apuesta

        gbc.gridx = 1; // Colocar en la segunda columna
        gbc.gridy = 1; // Fila 1 para el campo de apuesta
        add(campoApuesta = new JTextField(10), gbc); // Añadir campo de texto para la apuesta

        // Botón de girar
        gbc.gridx = 2; // Colocar en la tercera columna
        gbc.gridy = 1; // Fila 1 para el botón
        add(botonGirar = new JButton("Girar"), gbc); // Añadir botón para girar

        // Área de resultados
        gbc.gridx = 0; // Colocar en la primera columna
        gbc.gridy = 2; // Fila 2 para el área de resultados
        gbc.gridwidth = 3; // Ocupa las tres columnas
        areaResultado = new JTextArea(5, 30); // Crear área de texto para resultados
        areaResultado.setEditable(false); // Hacer que el área de resultados no sea editable
        add(new JScrollPane(areaResultado), gbc); // Añadir área de resultados dentro de un JScrollPane

        // Inicializar el temporizador
        aleatorio = new Random(); // Crear instancia de Random
        temporizadorCambioColor = new Timer(1000, e -> cambiarColorBorde()); // Temporizador que cambia el color cada segundo
        temporizadorCambioColor.start(); // Iniciar el temporizador
        setVisible(true); // Hacer visible la ventana
    }

    /**
     * Cambia el color del borde de los cuadros de emojis a un color aleatorio.
     */
    private void cambiarColorBorde() {
        Color[] colores = {Color.GREEN, Color.BLUE, Color.YELLOW, Color.RED}; // Colores disponibles
        Color colorAleatorio = colores[aleatorio.nextInt(colores.length)]; // Seleccionar un color aleatorio
        for (JLabel etiquetaEmoji : etiquetasEmojis) {
            etiquetaEmoji.setBorder(BorderFactory.createLineBorder(colorAleatorio, 8)); // Cambiar el color del borde
        }
    }

    /**
     * Obtiene la apuesta ingresada por el usuario.
     * @return La cantidad de la apuesta.
     */
    public int getApuesta() {
        try {
            return Integer.parseInt(campoApuesta.getText()); // Convertir el texto a un número entero
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido para la apuesta.", "Entrada inválida", JOptionPane.ERROR_MESSAGE);
            return 0; // Retornar 0 si hay un error
        }
    }

    /**
     * Muestra el resultado del giro en el área de resultados.
     * @param resultado El resultado a mostrar.
     */
    public void mostrarResultado(String resultado) {
        areaResultado.append(resultado + "\n"); // Añadir el resultado al área de texto
    }

    /**
     * Actualiza los emojis mostrados en los cuadros.
     * @param emojis Array de emojis a mostrar.
     */
    public void actualizarEmojis(ImageIcon[] emojis) {
        for (int i = 0; i < etiquetasEmojis.length; i++) {
            etiquetasEmojis[i].setIcon(emojis[i]); // Actualizar el icono de cada label con el emoji
        }
    }

    /**
     * Añade un listener al botón de girar.
     * @param listener El ActionListener a añadir.
     */
    public void addSpinListener(ActionListener listener) {
        botonGirar.addActionListener(listener); // Añadir el listener al botón
    }

    /**
     * Obtiene el array de etiquetas de emojis.
     * @return El array de etiquetas de emojis.
     */
    public JLabel[] getEtiquetasEmojis() {
        return etiquetasEmojis; // Retornar el array de etiquetas
    }
}
