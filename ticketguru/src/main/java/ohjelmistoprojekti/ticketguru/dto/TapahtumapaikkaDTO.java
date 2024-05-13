package ohjelmistoprojekti.ticketguru.dto;

import ohjelmistoprojekti.ticketguru.domain.Postitoimipaikka;

public class TapahtumapaikkaDTO {

    private Long tapaikkaId;
    private String paikkaNimi, osoite, ytunnus, sposti;
    
    public TapahtumapaikkaDTO() {
    }        

    public TapahtumapaikkaDTO(Long tapaikkaId, String paikkaNimi, String osoite, String ytunnus, String sposti,
            Postitoimipaikka postitoimipaikka) {
        this.tapaikkaId = tapaikkaId;
        this.paikkaNimi = paikkaNimi;
        this.osoite = osoite;
        this.ytunnus = ytunnus;
        this.sposti = sposti;
    }

    public Long getTapaikkaId() {
        return tapaikkaId;
    }

    public void setTapaikkaId(Long tapaikkaId) {
        this.tapaikkaId = tapaikkaId;
    }

    public String getPaikkaNimi() {
        return paikkaNimi;
    }

    public void setPaikkaNimi(String paikkaNimi) {
        this.paikkaNimi = paikkaNimi;
    }

    public String getOsoite() {
        return osoite;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
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

}

