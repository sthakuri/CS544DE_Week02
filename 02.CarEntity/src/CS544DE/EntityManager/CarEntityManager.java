/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS544DE.EntityManager;

import CS544DE.Model.Car;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author 500Course
 */
public class CarEntityManager {
   
    private javax.persistence.EntityManager em;

    public CarEntityManager(javax.persistence.EntityManager em) {        
        this.em = em;
    }

    public void save(Car car) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(car);
        tx.commit();
    }

    public boolean exist(Car car) {        
        Query query = em.createQuery("SELECT e FROM CarTbl e Where e.model ='"+car.getModel()+"'");        
        return query.getResultList().size()>0;
    }
}
