package ohjelmistoprojekti.ticketguru.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Kayttaja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hlo_id")
	private Long hloId;
	private String salasana;
	private String snimi;
	private String enimi;
	private String lisatiedot;

	@ManyToOne
	@JoinColumn(name = "rooli_id")
	private Rooli rooli;

	public Kayttaja() {
	}

	public Kayttaja(String salasana, String snimi, String enimi, String lisatiedot, Rooli rooli) {
		super();
		this.salasana = salasana;
		this.snimi = snimi;
		this.enimi = enimi;
		this.lisatiedot = lisatiedot;
		this.rooli = rooli;
	}

	public Long getHloId() {
		return hloId;
	}

	public void setHloId(Long hloId) {
		this.hloId = hloId;
	}

	public String getSalasana() {
		return salasana;
	}

	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}

	public String getSnimi() {
		return snimi;
	}

	public void setSnimi(String snimi) {
		this.snimi = snimi;
	}

	public String getEnimi() {
		return enimi;
	}

	public void setEnimi(String enimi) {
		this.enimi = enimi;
	}

	public String getLisatiedot() {
		return lisatiedot;
	}

	public void setLisatiedot(String lisatiedot) {
		this.lisatiedot = lisatiedot;
	}

	public Rooli getRooli() {
		return rooli;
	}

	public void setRooli(Rooli rooli) {
		this.rooli = rooli;
	}

	@Override
	public String toString() {
		return "Kayttaja [hloId=" + hloId + ", salasana=" + salasana + ", snimi=" + snimi + ", enimi=" + enimi
				+ ", lisatiedot=" + lisatiedot + ", rooli=" + rooli + "]";
	}

}
