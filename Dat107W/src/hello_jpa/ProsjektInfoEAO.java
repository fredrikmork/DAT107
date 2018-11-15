package hello_jpa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ProsjektInfoEAO {
	
	private EntityManagerFactory emf;

	public ProsjektInfoEAO() {
		emf = Persistence.createEntityManagerFactory("eclipselink");
	}
	
	@SuppressWarnings("unchecked")
	public List<ProsjektInfo> getAllPI(){
		EntityManager em = emf.createEntityManager();
		List<ProsjektInfo> pi;
		em.getTransaction().begin();
		try {
			pi = em.createQuery("SELECT p FROM ProsjektInfo p").getResultList();
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return pi;
	}
	
	
	public ProsjektInfo finnProsjektInfoMedId(int id) {
		EntityManager em = emf.createEntityManager();

		ProsjektInfo prosjektInfoMedId = null;
		try {
			prosjektInfoMedId = em.find(ProsjektInfo.class, id);
		} catch(NullPointerException e) {
			System.err.println("Finner ingen prosjektInfo med id: " + id);
		} finally {
			em.close();
		}
		return prosjektInfoMedId;
	}
//	public ProsjektInfo finnProsjektInfoMedAnsattIdOgProsjektId(int ansatt_id, int prosjekt_id) {
//		EntityManager em = emf.createEntityManager();
//		String query = "SELECT pi FROM ProsjektInfo pi WHERE (pi.ansatt_id = :ansatt_id) AND (pi.prosjekt_id = :prosjekt_id)";
//		//String query = "SELECT a.ansatt_id, p.prosjekt_id FROM ansatt a, prosjekt p WHERE (a.ansatt_id = : ansatt_id) AND (p.prosjekt_id = :prosjekt_id)";
//		ProsjektInfo prosjektInfo = null; 
//		try {
//			TypedQuery<ProsjektInfo> tQuery = em.createQuery(query, ProsjektInfo.class);
//			tQuery.setParameter("ansatt_id", ansatt_id);
//			tQuery.setParameter("prosjekt_id", prosjekt_id);
//			prosjektInfo = tQuery.getSingleResult();
//		} catch(NullPointerException e) {
//			//System.err.println("Finner ingen prosjektInfo med id: " + id);
//		} finally {
//			em.close();
//		}
//		return prosjektInfo;
//	}
	/*
	 * @param parametere til et nytt prosjekt, navn, beskrivelse
	 * 
	 * @return det nye prosjektet
	 */
	public ProsjektInfo leggTilProsjektInfo(Prosjekt p, Ansatt a, String rolle, boolean iGang) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		ProsjektInfo pI = new ProsjektInfo(p, a, rolle, iGang);
		try {
			tx.begin();
			em.persist(pI);
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return pI;
	}
	
	public ProsjektInfo oppdaterTimer(ProsjektInfo p, int antallTimer) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		p.setAntallTimer(antallTimer);
		try {
			tx.begin();

			em.merge(p);

			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return p;
	}
	

	
	private List<ProsjektInfo> finnProsjektInfo(Prosjekt p){
		ProsjektInfoEAO piEAO = new ProsjektInfoEAO();
		List<ProsjektInfo> fullListe = getAllPI();
		List<ProsjektInfo> pinf = new ArrayList<ProsjektInfo>();
		Iterator<ProsjektInfo> iterator = fullListe.iterator();
		while(iterator.hasNext()) {
			ProsjektInfo pinfo = iterator.next();
			if( p == pinfo.getProsjekt_id()) {
				pinf.add(pinfo);
			}
		}
		return pinf;
	}
//	private List<Ansatt> ProsjektInfoForProsjektet(Prosjekt p){
//		AnsattEAO ansattEAO = new AnsattEAO();
//		List<Ansatt> fullListe = ansattEAO.finnAlleAnsatte();
//		List<Ansatt> liste = new ArrayList<Ansatt>();
//		Iterator<Ansatt> iterator = fullListe.iterator();
//		while(iterator.hasNext()) {
//			Ansatt ansatt = iterator.next();
//			if(ansatt == pi.getAnsatt_id()) {
//				liste.add(ansatt);
//			}
//		}
//		return liste;
	//}
	public String getOmProsjekt(int id) {
		ProsjektEAO prosjektEAO = new ProsjektEAO();
		Prosjekt prosjekt = prosjektEAO.finnProsjektMedId(id);
		List<ProsjektInfo> prosjektinfoliste = finnProsjektInfo(prosjekt);
		
		System.out.println(prosjekt);
		System.out.println(prosjektinfoliste.size());
		
		String svar = "";

		Iterator<ProsjektInfo> iterator = prosjektinfoliste.iterator();
		while(iterator.hasNext()) {
			ProsjektInfo p = iterator.next();
			
		svar = "Prosjekt: " + prosjekt.getProsjektNavn() + "Beskrivelse: " + prosjekt.getProsjektBeskrivelse() + 
				"Ansatt: " + p.getAnsatt_id().getEtternavn() + ", " + p.getAnsatt_id().getFornavn() + "Rolle: " + p.getRolle() + "AntallTimer: " + p.getAntallTimer();
		}
		return svar;
	}
}
