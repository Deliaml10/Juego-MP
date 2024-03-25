public class Personaje {
    private String nombre;
    private String habilidades;
    private Arma[] armas;
    private Armadura[] armaduras;
    private Integer armasActivas;
    private Integer armadurasActivas;
    private Esbirro[] esbirros;
    private Integer oro;
    private Integer salud;
    private Integer poder;
    private Debilidad[] debilidades;
    private Fortaleza[] fortalezas;


    public Personaje (String nombre, String habilidades){
        this.nombre = nombre;
        this.oro = 100;
        this.salud = 5;
        this.poder = 5;
    }
}
