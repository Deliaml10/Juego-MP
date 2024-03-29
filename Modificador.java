public class Modificador {
    private String nombre;
    private Integer valor;

    public Modificador(String nombre, Integer valor){
        this.nombre = nombre;
        this.valor = valor;
    }
}

class Debilidad extends Modificador{

    public Debilidad(String nombre, Integer valor){
        super(nombre, valor);
    }

}

class Fortaleza extends Modificador{

    public Fortaleza(String nombre, Integer valor){
        super(nombre, valor);
    }
}
