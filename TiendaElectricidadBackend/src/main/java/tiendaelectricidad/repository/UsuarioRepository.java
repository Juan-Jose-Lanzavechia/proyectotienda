package tiendaelectricidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tiendaelectricidad.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
