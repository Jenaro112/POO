import java.util.Objects;

public class Provincia {
    private String nombre;

    // Constructor
    public Provincia(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Sobrescribir toString
    @Override
    public String toString() {
        return "Provincia{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    // Sobrescribir equals y hashCode para correcto funcionamiento en Sets
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provincia provincia = (Provincia) o;
        return Objects.equals(nombre, provincia.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}