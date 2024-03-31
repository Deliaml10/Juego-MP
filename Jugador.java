import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jugador extends Usuario {
    private String numeroRegistro;
    private Personaje personaje;
    private LocalDateTime ultimoCombatePerdido;
    private boolean bloqueado;
    public ArrayList<Combate> desafiosPendientes = new ArrayList<>();

    //private ArrayList<Combate> desafosPendientes;

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
                    if (seleccionArma == 1) {
                        System.out.println("Escribe el nombre del arma que quieres equipar");
                        String nombrePide = scanner.nextLine();
                        for (Arma arma : personaje.getArmas()){
                            String nombreArma = arma.getNombreEquipo();
                            int manosOcuparia = arma.getManos() + personaje.getManosOcupadas();
                            if (nombrePide.equalsIgnoreCase(nombreArma) && manosOcuparia <= 2){
                                arma.setEquipada(true);
                                personaje.setManosOcupadas(manosOcuparia);
                            }else if (nombrePide.equalsIgnoreCase(nombreArma) && manosOcuparia > 2){
                                System.out.println("No puedes ocupar mas de dos manos entre armas y armaduras");
                            }
                        }

                    }else{
                        System.out.println("Enhorabuena, ya has terminado de equipar tus armas");
                    }
                } while (seleccionArma != 2);
                break;

            case 2:
                System.out.println("Armaduras disponibles:");
                for (Armadura armadura : personaje.getArmaduras()) {
                    if (armadura.getActiva()) {
                        System.out.println(armadura.getNombreEquipo() + ". Manos que ocupa: " + armadura.getManos());
                    }
                }
                int seleccionArmadura;
                do {
                    System.out.println("Elige una opcion:\n 1. Equipar armadura\n 2. Terminar de equipar ");
                    seleccionArmadura = scanner.nextInt();
                    if (seleccionArmadura == 1) {
                        System.out.println("Escribe el nombre de la armadura que quieres equipar");
                        String nombrePide = scanner.nextLine();
                        for (Armadura armadura : personaje.getArmaduras()){
                            String nombreArmadura = armadura.getNombreEquipo();
                            int manosOcuparia = armadura.getManos() + personaje.getManosOcupadas();
                            if (nombrePide.equalsIgnoreCase(nombreArmadura) && manosOcuparia <= 2){
                                armadura.setEquipada(true);
                                personaje.setManosOcupadas(manosOcuparia);
                            }else if (nombrePide.equalsIgnoreCase(nombreArmadura) && manosOcuparia > 2){
                                System.out.println("No puedes ocupar mas de dos manos entre armas y armaduras");
                            }
                        }
                    }else{
                        System.out.println("Enhorabuena, ya has terminado de equipar tus armaduras");
                    }
                } while (seleccionArmadura != 2);
                break;

            default:
                System.out.println("Opción incorrecta. Saliendo del menú de equipamiento...");
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
            System.out.println("Selección no válida.");
            return;
        }
        /*String desafioSeleccionado = desafiosPendientes.get(seleccion - 1);
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
