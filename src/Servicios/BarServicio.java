package Servicios;

import java.util.List;
import Celiacos.Restaurante;
import Dao.FactoryDAO;
import Dao.RestauranteDAO;

public class BarServicio {
	public List<Restaurante> getListaBares() {
		RestauranteDAO dao = FactoryDAO.getRestauranteDAO();	
		
		List<Restaurante> restaurantes = dao.listar();
		return restaurantes;
	}
}
