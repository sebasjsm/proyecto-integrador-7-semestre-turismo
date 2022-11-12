package co.uceva.edu.base.beans;
import co.uceva.edu.base.models.Empleado;
import co.uceva.edu.base.services.EmpleadoService;


import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Default;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped

public class EmpleadoBean implements Serializable {
    EmpleadoService empleadoService;
    Empleado empleado;

    public EmpleadoBean() {
        empleadoService = new EmpleadoService();
        empleado = new Empleado();
    }

    public List<Empleado> listar() {
        return empleadoService.listar();
    }

    public String irCrear() {
        return "crear-empleado.xhtml?faces-redirect=true";
    }

    public String irActualizar(int id){
        this.empleado=empleadoService.consultar(id).get(0);
        return "actualizar-empleado.xhtml?faces-redirect=true";
    }

    public String crear(){
        if(empleadoService.crear(this.empleado)){
            System.out.println("Creado Exitosamente");
            return "listar-empleados.xhtml?faces-redirect=true";
        }else{
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Guardando","Error Guardando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }
    public String actualizarEmpleado(){
        if(empleadoService.actualizarEmpleado(this.empleado)){
            System.out.println("actualizado Exitosamente");
            return "listar-empleados.xhtml?faces-redirect=true";
        }else{
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Actualizando","no actualizado");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }

    public String eliminarEmpleado(int identificacion){
        if(empleadoService.eliminarEmpleado(identificacion)){
            System.out.println("Eliminado Exitosamente");
            return "listar-empleados.xhtml?faces-redirect=true";
        }else{
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Eliminando","no eliminado");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
