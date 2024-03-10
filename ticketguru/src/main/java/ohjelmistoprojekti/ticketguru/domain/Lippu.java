package ohjelmistoprojekti.ticketguru.domain;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Lippu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lippu_id")
	private Long lippuId;
	private LocalDateTime ostoPvm;
	private Date alkuPvm;
	private Date loppuPvm;
	private Date kayttoPvm;
	private String tarkistuskoodi;
	private double hinta;

	@ManyToOne
	@JoinColumn(name = "tapahtuma_id")
	private Tapahtuma tapahtuma;

	// Tuodaan lipputyyppi tänne
	@ManyToOne
	@JoinColumn(name = "lipputyyppi_id")
	private Lipputyyppi lipputyyppi;

	@ManyToOne
	@JoinColumn(name = "myyntitapahtuma_id")
	private Myyntitapahtuma myyntitapahtuma;

	// Konstruktori

	public Lippu() {
	}

	public Lippu(Tapahtuma tapahtuma, Lipputyyppi lipputyyppi, Myyntitapahtuma myyntitapahtuma, double hinta) {
		this.tapahtuma = tapahtuma;
		this.lipputyyppi = lipputyyppi;
		this.myyntitapahtuma = myyntitapahtuma;
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

	public Date getAlkuPvm() {
		return alkuPvm;
	}

	public void setAlkuPvm(Date alkuPvm) {
		this.alkuPvm = alkuPvm;
	}

	public Date getLoppuPvm() {
		return loppuPvm;
	}

	public void setLoppuPvm(Date loppuPvm) {
		this.loppuPvm = loppuPvm;
	}

	public Date getKayttoPvm() {
		return kayttoPvm;
	}

	public void setKayttoPvm(Date kayttoPvm) {
		this.kayttoPvm = kayttoPvm;
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

	@Override
	public String toString() {
		return "Lippu [lippuId=" + lippuId + ", ostoPvm=" + ostoPvm + ", alkuPvm=" + alkuPvm + ", loppuPvm=" + loppuPvm
				+ ", kayttoPvm=" + kayttoPvm + ", tarkistuskoodi=" + tarkistuskoodi + ", hinta=" + hinta
				+ ", tapahtuma=" + tapahtuma + ", lipputyyppi=" + lipputyyppi + ", myyntitapahtuma=" + myyntitapahtuma
				+ "]";
	}
}
