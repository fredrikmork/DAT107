package hello_jpa;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "ansatt")
@Table(name = "ansatt", schema = "hello_jpa")
// @NamedQuery(name = "hentAllePersoner", query ="SELECT p FROM Person p")
public class Ansatt {
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ansatt_id", updatable = false, nullable = false)
	private int ansatt_id;
	@Column(name = "brukernavn", updatable = true, nullable = false, unique = true)
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private Date dato;
	private String stilling;
	private int manedslonn;
	
	
	
	@ManyToOne
	@JoinColumn(name = "Avdeling_id", referencedColumnName = "Avdeling_id")
	private Avdeling avdeling_id;

	public Ansatt(String brukernavn, String fornavn, String etternavn, Date dato, String stilling, int manedslonn, Avdeling avdeling_id) {
		this.ansatt_id = 0;
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.dato = dato;
		this.stilling = stilling;
		this.manedslonn = manedslonn;
		this.avdeling_id = avdeling_id;
	}

	public Ansatt() {

	}

	// Getters and setters for feltvariablene
	public int getAnsatt_id() {
		return ansatt_id;
	}
	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public Date getDato() {
		return dato;
	}

	public void setDato(Date dato) {
		this.dato = dato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public int getmanedslonn() {
		return manedslonn;
	}

	public void setmanedslonn(int manedslonn) {
		this.manedslonn = manedslonn;
	}

	public Avdeling getAvdeling_id() {
		return avdeling_id;
	}

	public void setAvdeling_id(Avdeling avdeling_id) {
		this.avdeling_id = avdeling_id;
	}

	@Override
	public String toString() {
		return "Ansatt [ansatt_id=" + ansatt_id + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn="
				+ etternavn + ", dato=" + dato + ", stilling=" + stilling + ", manedslonn=" + manedslonn
				+ ", avdeling_id="  + "]\n";
	}

}
