package Dao;

import java.util.List;

import javax.persistence.Query;

import Celiacos.PerfilSocio;
import Celiacos.TipoUnidad;

public class PerfilSocioDAOhibernate extends GenericDAOhibernate<PerfilSocio> implements PerfilSocioDAO{

	public PerfilSocioDAOhibernate() {
		super(PerfilSocio.class);
		// TODO Auto-generated constructor stub
	}
	@Transactional(readOnly=true) 
	public List<PerfilSocio> getSociosFromUnidad(TipoUnidad unidad){
		String sql = "SELECT s FROM PerfilSocio s join s.unidad where s.unidad = :unidad";
		Query query = entityManager.createQuery(sql);
		query.setParameter("unidad",unidad);	
		return query.getResultList();
	}
	@Transactional(readOnly=true) 
	public List<PerfilSocio> getSociosVirtualesUnidad() {
		String sql = "SELECT s FROM PerfilSocio s where s.socioVirtual = 1";
		Query query = entityManager.createQuery(sql);
		return query.getResultList();
	}
	

}
