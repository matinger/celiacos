package Dao;

import java.util.List;

import javax.persistence.Query;

import Celiacos.Cuota;
import Celiacos.Pago;
import Celiacos.Perfil;
import Celiacos.PerfilSocio;

public class PagoDAOhibernate extends GenericDAOhibernate<Pago> implements PagoDAO{

	public PagoDAOhibernate() {
		super(Pago.class);
		// TODO Auto-generated constructor stub
	}
	
	@Transactional(readOnly=true) 
	public List<Pago> getPagosFromCuotaAndSocio(PerfilSocio perfil, Cuota cu){
		String sql = "SELECT p FROM Pago p join p.socio join p.cuota where p.socio = :socio and p.cuota = :cuota and p.cuota.fecha >= :fecha";
		Query query = entityManager.createQuery(sql);
		query.setParameter("socio", perfil);
		query.setParameter("cuota", cu);
		query.setParameter("fecha", perfil.getFechaIngreso());
		return query.getResultList();
	}

}
