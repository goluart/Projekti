package ohjelmistoprojekti.ticketguru.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Lipputyyppi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String nimi;
    private Date hintamuutos;

    // Tuodaan Asiakasryhmä luokka tänne
    @OneToOne
    @JoinColumn(name = "asryh_id")
    private Asiakasryhma asiakasryhma;

    public Lipputyyppi(Long id, String nimi, Date hintamuutos) {
        this.id = id;
        this.nimi = nimi;
        this.hintamuutos = hintamuutos;
    }

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

    public Date getHintamuutos() {
        return hintamuutos;
    }

    public void setHintamuutos(Date hintamuutos) {
        this.hintamuutos = hintamuutos;
    }

    @Override
    public String toString() {
        return "Lipputyyppi [id=" + id + ", nimi=" + nimi + ", hintamuutos=" + hintamuutos + "]";
    }

}
