package Servicios;

import Celiacos.Usuario;
import Dao.FactoryDAO;
import Dao.UsuarioDAO;


public class UsuarioServicio {


	public Usuario validarUsuario(String usuario, String password) {
		UsuarioDAO dao=FactoryDAO.getUsuarioDAO();
		Usuario u = dao.getUser(usuario, password);
		return u;		
	}

	public boolean esValido(String usu) {
		UsuarioDAO dao=FactoryDAO.getUsuarioDAO();
		Usuario u = dao.getUser(usu);
		if(u == null){
			return true;
		}else
		{return false;}
	}
}
