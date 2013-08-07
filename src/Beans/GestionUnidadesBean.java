package Beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Celiacos.TipoUnidad;
import Servicios.GestionUnidadesServicio;

@ManagedBean
@ViewScoped
public class GestionUnidadesBean {
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	private int unidadEliminar;
	private TipoUnidad unidad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
		if (unidad != null)
			unidad.setNombre(nombre);
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
		if (unidad != null)
			unidad.setDireccion(direccion);
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
		if (unidad != null)
			unidad.setTelefono(telefono);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		if (unidad != null)
			unidad.setEmail(email);
	}
	
	public void eliminar(){
		GestionUnidadesServicio g = new GestionUnidadesServicio();
		g.eliminar(unidadEliminar);
	}
	
	public void editar(){
		GestionUnidadesServicio g = new GestionUnidadesServicio();
		g.modificar(unidad);
	}
	
	public void crearUnidad(){
		GestionUnidadesServicio g = new GestionUnidadesServicio();
		g.crearUnidad(nombre, direccion, telefono, email);
	}
	
	public String editarUnidad(){
		this.setDireccion(unidad.getDireccion());
		this.setEmail(unidad.getEmail());
		this.setNombre(unidad.getNombre());
		this.setTelefono(unidad.getTelefono());
		return "editarunidad";
	}
	
	public void clear() {
		unidad = null;
		this.setDireccion(null);
		this.setEmail(null);
		this.setNombre(null);
		this.setTelefono(null);

	}  
	
	public List<TipoUnidad> getListaUnidades(){
		GestionUnidadesServicio g = new GestionUnidadesServicio();
		return g.getListaUnidades();
	}
	public int getUnidadEliminar() {
		return unidadEliminar;
	}
	public void setUnidadEliminar(int unidadEliminar) {
		this.unidadEliminar = unidadEliminar;
	}
	public TipoUnidad getUnidad() {
		return unidad;
	}
	public void setUnidad(TipoUnidad unidad) {
		this.unidad = unidad;
	}
}
