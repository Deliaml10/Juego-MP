import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Ronda implements Serializable {
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
            ArrayList<Arma> armasEquipadas = personaje.getArmasEquipadas();
            for (Arma arma : armasEquipadas){
                if (arma.getEquipada()){
                    valorArmas += arma.getValor();
                }
            }
            potencialAtaque += valorArmas;

            if (vampiro.getSangre() >= disciplina.getSangreNecesaria()) {
                potencialAtaque += disciplina.getValorDisciplina();
                if (disciplina.getSangreNecesaria() >= 5) {
                    potencialAtaque += 2;
                }
            }
            
        } else if (personaje instanceof Licantropo) {
            Licantropo licantropo = (Licantropo) personaje;
            Don don = licantropo.getDon();
            int valorArmas = 0;
            for (Arma arma : licantropo.getArmasEquipadas()){
                if (arma.getEquipada()){
                    valorArmas += arma.getValor();
                }
            }
            potencialAtaque += licantropo.getRabia() + valorArmas;
            if (licantropo.getRabia() >= don.getRabiaNecesaria()) {
                potencialAtaque += don.getValorDon();
            }

        } else if (personaje instanceof Cazador) {
            Cazador cazador = (Cazador) personaje;
            int valorArmas = 0;
            for (Arma arma : cazador.getArmasEquipadas()){
                if (arma.getEquipada()){
                    valorArmas += arma.getValor();
                }
            }
            potencialAtaque =  potencialAtaque + valorArmas + cazador.getPuntosVoluntad();
        }
        // Sumar el valor de fortaleza al potencial de ataque
        int valorFortalezas = 0;
        int valorDebilidades = 0;
        for (Fortaleza fortaleza : personaje.getFortalezas()){
            if (fortaleza.getActivado()){
                valorFortalezas += fortaleza.getValorModificador();
            }

        }
        for (Debilidad debilidad : personaje.getDebilidades()){
            if (debilidad.getActivado()){
                valorDebilidades += debilidad.getValorModificador();
            }
        }
        potencialAtaque += valorFortalezas;
        potencialAtaque -= valorDebilidades;
        return potencialAtaque;
    }

    private int calcularPotencialDefensa(Personaje personaje) {
        int potencialDefensa= personaje.getPoder() /* valor de ataque de equipo activo */;
        if (personaje instanceof Vampiro) {
            Vampiro vampiro = (Vampiro) personaje;
            Disciplina disciplina = vampiro.getDisciplina();
            int valorArmaduras = 0;
            for (Armadura armadura : vampiro.getArmadurasEquipadas()){
                if (armadura.getEquipada()){
                    valorArmaduras += armadura.getValor();
                }
            }
            potencialDefensa += valorArmaduras;
            if (vampiro.getSangre() >= disciplina.getSangreNecesaria()) {
                potencialDefensa += disciplina.getValorDisciplina();
                if (disciplina.getSangreNecesaria() >= 5) {
                    potencialDefensa += 2;
                }
            }
        } else if (personaje instanceof Licantropo) {
            Licantropo licantropo = (Licantropo) personaje;
            Don don = licantropo.getDon();
            int valorArmaduras = 0;
            for (Armadura armadura : licantropo.getArmadurasEquipadas()){
                if (armadura.getEquipada()){
                    valorArmaduras += armadura.getValor();
                }
            }
            potencialDefensa += licantropo.getRabia() + valorArmaduras;
            if (licantropo.getRabia() >= don.getRabiaNecesaria()) {
                potencialDefensa += don.getValorDon();
            }
        } else if (personaje instanceof Cazador) {
            Cazador cazador = (Cazador) personaje;
            int valorArmaduras = 0;
            for (Armadura armadura : cazador.getArmadurasEquipadas()){
                if (armadura.getEquipada()){
                    valorArmaduras += armadura.getValor();
                }
            }
            potencialDefensa =  potencialDefensa + valorArmaduras + cazador.getPuntosVoluntad();
        }
        // Sumar el valor de fortaleza al potencial de ataque
        int valorFortalezas = 0;
        int valorDebilidades = 0;
        for (Fortaleza fortaleza : personaje.getFortalezas()){
            if (fortaleza.getActivado()){
                valorFortalezas += fortaleza.getValorModificador();
            }
        }
        for (Debilidad debilidad : personaje.getDebilidades()){
            if (debilidad.getActivado()){
                valorDebilidades += debilidad.getValorModificador();
            }
        }
        potencialDefensa += valorFortalezas;
        potencialDefensa -= valorDebilidades;
        return potencialDefensa;
    }


    // Método para calcular la vida restante de cada jugador
    public int calcularVida(Personaje personaje, int defensa, int ataque) {
        int diferencia = ataque - defensa;

        if (diferencia > 0) {
            int salud = (personaje.getSalud()- 1);
            personaje.setSalud(salud);
            if (personaje instanceof Licantropo){
                ((Licantropo) personaje).incrementarRabia(1);
            }
        }
        return personaje.getSalud();
    }
    
    public int getSaludDesafiante() {
        return saludDesafiante;
    }

    public int getSaludDesafiado() {
        return saludDesafiado;
    }
    
}
