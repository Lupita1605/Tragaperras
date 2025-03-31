# Proyecto de Máquina Tragaperras

## Descripción
Este proyecto es una simulación de una máquina tragamonedas desarrollada en Java utilizando el patrón MVC. Los usuarios pueden realizar apuestas, girar los rodillos y ver los resultados en una interfaz gráfica.

## Instalación
1. **Descarga el repositorio**:
   - Ve a la página del repositorio en GitHub.
   - Haz clic en el botón "Code" y selecciona "Download ZIP".
   - Extrae el contenido del archivo ZIP en tu máquina local.

2. **Abrir el proyecto en NetBeans**:
   - Abre NetBeans.
   - Selecciona "File" > "Open Project".
   - Navega hasta el directorio donde extrajiste el archivo ZIP.
   - Selecciona el proyecto y haz clic en "Open Project".

3. **Compilar y ejecutar el proyecto**:
   - Haz clic derecho en el proyecto en el panel "Projects".
   - Selecciona "Run" para compilar y ejecutar el proyecto.

## Uso
1. **Ingresar la apuesta**: Escribe la cantidad de tu apuesta en el campo de texto.
2. **Girar los rodillos**: Haz clic en el botón "Girar".
3. **Ver los resultados**: Observa los símbolos en los rodillos y las ganancias en el área de resultados.

## Estructura del Código
### `src/Tragaperras/Simbolo.java`
Define los símbolos utilizados en los rodillos. Cada símbolo tiene una imagen asociada que se muestra en la interfaz gráfica.

### `src/Tragaperras/Rodillo.java`
Representa cada rodillo de la máquina tragamonedas. Cada rodillo contiene una lista de símbolos y tiene la capacidad de girar para seleccionar un símbolo aleatorio.

### `src/Tragaperras/MaquinaTragamonedas.java`
Contiene la lógica principal de la máquina tragamonedas. Gestiona los rodillos, la apuesta del usuario y calcula las ganancias basadas en los resultados de los rodillos.

### `src/Tragaperras/VistaMaquinaTragamonedas.java`
Maneja la interfaz gráfica del usuario. Muestra los rodillos, permite al usuario ingresar su apuesta y muestra los resultados del giro.

### `src/Tragaperras/ControladorMaquinaTragamonedas.java`
Conecta la vista y el modelo, manejando la interacción del usuario. Recibe las acciones del usuario desde la vista, actualiza el modelo y actualiza la vista con los resultados.

### `src/Tragaperras/Principal.java`
Clase principal que inicia la aplicación. Configura los símbolos, rodillos, la máquina tragamonedas, la vista y el controlador, y luego inicia la aplicación.

## Ejemplo de Uso
1. **Ingresar la apuesta**: El usuario ingresa una cantidad en el campo de apuesta.
2. **Girar los rodillos**: El usuario hace clic en el botón "Girar".
3. **Ver los resultados**: Los rodillos giran y muestran los símbolos. Si todos los símbolos son iguales, el usuario gana 10 veces su apuesta.

## Capturas de Pantalla
![Interfaz de Usuario]## Contribuciones
Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request para discutir cualquier cambio que desees realizar.


