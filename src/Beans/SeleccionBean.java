package Beans;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Celiacos.Perfil;
import Celiacos.TipoUnidad;
import Servicios.GestionUnidadesServicio;

@ManagedBean
@SessionScoped
public class SeleccionBean {

	public SeleccionBean() {}
	private Map<String, String> mapValue;
	private String seleccion;
	
	public Map<String,String> getMapValue() {
		return mapValue;
	}
	public String getSeleccion() {
		return seleccion;
	}
	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}
	
	public void cargarPerfiles(){
		mapValue = new LinkedHashMap<String,String>();
		GestionUnidadesServicio unidadesservicio = new GestionUnidadesServicio();
		FacesContext context = FacesContext.getCurrentInstance();
		
		List<Perfil> perfiles = (List<Perfil>) context.getExternalContext().getSessionMap().get("perfiles");
		System.out.println("Cantidad de perfiles: " + perfiles.size());
		for (Perfil p : perfiles){
			mapValue.put(p.getClass().getName(), p.getClass().getName()); //label, value
		}
	}
	
	public String ingresar() {
		System.out.println("PerfilSeleccionado: " + seleccion);
		return seleccion;
	}
	
}
