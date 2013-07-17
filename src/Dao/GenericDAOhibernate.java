package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import Celiacos.FactoryManager;

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

}
