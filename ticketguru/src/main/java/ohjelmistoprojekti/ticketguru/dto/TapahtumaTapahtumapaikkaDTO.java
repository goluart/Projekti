package ohjelmistoprojekti.ticketguru.dto;

public class TapahtumaTapahtumapaikkaDTO {

    private Long tapahtumapaikkaId;
    private String tapahtumapaikkaNimi, tapahtumapaikkaOsoite, tapahtumapaikkaKaupunki;    


    public TapahtumaTapahtumapaikkaDTO(Long tapahtumapaikkaId, String tapahtumapaikkaNimi, String tapahtumapaikkaOsoite,
            String tapahtumapaikkaKaupunki) {
        this.tapahtumapaikkaId = tapahtumapaikkaId;
        this.tapahtumapaikkaNimi = tapahtumapaikkaNimi;
        this.tapahtumapaikkaOsoite = tapahtumapaikkaOsoite;
        this.tapahtumapaikkaKaupunki = tapahtumapaikkaKaupunki;
    }
    public Long getTapahtumapaikkaId() {
        return tapahtumapaikkaId;
    }
    public void setTapahtumapaikkaId(Long tapahtumapaikkaId) {
        this.tapahtumapaikkaId = tapahtumapaikkaId;
    }
    public String getTapahtumapaikkaNimi() {
        return tapahtumapaikkaNimi;
    }
    public void setTapahtumapaikkaNimi(String tapahtumapaikkaNimi) {
        this.tapahtumapaikkaNimi = tapahtumapaikkaNimi;
    }
    public String getTapahtumapaikkaOsoite() {
        return tapahtumapaikkaOsoite;
    }
    public void setTapahtumapaikkaOsoite(String tapahtumapaikkaOsoite) {
        this.tapahtumapaikkaOsoite = tapahtumapaikkaOsoite;
    }
    public String getTapahtumapaikkaKaupunki() {
        return tapahtumapaikkaKaupunki;
    }
    public void setTapahtumapaikkaKaupunki(String tapahtumapaikkaKaupunki) {
        this.tapahtumapaikkaKaupunki = tapahtumapaikkaKaupunki;
    }

    

}
