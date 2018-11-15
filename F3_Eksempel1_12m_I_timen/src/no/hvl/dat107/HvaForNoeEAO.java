package no.hvl.dat107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class HvaForNoeEAO {

    private EntityManagerFactory emf;

    public HvaForNoeEAO() {
        emf = Persistence.createEntityManagerFactory("???PersistenceUnit");
    }

    public En finnEnPaaEnsidenPaaPK() {

        EntityManager em = emf.createEntityManager();

        En en = null;
        try {
            en = em.find(En.class, null);
        } finally {
            em.close();
        }
        return en;
    }

    public Mange finnEnPaaMangesidenMedMatchPaaParametre() {

        String queryString = "";

        EntityManager em = emf.createEntityManager();

        Mange mange = null;
        try {
            TypedQuery<Mange> query = em.createQuery(queryString, Mange.class);
            query.setParameter("???", null);
            query.setParameter("???", null);
            mange = query.getSingleResult();
        } finally {
            em.close();
        }
        return mange;
    }

    public void registrerMangeForEn() {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            tx.commit();

        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

}
