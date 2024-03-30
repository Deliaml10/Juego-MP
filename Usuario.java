import java.util.HashSet;
import java.util.Scanner;

public class Usuario {
    private String nombre;
    private String nick;
    private String contrasena;
    private static HashSet<String> nicksRegistrados = new HashSet<>();

    public Usuario(String nombre, String nick, String contrasena) {
        this.nombre = nombre;
        this.nick = nick;
        this.contrasena = contrasena;
    }

    public static void crearCuenta(HashSet<Usuario> usuarios) {
        Scanner scanner = new Scanner(System.in);
        String nombre, nick, contrasena;

        System.out.print("Nombre: ");
        nombre = scanner.nextLine().trim();

        System.out.print("Nick: ");
        nick = scanner.nextLine().trim();

        if (nickYaRegistrado(nick)) {
            System.out.println("El nick '" + nick + "' ya está registrado. Por favor, elija otro.");
            return;
        }

        System.out.print("Contraseña: ");
        contrasena = scanner.nextLine().trim();

        Usuario nuevoUsuario = new Usuario(nombre, nick, contrasena);
        usuarios.add(nuevoUsuario);
        nicksRegistrados.add(nick);
        System.out.println("Cuenta creada correctamente.");
    }

    private static boolean nickYaRegistrado(String nick) {
        return nicksRegistrados.contains(nick);
    }

    public static void borrarUsuario(HashSet<Usuario> usuarios, String nick) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNick().equals(nick)) {
                usuarios.remove(usuario);
                nicksRegistrados.remove(nick);
                System.out.println("Usuario '" + nick + "' eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró ningún usuario con el nick '" + nick + "'.");
    }

    public static Usuario iniciarSesion(HashSet<Usuario> usuarios, String nick, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNick().equals(nick) && usuario.getContrasena().equals(contrasena)) {
                System.out.println("Sesión iniciada correctamente para el usuario '" + nick + "'.");
                return usuario;
            }
        }
        System.out.println("Error: Nick o contraseña incorrectos.");
        return null;
    }

    public String cerrarSesion() {
        System.out.println("Sesión cerrada para el usuario '" + nick + "'.");
        return nick;
    }

    // Getters y setters
    public String getNombreUsuario() {
        return nombre;
    }

    public void setNombreUsuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
