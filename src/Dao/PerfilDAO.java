package Dao;

import java.util.List;

import Celiacos.Notificacion;
import Celiacos.Perfil;
import Celiacos.PerfilAdministradorUnidad;
import Celiacos.PerfilOperadorCentral;
import Celiacos.PerfilOperadorUnidad;
import Celiacos.Unidad;

public interface PerfilDAO extends GenericDAO<Perfil>{

	public List<PerfilAdministradorUnidad> getPerfilesAdmin();

	public List<PerfilOperadorCentral> getPerfilesOperadoresCentrales();
	public List<PerfilOperadorUnidad> getPerfilesOperadoresUnidades();
	public List<Notificacion> getNotificaciones(Unidad unidad);
}
