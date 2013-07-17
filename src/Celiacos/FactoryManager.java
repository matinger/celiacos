package Celiacos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryManager {
	 private static EntityManagerFactory emf =  Persistence.createEntityManagerFactory("celiacos");
	 
	 private FactoryManager() {  
	 }  	 
	 public static EntityManager getInstance() {
	    return emf.createEntityManager();
	
	 }
}
