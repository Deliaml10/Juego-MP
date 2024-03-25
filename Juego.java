
import java.sql.SQLOutput;
import java.util.Scanner;
public class Juego {
    public static void main(String[] args) {
        // Mensaje de bienvenida
        try (Scanner scanner = new Scanner(System.in)) {
            // Mensaje de bienvenida
            System.out.println("Bienvenido a Sangre y Luna, serás vampiro, licántropo, o quizás... cazador.");
            System.out.println("Adéntrate en esta aventura y desafía a otros jugadores.");

            // Solicitar acción al usuario
            System.out.println("Presiona R para ver las reglas del juego o J para jugar:");
            String opcion = scanner.nextLine();

            if (opcion.equalsIgnoreCase("R") || opcion.equalsIgnoreCase("r")) {
                // Mostrar las reglas del juego
                System.out.println("El juego consiste en combates contra otros jugadores. Cada combate debe ser validado por un administrador.\nSi decides aceptar un desafío, podrás elegir tus armas y armaduras; el ganador se lleva el oro apostado.\nPor otro lado, si decides no aceptarlo, deberás pagar un 10% de lo que haya apostado el desafiante. ¡SUERTE! ");
            } else if (opcion.equalsIgnoreCase("J") || (opcion.equalsIgnoreCase("j"))) {
                // Opción de jugar
                System.out.println("Seleccionaste jugar.");

                // Pedir al usuario que elija entre crear nuevo usuario o iniciar sesión
                System.out.println("Presiona C para crear un nuevo usuario o I para iniciar sesión:");
                String opcionJuego = scanner.nextLine();

                if (opcionJuego.equalsIgnoreCase("C") || opcionJuego.equalsIgnoreCase("c")) {
                    // Crear un nuevo usuario
                    System.out.println("Seleccionaste crear un nuevo usuario.");
                    //Pedir que elija entre ser un administrador o ser un jugador
                    System.out.println("Presiona J para ser un jugador o A para ser un nuevo administrador");
                    String eleccion = scanner.nextLine();
                    if (eleccion.equalsIgnoreCase("A") || eleccion.equalsIgnoreCase("a")) {
                        System.out.println("Seleccionaste ser un administrador.\n");
                        //  Administrador admin = new Administrador();
                    } else {
                        System.out.println("Seleccionaste ser un nuevo jugador");
                        //  Jugador jugador = new Jugador();  //ESTO FUNCIONARÁ CUANDO LA CLASE PERSONAJE ESTÉ CREADA
                    }
                    // Pedir datos al usuario para crear el nuevo usuario
                    System.out.println("Ingresa tu nombre:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingresa tu nick:");
                    String nick = scanner.nextLine();
                    String contrasena1;
                    String contrasena;
                    do {
                        System.out.println("Ingresa tu contraseña:");
                        contrasena = scanner.nextLine();
                        System.out.println("Repite tu contreseña:");
                        contrasena1 = scanner.nextLine();
                        if (!contrasena1.equals(contrasena)) {
                            System.out.println("Las contraseñas no coindicen");
                        }
                    }
                    while (!contrasena1.equals(contrasena));

                    Jugador jugador = new Jugador(String nombre, String contrasena, String nick);
                    System.out.println("¡Usuario creado exitosamente!");

                } else if (opcionJuego.equalsIgnoreCase("I") || opcionJuego.equalsIgnoreCase("i")) {      //OPCION DE INICIAR SESIÓN
                    // Iniciar sesión con un usuario existente
                    System.out.println("Seleccionaste iniciar sesión.");

                    // Pedir datos al usuario para iniciar sesión
                    System.out.println("Ingresa tu nick:");
                    String nick = scanner.nextLine();
                    System.out.println("Ingresa tu contraseña:");
                    String contrasena = scanner.nextLine();

                    // Aquí podrías realizar la lógica para verificar el inicio de sesión con los datos proporcionados
                    System.out.println("¡Inicio de sesión exitoso!");
                } else {
                    System.out.println("Opción no válida.");
                }
            } else {
                System.out.println("Opción no válida.");
            }

        }
    }
}
