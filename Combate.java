import java.util.ArrayList;
import java.util.Date;

public class Combate {
    private Jugador desafiante;
    private Jugador desafiado;
    private Date fecha;
    private Jugador vencedor;
    private int oroApostado;
    private ArrayList<Ronda> rondas; // Array para almacenar las rondas

    // Constructor
    public Combate(Personaje desafiante, Personaje desafiado, int oroApostado) {
        this.desafiante = desafiante;
        this.desafiado = desafiado;
        this.fecha = new Date(); // Fecha actual
        this.oroApostado = oroApostado;
        this.rondas = new ArrayList<>();
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

    // Getter para obtener el array de rondas
    public ArrayList<Ronda> getRondas() {
        return rondas;
    }
}
