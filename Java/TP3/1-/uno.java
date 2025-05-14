import java.util.Scanner;

public class uno {
    public static void main(String[] args) {
        // Leer tres números
        try (Scanner scanner = new Scanner(System.in)) {
            // Leer tres números
            System.out.print("Ingrese el primer número: ");
            int num1 = scanner.nextInt();
            
            System.out.print("Ingrese el segundo número: ");
            int num2 = scanner.nextInt();
            
            System.out.print("Ingrese el tercer número: ");
            int num3 = scanner.nextInt();
            
            // Verificar si el primer número es positivo
            if (num1 > 0) {
                int producto = num2 * num3;
                System.out.println("El primer número es positivo. El producto de los otros dos es: " + producto);
            } else {
                int suma = num2 + num3;
                System.out.println("El primer número no es positivo. La suma de los otros dos es: " + suma);
            }
        }
    }
}