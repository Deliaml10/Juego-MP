
import java.util.Scanner;

public class Juego {

    public static void main(String[] args) {
        // Mensaje de bienvenida
        try (Scanner scanner = new Scanner(System.in)) {
            // Mensaje de bienvenida
            System.out.println("Bienvenido  a Sangre y Luna, serás vampiro, licántropo, o quizás... cazador.");
            System.out.println("Adéntrate en esta aventura y desafía a otros jugadores.");

            // Solicitar acción al usuario
            System.out.println("Presiona R para ver las reglas del juego o J para jugar:");
            String opcion = scanner.nextLine();

            if (opcion.equalsIgnoreCase("R")) {
                // Mostrar las reglas del juego
                System.out.println("Aquí van las reglas del juego...");
            } else if (opcion.equalsIgnoreCase("J")) {
                // Opción de jugar
                System.out.println("Seleccionaste jugar.");

                // Pedir al usuario que elija entre crear nuevo usuario o iniciar sesión
                System.out.println("Presiona C para crear un nuevo usuario o I para iniciar sesión:");
                String opcionJuego = scanner.nextLine();

                if (opcionJuego.equalsIgnoreCase("C")) {
                    // Crear un nuevo usuario
                    System.out.println("Seleccionaste crear un nuevo usuario.");

                    // Pedir datos al usuario para crear el nuevo usuario
                    System.out.println("Ingresa tu nombre:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingresa tu nick:");
                    String nick = scanner.nextLine();
                    System.out.println("Ingresa tu contraseña:");
                    String contraseña = scanner.nextLine();

                    // Aquí podrías realizar la lógica para crear el nuevo usuario con los datos proporcionados
                    System.out.println("¡Usuario creado exitosamente!");
                } else if (opcionJuego.equalsIgnoreCase("I")) {
                    // Iniciar sesión con un usuario existente
                    System.out.println("Seleccionaste iniciar sesión.");

                    // Pedir datos al usuario para iniciar sesión
                    System.out.println("Ingresa tu nick:");
                    String nick = scanner.nextLine();
                    System.out.println("Ingresa tu contraseña:");
                    String contraseña = scanner.nextLine();

                    // Aquí podrías realizar la lógica para verificar el inicio de sesión con los datos proporcionados
                    System.out.println("¡Inicio de sesión exitoso!");
                } else {
                    System.out.println("Opción no válida.");
                }
            } else {
                System.out.println("Opción no válida.");
            }
            System.out.println("HOLA TU PADRE");
        }
    }
}
