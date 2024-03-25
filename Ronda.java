public class Ronda {
    private int defensaDesafiante;
    private int defensaDesafiado;
    private int ataqueDesafiante;
    private int ataqueDesafiado;
    private int exitosDesafiante;
    private int exitosDesafiado;
    private int saludDesafiante;
    private int saludDesafiado;

    // Constructor
    public Ronda(int defensaDesafiante, int defensaDesafiado, int ataqueDesafiante, int ataqueDesafiado, int exitosDesafiante, int exitosDesafiado, int saludDesafiante, int saludDesafiado) {
        this.defensaDesafiante = defensaDesafiante;
        this.defensaDesafiado = defensaDesafiado;
        this.ataqueDesafiante = ataqueDesafiante;
        this.ataqueDesafiado = ataqueDesafiado;
        this.exitosDesafiante = exitosDesafiante;
        this.exitosDesafiado = exitosDesafiado;
        this.saludDesafiante = saludDesafiante;
        this.saludDesafiado = saludDesafiado;
    }

    // Getter y Setter para defensaDesafiante
    public int getDefensaDesafiante() {
        return defensaDesafiante;
    }

    public void setDefensaDesafiante(int defensaDesafiante) {
        this.defensaDesafiante = defensaDesafiante;
    }

    // Getter y Setter para defensaDesafiado
    public int getDefensaDesafiado() {
        return defensaDesafiado;
    }

    public void setDefensaDesafiado(int defensaDesafiado) {
        this.defensaDesafiado = defensaDesafiado;
    }

    // Getter y Setter para ataqueDesafiante
    public int getAtaqueDesafiante() {
        return ataqueDesafiante;
    }

    public void setAtaqueDesafiante(int ataqueDesafiante) {
        this.ataqueDesafiante = ataqueDesafiante;
    }

    // Getter y Setter para ataqueDesafiado
    public int getAtaqueDesafiado() {
        return ataqueDesafiado;
    }

    public void setAtaqueDesafiado(int ataqueDesafiado) {
        this.ataqueDesafiado = ataqueDesafiado;
    }

    // Getter y Setter para exitosDesafiante
    public int getExitosDesafiante() {
        return exitosDesafiante;
    }

    public void setExitosDesafiante(int exitosDesafiante) {
        this.exitosDesafiante = exitosDesafiante;
    }

    // Getter y Setter para exitosDesafiado
    public int getExitosDesafiado() {
        return exitosDesafiado;
    }

    public void setExitosDesafiado(int exitosDesafiado) {
        this.exitosDesafiado = exitosDesafiado;
    }

    // Getter y Setter para saludDesafiante
    public int getSaludDesafiante() {
        return saludDesafiante;
    }

    public void setSaludDesafiante(int saludDesafiante) {
        this.saludDesafiante = saludDesafiante;
    }

    // Getter y Setter para saludDesafiado
    public int getSaludDesafiado() {
        return saludDesafiado;
    }

    public void setSaludDesafiado(int saludDesafiado) {
        this.saludDesafiado = saludDesafiado;
    }

    // Método para guardar la ronda
    public void guardarRonda() {
        // Lógica para guardar la ronda en algún repositorio de datos
        System.out.println("La ronda ha sido guardada.");
    }

    // Método para calcular la vida restante de cada jugador
    public void calcularVida() {
        this.saludDesafiante -= this.ataqueDesafiado - this.defensaDesafiante;
        this.saludDesafiado -= this.ataqueDesafiante - this.defensaDesafiante;
        System.out.println("La vida restante de los jugadores ha sido calculada.");
    }
}
