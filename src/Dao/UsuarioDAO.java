package Dao;

import Celiacos.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario>{

	public Usuario getUser(String username, String password);

	public Usuario getUser(String usu);
}
