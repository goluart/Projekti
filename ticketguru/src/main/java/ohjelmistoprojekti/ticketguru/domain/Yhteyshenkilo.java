package ohjelmistoprojekti.ticketguru.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Yhteyshenkilo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "yht_hlo_id")
	private Long yhtHloId;
	@Size(max = 20, message = "Etunimi voi olla 20 merkkiä pitkä")
	@NotEmpty(message = "Anna etunimi")
	private String etunimi;
	@Size(max = 50, message = "Sukunimi voi olla 50 merkkiä pitkä")
	@NotEmpty(message = "Anna sukunimi")
	private String sukunimi;
	@Size(max = 100, message = "Sähköposti voi olla 100 merkkiä pitkä")
	@Email(message = "Tarkista sähköpostiosoitten muoto")
	@NotEmpty(message = "Anna sähköpostiosoite")
	private String sahkoposti;
	@Size(max = 20, message = "Puhelinnumero voi olla 20 merkkiä pitkä")
	@NotEmpty(message = "Anna puhelinnumero")
	@Pattern(regexp = "^\\+?[0-9]+$", message = "Anna puehlinnumero muodossa +358401234567 tai 0401234567")
	private String puhelin;
	@Size(max = 700, message = "Lisätiedon suurin sallittu merkkimäärä on 700")
	private String lisatieto;
	
	// Liittyy luokkiin Tapahtumapaikka ja Jarjestaja
	@ManyToOne
	@JoinColumn(name = "jarjestaja_id")
	private Jarjestaja jarjestaja;
	@ManyToOne
	@JoinColumn(name = "tapaikka_id")
	private Tapahtumapaikka tapahtumapaikka;

	public Yhteyshenkilo() {
		super();
	}

	public Yhteyshenkilo(String etunimi, String sukunimi, String sahkoposti, String puhelin, String lisatieto) {
		super();
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.sahkoposti = sahkoposti;
		this.puhelin = puhelin;
		this.lisatieto = lisatieto;
	}

	public Long getYhtHloId() {
		return yhtHloId;
	}

	public void setYhtHloId(Long yhtHloId) {
		this.yhtHloId = yhtHloId;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public String getSahkoposti() {
		return sahkoposti;
	}

	public void setSahkoposti(String sahkoposti) {
		this.sahkoposti = sahkoposti;
	}

	public String getPuhelin() {
		return puhelin;
	}

	public void setPuhelin(String puhelin) {
		this.puhelin = puhelin;
	}

	public String getLisatieto() {
		return lisatieto;
	}

	public void setLisatieto(String lisatieto) {
		this.lisatieto = lisatieto;
	}

	public Jarjestaja getJarjestaja() {
		return jarjestaja;
	}

	public void setJarjestaja(Jarjestaja jarjestaja) {
		this.jarjestaja = jarjestaja;
	}

	public Tapahtumapaikka getTapahtumapaikka() {
		return tapahtumapaikka;
	}

	public void setTapahtumapaikka(Tapahtumapaikka tapahtumapaikka) {
		this.tapahtumapaikka = tapahtumapaikka;
	}

	@Override
	public String toString() {
		return "Yhteyshenkilo [yhtHloId=" + yhtHloId + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi
				+ ", sahkoposti=" + sahkoposti + ", puhelin=" + puhelin + ", lisatieto=" + lisatieto + ", jarjestaja="
				+ jarjestaja + ", tapahtumapaikka=" + tapahtumapaikka + "]";
	}

}
