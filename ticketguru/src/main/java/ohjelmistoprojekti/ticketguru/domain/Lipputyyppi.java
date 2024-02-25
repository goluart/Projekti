package ohjelmistoprojekti.ticketguru.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Lipputyyppi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "lipputyyppi_id")
    private Long lipputyyppiId;

    private String nimi;
    private double hintamuutos;

    // Tuodaan Asiakasryhmä luokka tänne
    @ManyToOne
    @JoinColumn(name = "asryh_id")
    private Asiakasryhma asiakasryhma;

    // Konstruktori
    public Lipputyyppi(String nimi, Double hintamuutos, Asiakasryhma asiakasryhma) {
        this.nimi = nimi;
        this.hintamuutos = hintamuutos;
        this.asiakasryhma = asiakasryhma;
    }

    // get+set
    public Long getId() {
        return lipputyyppiId;
    }

    public void setId(Long id) {
        this.lipputyyppiId = id;
    }

    public Asiakasryhma getAsiakasryhma() {
        return asiakasryhma;
    }

    public void setAsiakasryhma(Asiakasryhma asiakasryhma) {
        this.asiakasryhma = asiakasryhma;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public double getHintamuutos() {
        return hintamuutos;
    }

    public void setHintamuutos(double hintamuutos) {
        this.hintamuutos = hintamuutos;
    }

    // toString
    @Override
    public String toString() {
        return "Lipputyyppi [id=" + lipputyyppiId + ", nimi=" + nimi + ", hintamuutos=" + hintamuutos
                + ", asiakasryhma="
                + asiakasryhma + "]";
    }

}
