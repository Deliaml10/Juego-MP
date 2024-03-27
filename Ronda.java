import java.util.Random;

public class Ronda {
    private int ataqueDesafiante;
    private int ataqueDesafiado;
    private int defensaDesafiante;
    private int defensaDesafiado;
    private int exitosAtaqueDesafiante;
    private int exitosAtaqueDesafiado;
    private int exitosDefensaDesafiante;
    private int exitosDefensaDesafiado;
    private int saludDesafiante;
    private int saludDesafiado;

    // Constructor
    public Ronda(Personaje desafiante, Personaje desafiado) {
        // Calcular y asignar valores de ataque y defensa para el desafiante
        ataqueDesafiante = calcularPotencialAtaque(desafiante);
        defensaDesafiante = calcularPotencialDefensa(desafiante);

        // Calcular y asignar valores de ataque y defensa para el desafiado
        ataqueDesafiado = calcularPotencialAtaque(desafiado);
        defensaDesafiado = calcularPotencialDefensa(desafiado);

        // Inicializar otras propiedades
        exitosAtaqueDesafiante = exitosAtaque(ataqueDesafiante);
        exitosDefensaDesafiante = exitosDefensa(defensaDesafiante);
        exitosAtaqueDesafiante = exitosAtaque(ataqueDesafiado);
        exitosDefensaDesafiante = exitosDefensa(defensaDesafiado);
        saludDesafiante = desafiante.getSalud();
        saludDesafiado = desafiado.getSalud();
    }


    private int exitosAtaque(int ataque) {
        Random rand = new Random();
        int suma = 0;
        for (int i = 0; i < ataque; i++) {
            int numeroAleatorio = rand.nextInt(6) + 1;
            suma += numeroAleatorio;
        }
        return suma;
    }

    private int exitosDefensa(int defensa) {
        Random rand = new Random();
        int suma = 0;
        for (int i = 0; i < defensa; i++) {
            int numeroAleatorio = rand.nextInt(6) + 1;
            suma += numeroAleatorio;
        }
        return suma;
    }

    private int calcularPotencialAtaque(Personaje personaje) {
        int potencialAtaque = personaje.getPoder() + /* valor de ataque de equipo activo */;
        if (personaje instanceof Vampiro) {
            Vampiro vampiro = (Vampiro) personaje;
            potencialAtaque = potencialAtaque + vampiro.getValorDisciplina() + vampiro.getValorArmas();
            if (vampiro.getValorSangre() >= 5) {
                potencialAtaque += 2;
            }
        } else if (personaje instanceof Licantropo) {
            Licantropo licantropo = (Licantropo) personaje;
            potencialAtaque = potencialAtaque + licantropo.getValorDon() + licantropo.getValorArmas() + licantropo.getRabia();
        } else if (personaje instanceof Cazador) {
            Cazador cazador = (Cazador) personaje;
            potencialAtaque =  potencialAtaque + cazador.getValorTalento() + cazador.getValorArmas + cazador.getVoluntad();
        }
        // Sumar el valor de fortaleza al potencial de ataque
        potencialAtaque += personaje.getFortaleza();
        potencialAtaque -= personaje.getDebilidad();
        return potencialAtaque;
    }

    private int calcularPotencialDefensa(Personaje personaje) {
        int potencialDefensa= personaje.getPoder() + /* valor de ataque de equipo activo */;
        if (personaje instanceof Vampiro) {
            Vampiro vampiro = (Vampiro) personaje;
            potencialDefensa = potencialDefensa + vampiro.getValorDisciplina() + vampiro.getValorArmadura();
            if (vampiro.getValorSangre() >= 5) {
                potencialDefensa += 2;
            }
        } else if (personaje instanceof Licantropo) {
            Licantropo licantropo = (Licantropo) personaje;
            potencialDefensa = potencialDefensa + licantropo.getValorDon() + licantropo.getValorArmadura() + licantropo.getRabia();
        } else if (personaje instanceof Cazador) {
            Cazador cazador = (Cazador) personaje;
            potencialDefensa =  potencialDefensa + cazador.getValorTalento() + cazador.getValorArmadura + cazador.getVoluntad();
        }
        // Sumar el valor de fortaleza al potencial de ataque
        potencialDefensa += personaje.getFortaleza();
        potencialDefensa -= personaje.getDebilidad();
        return potencialDefensa;
    }


    // Método para calcular la vida restante de cada jugador
    public void calcularVida() {
        this.saludDesafiante -= this.ataqueDesafiado - this.defensaDesafiante;
        this.saludDesafiado -= this.ataqueDesafiante - this.defensaDesafiante;
        System.out.println("La vida restante de los jugadores ha sido calculada.");
    }
}
