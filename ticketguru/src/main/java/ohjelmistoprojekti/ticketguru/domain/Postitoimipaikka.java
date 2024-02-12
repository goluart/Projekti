package ohjelmistoprojekti.ticketguru.domain;

import java.util.List;

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
    private int postinumero;
    private String kaupunki;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postitoimipaikka")
    @JsonIgnoreProperties("postitoimipaikka")
    private List<Jarjestaja> jarjestajat;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postitoimipaikka")
    @JsonIgnoreProperties("postitoimipaikka")
    private List<Tapahtumapaikka> tapahtumapaikat;

    public Postitoimipaikka(int postinumero, String kaupunki) {
        super();
        this.postinumero = postinumero;
        this.kaupunki = kaupunki;
    }

    public Postitoimipaikka() {
        super();
        this.postinumero = 0;
        this.kaupunki = null;

    }

    public Long getPostinumeroId() {
        return postinumeroId;
    }

    public void setPostinumeroId(Long postinumeroId) {
        this.postinumeroId = postinumeroId;
    }

    public int getPostinumero() {
        return postinumero;
    }

    public void setPostinumero(int postinumero) {
        this.postinumero = postinumero;
    }

    public String getKaupunki() {
        return kaupunki;
    }

    public void setKaupunki(String kaupunki) {
        this.kaupunki = kaupunki;
    }

    public List<Jarjestaja> getJarjestajat() {
        return jarjestajat;
    }

    public void setJarjestajat(List<Jarjestaja> jarjestajat) {
        this.jarjestajat = jarjestajat;
    }

    public List<Tapahtumapaikka> getTapahtumapaikat() {
        return tapahtumapaikat;
    }

    public void setTapahtumapaikat(List<Tapahtumapaikka> tapahtumapaikat) {
        this.tapahtumapaikat = tapahtumapaikat;
    }

    @Override
    public String toString() {
        return "Postitoimipaikka [postinumeroId=" + postinumeroId + ", postinumero=" + postinumero + ", kaupunki="
                + kaupunki + ", jarjestajat=" + jarjestajat + ", tapahtumapaikat=" + tapahtumapaikat + "]";
    }

}
