package ohjelmistoprojekti.ticketguru.domain;

import java.time.ZonedDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tarkastus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tarkastusId;
    private ZonedDateTime kayttoPvm;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "lipputyyppiId")
    private Lipputyyppi lipputyyppi;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "lippuId")
    private Lippu lippu;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "tapahtumaId")
    private Tapahtuma tapahtuma;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "tapaikkaId")
    private Tapahtumapaikka tapahtumapaikka;

    public Tarkastus() {
        super();
        this.kayttoPvm = null;
        this.lipputyyppi = null;
        this.lippu = null;
        this.tapahtuma = null;
        this.tapahtumapaikka = null;
    }

    public Tarkastus(ZonedDateTime kayttoPvm, Lipputyyppi lipputyyppi, Lippu lippu,
            Tapahtuma tapahtuma, Tapahtumapaikka tapahtumapaikka) {
        super();
        this.kayttoPvm = kayttoPvm;
        this.lipputyyppi = lipputyyppi;
        this.lippu = lippu;
        this.tapahtuma = tapahtuma;
        this.tapahtumapaikka = tapahtumapaikka;
    }

    public Long getTarkastusId() {
        return tarkastusId;
    }

    public void setTarkastusId(Long tarkastusId) {
        this.tarkastusId = tarkastusId;
    }

    public ZonedDateTime getKayttoPvm() {
        return kayttoPvm;
    }

    public void setKayttoPvm(ZonedDateTime kayttoPvm) {
        this.kayttoPvm = kayttoPvm;
    }

    public Lipputyyppi getLipputyyppi() {
        return lipputyyppi;
    }

    public void setLipputyyppi(Lipputyyppi lipputyyppi) {
        this.lipputyyppi = lipputyyppi;
    }

    public Lippu getLippu() {
        return lippu;
    }

    public void setLippu(Lippu lippu) {
        this.lippu = lippu;
    }

    public Tapahtuma getTapahtuma() {
        return tapahtuma;
    }

    public void setTapahtuma(Tapahtuma tapahtuma) {
        this.tapahtuma = tapahtuma;
    }

    public Tapahtumapaikka getTapahtumapaikka() {
        return tapahtumapaikka;
    }

    public void setTapahtumapaikka(Tapahtumapaikka tapahtumapaikka) {
        this.tapahtumapaikka = tapahtumapaikka;
    }

    @Override
    public String toString() {
        return "Tarkastus [tarkastusId=" + tarkastusId + ", kayttoPvm=" + kayttoPvm + ", lipputyyppi=" + lipputyyppi
                + ", lippu=" + lippu + ", tapahtuma=" + tapahtuma + ", tapahtumapaikka=" + tapahtumapaikka + "]";
    }

}
