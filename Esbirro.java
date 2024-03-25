public class Esbirro {
    private String nombre;
    private int salud;

    // Clase interna Humano
    public class Humano {
        private String[] leadtad = {"baja", "media", "alta"};
    }

    // Clase interna Ghoul
    public class Ghoul {
        private int dependencia;
    }

    // Clase interna Demonio
    public class Demonio {
        private String pacto;
        private Esbirro esbirro;
    }
}
