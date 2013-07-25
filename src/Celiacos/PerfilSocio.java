package Celiacos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class PerfilSocio extends Perfil {
	
	private int nroSocio;
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
	
	@OneToMany(mappedBy="socio",  cascade={CascadeType.ALL})
	private List<Notificacion> notificaciones;
	
	@OneToMany(mappedBy="socio", cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	private List<Pago> pagos;
	
	public PerfilSocio(){
		pagos = new ArrayList<Pago>();
		notificaciones = new ArrayList<Notificacion>();
	}
	public PerfilSocio(int nroSocio, int dni, String domicilio,
			String ocupacion, Date fechaNacimiento, Date fechaIngreso,
			Date fechaDiagnostico, String presentadoPor, String telefono,
			String email, boolean beneficio) {
		super();
		this.nroSocio = nroSocio;
		this.dni = dni;
		this.domicilio = domicilio;
		this.ocupacion = ocupacion;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
		this.fechaDiagnostico = fechaDiagnostico;
		this.presentadoPor = presentadoPor;
		this.telefono = telefono;
		this.email = email;
		this.beneficio = beneficio;
		pagos = new ArrayList<Pago>();
		notificaciones = new ArrayList<Notificacion>();
	}
	public int getNroSocio() {
		return nroSocio;
	}
	public void setNroSocio(int nroSocio) {
		this.nroSocio = nroSocio;
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
	public List<Notificacion> getNotificaciones() {
		return notificaciones;
	}
	public List<Pago> getPagos() {
		return pagos;
	}
	
	public void addNotificacion(Notificacion notificacion) {
		this.notificaciones.add(notificacion);
		notificacion.setSocio(this);
	}
	public void addPago(Pago pago) {
		this.pagos.add(pago);
		pago.setSocio(this);
	}
	public void setNotificaciones(List<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}
	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}
	
	
	
}
