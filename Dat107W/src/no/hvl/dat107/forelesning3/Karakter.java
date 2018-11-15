package no.hvl.dat107.forelesning3;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Karakter", schema = "hello_jpa")
public class Karakter {
	@Id
	private int karNr;
	private String kursKode;
	private LocalDate eksDato;
	private String karakter;
	@ManyToOne
	@JoinColumn(name = "Studnr", referencedColumnName = "Studnr")
	private Vitnemal vitnemal;
	@OneToMany(mappedBy = "vitnemal")
	private List<Karakter> karakterer;
	
	public Karakter(String kursKode, LocalDate eksDato, String karakter, Vitnemal vitnemal, List<Karakter> karakterer) {
		super();
		this.kursKode = kursKode;
		this.eksDato = eksDato;
		this.karakter = karakter;
		this.vitnemal = vitnemal;
		this.karakterer = karakterer;
	}
	public void addKarakter(String karakter) {
		//karakterer.add(karakter);
	}
	@Override
	public String toString() {
		return "Karakter [karNr=" + karNr + ", kursKode=" + kursKode + ", eksDato=" + eksDato + ", karakter=" + karakter
				+ ", vitnemal=" + vitnemal + ", karakterer=" + karakterer + "]";
	}
	
}
