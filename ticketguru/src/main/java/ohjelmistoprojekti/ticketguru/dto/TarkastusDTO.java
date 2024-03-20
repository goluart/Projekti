package ohjelmistoprojekti.ticketguru.dto;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TarkastusDTO {

    private Long tarkastusId; // Tarkastus
    private ZonedDateTime kayttoPvm; // Tarkastus
    private String tarkistuskoodi; // Lippu
    private String tapahtumaNimi; // Tapahtuma
    private String lipputyyppi; // Lipputyyppi
    private String paikkaNimi; // Tapahtumapaikka

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

    @Override
    public String toString() {
        return "TarkastusDTO [kayttoPvm=" + kayttoPvm
                + ", tarkistuskoodi=" + tarkistuskoodi + ", tapahtumaNimi="
                + tapahtumaNimi + ", nimi=" + lipputyyppi + ", paikkaNimi=" + paikkaNimi + "]";
    }

}
