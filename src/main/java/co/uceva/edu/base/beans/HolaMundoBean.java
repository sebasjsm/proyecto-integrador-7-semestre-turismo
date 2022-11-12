package co.uceva.edu.base.beans;

import co.uceva.edu.base.models.Empleado;
import co.uceva.edu.base.util.ConexionBaseDatos;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class HolaMundoBean {
    private String welcome="Sé Bienvenido";

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }


}
