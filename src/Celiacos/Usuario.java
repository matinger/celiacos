package Celiacos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name="Usuario")
public class Usuario {
	
	@Id @GeneratedValue
	@Column(name="id_usuario")
	private int id;
	
	@Column(nullable=false)
	private String usuario;
	
	private String nombre;
	private String apellido;
	@Column(nullable=false)
	private String password;
	
	@OneToMany(mappedBy="usuario", cascade = {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.MERGE})
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Perfil> perfiles;
		
	public Usuario(){
		perfiles = new ArrayList<Perfil>();
	}
	public Usuario(String usuario, String pass){
		this.usuario = usuario;
		this.password = pass;
		perfiles = new ArrayList<Perfil>();
	}
	public Usuario(String usuario, String pass,String nombre,String apellido){
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = pass;
		perfiles = new ArrayList<Perfil>();
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}
	
	public List<Perfil> getPerfiles() {
		return perfiles;
	}
    public void addPerfil(Perfil perfil) {
        this.perfiles.add(perfil);
        if (perfil.getUsuario() != this) {
            perfil.setUsuario(this);
        }
    }
}
