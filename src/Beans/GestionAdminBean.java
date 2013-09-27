package Beans;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Servicios.GestionAdminServicio;
import Servicios.GestionUnidadesServicio;

import Celiacos.PerfilAdministradorUnidad;
import Celiacos.TipoUnidad;

@ManagedBean
@ViewScoped
public class GestionAdminBean {
	private String usuario;
	private String password;
	private String nombre;
	private String apellido;
	private Map<String, Integer> mapValue;
	private int seleccion;
	private TipoUnidad u;
	private int perfilEliminar;
	private PerfilAdministradorUnidad perfil;
	
	public PerfilAdministradorUnidad getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilAdministradorUnidad perfil) {
		this.perfil = perfil;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
		if (perfil != null)
		perfil.getUsuario().setUsuario(usuario);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
		if (perfil != null)
		perfil.getUsuario().setPassword(password);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
		if (perfil != null)
		perfil.getUsuario().setNombre(nombre);
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
		if (perfil != null)
		perfil.getUsuario().setApellido(apellido);
	}
	
	public List<PerfilAdministradorUnidad> getListaAdmin(){
		GestionAdminServicio g = new GestionAdminServicio();		
		return g.getListaAdmin();
	}
	
	public boolean eliminar(){
		GestionAdminServicio g = new GestionAdminServicio();
		return g.eliminar(perfilEliminar);
	}
	public String editarAdmin() {  
		this.setApellido(perfil.getUsuario().getApellido());
		this.setNombre(perfil.getUsuario().getNombre());
		this.setPassword(perfil.getUsuario().getPassword());
		this.setUsuario(perfil.getUsuario().getUsuario());
		this.setSeleccion(perfil.getUnidad().getId());
		return "editaradmin";
	}
	
	public boolean editar(){
		GestionAdminServicio g = new GestionAdminServicio();
		return g.modificar(perfil, seleccion);
		
	}
	
	public int getPerfilEliminar() {
		return perfilEliminar;
	}
	public void setPerfilEliminar(int perfilEliminar) {
		this.perfilEliminar = perfilEliminar;
	}
	
	public void clear(){
		this.setApellido(null);
		this.setNombre(null);
		this.setPassword(null);
		this.setUsuario(null);
	}
	
	public void cargarUnidades(){
		mapValue = new LinkedHashMap<String,Integer>();
		GestionUnidadesServicio unidadesservicio = new GestionUnidadesServicio();
		List<TipoUnidad> unidades = unidadesservicio.getListaUnidades();
		for (TipoUnidad uni : unidades){
			mapValue.put(uni.getNombre(), uni.getId()); //label, value
		 }
	}
	
	public boolean crearAdmin(){
		GestionAdminServicio g = new GestionAdminServicio();
		g.crearAdmin(usuario, password, nombre, apellido, seleccion);
		return true;
	}
	
	public Map<String,Integer> getMapValue() {
		return mapValue;
	}
	public int getSeleccion() {
		return seleccion;
	}
	public void setSeleccion(int seleccion) {
		this.seleccion = seleccion;
	}
	
}
