package Beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import Celiacos.Perfil;
import Celiacos.PerfilOperadorCentral;
import Celiacos.TipoUnidad;
import Servicios.GestionAdminServicio;
import Servicios.GestionOperadorServicio;

@ManagedBean
@ViewScoped
public class GestionOperadorBean {
	private String usuario;
	private String password;
	private String nombre;
	private String apellido;
	private int perfilEliminar;
	private PerfilOperadorCentral perfil;
	
	public PerfilOperadorCentral getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilOperadorCentral perfil) {
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
	
	public List<PerfilOperadorCentral> getListaOperador(){
		GestionOperadorServicio g = new GestionOperadorServicio();		
		return g.getListaOperadoresUnidades();
	}
	
	public boolean eliminar(){
		GestionOperadorServicio g = new GestionOperadorServicio();		
		return g.eliminar(perfilEliminar);
	}
	public String editarOperador() {  
		this.setApellido(perfil.getUsuario().getApellido());
		this.setNombre(perfil.getUsuario().getNombre());
		this.setPassword(perfil.getUsuario().getPassword());
		this.setUsuario(perfil.getUsuario().getUsuario());
		return "editaroperador";
	}
	
	public boolean editar(){
		GestionOperadorServicio g = new GestionOperadorServicio();	
		return g.modificar(perfil);
		
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
	
	public boolean crearOperador(){
		GestionOperadorServicio g = new GestionOperadorServicio();	
		FacesContext context = FacesContext.getCurrentInstance();
		Perfil p = (Perfil) context.getExternalContext().getSessionMap().get("perfil");
		g.crearOperadorCentral(usuario, password, nombre, apellido, p.getUnidad() );
		return true;
	}
	
	
}
