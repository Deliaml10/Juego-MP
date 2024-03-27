import java.util.Random;
public class Jugador extends Usuario {
    private String numero;

    public Jugador (String nombre, String contrasena, String nick){
        super(nombre, contrasena, nick);
        this.numero = CrearNumero();
    }
    public String CrearNumero()

    {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";

        Random random = new Random();
        StringBuilder codigo = new StringBuilder();

        int indice = random.nextInt(letras.length());
        codigo.append(letras.charAt(indice));

        for (int i = 0; i < 2; i++) {
            int indice1 = random.nextInt(numeros.length());
            codigo.append(numeros.charAt(indice));
        }
        for (int i = 0; i < 2; i++) {
            int indice2 = random.nextInt(letras.length());
            codigo.append(letras.charAt(indice));
        }

            return codigo.toString();
    }
}
