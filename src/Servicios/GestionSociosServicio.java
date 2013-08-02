package Servicios;

import java.util.List;

import Celiacos.PerfilSocio;
import Dao.FactoryDAO;
import Dao.PerfilSocioDAO;


public class GestionSociosServicio {

	public List<PerfilSocio> getListaPersonas() {
		PerfilSocioDAO dao = FactoryDAO.getPerfilSocioDAO();	
		
		List<PerfilSocio> socios = dao.listar();
		return socios;
	}
}
