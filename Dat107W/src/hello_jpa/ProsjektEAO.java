package hello_jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProsjektEAO {
	private EntityManagerFactory emf;

	public ProsjektEAO() {
		emf = Persistence.createEntityManagerFactory("eclipselink");
	}
	
	public Prosjekt finnProsjektMedId(int id) {
		EntityManager em = emf.createEntityManager();

		Prosjekt prosjektMedId = null;
		try {
			prosjektMedId = em.find(Prosjekt.class, id);
		} catch(NullPointerException e) {
			System.err.println("Finner ingen prosjekt med id: " + id);
		} finally {
			em.close();
		}
		return prosjektMedId;
	}

	/*
	 * @param parametere til et nytt prosjekt, navn, beskrivelse
	 * 
	 * @return det nye prosjektet
	 */
	public Prosjekt leggTilProsjekt(String prosjektnavn, String prosjektbeskrivelse) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Prosjekt a = new Prosjekt(prosjektnavn, prosjektbeskrivelse);
		try {
			tx.begin();
			em.persist(a);
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return a;
	}
}
