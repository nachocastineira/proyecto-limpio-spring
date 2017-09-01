package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UsuarioVendedorComprador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	private String nombre;
	private String apellido;
	private Integer edad;
	
	
	@OneToMany (mappedBy="usuarioVendedor", cascade=CascadeType.ALL)  //Un usuario publica MUCHOS productos
	private List<Producto> productosPublicados = new ArrayList<>();  //creo coleccion de productos que publico un usuario
	
	
	@OneToMany (mappedBy="usuarioComprador", cascade=CascadeType.ALL)  //un usuario compra MUCHOS productos
	private List<Oferta> productosComprados = new ArrayList<>();  //coleccion de productos comprados por un usuario


	
	 //GETTERS Y SETTERS
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public List<Producto> getProductosPublicados() {
		return productosPublicados;
	}

	public void setProductosPublicados(List<Producto> productosPublicados) {
		this.productosPublicados = productosPublicados;
	}

	public List<Oferta> getProductosComprados() {
		return productosComprados;
	}

	public void setProductosComprados(List<Oferta> productosComprados) {
		this.productosComprados = productosComprados;
	}
	
	
	

}
