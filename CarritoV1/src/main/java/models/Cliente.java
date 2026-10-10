package models;

public class Cliente {

    private int id;
    private String nombre;
    private String identificacion;
    private String telefono;
    private String correo;
    private  String contrasena;

    public Cliente( String nombre , String identificacion, String telefono , String correo, String contrasena){

        if(nombre.trim().isEmpty()){

            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        if(identificacion.trim().isEmpty()){

            throw new IllegalArgumentException("La identificacion no puede estar vacia");
        }
        if(telefono.trim().isEmpty()){

            throw new IllegalArgumentException("El Telefono no puede estar vacio");
        }

        if(correo.trim().isEmpty()){
            correo = null;
        }
        if(contrasena.replace(" ", "").length() < 5){

            throw new IllegalArgumentException("Contraseña Debe Tener Minimo 5 Caracteres ");
        }

        this.nombre = nombre;
        this.correo = correo;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.contrasena = contrasena;
    }
    public Cliente( int id, String nombre , String identificacion, String telefono , String correo){

        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.identificacion = identificacion;
        this.telefono = telefono;

    }
    public int getId() {
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public String getIdentificacion(){
        return  identificacion;
    }

    public  String getTelefono(){
        return  telefono;

    }
    public String getCorreo(){
        return correo;
    }

    public String getContrasena(){

        return contrasena;
    }
}
