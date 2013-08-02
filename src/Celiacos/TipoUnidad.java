package Celiacos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="TipoUnidad")
public abstract class TipoUnidad {
	@Id @GeneratedValue
	@Column(name="id_unidad")
	private int id;
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	
	@OneToMany(mappedBy="unidad" ,cascade={CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.MERGE})
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Cuota> cuotas;
	
	@OneToMany(mappedBy="unidad",cascade = {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.MERGE})
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Perfil> socios;
	
	public TipoUnidad(){
		cuotas = new ArrayList<Cuota>();
		socios = new ArrayList<Perfil>();
	}
	
	public TipoUnidad(String nombre, String direccion, String telefono,
			String email) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		cuotas = new ArrayList<Cuota>();
		socios = new ArrayList<Perfil>();
		
	}
	public void setId(int id){
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	public List<Cuota> getCuotas() {
		return cuotas;
	}
	public List<Perfil> getSocios() {
		return socios;
	}
	public void addSocio(Perfil socio) {
		this.socios.add(socio);
		socio.setUnidad(this);
	}
	public void addCuota(Cuota cuota) {
		this.cuotas.add(cuota);
		cuota.setUnidad(this);
	}

	public int getId() {
		return id;
	}

	public void setCuotas(List<Cuota> cuotas) {
		this.cuotas = cuotas;
	}

	public void setSocios(List<Perfil> socios) {
		this.socios = socios;
	}
	
	
	
}
