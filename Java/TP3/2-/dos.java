import java.util.Scanner;

public class dos {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese la Nota (del 1 al 10):"); // ? Imprime el texto, como un print en python
            int Nota = scanner.nextInt();
            
            if (Nota > 9) {
                System.out.println("Sobresaliente");
            } else if (Nota < 9 & Nota > 6) {
                System.out.println("Aprobado");
            } else {
                System.out.println("Desaprobado");
            }
        } // ? Imprime el texto, como un print en python
    }
}