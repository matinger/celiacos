package Celiacos;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PerfilAdministrador")
@PrimaryKeyJoinColumn(name="id_perfilAdministrador", referencedColumnName="id_perfil")
public class PerfilAdministrador extends Perfil {

	public PerfilAdministrador() {

	}

	
}
