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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Provincia {
    private String nombre;

    public Provincia(String nombre) {
        this.nombre = nombre;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "  - " + nombre; // Formato de lista con sangría
    }
}

class Pais {
    private String nombre;
    private String capital;
    private double superficie;
    private Provincia[] provincias;
    private String continente;

    public Pais(String nombre, String capital, double superficie, Provincia[] provincias, String continente) {
        this.nombre = nombre;
        this.capital = capital;
        this.superficie = superficie;
        this.provincias = provincias;
        this.continente = continente;
    }

    // Getters y setters (sin cambios)
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

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("País: ").append(nombre).append("\n");
        sb.append("  Capital: ").append(capital).append("\n");
        sb.append("  Superficie: ").append(superficie).append(" km²\n");
        sb.append("  Continente: ").append(continente).append("\n");
        if (provincias.length > 0) {
            sb.append("  Provincias:\n");
            for (Provincia provincia : provincias) {
                sb.append("    ").append(provincia).append("\n"); // Más sangría para provincias
            }
        } else {
            sb.append("  Provincias: Ninguna\n");
        }
        return sb.toString();
    }
}

class Continente {
    private String nombre;
    private Pais[] paises;

    public Continente(String nombre, Pais[] paises) {
        this.nombre = nombre;
        this.paises = paises;
    }

    // Getters y setters (sin cambios)
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continente: ").append(nombre).append("\n");
        if (paises.length > 0) {
            sb.append("  Países:\n");
            for (Pais pais : paises) {
                sb.append("    - ").append(pais.getNombre()).append("\n"); // Lista simple de nombres de países
            }
        } else {
            sb.append("  Países: Ninguno\n");
        }
        return sb.toString();
    }
}

class MapaMundial {
    private Continente[] continentes;

    public MapaMundial() {
        // Instanciar Provincias
        Provincia entreRios = new Provincia("Entre Ríos");
        Provincia buenosAires = new Provincia("Buenos Aires");
        Provincia santaFe = new Provincia("Santa Fé");
        Provincia corrientes = new Provincia("Corrientes");
        Provincia cordoba = new Provincia("Córdoba");
        Provincia salto = new Provincia("Salto");
        Provincia paysandu = new Provincia("Paysandú");
        Provincia canelones = new Provincia("Canelones");
        Provincia rocha = new Provincia("Rocha");
        Provincia maldonado = new Provincia("Maldonado");

        // Instanciar Países
        Pais argentina = new Pais("Argentina", "Buenos Aires", 2780400, new Provincia[]{entreRios, buenosAires, santaFe, corrientes, cordoba}, "América");
        Pais uruguay = new Pais("Uruguay", "Montevideo", 176215, new Provincia[]{salto, paysandu, canelones, rocha, maldonado}, "América");
        Pais brasil = new Pais("Brasil", "Brasilia", 8515767, new Provincia[]{}, "América");
        Pais chile = new Pais("Chile", "Santiago", 756102, new Provincia[]{}, "América");
        Pais paraguay = new Pais("Paraguay", "Asunción", 406752, new Provincia[]{}, "América");
        Pais bolivia = new Pais("Bolivia", "Sucre", 1098581, new Provincia[]{}, "América");
        Pais espana = new Pais("España", "Madrid", 505990, new Provincia[]{}, "Europa");
        Pais francia = new Pais("Francia", "París", 551695, new Provincia[]{}, "Europa");
        Pais italia = new Pais("Italia", "Roma", 301340, new Provincia[]{}, "Europa");
        Pais portugal = new Pais("Portugal", "Lisboa", 92212, new Provincia[]{}, "Europa");

        // Instanciar Continentes
        Continente america = new Continente("América", new Pais[]{argentina, uruguay, brasil, chile, paraguay, bolivia});
        Continente europa = new Continente("Europa", new Pais[]{espana, francia, italia, portugal});
        Continente asia = new Continente("Asia", new Pais[]{});
        Continente africa = new Continente("África", new Pais[]{});
        Continente oceania = new Continente("Oceanía", new Pais[]{});
        Continente antartida = new Continente("Antártida", new Pais[]{});

        this.continentes = new Continente[]{america, europa, asia, africa, oceania, antartida};
    }

    public Set<Pais> getPaises(String nombreContinente) {
        for (Continente continente : continentes) {
            if (continente.getNombre().equalsIgnoreCase(nombreContinente)) {
                return new HashSet<>(Arrays.asList(continente.getPaises()));
            }
        }
        return new HashSet<>();
    }

    public Set<Provincia> getProvincias(String nombrePais) {
        for (Continente continente : continentes) {
            for (Pais pais : continente.getPaises()) {
                if (pais.getNombre().equalsIgnoreCase(nombrePais)) {
                    return new HashSet<>(Arrays.asList(pais.getProvincias()));
                }
            }
        }
        return new HashSet<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Mapa Mundial:\n");
        for (Continente continente : continentes) {
            sb.append(continente).append("\n");
        }
        return sb.toString();
    }
}

public class main {
    public static void main(String[] args) {
        MapaMundial mapa = new MapaMundial();

        System.out.println("--- Países en América ---");
        mapa.getPaises("América").forEach(pais -> System.out.println(pais.toString())); // Usamos el toString personalizado

        System.out.println("\n--- Provincias de Argentina ---");
        mapa.getProvincias("Argentina").forEach(provincia -> System.out.println(provincia.toString())); // Usamos el toString personalizado

        System.out.println("\n--- Mapa Mundial Completo ---");
        System.out.println(mapa); // Se llama al toString de MapaMundial, que a su vez llama al de Continente y Pais
    }
}