package Dao;

import java.util.List;

import javax.persistence.Query;

import Celiacos.Pago;
import Celiacos.Perfil;

public class PagoDAOhibernate extends GenericDAOhibernate<Pago> implements PagoDAO{

	public PagoDAOhibernate() {
		super(Pago.class);
		// TODO Auto-generated constructor stub
	}

	@Transactional(readOnly=false) 
	public List<Pago> getPagosFromPerfil(int p) {
		System.out.println("EL ID DEL PERFIL ES: " + p);
		String sql = "SELECT * FROM Pago  where id_perfil = :id";
		Query query = entityManager.createQuery(sql);
		query.setParameter("id", p);	
		return query.getResultList();
	}

}
