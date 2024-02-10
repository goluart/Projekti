package ohjelmistoprojekti.ticketguru.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Jarjestaja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String nimi;
    private String ytunnus;
    private String osoite;
    private String paikkakunta;
    private String postinumero;
    private int yhteyshenkiloid;

    // Myöhemmin Jarjestaja OneToMany Tapahtuma
    // Liittyy luokkiin Jarjestaja ja Yhteyshenkilo

    public Jarjestaja(Long id, String nimi, String ytunnus, String osoite, String paikkakunta, String postinumero,
            int yhteyshenkiloid) {
        super();
        this.nimi = nimi;
        this.ytunnus = ytunnus;
        this.osoite = osoite;
        this.paikkakunta = paikkakunta;
        this.postinumero = postinumero;
        this.yhteyshenkiloid = yhteyshenkiloid;
    }

    public Jarjestaja() {
        super();
        this.nimi = null;
        this.ytunnus = null;
        this.osoite = null;
        this.paikkakunta = null;
        this.postinumero = null;
        this.yhteyshenkiloid = 0;

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

    public int getYhteyshenkiloid() {
        return yhteyshenkiloid;
    }

    public void setYhteyshenkiloid(int yhteyshenkiloid) {
        this.yhteyshenkiloid = yhteyshenkiloid;
    }

    @Override
    public String toString() {
        return "Jarjestaja [id=" + id + ", nimi=" + nimi + ", ytunnus=" + ytunnus + ", osoite=" + osoite
                + ", paikkakunta=" + paikkakunta + ", postinumero=" + postinumero + ", yhteyshenkiloid="
                + yhteyshenkiloid + "]";
    }

}
