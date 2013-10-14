package Servicios;

import java.util.Date;

import Celiacos.Cuota;
import Celiacos.Pago;
import Celiacos.PerfilSocio;
import Dao.CuotaDAO;
import Dao.FactoryDAO;
import Dao.PagoDAO;

public class PagoServicio {

	private PagoDAO pagod = FactoryDAO.getPagoDAO();
	public void crearPago(Date fecha, double monto, PerfilSocio perfil,
			int seleccion) {
		CuotaDAO cuotad = FactoryDAO.getCuotaDAO();
		Pago pago = new Pago(fecha, monto);
		pago.setSocio(perfil);
		Cuota cu = cuotad.encontrar(seleccion);
		pago.setCuota(cu);
		
		pagod.guardar(pago);
	}

}
