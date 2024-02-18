package ohjelmistoprojekti.ticketguru.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Postitoimipaikka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "postinumero_id")
    private Long postinumeroId;
    private String postinumero;
    private String kaupunki;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postitoimipaikka")
    @JsonIgnoreProperties("postitoimipaikka")
    private Set<Jarjestaja> jarjestajat = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postitoimipaikka")
    @JsonIgnoreProperties("postitoimipaikka")
    private List<Tapahtumapaikka> tapahtumapaikat;

    public Postitoimipaikka(String postinumero, String kaupunki) {
        super();
        this.postinumero = postinumero;
        this.kaupunki = kaupunki;
    }

    public Postitoimipaikka() {
        super();
        this.postinumero = null;
        this.kaupunki = null;

    }

    public Long getPostinumeroId() {
        return postinumeroId;
    }

    public void setPostinumeroId(Long postinumeroId) {
        this.postinumeroId = postinumeroId;
    }

    public String getPostinumero() {
        return postinumero;
    }

    public void setPostinumero(String postinumero) {
        this.postinumero = postinumero;
    }

    public String getKaupunki() {
        return kaupunki;
    }

    public void setKaupunki(String kaupunki) {
        this.kaupunki = kaupunki;
    }

    public List<Tapahtumapaikka> getTapahtumapaikat() {
        return tapahtumapaikat;
    }

    public void setTapahtumapaikat(List<Tapahtumapaikka> tapahtumapaikat) {
        this.tapahtumapaikat = tapahtumapaikat;
    }

    public Set<Jarjestaja> getJarjestajat() {
        return jarjestajat;
    }

    public void setJarjestajat(Set<Jarjestaja> jarjestajat) {
        this.jarjestajat = jarjestajat;
    }

    @Override
    public String toString() {
        return "Postitoimipaikka [postinumeroId=" + postinumeroId + ", postinumero=" + postinumero + ", kaupunki="
                + kaupunki + ", jarjestajat=" + jarjestajat + ", tapahtumapaikat=" + tapahtumapaikat + "]";
    }


}
