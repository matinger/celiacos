package Servicios;

import java.util.Date;
import java.util.List;

import Celiacos.Notificacion;
import Celiacos.Perfil;
import Celiacos.PerfilSocio;
import Celiacos.Producto;
import Dao.FactoryDAO;
import Dao.NotificacionDAO;
import Dao.ProductoDAO;


public class NotificacionServicio {
	NotificacionDAO dao = FactoryDAO.getNotificacionDAO();	
	
	public List<Notificacion> getNotificaciones(PerfilSocio p){
		
		return p.getNotificaciones();
	}
	
public boolean crearNotificacion(float monto, Date fecha, String medio, String numeroidentificatorio, PerfilSocio p) {
		
		Notificacion n = new Notificacion(monto,fecha,medio,numeroidentificatorio,false);
		n.setSocio(p);
		dao.guardar(n);
		return false;
	}
}
	