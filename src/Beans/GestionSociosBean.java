package Beans;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;


import Servicios.GestionSociosServicio;

import Celiacos.Perfil;
import Celiacos.PerfilSocio;

@ManagedBean
@ViewScoped
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
	private int perfilEliminar;
	private PerfilSocio perfil;
	
	public void setPerfilEliminar(int perfilEliminar) {
		this.perfilEliminar = perfilEliminar;
	}
	public void setPerfil(PerfilSocio perfil) {
		this.perfil= perfil;
	}
	public int getNroSocio() {
		return nroSocio;
	}
	public void setNroSocio(int nroSocio) {
		this.nroSocio = nroSocio;
		if (perfil != null)
		perfil.setNroSocio(nroSocio);
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
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
		if (perfil != null)
		perfil.setDni(dni);
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
		if (perfil != null)
		perfil.setDomicilio(domicilio);
	}
	public String getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
		if (perfil != null)
		perfil.setOcupacion(ocupacion);
	}
	public Date getFechaNacimiento() {
		
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		if (perfil != null)
		perfil.setFechaNacimiento(fechaNacimiento);
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		if (perfil != null)
		perfil.setFechaIngreso(fechaIngreso);
	}
	public Date getFechaDiagnostico() {
		return fechaDiagnostico;
	}
	public void setFechaDiagnostico(Date fechaDiagnostico) {
		this.fechaDiagnostico = fechaDiagnostico;
		if (perfil != null)
		perfil.setFechaDiagnostico(fechaDiagnostico);
	}
	public String getPresentadoPor() {
		return presentadoPor;
	}
	public void setPresentadoPor(String presentadoPor) {
		this.presentadoPor = presentadoPor;
		if (perfil != null)
		perfil.setPresentadoPor(presentadoPor);
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
		if (perfil != null)
		perfil.setTelefono(telefono);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		if (perfil != null)
		perfil.setEmail(email);
	}
	public boolean isBeneficio() {
		return beneficio;
	}
	public void setBeneficio(boolean beneficio) {
		this.beneficio = beneficio;
		if (perfil != null)
		perfil.setBeneficio(beneficio);
	}
	public boolean isSocioVirtual() {
		return socioVirtual;
	}
	public void setSocioVirtual(boolean socioVirtual) {
		this.socioVirtual = socioVirtual;
		if (perfil != null)
		perfil.setSocioVirtual(socioVirtual);
	}
	public List<PerfilSocio> getListaSocios(){
		FacesContext context = FacesContext.getCurrentInstance();
		Perfil p = (Perfil) context.getExternalContext().getSessionMap().get("perfil");
		GestionSociosServicio g = new GestionSociosServicio();
		return g.getListaPersonas(p);
	}
	public List<PerfilSocio> getListaSociosCentral(){
		FacesContext context = FacesContext.getCurrentInstance();
		Perfil p = (Perfil) context.getExternalContext().getSessionMap().get("perfil");
		GestionSociosServicio g = new GestionSociosServicio();
		return g.getListaPersonasCentral(p);
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
		GestionSociosServicio g = new GestionSociosServicio();
		g.eliminar(perfilEliminar);
		return true;
	}
	public boolean editar(){
		GestionSociosServicio g = new GestionSociosServicio();
		g.modificar(perfil);
		return true;
	}
	public String editarSocio() {  
		this.setApellido(perfil.getUsuario().getApellido());
		this.setBeneficio(perfil.isBeneficio());
		this.setDni(perfil.getDni());
		this.setDomicilio(perfil.getDomicilio());
		this.setEmail(perfil.getEmail());
		this.setFechaDiagnostico(perfil.getFechaDiagnostico());
		this.setFechaIngreso(perfil.getFechaIngreso());
		this.setFechaNacimiento(perfil.getFechaNacimiento());
		this.setNombre(perfil.getUsuario().getNombre());
		this.setNroSocio(perfil.getNroSocio());
		this.setOcupacion(perfil.getOcupacion());
		this.setPassword(perfil.getUsuario().getPassword());
		this.setPresentadoPor(perfil.getPresentadoPor());
		this.setSocioVirtual(perfil.isSocioVirtual());
		this.setTelefono(perfil.getTelefono());
		this.setUsuario(perfil.getUsuario().getUsuario());
		return "editarsocio";
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
