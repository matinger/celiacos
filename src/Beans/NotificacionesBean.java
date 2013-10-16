package Beans;

import java.util.List;

import javax.faces.context.FacesContext;

import Celiacos.Notificacion;
import Celiacos.Perfil;
import Celiacos.PerfilSocio;
import Celiacos.TipoUnidad;
import Celiacos.Unidad;
import Servicios.GestionOperadorServicio;
import Servicios.NotificacionServicio;

public class NotificacionesBean {
	public List<Notificacion> getNotificaciones(){
		FacesContext context = FacesContext.getCurrentInstance();
		Perfil p = (Perfil) context.getExternalContext().getSessionMap().get("perfil");
		TipoUnidad u= (TipoUnidad) p.getUnidad();
		GestionOperadorServicio g = new GestionOperadorServicio();	
		 List<Notificacion> l=g.getListaNotificaciones(u);
		System.out.println("La cantidad es: "+ l.size() );
		return l;
		
	}
	
	public List<Notificacion> getNotificacionesPerfil(){
		NotificacionServicio n= new NotificacionServicio();
		FacesContext context = FacesContext.getCurrentInstance();
		PerfilSocio p = (PerfilSocio) context.getExternalContext().getSessionMap().get("perfil");
		return n.getNotificaciones(p);
	}
	
}
