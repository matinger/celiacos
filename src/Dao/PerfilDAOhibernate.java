package Dao;

import java.util.List;

import javax.persistence.Query;

import Celiacos.Perfil;
import Celiacos.PerfilAdministradorUnidad;

public class PerfilDAOhibernate extends GenericDAOhibernate<Perfil> implements PerfilDAO{

	public PerfilDAOhibernate() {
		super(Perfil.class);
		// TODO Auto-generated constructor stub
	}

	@Transactional(readOnly=false) 
	public List<PerfilAdministradorUnidad> getPerfilesAdmin() {
			String sql = "FROM PerfilAdministradorUnidad";
			Query query = entityManager.createQuery(sql);	
			return query.getResultList();
	}

}
