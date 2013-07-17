package Celiacos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Notificacion {
	
	@Id @GeneratedValue
	@Column(name="id_notificacion")
	private int id;
	private boolean visto;
	private String mensaje;
	
	
	@ManyToOne
	@JoinColumn(name="id_cuota")
	private Cuota cuotaPaga;
	
	@ManyToOne
	@JoinColumn(name="id_perfil")
	private PerfilSocio socio;
	
	public Notificacion(){
		
	}
	public Notificacion(String mensaje) {
		super();
	
		this.mensaje = mensaje;
		this.setVisto(false);
	}
	public Cuota getCuotaPaga() {
		return cuotaPaga;
	}
	public void setCuotaPaga(Cuota cuotaPaga) {
		this.cuotaPaga = cuotaPaga;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public PerfilSocio getSocio() {
		return socio;
	}
	public void setSocio(PerfilSocio socio) {
		this.socio = socio;
	}
	public boolean getVisto() {
		return visto;
	}
	public void setVisto(boolean visto) {
		this.visto = visto;
	}
	public int getId() {
		return id;
	}
	
	
}
