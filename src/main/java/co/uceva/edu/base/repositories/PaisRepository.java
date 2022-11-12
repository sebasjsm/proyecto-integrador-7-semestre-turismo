package co.uceva.edu.base.repositories;
import co.uceva.edu.base.models.Empleado;
import co.uceva.edu.base.models.Pais;
import co.uceva.edu.base.util.ConexionBaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaisRepository {
    public List<Pais> listar(){
        List<Pais> listadoPaises = new ArrayList<>();
        Connection con =null;
        ResultSet rs=null;
        Statement st =null;
        try /*(con = ConexionBaseDatos.getConnection();)*/{                 //aqui ponemos las clases que pueden ser cerradas
            con = ConexionBaseDatos.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM paises");
            while(rs.next()){
                Pais pais = new Pais();
                pais.setCodigo_postal(rs.getInt("codigo_postal"));
                pais.setNombre(rs.getString("nombre"));
                pais.setCapital(rs.getString("capital"));
                pais.setContinente(rs.getString("continente"));
                pais.setIso(rs.getString("iso"));
                listadoPaises.add(pais);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            try {
                rs.close();
                con.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listadoPaises;
    }//fin de la funcion de listado


    public boolean crear(Pais pais){
        Connection con=null;
        PreparedStatement pst =null;
        try{
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("INSERT INTO paises (codigo_postal,nombre,capital,continente,iso) VALUES(?,?,?,?,?)");
            pst.setInt(1,pais.getCodigo_postal());
            pst.setString(2,pais.getNombre());
            pst.setString(3,pais.getCapital());
            pst.setString(4,pais.getContinente());
            pst.setString(5,pais.getIso());
            pst.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

        }
        return true;
    }// fin de la funcion crear


    public List<Pais> consulta(Integer codigo_postal){
        Connection con=null;
        PreparedStatement pst =null;
        ResultSet rs =null;
        List<Pais> listadoPaises = new ArrayList<>();
        try{
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("SELECT * FROM paises WHERE codigo_postal=?");
            pst.setInt(1,codigo_postal);
            rs  = pst.executeQuery();
            while(rs.next()){
                Pais pais = new Pais();
                pais.setCodigo_postal(rs.getInt("codigo_postal"));
                pais.setNombre(rs.getString("nombre"));
                pais.setCapital(rs.getString("capital"));
                pais.setContinente(rs.getString("continente"));
                pais.setIso(rs.getString("iso"));
                listadoPaises.add(pais);
            }

        }catch (Exception e){
            e.printStackTrace();
            return listadoPaises;
        }finally {
            try {
                pst.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                return listadoPaises;
            }

        }
        return listadoPaises;
    }// fin de la funcion consultar

    public boolean eliminarPais(int codigo_postal){
        Connection con =null;
        PreparedStatement st =null;
        try {
            con = ConexionBaseDatos.getConnection();
            st = con.prepareStatement("DELETE FROM paises WHERE codigo_postal=?");
            st.setInt(1, codigo_postal);
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }finally {
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }//fin de la funcion de borrado

    public boolean actualizarPais(Pais pais){
        Connection con =null;
        PreparedStatement st =null;
        try {
            con = ConexionBaseDatos.getConnection();
            st = con.prepareStatement("UPDATE paises SET nombre=? , capital=?, continente=?, iso=? WHERE codigo_postal=?");
            st.setString(1, pais.getNombre());
            st.setString(2, pais.getCapital());
            st.setString(3, pais.getContinente());
            st.setString(4, pais.getIso());
            st.setInt(5, pais.getCodigo_postal());
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }finally {
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }//fin de la funcion de actualizado

}
