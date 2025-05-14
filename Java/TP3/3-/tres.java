import java.util.Scanner;

public class tres {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese una palabra:");
            String palabra = scanner.nextLine();
            
            String palindromo = new StringBuilder(palabra).reverse().toString();
            
            if (palabra.equals(palindromo)) {
                System.out.println("La palabra es palindromo");
            } else {
                System.out.println("La palabra no es palindromo");
            }
        }
    }
}
