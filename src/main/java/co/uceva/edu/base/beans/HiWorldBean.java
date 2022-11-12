package co.uceva.edu.base.beans;
import co.uceva.edu.base.models.Empleado;
import co.uceva.edu.base.util.ConexionBaseDatos;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Named;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//@RequestScoped
@RequestScoped
@Named
public class HiWorldBean {
    private String welcome = "prueba soportada de nivel 3, obteniendo datos en progreso......3";
    private String access= "si este mensaje fue despleagado, todo funciona"; //TODO porque no agarran los estilos de oclor ???
    private String bait= "complete";

    public String getBait() {
        return bait;
    }

    public void setBait(String bait) {
        this.bait = bait;
    }

    public String getwelcome() {
        return welcome;
    }

    public void setwelcome(String welcom) {
        welcome = welcom;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}//fin de la clase
