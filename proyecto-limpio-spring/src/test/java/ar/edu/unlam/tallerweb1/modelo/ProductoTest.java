package ar.edu.unlam.tallerweb1.modelo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;

public class ProductoTest extends SpringTest {


	@SuppressWarnings("unchecked") //si no pongo esto me tira un warning en la consulta
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
	
	

	@SuppressWarnings("unchecked")
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
	
	@SuppressWarnings("unchecked")
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
	

	@SuppressWarnings("unchecked")
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
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback(true)
	public void testProducto5() {
		
		Producto producto1 = new Producto();
		producto1.setPrecio(100d);
		producto1.setTitulo("Tv");
		producto1.setDescripcion("32 pulgadas");
		producto1.setCantidad(8);
		
		Producto producto2 = new Producto();
		producto2.setPrecio(200d);
		producto2.setTitulo("Tv");
		producto2.setDescripcion(null);
		producto2.setCantidad(3);
		
		Producto producto3 = new Producto();
		producto3.setPrecio(300d);
		producto3.setTitulo("Tv");
		producto3.setDescripcion("tubo");
		producto3.setCantidad(14);
			
		getSession().save(producto1);
		getSession().save(producto2);
		getSession().save(producto3);

		Session s = getSession();
		
		List<Producto> listadoProductos;
		
		
		// -- 5. Todos los productos ordenados por precio descendente -- //
		
		listadoProductos = s.createCriteria(Producto.class)
							.addOrder(Order.desc("precio")) //los precios se van a ordernar de forma descendente
							.list();
			

		assertThat(listadoProductos.get(0).getPrecio()).isEqualTo(300d);  //el que quedo en el primer lugar es el producto3 con precio 300
		assertThat(listadoProductos).hasSize(3);  //que se hayan traido los 3 productos 	

	}
	

	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback(true)
	public void testProducto6() {
		
		//creo un objeto producto
		Producto producto1 = new Producto();
		producto1.setPrecio(1000d);
		producto1.setTitulo("Tv");
		producto1.setDescripcion("32 pulgadas");
		producto1.setCantidad(8);
		
		//creo otro objeto producto
		Producto producto2 = new Producto();
		producto2.setPrecio(500d);
		producto2.setTitulo("Tv");
		producto2.setDescripcion("25 pulgadas");
		producto2.setCantidad(2);
		
		//creo un objeto usuario
		UsuarioVendedorComprador usuario1 = new UsuarioVendedorComprador();
		usuario1.setNombre("Juan");
		usuario1.setApellido("Perez");
		usuario1.setEdad(30);
		
		//creo otro objeto usuario
		UsuarioVendedorComprador usuario2 = new UsuarioVendedorComprador();
		usuario2.setNombre("Pedro");
		usuario2.setApellido("Rodriguez");
		usuario2.setEdad(40);
		
		//creo un objeto categoria
		Categoria categoria1 = new Categoria();
		categoria1.setNombreCategoria("electronica");
		
		//creo un objeto oferta
		Oferta oferta1 = new Oferta();
		oferta1.setCantidad(1);
		//creo un objeto oferta
		Oferta oferta2 = new Oferta();
		oferta2.setCantidad(1);

		producto1.setUsuarioVendedor(usuario1);  			//al producto1 le seteo como vendedor al usuario1
		producto2.setUsuarioVendedor(usuario1);  			//al producto2 le seteo como vendedor al usuario1
		producto1.setCategoriaPerteneciente(categoria1); 	//al producto1 le seteo como categoriaPerteneciente la categoria1
		producto2.setCategoriaPerteneciente(categoria1); 	//al producto2 le seteo como categoriaPerteneciente la categoria1
		oferta1.setProductoOfertado(producto1);				//al objeto oferta1 le seteo como productoOfertado el producto1
		oferta2.setProductoOfertado(producto2);				//al objeto oferta1 le seteo como productoOfertado el producto1
		
		oferta2.setUsuarioComprador(usuario2);				//la oferta2 es comprada por el usuario2

		getSession().save(producto1);
		getSession().save(producto2);
		getSession().save(usuario1);
		getSession().save(usuario2);
		getSession().save(categoria1);
		getSession().save(oferta1);
		getSession().save(oferta2);

		Session s = getSession();
		
	
		// --- 6. Todos los productos vendidos por un usuario x -- //
			
		//-- Me trae todos los productos publicados por el usuario Juan -- 
		
		List<Producto> lista;
		
		lista = s.createCriteria(Producto.class)
				.createAlias("usuarioVendedor", "vendedor")  //creo un alias para poder traer el nombre del vendedor
				.add(Restrictions.eq("vendedor.nombre", "Juan"))	
				.list();
		
		assertThat(lista).hasSize(2); 

	}




	
}
