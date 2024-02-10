package ohjelmistoprojekti.ticketguru.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Lipputyyppi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    // Myöhemmin lisätään asiakasryhmä

    /*
     * Asiakasryhmä luokka liittyy tähän myös
     * 
     * @JoinColumn(name = "asiakasryhmaId")
     * private Asiakasryhma asiakasryhma;
     */

    private Long id;
    private String nimi;
    private Date hintamuutos;

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
