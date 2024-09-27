package tiendaelectricidad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tiendaelectricidad.exception.CategoriaProductoNotFoundException;
import tiendaelectricidad.model.CategoriaProducto;
import tiendaelectricidad.repository.CategoriaProductoRepository;
import tiendaelectricidad.service.CategoriaProductoService;

public class CategoriaProductoServiceImpl implements CategoriaProductoService{

	@Autowired
	private CategoriaProductoRepository categoriaProductoRepository;
	
	@Override
	public List<CategoriaProducto> obtenerTodasLasCategorias() {
		
		return categoriaProductoRepository.findAll();
	}

	@Override
	public CategoriaProducto obtenerCategoriaPorId(Long id) {
		
		return categoriaProductoRepository.findById(id).orElseThrow(
				()->new CategoriaProductoNotFoundException("Categoría con id " + id + " no encontrada"));
	}

	@Override
	public CategoriaProducto guardarCategoria(CategoriaProducto categoria) {
		
		return categoriaProductoRepository.save(categoria);
	}

	@Override
	public CategoriaProducto actualizarCategoria(Long id, CategoriaProducto categoriaProducto) {
		
		CategoriaProducto categoriaExistente= obtenerCategoriaPorId(id);
		
		categoriaExistente.setNombre(categoriaProducto.getNombre());
		
		categoriaExistente.setDescripcion(categoriaProducto.getDescripcion());
		
		return categoriaProductoRepository.save(categoriaExistente);
	}
	
	@Override
	public void eliminarCategoria(Long id) {
		
		CategoriaProducto categoriaExistente= obtenerCategoriaPorId(id);
		
		categoriaProductoRepository.delete(categoriaExistente);
		
	}	

}
