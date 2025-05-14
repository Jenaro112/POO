//*Agregue métodos para calcular, si el numero es par o impar, el factorial de numero, si numero es primo. Pruebelos.
public class cinco {

    public static class Entero { 
        private int numero;

        // constructor de la clase Enteros
        public Entero(int numero) {
            this.numero = numero;
        }

        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        
        public long cuadrado() {
            return (long) numero * numero; 
        }

        public int ParImpar() { 
            if (numero % 2 == 0) {
                System.out.println("El numero " + numero + " es par");
            } else {
                System.out.println("El numero " + numero + " es impar");
            }
            return numero;
        }

        public long factorial() {
            if (numero == 0) {
                return 1;
            }
            long resultado = 1;
            for (int i = 1; i <= numero; i++) {
                resultado *= i;
            }
            return resultado;
        }

        public boolean primo(){
        if (numero <= 1) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }
}

    public static void main(String[] args) {
        Entero miEntero = new Entero(7);
        System.out.println("El numero es: " + miEntero.getNumero());
        System.out.println("El cuadrado es: " + miEntero.cuadrado());
        miEntero.ParImpar();
        System.out.println("el factorial es " + miEntero.factorial());
        System.out.println(miEntero.primo());
    }
}