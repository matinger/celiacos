package Beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import Celiacos.Cuota;
import Celiacos.Perfil;
import Dao.CuotaDAO;
import Dao.FactoryDAO;

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
		Date fecha = dfm.parse("2000-01-01");
		Cuota cu = new Cuota(importe, fecha);	
		FacesContext context = FacesContext.getCurrentInstance();
		Perfil p = (Perfil) context.getExternalContext().getSessionMap().get("perfil");
		cu.setUnidad(p.getUnidad());
		FactoryDAO.getCuotaDAO().guardar(cu);	
	}
	
	public boolean puedeCambiarCuota(){
		FacesContext context = FacesContext.getCurrentInstance();
		Perfil p = (Perfil) context.getExternalContext().getSessionMap().get("perfil");
		return p.getUnidad().getPuedeCambiarCuota();
	}
	
	public void cambiarCuota() throws ParseException{		
		FacesContext context = FacesContext.getCurrentInstance();
		Perfil p = (Perfil) context.getExternalContext().getSessionMap().get("perfil");
		//List<Cuota> l = p.getUnidad().getCuotas();
	
		CuotaDAO dao = FactoryDAO.getCuotaDAO();
		Cuota cu = dao.getLastCuotaFromPerfil(p);	
		cu.setImporte(importe);
		dao.modificar(cu);	
	}
	
}
