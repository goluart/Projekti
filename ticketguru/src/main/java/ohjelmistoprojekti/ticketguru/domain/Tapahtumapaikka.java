package ohjelmistoprojekti.ticketguru.domain;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Tapahtumapaikka {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tapaikka_id")
    private Long tapaikkaId;
    private String osoite, paikkakunta, postinumero, kuvaus, ytunnus, sposti, lisatiedot;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tapahtumapaikka")
    private List<Yhteyshenkilo> yhteyshenkilo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tapahtumapaikka")
    private List<Tapahtuma> tapahtuma;
    

    public Tapahtumapaikka() {
        super();
    }


    public Long getTapaikkaId() {
        return tapaikkaId;
    }


    public void setTapaikkaId(Long tapaikkaId) {
        this.tapaikkaId = tapaikkaId;
    }


    public String getOsoite() {
        return osoite;
    }


    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }


    public String getPaikkakunta() {
        return paikkakunta;
    }


    public void setPaikkakunta(String paikkakunta) {
        this.paikkakunta = paikkakunta;
    }


    public String getPostinumero() {
        return postinumero;
    }


    public void setPostinumero(String postinumero) {
        this.postinumero = postinumero;
    }


    public String getKuvaus() {
        return kuvaus;
    }


    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }


    public String getYtunnus() {
        return ytunnus;
    }


    public void setYtunnus(String ytunnus) {
        this.ytunnus = ytunnus;
    }


    public String getSposti() {
        return sposti;
    }


    public void setSposti(String sposti) {
        this.sposti = sposti;
    }


    public String getLisatiedot() {
        return lisatiedot;
    }


    public void setLisatiedot(String lisatiedot) {
        this.lisatiedot = lisatiedot;
    }


    public List<Yhteyshenkilo> getYhteyshenkilo() {
        return yhteyshenkilo;
    }


    public void setYhteyshenkilo(List<Yhteyshenkilo> yhteyshenkilo) {
        this.yhteyshenkilo = yhteyshenkilo;
    }


    public List<Tapahtuma> getTapahtuma() {
        return tapahtuma;
    }


    public void setTapahtuma(List<Tapahtuma> tapahtuma) {
        this.tapahtuma = tapahtuma;
    }


    @Override
    public String toString() {
        return "Tapahtumapaikka [tapaikkaId=" + tapaikkaId + ", osoite=" + osoite + ", paikkakunta=" + paikkakunta
                + ", postinumero=" + postinumero + ", kuvaus=" + kuvaus + ", ytunnus=" + ytunnus + ", sposti=" + sposti
                + ", lisatiedot=" + lisatiedot + "]";
    }

}
