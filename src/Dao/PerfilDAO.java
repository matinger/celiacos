package Dao;

import java.util.List;

import Celiacos.Perfil;
import Celiacos.PerfilAdministradorUnidad;
import Celiacos.PerfilOperadorCentral;

public interface PerfilDAO extends GenericDAO<Perfil>{

	public List<PerfilAdministradorUnidad> getPerfilesAdmin();

	public List<PerfilOperadorCentral> getPerfilesOperadores();
}
