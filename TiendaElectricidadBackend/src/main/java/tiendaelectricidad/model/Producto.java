package tiendaelectricidad.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	
	
	private String nombre;
	
	private String descripcion;
	
	private double precio;
	
	private int cantidadEnStock;
	
	private String categoria;
	
	//Constructor por defecto
	
	public Producto() {
		
	}

	//Constructor con parámetros
	
	public Producto(String nombre, String descripcion, double precio, int cantidadEnStock,
			        String categoria) {
		            
		            this.nombre=nombre;
		            
		            this.descripcion=descripcion;
		            
		            this.precio=precio;
		            
		            this.cantidadEnStock=cantidadEnStock;
		            
		            this.categoria=categoria;	            
	}

	//Getter and setter
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidadEnStock() {
		return cantidadEnStock;
	}

	public void setCantidadEnStock(int cantidadEnStock) {
		this.cantidadEnStock = cantidadEnStock;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
		
}
