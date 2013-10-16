package Beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import Beans.GestionPagoBean.Deuda;
import Celiacos.Cuota;
import Celiacos.Pago;
import Celiacos.Perfil;
import Celiacos.PerfilSocio;
import Celiacos.TipoUnidad;
import Dao.FactoryDAO;
import Dao.PagoDAO;
import Dao.TipoUnidadDAO;

@ManagedBean
@ViewScoped
public class GestionCuotaBean {

	private double importe;
	private Date fecha;
	
	
	public double getImporte() {
		FacesContext context = FacesContext.getCurrentInstance();
		Perfil p = (Perfil) context.getExternalContext().getSessionMap().get("perfil");
		return p.getUnidad().getImporte();
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	public void agregarCuota() throws ParseException{	
		
		DateFormat dfm = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendario = GregorianCalendar.getInstance();
		
		Date d = calendario.getTime();
		
		List<TipoUnidad> unidades = FactoryDAO.getTipoUnidadDAO().listar();
		for(TipoUnidad uni : unidades){
			importe = uni.getImporte();
			Cuota cu = new Cuota(importe, d);	
			cu.setUnidad(uni);
			FactoryDAO.getCuotaDAO().guardar(cu);	
			List<PerfilSocio> listasocio = FactoryDAO.getPerfilSocioDAO().getSociosFromUnidad(uni);
			for(PerfilSocio socio : listasocio){
				List<Cuota> listacuota = cuotasQueDebeSocio(socio);
				if (listacuota.size() > 1){
					socio.setActivada(false);
				}
			}
		}
		
	}
	
	private List<Cuota> cuotasQueDebeSocio(PerfilSocio socio) {
		List<Cuota> cuotas = FactoryDAO.getCuotaDAO().getCuotasFromSocio(socio);
		List<Cuota> fin = new ArrayList<Cuota>();
		PagoDAO pDao = FactoryDAO.getPagoDAO();
		for (Cuota cu : cuotas){
			double total = 0;
			List<Pago> pagos= pDao.getPagosFromCuotaAndSocio(socio, cu);
			for (Pago p : pagos){
				total += p.getMonto();
			}	
			if (cu.getImporte() > total){
				fin.add(cu);
			}
		}
		return fin;
		
	}
	public boolean puedeCambiarCuota(){
		FacesContext context = FacesContext.getCurrentInstance();
		Perfil p = (Perfil) context.getExternalContext().getSessionMap().get("perfil");
		return p.getUnidad().getPuedeCambiarCuota();
	}
	
	public void cambiarCuotaUnidad() throws ParseException{		
		FacesContext context = FacesContext.getCurrentInstance();
		Perfil p = (Perfil) context.getExternalContext().getSessionMap().get("perfil");
		TipoUnidad uni = p.getUnidad();
		uni.setImporte(importe);
		TipoUnidadDAO tipo = FactoryDAO.getTipoUnidadDAO();
		tipo.modificar(uni);
	}
	
	public void cambiarCuotaCentral() throws ParseException{		
		List<TipoUnidad> unidades = FactoryDAO.getTipoUnidadDAO().listar();
		cambiarCuotaUnidad();
		for(TipoUnidad uni : unidades){
			if(!uni.getPuedeCambiarCuota()){
				uni.setImporte(importe);
				FactoryDAO.getTipoUnidadDAO().modificar(uni);	
			}
		}
	}
	
}
