import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Administrador extends Usuario {

    public Administrador(String nombre, String nick, String contrasena) {
        super(nombre, nick, contrasena);
    }

    public Personaje crearPersonaje() {
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
        System.out.println("2. Licántropo");
        System.out.println("3. Cazador");
        tipoPersonaje = scanner.nextInt();

        System.out.print("Habilidades: ");
        System.out.println("Cuantas habilidades quieres añadir al personaje");
        int numHabilidades = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numHabilidades; ++i) {
            System.out.println("Escribe el nombre de la habilidad");
            String nombreHabilidad = scanner.nextLine();
            switch (tipoPersonaje) {
                case 1:
                    habilidades.add(crearDisciplina(nombreHabilidad));
                    break;
                case 2:
                    habilidades.add(crearDon(nombreHabilidad));
                    break;
                case 3:
                    habilidades.add(crearTalento(nombreHabilidad));
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

        Personaje nuevoPersonaje = new Personaje(nombre, tipoPersonaje, habilidades, armas, armaduras, esbirros, debilidades, fortalezas);
        System.out.println("Personaje '" + nombre + "' creado correctamente.");
        return nuevoPersonaje;
    }

    public void editarPersonaje(Personaje personaje) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Editando personaje: " + personaje.getNombrePersonaje());
        System.out.println("Seleccione la característica que desea cambiar:");
        System.out.println("1. Nombre");
        System.out.println("2. Habilidades");
        System.out.println("3. Armas");
        System.out.println("4. Armaduras");
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
                System.out.println("Cuantas habilidades quieres añadir al personaje");
                int numHabilidades = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < numHabilidades; ++i) {
                    System.out.println("Escribe el nombre de la habilidad");
                    String nombreHabilidad = scanner.nextLine();
                    switch (tipo) {
                        case 1:
                            personaje.setHabilidad(crearDisciplina(nombreHabilidad));
                            break;
                        case 2:
                            personaje.setHabilidad(crearDon(nombreHabilidad));
                            break;
                        case 3:
                            personaje.setHabilidad(crearTalento(nombreHabilidad));
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
                for (Arma arma : armas) {
                    if (arma.getActiva()) {
                        System.out.println("¿Quieres desactivar el arma " + arma.getNombreEquipo() + "? (S/N)");
                        char opcionActiva = scanner.next().charAt(0);
                        if (opcionActiva == 'S' || opcionActiva == 's') {
                            arma.setActiva(false);
                            personaje.restarArmasActivas();
                        }
                    } else {
                        System.out.println("¿Quieres activar el arma " + arma.getNombreEquipo() + "? (S/N)");
                        char opcionActiva = scanner.next().charAt(0);
                        if (opcionActiva == 'S' || opcionActiva == 's') {
                            arma.setActiva(true);
                            personaje.sumarArmasActivas();
                        }
                    }
                }
                break;
                case 6:
                System.out.print("Nuevas armaduras activas: ");
                ArrayList<Armadura> armaduras = personaje.getArmaduras();
                for (Armadura armadura : armaduras) {
                    if (armadura.getActiva()) {
                        System.out.println("Quieres desactivar la armadura " + armadura.getNombreEquipo());
                        System.out.println("1. Desactivar");
                        System.out.println("2. Dejarla activa");
                        int opcionActiva = scanner.nextInt();
                        if (opcionActiva == 1) {
                            armadura.setActiva(false);
                            personaje.restarArmadurasActivas(); // Reducir el contador de armaduras activas
                        }
                    } else {
                        System.out.println("Quieres activar la armadura " + armadura.getNombreEquipo());
                        System.out.println("1. Activar");
                        System.out.println("2. Dejarla desactivada");
                        int opcionActiva = scanner.nextInt();
                        if (opcionActiva == 1) {
                            armadura.setActiva(true);
                            personaje.sumarArmadurasActivas(); // Incrementar el contador de armaduras activas
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
                System.out.println("Opción incorrecta.");
        }
    }

    private ArrayList<Esbirro> crearEsbirros() {
        ArrayList<Esbirro> esbirros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe con un numero cuantos esbirros quieres que tenga el personaje/demonio");
        int numEsbirros = scanner.nextInt();
        System.out.print("Esbirros: ");
        for (int i = 0; i < numEsbirros; ++i) {
            int tipoEsbirro = 0;
            do {
                System.out.println("De qué tipo quieres que sea el esbirro, elige uno del siguientes con numeros:");
                System.out.println("1. Humano");
                System.out.println("2. Ghoul");
                System.out.println("3. Demonio");
                tipoEsbirro = scanner.nextInt();
            } while ((tipoEsbirro < 1 || tipoEsbirro > 3));
            scanner.nextLine();
            System.out.println("Escribe el nombre del esbirro");
            String nombreEsbirro = scanner.nextLine();
            System.out.println("Cuanta salud tiene (del 1 al 5)");
            int saludEsbirro = scanner.nextInt();
            switch (tipoEsbirro) {
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
                    scanner.nextLine();
                    System.out.println("Escribe el pacto entre el demonio y su amo");
                    String pacto = scanner.nextLine();
                    ArrayList<Esbirro> esbirrosDemonio = this.crearEsbirros();
                    Esbirro demonio = new Demonio(nombreEsbirro, saludEsbirro, pacto, esbirrosDemonio);
                    esbirros.add(demonio);
                    break;
            }
        }
        return esbirros;
    }

    private ArrayList<Arma> crearArmas() {
        ArrayList<Arma> armas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe con un numero cuantas armas quieres anyadir al personaje");
        int numArmas = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Armas: ");
        for (int i = 0; i < numArmas; ++i) {
            System.out.println("Escribe el nombre del arma");
            String nombreArma = scanner.nextLine();
            System.out.println("Escribe su valor (numero del 1 al 5)");
            int valor = scanner.nextInt();
            System.out.println("Manos que ocupa (1 o 2)");
            int manos = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Si quieres que el arma esté activa escribe 1, sino pulsa otra tecla");
            String activaString = scanner.nextLine();
            boolean activa = activaString.equals("1");
            Arma arma = new Arma(nombreArma, manos, valor, activa);
            armas.add(arma);
        }
        return armas;
    }

    private ArrayList<Armadura> crearArmaduras() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Armadura> armaduras = new ArrayList<>();
    
        System.out.println("Escribe con un numero cuantas armaduras quieres anyadir al personaje");
        int numArmaduras = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Armaduras: ");
        for (int i = 0; i < numArmaduras; ++i) {
            System.out.println("Escribe el nombre de la armadura");
            String nombreArmadura = scanner.nextLine();
            System.out.println("Escribe su valor (numero del 1 al 5)");
            int valor = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            System.out.println("Manos que ocupa (1 o 2)");
            int manos = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            System.out.println("Si quieres que la armadura esté activa escribe 1, sino pulsa otra tecla");
            String activaString = scanner.nextLine();
            boolean activa = activaString.equals("1");
            Armadura armadura = new Armadura(nombreArmadura, manos, valor, activa);
            armaduras.add(armadura);
        }
        return armaduras;
    }
    

    private ArrayList<Debilidad> crearDebilidades() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Debilidad> debilidades = new ArrayList<>();

        System.out.println("Escribe con un numero cuantas debilidades quieres anyadir al personaje");
        int numDebilidades = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Debilidades: ");
        for (int i = 0; i < numDebilidades; ++i) {
            System.out.println("Escribe el nombre de la debilidad");
            String nombreDebilidad = scanner.nextLine();
            System.out.println("Escribe su valor (numero del 1 al 5)");
            int valor = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Quieres que el modificador este activado (contesta 1 o 2)");
            System.out.println("1. Si");
            System.out.println("2. No");
            int opcion = scanner.nextInt();
            boolean activado = opcion == 1;
            scanner.nextLine();
            Debilidad debilidad = new Debilidad(nombreDebilidad, valor, activado);
            debilidades.add(debilidad);
        }
        return debilidades;
    }

    private ArrayList<Fortaleza> crearFortalezas() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Fortaleza> fortalezas = new ArrayList<>();

        System.out.println("Escribe con un numero cuantas debilidades quieres anyadir al personaje");
        int numFortalezas = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Fortalezas: ");
        for (int i = 0; i < numFortalezas; ++i) {
            System.out.println("Escribe el nombre de la fortaleza");
            String nombreFortaleza = scanner.nextLine();
            System.out.println("Escribe su valor (numero del 1 al 5)");
            int valor = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Quieres que el modificador este activado (contesta 1 o 2)");
            System.out.println("1. Si");
            System.out.println("2. No");
            int opcion = scanner.nextInt();
            boolean activado = opcion == 1;
            scanner.nextLine();
            Fortaleza fortaleza = new Fortaleza(nombreFortaleza, valor, activado);
            fortalezas.add(fortaleza);
        }
        return fortalezas;
    }

    private Disciplina crearDisciplina(String nombre) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe el valor de la disciplina");
        int valor = scanner.nextInt();
        System.out.println("Cual es la sangre necesaria para usar la disciplina");
        int sangreNecesaria = scanner.nextInt();
        scanner.nextLine();
        Disciplina disciplina = new Disciplina(nombre, valor, sangreNecesaria);

        return disciplina;
    }

    private Don crearDon(String nombre) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe el valor del don");
        int valor = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Escribe el valor de rabia necesaria");
        int rabiaNecesaria = scanner.nextInt();
        scanner.nextLine();
        Don don = new Don(nombre, valor, rabiaNecesaria);

        return don;
    }

    private Talento crearTalento(String nombre) {
        Talento talento = new Talento(nombre);

        return talento;
    }

    public void bloquearUsuario(Jugador jugador) {
        if (!jugador.getBloqueado()) {
            jugador.setBloqueado(true);
            jugador.setTiempoBloqueo(LocalDateTime.now());
            System.out.println("El usuario " + jugador.getNick() + " ha sido bloqueado.");
        } else {
            System.out.println("El usuario " + jugador.getNick() + " ya está bloqueado.");
        }
    }
    
    public void desbloquearUsuario(Jugador jugador) {
        if (jugador.getBloqueado()) {
            jugador.setBloqueado(false);
            jugador.setTiempoBloqueo(null); // Establecer el tiempo de bloqueo como null
            System.out.println("El usuario '" + jugador.getNick() + "' ha sido desbloqueado.");
        } else {
            System.out.println("El usuario '" + jugador.getNick() + "' no está bloqueado.");
        }
    }
    
    
}
