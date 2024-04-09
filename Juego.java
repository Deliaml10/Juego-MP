import java.io.File;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Juego {
    private HashMap<String, Usuario> usuarios = new HashMap<>();
    private ArrayList<Personaje> personajes = new ArrayList<>();
    private static final String Usuarios = "usuarios.dat"; // Nombre del archivo para guardar usuarios
    private static final String Personajes = "personajes.dat"; // Nombre del archivo para guardar personajes

    private ArrayList<Jugador> rankingGlobal = new ArrayList<>();

    public void start() {
        cargarUsuarios(); // Cargar usuarios al inicio del juego
        cargarPersonajes(); // Cargar personajes al inicio del juego
        // Mensaje de bienvenida
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bienvenido a Sangre y Luna, serás vampiro, licántropo, o quizás... cazador.");
            System.out.println("Adéntrate en esta aventura y desafía a otros jugadores.");
            System.out.println("Presiona R para ver las reglas del juego o J para jugar:");
            String opcion = scanner.nextLine();

            if (opcion.equalsIgnoreCase("R")) {
                System.out.println("El juego consiste en combates contra otros jugadores. Cada combate debe ser validado por un administrador.\nSi decides aceptar un desafío, podrás elegir tus armas y armaduras; el ganador se lleva el oro apostado.\nPor otro lado, si decides no aceptarlo, deberás pagar un 10% de lo que haya apostado el desafiante. ¡SUERTE! ");
            } else if (opcion.equalsIgnoreCase("J")) {
                System.out.println("Seleccionaste jugar.");
            }
            String opcionJuego = null;

            do {
                System.out.println("Presiona C para crear un nuevo usuario, I para iniciar sesión o S para salir del juego:");
                opcionJuego = scanner.nextLine();
                if (opcionJuego.equalsIgnoreCase("C")) {
                    crearCuenta(scanner);

                } else if (opcionJuego.equalsIgnoreCase("I")) {      //OPCION DE INICIAR SESIÓN
                    Usuario usuarioJuego = iniciarSesion(scanner);
                    if (usuarioJuego != null){
                        jugar(usuarioJuego, scanner);
                    }

                } else if (opcionJuego.equalsIgnoreCase("S")) {
                    System.out.println("Gracias por jugar a Sangre y Luna");

                } else {
                    System.out.println("Opción no válida.");
                }
            } while (!opcionJuego.equalsIgnoreCase("S"));
        }
    }

    private void crearCuenta(Scanner scanner){
        System.out.println("Seleccionaste crear un nuevo usuario.");
        //Pedir que elija entre ser un administrador o ser un jugador
        System.out.println("Presiona J para ser un jugador o A para ser un nuevo administrador");
        String eleccion = scanner.nextLine();

        if (eleccion.equalsIgnoreCase("A")) {
            System.out.println("Seleccionaste ser un administrador.\n");
            System.out.println("Ingresa tu nombre:");
            String nombre = scanner.nextLine();
            boolean existeNick;
            String nick;
            do {
                System.out.println("\nIngresa tu nick:");
                nick = scanner.nextLine();
                existeNick = usuarios.containsKey(nick);
                if (existeNick){
                    System.out.println("El nick ya existe");
                }
            } while (existeNick);


            String contrasena1;
            String contrasena;
            do {
                System.out.println("\nIngresa tu contraseña:");
                contrasena = scanner.nextLine();
                System.out.println("\nRepite tu contreseña:");
                contrasena1 = scanner.nextLine();
                if (!contrasena1.equals(contrasena)) {
                    System.out.println("\nLas contraseñas no coinciden");
                }
            }
            while (!contrasena1.equals(contrasena));

            Administrador administrador = new Administrador(nombre, nick, contrasena);
            usuarios.put(nick, administrador);
            guardarUsuarios();
            System.out.println("¡Administrador creado exitosamente!");

        } else {
            String nombre;
            boolean existeNick;
            String nick;
            System.out.println("Seleccionaste ser un nuevo jugador\n");
            // Pedir datos al usuario para crear el nuevo usuario
            System.out.println("Ingresa tu nombre:");
            nombre = scanner.nextLine();
            do {
                System.out.println("Ingresa tu nick:");
                nick = scanner.nextLine();
                existeNick = usuarios.containsKey(nick);
                if (existeNick){
                    System.out.println("El nick ya existe");
                }
            } while (existeNick);
            String contrasena1;
            String contrasena;
            do {
                System.out.println("Ingresa tu contraseña:");
                contrasena = scanner.nextLine();
                System.out.println("Repite tu contreseña:");
                contrasena1 = scanner.nextLine();
                if (!contrasena1.equals(contrasena)) {
                    System.out.println("Las contraseñas no coinciden");
                }
            }
            while (!contrasena1.equals(contrasena));

            Jugador jugador = new Jugador(nombre, nick, contrasena);
            usuarios.put(nick, jugador);
            guardarUsuarios();
            System.out.println("¡Jugador creado exitosamente!");
        }
    }

    private Usuario iniciarSesion(Scanner scanner){
        // Iniciar sesión con un usuario existente
        System.out.println("Seleccionaste iniciar sesión.");

        // Pedir datos al usuario para iniciar sesión
        System.out.println("Ingresa tu nick:");
        String nick = scanner.nextLine();
        boolean existeUsuario = usuarios.containsKey(nick);
        Usuario usuarioJuego = usuarios.get(nick);
        if (existeUsuario) {
            System.out.println("Ingresa tu contraseña:");
            String contrasena1 = scanner.nextLine();
            if (usuarioJuego.getContrasena().equals(contrasena1)) {
                System.out.println("¡Inicio de sesión exitoso!");
                return usuarioJuego;
            } else {
                System.out.println("Nick o contraseña incorrectos");
                return null;
            }
        } else {
            System.out.println("Nick incorrecto");
            return null;
        }
    }

    private void jugar(Usuario usuario, Scanner scanner){
        System.out.println("¡Empieza el juego!");
        if (usuario instanceof Administrador) {
            Administrador administrador = (Administrador)usuario;
            String opcion = null;
            do {
                System.out.println("¿Qué quieres hacer?\n 1.Crear un personaje \n 2. Editar un personaje. \n 3. Validar desafíos. \n 4. Bloquear usuarios. \n 5. Desbloquear usuarios. \n 6. Salir del juego. ");
                opcion = scanner.nextLine();
                if (opcion.equals("1")) {
                    personajes.add(administrador.crearPersonaje());
                    guardarPersonajes();

                } else if (opcion.equals("2")) {
                    if (this.personajes.isEmpty()) {
                        System.out.println("No hay personajes para editar");
                    } else {
                        System.out.println("Escribe el nombre del personaje que quieres editar");
                        String nombreBuscado = scanner.nextLine();
                        Personaje personajeEditar = null;
                        for (Personaje personaje : personajes) {
                            if (personaje.getNombrePersonaje().equals(nombreBuscado)) {
                                personajeEditar = personaje;
                                break;
                            }
                        }
                        if (personajeEditar != null) {
                            administrador.editarPersonaje(personajeEditar);
                            guardarPersonajes();
                        } else {
                            System.out.println("Personaje no encontrado");
                        }
                    }

                } else if (opcion.equals("3")) {
                    //administrador.validarDesafios(); //Todavía no se puede hasta que no implementemos los combates

                } else if (opcion.equals("4")) {
                    System.out.println("Escribe el nick del usuario que quieres bloquear");
                    String nickBloquear = scanner.nextLine();
                    if (usuarios.containsKey(nickBloquear) && usuarios.get(nickBloquear) instanceof Jugador) {
                        Jugador usuarioBloquear = (Jugador) usuarios.get(nickBloquear);
                        administrador.bloquearUsuario(usuarioBloquear);
                    }

                } else if (opcion.equals("5")) {
                    System.out.println("Escribe el nick del usuario que quieres desbloquear");
                    String nickDesbloquear = scanner.nextLine();
                    if (usuarios.containsKey(nickDesbloquear) && usuarios.get(nickDesbloquear) instanceof Jugador) {
                        Jugador usuarioDesbloquear = (Jugador) usuarios.get(nickDesbloquear);
                        administrador.desbloquearUsuario(usuarioDesbloquear);
                    } else {
                        System.out.println("Usuario no encontrado o no es jugador");
                    }

                } else {
                    System.out.println("Opción no válida");
                }

            }while (!opcion.equals("6"));
        } else if (usuario instanceof Jugador) {
            Jugador jugador = (Jugador)usuario;
            ArrayList<Combate> desafiosPendientes = jugador.getDesafiosPendientes();
            while (!jugador.getDesafiosPendientes().isEmpty()) {
                System.out.println("Tienes desafíos pendientes");
                jugador.aceptarRechazarDesafio();
            }
            String op = null;
            do {
                System.out.println("¿Qué quieres hacer?\n 1. Elegir armas y armaduras. \n 2. Desafiar. \n 3. Consultar oro ganado y perdido. \n 4. Consultar ranking global. \n 5. Registrar personaje. \n 6. Dar de baja personaje. \n 7. Dar de baja la cuenta \n 8. Salir del juego ");
                op = scanner.nextLine();
                if (op.equals("1")) {
                    Personaje personajeJugador = jugador.getPersonaje();
                    if (personajeJugador == null) {
                        System.out.println("No tienes ningún personaje registrado");
                    } else {
                        jugador.equipar(personajeJugador);
                    }

<<<<<<< HEAD
            System.out.println("¿Qué quieres hacer?\n 1. Elegir armas y armaduras. \n 2. Desafiar. \n 3. Consultar oro ganado y perdido. \n 4. Consultar ranking global. \n 5. Registrar personaje. \n 6. Dar de baja personaje. \n 7. Dar de baja la cuenta \n 8. Salir del juego ");
            String op = scanner.nextLine();
            if(op.equals("1")) {
                Personaje personajeJugador = jugador.getPersonaje();
                if (personajeJugador == null){
                    System.out.println("No tienes ningún personaje registrado");
                }else {
                    jugador.equipar(personajeJugador);
                }

            }else if (op.equals("2")){
                Personaje personajeJugador = jugador.getPersonaje();
                if (personajeJugador == null){
                    System.out.println("No tienes ningún personaje registrado");
                } else {
                    // Obtener la lista de jugadores disponibles para desafiar
                    ArrayList<Jugador> jugadoresDisponibles = new ArrayList<>();
                    for (Usuario usuario2 : usuarios.values()){
                        if (usuario2 instanceof Jugador && !usuario2.getNick().equals(jugador.getNick())) {
                            jugadoresDisponibles.add((Jugador)usuario2);
                        }
                    }
            
                    // Mostrar los jugadores disponibles para desafiar
                    if (!jugadoresDisponibles.isEmpty()) {
                        System.out.println("Jugadores disponibles para desafiar:");
                        for (int i = 0; i < jugadoresDisponibles.size(); i++) {
                            Jugador jugadorDisponible = jugadoresDisponibles.get(i);
                            System.out.println((i + 1) + ". " + jugadorDisponible.getNombreUsuario() + " - Oro: " + jugadorDisponible.getPersonaje().getOro());
                        }
            
                        // Solicitar al jugador seleccionar a quién desafiar
                        System.out.println("Elige el número del jugador al que quieres desafiar:");
                        int opcionDesafiar = scanner.nextInt();
                        if (opcionDesafiar >= 1 && opcionDesafiar <= jugadoresDisponibles.size()) {
                            Jugador jugadorDesafiado = jugadoresDisponibles.get(opcionDesafiar - 1);
            
                            // Solicitar al jugador especificar la cantidad de oro a apostar
                            System.out.println("Especifica la cantidad de oro que deseas apostar:");
                            int oroApostado = scanner.nextInt();
            
                            // Crear el desafío
                            jugador.desafiar(jugador.getPersonaje(), jugadorDesafiado.getPersonaje(), oroApostado);
            
                            // Solicitar al administrador validar el desafío
                            System.out.println("El desafío ha sido enviado al administrador para su validación.");
                        } else {
                            System.out.println("Opción no válida");
                        }
                    } else {
                        System.out.println("No hay otros jugadores disponibles para desafiar en este momento");
                    }
                }
            }   else if(op.equals("3")){
                jugador.consultarOro();
=======
                } else if (op.equals("2")) {
                    Personaje personajeJugador = jugador.getPersonaje();
                    if (personajeJugador == null) {
                        System.out.println("No tienes ningún personaje registrado");
                    } else {
                        for (Usuario usuario2 : usuarios.values()) {
                            if (usuario2 instanceof Jugador) {
                                Jugador jugador2 = (Jugador) usuario2;
                                System.out.println("Quieres desafiar al jugador: " + usuario2.getNombreUsuario() + " \n 1. Si. \n 2. No.");
                                int opcionDesafiar = scanner.nextInt();
                                if (opcionDesafiar == 1) {
                                    jugador.desafiar(jugador.getPersonaje(), jugador2.getPersonaje());
                                }
                            }
                        }
                    }

                } else if (op.equals("3")) {
                    jugador.consultarOro();
>>>>>>> ae281cf58648c7c8f18b0b667da289f22cae775c

                } else if (op.equals("4")) {
                    // Ordenar el ranking global
                    rankingGlobal.sort((j1, j2) -> j2.getPersonaje().getOro() - j1.getPersonaje().getOro());
                    for (Jugador j : rankingGlobal) {
                        System.out.println("Nombre: " + j.getNombreUsuario() + ", Oro: " + j.getPersonaje().getOro());
                    }

                } else if (op.equals("5")) {
                    for (Personaje personaje : personajes) {
                        System.out.println("Quieres registrar el personaje: " + personaje.getNombrePersonaje() + " \n 1. Si. \n 2. No.");
                        int opcionRegistrar = scanner.nextInt();
                        if (opcionRegistrar == 1) {
                            jugador.registrarPersonaje(personaje);
                        }
                    }

                } else if (op.equals("6")) {
                    jugador.darBajaPersonaje();

                } else if (op.equals("7")) {
                    String nick = usuario.getNick();
                    if (usuarios.containsKey(nick)) {
                        usuarios.remove(nick);
                        guardarUsuarios();
                    }

                } else {
                    System.out.println("Opción no válida");
                }
            }while (!op.equals("8"));
        }
    }

    private void guardarUsuarios() {
        try {
            // Borrar el archivo de usuarios si existe
            File file = new File(Usuarios);
            if (file.exists()) {
                file.delete();
            }
            // Escribir el nuevo HashMap en el archivo
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Usuarios))) {
                oos.writeObject(usuarios);
                System.out.println("Usuarios guardados correctamente.");
            }
        } catch (IOException e) {
            System.err.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    private void cargarUsuarios() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Usuarios))) {
            HashMap<String, Usuario> usuariosCargados = (HashMap<String, Usuario>) ois.readObject();
            usuarios.clear(); // Limpiar el HashMap actual
            usuarios.putAll(usuariosCargados); // Almacenar los usuarios cargados en el HashMap
            System.out.println("Usuarios cargados correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar usuarios: " + e.getMessage());
        }
    }


    private void guardarPersonajes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Personajes))) {
            oos.writeObject(personajes);
            System.out.println("Personajes guardados correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar personajes: " + e.getMessage());
        }
    }
    
    private void cargarPersonajes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Personajes))) {
            ArrayList<Personaje> personajesCargados = (ArrayList<Personaje>) ois.readObject();
            personajes.clear(); // Limpiar la lista actual antes de cargar los personajes
            personajes.addAll(personajesCargados);
            System.out.println("Personajes cargados correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar personajes: " + e.getMessage());
        }
    }
    
}
