package ohjelmistoprojekti.ticketguru.dto;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotEmpty;

@JsonInclude(JsonInclude.Include.NON_NULL) // jättää null-arvot pois vastauksesta
public class TarkastusDTO {

    private Long tarkastusId; // Tarkastus
    private ZonedDateTime kayttoPvm; // Tarkastus
    @NotEmpty(message = "Lippua ei voi tarkistaa ilman tarkastuskoodia")
    private String tarkistuskoodi; // Lippu
    @NotEmpty(message = "Tapahtumalla pitää olla nimi")
    private String tapahtumaNimi; // Tapahtuma
    @NotEmpty(message = "Lippytyyppi pitää määrittää")
    private String lipputyyppi; // Lipputyyppi
    @NotEmpty(message = "Tapahtumapaikka pitää määrittää")
    private String paikkaNimi; // Tapahtumapaikka
    private Boolean response; // Vastausviestin palautus jsonina

    public Long getTarkastusId() {
        return tarkastusId;
    }

    public void setTarkastusId(Long tarkastusId) {
        this.tarkastusId = tarkastusId;
    }

    public ZonedDateTime getKayttoPvm() {
        return kayttoPvm;
    }

    public void setKayttoPvm(ZonedDateTime kayttoPvm) {
        this.kayttoPvm = kayttoPvm;
    }

    public String getTarkistuskoodi() {
        return tarkistuskoodi;
    }

    public void setTarkistuskoodi(String tarkistuskoodi) {
        this.tarkistuskoodi = tarkistuskoodi;
    }

    public String getTapahtumaNimi() {
        return tapahtumaNimi;
    }

    public void setTapahtumaNimi(String tapahtumaNimi) {
        this.tapahtumaNimi = tapahtumaNimi;
    }

    public String getLipputyyppi() {
        return lipputyyppi;
    }

    public void setLipputyyppi(String lipputyyppi) {
        this.lipputyyppi = lipputyyppi;
    }

    public String getPaikkaNimi() {
        return paikkaNimi;
    }

    public void setPaikkaNimi(String paikkaNimi) {
        this.paikkaNimi = paikkaNimi;
    }    
    
    public Boolean getResponse() {
        return response;
    }
    
    public void setResponse(Boolean response) {
        this.response = response;
    }
    @Override
    public String toString() {
        return "TarkastusDTO [tarkastusId=" + tarkastusId + ", kayttoPvm=" + kayttoPvm + ", tarkistuskoodi="
                + tarkistuskoodi + ", tapahtumaNimi=" + tapahtumaNimi + ", lipputyyppi=" + lipputyyppi + ", paikkaNimi="
                + paikkaNimi + "]";
    }
    
}
