package Servicios;

import java.util.List;

import Celiacos.Pago;
import Celiacos.Perfil;
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
	public List<Pago> getPagos(int id){
		PagoDAO dao=FactoryDAO.getPagoDAO();
		//List<Pago> pagos= dao.getPagosFromPerfil(id);
		List<Pago> pagos= dao.listar();
		return pagos;
	}
}

