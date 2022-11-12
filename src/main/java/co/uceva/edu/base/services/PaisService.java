package co.uceva.edu.base.services;

import co.uceva.edu.base.models.Empleado;
import co.uceva.edu.base.models.Pais;
import co.uceva.edu.base.repositories.EmpleadoRepository;
import co.uceva.edu.base.repositories.PaisRepository;

import java.util.List;

public class PaisService {
    PaisRepository paisRepository;

    public PaisService() {
        paisRepository = new PaisRepository();
    }

    public List<Pais> listar (){
        return paisRepository.listar();
    }

    public boolean crear(Pais pais){
        if(paisRepository.consulta(pais.getCodigo_postal()).size() > 0){
            return false;
        }else{
            return paisRepository.crear(pais);
        }
    }

    public List<Pais> consultar (int codigo_postal ){
        return paisRepository.consulta(codigo_postal);
    }

    public boolean eliminarPais(int codigo_postal) {
        return paisRepository.eliminarPais(codigo_postal);
    }

    public boolean actualizarPais(Pais pais) {
        return paisRepository.actualizarPais(pais);
    }
}
