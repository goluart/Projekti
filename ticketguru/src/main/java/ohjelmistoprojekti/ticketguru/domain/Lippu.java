package ohjelmistoprojekti.ticketguru.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Lippu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private Date ostoPvm;
    private Date alkuPvm;
    private Date loppuPvm;
    private Date kayttoPvm;
    private Long tarkistuskoodi;

    // Tuodaan lipputyyppi tänne
    @ManyToOne
    @JoinColumn(name = "lipputyyppi_id")
    private Lipputyyppi lippuTyyppi;

    // Konstruktori
    public Lippu(Long id, Date ostoPvm, Date alkuPvm, Date loppuPvm, Date kayttoPvm, Long tarkistuskoodi,
            Lipputyyppi lippuTyyppi) {
        this.id = id;
        this.ostoPvm = ostoPvm;
        this.alkuPvm = alkuPvm;
        this.loppuPvm = loppuPvm;
        this.kayttoPvm = kayttoPvm;
        this.tarkistuskoodi = tarkistuskoodi;
        this.lippuTyyppi = lippuTyyppi;
    }

    // get+set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Lipputyyppi getLippuTyyppi() {
        return lippuTyyppi;
    }

    public void setLippuTyyppi(Lipputyyppi lippuTyyppi) {
        this.lippuTyyppi = lippuTyyppi;
    }

    // toString
    @Override
    public String toString() {
        return "Lippu [id=" + id + ", ostoPvm=" + ostoPvm + ", alkuPvm=" + alkuPvm + ", loppuPvm=" + loppuPvm
                + ", kayttoPvm=" + kayttoPvm + ", tarkistuskoodi=" + tarkistuskoodi + ", lippuTyyppi=" + lippuTyyppi
                + "]";
    }
}
