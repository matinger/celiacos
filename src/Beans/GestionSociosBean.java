package Beans;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;


import Servicios.GestionSociosServicio;

import Celiacos.Perfil;
import Celiacos.PerfilSocio;

@ManagedBean
@SessionScoped
public class GestionSociosBean {
	private int nroSocio;
	private String usuario;
	private String password;
	private String nombre;
	private String apellido;
	private int dni;
	private String domicilio;
	private String ocupacion;
	private Date fechaNacimiento;
	private Date fechaIngreso;
	private Date fechaDiagnostico;
	private String presentadoPor;
	private String telefono;
	private String email;
	private boolean beneficio;
	private boolean socioVirtual;
	private PerfilSocio perfilEliminar;
	
	
	public void setPerfilEliminar(PerfilSocio perfilEliminar) {
		this.perfilEliminar = perfilEliminar;
	}
	public int getNroSocio() {
		return nroSocio;
	}
	public void setNroSocio(int nroSocio) {
		this.nroSocio = nroSocio;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaDiagnostico() {
		return fechaDiagnostico;
	}
	public void setFechaDiagnostico(Date fechaDiagnostico) {
		this.fechaDiagnostico = fechaDiagnostico;
	}
	public String getPresentadoPor() {
		return presentadoPor;
	}
	public void setPresentadoPor(String presentadoPor) {
		this.presentadoPor = presentadoPor;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isBeneficio() {
		return beneficio;
	}
	public void setBeneficio(boolean beneficio) {
		this.beneficio = beneficio;
	}
	public boolean isSocioVirtual() {
		return socioVirtual;
	}
	public void setSocioVirtual(boolean socioVirtual) {
		this.socioVirtual = socioVirtual;
	}
	public List<PerfilSocio> getListaSocios(){
		FacesContext context = FacesContext.getCurrentInstance();
		Perfil p = (Perfil) context.getExternalContext().getSessionMap().get("perfil");
		GestionSociosServicio g = new GestionSociosServicio();
		return g.getListaPersonas(p);
	}
	public boolean crearSocio(){

		GestionSociosServicio g = new GestionSociosServicio();
		FacesContext context = FacesContext.getCurrentInstance();
		Perfil p = (Perfil) context.getExternalContext().getSessionMap().get("perfil");
		g.crearSocio(nroSocio, usuario, password,  nombre, apellido, dni, domicilio, ocupacion, fechaNacimiento, fechaIngreso, fechaDiagnostico, presentadoPor, telefono, email, beneficio, socioVirtual, p.getUnidad());	
		clear();
		return true;
	}
	public boolean eliminar(){
		System.out.println("Llego!");
		/*FacesContext context = FacesContext.getCurrentInstance();	
		GestionSociosServicio g = new GestionSociosServicio();
		PerfilSocio p = (PerfilSocio) context.getExternalContext().getRequestMap().get("perfil");*/
		System.out.println("Dni: " + perfilEliminar.getDni());
		System.out.println("Email: " + perfilEliminar.getEmail());
		GestionSociosServicio g = new GestionSociosServicio();
		g.eliminar(perfilEliminar);
		return true;
	}
	
	public void clear() {  
		this.setApellido(null);
		this.setBeneficio(false);
		this.setDni(0);
		this.setDomicilio(null);
		this.setEmail(null);
		this.setFechaDiagnostico(null);
		this.setFechaIngreso(null);
		this.setFechaNacimiento(null);
		this.setNombre(null);
		this.setNroSocio(0);
		this.setOcupacion(null);
		this.setPassword(null);
		this.setPresentadoPor(null);
		this.setSocioVirtual(false);
		this.setTelefono(null);
		this.setUsuario(null);
	}  
}
