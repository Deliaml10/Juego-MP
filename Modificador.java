public class Modificador {
    private String nombre;
    private int valor;

    private boolean activado;

    public Modificador(String nombre, Integer valor, boolean activado){
        this.nombre = nombre;
        this.valor = valor;
        this.activado = activado;
    }
}

class Debilidad extends Modificador{

    public Debilidad(String nombre, Integer valor, boolean activado){
        super(nombre, valor, activado);
    }

}

class Fortaleza extends Modificador{

    public Fortaleza(String nombre, Integer valor, boolean activado){
        super(nombre, valor, activado);
    }
}
