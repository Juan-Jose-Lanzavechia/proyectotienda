package tiendaelectricidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tiendaelectricidad.model.Producto;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
