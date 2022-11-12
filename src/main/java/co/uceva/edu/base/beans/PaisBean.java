package co.uceva.edu.base.beans;
import co.uceva.edu.base.models.Empleado;
import co.uceva.edu.base.models.Pais;
import co.uceva.edu.base.services.EmpleadoService;
import co.uceva.edu.base.services.PaisService;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Default;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped

public class PaisBean implements Serializable{
    PaisService paisService;
    Pais pais;

    public PaisBean() {
        paisService = new PaisService();
        pais = new Pais();
    }

    public List<Pais> listar() {
        return paisService.listar();
    }

    public String irCrear() {
        return "crear-pais.xhtml?faces-redirect=true";
    }

    public String irActualizar(int codigo_postal){
        this.pais=paisService.consultar(codigo_postal).get(0);
        return "actualizar-pais.xhtml?faces-redirect=true";
    }

    public String crear(){
        if(paisService.crear(this.pais)){
            System.out.println("Creado Exitosamente");
            return "listar-paises.xhtml?faces-redirect=true";
        }else{
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Guardando","Error Guardando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }
    public String actualizarPais(){
        if(paisService.actualizarPais(this.pais)){
            System.out.println("actualizado Exitosamente");
            return "listar-paises.xhtml?faces-redirect=true";
        }else{
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Actualizando","no actualizado");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }

    public String eliminarPais(int codigo_postal){
        if(paisService.eliminarPais(codigo_postal)){
            System.out.println("Eliminado Exitosamente");
            return "listar-paises.xhtml?faces-redirect=true";
        }else{
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Eliminando","no eliminado");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
