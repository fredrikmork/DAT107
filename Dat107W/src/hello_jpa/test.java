package hello_jpa;

import java.util.Iterator;
import java.util.List;

public class test {
	public static void main(String[] args) {
		ProsjektEAO pEAO = new ProsjektEAO();
		ProsjektInfoEAO piEAO = new ProsjektInfoEAO();
		AvdelingEAO avEao = new AvdelingEAO();
		Avdeling a = avEao.finnAvdelingMedID(1);
		AnsattEAO anEAO = new AnsattEAO();
		Ansatt a1 = anEAO.finnAnsattMedId(3);
		
		// System.out.println(a);
		// List<Ansatt> a1 = avEao.UtlistingAvAvdeling(3);
		// System.out.println(a1);
		//Prosjekt p = pEAO.leggTilProsjekt("Hare", "Haretaskere som er kule");
		
//		Prosjekt p = pEAO.finnProsjektMedId(1);
//		System.out.println(p);
//		ProsjektInfo pI = piEAO.finnProsjektInfoMedId(1);
//		System.out.println(pI);
//		ProsjektInfo efg = piEAO.oppdaterTimer(pI, 4);
//		System.out.println(efg);
		
		System.out.println(piEAO.getOmProsjekt(3));
	}
	
	
}
