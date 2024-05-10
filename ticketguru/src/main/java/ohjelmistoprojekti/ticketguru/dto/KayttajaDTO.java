package ohjelmistoprojekti.ticketguru.dto;

public class KayttajaDTO { // Luodaan käyttjä-luokasta dto, jotta salasanaa ei tarvitse näyttää turhaan.

    private Long hloId;
    private String tunnus;
    private String snimi;
    private String enimi;
    private String lisatiedot;
    private String rooliNimi;

    public KayttajaDTO() {
        super();
        this.hloId = null;
        this.tunnus = null;
        this.snimi = null;
        this.enimi = null;
        this.lisatiedot = null;
        this.rooliNimi = null;
    }

    public KayttajaDTO(Long hloId, String tunnus, String snimi, String enimi, String lisatiedot, String rooliNimi) {
        this.hloId = hloId;
        this.tunnus = tunnus;
        this.snimi = snimi;
        this.enimi = enimi;
        this.lisatiedot = lisatiedot;
        this.rooliNimi = rooliNimi;
    }

    public Long getHloId() {
        return hloId;
    }

    public void setHloId(Long hloId) {
        this.hloId = hloId;
    }

    public String getTunnus() {
        return tunnus;
    }

    public void setTunnus(String tunnus) {
        this.tunnus = tunnus;
    }

    public String getSnimi() {
        return snimi;
    }

    public void setSnimi(String snimi) {
        this.snimi = snimi;
    }

    public String getEnimi() {
        return enimi;
    }

    public void setEnimi(String enimi) {
        this.enimi = enimi;
    }

    public String getLisatiedot() {
        return lisatiedot;
    }

    public void setLisatiedot(String lisatiedot) {
        this.lisatiedot = lisatiedot;
    }

    public String getRooliNimi() {
        return rooliNimi;
    }

    public void setRooliNimi(String rooliNimi) {
        this.rooliNimi = rooliNimi;
    }

    @Override
    public String toString() {
        return "KayttajaDTO [hloId=" + hloId + ", tunnus=" + tunnus + ", snimi=" + snimi + ", enimi=" + enimi
                + ", lisatiedot=" + lisatiedot + ", rooliNimi=" + rooliNimi + "]";
    }

}
