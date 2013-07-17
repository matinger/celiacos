package Celiacos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Producto {
	
	@Id @GeneratedValue
	@Column(name="id_producto")
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String nombre;
	private String marca;
	private String descripcion;
	private String rnpa;
	private String empresa;
	private String rne;
	private Date fechaAlta;
	private Date fechaCertificado;
	
	public Producto(){
		
	}
	public Producto(String nombre, String marca, String descripcion,
			String rnpa, String empresa, String rne, Date fechaAlta,
			Date fechaCertificado) {
		this.nombre = nombre;
		this.marca = marca;
		this.descripcion = descripcion;
		this.rnpa = rnpa;
		this.empresa = empresa;
		this.rne = rne;
		this.fechaAlta = fechaAlta;
		this.fechaCertificado = fechaCertificado;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getRnpa() {
		return rnpa;
	}
	public void setRnpa(String rnpa) {
		this.rnpa = rnpa;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getRne() {
		return rne;
	}
	public void setRne(String rne) {
		this.rne = rne;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Date getFechaCertificado() {
		return fechaCertificado;
	}
	public void setFechaCertificado(Date fechaCertificado) {
		this.fechaCertificado = fechaCertificado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}
