package models;

public class Categoria {

    private String nombre;

    public Categoria(String nombre) {
        if(nombre.trim().isEmpty()){

            throw new IllegalArgumentException("El campo _nombre categoria_ no puede ser vacio");
        }
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
