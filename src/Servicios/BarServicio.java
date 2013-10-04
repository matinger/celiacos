package Servicios;

import java.util.Date;
import java.util.List;

import Celiacos.Producto;
import Celiacos.Restaurante;
import Dao.FactoryDAO;
import Dao.ProductoDAO;
import Dao.RestauranteDAO;

public class BarServicio {
	RestauranteDAO dao = FactoryDAO.getRestauranteDAO();
	
	public List<Restaurante> getListaBares() {
		List<Restaurante> restaurantes = dao.listar();
		return restaurantes;
	}
	
	public boolean eliminar(int id){
		System.out.println("El id a eliminar es: " + id);
		dao.eliminarPorId(id);
		return true;
	}
	
	public boolean modificar(Restaurante b){
		dao.modificar(b);
		return true;
	}
	
	public boolean crearBar(String nombre, String telefono, String direccion,
	String provincia, String ciudad) {
		
		Restaurante b = new Restaurante( nombre,telefono,direccion,provincia,ciudad);
		//Guarda los bares
		
		dao.guardar(b);
		
		return false;
	}
}
