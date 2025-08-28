package scr.Ejercicio2;

//|---------------------------------------------------------------|
//|                       Ejercicio Dos                           |
//|---------------------------------------------------------------|
public class TareaMultiplicacion implements Runnable {

    private final int[][] matrizA;
    private final int[][] matrizB;
    private final int[][] resultado;
    private final int fila;
    private final int columna;

    public TareaMultiplicacion(int[][] matrizA, int[][] matrizB, int[][] resultado, int fila, int columna) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
        this.resultado = resultado;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public void run() {
        resultado[fila][columna] = 0;
        for (int k = 0; k < matrizA[0].length; k++) { // matrizA[0].length es igual a matrizB.length
            resultado[fila][columna] += matrizA[fila][k] * matrizB[k][columna];
        }
    }
}
