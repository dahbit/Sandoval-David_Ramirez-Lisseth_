package modelo;

import java.util.List;

public class Odontologo {
    private Integer id;
    private String NoMatricula;
    private String Nombre;
    private String Apellido;

    public Odontologo(String apellido, String nombre, String noMatricula) {
        this.Apellido = apellido;
        this.Nombre = nombre;
        this.NoMatricula = noMatricula;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNoMatricula() {
        return NoMatricula;
    }

    public void setNoMatricula(String noMatricula) {
        NoMatricula = noMatricula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
