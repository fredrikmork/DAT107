package no.hvl.dat107;

import no.hvl.dat107.eao.AnsattEAO;
import no.hvl.dat107.eao.ProsjektEAO;
import no.hvl.dat107.entity.Ansatt;
import no.hvl.dat107.entity.Prosjekt;

public class Main {

    public static void main(String[] args) {
        
        AnsattEAO ansattEAO = new AnsattEAO();
        ProsjektEAO prosjektEAO = new ProsjektEAO();
        
        Ansatt a2 = ansattEAO.finnAnsattMedId(2);
        a2.skrivUtMedProsjekter();

        Prosjekt p2 = prosjektEAO.finnProsjektMedId(2);
        p2.skrivUtMedAnsatte();

        Prosjekt p3 = prosjektEAO.finnProsjektMedId(3);
        p3.skrivUtMedAnsatte();

        ansattEAO.registrerProsjektdeltagelse(a2, p3);
        a2 = ansattEAO.finnAnsattMedId(2);
        p3 = prosjektEAO.finnProsjektMedId(3);
        a2.skrivUtMedProsjekter();
        p3.skrivUtMedAnsatte();
        
        ansattEAO.slettProsjektdeltagelse(a2, p3);
        a2 = ansattEAO.finnAnsattMedId(2);
        p3 = prosjektEAO.finnProsjektMedId(3);
        a2.skrivUtMedProsjekter();
        p3.skrivUtMedAnsatte();
    }

}
