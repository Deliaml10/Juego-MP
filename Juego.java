import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Juego {
    private HashMap<String,Usuario> usuarios = new HashMap();
    private ArrayList<Personaje> personajes = new ArrayList<>();

    public void start() {
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
                    jugar(usuarioJuego, scanner);

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
            boolean existeNick = true;
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
                    System.out.println("\nLas contraseñas no coindicen");
                }
            }
            while (!contrasena1.equals(contrasena));

            Administrador administrador = new Administrador(nombre, nick, contrasena);
            usuarios.put(nick, administrador);
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
            usuarios.put(nick, jugador);
            System.out.println("¡Jugador creado exitosamente!");
        }
    }

    private Usuario iniciarSesion(Scanner scanner){
        // Iniciar sesión con un usuario existente
        System.out.println("Seleccionaste iniciar sesión.");

        // Pedir datos al usuario para iniciar sesión
        System.out.println("Ingresa tu nick:");
        String nick1 = scanner.nextLine();
        System.out.println("Ingresa tu contraseña:");
        String contrasena1 = scanner.nextLine();
        boolean existeUsuario = usuarios.containsKey(nick1);
        Usuario usuarioJuego = usuarios.get(nick1);

        if (existeUsuario) {
            if (usuarioJuego.getContrasena().equals(contrasena1)) {
                System.out.println("¡Inicio de sesión exitoso!");
            } else {
                System.out.println("Nick o contraseña incorrectos");
            }
        }
        return usuarioJuego;
    }

    private void jugar(Usuario usuario, Scanner scanner){
        System.out.println("¡Empieza el juego!");
        if (usuario instanceof Administrador) {

            System.out.println("¿Qué quieres hacer?\n 1.Crear un personaje\n 2. Editar un personaje. \n 3. Validar desafíos. \n 4. Bloquear usuarios. \n 5. Desbloquear usuarios. \n6. Salir del juego. ");
            String opcion = scanner.nextLine();
            if(opcion.equals("1")) {
                ((Administrador) usuario).crearPersonaje();

            }else if (opcion.equals("2")){
                System.out.println("Escribe el nombre del personaje que quieres editar");
                String nombreBuscado = scanner.nextLine();
                Personaje personajeEditar;
                for (Personaje personaje : personajes){
                    if (personaje.getNombrePersonaje().equals(nombreBuscado)){
                        personajeEditar = personaje;
                        ((Administrador) usuario).editarPersonaje(personajeEditar);
                    }
                }

            }else if(opcion.equals("3")){
                //usuario.validarDesafios(); //Todavia no se puede hasta que no implementemos los combates

            }else if (opcion.equals("4")){
                System.out.println("Escribe el nick del usuario que quieres bloquear");
                String nickBloquear = scanner.nextLine();
                Usuario usuarioBloquear = usuarios.get(nickBloquear);
                ((Administrador) usuario).bloquearUsuario((Jugador)usuarioBloquear);

            }else if(opcion.equals("5")){
                System.out.println("Escribe el nick del usuario que quieres desbloquear");
                String nickDesbloquear = scanner.nextLine();
                Usuario usuarioDesbloquear = usuarios.get(nickDesbloquear);
                ((Administrador) usuario).desbloquearUsuario((Jugador)usuarioDesbloquear);

            }else if (opcion.equals("6")){
                System.out.println("¡Hasta luego!");

            }else{
                System.out.println("Opción no válida");
            }


        } else if (usuario instanceof Jugador) {  //esto es que es un Jugador.java

            //if (usuario.desafiosPendientes.isEmpty()) {

                System.out.println("¿Qué quieres hacer?\n 1. Elegir armas y armaduras. \n 2. Desafiar. \n 3. Consultar oro ganado y perdido. \n 4. Consultar ranking global. \n 5. Registrar personaje. \n6. Dar de baja personaje. \n 7. Dar de baja la cuenta \n 8. Salir del juego ");
                String op = scanner.nextLine();
                if(op.equals("1")) {
                    Personaje personajeJugador = ((Jugador) usuario).getPersonaje();
                    ((Jugador) usuario).equipar(personajeJugador);

                }else if (op.equals("2")){
                    //((Jugador)usuario).desafiar();

                }else if(op.equals("3")){
                    //((Jugador)usuario).rankingOro();

                }else if (op.equals("4")){
                    //((Jugador)usuario).rankingGlobal();

                }else if(op.equals("5")){
                    //jugador.registrarPersonaje();  //hay que pasarle el parámetro personaje

                }else if(op.equals("6")) {
                    //((Jugador)usuario).darBajaPersonaje();

                }else if (op.equals("7")){
                    //((Jugador)usuario).darBajaCuenta();

                }else if (op.equals("8")){
                    System.out.println("¡Hasta luego!");
                }else {
                    System.out.println("Opción no válida");
                }

            //}
            /*else{ //TODAVIA NO SE PUEDE PORQUE NO ESTA LA CLASE COMBATE

                System.out.println("Tienes desafíos pendientes. \n Pulsa A para aceptarlo o pulsa N para rechazarlo. \n Si rechazas un desafío tendrás que pagar el 10% del oro apostado.");
                String eleccion = scanner.nextLine();
                if(eleccion.equalsIgnoreCase("A")){
                    jugador.aceptarDesafio();
                }else{
                    jugador.rechazarDesafio();
                }
            }*/
        }
    }

}