package Dao;

import java.util.List;

import Celiacos.Cuota;
import Celiacos.Pago;
import Celiacos.PerfilSocio;

public interface PagoDAO extends GenericDAO<Pago>{
	public List<Pago> getPagosFromCuotaAndSocio(PerfilSocio perfil, Cuota cu);
}
