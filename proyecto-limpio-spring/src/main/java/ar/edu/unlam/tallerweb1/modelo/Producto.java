package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;
	
	private Double precio;
	private String descripcion;
	private String titulo;
	private Integer cantidad;
	
	
	@ManyToOne (fetch = FetchType.LAZY) //MUCHOS productos publicados por UN usuario
	@JoinColumn (name="idUsuario") //columna con la cual se va a joinear
	private UsuarioVendedorComprador usuarioVendedor;
	
	
	
	@ManyToOne (fetch = FetchType.LAZY) //MUCHOS productos pertenecen a UNA categoria
	@JoinColumn (name="categoriaPerteneciente") //columna con la cual se va a joinear
	private Categoria categoriaPerteneciente;
	
	@OneToMany (mappedBy="productoOfertado", cascade=CascadeType.ALL)  //UNA oferta pertenece a UN producto
	private List<Oferta> ofertasDeProducto = new ArrayList<>();  //coleccion de ofertas sobre un producto
	
	
	
	
	//getters y setters
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public UsuarioVendedorComprador getUsuarioVendedor() {
		return usuarioVendedor;
	}
	public void setUsuarioVendedor(UsuarioVendedorComprador usuarioVendedor) {
		this.usuarioVendedor = usuarioVendedor;
	}
	public Categoria getCategoriaPerteneciente() {
		return categoriaPerteneciente;
	}
	public void setCategoriaPerteneciente(Categoria categoriaPerteneciente) {
		this.categoriaPerteneciente = categoriaPerteneciente;
	}
	
	
	
	
	
	

}
