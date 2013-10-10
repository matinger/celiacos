package Dao;

import java.util.List;

import Celiacos.Notificacion;
import Celiacos.Perfil;
import Celiacos.PerfilSocio;

public interface NotificacionDAO extends GenericDAO<Notificacion>{
	public List<Notificacion> getNotificacionesfromPerfil(PerfilSocio perfil);
}
