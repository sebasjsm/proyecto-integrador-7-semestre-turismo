package co.uceva.edu.base.models;

public class Usuario {
    private int id;
    private String nombre;
    public String correo;
    public String password;

    public Usuario(int id, String nombre, String correo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    public Usuario() {
        this.id = 0;
        this.nombre = "";
        this.correo = "";
        this.password = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword(){return this.password;}
}
