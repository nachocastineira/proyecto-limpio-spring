package ar.edu.unlam.tallerweb1.modelo;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Libro {

	
	@Id
	private String nombre;
	private String titulo;
	
	@ManyToOne (fetch = FetchType.LAZY) //va a ir de muchos a uno del otro lado - un autor crea muchos libros
										// el .LAZY va a traer algunos registros, pero no toda la coleccion - Las otras las llama cuando yo lo use
										// el .EAGGER me trae todos los registros de una sola vez, puede desbordar la memoria
	@JoinColumn (name="idAutor") //columna con la cual se va a joinear
	private Autor autor;

	
	//constructor
	public Libro(){} //se deja vacio para que no se generen conflictos
	
	public Libro(String nombre, String titulo, Autor autor) {
		super();
		this.nombre = nombre;
		this.titulo = titulo;
		this.autor = autor;
	}


	//getters y setters
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
	
	
	
}
