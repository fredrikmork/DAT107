package no.hvl.dat107.forelesning3;

public class Main {

    public static void main(String[] args) {
        
        //Opprette hjelpeobjekt for databasetilgang
        VitnemalEAO vitnemalEAO = new VitnemalEAO();
        //Hent ut og skriv ut ???(en-siden) med PK = ???
        Vitnemal vitnemal = vitnemalEAO.finnEnPaaEnsidenPaaPK(123);
        System.out.println(vitnemal);
        //Hent ut og skriv ut ???(mange-siden) med unik egenskap (som ikke er PK) = ???

        //Registrer eller oppdater en entitet p� mange-siden
        
        //For � sjekke at registrering er gjort:
        //Hent ut og skriv ut ???(en-siden) med PK = ???
    }

}
