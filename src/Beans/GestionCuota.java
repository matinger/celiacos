package Beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import Celiacos.Cuota;
import Celiacos.Perfil;
import Celiacos.TipoUnidad;
import Dao.FactoryDAO;
import Dao.TipoUnidadDAO;

@ManagedBean
@ViewScoped
public class GestionCuota {

	private double importe;
	private Date fecha;
	
	
	public double getImporte() {
		
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	public void agregarCuota() throws ParseException{	
		
		DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendario = GregorianCalendar.getInstance();
		
		Date d = calendario.getTime();
		
		System.out.println(d);
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(formatoDeFecha.format(d));
		List<TipoUnidad> unidades = FactoryDAO.getTipoUnidadDAO().listar();
		for(TipoUnidad uni : unidades){
			importe = uni.getImporte();
			Cuota cu = new Cuota(importe, d);	
			cu.setUnidad(uni);
			FactoryDAO.getCuotaDAO().guardar(cu);	
		}
		
	}
	
	public boolean puedeCambiarCuota(){
		FacesContext context = FacesContext.getCurrentInstance();
		Perfil p = (Perfil) context.getExternalContext().getSessionMap().get("perfil");
		return p.getUnidad().getPuedeCambiarCuota();
	}
	
	public void cambiarCuotaUnidad() throws ParseException{		
		FacesContext context = FacesContext.getCurrentInstance();
		Perfil p = (Perfil) context.getExternalContext().getSessionMap().get("perfil");
		//List<Cuota> l = p.getUnidad().getCuotas();
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
