package no.hvl.dat107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TodolisteEAO {

    private EntityManagerFactory emf;

    public TodolisteEAO() {
        emf = Persistence.createEntityManagerFactory("TodoPU");
    }

    public Todoliste finnListeNr(int listeNr) {
        EntityManager em = emf.createEntityManager();

        Todoliste liste = null;
        try {
            liste = em.find(Todoliste.class, listeNr);
        } finally {
            em.close();
        }
        return liste;
     }

    public void lagreListe(Todoliste liste) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            
            // ???
            
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public void slettListe(Todoliste liste) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            
            // ???
            
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public void oppdaterListe(Todoliste liste) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            
            // ???
            
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

}
