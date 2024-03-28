public class Esbirro {
    private String nombre;
    private int salud;

    // Clase interna Humano
    public class Humano extends Esbirro {
        private String[] leadtad = {"baja", "media", "alta"};
    }

    // Clase interna Ghoul
    public class Ghoul extends Esbirro {
        private int dependencia;
    }

    // Clase interna Demonio
    public class Demonio extends Esbirro{
        private String pacto;
        private Esbirro esbirro;
    }
}
