
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
public class Juego {
    private ArrayList<Usuario>usuarios = new ArrayList<>();
    private ArrayList<Personaje>personajes = new ArrayList<>();
    private Jugador jugador;
    public void start() {
        // Mensaje de bienvenida
        try (Scanner scanner = new Scanner(System.in)) {
            // Mensaje de bienvenida
            System.out.println("Bienvenido a Sangre y Luna, serás vampiro, licántropo, o quizás... cazador.");
            System.out.println("Adéntrate en esta aventura y desafía a otros jugadores.");

            // Solicitar acción al usuario
            System.out.println("Presiona R para ver las reglas del juego o J para jugar:");
            String opcion = scanner.nextLine();

            if (opcion.equalsIgnoreCase("R") || opcion.equalsIgnoreCase("r")) {

                System.out.println("El juego consiste en combates contra otros jugadores. Cada combate debe ser validado por un administrador.\nSi decides aceptar un desafío, podrás elegir tus armas y armaduras; el ganador se lleva el oro apostado.\nPor otro lado, si decides no aceptarlo, deberás pagar un 10% de lo que haya apostado el desafiante. ¡SUERTE! ");
                } else if (opcion.equalsIgnoreCase("J") || (opcion.equalsIgnoreCase("j"))) {

                System.out.println("Seleccionaste jugar.");
            }
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

                        System.out.println("Ingresa tu nombre:");
                        String nombre = scanner.nextLine();
                        System.out.println("\nIngresa tu nick:");
                        String nick = scanner.nextLine();
                        String contrasena1;
                        String contrasena;
                        do {
                            System.out.println("\nIngresa tu contraseña:");
                            contrasena = scanner.nextLine();
                            System.out.println("\nRepite tu contreseña:");
                            contrasena1 = scanner.nextLine();
                            if (!contrasena1.equals(contrasena)) {
                                System.out.println("\nLas contraseñas no coindicen");
                            }
                        }
                        while (!contrasena1.equals(contrasena));

                        Administrador administrador = new Administrador(nombre, nick, contrasena);
                        usuarios.add(administrador);
                        System.out.println("¡Administrador creado exitosamente!");

                    } else {
                        System.out.println("Seleccionaste ser un nuevo jugador\n");
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

                        Jugador jugador = new Jugador(nombre, contrasena, nick);
                        usuarios.add(jugador);
                        System.out.println("¡Usuario creado exitosamente!");
                    }

                } else if (opcionJuego.equalsIgnoreCase("I") || opcionJuego.equalsIgnoreCase("i")) {      //OPCION DE INICIAR SESIÓN
                    // Iniciar sesión con un usuario existente
                    System.out.println("Seleccionaste iniciar sesión.");

                    // Pedir datos al usuario para iniciar sesión
                    System.out.println("Ingresa tu nick:");
                    String nick1 = scanner.nextLine();
                    System.out.println("Ingresa tu contraseña:");
                    String contrasena1 = scanner.nextLine();

                    for (Usuario usuario : usuarios) {
                        if ((usuario.getNick().equals(nick1)) && (usuario.getContrasena().equals(contrasena1))) {
                            System.out.println("¡Inicio de sesión exitoso!");
                        } else {
                            System.out.println("Nick o contraseña incorrectos");
                        }
                    }

                } else {
                System.out.println("Opción no válida.");
                System.out.println("¡Empieza el juego!");
                if (jugador.numero == null) {  //esto es que es un Administrador

                    System.out.println("¿Qué quieres hacer?\n 1. Editar un personaje. \n 2. Añadir armas, armaduras, debilidades o esbirros a un personaje. \n 3. Validar desafíos. \n 4. Bloquear usuarios. \n 5. Desbloquear usuarios. \n6. Salir del juego. ");
                    opcion = scanner.nextLine();
                    if(opcion.equals("1")) {
                        administrador.editar();

                    }else if (opcion.equals("2")){
                        administrador.modificarJugador();

                    }else if(opcion.equals("3")){
                        administrador.validarDesafios();

                    }else if (opcion.equals("4")){
                        administrador.bloquear();

                    }else if(opcion.equals("5")){
                        administrador.desbloquear();

                    }else if (opcion.equals("6")){
                        System.out.println("¡Hasta luego!");
                    }else{
                        System.out.println("Opción no válida");
                    }
                }

                if (jugador.numero != null) {  //esto es que es un Jugador.java

                    if (jugador.desafiosPendientes.isEmpty()) {

                        System.out.println("¿Qué quieres hacer?\n 1. Elegir armas y armaduras. \n 2. Desafiar. \n 3. Consultar oro ganado y perdido. \n 4. Consultar ranking global. \n 5. Registrar personaje. \n6. Dar de baja personaje. \n 7. Dar de baja la cuenta \n 8. Salir del juego ");
                        String op = scanner.nextLine();
                        if(op.equals("1")) {
                            jugador.elegirArmasyArmaduras();

                        }else if (op.equals("2")){
                            jugador.desafiar();

                        }else if(op.equals("3")){
                            jugador.rankingOro();

                        }else if (op.equals("4")){
                            jugador.rankingGlobal();

                        }else if(op.equals("5")){
                            jugador.registrarPersonaje();  //hay que pasarle el parámetro personaje

                        }else if(op.equals("6")) {
                            jugador.darBajaPersonaje();

                        }else if (op.equals("7")){
                            jugador.darBajaCuenta();

                        }else if (op.equals("8")){
                            System.out.println("¡Hasta luego!");
                        }else {
                            System.out.println("Opción no válida");
                        }

                    }
                    else{
                        System.out.println("Tienes desafíos pendientes. \n Pulsa A para aceptarlo o pulsa N para rechazarlo. \n Si rechazas un desafío tendrás que pagar el 10% del oro apostado.");
                        String eleccion = scanner.nextLine();
                        if(eleccion.equalsIgnoreCase("A")){
                            jugador.aceptarDesafio();
                        }else{
                            jugador.rechazarDesafio();
                        }
                    }
                }
            }

        }
    }
}
