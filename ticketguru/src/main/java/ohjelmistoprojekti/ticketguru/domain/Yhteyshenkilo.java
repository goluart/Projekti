package ohjelmistoprojekti.ticketguru.domain;

import java.util.List;

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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Yhteyshenkilo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "yht_hlo_id")
	private Long yhtHloId;
	@NotEmpty(message = "Anna etunimesi")
	private String etunimi;
	@NotEmpty(message = "Anna sukunimesi")
	private String sukunimi;
	@NotEmpty(message = "Anna sähköpostiosoitteesi")
	private String sahkoposti;
	@NotEmpty(message = "Anna puhelinnumero")
	@Pattern(regexp = "[0-9]+", message = "Anna numero ilman välilyöntejä tai erikoismerkkejä")
	private String puhelin;
	@Size(max = 700, message = "Suurin sallittu merkkimäärä on 700")
	private String lisatieto;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "yhteyshenkilo")
	@JsonIgnoreProperties("yhteyshenkilo")
	private List<Jarjestaja> jarjestajat;

	@ManyToOne
	@JsonIgnoreProperties("yhteyshenkilo")
	@JoinColumn(name = "tapaikkaId")
	private Tapahtumapaikka tapahtumapaikka;

	// Myöhemmin Yhteyshenkilo OneToMany Tapahtumapaikka
	// Liittyy luokkiin Tapahtumapaikka ja Jarjestaja
	
	public Yhteyshenkilo() {
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

	public List<Jarjestaja> getJarjestajat() {
		return jarjestajat;
	}

	public void setJarjestajat(List<Jarjestaja> jarjestajat) {
		this.jarjestajat = jarjestajat;
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
				+ ", sahkoposti=" + sahkoposti + ", puhelin=" + puhelin + ", lisatieto=" + lisatieto + ", jarjestajat="
				+ jarjestajat + ", tapahtumapaikka=" + tapahtumapaikka + "]";
	}

}
