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
        // Suponiendo que Usuario tiene getters y setters para nombre, contrasena y nick
        this.setNombre("");
        this.setContrasena("");
        this.setNick("");
        this.numero = "";
    }

    public class Jugador extends Usuario {
        private int oro;

        // Otros atributos y métodos de la clase Jugador...

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
            // Lógica para aceptar el desafío
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
}
