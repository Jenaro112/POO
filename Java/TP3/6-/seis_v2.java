
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 6. Cree una aplicación que gestione empleados y permita:
• Registrar nombre y sueldo de empleados.
• Devolver el nombre y sueldo del empleado que más gana.
• Devolver el sueldo promedio. */


public class seis_v2 {

    public static void main(String[] args) {
        GestorEmpleados gestor = new GestorEmpleados();
        gestor.cargarEmpleados();
        gestor.mostrarResultados();
    }
}

class Empleado {
    private final String nombre;
    private final double sueldo;

    public Empleado(String nombre, double sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }
}

class GestorEmpleados {
    private final Map<String, Empleado> empleados = new HashMap<>();

    private final String RESET = "\u001B[0m";
    private final String AMARILLO = "\u001B[33m";
    private final String VERDE = "\u001B[32m";

    public void cargarEmpleados() {
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.println("¿Cuántas personas va a ingresar?");
            int cantidad = entrada.nextInt();
            entrada.nextLine();

            for (int i = 0; i < cantidad; i++) {
                System.out.println("--------------------------------");
                System.out.println("Ingrese el nombre del empleado #" + (i + 1));
                String nombre = entrada.nextLine();
                System.out.println("Ingrese el sueldo del empleado #" + (i + 1));
                double sueldo = entrada.nextDouble();
                entrada.nextLine();

                empleados.put(nombre, new Empleado(nombre, sueldo));
            }
        }
    }

    public void mostrarResultados() {
        double suma = 0;
        double maximo = -1;
        String nombreMax = "";

        for (Empleado empleado : empleados.values()) {
            double sueldo = empleado.getSueldo();
            suma += sueldo;

            if (sueldo > maximo) {
                maximo = sueldo;
                nombreMax = empleado.getNombre();
            }
        }

        double promedio = empleados.isEmpty() ? 0 : suma / empleados.size();

        System.out.println("--------------------------------");
        System.out.println(VERDE + "El empleado que más gana es:" + RESET);
        System.out.println("-   Nombre: " + nombreMax);
        System.out.println("-   Sueldo: " + maximo);

        System.out.println(AMARILLO + "El promedio del sueldo es: $" + promedio + RESET);
    }
}