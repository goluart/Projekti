package ohjelmistoprojekti.ticketguru.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Rooli {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rooli_id")
	private Long rooliId;
	@NotBlank(message = "Roolin nimi ei voi olla tyhjä")
	@Column(name = "rooli_nimi")
	private String rooliNimi;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rooli")
	@JsonIgnoreProperties("rooli")
	private List<Kayttaja> kayttajat;

	public Rooli() {
	}

	public Rooli(String rooliNimi) {
		super();
		this.rooliNimi = rooliNimi;
	}

	public Long getRooliId() {
		return rooliId;
	}

	public void setRooliId(Long rooliId) {
		this.rooliId = rooliId;
	}

	public String getRooliNimi() {
		return rooliNimi;
	}

	public void setRooliNimi(String rooliNimi) {
		this.rooliNimi = rooliNimi;
	}

	public List<Kayttaja> getKayttajat() {
		return kayttajat;
	}

	public void setKayttajat(List<Kayttaja> kayttajat) {
		this.kayttajat = kayttajat;
	}

	@Override
	public String toString() {
		return "Rooli [rooliId=" + rooliId + ", rooliNimi=" + rooliNimi + "]";
	}

}
