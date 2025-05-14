import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Continente {
    private String nombre;
    private Set<Pais> paises; // Colección de países

    // Constructor
    public Continente(String nombre) {
        this.nombre = nombre;
        this.paises = new HashSet<>(); // Inicializar el conjunto de países
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para devolver los países (devuelve una copia para proteger la original)
    public Set<Pais> getPaises() {
        return new HashSet<>(paises); // Devuelve una copia defensiva
    }

    // Método para añadir un país
    public void addPais(Pais pais) {
        if (pais != null && pais.getContinente() == this) { // Asegura que el país pertenezca a este continente
            this.paises.add(pais);
        } else if (pais != null) {
            System.err.println("Advertencia: Intentando añadir el país '" + pais.getNombre() +
                                "' al continente '" + this.nombre +
                                "' pero el país pertenece a '" + (pais.getContinente() != null ? pais.getContinente().getNombre() : "ninguno") + "'.");
            // Opcional: forzar la asignación
            // pais.setContinente(this);
            // this.paises.add(pais);
        }
    }

    // Método para inicializar países (ejemplo)
    public void inicializarPaises(Set<Pais> paises) {
        for (Pais pais : paises) {
           addPais(pais); // Usa el método addPais para validación
        }
    }

    // Sobrescribir toString
    @Override
    public String toString() {
        return "Continente{" +
                "nombre='" + nombre + '\'' +
                ", numeroPaises=" + paises.size() +
                '}';
    }

    // Sobrescribir equals y hashCode para correcto funcionamiento en Sets/Maps
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Continente that = (Continente) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}