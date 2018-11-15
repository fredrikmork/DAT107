package no.hvl.dat107.forelesning3;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vitnemal", schema = "hello_jpa")
public class Vitnemal {
	@Id
	private int studNr;
	private LocalDate studieStart;
	private LocalDate studieSlutt;
	@Override
	public String toString() {
		return "Vitnemal [studNr=" + studNr + ", studieStart=" + studieStart + ", studieSlutt=" + studieSlutt + "]";
	}
	

}
