package ohjelmistoprojekti.ticketguru.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Yhteyshenkilo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "yht_hlo_id")
    private Long yhtHloId;
    private String etunimi;
    private String sukunimi;
    private String sahkoposti;
    private String puhelin;
    private String lisatieto;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "yhteyshenkilo")
    @JsonIgnoreProperties("yhteyshenkilo")
    private List<Jarjestaja> jarjestajat;

    @ManyToOne
    @JsonIgnoreProperties("yhteyshenkilo")
    @JoinColumn(name = "tapaikkaId")
    private Tapahtumapaikka tapahtumapaikka;

    // Myöhemmin Yhteyshenkilo OneToMany Tapahtumapaikka
    // Liittyy luokkiin Tapahtumapaikka ja Jarjestaja

    public Yhteyshenkilo(String etunimi, String sukunimi, String sahkoposti, String puhelin, String lisatieto) {
        super();
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.sahkoposti = sahkoposti;
        this.puhelin = puhelin;
        this.lisatieto = lisatieto;
    }

    public Yhteyshenkilo() {
        super();
        this.etunimi = null;
        this.sukunimi = null;
        this.sahkoposti = null;
        this.puhelin = null;
        this.lisatieto = null;

    }

    public Long getYhtHloId() {
        return yhtHloId;
    }

    public void setYhtHloId(Long yhtHloId) {
        this.yhtHloId = yhtHloId;
    }

    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public String getSahkoposti() {
        return sahkoposti;
    }

    public void setSahkoposti(String sahkoposti) {
        this.sahkoposti = sahkoposti;
    }

    public String getPuhelin() {
        return puhelin;
    }

    public void setPuhelin(String puhelin) {
        this.puhelin = puhelin;
    }

    public String getLisatieto() {
        return lisatieto;
    }

    public void setLisatieto(String lisatieto) {
        this.lisatieto = lisatieto;
    }

    public List<Jarjestaja> getJarjestajat() {
        return jarjestajat;
    }

    public void setJarjestajat(List<Jarjestaja> jarjestajat) {
        this.jarjestajat = jarjestajat;
    }

    public Tapahtumapaikka getTapahtumapaikka() {
        return tapahtumapaikka;
    }

    public void setTapahtumapaikka(Tapahtumapaikka tapahtumapaikka) {
        this.tapahtumapaikka = tapahtumapaikka;
    }

    @Override
    public String toString() {
        return "Yhteyshenkilo [yhtHloId=" + yhtHloId + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi
                + ", sahkoposti=" + sahkoposti + ", puhelin=" + puhelin + ", lisatieto=" + lisatieto + ", jarjestajat="
                + jarjestajat + ", tapahtumapaikka=" + tapahtumapaikka + "]";
    }

}
