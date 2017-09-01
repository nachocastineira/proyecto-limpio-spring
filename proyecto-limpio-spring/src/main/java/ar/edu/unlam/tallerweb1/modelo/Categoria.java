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
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	
	private String nombreCategoria;
	
	
	
	@OneToMany (mappedBy="categoriaPerteneciente", cascade=CascadeType.ALL)  //UNA categoria tiene MUCHOS productos
	private List<Producto> listadoDeProductoEnCategoria = new ArrayList<>();  //creo coleccion de productos de una categoria


		//GETTERS Y SETTERS
	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public List<Producto> getListadoDeProductoEnCategoria() {
		return listadoDeProductoEnCategoria;
	}

	public void setListadoDeProductoEnCategoria(List<Producto> listadoDeProductoEnCategoria) {
		this.listadoDeProductoEnCategoria = listadoDeProductoEnCategoria;
	}
	
	
	

}
