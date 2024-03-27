public class Usuario {
    private String contrasena;
    private String nombre;
    private String nick;

    public Usuario(String nombre, String contrasena, String nick) {
        this.nombre = nombre;
        this.nick = nick;
        this.contrasena = contrasena;
    }

    public String getNick(){
        return this.nick;
    }

    public String getContrasena(){
        return this.contrasena;
    }

}