package co.uceva.edu.base.services;

import co.uceva.edu.base.models.Empleado;
import co.uceva.edu.base.models.Pack;
import co.uceva.edu.base.repositories.EmpleadoRepository;
import co.uceva.edu.base.repositories.PackRepository;

import java.util.List;

public class PackService {
    PackRepository paqueteRepository;

    public PackService() {
        paqueteRepository = new PackRepository();
    }

    public List<Pack> listar (){
        return paqueteRepository.listar();
    }

    public boolean crear(Pack paquete){
        if(paqueteRepository.consulta(paquete.getId()).size() > 0){
            return false;
        }else{
            return paqueteRepository.crear(paquete);
        }
    }
    public List<Pack> consultar (String id ){
        return paqueteRepository.consulta(id);
    }

    public List<Pack> consultarXTipo (String tipo ){
        return paqueteRepository.consultaXTipo(tipo);
    }

    public boolean eliminarPack(String identificacion) {
        return paqueteRepository.eliminarPack(identificacion);
    }

    public boolean actualizarPack(Pack paquete) {
        return paqueteRepository.actualizarPack(paquete);
    }
}
