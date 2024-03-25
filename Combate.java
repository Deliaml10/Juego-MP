import java.util.Date;

public class Combate {
    private Ronda[] rondas;
    private Jugador desafiante;
    private Jugador desafiado;
    private Date fecha;
    private Jugador vencedor;
    private Esbirro[] esbirros;
    private int oroGanado;

    // Constructor
    public Combate(Ronda[] rondas, Jugador desafiante, Jugador desafiado, Date fecha, Jugador vencedor, Esbirro[] esbirros, int oroGanado) {
        this.rondas = rondas;
        this.desafiante = desafiante;
        this.desafiado = desafiado;
        this.fecha = fecha;
        this.vencedor = vencedor;
        this.esbirros = esbirros;
        this.oroGanado = oroGanado;
    }

    // Métodos
    public void guardarCombate() {
        // Lógica para guardar el combate en algún repositorio de datos
        System.out.println("El combate ha sido guardado.");
    }

    public void crearRondas(int numeroRondas) {
        this.rondas = new Ronda[numeroRondas];
        for (int i = 0; i < numeroRondas; i++) {
            this.rondas[i] = new Ronda(); // Suponiendo que Ronda tiene un constructor por defecto
        }
        System.out.println("Se han creado " + numeroRondas + " rondas.");
    }

    // Getters y setters
    // Getter y Setter para desafiante
    public Jugador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Jugador desafiante) {
        this.desafiante = desafiante;
    }

    // Getter y Setter para desafiado
    public Jugador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Jugador desafiado) {
        this.desafiado = desafiado;
    }

    // Getter y Setter para fecha
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    // Getter y Setter para vencedor
    public Jugador getVencedor() {
        return vencedor;
    }

    public void setVencedor(Jugador vencedor) {
        this.vencedor = vencedor;
    }

    // Getter y Setter para esbirros
    public Esbirro[] getEsbirros() {
        return esbirros;
    }

    public void setEsbirros(Esbirro[] esbirros) {
        this.esbirros = esbirros;
    }

    // Getter y Setter para oroGanado
    public int getOroGanado() {
        return oroGanado;
    }

    public void setOroGanado(int oroGanado) {
        this.oroGanado = oroGanado;
    }

    // Métodos
    public void guardarCombate() {
        // Lógica para guardar el combate en algún repositorio de datos
        System.out.println("El combate ha sido guardado.");
    }
    
}
