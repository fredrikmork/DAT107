package no.hvl.dat107.forelesning3;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class VitnemalEAO {

	private EntityManagerFactory emf;

	public VitnemalEAO() {
		emf = Persistence.createEntityManagerFactory("???PersistenceUnit");
	}

	public Vitnemal finnEnPaaEnsidenPaaPK(int studNr) {

		EntityManager em = emf.createEntityManager();

		Vitnemal en = null;
		try {
			en = em.find(Vitnemal.class, studNr);
		} finally {
			em.close();
		}
		return en;
	}

	public Karakter finnEnPaaMangesidenMedMatchPaaParametre() {

		String queryString = "";

		EntityManager em = emf.createEntityManager();

		Karakter karakter = null;
		try {
			TypedQuery<Karakter> query = em.createQuery(queryString, Karakter.class);
			query.setParameter("???", null);
			query.setParameter("???", null);
			karakter = query.getSingleResult();
		} finally {
			em.close();
		}
		return karakter;
	}
	//mangeForEn
	public void registrerKarakterForStudent(String kursKode, LocalDate eksDato, String karakter, int studNr) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Vitnemal vitnemal = em.find(Vitnemal.class, studNr);
			//Karakter kar = new Karakter(kursKode, eksDato, karakter, vitnemal);
			//em.persist(kar);
			//vitnemal.addKarakter(karakter);
			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

}
