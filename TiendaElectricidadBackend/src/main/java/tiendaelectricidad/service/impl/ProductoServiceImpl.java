package tiendaelectricidad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tiendaelectricidad.exception.ProductoNotFoundException;
import tiendaelectricidad.model.Producto;
import tiendaelectricidad.repository.ProductoRepository;
import tiendaelectricidad.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired   //Se Inyecta una instancia de ProductoRepository usando @Autowired,sin tener que hacerlo manualmente.
	private ProductoRepository productoRepository;
	
	@Override
	public List<Producto> obtenerTodosLosProductos() {
		
		return productoRepository.findAll();
	}

	@Override
	public Producto obtenerProductoPorId(Long id) {
		
		return productoRepository.findById(id).orElseThrow(
				()->new ProductoNotFoundException("Producto con id" + id + "no encontrado")); //Lanzamos exception cuando no está el producto
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		
		return productoRepository.save(producto);
	}

	@Override
	public Producto actualizarProducto(Long id, Producto producto) {
		
		//Obtenemos el producto existente por id
		Producto productoExistente= obtenerProductoPorId(id);
		
		//Actualizamos los valores del producto existente con los nuevos valores
		productoExistente.setNombre(producto.getNombre());
		
		productoExistente.setDescripcion(producto.getDescripcion());
		
		productoExistente.setPrecio(producto.getPrecio());
		
		productoExistente.setCategoria(producto.getCategoria());
		
		//Guardamos el producto actualizado
		
		return productoRepository.save(productoExistente);
	}
	
	@Override
	public void eliminarProducto(Long id) {
		
		Producto productoExistente= obtenerProductoPorId(id);
		
		productoRepository.delete(productoExistente);
	}

	

}
