package ohjelmistoprojekti.ticketguru.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jarjestaja")
    @JsonIgnore
    private List<Tapahtuma> tapahtumat;

    @ManyToOne
    @JsonIgnoreProperties("jarjestajat")
    @JoinColumn(name = "yht_hlo_id")
    private Yhteyshenkilo yhteyshenkilo;

    @ManyToOne
    @JsonIgnoreProperties("jarjestajat")
    @JoinColumn(name = "postitoimipaikka_id")
    private Postitoimipaikka postitoimipaikka;

    // Myöhemmin Jarjestaja ManyToOne Tapahtuma
    // Liittyy luokkiin Tapahtumapaikka, Yhteyshenkilo ja Postitoimipaikka


    
    public Jarjestaja(String nimi, String ytunnus, String osoite, String paikkakunta, Postitoimipaikka postitoimipaikka,
    Yhteyshenkilo yhteyshenkilo) {
        super();
        this.nimi = nimi;
        this.ytunnus = ytunnus;
        this.osoite = osoite;
        this.paikkakunta = paikkakunta;
        this.postitoimipaikka = postitoimipaikka;
        this.yhteyshenkilo = yhteyshenkilo;
    }
    
    public Jarjestaja() {
        super();
        this.nimi = null;
        this.ytunnus = null;
        this.osoite = null;
        this.paikkakunta = null;
        this.postitoimipaikka = null;
        this.yhteyshenkilo = null;        
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
    
    public Yhteyshenkilo getyhteyshenkilo() {
        return yhteyshenkilo;
    }
    
    public void setyhteyshenkilo(Yhteyshenkilo yhteyshenkilo) {
        this.yhteyshenkilo = yhteyshenkilo;
    }
    
    public List<Tapahtuma> getTapahtumat() {
        return tapahtumat;
    }
    
    public void setTapahtumat(List<Tapahtuma> tapahtumat) {
        this.tapahtumat = tapahtumat;
    }
    
    public Postitoimipaikka getPostitoimipaikka() {
        return postitoimipaikka;
    }
    
    public void setPostitoimipaikka(Postitoimipaikka postitoimipaikka) {
        this.postitoimipaikka = postitoimipaikka;
    }

    @Override
    public String toString() {
        return "Jarjestaja [jarjestajaId=" + jarjestajaId + ", nimi=" + nimi + ", ytunnus=" + ytunnus + ", osoite="
        + osoite + ", paikkakunta=" + paikkakunta + ", postinumero=" + postinumero + ", yhteyshenkilo=" + yhteyshenkilo
        + ", postitoimipaikka=" + postitoimipaikka + "]";
    }
    
    
    
}
