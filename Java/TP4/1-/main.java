/*  
Cree una aplicación que represente el mapa del mundo, con las siguientes características:
•   Un País tiene un nombre, una capital, superficie (en km2) y pertenece a un continente.
•   Un País esta compuesto por provincias (en algunos países pueden ser estados y en otros departamentos pero tomaremos provincias para todos los casos).
•   Un Continente tiene un nombre y esta compuesto por Países. Vamos a suponer que un país solo pertenece a un continente.
•   Una Provincia tiene un nombre.

Estas clases deben tener operaciones para:
•   Crear e inicializar objetos. Método constructor y por ejemplo un continente crea sus países, un país sus provincias.
•   Devolver y actualizar los valores de sus atributos. Métodos get y set.
•   Devolver los Países de un Continente.
•   Devolver las Provincias de un País.
•   Sobrescribir el método toString de cada clase para mostrar como String a cada objeto.
*/

public class main {
    public static void main(String[] args) {
        
        class Pais {
            String nombre;
            String capital;
            double superficie;
            Provincia[] provincias;

            public Pais(String nombre, String capital, double superficie, Provincia[] provincias) {
                this.nombre = nombre;
                this.capital = capital;
                this.superficie = superficie;
                this.provincias = provincias;
            }

            //* GETTERS Y SETTERS */
            public String getNombre() {
                return nombre;
            }

            public void setNombre(String nombre) {
                this.nombre = nombre;
            }

            public String getCapital() {
                return capital;
            }

            public void setCapital(String capital) {
                this.capital = capital;
            }

            public double getSuperficie() {
                return superficie;
            }

            public void setSuperficie(double superficie) {
                this.superficie = superficie;
            }

            public Provincia[] getProvincias() {
                return provincias;
            }

            public void setProvincias(Provincia[] provincias) {
                this.provincias = provincias;
            }

            class Provincia {
                String nombre;

                public Provincia(String nombre) {
                    this.nombre = nombre;
                }

                //* GETTERS Y SETTERS */
                public String getNombre() {
                    return nombre;
                }

                public void setNombre(String nombre) {
                    this.nombre = nombre;
                }

                @Override
                public String toString() {
                    return "Provincia{" +
                            "nombre='" + nombre + '\'' +
                            '}';
                }
            }
        }

        class Continente {
            String nombre;
            Pais[] paises;

            public Continente(String nombre, Pais[] paises) {
                this.nombre = nombre;
                this.paises = paises;
            }

            //* GETTERS Y SETTERS */
            public String getNombre() {
                return nombre;
            }

            public void setNombre(String nombre) {
                this.nombre = nombre;
            }

            public Pais[] getPaises() {
                return paises;
            }

            public void setPaises(Pais[] paises) {
                this.paises = paises;
            }
        }
    }
}
