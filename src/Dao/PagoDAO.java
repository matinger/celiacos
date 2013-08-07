package Dao;

import java.util.List;

import Celiacos.Pago;
import Celiacos.Perfil;

public interface PagoDAO extends GenericDAO<Pago>{
	public List<Pago> getPagosFromPerfil(int p);

}
