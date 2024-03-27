import java.util.HashMap;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Administrador extends Usuario {
    private HashMap<String, Integer> debilidades;
    private HashMap<String, Integer> fortalezas;

    public Administrador(String nombre, String nick, String contrasena) {
        super(nombre, nick, contrasena);
        this.debilidades = new HashMap<>();
        this.fortalezas = new HashMap<>();
    }

    public void activarModificadores(String tipo, String nombre, int valor) {
        if (tipo.equalsIgnoreCase("debilidades")) {
            if (valor >= 1 && valor <= 5) {
                debilidades.put(nombre, valor);
                System.out.println("Debilidad '" + nombre + "' activada correctamente con valor " + valor + ".");
            } else {
                System.out.println("Error: El valor de la debilidad debe estar entre 1 y 5.");
            }
        } else if (tipo.equalsIgnoreCase("fortalezas")) {
            if (valor >= 1 && valor <= 5) {
                fortalezas.put(nombre, valor);
                System.out.println("Fortaleza '" + nombre + "' activada correctamente con valor " + valor + ".");
            } else {
                System.out.println("Error: El valor de la fortaleza debe estar entre 1 y 5.");
            }
        } else {
            System.out.println("Error: Tipo de modificador no reconocido. Debe ser 'debilidades' o 'fortalezas'.");
        }
    }

    public void crearPersonaje() {
        Scanner scanner = new Scanner(System.in);
        String nombre, habilidades, armas, armadura, armasActivas, armadurasActivas, esbirros;
        int oro, salud, poder, debilidades, fortalezas;

        System.out.print("Nombre del personaje: ");
        nombre = scanner.nextLine().trim();

        System.out.print("Habilidades: ");
        habilidades = scanner.nextLine().trim();

        System.out.print("Armas: ");
        armas = scanner.nextLine().trim();

        System.out.print("Armadura: ");
        armadura = scanner.nextLine().trim();

        System.out.print("Armas Activas: ");
        armasActivas = scanner.nextLine().trim();

        System.out.print("Armaduras Activas: ");
        armadurasActivas = scanner.nextLine().trim();

        System.out.print("Esbirros: ");
        esbirros = scanner.nextLine().trim();

        System.out.print("Oro: ");
        oro = scanner.nextInt();

        System.out.print("Salud: ");
        salud = scanner.nextInt();

        System.out.print("Poder: ");
        poder = scanner.nextInt();

        System.out.print("Debilidades: ");
        debilidades = scanner.nextInt();

        System.out.print("Fortalezas: ");
        fortalezas = scanner.nextInt();

        Personaje nuevoPersonaje = new Personaje(nombre, habilidades, armas, armadura, armasActivas, armadurasActivas, esbirros, oro, salud, poder, debilidades, fortalezas);
        System.out.println("Personaje '" + nombre + "' creado correctamente.");
    }

    public void editarPersonaje(Personaje personaje) {
        Scanner scanner = new Scanner(System.in);
        String nombre, habilidades, armas, armadura, armasActivas, armadurasActivas, esbirros;
        int oro, salud, poder, debilidades, fortalezas;

        System.out.println("Editando personaje: " + personaje.getNombre());

        System.out.print("Nuevo nombre del personaje: ");
        nombre = scanner.nextLine().trim();

        System.out.print("Nuevas habilidades: ");
        habilidades = scanner.nextLine().trim();

        System.out.print("Nuevas armas: ");
        armas = scanner.nextLine().trim();

        System.out.print("Nueva armadura: ");
        armadura = scanner.nextLine().trim();

        System.out.print("Nuevas armas Activas: ");
        armasActivas = scanner.nextLine().trim();

        System.out.print("Nuevas armaduras Activas: ");
        armadurasActivas = scanner.nextLine().trim();

        System.out.print("Nuevos Esbirros: ");
        esbirros = scanner.nextLine().trim();

        System.out.print("Nuevo Oro: ");
        oro = scanner.nextInt();

        System.out.print("Nueva Salud: ");
        salud = scanner.nextInt();

        System.out.print("Nuevo Poder: ");
        poder = scanner.nextInt();

        System.out.print("Nuevas Debilidades: ");
        debilidades = scanner.nextInt();

        System.out.print("Nuevas Fortalezas: ");
        fortalezas = scanner.nextInt();

        personaje.setNombre(nombre);
        personaje.setHabilidades(habilidades);
        personaje.setArmas(armas);
        personaje.setArmadura(armadura);
        personaje.setArmasActivas(armasActivas);
        personaje.setArmadurasActivas(armadurasActivas);
        personaje.setEsbirros(esbirros);
        personaje.setOro(oro);
        personaje.setSalud(salud);
        personaje.setPoder(poder);
        personaje.setDebilidades(debilidades);
        personaje.setFortalezas(fortalezas);

        System.out.println("Personaje '" + nombre + "' editado correctamente.");
    }


    public boolean validarDesafio(Jugador desafiante, Jugador desafiado, HashSet<Desafio> desafiosPendientes) {
        for (Desafio desafio : desafiosPendientes) {
            if (desafio.getDesafiante().equals(desafiante) && desafio.getDesafiado().equals(desafiado) && desafio.isAceptado()) {
                System.out.println("El desafío entre '" + desafiante.getNick() + "' y '" + desafiado.getNick() + "' ha sido validado correctamente.");
                return true;
            }
        }
        System.out.println("No se encontró ningún desafío pendiente entre '" + desafiante.getNick() + "' y '" + desafiado.getNick() + "'.");
        return false;
    }

    public void perderCombate() {
        this.ultimoCombatePerdido = LocalDateTime.now();
    }

    public boolean esBloqueado() {
        if (bloqueado)
            return true;

        if (ultimoCombatePerdido != null) {
            LocalDateTime hace24Horas = LocalDateTime.now().minusHours(24);
            if (ultimoCombatePerdido.isAfter(hace24Horas)) {
                bloqueado = true;
                return true;
            }
        }
        return false;
    }

    public void bloquearUsuario(Jugador jugador) {
        if (jugador.ultimoCombatePerdido != null) {
            LocalDateTime hace24Horas = LocalDateTime.now().minusHours(24);
            if (jugador.ultimoCombatePerdido.isAfter(hace24Horas)) {
                jugador.bloqueado = true;
                System.out.println("El jugador ha sido bloqueado.");
            } else {
                System.out.println("El jugador no ha perdido combates en las últimas 24 horas. No se puede bloquear.");
            }
        } else {
            System.out.println("El jugador no ha perdido combates. No se puede bloquear.");
        }
    }

    public void desbloquearUsuario(Jugador jugador) {
        if (jugador.ultimoCombatePerdido != null) {
            LocalDateTime hace24Horas = LocalDateTime.now().minusHours(24);
            if (jugador.ultimoCombatePerdido.isAfter(hace24Horas)) {
                System.out.println("Aún no han pasado 24 horas desde que el jugador perdió el último combate. No se puede desbloquear.");
            } else {
                jugador.bloqueado = false;
                System.out.println("El jugador ha sido desbloqueado.");
            }
        } else {
            jugador.bloqueado = false;
            System.out.println("El jugador ha sido desbloqueado.");
        }
    }
}

