package Celiacos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cuota")
public class Cuota {
	@Id @GeneratedValue
	@Column(name="id_cuota")
	private int id;
	private Date fecha;
	private double importe;
	
	@OneToMany(mappedBy="cuota", cascade = {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.MERGE})
	private List<Pago> pagos;

	@OneToMany(mappedBy="cuotaPaga", cascade = {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.MERGE})
	private List<Notificacion> notificaciones;
	
	@ManyToOne
	@JoinColumn(name="id_unidad")
	private TipoUnidad unidad;
	
	public Cuota(){
		pagos = new ArrayList<Pago>();
		notificaciones = new ArrayList<Notificacion>();
	}
	public Cuota(double importe, Date fecha) {
		super();
		this.fecha = fecha;
		this.importe = importe;
		pagos = new ArrayList<Pago>();
		notificaciones = new ArrayList<Notificacion>();
	}

	public TipoUnidad getUnidad() {
		return unidad;
	}

	public void setUnidad(TipoUnidad unidad) {
		this.unidad = unidad;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
	public Date getFecha() {
		return fecha;
	}
	public List<Pago> getPagos() {
		return pagos;
	}
	public void addPago(Pago pago) {
		this.pagos.add(pago);
		if (pago.getCuota() != this){
			pago.setCuota(this);
		}
		
	}
	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}
	public void setNotificaciones(List<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public List<Notificacion> getNotificaciones() {
		return notificaciones;
	}
	public void addNotificacion(Notificacion notificacion) {
		this.notificaciones.add(notificacion);
		notificacion.setCuotaPaga(this);
	}
	public int getId() {
		return id;
	}
}
