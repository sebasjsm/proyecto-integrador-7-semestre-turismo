package co.uceva.edu.base.models;
public class Empleado {
    private int id;
    private String nombre,departamento,correo,password;
    private long salario;

    public Empleado(int id, String nombre, String departamento, long salario,String correo,String password) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
        this.correo=correo;
        this.password=password;
    }

    public Empleado() {
        this.id = 0;
        this.nombre = "";
        this.departamento = "";
        this.salario = 0;
        this.password="";
        this.correo="";
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public long getSalario() {
        return salario;
    }

    public void setSalario(long salario) {
        this.salario = salario;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
