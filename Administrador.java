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
        String nombre;
        ArrayList<Arma> armas = new ArrayList<>();
        ArrayList<Armadura> armaduras = new ArrayList<>();
        int tipoPersonaje;
        ArrayList<Habilidad> habilidades = new ArrayList<>();
        ArrayList<Esbirro> esbirros = new ArrayList<>();
        ArrayList<Debilidad> debilidades = new ArrayList<>();
        ArrayList<Fortaleza> fortalezas = new ArrayList<>();


        System.out.print("Nombre del personaje: ");
        nombre = scanner.nextLine().trim();

        System.out.println("Tipo de personaje (elige el 1, 2 o 3):");
        System.out.println("1. Vampiro");
        System.out.println("2. Licantropo");
        System.out.println("3. Cazador");
        tipoPersonaje = scanner.nextInt();

        System.out.print("Habilidades: ");
        System.out.println("Cuantas habilidades quieres anyadir al personaje");
        int numHabilidades = scanner.nextInt();
        for (int i = 0; i<numHabilidades; ++i) {
            switch (tipoPersonaje) {
                case 1:
                    habilidades.add(crearDisciplina());
                    break;
                case 2:
                    habilidades.add(crearDon());
                    break;
                case 3:
                    habilidades.add(crearTalento());
                    break;
            }
        }

        System.out.print("Armas: ");
        armas = crearArmas();

        System.out.print("Armaduras: ");
        armaduras = crearArmaduras();

        System.out.print("Esbirros: ");
        esbirros = crearEsbirros();

        System.out.print("Debilidades: ");
        debilidades = crearDebilidades();

        System.out.print("Fortalezas: ");
        fortalezas = crearFortalezas();

        Personaje nuevoPersonaje = new Personaje(nombre, tipoPersonaje, habilidades,  armas,  armaduras,  esbirros,  debilidades,  fortalezas);
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
                int tipo = personaje.getTipoPersonaje();
                System.out.println("Cuantas habilidades quieres anyadir al personaje");
                int numHabilidades = scanner.nextInt();
                for (int i = 0; i<numHabilidades; ++i) {
                    switch (tipo) {
                        case 1:
                            personaje.setHabilidad(crearDisciplina());
                            break;
                        case 2:
                            personaje.setHabilidad(crearDon());
                            break;
                        case 3:
                            personaje.setHabilidad(crearTalento());
                            break;
                    }
                }
                System.out.println("Habilidades del personaje cambiadas correctamente");
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
                ArrayList<Arma> armas = personaje.getArmas();
                for (Arma arma : armas){
                    if (arma.getActiva()){
                        System.out.println("Quieres desactivar el arma "+ arma.getNombreEquipo());
                        System.out.println("1.Desactivar");
                        System.out.println("2. Dejarla activa");
                        int opcionActiva = scanner.nextInt();
                        if (opcionActiva == 1){
                            arma.setActiva(false);
                            personaje.restarArmasActivas();
                        }
                    }else {
                        System.out.println("Quieres activar el arma " + arma.getNombreEquipo());
                        System.out.println("1.Activar");
                        System.out.println("2. Dejarla desactiva");
                        int opcionActiva = scanner.nextInt();
                        if (opcionActiva == 1) {
                            arma.setActiva(true);
                            personaje.sumarArmasActivas();
                        }
                    }
                }
                break;
            case 6:
                System.out.print("Nuevas armaduras activas: ");
                ArrayList<Armadura> armaduras = personaje.getArmaduras();
                for (Armadura armadura : armaduras){
                    if (armadura.getActiva()){
                        System.out.println("Quieres desactivar el arma "+ armadura.getNombreEquipo());
                        System.out.println("1.Desactivar");
                        System.out.println("2. Dejarla activa");
                        int opcionActiva = scanner.nextInt();
                        if (opcionActiva == 1){
                            armadura.setActiva(false);
                            personaje.restarArmadurasActivas();
                        }
                    }else {
                        System.out.println("Quieres activar el arma " + armadura.getNombreEquipo());
                        System.out.println("1.Activar");
                        System.out.println("2. Dejarla desactiva");
                        int opcionActiva = scanner.nextInt();
                        if (opcionActiva == 1) {
                            armadura.setActiva(true);
                            personaje.restarArmadurasActivas();
                        }
                    }
                }
                break;
            case 7:
                System.out.print("Nuevos esbirros: ");
                ArrayList<Esbirro> nuevosEsbirros = crearEsbirros();
                personaje.setEsbirros(nuevosEsbirros);
                System.out.println("Esbirros del personaje cambiados correctamente");
                break;
            case 8:
                System.out.print("Nuevas debilidades: ");
                ArrayList<Debilidad> debilidades = crearDebilidades();
                personaje.setDebilidades(debilidades);
                System.out.println("Debilidades del personaje cambiadas correctamente");
                break;
            case 9:
                System.out.print("Nuevas fortalezas: ");
                ArrayList<Fortaleza> fortalezas = crearFortalezas();
                personaje.setFortalezas(fortalezas);
                System.out.println("Fortalezas del personaje cambiadas correctamente");
                break;
            default:
                System.out.println("Opcion incorrecta.");
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
    }*/

    public void bloquearUsuario(Jugador jugador) {
        if (jugador.getUltimoCombatePerdido() != null) {
            LocalDateTime hace24Horas = LocalDateTime.now().minusHours(24);
            if (jugador.getUltimoCombatePerdido().isAfter(hace24Horas)) {
                jugador.setBloqueado(true);
                System.out.println("El jugador ha sido bloqueado.");
            } else {
                System.out.println("El jugador no ha perdido combates en las últimas 24 horas. No se puede bloquear.");
            }
        } else {
            System.out.println("El jugador no ha perdido combates. No se puede bloquear.");
        }
    }

    public void desbloquearUsuario(Jugador jugador) { //HAY QUE HACER CAMBIOS EN BLOQUEAR Y DESBLOQUEAR USUARIOS
        if (jugador.getUltimoCombatePerdido() != null) {
            LocalDateTime hace24Horas = LocalDateTime.now().minusHours(24);
            if (jugador.getUltimoCombatePerdido().isAfter(hace24Horas)) {
                System.out.println("Aún no han pasado 24 horas desde que el jugador perdió el último combate. No se puede desbloquear.");
            } else {
                jugador.setBloqueado(false);
                System.out.println("El jugador ha sido desbloqueado.");
            }
        } else {
            jugador.setBloqueado(false);
            System.out.println("El jugador ha sido desbloqueado.");
        }
    }

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
                    break;
                case 2:
                    System.out.println("Escribe con un numero entre el 1 y el 5 el nivel de dependencia del Ghoul");
                    int dependencia = scanner.nextInt();
                    Esbirro ghoul = new Ghoul(nombreEsbirro, saludEsbirro, dependencia);
                    esbirros.add(ghoul);
                    break;
                case 3:
                    System.out.println("Escribe el pacto entre el demonio y su amo");
                    String pacto = scanner.nextLine();
                    System.out.println("A continuacion escribe cuantos esbirros tiene el demonio");
                    ArrayList<Esbirro> esbirrosDemonio = this.crearEsbirros();
                    Esbirro demonio = new Demonio(nombreEsbirro, saludEsbirro, pacto, esbirrosDemonio);
                    esbirros.add(demonio);
                    break;
            }
        }
        return esbirros;
    }

    private ArrayList<Arma> crearArmas(){
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
            }else{
                activa = false;
            }
            Armadura armadura = new Armadura(nombreArmadura, manos, valor, activa);
            armaduras.add(armadura);
        }
        return armaduras;
    }

    private ArrayList<Debilidad> crearDebilidades(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Debilidad> debilidades = new ArrayList<>();

        System.out.println("Escribe con un numero cuantas debilidades quieres anyadir al personaje");
        int numDebilidades = scanner.nextInt();
        System.out.print("Debilidades: ");
        for (int i = 0; i < numDebilidades; ++i) {
            System.out.println("Escribe el nombre de la debilidad");
            String nombreDebilidad = scanner.nextLine();
            System.out.println("Escribe su valor (numero del 1 al 5)");
            int valor = scanner.nextInt();
            System.out.println("Quieres que el modificador este activado (contesta 1 o 2)");
            System.out.println("1. Si");
            System.out.println("2. No");
            int opcion = scanner.nextInt();
            boolean activado = false;
            switch (opcion){
                case 1:
                    activado = true;
                case 2:
                    activado = false;
            }

            Debilidad debilidad = new Debilidad(nombreDebilidad, valor, activado);
            debilidades.add(debilidad);
        }
        return debilidades;
    }

    private ArrayList<Fortaleza> crearFortalezas(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Fortaleza> fortalezas = new ArrayList<>();

        System.out.println("Escribe con un numero cuantas debilidades quieres anyadir al personaje");
        int numFortalezas = scanner.nextInt();
        System.out.print("Fortalezas: ");
        for (int i = 0; i < numFortalezas; ++i) {
            System.out.println("Escribe el nombre de la fortaleza");
            String nombreFortaleza = scanner.nextLine();
            System.out.println("Escribe su valor (numero del 1 al 5)");
            int valor = scanner.nextInt();
            System.out.println("Quieres que el modificador este activado (contesta 1 o 2)");
            System.out.println("1. Si");
            System.out.println("2. No");
            int opcion = scanner.nextInt();
            boolean activado = false;
            switch (opcion){
                case 1:
                    activado = true;
                case 2:
                    activado = false;
            }
            Fortaleza fortaleza = new Fortaleza(nombreFortaleza, valor, activado);
            fortalezas.add(fortaleza);
        }
        return fortalezas;
    }

    private Disciplina crearDisciplina(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe el nombre de la disciplina");
        String nombre = scanner.nextLine();
        System.out.println("Escribe el valor de la disciplina");
        int valor = scanner.nextInt();
        System.out.println("Cual es la sangre necesaria para usar la disciplina");
        int sangreNecesaria = scanner.nextInt();
        Disciplina disciplina = new Disciplina(nombre, valor, sangreNecesaria);

        return disciplina;
    }

    private Don crearDon(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe el nombre del don");
        String nombre = scanner.nextLine();
        System.out.println("Escribe el valor del don");
        int valor = scanner.nextInt();
        System.out.println("Cual es la rabia necesaria para usar el don");
        int rabiaNecesaria = scanner.nextInt();
        Don don = new Don(nombre, valor, rabiaNecesaria);

        return don;
    }

    private Talento crearTalento(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe el nombre del talento");
        String nombre = scanner.nextLine();
        Talento talento = new Talento(nombre);
        return talento;
    }
}