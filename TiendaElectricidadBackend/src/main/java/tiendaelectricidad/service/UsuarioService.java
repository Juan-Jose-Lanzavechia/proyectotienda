package tiendaelectricidad.service;

import java.util.List;

import tiendaelectricidad.model.Usuario;

public interface UsuarioService {

	List<Usuario> obtenerTodosLosUsuarios();
	
	Usuario obtenerUsuarioPorId(Long id);
	
	Usuario guardarUsuario(Usuario usuario);
	
	Usuario actualizarUsuario(Long id, Usuario usuario);
	
	void eliminarUsuario(Long id);
}
