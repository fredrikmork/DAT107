package no.hvl.dat107.forelesning4;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Todoliste", schema = "todo_schema")
public class Todoliste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listeId;
    private String navn;
    
    @OneToMany(
            mappedBy = "liste") 
    private List<Todo> todos;
    
    public Todoliste() {
    }
    
    public Todoliste(String navn) {
        this.navn = navn;
    }

    public int getListeId() {
        return listeId;
    }
    
    public void setNavn(String navn) {
        this.navn = navn;
    }
    
    @Override
    public String toString() {
        return "Todoliste [listeId=" + listeId + ", navn=" + navn + ", todos=" + todos + "]";
    }

    
}
