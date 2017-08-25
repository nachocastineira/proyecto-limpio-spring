package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Departamento {
	
	@Id
	private Long id;
	private String nombre;

	

}
