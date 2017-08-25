package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Gerente {

	@Id
	private Long id;
	private String nombre;
	
	@OneToOne
	private Departamento departamento;
}
