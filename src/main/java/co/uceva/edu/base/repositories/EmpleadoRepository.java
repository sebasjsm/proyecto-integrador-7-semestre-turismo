package co.uceva.edu.base.repositories;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import co.uceva.edu.base.models.Empleado;
import co.uceva.edu.base.util.ConexionBaseDatos;

public class EmpleadoRepository {

    public List<Empleado> listar(){
        List<Empleado> listadoEmpleado = new ArrayList<>();
        Connection con =null;
        ResultSet rs=null;
        Statement st =null;
        try /*(con = ConexionBaseDatos.getConnection();)*/{                 //aqui ponemos las clases que pueden ser cerradas
            con = ConexionBaseDatos.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM empleados");
            while(rs.next()){
                Empleado emp = new Empleado();
                emp.setId(rs.getInt("id"));
                emp.setNombre(rs.getString("nombre"));
                emp.setDepartamento(rs.getString("departamento"));
                emp.setSalario(rs.getInt("salario"));
                emp.setCorreo(rs.getString("correo"));
                emp.setPassword(rs.getString("password"));
                listadoEmpleado.add(emp);
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
        return listadoEmpleado;
    }//fin de la funcion de listado


    public boolean crear(Empleado empleado){
        Connection con=null;
        PreparedStatement pst =null;
        try{
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("INSERT INTO empleados (id,nombre,departamento,salario,correo,password) VALUES(?,?,?,?,?,?)");
            pst.setInt(1,empleado.getId());
            pst.setString(2,empleado.getNombre());
            pst.setString(3,empleado.getDepartamento());
            pst.setLong(4, empleado.getSalario());
            pst.setString(5, empleado.getCorreo());
            pst.setString(6, empleado.getPassword());

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


    public List<Empleado> consulta(Integer id){
        Connection con=null;
        PreparedStatement pst =null;
        ResultSet rs =null;
        List<Empleado> listadoEmpleado = new ArrayList<>();
        try{
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("SELECT * FROM empleados WHERE id=?");
            pst.setInt(1,id);
            rs  = pst.executeQuery();
            while(rs.next()){
                Empleado empleado = new Empleado();
                empleado.setId(rs.getInt("id"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setDepartamento(rs.getString("departamento"));
                empleado.setSalario(rs.getInt("salario"));
                listadoEmpleado.add(empleado);
            }

        }catch (Exception e){
            e.printStackTrace();
            return listadoEmpleado;
        }finally {
            try {
                pst.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                return listadoEmpleado;
            }

        }
        return listadoEmpleado;
    }// fin de la funcion consultar

    public boolean eliminarEmpleado(int identify){
        Connection con =null;
        PreparedStatement st =null;
        try {
            con = ConexionBaseDatos.getConnection();
            st = con.prepareStatement("DELETE FROM empleados WHERE id=?");
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

    public boolean actualizarEmpleado(Empleado empleado){
        Connection con =null;
        PreparedStatement st =null;
        try {
            con = ConexionBaseDatos.getConnection();
            st = con.prepareStatement("UPDATE empleados SET nombre=? , departamento=?, salario=?, correo=?, password=? WHERE id=?");
            st.setString(1, empleado.getNombre());
            st.setString(2, empleado.getDepartamento());
            st.setLong(3, empleado.getSalario());
            st.setString(4, empleado.getCorreo());
            st.setString(5, empleado.getPassword());
            st.setInt(6, empleado.getId());
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

    public Empleado autenticarEmpleado(String correo, String password) {
        Connection con=null;
        PreparedStatement pst =null;
        ResultSet rs =null;
        Empleado empleado =new Empleado();

        try{
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("SELECT * FROM empleados WHERE correo=? AND password=?");
            pst.setString(1,correo);
            pst.setString(2,password);
            rs  = pst.executeQuery();

            while(rs.next()){

                empleado.setId(rs.getInt("id"));
                empleado.setNombre(rs.getString("nombre"));

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
        return empleado;
    }
}
