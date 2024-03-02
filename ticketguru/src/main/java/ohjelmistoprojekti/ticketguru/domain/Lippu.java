package ohjelmistoprojekti.ticketguru.domain;

import java.util.Date;

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

    private Date ostoPvm;
    private Date alkuPvm;
    private Date loppuPvm;
    private Date kayttoPvm;
    private Long tarkistuskoodi;
    private double hinta;

    // Tuodaan lipputyyppi tänne
    @ManyToOne
    @JoinColumn(name = "tapahtuma_id")
    private Tapahtuma tapahtuma;

    @ManyToOne
    @JoinColumn(name = "lipputyyppi_id")
    private Lipputyyppi lipputyyppi;
    
    @ManyToOne
    @JoinColumn(name = "myyntitapahtuma_id")
    private Myyntitapahtuma myyntitapahtuma;
    
    // Konstruktori
    
    public Lippu() {
        super();
    }
    
    public Lippu(Date ostoPvm, Date alkuPvm, Date loppuPvm, Date kayttoPvm, Long tarkistuskoodi,
    Tapahtuma tapahtuma, Lipputyyppi lipputyyppi, Myyntitapahtuma myyntitapahtuma, double hinta) {
        this.ostoPvm = ostoPvm;
        this.alkuPvm = alkuPvm;
        this.loppuPvm = loppuPvm;
        this.kayttoPvm = kayttoPvm;
        this.tarkistuskoodi = tarkistuskoodi;
        this.tapahtuma = tapahtuma;
        this.lipputyyppi = lipputyyppi;
        this.myyntitapahtuma = myyntitapahtuma;
        this.hinta = hinta;
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
    
    public Date getOstoPvm() {
        return ostoPvm;
    }

    public void setOstoPvm(Date ostoPvm) {
        this.ostoPvm = ostoPvm;
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

    public Long getTarkistuskoodi() {
        return tarkistuskoodi;
    }

    public void setTarkistuskoodi(Long tarkistuskoodi) {
        this.tarkistuskoodi = tarkistuskoodi;
    }

    public Tapahtuma getTapahtuma() {
        return tapahtuma;
    }

    public void setTapahtuma(Tapahtuma tapahtuma) {
        this.tapahtuma = tapahtuma;
    }

    @Override
    public String toString() {
        return "Lippu [lippuId=" + lippuId + ", ostoPvm=" + ostoPvm + ", alkuPvm=" + alkuPvm + ", loppuPvm=" + loppuPvm
                + ", kayttoPvm=" + kayttoPvm + ", tarkistuskoodi=" + tarkistuskoodi + ", hinta=" + hinta
                + ", tapahtuma=" + tapahtuma + ", myyntitapahtuma=" + myyntitapahtuma + "]";
    }

    public Lipputyyppi getLipputyyppi() {
        return lipputyyppi;
    }

    public void setLipputyyppi(Lipputyyppi lipputyyppi) {
        this.lipputyyppi = lipputyyppi;
    }

    

}
