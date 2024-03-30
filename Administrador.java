import java.util.HashMap;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Administrador extends Usuario {
    private HashMap<String, Integer> debilidades;
    private HashMap<String, Integer> fortalezas;
    private LocalDateTime ultimoCombatePerdido;

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
        int opcion;

        System.out.println("Editando personaje: " + personaje.getNombre());
        System.out.println("Seleccione la característica que desea cambiar:");
        System.out.println("1. Nombre");
        System.out.println("2. Habilidades");
        System.out.println("3. Armas");
        System.out.println("4. Armadura");
        System.out.println("5. Armas Activas");
        System.out.println("6. Armaduras Activas");
        System.out.println("7. Esbirros");
        System.out.println("8. Oro");
        System.out.println("9. Salud");
        System.out.println("10. Poder");
        System.out.println("11. Debilidades");
        System.out.println("12. Fortalezas");

        opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                System.out.print("Nuevo nombre del personaje: ");
                String nombre = scanner.nextLine().trim();
                personaje.setNombre(nombre);
                System.out.println("Nombre del personaje cambiado correctamente a: " + nombre);
                break;
            case 2:
                System.out.print("Nuevas habilidades: ");
                String habilidades = scanner.nextLine().trim();
                personaje.setHabilidades(habilidades);
                System.out.println("Habilidades del personaje cambiadas correctamente a: " + habilidades);
                break;
            case 3:
                System.out.print("Nuevas armas: ");
                String armas = scanner.nextLine().trim();
                personaje.setArmas(armas);
                System.out.println("Armas del personaje cambiadas correctamente a: " + armas);
                break;
            case 4:
                System.out.print("Nueva armadura: ");
                String armadura = scanner.nextLine().trim();
                personaje.setArmadura(armadura);
                System.out.println("Armadura del personaje cambiada correctamente a: " + armadura);
                break;
            case 5:
                System.out.print("Nuevas armas activas: ");
                String armasActivas = scanner.nextLine().trim();
                personaje.setArmasActivas(armasActivas);
                System.out.println("Armas activas del personaje cambiadas correctamente a: " + armasActivas);
                break;
            case 6:
                System.out.print("Nuevas armaduras activas: ");
                String armadurasActivas = scanner.nextLine().trim();
                personaje.setArmadurasActivas(armadurasActivas);
                System.out.println("Armaduras activas del personaje cambiadas correctamente a: " + armadurasActivas);
                break;
            case 7:
                System.out.print("Nuevos esbirros: ");
                String esbirros = scanner.nextLine().trim();
                personaje.setEsbirros(esbirros);
                System.out.println("Esbirros del personaje cambiados correctamente a: " + esbirros);
                break;
            case 8:
                System.out.print("Nuevo oro: ");
                int oro = scanner.nextInt();
                personaje.setOro(oro);
                System.out.println("Oro del personaje cambiado correctamente a: " + oro);
                break;
            case 9:
                System.out.print("Nueva salud: ");
                int salud = scanner.nextInt();
                personaje.setSalud(salud);
                System.out.println("Salud del personaje cambiada correctamente a: " + salud);
                break;
            case 10:
                System.out.print("Nuevo poder: ");
                int poder = scanner.nextInt();
                personaje.setPoder(poder);
                System.out.println("Poder del personaje cambiado correctamente a: " + poder);
                break;
            case 11:
                System.out.print("Nuevas debilidades: ");
                int debilidades = scanner.nextInt();
                personaje.setDebilidades(debilidades);
                System.out.println("Debilidades del personaje cambiadas correctamente a: " + debilidades);
                break;
            case 12:
                System.out.print("Nuevas fortalezas: ");
                int fortalezas = scanner.nextInt();
                personaje.setFortalezas(fortalezas);
                System.out.println("Fortalezas del personaje cambiadas correctamente a: " + fortalezas);
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }
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

        public void crearCombate(Jugador oponente){
            Combate combate = new Combate(this, oponente);
            combate.iniciarCombate();
        }
}

