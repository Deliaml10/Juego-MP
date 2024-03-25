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
    public Ronda(Personaje desafiante, Personaje desafiado) {
        // Calcular y asignar valores de ataque y defensa para el desafiante
        ataqueDesafiante = desafiante.calcularPotencialAtaque();
        defensaDesafiante = desafiante.calcularPotencialDefensa();

        // Calcular y asignar valores de ataque y defensa para el desafiado
        ataqueDesafiado = desafiado.calcularPotencialAtaque();
        defensaDesafiado = desafiado.calcularPotencialDefensa();

        // Inicializar otras propiedades
        exitosDesafiante = 0;
        exitosDesafiado = 0;
        saludDesafiante = desafiante.getSalud();
        saludDesafiado = desafiado.getSalud();
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
