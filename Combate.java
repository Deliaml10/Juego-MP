import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Combate implements Serializable {
    private Jugador desafianteJugador;
    private Personaje desafiante;
    private Jugador desafiadoJugador;
    private Personaje desafiado;
    private Date fecha;
    private Jugador vencedor;
    private int oroApostado;
    private ArrayList<Ronda> rondas; // Array para almacenar las rondas
    private boolean validado;
    private boolean visto;

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
                System.out.println("¡El vencedor es: " + desafiadoJugador.getNick() + "!");
                System.out.println("¡Has ganado: " + this.oroApostado + " monedas de oro" + "!");
                vencedor = desafiadoJugador;
                desafiadoJugador.getPersonaje().incrementarOroGanado(this.oroApostado);
                desafiadoJugador.getPersonaje().incrementarOro(this.oroApostado);
                desafianteJugador.getPersonaje().incrementarOroPerdido(this.oroApostado);
                desafianteJugador.getPersonaje().incrementarOro(-this.oroApostado);

                break;
            } else if (desafiado.getSalud() <= 0) {
                System.out.println("¡El vencedor es: " + desafianteJugador.getNick() + "!");
                System.out.println("¡Has perdido: " + this.oroApostado + " monedas de oro" + "!");
                vencedor = desafianteJugador;
                desafianteJugador.getPersonaje().incrementarOroGanado(this.oroApostado);
                desafianteJugador.getPersonaje().incrementarOro(this.oroApostado);
                desafiadoJugador.getPersonaje().incrementarOroPerdido(this.oroApostado);
                desafiadoJugador.getPersonaje().incrementarOro(-this.oroApostado);
                break;
            }
        }

        // Mostrar las rondas
        System.out.println("Rondas:");
        for (int i = 0; i < rondas.size(); i++) {
            System.out.println("Ronda " + (i + 1) + ": " + desafianteJugador.getNick() + ": " + rondas.get(i).getSaludDesafiado() + " puntos de vida, y " + desafiadoJugador.getNick() + ": " + rondas.get(i).getSaludDesafiante() + " puntos de vida");
        }
        visto = false;
        desafianteJugador.agregarCombate(this);
        desafiado.setSalud(5);
        desafiante.setSalud(5);
    }

    private void guardarRonda(Ronda ronda) {
        rondas.add(ronda); // Agregar la ronda al array
    }

    // Getters y setters

    public Jugador getDesafiante() {
        return this.desafianteJugador;
    }

    public Jugador getDesafiado() {
        return this.desafiadoJugador;
    }

    public Jugador getVencedor() {
        return this.vencedor;
    }

    public int getOroApostado() {
        return this.oroApostado;
    }

    // Getter para obtener el array de rondas
    public ArrayList<Ronda> getRondas() {
        return this.rondas;
    }

    public void setValidado(boolean b) {
        this.validado = b;
    }

    public boolean getVisto() {
        return visto;
    }

    public void setVisto(boolean v) {
        this.visto = v;
    }

}
