package ohjelmistoprojekti.ticketguru.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Postitoimipaikka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "postinumero_id")
    private Long postinumeroId;
    private int postinumero;
    private String kaupunki;

    public Postitoimipaikka(int postinumero, String kaupunki) {
        super();
        this.postinumero = postinumero;
        this.kaupunki = kaupunki;
    }

    public Postitoimipaikka() {
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

    @Override
    public String toString() {
        return "Postitoimipaikka [postinumero_id=" + postinumeroId + ", postinumero=" + postinumero + ", kaupunki="
                + kaupunki + "]";
    }

}
