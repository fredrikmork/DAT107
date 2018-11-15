package hello_jpa;

import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AnsattEAO {

	private EntityManagerFactory emf;

	public AnsattEAO() {
		emf = Persistence.createEntityManagerFactory("eclipselink");
	}

	/*
	 * @param et id nummer for en ansatt
	 * 
	 * @return en ansatt med en ID som man selv ønsker å finne
	 */
	public Ansatt finnAnsattMedId(int id) {
		EntityManager em = emf.createEntityManager();

		Ansatt ansattMedId = null;
		try {
			ansattMedId = em.find(Ansatt.class, id);
		} catch(NullPointerException e) {
			System.err.println("Finner ingen ansatt med id: " + id);
		} finally {
			em.close();
		}
		return ansattMedId;
	}

	/*
	 * @param et inntastet brukernavn
	 * 
	 * @return gir en ansatt søkt på med brukernavn
	 */
	public Ansatt finnAnsattMedNavn(String brukernavn) {
		String queryBN = "SELECT a FROM ansatt a" + " WHERE a.brukernavn = :brukernavn";
		EntityManager em = emf.createEntityManager();
		Ansatt a = null;
		try {
			TypedQuery<Ansatt> query = em.createQuery(queryBN, Ansatt.class);
			query.setParameter("brukernavn", brukernavn);
			a = query.getSingleResult();

		} catch (NoResultException e) {
			System.err.println("Fant ikke brukernavn gitt: " + brukernavn + ". Går tilbake.");
		} finally {
			em.close();
		}
		return a;
	}

	/*
	 * @param
	 * 
	 * @return en liste med alle ansatte
	 */
	@SuppressWarnings("unchecked")
	public List<Ansatt> finnAlleAnsatte() {
		EntityManager em = emf.createEntityManager();
		List<Ansatt> ansatte;
		em.getTransaction().begin();
		try {
			ansatte = em.createQuery("SELECT a FROM ansatt a").getResultList();
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return ansatte;
	}
	/*
	 * @param Nye stilling og lønn for den ansatte
	 * 
	 * @return boolsk verdi på om den ansatte har fått oppdatert stilling og eller
	 * lønn
	 */
	public Ansatt oppdateringAvAnsatt(Ansatt a, String stilling, int manedslonn) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		a.setmanedslonn(manedslonn);
		a.setStilling(stilling);
		try {
			tx.begin();

			em.merge(a);

			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return a;
	}

	/*
	 * @param parametere til nye ansatte
	 * 
	 * @return den nye ansatte
	 */
	public Ansatt leggTilAnsatt(String brukernavn, String fornavn, String etternavn, Date dato, String stilling,
			int manedslonn, Avdeling avdeling_id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Ansatt a = new Ansatt(brukernavn, fornavn, etternavn, dato, stilling, manedslonn, avdeling_id);
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

	/*
	 * @param den ansatte som skal sparkes
	 * 
	 * @return den ansatte som skal sparkes
	 */
	public Ansatt sparkeAnsatt(Ansatt a) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Ansatt slettede;
		Ansatt temp = null;
		boolean slett = false;
		try {
			tx.begin();
			temp = slettede = em.merge(a);
			em.remove(slettede);
			slett = true;
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		if (slett) {
			return temp;
		}
		return null;
	}
	public void oppdaterAvdeling(Ansatt a, int avdeling) {
		EntityManager em = emf.createEntityManager();
		AvdelingEAO avdeao = new AvdelingEAO();

		if (!erSjef(a)) {
			EntityTransaction tx = em.getTransaction();
			Avdeling avd = null;
			try {
				tx.begin();
				a = em.merge(a);
				avd = avdeao.finnAvdelingMedID(avdeling);
				a.setAvdeling_id(avd);
				tx.commit();
				System.out.println("Ny avdeling er: " + a.getAvdeling_id().getAvdelingNavn());
			} catch (Throwable e) {
				e.printStackTrace();
				tx.rollback();
			} finally {
				em.close();
			}
		} else {
			System.out.println("Den ansatte er allerede sjef i en annen avdeling, velg en annen ansatt.");
		}
	}
	
	public boolean erSjef(Ansatt a) {
		boolean erAnsattSjef = false;
		if (a.getAvdeling_id().getSjefHvem().getAnsatt_id() == a.getAnsatt_id()) {
			erAnsattSjef = true;
		}

		return erAnsattSjef;
	}
	
}
