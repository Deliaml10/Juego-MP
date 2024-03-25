import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jugador extends Usuario {
    private String numero;
    private Personaje personaje;
    private int oro;

    public Jugador(String nombre, String contrasena, String nick) {
        super(nombre, contrasena, nick);
        this.numero = numeroRegistro();
        this.personaje = null;
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

    public boolean aceptarDesafio() {
        return hayDesafioPendiente();
    }

    public boolean rechazarDesafio() {
        return hayDesafioPendiente();
    }

    private boolean hayDesafioPendiente() {
        // Implementa la lógica real para verificar si hay un desafío pendiente
        // Este método debe devolver true o false dependiendo de la situación
        return true; // Por ahora, simplemente devolvemos true para simular que hay un desafío pendiente
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
                return true; // El nick ya está en uso
            }
        }
        return false; // El nick es único
    }
}
