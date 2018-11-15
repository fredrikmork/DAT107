package hello_jpa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Prosjekt")
@Table(name = "Prosjekt", schema = "hello_jpa")
public class Prosjekt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prosjekt_id", updatable = false, nullable = false)
	private int prosjekt_id;
	private String prosjektNavn;
	private String prosjektBeskrivelse;
	
//	@OneToMany(mappedBy = "ansatt_id", fetch = FetchType.EAGER)
//	private List<Ansatt> ansatte;

	public Prosjekt(String prpsjektNavn, String prosjektBeskrivelse) {
		this.prosjekt_id = 0;
		this.prosjektNavn = prpsjektNavn;
		this.prosjektBeskrivelse = prosjektBeskrivelse;
	}
	
	

//	public List<Ansatt> getAnsatte() {
//		return ansatte;
//	}
//
//
//
//	public void setAnsatte(List<Ansatt> ansatte) {
//		this.ansatte = ansatte;
//	}



	public void setProsjekt_id(int prosjekt_id) {
		this.prosjekt_id = prosjekt_id;
	}



	public Prosjekt() {

	}

	public int getProsjekt_id() {
		return prosjekt_id;
	}

	public String getProsjektNavn() {
		return prosjektNavn;
	}

	public void setProsjektNavn(String prosjektNavn) {
		this.prosjektNavn = prosjektNavn;
	}

	public String getProsjektBeskrivelse() {
		return prosjektBeskrivelse;
	}

	public void setProsjektBeskrivelse(String prosjektBeskrivelse) {
		this.prosjektBeskrivelse = prosjektBeskrivelse;
	}

	@Override
	public String toString() {
		return "Prosjekt [prosjekt_id=" + prosjekt_id + ", prosjektNavn=" + prosjektNavn + ", prosjektBeskrivelse="
				+ prosjektBeskrivelse + "]";
	}

}
