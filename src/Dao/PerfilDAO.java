package Dao;

import java.util.List;

import Celiacos.Perfil;
import Celiacos.PerfilAdministradorUnidad;
import Celiacos.PerfilOperadorCentral;
import Celiacos.PerfilOperadorUnidad;

public interface PerfilDAO extends GenericDAO<Perfil>{

	public List<PerfilAdministradorUnidad> getPerfilesAdmin();

	public List<PerfilOperadorCentral> getPerfilesOperadoresCentrales();
	public List<PerfilOperadorUnidad> getPerfilesOperadoresUnidades();

}
