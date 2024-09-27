package tiendaelectricidad.service;

import java.util.List;

import tiendaelectricidad.model.Pedido;

public interface PedidoService {

	List<Pedido> obtenerTodosLosPedidos();
	
	Pedido obtenerPedidoPorId(Long id);
	
	Pedido guardarPedido(Pedido pedido);
	
	Pedido actualizarPedido(Long id, Pedido pedido);
	
	void eliminarPedido(Long id);
}
