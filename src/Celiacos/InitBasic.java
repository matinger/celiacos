package Celiacos;

import java.text.ParseException;

import Dao.FactoryDAO;
import Dao.PerfilDAO;
import Dao.TipoUnidadDAO;
import Dao.UsuarioDAO;

public class InitBasic {
	public static void main(String[] args) throws ParseException {
		UnidadCentral unidad = new UnidadCentral("Unidad Cemtral ","50 y 1","4222222","central@email.com");
		
		unidad.setImporte(100);
		
		//Guarda las unidades
		TipoUnidadDAO tipodao = FactoryDAO.getTipoUnidadDAO();
		tipodao.guardar(unidad);
		
		//Crea usuarios		
		Usuario us = new Usuario("admincentral", "admincentral");
		us.setNombre("Jose");us.setApellido("Hernandez");
		
		//Guarda los usuarios
		UsuarioDAO usuariodao = FactoryDAO.getUsuarioDAO();
		usuariodao.guardar(us);
		
		//Crea perfiles
		PerfilAdministradorCentral perfiladministradorcentral = new PerfilAdministradorCentral();
		
		//Asocia perfiles a unidades
		unidad.addPerfil(perfiladministradorcentral);
		us.addPerfil(perfiladministradorcentral);
		
		//Guarda los perfiles
		PerfilDAO perfildao = FactoryDAO.getPerfilDAO();
		perfildao.guardar(perfiladministradorcentral);
		
	}
}
