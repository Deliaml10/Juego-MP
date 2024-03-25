import java.util.Date;

public class Combate {
    private Jugador desafiante;
    private Jugador desafiado;
    private Date fecha;
    private Jugador vencedor;
    private int oroApostado;

    // Constructor
    public Combate(Jugador desafiante, Jugador desafiado, int oroApostado) {
        this.desafiante = desafiante;
        this.desafiado = desafiado;
        this.fecha = new Date(); // Fecha actual
        this.oroApostado = oroApostado;
    }

    // Método para iniciar el combate
    public void iniciarCombate() {
        System.out.println("¡El combate ha comenzado!");

        while (desafiante.getSalud() > 0 && desafiado.getSalud() > 0) {
            // Crear nueva ronda
            Ronda ronda = new Ronda();

            // Guardar la ronda
            ronda.guardarRonda();

            // Verificar si uno de los jugadores ha perdido
            if (desafiante.getSalud() <= 0 && desafiado.getSalud() <= 0) {
                System.out.println("¡El combate termina en empate!");
                vencedor = null; // Empate
                break;
            } else if (desafiante.getSalud() <= 0) {
                System.out.println("¡El desafiado ha ganado el combate!");
                vencedor = desafiado;
                break;
            } else if (desafiado.getSalud() <= 0) {
                System.out.println("¡El desafiante ha ganado el combate!");
                vencedor = desafiante;
                break;
            }
        }

        // Asignar oro al ganador y al perdedor
        asignarOro();
    }

    // Método para asignar oro al ganador y al perdedor
    private void asignarOro() {
        if (vencedor == desafiante) {
            desafiante.incrementarOro(oroApostado);
            desafiado.incrementarOro(-oroApostado);
            if (vencedor == null) {
                desafiado.incrementarOro(oroApostado / 2);
                desafiante.incrementarOro(oroApostado / 2);
            } else {
                desafiante.incrementarOro(-oroApostado);
                desafiado.incrementarOro(oroApostado);
            }
        }
    }

    // Getters
    public Jugador getDesafiante() {
        return desafiante;
    }

    public Jugador getDesafiado() {
        return desafiado;
    }

    public Date getFecha() {
        return fecha;
    }

    public Jugador getVencedor() {
        return vencedor;
    }

    public int getOroApostado() {
        return oroApostado;
    }
}
