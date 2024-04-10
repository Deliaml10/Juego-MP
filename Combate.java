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

    public void iniciarCombate() {
        System.out.println("¡El combate ha comenzado!");
        
        // Mostrar información de los jugadores antes de iniciar los combates
        System.out.println("Desafiante: " + desafianteJugador.getNick() + " - Salud: " + desafiante.getSalud());
        System.out.println("Desafiado: " + desafiadoJugador.getNick() + " - Salud: " + desafiado.getSalud());
        System.out.println("Oro apostado: " + oroApostado);
    
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
                vencedor = desafiado;
                break;
            } else if (desafiado.getSalud() <= 0) {
                System.out.println("¡El vencedor es: " + desafianteJugador.getNick() + "!");
                vencedor = desafiante;
                break;
            }
        }
    
        // Asignar oro al ganador y al perdedor
        asignarOro();

        desafiado.setSalud(5);
        desafiante.setSalud(5);
    
        // Mostrar las rondas
        System.out.println("Rondas:");
        for (int i = 0; i < rondas.size(); i++) {
            System.out.println("Ronda " + (i + 1) + ": " + desafianteJugador.getNick() + ": " + rondas.get(i).getSaludDesafiado() + " puntos de vida, y " + desafiadoJugador.getNick() + ": " + rondas.get(i).getSaludDesafiante() + " puntos de vida");
        }
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
