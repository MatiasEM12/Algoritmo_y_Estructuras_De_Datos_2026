package Practica_1_Abstraccion_y_Encapsulamiento.Punto_2;

public class Estudiante {

    private String nombre;
    private String apellido;
    private Integer legajo;

    public Estudiante(String nombre, String apellido, Integer legajo) {
        validarNombreApellido( nombre);
        validarNombreApellido(apellido);
        validarLegajo(legajo);

        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
    }

    public String tusDatos(){
        return "Nombre: " + this.nombre + ", Apellido: " + this.apellido + ", Legajo: " + Integer.toString(this.legajo);
    }

    public void validarNombreApellido(String valor){
        if(valor == null) throw new NullPointerException("El valor no puede ser nulo");
        if(valor.isEmpty()) throw new IllegalArgumentException("El valor no puede ser vacío");
    }

    public void validarLegajo(Integer legajo){
        if(legajo == null) throw new NullPointerException("El valor no puede ser nulo");
        if(legajo <= 0) throw new IllegalArgumentException("El valor no puede ser menor o igual a cero");
    }
}
