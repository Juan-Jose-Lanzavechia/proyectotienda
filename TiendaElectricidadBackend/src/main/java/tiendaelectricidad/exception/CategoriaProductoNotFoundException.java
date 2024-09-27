package tiendaelectricidad.exception;

public class CategoriaProductoNotFoundException extends RuntimeException{
	
	public CategoriaProductoNotFoundException(String mensaje) {
		
		super(mensaje);
	}

}
