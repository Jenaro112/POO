/* 
1. . Defina una clase Figura que tenga los siguientes atributos:
• Color
• Coordenada del centro de la forma (Defina una clase Punto con atributos coordenadaX y coordenadaY)
• Nombre de la forma

Y, al menos, los siguientes métodos:
• toString. Sobrescribir el método heredado de Object
• Obtener y cambiar el color
• Mover la forma (o sea, su centro)

Defina una subclase Rectángulo que herede de Figura y tenga los siguientes atributos:
• Lado menor.
• Lado mayor.

Y, al menos, los siguientes métodos:
• toString. Debe retornar un string mostrando que se trata de un rectángulo, su nombre, color,
centro y lado. Debería usarse la función toString de la clase base para realizar parte de este
trabajo.
• Calcular el área (lado menor * lado mayor).
• Calcular el perímetro. (2 * lado menor + 2 * lado mayor).
• Cambiar el tamaño del rectángulo. Recibe como parámetro un factor de escala. Así, por
ejemplo, si el factor vale 2, el rectángulo duplicará su tamaño y si es 0,5 se reducirá a la
mitad. Qué pasaría o cómo deberían manejar un factor de escala negativo o cero?

 */

public class main {

    public class Punto {

        double coordenadaX;
        double coordenadaY;

        public void SetCoordenadaX(double x) {
            this.coordenadaX = x;
        }

        public void SetCoordenadaY(double y) {
            this.coordenadaY = y;
        }

        public double GetCoordenadaX(double coordenadaX) {
            return coordenadaX;
        }

        public double GetCoordenadaY(double coordenadaY) {
            return coordenadaY;
        }

        public void mover_forma(int dx, int dy) {
            this.coordenadaX += dx;
            this.coordenadaY += dy;
        }

        @Override
        public String toString() {
            return "(" + coordenadaX + ", " + coordenadaY + ")";
        }
    }

    public class Figura {

        private String color;
        protected Punto centro;
        public String nombre;

        public Figura(String color, Punto centro, String nombre) {
            this.color = color;
            this.centro = centro;
            this.nombre = nombre;
        }

        // Getter y Setter del color
        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        // Método para mover la figura
        public void mover(int dx, int dy) {
            this.centro.mover_forma(dx, dy);
        }

        @Override
        public String toString() {
            return "Figura: " + nombre + ", Color: " + color + ", Centro: " + centro;
        }
    }

    public class Rectangulo extends Figura {

        public Rectangulo(String color, Punto centro, String nombre, double ladoMenor, double ladoMayor) {
            super(color, centro, nombre);
            this.ladoMenor = ladoMenor;
            this.ladoMayor = ladoMayor;
        }

        private double ladoMenor;
        private double ladoMayor;

        public void Set_Lado_Mayor(double ladoMayor) {
            this.ladoMayor = ladoMayor;
        }

        public void Set_Lado_Menor(double ladoMenor) {
            this.ladoMenor = ladoMenor;
        }

        public double Get_Lado_Mayor() {
            return ladoMayor;
        }

        public double Get_Lado_Menor() {
            return ladoMenor;
        }

        @Override
        public String toString() {
            return "Rectángulo: " + super.toString() + ", Lado Menor: " + ladoMenor + ", Lado Mayor: " + ladoMayor + "Color: " + getColor() + ", Centro: " + centro;
        }

        public double Area() {
            return ladoMenor * ladoMayor;
        }

        public double Perimetro() {
            return 2 * ladoMenor + 2 * ladoMayor;
        }

        public void cambiarTamaño(double factor) {
            if (factor <= 0) {
                System.out.println("El factor de escala debe ser mayor que cero.");
                return;
            }
            this.ladoMenor *= factor;
            this.ladoMayor *= factor;
        }
    }

    public static void main(String[] args) {

        //* Colores :)
        String Amarillo = "\u001b[33m";
        String azul = "\u001b[34m";
        String reset = "\u001b[0m";
        String negrita = "\u001b[1m";

        Punto centro = new main().new Punto();
        centro.SetCoordenadaX(5);
        centro.SetCoordenadaY(10);

        Rectangulo rectangulo = new main().new Rectangulo("Azul", centro, "Rectangulo", 4, 6);
        System.out.println("------------------------------------------------------------------");
        System.out.println(negrita + azul + "Caracteristicas de la figura" + reset);
        System.out.println("-   " + negrita + Amarillo + "Color: " + reset + rectangulo.getColor());
        System.out.println("-   " + negrita + Amarillo + "Centro: " + reset + rectangulo.centro.toString());
        System.out.println("-   " + negrita + Amarillo + "Nombre: " + reset + rectangulo.nombre);
        System.out.println("-   " + negrita + Amarillo + "Lado Menor: " + reset + rectangulo.Get_Lado_Menor());
        System.out.println("-   " + negrita + Amarillo + "Lado Mayor: " + reset + rectangulo.Get_Lado_Mayor());

        System.out.println("------------------------------------------------------------------");
        System.out.println(negrita + azul + "Datos del rectángulo:" + reset);
        System.out.println("-   " + negrita + Amarillo + "Area: " + reset + rectangulo.Area());
        System.out.println("-   " + negrita + Amarillo + "Perímetro: " + reset + rectangulo.Perimetro());

        System.out.println("------------------------------------------------------------------");
        rectangulo.cambiarTamaño(2);
        System.out.println("Después de cambiar tamaño: " + rectangulo.toString());
    }
}
