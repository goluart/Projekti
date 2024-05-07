package ohjelmistoprojekti.ticketguru.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name = "jarjestaja_id")
	private Jarjestaja jarjestaja;

	@ManyToOne
	@JoinColumn(name = "tapaikka_id")
	private Tapahtumapaikka tapahtumapaikka;

    // Myöhemmin Yhteyshenkilo OneToMany Tapahtumapaikka
    // Liittyy luokkiin Tapahtumapaikka ja Jarjestaja

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
