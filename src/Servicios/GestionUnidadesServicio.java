package Servicios;

import java.util.List;

import Celiacos.TipoUnidad;
import Celiacos.Unidad;
import Celiacos.UnidadCentral;
import Dao.FactoryDAO;
import Dao.TipoUnidadDAO;

public class GestionUnidadesServicio {
	
	TipoUnidadDAO dao = FactoryDAO.getTipoUnidadDAO();
	
	public List<TipoUnidad> getListaUnidades() {
		
		List<TipoUnidad> socios = dao.listar();
		return socios;
	}
	public boolean eliminar(int id){
		dao.eliminarPorId(id);
		return true;
	}
	
	public boolean modificar(TipoUnidad u){
		dao.modificar(u);
		return true;
	}
	
	public void crearUnidad(String nombre, String direccion, String telefono, String email, String tipo){
	
		Unidad u = new Unidad(nombre, direccion, telefono, email, tipo);
		
		TipoUnidadDAO tipodao = FactoryDAO.getTipoUnidadDAO();
		tipodao.guardar(u);
	}
	
}
