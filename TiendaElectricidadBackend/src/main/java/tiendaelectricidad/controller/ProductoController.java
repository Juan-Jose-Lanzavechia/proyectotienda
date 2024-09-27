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

import tiendaelectricidad.model.Producto;
import tiendaelectricidad.service.ProductoService;

@RestController

@RequestMapping("/api/productos")

public class ProductoController {

	@Autowired
	
	private ProductoService productoService;
	
	//Obtener todos los productos
	
	@GetMapping
	
	public List<Producto> obtenerTodosLosProductos(){
	
		return productoService.obtenerTodosLosProductos();
		
	}
	
	//Obtener producto por id
	
	@GetMapping("/{id}")
	
	public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
		
		Producto producto= productoService.obtenerProductoPorId(id);
		
		return ResponseEntity.ok(producto);
	}
	
	//Crear nuevo producto
	
	@PostMapping 
	
	public ResponseEntity<Producto> guardarProducto (@RequestBody Producto producto){
		
		Producto nuevoProducto=productoService.guardarProducto(producto);
		
		return ResponseEntity.ok(nuevoProducto);
	}
	
	//Actualizar un producto existente
	
	@PutMapping("/{id}")
	
	public ResponseEntity<Producto> actualizarProducto
	         (@PathVariable Long id, @RequestBody Producto producto){
		
		Producto productoActualizado= productoService.actualizarProducto(id, producto);
		
		return ResponseEntity.ok(productoActualizado);
	}
	
	//Eliminar un producto
	
	@DeleteMapping("/{id}")
	
	public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
		
		productoService.eliminarProducto(id);
		
		return ResponseEntity.noContent().build();
	}
	
} 
