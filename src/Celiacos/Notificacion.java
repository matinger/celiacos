package Celiacos;


import java.util.Date;

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
	private String medio;
	private float monto;
	private String numeroidentificatorio;
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="id_perfil")
	private PerfilSocio socio;
	
	public Notificacion(float monto,Date fecha, String medio, String numeroidentificatorio, boolean visto){
		super();
		this.monto=monto;
		this.fecha=fecha;
		this.medio=medio;
		this.numeroidentificatorio=numeroidentificatorio;
		this.visto=visto;
		
	}
	
	public Notificacion(){
		
	}
	public Notificacion(String mensaje) {
		super();
	
		this.setVisto(false);
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

	public String getMedio() {
		return medio;
	}

	public void setMedio(String medio) {
		this.medio = medio;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public String getNumeroidentificatorio() {
		return numeroidentificatorio;
	}

	public void setNumeroidentificatorio(String numeroidentificatorio) {
		this.numeroidentificatorio = numeroidentificatorio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
