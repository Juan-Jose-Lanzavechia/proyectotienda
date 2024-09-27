package tiendaelectricidad.service;

import java.util.List;

import tiendaelectricidad.model.Producto;

public interface ProductoService {

	List<Producto> obtenerTodosLosProductos();

	Producto obtenerProductoPorId(Long id);
	
	Producto guardarProducto(Producto producto);
	
	Producto actualizarProducto(Long id, Producto producto);
	
	void eliminarProducto(Long id);

}