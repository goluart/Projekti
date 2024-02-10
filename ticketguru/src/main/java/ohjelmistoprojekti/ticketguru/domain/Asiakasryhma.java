package ohjelmistoprojekti.ticketguru.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Asiakasryhma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String nimi;
    private String kuvaus;
    private boolean tarkista;

    // Konstruktori
    public Asiakasryhma(Long id, String nimi, String kuvaus, boolean tarkista) {
        this.id = id;
        this.nimi = nimi;
        this.kuvaus = kuvaus;
        this.tarkista = tarkista;
    }

    // get+set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public boolean isTarkista() {
        return tarkista;
    }

    public void setTarkista(boolean tarkista) {
        this.tarkista = tarkista;
    }

    // toString
    @Override
    public String toString() {
        return "Asiakasryhma [id=" + id + ", nimi=" + nimi + ", kuvaus=" + kuvaus + ", tarkista=" + tarkista + "]";
    }

}
