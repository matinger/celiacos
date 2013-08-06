package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import Celiacos.FactoryManager;
import Celiacos.Usuario;

public class GenericDAOhibernate<T> implements GenericDAO<T> {

	private Class<T> persistenceClass = null;
	public EntityManager entityManager;
	public EntityTransaction tx;
	
	public GenericDAOhibernate(Class clase) {
        this.persistenceClass = clase;
    }
	
    @Transactional(readOnly=true) 
    public List<T> listar() {
        CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery(persistenceClass);
        criteriaQuery.from(persistenceClass);
        TypedQuery typedQuery = entityManager.createQuery(criteriaQuery);
        List l = typedQuery.getResultList();
        return l;
    }
    
    @Transactional(readOnly=false) 
	public void guardar(T objeto) {
        entityManager.persist(objeto);
	}

    @Transactional(readOnly=false) 
	public void eliminar(T objeto) {
        entityManager.remove(objeto);
        }
  
    @Transactional(readOnly=true) 
    public T encontrar(Object id) {
        T tipo = (T) entityManager.find(persistenceClass, id);
        return tipo;
    }
    
    @Transactional(readOnly=false) 
    public T modificar(T objeto) {
        T tipo = (T) entityManager.merge(objeto);
        return tipo;
    }
    
	private EntityManager getEntityManager() {
		return FactoryManager.getInstance();
	}

	@Transactional(readOnly=false) 
	public void eliminarPorId(Object id) {
		entityManager.remove(this.entityManager.getReference(persistenceClass, id));
		
	}
	
	/*
	@Transactional(readOnly=true)
	public T findOne(Query query) {
        T t;
        t = (T) query.getSingleResult();
        return t;
    }
	*/
	/*
	public Usuario getUser(String username, String password) {
		
		String sql = "SELECT u FROM Usuario u WHERE u.usuario = :username AND u.password = :password";
		Query query = entityManager.createQuery(sql);
		query.setParameter("password", password);
		query.setParameter("username", username);		
		Usuario u = (Usuario) query.getSingleResult();		
		return u;
	}*/
}
