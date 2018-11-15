package no.hvl.dat107;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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

            em.persist(liste);

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

            //NB! Ikke nok med em.merge(liste); Det er den 
            //returnerte listen som er managed.
            liste = em.merge(liste); 
            
            em.remove(liste);

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

            em.merge(liste);

            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public Todoliste finnListePaaNavn(String navn) {

        String queryString = "SELECT t FROM Todoliste t " 
                + "WHERE t.navn = :navn";

        EntityManager em = emf.createEntityManager();

        Todoliste liste = null;
        try {
            TypedQuery<Todoliste> query 
                    = em.createQuery(queryString, Todoliste.class);
            query.setParameter("navn", navn);
            liste = query.getSingleResult();
            
        } catch (NoResultException e) {
            // e.printStackTrace();
        } finally {
            em.close();
        }
        return liste;
    }

    public List<Todo> finnTodosIListe(Todoliste liste) {

        String queryString = "SELECT t FROM Todo t " 
                + "WHERE t.liste.listeId = :listeId "
                + "ORDER BY t.tekst ASC";

        EntityManager em = emf.createEntityManager();

        List<Todo> todos = null;
        try {
            TypedQuery<Todo> query = em.createQuery(queryString, Todo.class);
            query.setParameter("listeId", liste.getListeId());
            todos = query.getResultList();
            
        } finally {
            em.close();
        }
        return todos;
    }

}
