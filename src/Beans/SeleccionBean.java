package Beans;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import Celiacos.Perfil;
import Celiacos.PerfilSocio;
import Celiacos.TipoUnidad;
import Dao.FactoryDAO;
import Servicios.GestionUnidadesServicio;

@ManagedBean
@SessionScoped
public class SeleccionBean {

	public SeleccionBean() {}
	private Map<String, Integer> mapValue;
	private Integer seleccion;
	
	public Map<String,Integer> getMapValue() {
		return mapValue;
	}
	public Integer getSeleccion() {
		return seleccion;
	}
	public void setSeleccion(Integer seleccion) {
		this.seleccion = seleccion;
	}
	
	public void cargarPerfiles(){
		mapValue = new LinkedHashMap<String,Integer>();
		GestionUnidadesServicio unidadesservicio = new GestionUnidadesServicio();
		FacesContext context = FacesContext.getCurrentInstance();
		
		List<Perfil> perfiles = (List<Perfil>) context.getExternalContext().getSessionMap().get("perfiles");
		System.out.println("Cantidad de perfiles: " + perfiles.size());
		for (Perfil p : perfiles){
			mapValue.put(p.getClass().getName(), p.getId()); //label, value
		}
	}
	
	public String ingresar() {
		System.out.println("PerfilSeleccionado: " + seleccion);
		ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession session =  (HttpSession)ctx.getSession(false);	
		PerfilSocio ps = FactoryDAO.getPerfilSocioDAO().encontrar(seleccion);
		session.setAttribute("perfil", ps);
		System.out.println(ps.getClass().getName());
		return ps.getClass().getName();
	}
	
}
