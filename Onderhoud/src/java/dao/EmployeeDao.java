/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entity.EmployeeEntity;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author jasper
 */
@Stateless
public class EmployeeDao implements Serializable {
     @PersistenceContext(unitName = "RESORTPU")
    private EntityManager em;

    public void edit(EmployeeEntity employeeEntity) {
        em.merge(employeeEntity);
    }

    public List<EmployeeEntity> listAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(EmployeeEntity.class));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }

    public EmployeeEntity findById(String id) {
        if (id == null) {
            return null;
        }
        return em.find(EmployeeEntity.class, id);
    }

    public void deleteById(String id) {
        em.remove(findById(id));
    }
}
