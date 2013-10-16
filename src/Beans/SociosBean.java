package Beans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Celiacos.Notificacion;
import Celiacos.Pago;
import Celiacos.Perfil;
import Celiacos.PerfilSocio;
import Celiacos.Producto;
import Celiacos.Restaurante;
import Servicios.BarServicio;
import Servicios.NotificacionServicio;
import Servicios.ProductoServicio;

@ManagedBean
@SessionScoped
public class SociosBean {
	private Date fecha;
	private float monto;
	private String medio;
	private String numeroidentificatorio;
	
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fechapago) {
		this.fecha = fechapago;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public String getMedio() {
		return medio;
	}
	public void setMedio(String medio) {
		this.medio = medio;
	}
	public String getNumeroidentificatorio() {
		return numeroidentificatorio;
	}
	public void setNumeroidentificatorio(String numeroidentificatorio) {
		this.numeroidentificatorio = numeroidentificatorio;
	}
		
		public List<Pago> getPagos(){
			FacesContext context = FacesContext.getCurrentInstance();
			PerfilSocio p = (PerfilSocio) context.getExternalContext().getSessionMap().get("perfil");
			return p.getPagos();
		}
		
		public boolean isVirtual(){
			FacesContext context = FacesContext.getCurrentInstance();
			PerfilSocio p = (PerfilSocio) context.getExternalContext().getSessionMap().get("perfil");
			return p.isSocioVirtual();
		}
		
		public boolean getAcceso(){
			FacesContext context = FacesContext.getCurrentInstance();
			PerfilSocio p = (PerfilSocio) context.getExternalContext().getSessionMap().get("perfil");
			return p.isBeneficio() ? p.isBeneficio() : p.isActivada();
		}
		
		public void enviarNotificacion(){
			NotificacionServicio noti = new NotificacionServicio();
			FacesContext context = FacesContext.getCurrentInstance();
			PerfilSocio p = (PerfilSocio) context.getExternalContext().getSessionMap().get("perfil");
			noti.crearNotificacion(monto, fecha, medio, numeroidentificatorio,p);
		}
		public String getCuentaActivada(){
			FacesContext context = FacesContext.getCurrentInstance();
			PerfilSocio p = (PerfilSocio) context.getExternalContext().getSessionMap().get("perfil");
			return (p.isActivada()) ? "Activada" : "Desactivada";
		}
		
}
