package ohjelmistoprojekti.ticketguru.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Asiakasryhma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "asryh_id")
	private Long asryhid;
	@NotBlank(message = "Asiakasryhmän nimi ei saa olla tyhjä")
	@Size(max = 20, message = "Asiakasryhmän nimen maksimipituus on 20 merkkiä")
	private String nimi;
	@Size(max = 100, message = "Kuvauksen maksimipituus on 100 merkkiä")
	private String kuvaus;
	// private boolean tarkista;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "asiakasryhma")
	@JsonIgnore
	List<Lipputyyppi> lipputyypit;

	public Asiakasryhma() {
		super();
	}

	// Konstruktori
	public Asiakasryhma(String nimi, String kuvaus) {
		this.nimi = nimi;
		this.kuvaus = kuvaus;
	}

	// get+set
	public Long getId() {
		return asryhid;
	}

	public void setId(Long id) {
		this.asryhid = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	// public boolean isTarkista() {
	// return tarkista;
	// }

	// public void setTarkista(boolean tarkista) {
	// this.tarkista = tarkista;
	// }

	// toString
	@Override
	public String toString() {
		return "Asiakasryhma [id=" + asryhid + ", nimi=" + nimi + ", kuvaus=" + kuvaus + "]";
	}

}
