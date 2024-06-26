import java.time.LocalDateTime;
import java.io.*;
import java.util.*;

import static java.util.Collections.sort;

public class Juego {
    private HashMap<String, Usuario> usuarios = new HashMap<>();
    private ArrayList<Personaje> personajes = new ArrayList<>();
    private static String Usuarios = "usuarios.dat"; // Nombre del archivo para guardar usuarios
    private static String Personajes = "personajes.dat"; // Nombre del archivo para guardar personajes
    private ArrayList<Jugador> rankingGlobal = new ArrayList<>();


    public void start() {
        cargarUsuarios();
        cargarPersonajes();
        // Mensaje de bienvenida
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bienvenido a Sangre y Luna, serás vampiro, licántropo, o quizás... cazador.");
            System.out.println("Adéntrate en esta aventura y desafía a otros jugadores.");
            String opcionJuego = null;
            while (opcionJuego == null){
                System.out.println("Presiona R para ver las reglas del juego o J para jugar:");
                String opcion = scanner.nextLine();

                if (!esEntero(opcion) && opcion.equalsIgnoreCase("R")) {
                    System.out.println("El juego consiste en combates contra otros jugadores. Cada combate debe ser validado por un administrador.\nSi decides aceptar un desafío, podrás elegir tus armas y armaduras; el ganador se lleva el oro apostado.\nPor otro lado, si decides no aceptarlo, deberás pagar un 10% de lo que haya apostado el desafiante. ¡SUERTE! ");
                    opcionJuego = "R";
                } else if (!esEntero(opcion) && opcion.equalsIgnoreCase("J")) {
                    System.out.println("Seleccionaste jugar.");
                    opcionJuego = "J";
                }
                else {
                    System.out.println("Opción no válida.");
                }
            }
            do {
                System.out.println("Presiona C para crear un nuevo usuario, I para iniciar sesión o S para salir del juego:");
                opcionJuego = scanner.nextLine();
                if (!esEntero(opcionJuego) && opcionJuego.equalsIgnoreCase("C")) {
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

    public boolean esEntero(String opcionJuego) {
        try{
            Integer.parseInt(opcionJuego);
            return true;
        } catch (NumberFormatException e){
            return false;
        }

    }

    public void crearCuenta(Scanner scanner){
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


            String contrasena1 = " ";
            String contrasena;
            do {
                System.out.println("\nIngresa tu contraseña de entre 8 y 12 caracteres:");
                contrasena = scanner.nextLine();
                if (contrasena.length() > 12 || contrasena.length() < 8) {
                    System.out.println("La contraseña debe tener entre 8 y 12 caracteres");
                }else{
                        System.out.println("\nRepite tu contreseña:");
                        contrasena1 = scanner.nextLine();
                        if (!contrasena1.equals(contrasena)) {
                            System.out.println("\nLas contraseñas no coinciden");
                        }
                }
            }
            while (!contrasena1.equals(contrasena));

            Administrador administrador = new Administrador(nombre, nick, contrasena);
            usuarios.put(nick, administrador);
            guardarUsuarios();
            System.out.println("¡Administrador creado exitosamente!");

        }else if (eleccion.equalsIgnoreCase("J")){
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
                if (existeNick) {
                    System.out.println("El nick ya existe");
                }
            } while (existeNick);

            String contrasena1 = " ";
            String contrasena;
            do {
                System.out.println("\nIngresa tu contraseña de entre 8 y 12 caracteres:");
                contrasena = scanner.nextLine();
                if (contrasena.length() > 12 || contrasena.length() < 8) {
                    System.out.println("La contraseña debe tener entre 8 y 12 caracteres");
                }else{
                    System.out.println("\nRepite tu contreseña:");
                    contrasena1 = scanner.nextLine();
                    if (!contrasena1.equals(contrasena)) {
                        System.out.println("\nLas contraseñas no coinciden");
                    }
                }
            }
            while (!contrasena1.equals(contrasena));

            Jugador jugador = new Jugador(nombre, nick, contrasena);
            usuarios.put(nick, jugador);
            guardarUsuarios();
            System.out.println("¡Jugador creado exitosamente!");
        }else{
            System.out.println("Opcion no valida");
            this.crearCuenta(scanner);
        }
    }

    public Usuario iniciarSesion(Scanner scanner) {

        System.out.println("Seleccionaste iniciar sesión.");

        System.out.println("Ingresa tu nick:");
        String nick = scanner.nextLine();
        boolean existeUsuario = usuarios.containsKey(nick);
        Usuario usuarioJuego = usuarios.get(nick);
        if (existeUsuario) {
            System.out.println("Ingresa tu contraseña:");
            String contrasena1 = scanner.nextLine();
            if (usuarioJuego.getContrasena().equals(contrasena1)) {
                if (usuarioJuego instanceof Jugador) {
                    Jugador jugador = (Jugador) usuarioJuego;
                    if (jugador.getBloqueado()) {
                        if (jugador.getTiempoBloqueo() != null && jugador.getTiempoBloqueo().plusHours(24).isBefore(LocalDateTime.now())) {
                            jugador.setBloqueado(false); // Desbloquear si han pasado 24 horas desde el bloqueo
                        } else {
                            System.out.println("Has sido bloqueado. Inténtalo más tarde.");
                            return null; // No permitir iniciar sesión si está bloqueado
                        }
                    }
                }
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

    public void jugar(Usuario usuario, Scanner scanner){
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
                    administrador.validarCombate();
                    guardarUsuarios();

                } else if (opcion.equals("4")) {
                    // Mostrar la lista de usuarios jugadores desbloqueados para elegir quién bloquear
                    System.out.println("Lista de usuarios jugadores desbloqueados:");
                    boolean hayDesbloqueados = false;
                    for (Usuario usuarioEnLista : usuarios.values()) {
                        if (usuarioEnLista instanceof Jugador && !((Jugador) usuarioEnLista).getBloqueado()) {
                            System.out.println(usuarioEnLista.getNick());
                            hayDesbloqueados = true;
                        }
                    }
                    if (!hayDesbloqueados) {
                        System.out.println("No hay usuarios jugadores desbloqueados disponibles para bloquear.");
                    } else {
                        // Pedir al administrador que elija un usuario para bloquear
                        System.out.println("Escribe el nick del usuario que quieres bloquear:");
                        String nickBloquear = scanner.nextLine();

                        // Verificar si el usuario seleccionado existe y es un jugador desbloqueado
                        if (usuarios.containsKey(nickBloquear) && usuarios.get(nickBloquear) instanceof Jugador && !((Jugador) usuarios.get(nickBloquear)).getBloqueado()) {
                            Jugador jugadorBloquear = (Jugador) usuarios.get(nickBloquear);
                            administrador.bloquearUsuario(jugadorBloquear);
                            guardarUsuarios();
                        } else {
                            System.out.println("Usuario no encontrado o no es jugador desbloqueado.");
                        }
                    }
                } else if (opcion.equals("5")) {
                    // Mostrar la lista de usuarios bloqueados para elegir quién desbloquear
                    System.out.println("Lista de usuarios bloqueados:");
                    boolean hayBloqueados = false;
                    for (Usuario usuarioEnLista : usuarios.values()) {
                        if (usuarioEnLista instanceof Jugador && ((Jugador) usuarioEnLista).getBloqueado()) {
                            System.out.println(usuarioEnLista.getNick());
                            hayBloqueados = true;
                        }
                    }
                    if (!hayBloqueados) {
                        System.out.println("No hay usuarios jugadores bloqueados disponibles para desbloquear.");
                    } else {
                        // Pedir al administrador que elija un usuario para desbloquear
                        System.out.println("Escribe el nick del usuario que quieres desbloquear:");
                        String nickDesbloquear = scanner.nextLine();

                        // Verificar si el usuario seleccionado existe y es un jugador bloqueado
                        if (usuarios.containsKey(nickDesbloquear) && usuarios.get(nickDesbloquear) instanceof Jugador && ((Jugador) usuarios.get(nickDesbloquear)).getBloqueado()) {
                            Jugador jugadorDesbloquear = (Jugador) usuarios.get(nickDesbloquear);
                            administrador.desbloquearUsuario(jugadorDesbloquear);
                            guardarUsuarios();
                        } else {
                            System.out.println("Usuario no encontrado, no es jugador o no está bloqueado.");
                        }
                    }
                }   else if (opcion.equals("6")) {
                    break;
                }   else {
                    System.out.println("Opción no válida");
                    this.jugar(usuario, scanner);
                }

            }while (!opcion.equals("6"));

        } else if (usuario instanceof Jugador) {
            Jugador jugador = (Jugador)usuario;
            ArrayList<Combate> desafiosPendientes = jugador.getDesafiosPendientes();
            while (!jugador.getDesafiosPendientes().isEmpty()) {
                System.out.println("Tienes desafíos pendientes");
                jugador.aceptarRechazarDesafio();
                guardarUsuarios();
            }
            for (Combate combate : jugador.getCombates()) {
                if (!combate.getVisto()) {
                    System.out.println("Han tenido lugar un combate, veamos que ha pasado");
                    System.out.println(combate.getDesafiante().getNick() + " VS " + combate.getDesafiado().getNick());
                    if(!(combate.getVencedor() == null)){
                        System.out.println("¡El vencedor es: " + combate.getVencedor().getNick() + "!");
                        if(combate.getDesafiante() == combate.getVencedor()){
                            System.out.println("¡Has ganado: " + combate.getOroApostado() + " monedas de oro" + "!");
                        } else {
                            System.out.println("¡Has perdido: " + combate.getOroApostado() + " monedas de oro" + "!");
                        }
                    } else {
                        System.out.println("¡El combate ha quedado en empate, recuperas el oro apostado");
                    }
                    System.out.println("Rondas:");
                    for (int i = 0; i < combate.getRondas().size(); i++) {
                        System.out.println("Ronda " + (i + 1) + ": " + combate.getDesafiante().getNick() + ": " + combate.getRondas().get(i).getSaludDesafiado() + " puntos de vida, y " + combate.getDesafiado().getNick() + ": " + combate.getRondas().get(i).getSaludDesafiante() + " puntos de vida");
                    }
                    // Marcar el combate como visto
                    combate.setVisto(true);
                }
            }
            String op = null;
            do {
                System.out.println("¿Qué quieres hacer?\n 1. Modificar armas y armaduras. \n 2. Desafiar. \n 3. Consultar oro ganado y perdido. \n 4. Consultar ranking global. \n 5. Registrar personaje. \n 6. Dar de baja el personaje. \n 7. Dar de baja la cuenta \n 8. Salir del juego ");
                op = scanner.nextLine();
                if (op.equals("1")) {
                    Personaje personajeJugador = jugador.getPersonaje();
                    if (personajeJugador == null) {
                        System.out.println("No tienes ningún personaje registrado");
                    } else {
                        jugador.equipar(personajeJugador);
                        guardarUsuarios();
                    }
                } else if (op.equals("2")) {
                    Personaje personajeJugador = jugador.getPersonaje();
                    if (personajeJugador == null) {
                        System.out.println("No tienes ningún personaje registrado");
                    } else {
                        // Obtener la lista de jugadores disponibles para desafiar
                        ArrayList<Jugador> jugadoresDisponibles = new ArrayList<>();
                        for (Usuario usuario2 : usuarios.values()) {
                            if (usuario2 instanceof Jugador && !usuario2.getNick().equals(jugador.getNick())) {
                                Personaje personajeUsuario2 = ((Jugador) usuario2).getPersonaje();
                                if (personajeUsuario2 != null) {
                                    jugadoresDisponibles.add((Jugador) usuario2);
                                }
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
                            int opcionDesafiar = Integer.parseInt(scanner.nextLine());
                            if (opcionDesafiar >= 1 && opcionDesafiar <= jugadoresDisponibles.size()) {
                                Jugador jugadorDesafiado = jugadoresDisponibles.get(opcionDesafiar - 1);

                                // Solicitar al jugador especificar la cantidad de oro a apostar
                                System.out.println("Especifica la cantidad de oro que deseas apostar:");
                                int oroApostado = Integer.parseInt(scanner.nextLine());

                                // Crear el desafío
                                jugador.desafiar(jugador, jugadorDesafiado, oroApostado);

                                // Solicitar al administrador validar el desafío
                                guardarUsuarios();
                            } else {
                                System.out.println("Opción no válida");
                            }
                        } else {
                            System.out.println("No hay otros jugadores disponibles para desafiar en este momento");
                        }
                    }
                } else if (op.equals("3")) {
                    jugador.consultarOro();

                } else if (op.equals("4")) {
                    // Ordenar el ranking global
                    mostrarRankingGlobal();

                } else if (op.equals("5")) {
                    if (personajes.isEmpty()) {
                        System.out.println("No hay personajes disponibles para registrar.");
                    } else {
                        if (jugador.getPersonaje() == null) {
                            System.out.println("Los personajes que tienes para elegir son: ");
                            for (Personaje personaje : personajes) {
                                if (!personaje.getOcupado()) {
                                    System.out.println("- " + personaje.getNombrePersonaje() + "\n");
                                }
                            }
                            String opcionRegistrar = null;
                            for (Personaje personaje : personajes) {
                                if (!personaje.getOcupado()) {
                                    System.out.println("Quieres registrar el personaje: " + personaje.getNombrePersonaje() + " \n 1. Si. \n 2. No.");
                                    opcionRegistrar = scanner.nextLine();
                                    if (opcionRegistrar != null && opcionRegistrar.equals("1")) {
                                        if (personaje.getOcupado()) {
                                            System.out.println("El personaje ya ha sido elegido por otro jugador. Elige otro.");
                                        } else {
                                            personaje.setOcupado(true);
                                            jugador.registrarPersonaje(personaje);
                                        }
                                    }
                                }

                                if (opcionRegistrar != null && opcionRegistrar.equals("1")) {
                                    jugador.registrarPersonaje(personaje);
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Ya has elegido un personaje.");
                        }
                        guardarUsuarios();
                    }
                } else if (op.equals("6")) {
                    Personaje personaje = jugador.getPersonaje();
                    jugador.darBajaPersonaje();
                    if (personaje != null){
                        personaje.setOcupado(false);
                        System.out.println("Se ha deseleccionado el personaje");
                    }

                    guardarUsuarios();

                } else if (op.equals("7")) {
                    String nick = usuario.getNick();
                    Personaje personaje = jugador.getPersonaje();
                    if(jugador.getPersonaje() != null) {
                        jugador.darBajaPersonaje();
                        personaje.setOcupado(false);
                    }
                    if (usuarios.containsKey(nick)) {
                        usuarios.remove(nick);
                        guardarUsuarios();
                        System.out.println("Se ha eliminado la cuenta correctamente");
                        break;
                    }


                } else if (op.equals("8")) {

                } else {
                    System.out.println("Opción no válida");
                    this.jugar(usuario, scanner);
                }
            } while (!op.equals("8"));
        }
    }

    public void guardarUsuarios() {
        try {
            // Borrar el archivo de usuarios si existe
            File file = new File(Usuarios);
            if (file.exists()) {
                file.delete();
            }
            // Escribir el nuevo HashMap en el archivo
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Usuarios))) {
                oos.writeObject(usuarios);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Imprime la traza de la excepción para ayudar a identificar el problema
        }
    }
    public void cargarUsuarios() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Usuarios))) {
            HashMap<String, Usuario> usuariosCargados = (HashMap<String, Usuario>) ois.readObject();
            usuarios.clear(); // Limpiar el HashMap actual
            usuarios.putAll(usuariosCargados); // Almacenar los usuarios cargados en el HashMap
        } catch (IOException | ClassNotFoundException e) {
        }
    }

    public void guardarPersonajes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Personajes))) {
            oos.writeObject(personajes);
        } catch (IOException e) {
        }
    }

    public void cargarPersonajes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Personajes))) {
            ArrayList<Personaje> personajesCargados = (ArrayList<Personaje>) ois.readObject();
            personajes.clear(); // Limpiar la lista actual antes de cargar los personajes
            personajes.addAll(personajesCargados);
        } catch (IOException | ClassNotFoundException e) {
        }
    }

    public void mostrarRankingGlobal() {
        // Crear una lista de jugadores
        ArrayList<Jugador> jugadores = new ArrayList<>();
    
        // Obtener todos los jugadores
        for (Usuario usuario : usuarios.values()) {
            if (usuario instanceof Jugador) {
                Jugador jugador = (Jugador) usuario;
                jugadores.add(jugador);
            }
        }
    
        // Ordenar la lista de jugadores por la cantidad de oro que tienen en sus personajes
        Collections.sort(jugadores, new Comparator<Jugador>() {
            @Override
            public int compare(Jugador j1, Jugador j2) {
                int oroJugador1 = (j1.getPersonaje() != null) ? j1.getPersonaje().getOro() : 0;
                int oroJugador2 = (j2.getPersonaje() != null) ? j2.getPersonaje().getOro() : 0;
                return Integer.compare(oroJugador2, oroJugador1); // Orden descendente
            }
        });
    
        // Mostrar el ranking por pantalla
        System.out.println("Ranking Global:");
        int posicion = 1;
        for (Jugador jugador : jugadores) {
            int oroJugador = (jugador.getPersonaje() != null) ? jugador.getPersonaje().getOro() : 0;
            System.out.println(posicion + "º. Jugador " + jugador.getNick() + " con " + oroJugador + " monedas de oro");
            posicion++;
        }
    }

    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuariosFile(String usuariosFile) {
        this.Usuarios = usuariosFile;
    }

    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    public String getPersonajesFile() {
        return Personajes;
    }

    public void setPersonajesFile(String personajesFile) {
        this.Personajes = personajesFile;
    }

    public ArrayList<Personaje> getPersonajes() {
        return this.personajes;
    }
    
    public Usuario getUsuarioPorNick(String nick) {
        for (Usuario usuario : usuarios.values()) {
            if (usuario.getNick().equals(nick)) {
                return usuario;
            }
        }
        return null; // Retorna null si no se encuentra ningún usuario con el nick especificado
    }
    
    
    
    }

