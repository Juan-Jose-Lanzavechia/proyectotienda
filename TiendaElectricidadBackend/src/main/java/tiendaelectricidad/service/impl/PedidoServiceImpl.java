package tiendaelectricidad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tiendaelectricidad.exception.PedidoNotFoundException;
import tiendaelectricidad.model.Pedido;
import tiendaelectricidad.repository.PedidoRepository;
import tiendaelectricidad.service.PedidoService;

public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public List<Pedido> obtenerTodosLosPedidos() {
		
		return pedidoRepository.findAll();
	}

	@Override
	public Pedido obtenerPedidoPorId(Long id) {
		
		return pedidoRepository.findById(id).orElseThrow(
				()->new PedidoNotFoundException("Pedido con id" + id + "no encontrado"));
	}

	@Override
	public Pedido guardarPedido(Pedido pedido) {
		
		return pedidoRepository.save(pedido);
	}

	@Override
	public Pedido actualizarPedido(Long id, Pedido pedido) {
		
		Pedido pedidoExistente=obtenerPedidoPorId(id);
		
		pedidoExistente.setFechaPedido(pedido.getFechaPedido());
		
		pedidoExistente.setEstado(pedido.getEstado());
		
		return pedidoRepository.save(pedidoExistente);
	}
	
	@Override
	public void eliminarPedido(Long id) {
		
		Pedido pedidoExistente= obtenerPedidoPorId(id);
		
		pedidoRepository.delete(pedidoExistente);
		
	}

	

	
}
