import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jugador extends Usuario  {
    private String numeroRegistro;
    private Personaje personaje;
    private LocalDateTime ultimoCombatePerdido;
    private boolean bloqueado;
    public ArrayList<Combate> desafiosPendientes = new ArrayList<>();


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
        /*
        String[] nombre = new String[Personajes];
        String[] contrasena = new String[Personajes];
        String[] nick = new String[Personajes];
        String[] numeroRegistro = new String[Personajes];

        try {
            FileWriter fichero = new FileWriter("personajes.txt");
            PrintWriter pw = new PrintWriter(fichero);

            for(int i = 0; i < Personajes; i++) {
                System.out.print("\nDime el nombre del usuario " + (i + 1) + ": ");
                nombre[i] = Entrada.cadena();

                System.out.print("Dime la contraseña del usuario " + (i + 1) + ": ");
                contrasena[i] = Entrada.cadena();

                System.out.print("Dime el nick del usuario " + (i + 1) + ": ");
                nick[i] = Entrada.cadena();

                String numeroRegistroActual = crearNumeroRegistro();
                numeroRegistro[i] = numeroRegistroActual;

                pw.println("\nUsuario " + (i + 1) + "\tNombre: " + nombre[i] +
                        "\tContraseña: " + contrasena[i] + "\tNick: " + nick[i] +
                        "\tNúmero de Registro: " + numeroRegistroActual);
            }

            pw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }*/
    }

    public void eliminarPersonaje() {
        this.personaje = null;

        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nick del personaje a eliminar:");
        String nickEliminar = scanner.nextLine();

        try {
            File inputFile = new File("personajes.txt");
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = "Nick: " + nickEliminar;
            String currentLine;

            boolean found = false;

            while ((currentLine = reader.readLine()) != null) {
                // Si la línea actual no contiene el nick a eliminar, se escribe en el archivo temporal
                if (!currentLine.contains(lineToRemove)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                } else {
                    found = true;
                }
            }
            writer.close();
            reader.close();

            if (found) {
                boolean successful = tempFile.renameTo(inputFile);
                if (!successful) {
                    System.out.println("Error al renombrar el archivo.");
                } else {
                    System.out.println("Personaje eliminado correctamente.");
                }
            } else {
                System.out.println("No se encontró ningún personaje con el nick especificado.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/
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
                for (Arma arma : this.personaje.getArmas()) {
                    if (arma.getActiva()) {
                        System.out.println(arma.getNombreEquipo() + ". Manos que ocupa: " + arma.getManos());
                    }
                }
                int seleccionArma;
                do {
                    System.out.println("Elige una opcion:\n 1. Equipar arma\n 2. Salir ");
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
                for (Armadura armadura : this.personaje.getArmaduras()) {
                    if (armadura.getActiva()) {
                        System.out.println(armadura.getNombreEquipo() + ". Manos que ocupa: " + armadura.getManos());
                    }
                }
                int seleccionArmadura;
                do {
                    System.out.println("Elige una opcion:\n 1. Equipar armadura\n 2. Salir ");
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

    public void aceptarRechazarDesafio() {
        if (desafiosPendientes.isEmpty()) {
            System.out.println("No hay desafíos pendientes.");
            return;
        }
        System.out.println("Desafíos pendientes:");
        for (int i = 0; i < desafiosPendientes.size(); i++) {
            Combate desafio = desafiosPendientes.get(i);
            System.out.println((i + 1) + ". Desafiante: " + desafio.getDesafiante() + ", Oro Apostado: " + desafio.getOroApostado());
        }


        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione el número del desafío que desea aceptar/rechazar: ");
        int seleccion;
        scanner.nextLine(); // Limpiar el buffer
        do {
            seleccion = scanner.nextInt();
            if (seleccion < 1 || seleccion > desafiosPendientes.size()) {
                System.out.println("Selección no válida. Intentalo de nuevo: ");
            }
        }while (seleccion < 1 || seleccion > desafiosPendientes.size());
        Combate desafioSeleccionado = desafiosPendientes.get(seleccion - 1);
        int oroApostado = desafioSeleccionado.getOroApostado();

        System.out.println("Pulse 'A' para aceptar, o cualquier otra letra para rechazar");
        String aceptarRechazar = scanner.nextLine();
        scanner.nextLine();
        if (aceptarRechazar.equalsIgnoreCase("A")){
            if (this.personaje.getOro() < oroApostado) {
                System.out.println("No tienes suficiente oro para aceptar este desafío.");
                return;
            }else{
                this.personaje.restarOro(oroApostado);
                System.out.println("Desafío de " + desafioSeleccionado.getDesafiante() + " aceptado.");
                this.desafiosPendientes.remove(seleccion - 1);
            }
        }else{
            int oroRechazar = (int)(oroApostado * 0.1);
            if (this.personaje.getOro() < desafioSeleccionado.getOroApostado()*0.1 ) {
                System.out.println("No tienes suficiente oro para rechazar este desafío.");
                return;
            }else{
                this.personaje.restarOro(oroRechazar);
                System.out.println("Desafío de " + desafioSeleccionado.getDesafiante() + " rechazado.");
                this.desafiosPendientes.remove(seleccion - 1);
            }
        }
    }

    public void addDesafioPendiente(Combate desafioPendiente) {
        this.desafiosPendientes.add(desafioPendiente);
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
    public void darBajaPersonaje(){
        if (this.personaje == null){
            System.out.println("No tienes ningun personaje registrado");
        }else {
            this.personaje = null;
        }
    }


    public ArrayList<Combate> getDesafiosPendientes(){
        return this.desafiosPendientes;
    }
    public Combate getFirstDesafioPendiente(){
        return this.desafiosPendientes.get(0);
    }

    public void removeFirstDesafioPendiente(){
        this.desafiosPendientes.remove(0);
    }

    public void consultarOro(){
        System.out.println("ESTO TODAVIA NO ESTA HECHO, HAZLOOOOO");
    }

    public void desafiar(Personaje personaje1, Personaje personaje2){

    }

}
