package co.uceva.edu.base.beans;
import co.uceva.edu.base.models.Usuario;
import co.uceva.edu.base.services.UsuarioService;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Default;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.swing.*;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped

public class UsuarioBean implements Serializable {
    private UsuarioService usuarioService;
    private Usuario usuario;

    public UsuarioBean (){
        usuarioService  = new UsuarioService();
        usuario = new Usuario();
    }

    public String autenticar() {
        System.out.println("autenticando...");
        usuario =  usuarioService.autenticar(usuario.getCorreo(),usuario.getPassword());
        System.out.println(usuario.getId() +" revisado " +usuario.getNombre());

        if(usuario.getNombre() == ""){
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Autenticando","Error en la autenticacion");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            System.out.println("no se autentica");
            return "";

        }else{
            FacesMessage mensaje= new FacesMessage(FacesMessage.SEVERITY_WARN,"Autenticado","Atenticado correctmente");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            //System.out.println("Autenticado Exitosamente, bienvenido "+usuario.getNombre());
            System.out.println("si se autentica.");
            return "";
           // return "listado-empleados.xhtml?faces-redirect=true";  TODO porque no funciona el redireccionamiento ni los faces messages?
        }
    }

    public List<Usuario> listarUsuario(){
        return usuarioService.listarUsuario();
    }

    public String irCrear(){
     return "crear-usuario.xhtml?faces-redirect=true";
    }

    public String irActualizarUsuario(int id){
        this.usuario = usuarioService.consultarUsuario(id).get(0);
        return "actualizar-usuario.xhtml?faces-redirect=true";
    }

    public String crearUsuario(){
        if(usuarioService.crearUsuario(this.usuario)){
            System.out.println("Creado Exitosamente");
            return "listar-usuarios.xhtml?faces-redirect=true";
        }else{
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Guardando","Error Guardando, e id posiblemente ya existe");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }

    public String actualizarUsuario(){
        if(usuarioService.actualizarUsuario(this.usuario)){
            System.out.println("actualizado Exitosamente");
            return "listar-usuarios.xhtml?faces-redirect=true";
        }else{
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Actualizando","no actualizado");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }

    public String eliminarUsuario(int identificacion){
        if(usuarioService.eliminarUsuario(identificacion)){
            System.out.println("Eliminado Exitosamente");
            return "listar-usuarios.xhtml?faces-redirect=true";
        }else{
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Eliminando","no eliminado");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
