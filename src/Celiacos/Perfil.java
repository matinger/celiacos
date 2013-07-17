package Celiacos;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="perfil")
public abstract class Perfil {

	@Id @GeneratedValue
	@Column(name="id_perfil")
	private int id;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="id_unidad")
	private TipoUnidad unidad;
	
	@ManyToOne
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

	
	
}
