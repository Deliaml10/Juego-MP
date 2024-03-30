import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jugador extends Usuario {
    private String numeroRegistro;
    private Personaje personaje;
    private LocalDateTime ultimoCombatePerdido;
    private boolean bloqueado;

    //private ArrayList<Combate> desafiosPendientes;

    public Jugador(String nombre, String contrasena, String nick) {
        super(nombre, contrasena, nick);
        this.numeroRegistro = crearNumeroRegistro();
        this.personaje = null;
        this.bloqueado = false;
        //this.desafiosPendientes = new ArrayList<>();
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
        this.setNombreUsuario("");
        this.setContrasena("");
        this.setNick("");
        this.numeroRegistro = null;
    }

    public void equipar(Personaje personaje) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Qué deseas equipar?");
        System.out.println("1. Armas");
        System.out.println("2. Armaduras");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Armas disponibles:");
                for (Arma arma : personaje.getArmas()) {
                    if (arma.getActiva()) {
                        System.out.println(arma.getNombreEquipo() + ". Manos que ocupa: " + arma.getManos());
                    }
                }
                int seleccionArma;
                do {
                    System.out.println("Elige una opcion:\n 1. Equipar arma\n 2. Terminar de equipar ");
                    seleccionArma = scanner.nextInt();
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
                    System.out.println("Se ha equipado el arma '" + armaSeleccionada.getNombreEquipo() + "'.");
                    break;
                } while (seleccionArma !);
            case 2:
                System.out.println("Defensas disponibles:");
                for (int i = 0; i < armadurasDisponibles.size(); i++) {
                    Armadura armadura = armadurasDisponibles.get(i);
                    System.out.println((i + 1) + ". " + armadura.getNombreEquipo());
                }
                System.out.println("Selecciona una defensa para equipar (0 para salir): ");
                int seleccionDefensa = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                if (seleccionDefensa == 0 || seleccionDefensa > armadurasDisponibles.size()) {
                    System.out.println("Saliendo del menú de equipamiento...");
                    return;
                }
                Armadura defensaSeleccionada = armadurasDisponibles.get(seleccionDefensa - 1);
                this.defensasActivas.add(defensaSeleccionada);
                armadurasDisponibles.remove(defensaSeleccionada);
                System.out.println("Se ha equipado la defensa '" + defensaSeleccionada.getNombre() + "'.");
                break;
            default:
                System.out.println("Opción inválida. Saliendo del menú de equipamiento...");
                break;
        }

    }
    public void aceptarDesafio() {
        /*if (desafiosPendientes.isEmpty()) {
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
         */
    }
    public void setDesafiosPendientes(ArrayList<String> desafiosPendientes) {
        //this.desafiosPendientes = desafiosPendientes;
    }
    public String getNumeroRegistro(){
        return this.numeroRegistro;
    }
    public LocalDateTime getUltimoCombatePerdido(){
        return this.ultimoCombatePerdido;
    }
    public boolean getBloqueado(){
        return this.bloqueado;
    }
    public void setBloqueado(boolean bloqueado){
        this.bloqueado = bloqueado;
    }
    public Personaje getPersonaje(){
        return this.personaje;
    }
    public void setPersonaje(Personaje personaje){
        this.personaje = personaje;
    }
}
