package hello_jpa;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Klient {
	public static void main(String[] args) {
		AnsattEAO aeao = new AnsattEAO();
		ProsjektEAO peao = new ProsjektEAO();
		AvdelingEAO aveao = new AvdelingEAO();
		ProsjektInfoEAO pieao = new ProsjektInfoEAO();
		
		// Menyen
		int avslutt = 0;
		while (avslutt == 0) {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			System.out.println("---Meny---\n1 -- Tast 1 for å søke etter ansatt med ansatt-ID"
					+ "\n2 -- Tast 2 for å søke etter ansatt med brukernavn"
					+ "\n3 -- Tast 3 for å liste ut alle ansatte"
					+ "\n4 -- Tast 4 for å oppdatere en ansatt sin stilling og månedslønn"
					+ "\n5 -- Tast 5 for å ansette en ny" + "\n6 -- Tast 6 for å sparke ansatt" + "\n7 -- Avslutt");
			
			int input = scan.nextInt();

			switch (input) {
			case 1:
				System.out.println("Skriv inn ansatt-ID på den ansatte du vil finne: ");
				int id = scan.nextInt();
				Ansatt a1 = aeao.finnAnsattMedId(id);
				System.out.println(a1);
				break;
			case 2:
				System.out.println("Skriv inn brukernavnet på den ansatte du vil finne: ");
				scan.nextLine();
				String initialer = scan.nextLine();
				Ansatt a2 = aeao.finnAnsattMedNavn(initialer);
				System.out.println(a2);
				break;
			case 3:
				System.out.println("Liste av ansatte:\n");
				List<Ansatt> ansatte = aeao.finnAlleAnsatte();
				Iterator<Ansatt> iterator = ansatte.iterator();
				while (iterator.hasNext()) {
					System.out.println(iterator.next());
				}
				break;
			case 4:
				System.out.println("Søk først etter ansatte som skal oppdateres med ansatt-ID: ");
				scan.nextLine();
				int id1 = scan.nextInt();
				Ansatt a3 = aeao.finnAnsattMedId(id1);
				System.out.println("Tast inn ny lønn:");
				scan.nextLine();
				int lonn = scan.nextInt();
				System.out.println("Tast inn ny stilling:");
				scan.nextLine();
				String stilling = scan.nextLine();
				Ansatt a4 = aeao.oppdateringAvAnsatt(a3, stilling, lonn);
				System.out.println(a4);
				break;
			case 5:
				System.out.println("Skriv inn brukernavn (4 karakterer): ");
				scan.nextLine();
				String bNavn = scan.nextLine();
				System.out.println("Fornavn:");
				String fNavn = scan.nextLine();
				System.out.println("Etternavn:");
				String eNavn = scan.nextLine();
				System.out.println("Skriv inn dato med format åååå-mm-dd:");
				Date date = Date.valueOf((scan.nextLine()));
				System.out.println("Stilling: ");
				String stilling1 = scan.nextLine();
				System.out.println("Månedslønn: ");
				int lonn2 = scan.nextInt();
				System.out.println("Søk etter avdeling: ");
				System.out.println("Avdeling_id:");
				int avdelingID= scan.nextInt();
				Avdeling avdeling = aveao.finnAvdelingMedID(avdelingID);
				Ansatt a6 = aeao.leggTilAnsatt(bNavn, fNavn, eNavn, date, stilling1, lonn2, avdeling);
				System.out.println(a6);
				break;
			case 6:
				System.out.println("Søk på den ansatte som du vil sparke, så blir h*n sparket:");
				int id3 = scan.nextInt();
				Ansatt a5 = aeao.finnAnsattMedId(id3);
				aeao.sparkeAnsatt(a5);
				break;
			case 7:
				System.out.println("Legg til navnet på prosjektet:");
				scan.nextLine();
				String pNavn = scan.nextLine();
				System.out.println("Prosjektbeskrivelse: ");
				String beNavn = scan.nextLine();
				Prosjekt p1 = peao.leggTilProsjekt(pNavn, beNavn);
				System.out.println(p1);
				break;
			case 8:
				System.out.println("Skriv inn navn på prosjektet, som skal få nye objekt (Prosjekt nummer): "); //prosjekt p, Ansatt a, String rolle, boolean iGang
				scan.nextLine();
				Prosjekt p2 = peao.finnProsjektMedId(scan.nextInt());
				System.out.println("Skriv inn ansatt som skal endres på (Ansatt-nummer: ");
				Ansatt a9 = aeao.finnAnsattMedId(scan.nextInt());
				System.out.println("Legg til ansatt-rolle: ");
				String arolle = scan.nextLine();
				System.out.println("Hvis prosjektet er startet skriv inn 1, hvis ikke skriv inn 2. ");
				boolean iGang = false;
				switch (scan.nextInt()) {
				case 1:
					iGang = true;
					break;
				case 2:
					iGang = false;
					break;
				default:
					break;
				}
				ProsjektInfo pi3 = pieao.leggTilProsjektInfo(p2, a9, arolle, iGang);
				System.out.println(pi3);
				break;
			case 9:
				System.out.println("Søk først etter ansatte som skal oppdateres med prosjektInfo-ID: ");
				scan.nextLine();
				ProsjektInfo p99 = pieao.finnProsjektInfoMedId(scan.nextInt());
				System.out.println("Oppdater antall timer: ");
				int antallTimer = scan.nextInt();	
				ProsjektInfo oppdatertPI = pieao.oppdaterTimer(p99, antallTimer);
				System.out.println(oppdatertPI);
				break;
			case 10:
//				System.out.println("Skriv inn ansatt_id du vil se info om: ");
//				scan.nextLine();
//				int ansatt_id = scan.nextInt();
//				System.out.println("Skriv inn prosjekt_id du vil se info om:");
//				int prosjekt_id = scan.nextInt();
//				ProsjektInfo p9999 = pieao.finnProsjektInfoMedAnsattIdOgProsjektId(ansatt_id, prosjekt_id);
//				System.out.println(pieao.getProsjektInfo(p9999.getProsjektInfoId()));
//				break;
			case 11: 
				avslutt = 1;
				break;
			default:
				break;
			}	
		}
	}
}
