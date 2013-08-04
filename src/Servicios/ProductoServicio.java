package Servicios;

import java.util.List;

import Celiacos.Producto;
import Dao.FactoryDAO;
import Dao.ProductoDAO;

public class ProductoServicio {
	public List<Producto> getListaProductos() {
		ProductoDAO dao = FactoryDAO.getProductoDAO();	
		
		List<Producto> productos = dao.listar();
		return productos;
	}
}
