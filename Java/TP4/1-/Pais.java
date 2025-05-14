import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Pais {
    private String nombre;
    private String capital;
    private double superficie; // en km2
    private Continente continente; // Referencia al continente al que pertenece
    private Set<Provincia> provincias; // Colección de provincias

    // Constructor
    public Pais(String nombre, String capital, double superficie, Continente continente) {
        this.nombre = nombre;
        this.capital = capital;
        this.superficie = superficie;
        this.continente = continente;
        this.provincias = new HashSet<>(); // Inicializar el conjunto de provincias
    }

    // Getters y Setters
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

    public Continente getContinente() {
        return continente;
    }

    public void setContinente(Continente continente) {
        // Considerar si se debe actualizar también la lista de países en el continente
        this.continente = continente;
    }

    // Método para devolver las provincias (devuelve una copia para proteger la original)
    public Set<Provincia> getProvincias() {
        return new HashSet<>(provincias); // Devuelve una copia defensiva
    }

    // Método para añadir una provincia
    public void addProvincia(Provincia provincia) {
        if (provincia != null) {
            this.provincias.add(provincia);
        }
    }

     // Método para inicializar provincias (ejemplo)
    public void inicializarProvincias(Set<Provincia> provincias) {
        this.provincias.addAll(provincias);
    }


    // Sobrescribir toString
    @Override
    public String toString() {
        return "Pais{" +
                "nombre='" + nombre + '\'' +
                ", capital='" + capital + '\'' +
                ", superficie=" + superficie + " km2" +
                ", continente=" + (continente != null ? continente.getNombre() : "N/A") +
                ", numeroProvincias=" + provincias.size() +
                '}';
    }

    // Sobrescribir equals y hashCode para correcto funcionamiento en Sets (basado en el nombre)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return Objects.equals(nombre, pais.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}