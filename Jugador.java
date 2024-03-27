import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jugador extends Usuario {
    private String numero;
    private Personaje personaje;
    private int oro;
    private ArrayList<String> desafiosPendientes;
    public Jugador(String nombre, String contrasena, String nick) {
        super(nombre, contrasena, nick);
        this.numero = numeroRegistro();
        this.personaje = null;
        this.desafiosPendientes = new ArrayList<>();
        this.oro = 0;
    }

    public String numeroRegistro() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";

        Random random = new Random();
        StringBuilder codigo = new StringBuilder();

        int indice = random.nextInt(letras.length());
        codigo.append(letras.charAt(indice));

        for (int i = 0; i < 2; i++) {
            int indice1 = random.nextInt(numeros.length());
            codigo.append(numeros.charAt(indice1));
        }
        for (int i = 0; i < 2; i++) {
            int indice2 = random.nextInt(letras.length());
            codigo.append(letras.charAt(indice2));
        }

        return codigo.toString();
    }

    public void registrarPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public void eliminarPersonaje() {
        this.setNombre("");
        this.setContrasena("");
        this.setNick("");
        this.numero = "";
    }

    public void equipar(ArrayList<Arma> armasDisponibles, ArrayList<Defensa> defensasDisponibles) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Qué deseas equipar?");
        System.out.println("1. Armas");
        System.out.println("2. Defensas");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                System.out.println("Armas disponibles:");
                for (int i = 0; i < armasDisponibles.size(); i++) {
                    Arma arma = armasDisponibles.get(i);
                    System.out.println((i + 1) + ". " + arma.getNombre() + " - Tipo: " + arma.getTipo());
                }
                System.out.println("Selecciona un arma para equipar (0 para salir): ");
                int seleccionArma = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                if (seleccionArma == 0 || seleccionArma > armasDisponibles.size()) {
                    System.out.println("Saliendo del menú de equipamiento...");
                    return;
                }
                Arma armaSeleccionada = armasDisponibles.get(seleccionArma - 1);
                // Comprobar si la arma es de una o dos manos y si se puede equipar
                if (armaSeleccionada.getTipo().equals("1 mano")) {
                    if (this.armasActivas.size() >= 2) {
                        System.out.println("Ya tienes equipadas dos armas de una mano. No puedes equipar más.");
                        return;
                    }
                } else if (armaSeleccionada.getTipo().equals("2 manos")) {
                    if (!this.armasActivas.isEmpty()) {
                        System.out.println("Ya tienes equipada un arma de dos manos. No puedes equipar más.");
                        return;
                    }
                }
                this.armasActivas.add(armaSeleccionada);
                armasDisponibles.remove(armaSeleccionada);
                System.out.println("Se ha equipado el arma '" + armaSeleccionada.getNombre() + "'.");
                break;
            case 2:
                System.out.println("Defensas disponibles:");
                for (int i = 0; i < defensasDisponibles.size(); i++) {
                    Defensa defensa = defensasDisponibles.get(i);
                    System.out.println((i + 1) + ". " + defensa.getNombre());
                }
                System.out.println("Selecciona una defensa para equipar (0 para salir): ");
                int seleccionDefensa = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                if (seleccionDefensa == 0 || seleccionDefensa > defensasDisponibles.size()) {
                    System.out.println("Saliendo del menú de equipamiento...");
                    return;
                }
                Defensa defensaSeleccionada = defensasDisponibles.get(seleccionDefensa - 1);
                this.defensasActivas.add(defensaSeleccionada);
                defensasDisponibles.remove(defensaSeleccionada);
                System.out.println("Se ha equipado la defensa '" + defensaSeleccionada.getNombre() + "'.");
                break;
            default:
                System.out.println("Opción inválida. Saliendo del menú de equipamiento...");
                break;
        }
    }

    public void aceptarDesafio() {
        if (desafiosPendientes.isEmpty()) {
            System.out.println("No hay desafíos pendientes.");
            return;
        }
        System.out.println("Desafíos pendientes:");
        for (int i = 0; i < desafiosPendientes.size(); i++) {
            String desafio = desafiosPendientes.get(i);
            System.out.println((i + 1) + ". " + desafio);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione el número del desafío que desea aceptar: ");
        int seleccion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        if (seleccion < 1 || seleccion > desafiosPendientes.size()) {
            System.out.println("Selección inválida.");
            return;
        }
        String desafioSeleccionado = desafiosPendientes.get(seleccion - 1);
        System.out.println("Desafío aceptado: " + desafioSeleccionado);
        if (oro < desafioSeleccionado.getOro()) {
            System.out.println("No tienes suficiente oro para aceptar este desafío.");
            return;
        }

        System.out.println("Desafío de " + desafioSeleccionado.getNickOponente() + " aceptado.");
    }

    public void setDesafiosPendientes(ArrayList<String> desafiosPendientes) {
        this.desafiosPendientes = desafiosPendientes;
    }
}

    public void setDesafiosPendientes(ArrayList<String> desafiosPendientes) {
        this.desafiosPendientes = desafiosPendientes;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public int consultarOro() {
        return personaje.getOro();
    }

    public void actualizarOro(int cantidad) {
        personaje.setOro(cantidad);
    }

    public void generarNickUnico(ArrayList<Usuario> usuarios) {
        boolean nickUnico = false;
        Scanner scanner = new Scanner(System.in);

        while (!nickUnico) {
            System.out.print("Por favor, elija su nick: ");
            String nick = scanner.nextLine().trim();
            if (!validarNick(nick, usuarios)) {
                this.setNick(nick);
                nickUnico = true;
            } else {
                System.out.println("El nick ya existe. Por favor, elija otro.");
            }
        }
    }

    private boolean validarNick(String nick, ArrayList<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Jugador && ((Jugador) usuario).getNick().equals(nick)) {
                return true;
            }
        }
        return false;
    }

    public void consultarRanking(ArrayList<Jugador> jugadores) {
        Collections.sort(jugadores, new Comparator<Jugador>() {
            @Override
            public int compare(Jugador jugador1, Jugador jugador2) {
                return jugador2.getPuntos() - jugador1.getPuntos();
            }
        });

        // Imprimir el ranking
        System.out.println("Ranking de Jugadores:");
        System.out.println("=======================");
        System.out.printf("%-10s %-15s %-10s%n", "Posición", "Nick", "Puntos");
        System.out.println("=======================");
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador jugador = jugadores.get(i);
            System.out.printf("%-10d %-15s %-10d%n", i + 1, jugador.getNick(), jugador.getPuntos());
        }
        System.out.println("=======================");
    }
}
