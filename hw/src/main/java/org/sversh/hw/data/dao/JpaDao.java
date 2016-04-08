package org.sversh.hw.data.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.sversh.hw.data.model.LoanRequest;


@Repository
public class JpaDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional(propagation = Propagation.MANDATORY)
    public LoanRequest find(final Long id) {
        return entityManager.find(LoanRequest.class, id);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void save(final LoanRequest entity) {
        entityManager.persist(entity);
    }


    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public int findAllLoansForPersonAndIp(String firstName, String lastName, String ip, Date date) {
        return (int) getEntityManager().createNamedQuery("findAllLoansForPersonAndIp")
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName)
                .setParameter("ip", ip)
                .setParameter("date", date)
                .getSingleResult();
    }


}
