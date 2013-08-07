package Servicios;

import java.util.List;

import Celiacos.Pago;
import Celiacos.Perfil;
import Celiacos.PerfilSocio;
import Celiacos.Producto;
import Celiacos.Restaurante;
import Dao.FactoryDAO;
import Dao.PagoDAO;
import Dao.ProductoDAO;
import Dao.RestauranteDAO;

public class SocioServicio {
	public List<Restaurante> getListaBares() {
		RestauranteDAO dao = FactoryDAO.getRestauranteDAO();	
		
		List<Restaurante> restaurantes = dao.listar();
		return restaurantes;
	}
	public List<Producto> getListaProductos() {
		ProductoDAO dao = FactoryDAO.getProductoDAO();	
		
		List<Producto> productos = dao.listar();
		return productos;
	}

}

