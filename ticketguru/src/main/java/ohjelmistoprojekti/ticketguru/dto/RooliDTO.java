package ohjelmistoprojekti.ticketguru.dto;

import java.util.List;

public class RooliDTO {

    private Long rooliId;
    private String rooliNimi;
    private List<RooliKayttajaDTO> kayttajat;

    public RooliDTO() {
        super();
        this.rooliId = null;
        this.rooliNimi = null;
        this.kayttajat = null;
    }

    public RooliDTO(Long rooliId, String rooliNimi, List<RooliKayttajaDTO> kayttajat) {
        super();
        this.rooliId = rooliId;
        this.rooliNimi = rooliNimi;
        this.kayttajat = kayttajat;
    }

    public Long getRooliId() {
        return rooliId;
    }

    public void setRooliId(Long rooliId) {
        this.rooliId = rooliId;
    }

    public String getRooliNimi() {
        return rooliNimi;
    }

    public void setRooliNimi(String rooliNimi) {
        this.rooliNimi = rooliNimi;
    }

    public List<RooliKayttajaDTO> getKayttajat() {
        return kayttajat;
    }

    public void setKayttajat(List<RooliKayttajaDTO> kayttajat) {
        this.kayttajat = kayttajat;
    }

    @Override
    public String toString() {
        return "RooliDTO [rooliId=" + rooliId + ", rooliNimi=" + rooliNimi + ", kayttajat=" + kayttajat + "]";
    }

}
