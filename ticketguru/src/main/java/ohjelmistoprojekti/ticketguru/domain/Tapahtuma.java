package ohjelmistoprojekti.ticketguru.domain;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Tapahtuma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tapahtuma_id")
    private Long tapahtumaId;
    @Column(name = "tapahtuma_nimi")
    private String tapahtumaNimi;
    @Column(name = "luonti_pvm")
    private ZonedDateTime luontiPvm;
    @Column(name = "alkaa_pvm")
    private LocalDateTime alkaaPvm;
    @Column(name = "paattyy_pvm")
    private LocalDateTime paattyyPvm;
    private String kuvaus;
    private double perushinta;
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name="tapaikka_id")
    private Tapahtumapaikka tapahtumapaikka;
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name="jarjestaja_id")
    private Jarjestaja jarjestaja;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "tapahtuma_lippu", joinColumns = { @JoinColumn(name = "tapahtuma_id") }, inverseJoinColumns = { @JoinColumn( name = "lippu_id" ) })
    private Set<Lippu> liput = new HashSet<Lippu>(0);
    
    public Tapahtuma() {
        super();
        luontiPvm = ZonedDateTime.now(ZoneId.of("Europe/Helsinki"));
    }

    public Long getTapahtumaId() {
        return tapahtumaId;
    }

    public void setTapahtumaId(Long tapahtumaId) {
        this.tapahtumaId = tapahtumaId;
    }

    public String getTapahtumaNimi() {
        return tapahtumaNimi;
    }

    public void setTapahtumaNimi(String tapahtumaNimi) {
        this.tapahtumaNimi = tapahtumaNimi;
    }

    public ZonedDateTime getLuontiPvm() {
        return luontiPvm;
    }

    public void setLuontiPvm(ZonedDateTime luontiPvm) {
        this.luontiPvm = luontiPvm;
    }

    public LocalDateTime getAlkaaPvm() {
        return alkaaPvm;
    }

    public void setAlkaaPvm(LocalDateTime alkaaPvm) {
        this.alkaaPvm = alkaaPvm;
    }

    public LocalDateTime getPaattyyPvm() {
        return paattyyPvm;
    }

    public void setPaattyyPvm(LocalDateTime paattyyPvm) {
        this.paattyyPvm = paattyyPvm;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public double getPerushinta() {
        return perushinta;
    }

    public void setPerushinta(double perushinta) {
        this.perushinta = perushinta;
    }

    public Tapahtumapaikka getTapahtumapaikka() {
        return tapahtumapaikka;
    }

    public void setTapahtumapaikka(Tapahtumapaikka tapahtumapaikka) {
        this.tapahtumapaikka = tapahtumapaikka;
    }

    public Jarjestaja getJarjestaja() {
        return jarjestaja;
    }

    public void setJarjestaja(Jarjestaja jarjestaja) {
        this.jarjestaja = jarjestaja;
    }

    public Set<Lippu> getLiput() {
        return liput;
    }

    public void setLiput(Set<Lippu> liput) {
        this.liput = liput;
    }

    @Override
    public String toString() {
        return "Tapahtuma [tapahtumaId=" + tapahtumaId + ", tapahtumaNimi=" + tapahtumaNimi + ", luontiPvm=" + luontiPvm
                + ", alkaaPvm=" + alkaaPvm + ", paattyyPvm=" + paattyyPvm + ", kuvaus=" + kuvaus + ", perushinta="
                + perushinta + ", tapahtumapaikka=" + tapahtumapaikka + ", jarjestaja=" + jarjestaja + "]";
    }
   
    
}
