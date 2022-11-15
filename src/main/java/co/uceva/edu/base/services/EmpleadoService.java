package co.uceva.edu.base.services;
import co.uceva.edu.base.models.Empleado;
import co.uceva.edu.base.models.Usuario;
import co.uceva.edu.base.repositories.EmpleadoRepository;
import java.util.List;

public class EmpleadoService {
    EmpleadoRepository empleadoRepository;

    public EmpleadoService() {
        empleadoRepository = new EmpleadoRepository();
    }

    public Empleado autenticar(String correo, String password){
        return empleadoRepository.autenticarEmpleado(correo,password);
    }

    public List<Empleado> listar (){
       return empleadoRepository.listar();
    }

    public boolean crear(Empleado empleado){
        if(empleadoRepository.consulta(empleado.getId()).size() > 0){
            return false;
        }else{
            return empleadoRepository.crear(empleado);
        }
    }

    public List<Empleado> consultar (int id ){
        return empleadoRepository.consulta(id);
    }

    public boolean eliminarEmpleado(int identificacion) {
        return empleadoRepository.eliminarEmpleado(identificacion);
    }

    public boolean actualizarEmpleado(Empleado empleado) {
        return empleadoRepository.actualizarEmpleado(empleado);
    }
}
