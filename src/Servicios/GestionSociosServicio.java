package Servicios;

import java.util.Date;
import java.util.List;

import Celiacos.Perfil;
import Celiacos.PerfilSocio;
import Celiacos.TipoUnidad;
import Celiacos.Usuario;
import Dao.FactoryDAO;
import Dao.PerfilDAO;
import Dao.PerfilSocioDAO;
import Dao.UsuarioDAO;


public class GestionSociosServicio {
	PerfilSocioDAO dao = FactoryDAO.getPerfilSocioDAO();
	public List<PerfilSocio> getListaPersonas(Perfil perfil) {
					
		List<PerfilSocio> socios = dao.getSociosFromPerfil(perfil);
		return socios;
	}
	
	public boolean eliminar(PerfilSocio s){
		dao.modificar(s);
		dao.eliminar(s);
		return true;
	}
	
	public boolean crearSocio(int nroSocio, String usuario, String password,  String nombre, String apellido,int dni, String domicilio, String ocupacion, Date fechaNacimiento, Date fechaIngreso,
			Date fechaDiagnostico, String presentadoPor, String telefono,
			String email, boolean beneficio, boolean socioVirtual, TipoUnidad unidad) {
		
		Usuario u = new Usuario(usuario, password, nombre, apellido);	
		//Guarda los usuarios
		UsuarioDAO usuariodao = FactoryDAO.getUsuarioDAO();
		usuariodao.guardar(u);

		PerfilSocio perfilsocio = new PerfilSocio(nroSocio , dni , domicilio, ocupacion, fechaNacimiento, fechaIngreso ,fechaDiagnostico, presentadoPor, telefono, email ,beneficio);
		perfilsocio.setSocioVirtual(socioVirtual);
		
		u.addPerfil(perfilsocio);
		unidad.addPerfil(perfilsocio);
		
		PerfilDAO perfildao = FactoryDAO.getPerfilDAO();
		perfildao.guardar(perfilsocio);
		
		return false;
	}
}
