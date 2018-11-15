package hello_jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prosjektinfo", schema = "hello_jpa")
public class ProsjektInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prosjektInfoId;
	@ManyToOne
	@JoinColumn(name = "prosjekt_id", referencedColumnName = "prosjekt_id")
	private Prosjekt prosjekt_id;
	@ManyToOne
	@JoinColumn(name = "ansatt_id", referencedColumnName = "ansatt_id")
	private Ansatt ansatt_id;
	private String rolle;
	private boolean iGang;
	private int antallTimer;

	public ProsjektInfo(Prosjekt prosjekt_id, Ansatt ansatt_id, String rolle, boolean iGang) {
		this.prosjektInfoId = 0;
		this.prosjekt_id = prosjekt_id;
		this.ansatt_id = ansatt_id;
		this.rolle = rolle;
		this.iGang = iGang;
		this.antallTimer = 0;
	}

	public ProsjektInfo() {

	}

	public int getProsjektInfoId() {
		return prosjektInfoId;
	}

	public void setProsjektInfoId(int prosjektInfoId) {
		this.prosjektInfoId = prosjektInfoId;
	}

	public Prosjekt getProsjekt_id() {
		return prosjekt_id;
	}

	public void setProsjekt_id(Prosjekt prosjekt_id) {
		this.prosjekt_id = prosjekt_id;
	}

	public Ansatt getAnsatt_id() {
		return ansatt_id;
	}

	public void setAnsatt_id(Ansatt ansatt_id) {
		this.ansatt_id = ansatt_id;
	}

	public String getRolle() {
		return rolle;
	}

	public void setRolle(String rolle) {
		this.rolle = rolle;
	}

	public boolean isiGang() {
		return iGang;
	}

	public void setiGang(boolean iGang) {
		this.iGang = iGang;
	}

	public int getAntallTimer() {
		return antallTimer;
	}

	public void setAntallTimer(int antallTimer) {
		this.antallTimer = antallTimer;
	}

	@Override
	public String toString() {
		return "ProsjektInfo [prosjektInfoId=" + prosjektInfoId + ", prosjekt_id=" + prosjekt_id + ", ansatt_id="
				+ ansatt_id + ", rolle=" + rolle + ", iGang=" + iGang + ", antallTimer=" + antallTimer + "]";
	}

}
