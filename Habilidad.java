public class Habilidad {
    private String nombre;

    public Habilidad(String nombre){
        this.nombre = nombre;
    }
}

class Disciplina extends Habilidad {
    private int valor;
    private int sangreNecesaria;

    public Disciplina(String nombre, int valor, int sangreNecesaria){
        super(nombre);
        this.valor = valor;
        this.sangreNecesaria = sangreNecesaria;
    }
    public static int getSangre(){
        int sangre = this.valor;
        return sangre;
    }
}

class Don extends Habilidad{
    private Integer valor;
    private Integer rabiaNecesaria;

    public Don(String nombre, int valor, int rabiaNecesaria){
        super(nombre);
        this.valor = valor;
        this.rabiaNecesaria = rabiaNecesaria;
    }
}

class Talento extends Habilidad{

    public Talento(String nombre){
        super(nombre);
    }

}