package Dao;

import java.util.List;

import javax.persistence.Query;

import Celiacos.Notificacion;
import Celiacos.Perfil;
import Celiacos.PerfilSocio;

public class NotificacionDAOhibernate extends GenericDAOhibernate<Notificacion> implements NotificacionDAO{

	public NotificacionDAOhibernate() {
		super(Notificacion.class);
		// TODO Auto-generated constructor stub
	}

}
