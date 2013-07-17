package Celiacos;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="pago")
public class Pago {
	@Id @GeneratedValue
	@Column(name="id_pago")
	private int id;
	private Date fecha;
	private double monto;
	
	@ManyToOne
	@JoinColumn(name="id_perfil")
	private PerfilSocio socio;
	
	@ManyToOne
	@JoinColumn(name="id_cuota")
	private Cuota cuota;
	
	public Pago(){
		
	}
	public Pago(Date fecha, double monto) {
		super();
		this.fecha = fecha;
		this.monto = monto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public PerfilSocio getSocio() {
		return socio;
	}
	public void setSocio(PerfilSocio socio) {
		this.socio = socio;
	}
	
	public Cuota getCuota() {
		return cuota;
	}
	public void setCuota(Cuota cuota) {
		this.cuota = cuota;
	}
	
	
	
}
