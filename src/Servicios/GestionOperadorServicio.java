package Servicios;

import java.util.List;

import Celiacos.Perfil;
import Celiacos.PerfilAdministradorUnidad;
import Celiacos.PerfilOperadorCentral;
import Celiacos.PerfilOperadorUnidad;
import Celiacos.TipoUnidad;
import Celiacos.Usuario;
import Dao.FactoryDAO;
import Dao.PerfilDAO;
import Dao.TipoUnidadDAO;
import Dao.UsuarioDAO;

public class GestionOperadorServicio {

	PerfilDAO dao = FactoryDAO.getPerfilDAO();
	public List<PerfilOperadorCentral> getListaOperadoresCentrales() {				
		List<PerfilOperadorCentral> operadores = dao.getPerfilesOperadoresCentrales();
		return operadores;
	}
	
	public List<PerfilOperadorUnidad> getListaOperadoresUnidades() {				
		List<PerfilOperadorUnidad> operadores = dao.getPerfilesOperadoresUnidades();
		return operadores;
	}
	
	public boolean eliminar(int id){
		System.out.println("El id a eliminar es: " + id);
		dao.eliminarPorId(id);
		return true;
	}
	
	public boolean modificar(Perfil s){
		System.out.println("El id a editar es: " + s.getId());
		dao.modificar(s);
		
		return true;
	}
	
	public boolean crearOperador(String usuario, String password,  String nombre, String apellido, TipoUnidad unidad, Perfil pu) {
		
		Usuario u = new Usuario(usuario, password, nombre, apellido);	
		//Guarda los usuarios
		UsuarioDAO usuariodao = FactoryDAO.getUsuarioDAO();
		usuariodao.guardar(u);
				
		pu.setUnidad(unidad);
		
		u.addPerfil(pu);
		unidad.addPerfil(pu);
		
		PerfilDAO perfildao = FactoryDAO.getPerfilDAO();
		perfildao.guardar(pu);
		
		return false;
	}
}
