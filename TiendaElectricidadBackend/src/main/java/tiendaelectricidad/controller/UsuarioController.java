package tiendaelectricidad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tiendaelectricidad.model.Usuario;
import tiendaelectricidad.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")

public class UsuarioController {

	@Autowired
	
	private UsuarioService usuarioService;
	
	//Obtener todos los usuarios
	
	@GetMapping
	
	public List<Usuario> obtenerTodosLosUsuarios(){
		
		return usuarioService.obtenerTodosLosUsuarios();
		
	}
	
	//Obtener usuario por id
	
	@GetMapping("/{id}")
	
	public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
		
		Usuario usuario= usuarioService.obtenerUsuarioPorId(id);
		
		return ResponseEntity.ok(usuario);
	}
	
	//Crear nuevo usuario
	
	@PostMapping
	
	public ResponseEntity<Usuario> guardarUsuario (@RequestBody Usuario usuario){
		
		Usuario nuevoUsuario=usuarioService.guardarUsuario(usuario);
		
		return ResponseEntity.ok(nuevoUsuario);
	}
	
	//Actualizar un usuario existente
	
	@PutMapping ("/{id}")
	
	public ResponseEntity<Usuario> actualizarUsuario 
	
	   (@PathVariable Long id, @RequestBody Usuario usuario) {
		
		Usuario usuarioActualizado= usuarioService.actualizarUsuario(id, usuario);
		
		return ResponseEntity.ok(usuarioActualizado);
	}
	
	//Eliminar un usuario
	
	@DeleteMapping("/{id}")
	
	public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id){
		
		usuarioService.eliminarUsuario(id);
		
		return ResponseEntity.noContent().build();
	}
}
