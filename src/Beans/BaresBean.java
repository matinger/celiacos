package Beans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Servicios.BarServicio;
import Servicios.GestionAdminServicio;
import Servicios.GestionOperadorServicio;
import Servicios.GestionUnidadesServicio;
import Servicios.ProductoServicio;
import Celiacos.Producto;
import Celiacos.Restaurante;



@ManagedBean
@SessionScoped
public class BaresBean {
	private String nombre;
	private String direccion;
	private String ciudad;
	private String provincia;
	private String telefono;
	private Restaurante barEditar;
	private int barEliminar;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
		if(barEditar !=null)
			barEditar.setNombre(nombre);
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
		if(barEditar !=null)
			barEditar.setDireccion(direccion);
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
		if(barEditar !=null)
			barEditar.setCiudad(ciudad);
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
		if(barEditar !=null)
			barEditar.setProvincia(provincia);
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
		if(barEditar !=null)
			barEditar.setTelefono(telefono);
	}
	public Restaurante getBarEditar() {
		return barEditar;
	}
	public void setBarEditar(Restaurante barEditar) {
		this.barEditar = barEditar;
	}
	public int getBarEliminar() {
		return barEliminar;
	}
	public void setBarEliminar(int barEliminar) {
		this.barEliminar = barEliminar;
	}
	
	public List<Restaurante> getListaBares(){
		BarServicio b = new BarServicio();	
		return b.getListaBares();
	}
	
	public boolean eliminar(){
		BarServicio b = new BarServicio();		
		return b.eliminar(barEliminar);
	}
	public boolean editar(){
		BarServicio b = new BarServicio();	
		return b.modificar(barEditar);
		
	}
	public String editarBar() { 
		this.setCiudad(barEditar.getCiudad());
		this.setDireccion(barEditar.getDireccion());
		this.setNombre(barEditar.getNombre());
		this.setProvincia(barEditar.getProvincia());
		this.setTelefono(barEditar.getTelefono());
		return "editarbar";
	}
	public void crearBar(){
		BarServicio b = new BarServicio();	
		b.crearBar(nombre,telefono,direccion,provincia,ciudad);
	}
	public void clear(){
		this.setNombre(null);
		this.setCiudad(null);
		this.setDireccion(null);
		this.setProvincia(null);
		this.setTelefono(null);
	}
	
}
