import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.ArrayList;

public class TestRonda {
    
    @Test
    public void testConstructorRonda() {
        // Crear personajes para los jugadores
        Habilidad habilidad1 = new Disciplina("Disciplina", 5, 10);
        Habilidad habilidad2 = new Don("Don", 8, 15);

        // Crear una lista de habilidades
        ArrayList<Habilidad> habilidades1 = new ArrayList<>();
        ArrayList<Habilidad> habilidades2 = new ArrayList<>();
        habilidades1.add(habilidad1);
        habilidades2.add(habilidad2);

        // Crear armas
        Arma arma = new Arma("Espada", 1, 2, true);

        // Crear armaduras
        Armadura armadura = new Armadura("Escudo", 1, 4, true);

        // Crear listas de armas y armaduras
        ArrayList<Arma> armas = new ArrayList<>();
        armas.add(arma);

        ArrayList<Armadura> armaduras = new ArrayList<>();
        armaduras.add(armadura);

        // Crear esbirros
        Esbirro esbirro1 = new Humano("Sir Lancelot", 5, 2);
        Esbirro esbirro2 = new Ghoul("Fang", 5, 3);
        Esbirro esbirro3 = new Demonio("Azazel", 5, "Pacto oscuro", new ArrayList<>());

        // Crear lista de esbirros
        ArrayList<Esbirro> esbirros = new ArrayList<>();
        esbirros.add(esbirro1);
        esbirros.add(esbirro2);
        esbirros.add(esbirro3);

        // Crear debilidades y fortalezas
        Debilidad debilidad1 = new Debilidad("Miedo a la oscuridad", 2, true);
        Debilidad debilidad2 = new Debilidad("Fobia a los insectos", 3, false);
        Fortaleza fortaleza1 = new Fortaleza("Gran resistencia física", 3, true);
        Fortaleza fortaleza2 = new Fortaleza("Gran inteligencia", 2, true);

        // Crear lista de debilidades y fortalezas
        ArrayList<Debilidad> debilidades = new ArrayList<>();
        debilidades.add(debilidad1);
        debilidades.add(debilidad2);

        ArrayList<Fortaleza> fortalezas = new ArrayList<>();
        fortalezas.add(fortaleza1);
        fortalezas.add(fortaleza2);

        // Crear un objeto Personaje
        Personaje personaje1 = new Personaje("Personaje1", 1, habilidades1, armas, armaduras, esbirros, debilidades, fortalezas);
        Personaje personaje2 = new Personaje("Personaje2", 1, habilidades2, armas, armaduras, esbirros, debilidades, fortalezas);
        
        // Crear una ronda
        Ronda ronda = new Ronda(personaje1, personaje2);

        // Verificar que los valores de salud inicial son correctos
        assertEquals(personaje1.getSalud(), ronda.getSaludDesafiante());
        assertEquals(personaje2.getSalud(), ronda.getSaludDesafiado());
    }

    @Test
    public void testCalcularVida() {
        // Vampiro vacío
        Vampiro vampiro = new Vampiro("Vampiro Vacío", 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0, new Disciplina("", 0, 0), 0);

        // Licántropo vacío
        Licantropo licantropo = new Licantropo("Licántropo Vacío", 2, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0, 0, 5, new Don("", 0, 0));

        // Cazador vacío
        Cazador cazador = new Cazador("Cazador Vacío", 3, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0, null);

        // Calcular vida con ataque menor que defensa
        assertEquals(5, calcularVida(licantropo, 5, 3));
        // Comprobar que la rabia sigue igual
        assertEquals(5, licantropo.getRabia());

        // Calcular vida con ataque igual a defensa
        assertEquals(5, calcularVida(licantropo, 5, 5));
        // Comprobar que la rabia sigue igual
        assertEquals(5, licantropo.getRabia());

        // Calcular vida con ataque mayor que defensa
        assertEquals(4, calcularVida(licantropo, 5, 7));
        // Comprobar que la rabia se incrementa en 1
        assertEquals(6, licantropo.getRabia());

        // Calcular vida con ataque menor que defensa
        assertEquals(5, calcularVida(vampiro, 5, 3));

        // Calcular vida con ataque igual a defensa
        assertEquals(5, calcularVida(vampiro, 5, 5));

        // Calcular vida con ataque mayor que defensa
        assertEquals(4, calcularVida(vampiro, 5, 7));

        // Calcular vida con ataque menor que defensa
        assertEquals(5, calcularVida(cazador, 5, 3));

        // Calcular vida con ataque igual a defensa
        assertEquals(5, calcularVida(cazador, 5, 5));

        // Calcular vida con ataque mayor que defensa
        assertEquals(4, calcularVida(cazador, 5, 7));
    }

    @Test
    public void testCalcularPotencialAtaque() {
        // Crear habilidades para el vampiro
        Habilidad disciplina = new Disciplina("Dominate", 1, 5);
        
        // Crear armas y armaduras para el vampiro
        Arma arma = new Arma("Colmillos", 1, 1, true);
        Armadura armadura = new Armadura("Túnica de la noche", 1, 1, true);
        
        // Crear listas de habilidades, armas y armaduras
        ArrayList<Habilidad> habilidadesVampiro = new ArrayList<>();
        habilidadesVampiro.add(disciplina);
        
        ArrayList<Arma> armasVampiro = new ArrayList<>();
        armasVampiro.add(arma);
        
        ArrayList<Armadura> armadurasVampiro = new ArrayList<>();
        armadurasVampiro.add(armadura);
        
        // Crear esbirros para el vampiro (puede estar vacía si no tiene)
        ArrayList<Esbirro> esbirrosVampiro = new ArrayList<>();
        
        // Crear debilidades y fortalezas para el vampiro (pueden estar vacías si no tiene)
        ArrayList<Debilidad> debilidadesVampiro = new ArrayList<>();
        ArrayList<Fortaleza> fortalezasVampiro = new ArrayList<>();
        
        // Crear un objeto Disciplina para el vampiro
        Disciplina poderVampirico = new Disciplina("Poder Vampírico", 1, 5);
        
        // Crear un objeto Vampiro
        Vampiro vampiro = new Vampiro("Drácula", 1, habilidadesVampiro, armasVampiro, armadurasVampiro, esbirrosVampiro, debilidadesVampiro, fortalezasVampiro, 3, poderVampirico, 200);



        // Crear habilidades para el licántropo
        Habilidad habilidadLobo = new Don("Transformación en Lobo", 1, 5);
        
        // Crear armas y armaduras para el licántropo
        Arma garra = new Arma("Garra afilada", 1, 1, true);
        Armadura pielDura = new Armadura("Piel dura", 1, 1, true);
        
        // Crear listas de habilidades, armas y armaduras
        ArrayList<Habilidad> habilidadesLicantropo = new ArrayList<>();
        habilidadesLicantropo.add(habilidadLobo);
        
        ArrayList<Arma> armasLicantropo = new ArrayList<>();
        armasLicantropo.add(garra);
        
        ArrayList<Armadura> armadurasLicantropo = new ArrayList<>();
        armadurasLicantropo.add(pielDura);
        
        // Crear esbirros para el licántropo (puede estar vacía si no tiene)
        ArrayList<Esbirro> esbirrosLicantropo = new ArrayList<>();
        
        // Crear debilidades y fortalezas para el licántropo (pueden estar vacías si no tiene)
        ArrayList<Debilidad> debilidadesLicantropo = new ArrayList<>();
        debilidadesLicantropo.add(new Debilidad("Vulnerabilidad a la magia", 1, false));
        ArrayList<Fortaleza> fortalezasLicantropo = new ArrayList<>();
        fortalezasLicantropo.add(new Fortaleza("Regeneración rápida", 1,false));
        
        // Crear un objeto Don para el licántropo
        Don donLicantropo = new Don("Fuerza de la Bestia", 1, 5);
        
        // Crear un objeto Licantropo
        Licantropo licantropo = new Licantropo("Garra Nocturna", 2, habilidadesLicantropo, armasLicantropo, armadurasLicantropo, esbirrosLicantropo, debilidadesLicantropo, fortalezasLicantropo, 180, 80, 2, donLicantropo);



        // Crear habilidades para el cazador
        Habilidad puntería = new Talento("Puntería");
        
        // Crear armas y armaduras para el cazador
        Arma arco = new Arma("Arco", 1, 1, true);
        Armadura cuero = new Armadura("Armadura de cuero", 1, 5, true);
        
        // Crear listas de habilidades, armas y armaduras
        ArrayList<Habilidad> habilidadesCazador = new ArrayList<>();
        habilidadesCazador.add(puntería);
        
        ArrayList<Arma> armasCazador = new ArrayList<>();
        armasCazador.add(arco);
        
        ArrayList<Armadura> armadurasCazador = new ArrayList<>();
        armadurasCazador.add(cuero);
        
        // Crear esbirros para el cazador (puede estar vacía si no tiene)
        ArrayList<Esbirro> esbirrosCazador = new ArrayList<>();
        
        // Crear debilidades y fortalezas para el cazador (pueden estar vacías si no tiene)
        ArrayList<Debilidad> debilidadesCazador = new ArrayList<>();
        debilidadesCazador.add(new Debilidad("Vulnerabilidad a la magia", 5,false));
        ArrayList<Fortaleza> fortalezasCazador = new ArrayList<>();
        
        // Crear un objeto Cazador
        Cazador cazador = new Cazador("Robin Hood", 3, habilidadesCazador, armasCazador, armadurasCazador, esbirrosCazador, debilidadesCazador, fortalezasCazador, 5, (Talento) puntería);

        assertEquals(9, calcularPotencialAtaque(vampiro));
        assertEquals(9, calcularPotencialDefensa(vampiro));

    }

    @Test
    public void testExitosAtaque() {
        assertTrue(exitosAtaque(1) >= 0);
        assertTrue(exitosAtaque(5) <= 30);
    }

    @Test
    public void testExitosDefensa() {
        assertTrue(exitosDefensa(1) >= 0);
        assertTrue(exitosDefensa(5) <= 30);
    }

    private static int calcularPotencialDefensa(Personaje personaje) {
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

    private static int calcularPotencialAtaque(Personaje personaje) {
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

    private int calcularVida(Personaje personaje, int defensa, int ataque) {
        int diferencia = ataque - defensa;
        if (diferencia > 0) {
            int salud = personaje.getSalud() - 1;
            personaje.setSalud(salud);
            if (personaje instanceof Licantropo) {
                ((Licantropo) personaje).incrementarRabia(1);
            }
        }
        return personaje.getSalud();
    }

    private static int exitosAtaque(int ataque) {
        java.util.Random rand = new java.util.Random();
        int suma = 0;
        for (int i = 0; i < ataque; i++) {
            int numeroAleatorio = rand.nextInt(6) + 1;
            suma += numeroAleatorio;
        }
        return suma;
    }

    private static int exitosDefensa(int defensa) {
        java.util.Random rand = new java.util.Random();
        int suma = 0;
        for (int i = 0; i < defensa; i++) {
            int numeroAleatorio = rand.nextInt(6) + 1;
            suma += numeroAleatorio;
        }
        return suma;
    }
}
