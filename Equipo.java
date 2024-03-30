public class Equipo {
    private String nombre;
    private int manos;
    private int valor;

    private boolean activa;

    public Equipo(String nombre, int manos, int valor, boolean activa){
        this.nombre = nombre;
        this.manos = manos;
        this.valor = valor;
        this.activa = activa;
    }

    public String getNombreEquipo(){
        return this.nombre;
    }
    public boolean getActiva(){
        return this.activa;
    }

    public void setActiva(boolean activa){
        this.activa = activa;
    }

    public int getValor(){
        return this.valor;
    }

    public int getManos(){
        return this.manos;
    }
}

class Arma extends Equipo{

    public Arma(String nombre, int manos, int valor, boolean activa){
        super(nombre, manos, valor, activa);
    }

}

class Armadura extends Equipo{

    public Armadura(String nombre, int manos, int valor, boolean activa){
        super(nombre, manos, valor, activa);
    }
}
