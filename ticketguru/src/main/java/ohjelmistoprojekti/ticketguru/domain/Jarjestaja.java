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
public class Jarjestaja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "jarjestaja_id")
    private Long jarjestajaId;
    private String nimi;
    private String ytunnus;
    private String osoite;
    private String paikkakunta;
    private String postinumero;

    @ManyToOne
    @JsonIgnoreProperties("jarjestajat")
    @JoinColumn(name = "yht_hlo_id")
    private Yhteyshenkilo yhtHloId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jarjestaja")
    @JsonIgnoreProperties("jarjestaja")
    private List<Tapahtuma> tapahtumat;

    // Myöhemmin Jarjestaja ManyToOne Tapahtuma
    // Liittyy luokkiin Tapahtumapaikka, Yhteyshenkilo ja Postitoimipaikka

    public Jarjestaja(String nimi, String ytunnus, String osoite, String paikkakunta, String postinumero,
            Yhteyshenkilo yhtHloId) {
        super();
        this.nimi = nimi;
        this.ytunnus = ytunnus;
        this.osoite = osoite;
        this.paikkakunta = paikkakunta;
        this.postinumero = postinumero;
        this.yhtHloId = yhtHloId;
    }

    public Jarjestaja() {
        super();
        this.nimi = null;
        this.ytunnus = null;
        this.osoite = null;
        this.paikkakunta = null;
        this.postinumero = null;
        this.yhtHloId = null;

    }

    public Long getJarjestajaId() {
        return jarjestajaId;
    }

    public void setJarjestajaId(Long jarjestajaId) {
        this.jarjestajaId = jarjestajaId;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getYtunnus() {
        return ytunnus;
    }

    public void setYtunnus(String ytunnus) {
        this.ytunnus = ytunnus;
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

    public Yhteyshenkilo getYhtHloId() {
        return yhtHloId;
    }

    public void setYhtHloId(Yhteyshenkilo yhtHloId) {
        this.yhtHloId = yhtHloId;
    }

    public List<Tapahtuma> getTapahtumat() {
        return tapahtumat;
    }

    public void setTapahtumat(List<Tapahtuma> tapahtumat) {
        this.tapahtumat = tapahtumat;
    }

    @Override
    public String toString() {
        return "Jarjestaja [jarjestajaId=" + jarjestajaId + ", nimi=" + nimi + ", ytunnus=" + ytunnus + ", osoite="
                + osoite
                + ", paikkakunta=" + paikkakunta + ", postinumero=" + postinumero + ", yhtHloId="
                + yhtHloId + "]";
    }

}
