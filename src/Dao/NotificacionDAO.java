package Dao;

import java.util.List;

import Celiacos.Notificacion;
import Celiacos.Perfil;
import Celiacos.PerfilSocio;
import Celiacos.Unidad;

public interface NotificacionDAO extends GenericDAO<Notificacion>{
	public List<Notificacion> getNotificaciones(Unidad unidad);
}
