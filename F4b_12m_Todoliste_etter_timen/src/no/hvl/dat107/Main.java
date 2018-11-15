package no.hvl.dat107;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        TodolisteEAO todolisteEAO = new TodolisteEAO();
        
        Todoliste husarbeid = new Todoliste("Husarbeid");
        
        Todo rydde = new Todo("Rydde");
        Todo vaskeOpp = new Todo("Vaske opp");
        Todo stovsuge = new Todo("St�vsuge");
        Todo vaskeVinduer = new Todo("Vaske vinduer");
        
        husarbeid.leggTil(rydde);
        husarbeid.leggTil(vaskeOpp);
        husarbeid.leggTil(stovsuge);
        
        todolisteEAO.lagreListe(husarbeid);
        int id = husarbeid.getListeId();
        System.out.println("\n\nEtter lagreListe()");
        System.out.println(todolisteEAO.finnListeNr(id));
        
        husarbeid.setNavn("G�y husarbeid");
        husarbeid.fjern(vaskeOpp);         
        husarbeid.leggTil(vaskeVinduer);   
        stovsuge.setTekst("G�y st�vsuging");
        
        todolisteEAO.oppdaterListe(husarbeid);
        System.out.println("\n\nEtter oppdaterListe()");
        System.out.println(todolisteEAO.finnListeNr(id));
        
        Todoliste t = todolisteEAO.finnListePaaNavn("G�y husarbeid");
        System.out.println("\n\nfinnListePaaNavn(\"G�y husarbeid\")");
        System.out.println(t);
        
        List<Todo> todos = todolisteEAO.finnTodosIListe(husarbeid);
        System.out.println("\n\nfinnTodosIListe(husarbeid)");
        System.out.println(todos);
        
        todolisteEAO.slettListe(husarbeid);
        System.out.println("\n\nEtter slettListe()");
        System.out.println(todolisteEAO.finnListeNr(id));
    }
}






