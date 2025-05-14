import java.util.Arrays;

public class cuatroo {

    private int[] numeros = { 4, 2, 3, 8, 1 };

    public int cantidadNumeros() {
        return numeros.length; //* Se usa la propiedad length para saber cuántos elementos hay
    }

    public int mayorNumero() {
        int mayor = numeros[0]; // Se asume que el primero es el mayor inicialmente
        for (int num : numeros) {
            if (num > mayor) {
                mayor = num; // Se actualiza si se encuentra uno mayor
            }
        }
        return mayor;
    }

    public double promedio() {
        int suma = 0;
        for (int num : numeros) {
            suma += num; //* Se suman todos los números
        }
        return (double) suma / numeros.length; //* Se divide por la cantidad total para obtener el promedio
    }

    public int[] ordenarAscendente() {
        int[] copia = Arrays.copyOf(numeros, numeros.length); //* Se hace una copia para no modificar el original
        Arrays.sort(copia); //* Se ordena de menor a mayor
        return copia;
    }

    public int[] ordenarDescendente() {
        int[] copia = ordenarAscendente(); //* Se obtiene primero una copia ordenada ascendentemente
        for (int i = 0; i < copia.length / 2; i++) { //* Se invierte el orden para que quede descendente
            int temp = copia[i];
            copia[i] = copia[copia.length - 1 - i];
            copia[copia.length - 1 - i] = temp;
        }
        return copia;
    }

    public void imprimirArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println(); // Salto de línea
    }

    public static void main(String[] args) {
        cuatroo ae = new cuatroo();

        System.out.println("--------------------------------------------------------------");
        System.out.println("Cantidad de números: " + ae.cantidadNumeros());
        System.out.println("--------------------------------------------------------------");
        System.out.println("Número mayor: " + ae.mayorNumero());
        System.out.println("--------------------------------------------------------------");
        System.out.println("Promedio: " + ae.promedio());
        
        System.out.println("--------------------------------------------------------------");
        System.out.print("Orden ascendente: ");
        ae.imprimirArray(ae.ordenarAscendente());
        
        System.out.println("--------------------------------------------------------------");
        System.out.print("Orden descendente: ");
        ae.imprimirArray(ae.ordenarDescendente());
    }
}
