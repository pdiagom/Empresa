package model;


/**
 * La clase {@code Persona} representa a una persona con atributos como
 * DNI, nombre y sexo. Se utiliza como entidad en una base de datos
 * y se beneficia de las anotaciones de Lombok para la generación
 * automática de métodos comunes.
 */

public class Persona {

    public String dni;

    public String nombre;
    public String sexo;

    /**
     * Establece el DNI de la persona.
     *
     * @param dni El nuevo DNI de la persona.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Imprime el nombre y el DNI de la persona en la consola.
     */
    public void imprime() {
        System.out.println(nombre + " " + dni);
    }

    /**
     * Constructor que crea una nueva instancia de {@code Persona}
     * con un DNI, nombre y sexo.
     *
     * @param dni El DNI de la persona.
     * @param nombre El nombre de la persona.
     * @param sexo El sexo de la persona ('M' para masculino, 'F' para femenino).
     */
    public Persona(String dni, String nombre, String sexo) {
        this.dni = dni;
        this.nombre = nombre;
        this.sexo = sexo;
    }

    /**
     * Constructor que crea una nueva instancia de {@code Persona}
     * con un nombre y sexo, sin especificar el DNI.
     *
     * @param nombre El nombre de la persona.
     * @param sexo El sexo de la persona ('M' para masculino, 'F' para femenino).
     */
    public Persona(String nombre, String sexo) {
        this.nombre = nombre;
        this.sexo = sexo;
    }

    public Persona() {
    }

}
