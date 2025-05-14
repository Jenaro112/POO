import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Mapa_Mundial {

    // Usamos un Map para acceder fácilmente a los continentes por nombre
    private Map<String, Continente> continentes;

    // Constructor que inicializa todo
    public Mapa_Mundial() {
        continentes = new HashMap<>();
        inicializar();
    }

    private void inicializar() {
        // 1. Instanciar e Inicializar Continentes
        Continente america = new Continente("América");
        Continente europa = new Continente("Europa");
        Continente asia = new Continente("Asia");
        Continente africa = new Continente("África");
        Continente oceania = new Continente("Oceanía");
        Continente antartida = new Continente("Antártida");

        // Guardar continentes en el mapa
        continentes.put(america.getNombre().toLowerCase(), america); // Guardar en minúsculas para búsqueda insensible
        continentes.put(europa.getNombre().toLowerCase(), europa);
        continentes.put(asia.getNombre().toLowerCase(), asia);
        continentes.put(africa.getNombre().toLowerCase(), africa);
        continentes.put(oceania.getNombre().toLowerCase(), oceania);
        continentes.put(antartida.getNombre().toLowerCase(), antartida);


        // 2. Instanciar e Inicializar Países y Vincular con Continente
        // América
        Pais argentina = new Pais("Argentina", "Buenos Aires", 2780400, america);
        Pais uruguay = new Pais("Uruguay", "Montevideo", 176215, america);
        Pais brasil = new Pais("Brasil", "Brasilia", 8515767, america);
        Pais chile = new Pais("Chile", "Santiago", 756102, america);
        Pais paraguay = new Pais("Paraguay", "Asunción", 406752, america);
        Pais bolivia = new Pais("Bolivia", "Sucre", 1098581, america);

        // Europa
        Pais espana = new Pais("España", "Madrid", 505990, europa);
        Pais francia = new Pais("Francia", "París", 551695, europa);
        Pais italia = new Pais("Italia", "Roma", 301340, europa);
        Pais portugal = new Pais("Portugal", "Lisboa", 92212, europa);

        // Añadir países a sus continentes
        america.addPais(argentina);
        america.addPais(uruguay);
        america.addPais(brasil);
        america.addPais(chile);
        america.addPais(paraguay);
        america.addPais(bolivia);

        europa.addPais(espana);
        europa.addPais(francia);
        europa.addPais(italia);
        europa.addPais(portugal);

        // 3. Instanciar e Inicializar Provincias y Vincular con País
        // Argentina
        argentina.addProvincia(new Provincia("Entre Ríos"));
        argentina.addProvincia(new Provincia("Buenos Aires"));
        argentina.addProvincia(new Provincia("Santa Fé"));
        argentina.addProvincia(new Provincia("Corrientes"));
        argentina.addProvincia(new Provincia("Córdoba"));

        // Uruguay
        uruguay.addProvincia(new Provincia("Salto"));
        uruguay.addProvincia(new Provincia("Paysandú"));
        uruguay.addProvincia(new Provincia("Canelones"));
        uruguay.addProvincia(new Provincia("Rocha"));
        uruguay.addProvincia(new Provincia("Maldonado"));

        // Nota: No se especificaron provincias para los demás países, se dejan vacías.
    }

    /**
     * Devuelve el conjunto de países pertenecientes a un continente específico.
     *
     * @param nombreContinente El nombre del continente (insensible a mayúsculas/minúsculas).
     * @return Un Set de objetos Pais, o un Set vacío si el continente no existe.
     */
    public Set<Pais> getPaises(String nombreContinente) {
        Continente continente = continentes.get(nombreContinente.toLowerCase());
        if (continente != null) {
            return continente.getPaises(); // Devuelve la copia defensiva del continente
        } else {
            System.out.println("Continente '" + nombreContinente + "' no encontrado.");
            return Collections.emptySet(); // Devuelve un conjunto vacío inmutable
        }
    }

    /**
     * Devuelve el conjunto de provincias pertenecientes a un país específico.
     * Busca el país en todos los continentes.
     *
     * @param nombrePais El nombre del país (insensible a mayúsculas/minúsculas).
     * @return Un Set de objetos Provincia, o un Set vacío si el país no existe.
     */
    public Set<Provincia> getProvincias(String nombrePais) {
        String nombrePaisLower = nombrePais.toLowerCase();
        // Iterar sobre todos los continentes
        for (Continente continente : continentes.values()) {
            // Iterar sobre los países de cada continente
            for (Pais pais : continente.getPaises()) { // Usa el getter que devuelve copia
                if (pais.getNombre().toLowerCase().equals(nombrePaisLower)) {
                    return pais.getProvincias(); // Devuelve la copia defensiva del país
                }
            }
        }
        System.out.println("País '" + nombrePais + "' no encontrado.");
        return Collections.emptySet(); // Devuelve un conjunto vacío inmutable si no se encuentra
    }

    // Método opcional para obtener todos los continentes
    public Set<Continente> getContinentes() {
        return new HashSet<>(continentes.values());
    }

     // Método opcional para mostrar la estructura general
    public void mostrarMapa() {
        System.out.println("--- Mapa Mundial ---");
        for (Continente cont : continentes.values()) {
            System.out.println("\nContinente: " + cont.getNombre());
            Set<Pais> paisesDelContinente = cont.getPaises();
            if (paisesDelContinente.isEmpty()) {
                System.out.println("  (Sin países registrados)");
            } else {
                for (Pais p : paisesDelContinente) {
                    System.out.println("  -> " + p); // Usa el toString de Pais
                    Set<Provincia> provs = p.getProvincias();
                    if (!provs.isEmpty()) {
                            System.out.print("     Provincias: ");
                            int count = 0;
                            for (Provincia prov : provs) {
                                System.out.print(prov.getNombre() + (++count < provs.size() ? ", " : ""));
                            }
                            System.out.println();
                    } else {
                            System.out.println("     (Sin provincias registradas)");
                    }
                }
            }
        }
        System.out.println("--------------------");
    }
}