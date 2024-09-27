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

import tiendaelectricidad.model.Pedido;
import tiendaelectricidad.service.PedidoService;

@RestController

@RequestMapping("/api/pedidos")

public class PedidoController {

	@Autowired
	
	private PedidoService pedidoService;
	
	//Obtener todos los pedidos
	
	@GetMapping
	
	public List<Pedido> obtenerTodosLosPedidos(){
		
		return pedidoService.obtenerTodosLosPedidos();
	}
	
	//Obtener pedido por id
	
	@GetMapping("/{id}")
	
	public ResponseEntity<Pedido> obtenerPedidoPorId(@PathVariable Long id) {
		
		Pedido pedido=pedidoService.obtenerPedidoPorId(id);
		
		return ResponseEntity.ok(pedido);
	}
	
	//Crear nuevo pedido
	
	@PostMapping
	
	public ResponseEntity<Pedido> guardarPedido(@RequestBody Pedido pedido){
		
		Pedido nuevoPedido=pedidoService.guardarPedido(pedido);
		
		return ResponseEntity.ok(nuevoPedido);
	}
	
	//Actualizar pedido existente
	
	@PutMapping("/{id}") 
	
	public ResponseEntity<Pedido> actualizarPedido
	(@PathVariable Long id, @RequestBody Pedido pedido){
		
		Pedido pedidoActualizado=pedidoService.actualizarPedido(id, pedido);
		
		return ResponseEntity.ok(pedidoActualizado);
	}
	
	//Eliminar un pedido
	
	@DeleteMapping("/{id}")
	
	public ResponseEntity<Void> eliminarPedido(@PathVariable Long id){
		
		pedidoService.eliminarPedido(id);
		
		return ResponseEntity.noContent().build();
	}
}
