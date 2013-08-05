package Dao;

import java.util.List;

import Celiacos.Perfil;
import Celiacos.PerfilSocio;

public interface PerfilSocioDAO extends GenericDAO<PerfilSocio>{

	public List<PerfilSocio> getSociosFromPerfil(Perfil perfil);
}
