package Dao;

import java.util.List;

import javax.persistence.Query;

import Celiacos.Usuario;

public class UsuarioDAOhibernate extends GenericDAOhibernate<Usuario> implements UsuarioDAO{

	public UsuarioDAOhibernate() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

	@Transactional(readOnly=true) 
	public Usuario getUser(String username, String password) {
		String sql = "SELECT u FROM Usuario u WHERE u.usuario = :username AND u.password = :password";
		Query query = entityManager.createQuery(sql);
		query.setParameter("password", password);
		query.setParameter("username", username);
		query.getResultList();
		List<Usuario> l = query.getResultList();
		if (l.isEmpty()) {
			return null;
		}
		return l.get(0);
	}

}
