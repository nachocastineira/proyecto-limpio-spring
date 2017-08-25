package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Autor {

	
	@Id
	private Long idAutor;
	private String nombre;
	private String nacionalidad;
	
	@OneToMany (mappedBy="autor", cascade=CascadeType.ALL) //como va a estar asociada una tabla con otra
															//con el ALL se guarda en los dos lados en el autor como en el libro
															// el "autor" con la tabla que va a estar asociada
	private List<Libro> misLibros = new ArrayList<Libro>();  //creo una coleccion de libros

	
	//constructor
	public Autor(){}
	
	public Autor(Long idAutor, String nombre, String nacionalidad) {
		super();
		this.idAutor = idAutor;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}

	
	//getters y setters
	public Long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public List<Libro> getMisLibros() {
		return misLibros;
	}

	public void setMisLibros(List<Libro> misLibros) {
		this.misLibros = misLibros;
	}
	
	
	
	
}


	