import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Administrador extends Usuario {

    public Administrador(String nombre, String nick, String contrasena) {
        super(nombre, nick, contrasena);
    }



    public void crearPersonaje() {
        Scanner scanner = new Scanner(System.in);
        String nombre, habilidades, input;
        String[] convertidor;
        ArrayList<Arma> armas = new ArrayList<>();
        ArrayList<Armadura> armaduras = new ArrayList<>();
        int armadurasActivas = 0;
        ArrayList<Esbirro> esbirros = new ArrayList<>();
        ArrayList<Debilidad> debilidades = new ArrayList<>();
        ArrayList<Fortaleza> fortalezas = new ArrayList<>();


        System.out.print("Nombre del personaje: ");
        nombre = scanner.nextLine().trim();

        System.out.print("Habilidades: ");
        habilidades = scanner.nextLine().trim();

        System.out.print("Armas: ");
        armas = crearArmas();

        System.out.print("Armaduras: ");
        armaduras = crearArmaduras();

        System.out.print("Esbirros: ");
        esbirros = crearEsbirros();

        System.out.print("Debilidades: ");
        /*debilidades = scanner.nextInt();*/

        System.out.print("Fortalezas: ");
        /*fortalezas = scanner.nextInt();*/

        Personaje nuevoPersonaje = new Personaje(nombre,  habilidades,  armas,  armaduras,  esbirros,  debilidades,  fortalezas);
        System.out.println("Personaje '" + nombre + "' creado correctamente.");
    }

    public void editarPersonaje(Personaje personaje) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Editando personaje: " + personaje.getNombrePersonaje());
        System.out.println("Seleccione la característica que desea cambiar:");
        System.out.println("1. Nombre");
        System.out.println("2. Habilidades");
        System.out.println("3. Armas");
        System.out.println("4. Armadura");
        System.out.println("5. Armas Activas");
        System.out.println("6. Armaduras Activas");
        System.out.println("7. Esbirros");
        System.out.println("8. Debilidades");
        System.out.println("9. Fortalezas");

        opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                System.out.print("Nuevo nombre del personaje: ");
                String nombre = scanner.nextLine().trim();
                personaje.setNombrePersonaje(nombre);
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
                ArrayList<Arma> nuevasArmas = crearArmas();
                personaje.setArmas(nuevasArmas);
                System.out.println("Armas del personaje cambiadas correctamente");
                break;
            case 4:
                System.out.print("Nuevas armaduras: ");
                ArrayList<Armadura> nuevasArmaduras = crearArmaduras();
                personaje.setArmaduras(nuevasArmaduras);
                System.out.println("Armaduras del personaje cambiadas correctamente");
                break;
            case 5:
                System.out.print("Nuevas armas activas: ");
                String armasActivas = scanner.nextLine().trim();
                /*personaje.sumaArmasActivas(armasActivas);*/
                break;
            case 6:
                System.out.print("Nuevas armaduras activas: ");
                String armadurasActivas = scanner.nextLine().trim();
                /*personaje.setArmadurasActivas(armadurasActivas);*/
                break;
            case 7:
                System.out.print("Nuevos esbirros: ");
                ArrayList<Esbirro> nuevosEsbirros = crearEsbirros();
                personaje.setEsbirros(nuevosEsbirros);
                System.out.println("Esbirros del personaje cambiados correctamente");
                break;
            case 8:
                System.out.print("Nuevas debilidades: ");
                int debilidades = scanner.nextInt();
                /*personaje.setDebilidades(debilidades);*/
                System.out.println("Debilidades del personaje cambiadas correctamente a: " + debilidades);
                break;
            case 9:
                System.out.print("Nuevas fortalezas: ");
                int fortalezas = scanner.nextInt();
                /*personaje.setFortalezas(fortalezas);*/
                System.out.println("Fortalezas del personaje cambiadas correctamente a: " + fortalezas);
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    public void activarModificadores(Personaje personaje, String nombre, int valor) {
        /*if (tipo.equalsIgnoreCase("debilidades")) {
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
        }*/
    }

    /*public boolean validarDesafio(Jugador desafiante, Jugador desafiado, HashSet<Desafio> desafiosPendientes) {
        for (Desafio desafio : desafiosPendientes) {
            if (desafio.getDesafiante().equals(desafiante) && desafio.getDesafiado().equals(desafiado) && desafio.isAceptado()) {
                System.out.println("El desafío entre '" + desafiante.getNick() + "' y '" + desafiado.getNick() + "' ha sido validado correctamente.");
                return true;
            }
        }
        System.out.println("No se encontró ningún desafío pendiente entre '" + desafiante.getNick() + "' y '" + desafiado.getNick() + "'.");
        return false;
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
*/

    private ArrayList<Esbirro> crearEsbirros(){
        ArrayList<Esbirro> esbirros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe con un numero cuantos esbirros quieres que tenga el personaje/demonio");
        int numEsbirros = scanner.nextInt();
        System.out.print("Esbirros: ");
        for (int i = 0; i < numEsbirros; ++i){
            int tipoEsbirro = 0;
            do {
                System.out.println("De que tipo quieres que sea el esbirro, elige uno del siguientes con numeros:");
                System.out.println("1. Humano");
                System.out.println("2. Ghoul");
                System.out.println("3. Demonio");
                tipoEsbirro = scanner.nextInt();
            }while (tipoEsbirro < 1 || tipoEsbirro > 3);
            System.out.println("Escribe el nombre del esbirro");
            String nombreEsbirro = scanner.nextLine();
            System.out.println("Cuanta salud tiene (del 1 al 5)");
            int saludEsbirro = scanner.nextInt();
            switch (tipoEsbirro){
                case 1:
                    int lealtad = 0;
                    do {
                        System.out.println("Elige la lealtad del esbirro humano:");
                        System.out.println("1. Baja");
                        System.out.println("2. Media");
                        System.out.println("3. Alta");
                        lealtad = scanner.nextInt();
                    } while (lealtad < 1 || lealtad > 3);
                    Esbirro humano = new Humano(nombreEsbirro, saludEsbirro, lealtad);
                    esbirros.add(humano);
                case 2:
                    System.out.println("Escribe con un numero entre el 1 y el 5 el nivel de dependencia del Ghoul");
                    int dependencia = scanner.nextInt();
                    Esbirro ghoul = new Ghoul(nombreEsbirro, saludEsbirro, dependencia);
                    esbirros.add(ghoul);
                case 3:
                    System.out.println("Escribe el pacto entre el demonio y su amo");
                    String pacto = scanner.nextLine();
                    System.out.println("A continuacion escribe cuantos esbirros tiene el demonio");
                    ArrayList<Esbirro> esbirrosDemonio = this.crearEsbirros();
                    Esbirro demonio = new Demonio(nombreEsbirro, saludEsbirro, pacto, esbirrosDemonio);
                    esbirros.add(demonio);
            }
        }
        return esbirros;
    }

    private ArrayList<Arma> crearArmas(){
        int armasActivas = 0;
        ArrayList<Arma> armas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe con un numero cuantas armas quieres anyadir al personaje");
        int numArmas = scanner.nextInt();
        System.out.print("Armas: ");
        for (int i = 0; i < numArmas; ++i){
            System.out.println("Escribe el nombre del arma");
            String nombreArma = scanner.nextLine();
            System.out.println("Escribe su valor (numero del 1 al 5)");
            int valor = scanner.nextInt();
            System.out.println("Manos que ocupa (1 o 2)");
            int manos = scanner.nextInt();
            System.out.println("Si quieres que el arma este activa escribe 1, sino pulsa otra tecla");
            String activaString = scanner.nextLine();
            boolean activa;
            if (activaString.equals('1')){
                activa = true;
                armasActivas += 1;
            }else{
                activa = false;
            }
            Arma arma = new Arma(nombreArma, manos, valor, activa);
            armas.add(arma);
        }
        return armas;
    }

    private ArrayList<Armadura> crearArmaduras(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Armadura> armaduras = new ArrayList<>();
        int armadurasActivas = 0;
        System.out.println("Escribe con un numero cuantas armaduras quieres anyadir al personaje");
        int numArmaduras = scanner.nextInt();
        System.out.print("Armaduras: ");
        for (int i = 0; i < numArmaduras; ++i){
            System.out.println("Escribe el nombre de la armadura");
            String nombreArmadura = scanner.nextLine();
            System.out.println("Escribe su valor (numero del 1 al 5)");
            int valor = scanner.nextInt();
            System.out.println("Manos qe ocupa (1 o 2)");
            int manos = scanner.nextInt();
            System.out.println("Si quieres que la armadura este activa escribe 1, sino pulsa otra tecla");
            String activaString = scanner.nextLine();
            boolean activa;
            if (activaString.equals('1')){
                activa = true;
                armadurasActivas += 1;
            }else{
                activa = false;
            }
            Armadura armadura = new Armadura(nombreArmadura, manos, valor, activa);
            armaduras.add(armadura);
        }
        return armaduras;
    }
}