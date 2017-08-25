package ar.edu.unlam.tallerweb1.modelo;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;


import ar.edu.unlam.tallerweb1.SpringTest;

public class UsuarioTest extends SpringTest{

	@Test
	@Transactional
	@Rollback(true)
	public void testPersona() {
		
		Usuario miUsuario = new Usuario();
		
		miUsuario.setEmail("aaa@a.w");
		miUsuario.setPassword("abcd1234");
		miUsuario.setRol("usuario");
		
		getSession().save(miUsuario);
		
		assertThat(getSession().get(Usuario.class, miUsuario.getId())).isNotNull();
		
	}


	
}
