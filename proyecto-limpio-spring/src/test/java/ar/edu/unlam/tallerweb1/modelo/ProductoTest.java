package ar.edu.unlam.tallerweb1.modelo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;

public class ProductoTest extends SpringTest {


	@Test
	@Transactional
	@Rollback(true)
	public void testProducto1() {
		
		Producto producto1 = new Producto();
		producto1.setPrecio(1000d);
		producto1.setTitulo("Tv");
		producto1.setDescripcion("32 pulgadas");
		producto1.setCantidad(8);
		
		Producto producto2 = new Producto();
		producto2.setPrecio(30d);
		producto2.setTitulo("Tv");
		producto2.setDescripcion("32 pulgadas");
		producto2.setCantidad(2);
		
		Producto producto3 = new Producto();
		producto3.setPrecio(70d);
		producto3.setTitulo("Tv");
		producto3.setDescripcion("24 pulgadas");
		producto3.setCantidad(5);
		
		getSession().save(producto1);
		getSession().save(producto2);
		getSession().save(producto3);

		Session s = getSession();
		
		List<Producto> listadoProductos;
		
		// --- 1. Todos los productos que salgan menos de 100 -- //
		
		//creo un criterio con una restriccion para traer todos los precios menores a 100
		listadoProductos = s.createCriteria(Producto.class)
							.add(Restrictions.lt("precio", 100d))  // el .lt es menores que
							.list();
			
		
		assertThat(listadoProductos.get(0).getPrecio().min(0d, 100d));  //que me haya traido los productos menores a 100
		assertThat(listadoProductos).hasSize(2); 						//verifico que haya traido la cantidad de productos menores a 100
	}
	
	

	@Test
	@Transactional
	@Rollback(true)
	public void testProducto2() {
		
		Producto producto1 = new Producto();
		producto1.setPrecio(1000d);
		producto1.setTitulo("Tv");
		producto1.setDescripcion("32 pulgadas");
		producto1.setCantidad(8);
		
		Producto producto2 = new Producto();
		producto2.setPrecio(30d);
		producto2.setTitulo("Tv");
		producto2.setDescripcion(null);
		producto2.setCantidad(2);
			
		getSession().save(producto1);
		getSession().save(producto2);


		Session s = getSession();
		
		List<Producto> listadoProductos;
		
		// --- 2. Todos los productos que tengan descripcion nulo -- //
		
		listadoProductos = s.createCriteria(Producto.class)
							.add(Restrictions.isNull("descripcion"))  // Solo me trae los que tengan descripcion Null
							.list();
			
		assertThat(listadoProductos).hasSize(1); 					
	
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testProducto3() {
		
		Producto producto1 = new Producto();
		producto1.setPrecio(200d);
		producto1.setTitulo("Tv");
		producto1.setDescripcion("32 pulgadas");
		producto1.setCantidad(8);
		
		Producto producto2 = new Producto();
		producto2.setPrecio(30d);
		producto2.setTitulo("Tv");
		producto2.setDescripcion(null);
		producto2.setCantidad(3);
		
		Producto producto3 = new Producto();
		producto3.setPrecio(350d);
		producto3.setTitulo("Tv");
		producto3.setDescripcion("tubo");
		producto3.setCantidad(14);
			
		getSession().save(producto1);
		getSession().save(producto2);
		getSession().save(producto3);

		Session s = getSession();
		
		List<Producto> listadoProductos;
		
		// -- 3. Todos los productos con precio mayor a 100 y cantidad menor o igual a 10 -- //
		
		listadoProductos = s.createCriteria(Producto.class)
							.add(Restrictions.gt("precio", 100d))  // .gt (greather than) producto con precios MAYORES QUE 100
							.add(Restrictions.le("cantidad", 10))  // .le (less than or equals) con cantidad MENOR O IGUAL que 10
							.list();
			
		assertThat(listadoProductos).hasSize(1); 					
	
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testProducto4() {
		
		Producto producto1 = new Producto();
		producto1.setPrecio(33d);
		producto1.setTitulo("Tv");
		producto1.setDescripcion("32 pulgadas");
		producto1.setCantidad(8);
		
		Producto producto2 = new Producto();
		producto2.setPrecio(44d);
		producto2.setTitulo("Tv");
		producto2.setDescripcion(null);
		producto2.setCantidad(3);
		
		Producto producto3 = new Producto();
		producto3.setPrecio(350d);
		producto3.setTitulo("Tv");
		producto3.setDescripcion("tubo");
		producto3.setCantidad(14);
			
		getSession().save(producto1);
		getSession().save(producto2);
		getSession().save(producto3);

		Session s = getSession();
		
		List<Producto> listadoProductos;
		
		// -- 4. Todos los productos con precio de 33 o 44 -- //
		
		listadoProductos = s.createCriteria(Producto.class)
				
							//restriccion para que el precio sea 33 O 44, usamos el .or y en cada campo ponemos una restriccion para un valor diferente
							.add(Restrictions.or(Restrictions.eq("precio", 33d), Restrictions.eq("precio", 44d)))
							.list();
			
		assertThat(listadoProductos).hasSize(2); 					
	
	}



	
}
