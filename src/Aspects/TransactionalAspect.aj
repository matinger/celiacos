package Aspects;

import java.lang.reflect.Field;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.aspectj.lang.reflect.MethodSignature;

import Celiacos.FactoryManager;
import Dao.Transactional;

public aspect TransactionalAspect {

Object around(): execution(@Transactional * *(..)) {

		Object dao = thisJoinPoint.getTarget();	
		MethodSignature methodSignature = (MethodSignature) thisJoinPoint.getSignature();
		Transactional annotation = methodSignature.getMethod().getAnnotation(Transactional.class);
		boolean ro = annotation.readOnly();
		EntityManager em = FactoryManager.getInstance();
		EntityTransaction tx = em.getTransaction();

		for (Field field : dao.getClass().getFields()) {
			if (field.getType().equals(javax.persistence.EntityManager.class)){
				//Seteo valor a atributo de la instancia alcanzada
				
				try {
					field.set(dao, em);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(!ro){
				if (field.getType().equals(javax.persistence.EntityTransaction.class)){
					//Seteo valor a atributo de la instancia alcanzada
					tx.begin();
					try {
						field.set(dao, tx);
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		dao = proceed();
		if(!ro){
			tx.commit();
		}
		em.close();
		return dao;
	}
}
