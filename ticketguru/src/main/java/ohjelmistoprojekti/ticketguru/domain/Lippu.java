package ohjelmistoprojekti.ticketguru.domain;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Lippu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lippu_id")
	private Long lippuId;
	@NotNull(message = "Lippu tarvitsee osto päivämäärän")
	private LocalDateTime ostoPvm;
	@NotBlank(message = "Lipussa on oltava tarkistuskoodi")
	private String tarkistuskoodi;
	@NotNull(message = "Lipussa ei ole hintaa")
	private double hinta;

	@ManyToOne
	@JoinColumn(name = "tapahtuma_id")
	private Tapahtuma tapahtuma;

	// Tuodaan lipputyyppi tänne
	@ManyToOne
	@JoinColumn(name = "lipputyyppi_id")
	private Lipputyyppi lipputyyppi;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "myyntitapahtuma_id")
	private Myyntitapahtuma myyntitapahtuma;
	private ZonedDateTime kayttoPvm;

	// Konstruktori

	public Lippu() {
	}

	public Lippu(Tapahtuma tapahtuma, Myyntitapahtuma myyntitapahtuma, Lipputyyppi lipputyyppi, double hinta) {
		this.tapahtuma = tapahtuma;
		this.myyntitapahtuma = myyntitapahtuma;
		this.lipputyyppi = lipputyyppi;
		// Hinta on laskettu ennen lipun muodostamista: tapahtuman perushinta *
		// lipputyypin hintakerroin
		this.hinta = hinta;
		this.ostoPvm = LocalDateTime.now();
		this.tarkistuskoodi = generoiTarkistuskoodi();
	}

	private String generoiTarkistuskoodi() {
		// Generoi satunnainen UUID ja muuntaa sen merkkijonoksi
		return UUID.randomUUID().toString();
	}

	// get+set

	public Long getLippuId() {
		return lippuId;
	}

	public void setLippuId(Long lippuId) {
		this.lippuId = lippuId;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	public Myyntitapahtuma getMyyntitapahtuma() {
		return myyntitapahtuma;
	}

	public void setMyyntitapahtuma(Myyntitapahtuma myyntitapahtuma) {
		this.myyntitapahtuma = myyntitapahtuma;
	}

	public Tapahtuma getTapahtuma() {
		return tapahtuma;
	}

	public void setTapahtuma(Tapahtuma tapahtuma) {
		this.tapahtuma = tapahtuma;
	}

	public String getTarkistuskoodi() {
		return tarkistuskoodi;
	}

	public void setTarkistuskoodi(String tarkistuskoodi) {
		this.tarkistuskoodi = tarkistuskoodi;
	}

	public Lipputyyppi getLipputyyppi() {
		return lipputyyppi;
	}

	public void setLipputyyppi(Lipputyyppi lipputyyppi) {
		this.lipputyyppi = lipputyyppi;
	}

	public LocalDateTime getOstoPvm() {
		return ostoPvm;
	}

	public void setOstoPvm(LocalDateTime ostoPvm) {
		this.ostoPvm = ostoPvm;
	}

	public ZonedDateTime getKayttoPvm() {
		return kayttoPvm;
	}

	public void setKayttoPvm(ZonedDateTime kayttoPvm) {
		this.kayttoPvm = kayttoPvm;
	}

	@Override
	public String toString() {
		return "Lippu [lippuId=" + lippuId + ", ostoPvm=" + ostoPvm + ", tarkistuskoodi=" + tarkistuskoodi + ", hinta="
				+ hinta + ", tapahtuma=" + tapahtuma + ", lipputyyppi=" + lipputyyppi + ", myyntitapahtuma="
				+ myyntitapahtuma + ", kayttoPvm=" + kayttoPvm + "]";
	}

	

}
