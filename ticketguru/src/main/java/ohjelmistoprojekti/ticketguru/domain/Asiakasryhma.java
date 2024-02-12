package ohjelmistoprojekti.ticketguru.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Asiakasryhma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "asryh_id")
    private Long asryhid;

    private String nimi;
    private String kuvaus;
    private boolean tarkista;

    // Konstruktori
    public Asiakasryhma(Long id, String nimi, String kuvaus, boolean tarkista) {
        this.asryhid = id;
        this.nimi = nimi;
        this.kuvaus = kuvaus;
        this.tarkista = tarkista;
    }

    // get+set
    public Long getId() {
        return asryhid;
    }

    public void setId(Long id) {
        this.asryhid = id;
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
        return "Asiakasryhma [id=" + asryhid + ", nimi=" + nimi + ", kuvaus=" + kuvaus + ", tarkista=" + tarkista + "]";
    }

}
