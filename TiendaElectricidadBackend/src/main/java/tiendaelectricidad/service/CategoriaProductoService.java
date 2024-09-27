package tiendaelectricidad.service;

import java.util.List;

import tiendaelectricidad.model.CategoriaProducto;

public interface CategoriaProductoService {
	
	List<CategoriaProducto> obtenerTodasLasCategorias();
	
	CategoriaProducto obtenerCategoriaPorId(Long id);
	
	CategoriaProducto guardarCategoria(CategoriaProducto categoria);
	
	CategoriaProducto actualizarCategoria(Long id, CategoriaProducto categoriaProducto);
	
	void eliminarCategoria(Long id);

}
