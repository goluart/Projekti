package ohjelmistoprojekti.ticketguru.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Yhteyshenkilo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long yhtHloId;
    private String etunimi;
    private String sukunimi;
    private String sahkoposti;
    private String puhelin;
    private String lisatieto;

    // Myöhemmin Yhteyshenkilo ManyToOne Tapahtumapaikka
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

    @Override
    public String toString() {
        return "Yhteyshenkilo [yhtHloId=" + yhtHloId + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi
                + ", sahkoposti=" + sahkoposti + ", puhelin=" + puhelin + ", lisatieto=" + lisatieto + "]";
    }

}
