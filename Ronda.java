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
        exitosAtaqueDesafiado = exitosAtaque(ataqueDesafiado);
        exitosDefensaDesafiado = exitosDefensa(defensaDesafiado);
        saludDesafiante = calcularVida(desafiante, exitosDefensaDesafiante, exitosAtaqueDesafiado);
        saludDesafiado = calcularVida(desafiado, exitosDefensaDesafiado, exitosAtaqueDesafiante);
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
        int potencialAtaque = personaje.getPoder()/* valor de ataque de equipo activo */;
        if (personaje instanceof Vampiro) {
            Vampiro vampiro = (Vampiro) personaje;
            Disciplina disciplina = vampiro.getDisciplina();
            int valorArmas = 0;
            for (Arma arma : vampiro.getArmas()){
                if (arma.getEquipada()){
                    valorArmas += arma.getValor();
                }
            }
            potencialAtaque = potencialAtaque + disciplina.getValorDisciplina() + valorArmas;
            if (disciplina.getSangreNecesaria() >= 5) {
                potencialAtaque += 2;
            }
        } else if (personaje instanceof Licantropo) {
            Licantropo licantropo = (Licantropo) personaje;
            Don don = licantropo.getDon();
            int valorArmas = 0;
            for (Arma arma : licantropo.getArmas()){
                if (arma.getEquipada()){
                    valorArmas += arma.getValor();
                }
            }
            potencialAtaque = potencialAtaque + don.getValorDon() + don.getRabia() + valorArmas;
        } else if (personaje instanceof Cazador) {
            Cazador cazador = (Cazador) personaje;
            int valorArmas = 0;
            for (Arma arma : cazador.getArmas()){
                if (arma.getEquipada()){
                    valorArmas += arma.getValor();
                }
            }
            potencialAtaque =  potencialAtaque + valorArmas + cazador.getPuntosVoluntad();
        }
        // Sumar el valor de fortaleza al potencial de ataque
        potencialAtaque += personaje.getFortaleza();
        potencialAtaque -= personaje.getDebilidad();
        return potencialAtaque;
    }

    private int calcularPotencialDefensa(Personaje personaje) {
        int potencialDefensa= personaje.getPoder() /* valor de ataque de equipo activo */;
        if (personaje instanceof Vampiro) {
            Vampiro vampiro = (Vampiro) personaje;
            Disciplina disciplina = vampiro.getDisciplina();
            int valorArmaduras = 0;
            for (Armadura armadura : vampiro.getArmaduras()){
                if (armadura.getEquipada()){
                    valorArmaduras += armadura.getValor();
                }
            }
            potencialDefensa = potencialDefensa + disciplina.getValorDisciplina() + valorArmaduras;
            if (disciplina.getSangreNecesaria() >= 5) {
                potencialDefensa += 2;
            }
        } else if (personaje instanceof Licantropo) {
            Licantropo licantropo = (Licantropo) personaje;
            Don don = licantropo.getDon();
            int valorArmaduras = 0;
            for (Armadura armadura : licantropo.getArmaduras()){
                if (armadura.getEquipada()){
                    valorArmaduras += armadura.getValor();
                }
            }
            potencialDefensa = potencialDefensa + don.getValorDon() + don.getRabia() + valorArmaduras;
        } else if (personaje instanceof Cazador) {
            Cazador cazador = (Cazador) personaje;
            int valorArmaduras = 0;
            for (Armadura armadura : cazador.getArmaduras()){
                if (armadura.getEquipada()){
                    valorArmaduras += armadura.getValor();
                }
            }
            potencialDefensa =  potencialDefensa + valorArmaduras + cazador.getPuntosVoluntad();
        }
        // Sumar el valor de fortaleza al potencial de ataque
        potencialDefensa += personaje.getFortaleza();
        potencialDefensa -= personaje.getDebilidad();
        return potencialDefensa;
    }


    // Método para calcular la vida restante de cada jugador
    public int calcularVida(Personaje personaje, int defensa, int ataque) {
        int diferencia = ataque - defensa;
        int vidaRestante;

        if (diferencia > 0) {
            int salud = (personaje.getSalud()- 1);
            personaje.setSalud(salud);
        }
        return personaje.getSalud();
    }
}
