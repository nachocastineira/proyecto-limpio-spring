package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Oferta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOferta;
	
	private Integer cantidad;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name="idProducto")
	private Producto productoOfertado;
	
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name="idUsuario")
	private UsuarioVendedorComprador usuarioComprador;


	
	//GETTERS Y SETTERS
	public Long getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(Long idOferta) {
		this.idOferta = idOferta;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProductoOfertado() {
		return productoOfertado;
	}

	public void setProductoOfertado(Producto productoOfertado) {
		this.productoOfertado = productoOfertado;
	}

	public UsuarioVendedorComprador getUsuarioComprador() {
		return usuarioComprador;
	}

	public void setUsuarioComprador(UsuarioVendedorComprador usuarioComprador) {
		this.usuarioComprador = usuarioComprador;
	}


	
	


}
