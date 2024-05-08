package ohjelmistoprojekti.ticketguru.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Tapahtumapaikka {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tapaikka_id")
	private Long tapaikkaId;
	@NotBlank(message = "Paikan nimi ei saa olla tyhjä")
	@Size(max = 100, message = "Paikan nimen maksimipituus on 100 merkkiä")
	@Column(name = "paikka_nimi")
	private String paikkaNimi;
	@Size(max = 150, message = "Osoitteen maksimipituus on 150 merkkiä")
	private String osoite;
	@Size(max = 500, message = "Kuvauksen maksimipituus on 500 merkkiä")
	private String kuvaus;
	@Pattern(regexp = "^[0-9]{7}-[0-9]$", message = "Y-tunnuksen tulee olla muodossa 1234567-8")
	private String ytunnus;
	@Email(message = "Sähköpostiosoitteen tulee olla kelvollinen")
	private String sposti;
	@Size(max = 500, message = "Lisätietojen maksimipituus on 500 merkkiä")
	private String lisatiedot;

	@JsonIgnoreProperties("tapahtumapaikka")
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "tapahtumapaikka")
	private List<Yhteyshenkilo> yhteyshenkilo;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "tapahtumapaikka")
	private List<Tapahtuma> tapahtuma;

	@ManyToOne
	@JsonIgnoreProperties("tapahtumapaikat")
	@JoinColumn(name = "postinumeroId")
	private Postitoimipaikka postitoimipaikka;

	public Tapahtumapaikka() {
	}

	public Tapahtumapaikka(String paikkaNimi) {
		this.paikkaNimi = paikkaNimi;
	}

	public Tapahtumapaikka(String paikkaNimi, String osoite, String kuvaus, String ytunnus, String sposti,
			String lisatiedot, List<Yhteyshenkilo> yhteyshenkilo, List<Tapahtuma> tapahtuma,
			Postitoimipaikka postitoimipaikka) {
		this.paikkaNimi = paikkaNimi;
		this.osoite = osoite;
		this.kuvaus = kuvaus;
		this.ytunnus = ytunnus;
		this.sposti = sposti;
		this.lisatiedot = lisatiedot;
		this.yhteyshenkilo = yhteyshenkilo;
		this.tapahtuma = tapahtuma;
		this.postitoimipaikka = postitoimipaikka;
	}

	public Long getTapaikkaId() {
		return tapaikkaId;
	}

	public void setTapaikkaId(Long tapaikkaId) {
		this.tapaikkaId = tapaikkaId;
	}

	public String getOsoite() {
		return osoite;
	}

	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	public String getYtunnus() {
		return ytunnus;
	}

	public void setYtunnus(String ytunnus) {
		this.ytunnus = ytunnus;
	}

	public String getSposti() {
		return sposti;
	}

	public void setSposti(String sposti) {
		this.sposti = sposti;
	}

	public String getLisatiedot() {
		return lisatiedot;
	}

	public void setLisatiedot(String lisatiedot) {
		this.lisatiedot = lisatiedot;
	}

	public List<Yhteyshenkilo> getYhteyshenkilo() {
		return yhteyshenkilo;
	}

	public void setYhteyshenkilo(List<Yhteyshenkilo> yhteyshenkilo) {
		this.yhteyshenkilo = yhteyshenkilo;
	}

	public List<Tapahtuma> getTapahtuma() {
		return tapahtuma;
	}

	public void setTapahtuma(List<Tapahtuma> tapahtuma) {
		this.tapahtuma = tapahtuma;
	}

	public Postitoimipaikka getPostitoimipaikka() {
		return postitoimipaikka;
	}

	public void setPostitoimipaikka(Postitoimipaikka postitoimipaikka) {
		this.postitoimipaikka = postitoimipaikka;
	}

	@Override
	public String toString() {
		return "Tapahtumapaikka [tapaikkaId=" + tapaikkaId + ", paikkaNimi=" + paikkaNimi + ", osoite=" + osoite
				+ ", kuvaus=" + kuvaus + ", ytunnus=" + ytunnus + ", sposti=" + sposti + ", lisatiedot=" + lisatiedot
				+ ", postitoimipaikka=" + postitoimipaikka + "]";
	}

	public String getPaikkaNimi() {
		return paikkaNimi;
	}

	public void setPaikkaNimi(String paikkaNimi) {
		this.paikkaNimi = paikkaNimi;
	}

}
