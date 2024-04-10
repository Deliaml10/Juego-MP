import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Combate implements Serializable {
    private Jugador desafianteJugador;
    private Personaje desafiante;
    private Jugador desafiadoJugador;
    private Personaje desafiado;
    private Date fecha;
    private Personaje vencedor;
    private int oroApostado;
    private ArrayList<Ronda> rondas; // Array para almacenar las rondas
    private boolean validado;

    // Constructor
    public Combate(Jugador desafianteJugador, Jugador desafiadoJugador, int oroApostado) {
        this.desafianteJugador = desafianteJugador;
        this.desafiante = desafianteJugador.getPersonaje();
        this.desafiadoJugador = desafiadoJugador;
        this.desafiado = desafiadoJugador.getPersonaje();
        this.fecha = new Date(); // Fecha actual
        this.oroApostado = oroApostado;
        this.rondas = new ArrayList<>();
        this.validado = false;
    }

    // Método para iniciar el combate
    public void iniciarCombate() {
        System.out.println("¡El combate ha comenzado!");

        while (desafiante.getSalud() > 0 && desafiado.getSalud() > 0) {
            // Crear nueva ronda
            Ronda ronda = new Ronda(desafiante, desafiado);

            // Guardar la ronda
            guardarRonda(ronda);

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

    private void guardarRonda(Ronda ronda) {
        rondas.add(ronda); // Agregar la ronda al array
    }

    // Método para asignar oro al ganador y al perdedor
    private void asignarOro() {
        if (vencedor == desafiante) {
            desafiante.incrementarOro(oroApostado / 2);
            desafiado.incrementarOro(-oroApostado / 2);
        } else {
            desafiante.incrementarOro(-oroApostado / 2);
            desafiado.incrementarOro(oroApostado / 2);
        }
    }

    // Getters y setters

    public Jugador getDesafiante() {
        return this.desafianteJugador;
    }

    public Jugador getDesafiado() {
        return this.desafiadoJugador;
    }

    public Date getFecha() {
        return fecha;
    }

    public Personaje getVencedor() {
        return vencedor;
    }

    public int getOroApostado() {
        return oroApostado;
    }

    // Getter para obtener el array de rondas
    public ArrayList<Ronda> getRondas() {
        return rondas;
    }

    public void setValidado(boolean b) {
        this.validado = b;
    }

    public boolean getValidado() {
        return validado;
    }
}
