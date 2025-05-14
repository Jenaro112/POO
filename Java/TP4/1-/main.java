public class main {

    class Continente {
        String nombre;
        int poblacion;
        double superficie;

        public Continente(String nombre, int poblacion, double superficie) {
            this.nombre = nombre;
            this.poblacion = poblacion;
            this.superficie = superficie;
        }

        public String getNombre() {
            return nombre;
        }

        public int getPoblacion() {
            return poblacion;
        }

        public double getsuperficie() {
            return superficie;
        }
    }
}