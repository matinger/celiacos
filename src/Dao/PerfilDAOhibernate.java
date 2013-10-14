package Dao;

import java.util.List;

import javax.persistence.Query;

import Celiacos.Notificacion;
import Celiacos.Perfil;
import Celiacos.PerfilAdministradorUnidad;
import Celiacos.PerfilOperadorCentral;
import Celiacos.PerfilOperadorUnidad;
import Celiacos.Unidad;

public class PerfilDAOhibernate extends GenericDAOhibernate<Perfil> implements PerfilDAO{

	public PerfilDAOhibernate() {
		super(Perfil.class);
		// TODO Auto-generated constructor stub
	}

	@Transactional(readOnly=true) 
	public List<PerfilAdministradorUnidad> getPerfilesAdmin() {
			String sql = "FROM PerfilAdministradorUnidad";
			Query query = entityManager.createQuery(sql);	
			return query.getResultList();
	}

	@Transactional(readOnly=true) 
	public List<PerfilOperadorCentral> getPerfilesOperadoresCentrales() {
		String sql = "FROM PerfilOperadorCentral";
		Query query = entityManager.createQuery(sql);	
		return query.getResultList();
	}

	@Transactional(readOnly=true) 
	public List<PerfilOperadorUnidad> getPerfilesOperadoresUnidades() {
		String sql = "FROM PerfilOperadorUnidad";
		Query query = entityManager.createQuery(sql);	
		return query.getResultList();
	}



}
