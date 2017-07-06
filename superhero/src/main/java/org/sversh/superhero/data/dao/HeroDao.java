package org.sversh.superhero.data.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.sversh.superhero.data.model.Superhero;


@Repository
public class HeroDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional(propagation = Propagation.MANDATORY)
    public Superhero find(final Long id) {
        return entityManager.find(Superhero.class, id);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void save(final Superhero entity) {
        entityManager.persist(entity);
    }


    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public long findAllLoansForPersonAndIp(String firstName, String lastName, String ip, Date date) {
        return (long) getEntityManager().createNamedQuery("findAllLoansForPersonAndIp")
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName)
                .setParameter("ip", ip)
                .setParameter("date", date)
                .getSingleResult();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void update(Superhero entity) {
        entityManager.merge(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Superhero> findAll() {
        return (List<Superhero>) getEntityManager()
                .createNamedQuery("findAllHeros")
                .getResultList();
    }

    public Superhero findByPseudonym(String pseudonym) {
        return (Superhero) getEntityManager()
                .createNamedQuery("findByPseudonym")
                .setParameter("pseudonym", pseudonym)
                .getSingleResult();
    }

}
