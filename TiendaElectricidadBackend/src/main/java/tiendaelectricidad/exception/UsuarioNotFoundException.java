package tiendaelectricidad.exception;

public class UsuarioNotFoundException extends RuntimeException {

	public UsuarioNotFoundException(String mensaje) {
		
		super(mensaje);
	}
}
