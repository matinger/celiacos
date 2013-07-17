package Dao;

import java.util.List;

import javax.persistence.EntityManager;

import Celiacos.FactoryManager;

public interface GenericDAO<T1> {

	public void guardar(T1 objeto) ;
	public void eliminar(T1 objeto) ;
    public T1 encontrar(Object id);
    public T1 modificar(T1 objeto);
    public List<T1> listar();
}
