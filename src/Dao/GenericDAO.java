package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Celiacos.FactoryManager;
import Celiacos.Usuario;

public interface GenericDAO<T1> {

	public void guardar(T1 objeto) ;
	public void eliminar(T1 objeto) ;
	public void eliminarPorId(Object id) ;
    public T1 encontrar(Object id);
    public T1 modificar(T1 objeto);
    public List<T1> listar();
	//public T1 findOne(Query T1);
}
