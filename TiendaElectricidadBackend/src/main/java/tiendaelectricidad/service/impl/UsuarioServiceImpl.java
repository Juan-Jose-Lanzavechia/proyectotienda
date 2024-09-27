package tiendaelectricidad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tiendaelectricidad.exception.UsuarioNotFoundException;
import tiendaelectricidad.model.Usuario;
import tiendaelectricidad.repository.UsuarioRepository;
import tiendaelectricidad.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService{

	@Autowired   //Se Inyecta una instancia de UsuarioRepository usando @Autowired,sin tener que hacerlo manualmente.
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> obtenerTodosLosUsuarios() {
		
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario obtenerUsuarioPorId(Long id) {
		
		return usuarioRepository.findById(id).orElseThrow(
				()-> new UsuarioNotFoundException("Usuario con id" + id + "no encontrado")); //Lanzamos exception si no se encuentra el usuario
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
	}

	
	@Override
	public Usuario actualizarUsuario(Long id, Usuario usuario) {
		
		Usuario usuarioExistente= obtenerUsuarioPorId(id);
		
		usuarioExistente.setNombre(usuario.getNombre());
		
		usuarioExistente.setCorreoElectronico(usuario.getCorreoElectronico());
		
		usuarioExistente.setContrasenia(usuario.getContrasenia());
		
		return usuarioRepository.save(usuarioExistente);
	}
	
	@Override
	public void eliminarUsuario(Long id) {
	
		Usuario usuarioExistente=obtenerUsuarioPorId(id);
		
		usuarioRepository.delete(usuarioExistente);
	}


}
