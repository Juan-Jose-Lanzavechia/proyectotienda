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

import tiendaelectricidad.model.CategoriaProducto;
import tiendaelectricidad.service.CategoriaProductoService;

@RestController

@RequestMapping("/api/categoriaproductos")

public class CategoriaProductoController {

	@Autowired
	
	private CategoriaProductoService categoriaProductoService;
	
	//Obtener todas las categorias de productos
	
	@GetMapping
	
	public List<CategoriaProducto> obtenerTodasLasCategorias(){
		
		return categoriaProductoService.obtenerTodasLasCategorias();
	}
	
	//Obtener categoria de productos por id
	
	@GetMapping("/{id}")
	
	public ResponseEntity<CategoriaProducto> obtenerCategoriaProductoPorId(@PathVariable Long id){
		
		CategoriaProducto categoriaProducto=categoriaProductoService.obtenerCategoriaPorId(id);
		
		return ResponseEntity.ok(categoriaProducto);
	}
	
	//Crear nueva categoria de producto
	
	@PostMapping
	
	public ResponseEntity<CategoriaProducto> guardarCategoriaProducto
	
	(@RequestBody CategoriaProducto categoriaProducto){
		
	  CategoriaProducto nuevaCategoriaProducto= categoriaProductoService.guardarCategoria
			  
			  (categoriaProducto);
	  
		return ResponseEntity.ok(nuevaCategoriaProducto);
	}
	
	//Actualizar una categoria existente
	
	@PutMapping("/{id}")
	
	public ResponseEntity<CategoriaProducto> actualizarCategoria
	         (@PathVariable Long id, @RequestBody CategoriaProducto categoriaProducto) {
		
		CategoriaProducto categoriaActualizada=
				
		categoriaProductoService.actualizarCategoria(id, categoriaProducto);
		
		return ResponseEntity.ok(categoriaActualizada);
	}
	
	//Eliminar categoria de producto
	
	@DeleteMapping("/{id}")
	
	public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id){
		
		categoriaProductoService.eliminarCategoria(id);
		
		return ResponseEntity.noContent().build();
	}
}
