package Celiacos;

import javax.persistence.Entity;

@Entity
public class UnidadCentral extends TipoUnidad {

	public UnidadCentral(){
		
	}
	public UnidadCentral(String nombre, String direccion, String telefono,
			String email) {
		super(nombre, direccion, telefono, email, "Central", true);
		// TODO Auto-generated constructor stub
	}

}
