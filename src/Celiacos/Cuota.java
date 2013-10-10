package Celiacos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="Cuota")
public class Cuota {
	@Id @GeneratedValue
	@Column(name="id_cuota")
	private int id;
	private Date fecha;
	private double importe;
	
	@OneToMany(mappedBy="cuota", cascade = {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.MERGE})
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Pago> pagos;

	@ManyToOne
	@JoinColumn(name="id_unidad")
	private TipoUnidad unidad;
	
	public Cuota(){
		pagos = new ArrayList<Pago>();
	}
	public Cuota(double importe, Date fecha) {
		super();
		this.fecha = fecha;
		this.importe = importe;
		pagos = new ArrayList<Pago>();
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

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}
}
