import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jugador extends Usuario {
    private final String numeroRegistro;
    private Personaje personaje;
    private boolean bloqueado;
    private ArrayList<Combate> desafiosPendientes = new ArrayList<>();
    private ArrayList<Combate> combates = new ArrayList<>();
    private LocalDateTime tiempoBloqueo;


    public Jugador(String nombre, String contrasena, String nick) {
        super(nombre, contrasena, nick);
        this.numeroRegistro = crearNumeroRegistro();
        this.personaje = null;
        this.bloqueado = false;
        this.desafiosPendientes = new ArrayList<>();
    }

    public String crearNumeroRegistro() {
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
        this.personaje = null;
    }


    public void equipar(Personaje personaje) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("¿Qué deseas equipar o desequipar?");
        System.out.println("1. Equipar");
        System.out.println("2. Desequipar");
        String opcion1 = scanner.nextLine();
        switch (opcion1) {
            case "1":
                System.out.println("¿Qué deseas equipar armas o armaduras?");
                System.out.println("1. Armas");
                System.out.println("2. Armaduras");
                System.out.print("Selecciona una opción: ");
                String opcion = scanner.nextLine();
    
                switch (opcion) {
                    case "1":
                        System.out.println("Armas disponibles:");
                        for (Arma arma : this.personaje.getArmas()) {
                            if (arma.getActiva()) {
                                System.out.println("Nombre del arma: " + arma.getNombreEquipo() + ". Manos que ocupa: " + arma.getManos());
                            }
                        }
                        String seleccionArma;
                        do {
                            System.out.println("Elige una opcion:\n 1. Equipar armas\n 2. Salir ");
                            seleccionArma = scanner.nextLine();
                            if (seleccionArma.equals("1")) {
                                System.out.println("Escribe el nombre del arma que quieres equipar");
                                String nombrePide = scanner.nextLine();
                                for (Arma arma : personaje.getArmas()) {
                                    String nombreArma = arma.getNombreEquipo();
                                    int manosOcuparia = arma.getManos() + personaje.getManosOcupadas();
                                    if (nombrePide.equalsIgnoreCase(nombreArma) && manosOcuparia <= 2) {
                                        if (!arma.getEquipada()) {
                                            arma.setEquipada(true);
                                            personaje.setManosOcupadas(manosOcuparia);
                                        } else {
                                            System.out.println("Ya esta equipada");
                                            this.equipar(personaje);
                                        }
                                    } else if (nombrePide.equalsIgnoreCase(nombreArma) && manosOcuparia > 2) {
                                        System.out.println("No puedes ocupar mas de dos manos entre armas y armaduras");
                                    }
                                }
    
                            } else if (seleccionArma.equals("2")) {
                                System.out.println("Enhorabuena, ya has terminado de equipar tus armas");
                            } else {
                                System.out.println("Opcion incorrecta");
                            }
                        } while (!seleccionArma.equals("2"));
                        break;
    
                    case "2":
                        System.out.println("Armaduras disponibles:");
                        for (Armadura armadura : this.personaje.getArmaduras()) {
                            if (armadura.getActiva()) {
                                System.out.println("Nombre del armadura: " + armadura.getNombreEquipo() + ". Manos que ocupa: " + armadura.getManos());
                            }
                        }
                        String seleccionArmadura;
                        do {
                            System.out.println("Elige una opcion:\n 1. Equipar armadura\n 2. Salir ");
                            seleccionArmadura = scanner.nextLine();
                            if (seleccionArmadura.equals("1")) {
                                System.out.println("Escribe el nombre de la armadura que quieres equipar");
                                String nombrePide = scanner.nextLine();
                                for (Armadura armadura : personaje.getArmaduras()) {
                                    String nombreArmadura = armadura.getNombreEquipo();
                                    int manosOcuparia = armadura.getManos() + personaje.getManosOcupadas();
                                    if (nombrePide.equalsIgnoreCase(nombreArmadura) && manosOcuparia <= 2) {
                                        if (!armadura.getEquipada()) {
                                            armadura.setEquipada(true);
                                            personaje.setManosOcupadas(manosOcuparia);
                                        } else {
                                            System.out.println("Ya esta equipada");
                                            this.equipar(personaje);
                                        }
                                    } else if (nombrePide.equalsIgnoreCase(nombreArmadura) && manosOcuparia > 2) {
                                        System.out.println("No puedes ocupar mas de dos manos entre armas y armaduras");
                                    }
                                }
    
                            } else if (seleccionArmadura.equals("2")) {
                                System.out.println("Enhorabuena, ya has terminado de equipar tus armas");
                            } else {
                                System.out.println("Opcion incorrecta");
                            }
                        } while (!seleccionArmadura.equals("2"));
                        break;
    
                    default:
                        System.out.println("Opción incorrecta.");
                        this.equipar(personaje);
                }
    
                break;
    
            case "2":
                System.out.println("¿Qué deseas desequipar armas o armaduras?");
                System.out.println("1. Armas");
                System.out.println("2. Armaduras");
                System.out.print("Selecciona una opción: ");
                String opcion3 = scanner.nextLine();
    
                switch (opcion3) {
                    case "1":
                        // Mostrar armas equipadas
                        System.out.println("Armas equipadas:");
                        for (Arma arma : personaje.getArmas()) {
                            if (arma.getEquipada()) {
                                System.out.println(arma.getNombreEquipo());
                            }
                        }
                        // Solicitar nombre del arma a desequipar
                        System.out.println("Escribe el nombre del arma que quieres desequipar");
                        String nombreArma = scanner.nextLine();
                        // Desequipar el arma seleccionada
                        for (Arma arma : personaje.getArmas()) {
                            if (arma.getNombreEquipo().equalsIgnoreCase(nombreArma)) {
                                if (arma.getEquipada()) {
                                    arma.setEquipada(false);
                                    System.out.println("¡Arma desequipada!");
                                } else {
                                    System.out.println("El arma no está equipada.");
                                }
                            }
                        }
                        break;
    
                    case "2":
                        // Mostrar armaduras equipadas
                        System.out.println("Armaduras equipadas:");
                        for (Armadura armadura : personaje.getArmaduras()) {
                            if (armadura.getEquipada()) {
                                System.out.println(armadura.getNombreEquipo());
                            }
                        }
                        // Solicitar nombre de la armadura a desequipar
                        System.out.println("Escribe el nombre de la armadura que quieres desequipar");
                        String nombreArmadura = scanner.nextLine();
                        // Desequipar la armadura seleccionada
                        for (Armadura armadura : personaje.getArmaduras()) {
                            if (armadura.getNombreEquipo().equalsIgnoreCase(nombreArmadura)) {
                                if (armadura.getEquipada()) {
                                    armadura.setEquipada(false);
                                    System.out.println("¡Armadura desequipada!");
                                } else {
                                    System.out.println("La armadura no está equipada.");
                                }
                            }
                        }
                        break;
    
                    default:
                        System.out.println("Opción incorrecta.");
                        break;
                }
                break;
    
            default:
                System.out.println("Opción incorrecta.");
                break;
        }
    }


    
    public void aceptarRechazarDesafio() {
        if (desafiosPendientes.isEmpty()) {
            System.out.println("No hay desafíos pendientes.");
            return;
        }

        System.out.println("Desafíos pendientes:");
        for (int i = 0; i < desafiosPendientes.size(); i++) {
            Combate desafio = desafiosPendientes.get(i);
            System.out.println((i + 1) + ". Desafiante: " + desafio.getDesafiante().getNombreUsuario() + ", Oro Apostado: " + desafio.getOroApostado());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione el número del desafío que desea aceptar/rechazar: ");
        int seleccion;
        do {
            seleccion = scanner.nextInt();
            if (seleccion < 1 || seleccion > desafiosPendientes.size()) {
                System.out.println("Selección no válida. Inténtalo de nuevo: ");
            }
        } while (seleccion < 1 || seleccion > desafiosPendientes.size());

        Combate desafioSeleccionado = desafiosPendientes.get(seleccion - 1);
        int oroApostado = desafioSeleccionado.getOroApostado();

        System.out.println("Pulse 'A' para aceptar, o cualquier otra letra para rechazar");
        String aceptarRechazar = scanner.next();
        scanner.nextLine(); // Limpiar el buffer

        if (aceptarRechazar.equalsIgnoreCase("A")) {
            if (this.personaje.getOro() < oroApostado) {
                System.out.println("No tienes suficiente oro para aceptar este desafío.");
                return;
            } else {
                this.personaje.restarOro(oroApostado);
                System.out.println("Desafío de " + desafioSeleccionado.getDesafiante().getNombreUsuario() + " aceptado.");

                // Iniciar el combate
                desafioSeleccionado.iniciarCombate();
                desafiosPendientes.remove(desafioSeleccionado);
                this.personaje.incrementarOro(10);
                Jugador desafiante = desafioSeleccionado.getDesafiante();
                desafiante.removeDesafioPendiente(desafioSeleccionado);
                desafiante.personaje.incrementarOro(10);
            }
        } else {
            int oroRechazar = (int) (oroApostado * 0.1);
            if (this.personaje.getOro() < oroRechazar) {
                System.out.println("No tienes suficiente oro para rechazar este desafío.");
                return;
            } else {
                // Pagar el 10% del oro al jugador desafiante
                this.personaje.restarOro(oroRechazar);
                desafioSeleccionado.getDesafiante().getPersonaje().incrementarOro(oroRechazar);
                desafioSeleccionado.getDesafiado().getPersonaje().incrementarOro(-oroRechazar);
                System.out.println("Desafío de " + desafioSeleccionado.getDesafiante().getNombreUsuario() + " rechazado.");
                desafiosPendientes.remove((desafioSeleccionado));
                Jugador desafiante = desafioSeleccionado.getDesafiante();
                desafiante.removeDesafioPendiente(desafioSeleccionado);
            }
        }
    }

    public String getNumeroRegistro() {
        return this.numeroRegistro;
    }

    public boolean getBloqueado() {
        return this.bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public Personaje getPersonaje() {
        return this.personaje;
    }

public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }
    
    public void darBajaPersonaje() {
        if (this.personaje == null) {
            System.out.println("No tienes ningun personaje registrado");
        } else {
            this.personaje = null;
        }
    }


    public ArrayList<Combate> getDesafiosPendientes() {
        return this.desafiosPendientes;
    }

    public Combate getFirstDesafioPendiente() {
        return this.desafiosPendientes.get(0);
    }

    public void removeFirstDesafioPendiente() {
        this.desafiosPendientes.remove(0);
    }

    public void consultarOro() {
        System.out.println("Oro ganado: " + this.personaje.getOroGanado());
        System.out.println("Oro perdido: " + this.personaje.getOroPerdido());
    }

    public void desafiar(Jugador desafiante, Jugador desafiado, int oroApostado) {
        // Crear un nuevo desafío
        Combate combate = new Combate(desafiante, desafiado, oroApostado);

        // Agregar el desafío a la lista de desafíos pendientes del jugador retador
        this.addDesafioPendienteAdmin(combate);
    }

    public void setTiempoBloqueo(LocalDateTime tiempoBloqueo) {
        this.tiempoBloqueo = tiempoBloqueo;
    }

    public LocalDateTime getTiempoBloqueo() {
        return tiempoBloqueo;
    }

    // Método para agregar un desafío pendiente a la lista del administrador
    private void addDesafioPendienteAdmin(Combate combate) {
        Administrador.addDesafioPendienteComun(combate);
    }

    public void addDesafioPendiente(Combate combate) {
        this.desafiosPendientes.add(combate);
    }

    public void agregarCombate(Combate combate) {
        combates.add(combate);
    }

    public ArrayList<Combate> getCombates() {
        return this.combates;
    }
    
    public void removeDesafioPendiente(Combate combate){
        this.desafiosPendientes.remove(combate);
    }

}
