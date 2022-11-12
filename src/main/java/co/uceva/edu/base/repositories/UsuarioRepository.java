package co.uceva.edu.base.repositories;
import co.uceva.edu.base.models.Empleado;
import co.uceva.edu.base.models.Usuario;
import co.uceva.edu.base.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

    public List<Usuario> listar(){
        List<Usuario> listadousuario = new ArrayList<>();
        Connection con =null;
        ResultSet rs=null;
        Statement st =null;
        try /*(con = ConexionBaseDatos.getConnection();)*/{                 //aqui ponemos las clases que pueden ser cerradas
            con = ConexionBaseDatos.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                Usuario emp = new Usuario();
                emp.setId(rs.getInt("id"));
                emp.setNombre(rs.getString("nombre"));
                emp.setCorreo(rs.getString("correo"));
                emp.setPassword(rs.getString("password"));
                listadousuario.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            try {
                rs.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listadousuario;
    }//fin de la funcion de listado


    public boolean crear(Usuario usuario){
        Connection con=null;
        PreparedStatement pst =null;
        try{
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("INSERT INTO usuarios (id,nombre,correo,password) VALUES(?,?,?,?)");
            pst.setInt(1,usuario.getId());
            pst.setString(2,usuario.getNombre());
            pst.setString(3,usuario.getCorreo());
            pst.setString(4, usuario.getPassword());
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



    public List<Usuario> consulta(Integer id){
        Connection con=null;
        PreparedStatement pst =null;
        ResultSet rs =null;
        List<Usuario> listadousuario = new ArrayList<>();
        try{
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("SELECT * FROM usuarios WHERE id=?");
            pst.setInt(1,id);
            rs  = pst.executeQuery();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setPassword(rs.getString("password"));
                listadousuario.add(usuario);
            }

        }catch (Exception e){
            e.printStackTrace();
            return listadousuario;
        }finally {
            try {
                pst.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                return listadousuario;
            }

        }
        return listadousuario;
    }

    public boolean actualizarUsuario(Usuario usuario){
        Connection con =null;
        PreparedStatement st =null;

        try {
            con = ConexionBaseDatos.getConnection();
            st = con.prepareStatement("UPDATE usuarios SET nombre=? , password=?, correo=? WHERE id=?");
            st.setString(1, usuario.getNombre());
            st.setString(2, usuario.getPassword());
            st.setString(3, usuario.getCorreo());
            st.setInt(4, usuario.getId());
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

    public boolean eliminarUsuario(int identify){
        Connection con =null;
        PreparedStatement st =null;
        try {
            con = ConexionBaseDatos.getConnection();
            st = con.prepareStatement("DELETE FROM usuarios WHERE id=?");
            st.setInt(1, identify);
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




    public Usuario autenticarUsuario (String correo,String password){
        Connection con=null;
        PreparedStatement pst =null;
        ResultSet rs =null;
        Usuario usuario =new Usuario();
        try{
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("SELECT * FROM usuarios WHERE correo=? AND password=?");
            pst.setString(1,correo);
            pst.setString(2,password);
            rs  = pst.executeQuery();

            while(rs.next()){
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                //  usuario.setCorreo(rs.getString("correo"));
                //  usuario.setPassword(rs.getString("password"));

            }


        }catch (Exception e){
                e.printStackTrace();


        }finally {
            try {
                pst.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        return usuario;
    }//fin de la funcion de autenticacion
}
