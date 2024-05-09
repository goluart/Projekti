package ohjelmistoprojekti.ticketguru.dto;

public class RooliKayttajaDTO {

    private Long hloId;
    private String enimi;
    private String snimi;

    public RooliKayttajaDTO() {
        super();
        this.hloId = null;
        this.enimi = null;
        this.snimi = null;

    }

    public RooliKayttajaDTO(Long hloId, String enimi, String snimi) {
        super();
        this.hloId = hloId;
        this.enimi = enimi;
        this.snimi = snimi;

    }

    public Long getHloId() {
        return hloId;
    }

    public void setHloId(Long hloId) {
        this.hloId = hloId;
    }

    public String getEnimi() {
        return enimi;
    }

    public void setEnimi(String enimi) {
        this.enimi = enimi;
    }

    public String getSnimi() {
        return snimi;
    }

    public void setSnimi(String snimi) {
        this.snimi = snimi;
    }

    @Override
    public String toString() {
        return "RooliKayttajaDTO [hloId=" + hloId + ", enimi=" + enimi + ", snimi=" + snimi + "]";
    }

}
