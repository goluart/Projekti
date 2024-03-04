package ohjelmistoprojekti.ticketguru.domain;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Lipputyyppi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lipputyyppi_id")
    private Long lipputyyppiId;
    private String nimi;
    private double hintakerroin;
    @JsonIgnore
    @ManyToMany(mappedBy = "lipputyypit")
    private Set<Tapahtuma> tapahtumat = new HashSet<>();
    
    // Tuodaan Asiakasryhmä luokka tänne
    @ManyToOne
    @JoinColumn(name = "asryh_id")
    private Asiakasryhma asiakasryhma;

    public Lipputyyppi() {
        super();
    }
    
    // Konstruktori
    public Lipputyyppi(String nimi, Double hintakerroin, Asiakasryhma asiakasryhma) {
        this.nimi = nimi;
        this.hintakerroin = hintakerroin;
        this.asiakasryhma = asiakasryhma;
    }
    
    public Long getLipputyyppiId() {
        return lipputyyppiId;
    }

    public void setLipputyyppiId(Long lipputyyppiId) {
        this.lipputyyppiId = lipputyyppiId;
    }

    public Set<Tapahtuma> getTapahtumat() {
        return tapahtumat;
    }

    public void setTapahtumat(Set<Tapahtuma> tapahtumat) {
        this.tapahtumat = tapahtumat;
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

    public double getHintakerroin() {
        return hintakerroin;
    }

    public void setHintakerroin(double hintakerroin) {
        this.hintakerroin = hintakerroin;
    }
    

    // toString
    @Override
    public String toString() {
        return "Lipputyyppi [id=" + lipputyyppiId + ", nimi=" + nimi + ", hintakerroin=" + hintakerroin
                + ", asiakasryhma="
                + asiakasryhma + "]";
    }


}
