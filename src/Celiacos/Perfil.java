package Celiacos;

import javax.persistence.*;

import org.hibernate.annotations.IndexColumn;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Perfil")
public abstract class Perfil {

	@Id @GeneratedValue
	@Column(name="id_perfil")
	private int id;
	
	@ManyToOne(optional=true, cascade = {CascadeType.MERGE})
	@JoinColumn(name="id_unidad")
	private TipoUnidad unidad;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	public Perfil() {
		
	}

	public int getId() {
		return id;
	}

	public TipoUnidad getUnidad() {
		return unidad;
	}

	public void setUnidad(TipoUnidad unidad) {
		this.unidad = unidad;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String toString(){
		return this.getClass().toString();
	}
	
}
