package Celiacos;

import javax.persistence.Entity;

@Entity
public class Unidad extends TipoUnidad {
		
	public Unidad(){
		
	}
	public Unidad(String nombre, String direccion, String telefono,
			String email, String tipo) {
		super(nombre, direccion, telefono, email, tipo, false);
		// TODO Auto-generated constructor stub
	}

}
