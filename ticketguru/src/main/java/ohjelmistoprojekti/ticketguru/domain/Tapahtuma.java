package ohjelmistoprojekti.ticketguru.domain;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.micrometer.common.lang.NonNull;
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
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Tapahtuma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tapahtuma_id")
    @NonNull
    private Long tapahtumaId;
    @NotEmpty(message = "Tapahtuma tarvitsee nimen")
    @Column(name = "tapahtuma_nimi")
    private String tapahtumaNimi;
    @Column(name = "luonti_pvm")
    private ZonedDateTime luontiPvm;
    @Future(message = "Tapahtumia voi luoda vain tulevaisuuten")
    @Column(name = "alkaa_pvm")
    private ZonedDateTime alkaaPvm;
    @Future(message = "Tapahtumia voi luoda vain tulevaisuuteen")
    @Column(name = "paattyy_pvm")
    private ZonedDateTime paattyyPvm;
    private String kuvaus;
    @Min(value = 1, message = "Myytäviä lippuja on oltava enemmän kuin 0")
    private int max_lippuja;
    @Min(value = 1, message = "Anna tapahtuman lipuille perushinta")
    private double perushinta;

    // @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "tapaikka_id")
    private Tapahtumapaikka tapahtumapaikka;

    // @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "jarjestaja_id")
    private Jarjestaja jarjestaja;

    // Tapahtuman ja lipun välinen suhde muutettu. Tähän ei tule enää välitaulua.
    @JsonIgnore
    @OneToMany(mappedBy = "tapahtuma")
    private Set<Lippu> liput = new HashSet<Lippu>();

    // Lipputyyppi
    // @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tapahtuma_lipputyyppi", joinColumns = @JoinColumn(name = "tapahtuma_id"), inverseJoinColumns = @JoinColumn(name = "lipputyyppi_id"))
    private Set<Lipputyyppi> lipputyypit = new HashSet<>();

    public Tapahtuma() {
        super();
        luontiPvm = ZonedDateTime.now(ZoneId.of("Europe/Helsinki"));
    }

    public Tapahtuma(String tapahtumaNimi, ZonedDateTime alkaaPvm,
            ZonedDateTime paattyyPvm, String kuvaus, double perushinta, Tapahtumapaikka tapahtumapaikka,
            Jarjestaja jarjestaja, Set<Lipputyyppi> lipputyypit, int max_lippuja) {
        this.tapahtumaNimi = tapahtumaNimi;
        this.alkaaPvm = alkaaPvm;
        this.paattyyPvm = paattyyPvm;
        this.kuvaus = kuvaus;
        this.perushinta = perushinta;
        this.tapahtumapaikka = tapahtumapaikka;
        this.jarjestaja = jarjestaja;
        this.lipputyypit = lipputyypit;
        this.max_lippuja = max_lippuja;
        this.luontiPvm = ZonedDateTime.now(ZoneId.of("Europe/Helsinki"));
    }

    public int getLippujaJaljella() {
        return max_lippuja - liput.size();
    }

    public void addLipputyyppi(Lipputyyppi lipputyyppi) {
        this.lipputyypit.add(lipputyyppi);
        lipputyyppi.getTapahtumat().add(this);
    }

    public void removeLipputyyppi(Lipputyyppi lipputyyppi) {
        this.lipputyypit.remove(lipputyyppi);
        lipputyyppi.getTapahtumat().remove(this);
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

    public ZonedDateTime getAlkaaPvm() {
        return alkaaPvm;
    }

    public void setAlkaaPvm(ZonedDateTime alkaaPvm) {
        this.alkaaPvm = alkaaPvm;
    }

    public ZonedDateTime getPaattyyPvm() {
        return paattyyPvm;
    }

    public void setPaattyyPvm(ZonedDateTime paattyyPvm) {
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

    public Set<Lipputyyppi> getLipputyypit() {
        return lipputyypit;
    }

    public void setLipputyypit(Set<Lipputyyppi> lipputyypit) {
        this.lipputyypit = lipputyypit;
    }

    public int getMax_lippuja() {
        return max_lippuja;
    }

    public void setMax_lippuja(int max_lippuja) {
        this.max_lippuja = max_lippuja;
    }

    @Override
    public String toString() {
        return "Tapahtuma [tapahtumaId=" + tapahtumaId + ", tapahtumaNimi=" + tapahtumaNimi + ", luontiPvm=" + luontiPvm
                + ", alkaaPvm=" + alkaaPvm + ", paattyyPvm=" + paattyyPvm + ", kuvaus=" + kuvaus + ", max_lippuja="
                + max_lippuja + ", perushinta=" + perushinta + ", tapahtumapaikka=" + tapahtumapaikka + ", jarjestaja="
                + jarjestaja + "]";
    }

}
