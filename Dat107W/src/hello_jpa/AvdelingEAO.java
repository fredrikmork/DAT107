package hello_jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class AvdelingEAO {
	private EntityManagerFactory emf;

	public AvdelingEAO() {
		emf = Persistence.createEntityManagerFactory("eclipselink");
	}

	/*
	 * @param et id nummer for en avdeling
	 * 
	 * @return en avdeling med en ID som man selv ønsker å finne
	 */
	public Avdeling finnAvdelingMedID(int id) {
		EntityManager em = emf.createEntityManager();

		Avdeling avdelingMedId = null;
		try {
			avdelingMedId = em.find(Avdeling.class, id);
		} finally {
			em.close();
		}
		return avdelingMedId;
	}
	/*
	 * @param et id nummer for sjefen i avdelingen
	 * 
	 * @return utlisting av alle ansatte på en avdeling, og utheving av hvem som er
	 * sjef
	 */	
	public List<Ansatt> UtlistingAvAvdeling(int id) {
		EntityManager em = emf.createEntityManager();
		List<Ansatt> avdeling = null;
		
		try {
			em.getTransaction().begin();
			Avdeling av = em.find(Avdeling.class, id);
			avdeling = av.getAnsatte();
			em.getTransaction().commit();
		} catch (NoResultException e) {
            // e.printStackTrace();
		} finally {
			em.close();
		}
		return avdeling;
	}
	
	public boolean leggTilAvdeling(String avdnavn, Ansatt sjefHvem) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        AnsattEAO aeao = new AnsattEAO();
        boolean opprettet = false;
        if (!aeao.erSjef(sjefHvem)) {
            Avdeling a = new Avdeling(avdnavn, sjefHvem);
            try {
                tx.begin();
                em.persist(a);
                tx.commit();
            } finally {
                em.close();
            }
            aeao.oppdaterAvdeling(sjefHvem, a.getAvdeling_id());
            opprettet = true;
        }
        return opprettet;
    }
}
