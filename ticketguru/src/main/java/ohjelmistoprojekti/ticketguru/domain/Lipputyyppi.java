package ohjelmistoprojekti.ticketguru.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Lipputyyppi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "lipputyyppi_id")
    private Long lipputyyppiId;

    private String nimi;
    private Date hintamuutos;

    // Tuodaan Asiakasryhmä luokka tänne
    @OneToOne
    @JoinColumn(name = "asryh_id")
    private Asiakasryhma asiakasryhma;

    // Konstruktori
    public Lipputyyppi(Long id, String nimi, Date hintamuutos, Asiakasryhma asiakasryhma) {
        this.lipputyyppiId = id;
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

    public Date getHintamuutos() {
        return hintamuutos;
    }

    public void setHintamuutos(Date hintamuutos) {
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
