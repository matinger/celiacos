package Dao;

import java.util.List;

import javax.persistence.Query;

import Celiacos.Cuota;
import Celiacos.Perfil;
import Celiacos.PerfilSocio;
import Celiacos.TipoUnidad;

public class CuotaDAOhibernate extends GenericDAOhibernate<Cuota> implements CuotaDAO{

	public CuotaDAOhibernate() {
		super(Cuota.class);
		// TODO Auto-generated constructor stub
	}
	
	@Transactional(readOnly=true) 
	public Cuota getLastCuotaFromPerfil(Perfil perfil){
		String sql = "SELECT s FROM Cuota s join s.unidad where s.unidad = :unidad ORDER BY s.fecha desc";
		Query query = entityManager.createQuery(sql);
		query.setParameter("unidad", perfil.getUnidad());	
		Cuota cu = (Cuota) query.getResultList().get(0);
		return cu;
	}
	
	@Transactional(readOnly=true) 
	public List<Cuota> getCuotasFromSocio(PerfilSocio perfil){
		String sql = "SELECT s FROM Cuota s join s.unidad where s.unidad = :unidad and s.fecha >= :fecha ORDER BY s.fecha desc";
		Query query = entityManager.createQuery(sql);
		query.setParameter("unidad", perfil.getUnidad());
		query.setParameter("fecha", perfil.getFechaIngreso());
		return query.getResultList();
	}

}
