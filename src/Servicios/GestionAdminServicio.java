package Servicios;

import java.util.Date;
import java.util.List;

import Celiacos.Perfil;
import Celiacos.PerfilAdministrador;
import Celiacos.PerfilAdministradorUnidad;
import Celiacos.PerfilSocio;
import Celiacos.TipoUnidad;
import Celiacos.Usuario;
import Dao.FactoryDAO;
import Dao.PerfilDAO;
import Dao.PerfilSocioDAO;
import Dao.TipoUnidadDAO;
import Dao.UsuarioDAO;

public class GestionAdminServicio {
	PerfilDAO dao = FactoryDAO.getPerfilDAO();
	
	public List<PerfilAdministradorUnidad> getListaAdmin() {				
		List<PerfilAdministradorUnidad> socios = dao.getPerfilesAdmin();
		return socios;
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
	
	public boolean crearAdmin(String usuario, String password,  String nombre, String apellido, int unidad) {
		
		Usuario u = new Usuario(usuario, password, nombre, apellido);	
		//Guarda los usuarios
		UsuarioDAO usuariodao = FactoryDAO.getUsuarioDAO();
		usuariodao.guardar(u);

		PerfilAdministradorUnidad pu = new PerfilAdministradorUnidad();
		
		TipoUnidadDAO unidao = FactoryDAO.getTipoUnidadDAO();
		TipoUnidad unidadaguardar = unidao.encontrar(unidad);
		
		pu.setUnidad(unidadaguardar);
		
		u.addPerfil(pu);
		unidadaguardar.addPerfil(pu);
		
		PerfilDAO perfildao = FactoryDAO.getPerfilDAO();
		perfildao.guardar(pu);
		
		return false;
	}
}
