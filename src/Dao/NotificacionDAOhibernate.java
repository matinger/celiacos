package Dao;

import java.util.List;

import javax.persistence.Query;

import Celiacos.Notificacion;
import Celiacos.Perfil;
import Celiacos.PerfilSocio;
import Celiacos.TipoUnidad;
import Celiacos.Unidad;

public class NotificacionDAOhibernate extends GenericDAOhibernate<Notificacion> implements NotificacionDAO{

	public NotificacionDAOhibernate() {
		super(Notificacion.class);
		// TODO Auto-generated constructor stub
	}
	@Transactional(readOnly=true) 
	public List<Notificacion> getNotificaciones(TipoUnidad unidad) {
		String sql = "SELECT n FROM Notificacion n join n.socio where n.socio.unidad = :unidad";
		Query query = entityManager.createQuery(sql);
		query.setParameter("unidad",unidad);	
		return query.getResultList();
	}
}
