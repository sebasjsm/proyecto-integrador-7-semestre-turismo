package co.uceva.edu.base.services;

import co.uceva.edu.base.models.Empleado;
import co.uceva.edu.base.models.Usuario;
import co.uceva.edu.base.repositories.UsuarioRepository;

import java.util.List;

public class UsuarioService {
    UsuarioRepository  usuarioRepository;

    public UsuarioService() {
        usuarioRepository = new UsuarioRepository();
    }

    public Usuario autenticar(String correo, String password){
        return usuarioRepository.autenticarUsuario(correo,password);
    }

    public List<Usuario> listarUsuario (){
       return usuarioRepository.listar();
    }

    public boolean crearUsuario(Usuario usuario){
        if(usuarioRepository.consulta(usuario.getId()).size() > 0){
            return false;
        }else{
            return usuarioRepository.crear(usuario);
        }
    }// TODO hacer validacion por id,correo


    public List<Usuario> consultarUsuario (String id ){
        return usuarioRepository.consulta(id);
    }

    public void nuevaCompra(Usuario usuarioNuevo){
        usuarioRepository.nuevaCompra(usuarioNuevo);
    }

    public boolean actualizarUsuario(Usuario usuario) {
        return usuarioRepository.actualizarUsuario(usuario);
    }

    public boolean eliminarUsuario(String identificacion) {
        return usuarioRepository.eliminarUsuario(identificacion);
    }
}
