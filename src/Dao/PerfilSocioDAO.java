package Dao;

import java.util.List;

import Celiacos.PerfilSocio;
import Celiacos.TipoUnidad;

public interface PerfilSocioDAO extends GenericDAO<PerfilSocio>{

	public List<PerfilSocio> getSociosFromUnidad(TipoUnidad unidad);
	public List<PerfilSocio> getSociosVirtualesUnidad();

}
