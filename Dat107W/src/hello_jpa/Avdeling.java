package hello_jpa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Avdeling")
@Table(name = "Avdeling", schema = "hello_jpa")
public class Avdeling {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "avdeling_id", updatable = false, nullable = false)
	private int avdeling_id;
	private String avdNavn;
	@OneToOne
	@JoinColumn(name = "sjef_hvem", referencedColumnName = "Ansatt_id")
	private Ansatt sjef_Hvem;
	
	@OneToMany(mappedBy = "avdeling_id", fetch = FetchType.EAGER)
	private List<Ansatt> ansatte;
	
	public List<Ansatt> getAnsatte() {
		return ansatte;
	}

	public void setAnsatte(List<Ansatt> ansatte) {
		this.ansatte = ansatte;
	}

	public Avdeling(String avdelingNavn, Ansatt sjefHvem) {
		this.avdeling_id = 0;
		this.avdNavn = avdelingNavn;
		this.sjef_Hvem = sjefHvem;
	}

	public Avdeling() {

	}

	public int getAvdeling_id() {
		return avdeling_id;
	}

	public String getAvdelingNavn() {
		return avdNavn;
	}

	public void setAvdelingNavn(String avdelingNavn) {
		this.avdNavn = avdelingNavn;
	}

	public Ansatt getSjefHvem() {
		return sjef_Hvem;
	}

	public void setSjefHvem(Ansatt sjefHvem) {
		this.sjef_Hvem = sjefHvem;
	}

	@Override
	public String toString() {
		return "Avdeling [avdeling_id=" + avdeling_id + ", avdelingNavn=" + avdNavn + ", sjefHvem=" + sjef_Hvem + "]";
	}

}
