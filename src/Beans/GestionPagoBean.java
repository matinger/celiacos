package Beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import Servicios.PagoServicio;

import Celiacos.Cuota;
import Celiacos.Pago;
import Celiacos.PerfilSocio;
import Dao.FactoryDAO;
import Dao.PagoDAO;

@ManagedBean
@ViewScoped
public class GestionPagoBean {
	
	public class Deuda {
		private Date fecha;
		private double monto;
		
		public Deuda(Date f, Double m){
			fecha = f;
			monto = m;
		}
		public Date getFecha(){
			return fecha;
		}
		public Double getMonto(){
			return monto;
		}
	}
	
	private Date fecha;
	private double monto;
	
	private Map<String, Integer> mapValue;
	private int seleccion;
	private PerfilSocio perfil;
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public double getMonto() {
		return monto;
	}
	
	public void setMonto(double monto) {
		this.monto = monto;
	}

	public PerfilSocio getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilSocio perfil) {
		this.perfil = perfil;
	}
	
	public String registrarPago(){
		return "registrarpago";
	}
	
	public Map<String,Integer> getMapValue() {
		return mapValue;
	}
	
	public void cargarCuotas(){
		mapValue = new LinkedHashMap<String,Integer>();
		
		PagoDAO pDao = FactoryDAO.getPagoDAO();
		List<Cuota> cuotas = FactoryDAO.getCuotaDAO().getCuotasFromSocio(perfil);
		for (Cuota cu : cuotas){
			double total = 0;
			List<Pago> pagos= pDao.getPagosFromCuotaAndSocio(perfil, cu);
			for (Pago p : pagos){
				total += p.getMonto();
			}	
			if (cu.getImporte() > total){
				mapValue.put(cu.getFecha().toString() , cu.getId());
			}
		}
		
	}
	
	public List<Deuda> getDeudas(){		
		FacesContext context = FacesContext.getCurrentInstance();
		PerfilSocio pf = (PerfilSocio) context.getExternalContext().getSessionMap().get("perfil");
		PagoDAO pDao = FactoryDAO.getPagoDAO();
		List<Cuota> cuotas = FactoryDAO.getCuotaDAO().getCuotasFromSocio(pf);
		List<Deuda> fin = new ArrayList<Deuda>();
		for (Cuota cu : cuotas){
			double total = 0;
			List<Pago> pagos= pDao.getPagosFromCuotaAndSocio(pf, cu);
			for (Pago p : pagos){
				total += p.getMonto();
			}	
			if (cu.getImporte() > total){
				fin.add(new Deuda(cu.getFecha(),cu.getImporte() - total));
			}
		}
		return fin;
		
	}
	
	public void guardarPago(){
		PagoServicio g = new PagoServicio();
		g.crearPago(fecha, monto, perfil , seleccion);
	}
	
	public int getSeleccion() {
		return seleccion;
	}
	public void setSeleccion(int seleccion) {
		this.seleccion = seleccion;
	}
	
}

