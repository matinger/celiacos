package Dao;

import java.util.List;

import Celiacos.Perfil;
import Celiacos.PerfilAdministradorUnidad;

public interface PerfilDAO extends GenericDAO<Perfil>{

	public List<PerfilAdministradorUnidad> getPerfilesAdmin();
}
