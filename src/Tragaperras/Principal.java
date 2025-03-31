package Tragaperras;

public class Principal {
    public static void main(String[] args) {
        // Crear símbolos que se utilizarán en la máquina tragamonedas
        Simbolo[] simbolos = {
            new Simbolo("C:\\Users\\Administrator\\Downloads\\descarga.jpeg"),
            new Simbolo("C:\\Users\\Administrator\\Downloads\\descarga (1).jpeg"),
            new Simbolo("C:\\Users\\Administrator\\Downloads\\descarga (2).jpeg"),
            new Simbolo("C:\\Users\\Administrator\\Downloads\\descarga (3).jpeg"),
            new Simbolo("C:\\Users\\Administrator\\Downloads\\descarga (4).jpeg"),
            new Simbolo("C:\\Users\\Administrator\\Downloads\\descarga (5).jpeg")
        };

        // Crear rodillos utilizando los símbolos
        Rodillo[] rodillos = {
            new Rodillo(simbolos),
            new Rodillo(simbolos),
            new Rodillo(simbolos)
        };

        // Crear la máquina tragamonedas con los rodillos
        MaquinaTragamonedas maquinaTragamonedas = new MaquinaTragamonedas(rodillos);

        // Crear la vista de la máquina tragamonedas
        VistaMaquinaTragamonedas vista = new VistaMaquinaTragamonedas();

        // Crear el controlador que conecta la máquina tragamonedas y la vista
        ControladorMaquinaTragamonedas controlador = new ControladorMaquinaTragamonedas(maquinaTragamonedas, vista);
    }
}
