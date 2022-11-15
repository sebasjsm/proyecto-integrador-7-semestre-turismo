package co.uceva.edu.base.models;

public class Usuario {

    private long telefono,otroTelefono;
    private String nombre,correo,nacimiento,otroNombre,id,idPack;


    public Usuario(String id, String nombre, String correo,long telefono, long otroTelefono, String nacimiento, String otroNOmbre, String idPack) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.otroTelefono = otroTelefono;
        this.nacimiento=nacimiento;
        this.otroNombre = otroNOmbre;
        this.idPack=idPack;

    }

    public Usuario() {
        this.id = "";
        this.nombre = "";
        this.correo = "";
        this.telefono = 0;
        this.otroTelefono = 0;
        this.nacimiento="";
        this.otroNombre = "";
        this.idPack="";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public long getOtroTelefono() {
        return otroTelefono;
    }

    public void setOtroTelefono(long otroTelefono) {
        this.otroTelefono = otroTelefono;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getOtroNombre() {
        return otroNombre;
    }

    public void setOtroNombre(String otroNombre) {
        this.otroNombre = otroNombre;
    }

    public String getIdPack() {
        return idPack;
    }

    public void setIdPack(String idPack) {
        this.idPack = idPack;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
