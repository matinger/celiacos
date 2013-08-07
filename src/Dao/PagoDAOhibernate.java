package Dao;

import java.util.List;

import javax.persistence.Query;

import Celiacos.Pago;
import Celiacos.Perfil;
import Celiacos.PerfilSocio;

public class PagoDAOhibernate extends GenericDAOhibernate<Pago> implements PagoDAO{

	public PagoDAOhibernate() {
		super(Pago.class);
		// TODO Auto-generated constructor stub
	}

}
