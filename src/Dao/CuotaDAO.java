package Dao;

import java.util.List;

import Celiacos.Cuota;
import Celiacos.Perfil;
import Celiacos.PerfilSocio;
import Celiacos.TipoUnidad;

public interface CuotaDAO extends GenericDAO<Cuota>{
	public Cuota getLastCuotaFromPerfil(Perfil perfil);
	public List<Cuota> getCuotasFromSocio(PerfilSocio perfil);
}
