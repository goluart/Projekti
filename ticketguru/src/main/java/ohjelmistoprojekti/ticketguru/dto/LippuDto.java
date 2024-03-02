package ohjelmistoprojekti.ticketguru.dto;

public class LippuDto {

    private String tapahtumaId;
    private String tapahtumanNimi;
    private String tapahtumaAika;
    private String tapahtumaPaikka;
    private String lipputyyppiId;
    private String lipputyyppi;
    private String hinta;
    private String tarkistuskoodi;
    
    public String getTapahtumanNimi() {
        return tapahtumanNimi;
    }
    public void setTapahtumanNimi(String tapahtumanNimi) {
        this.tapahtumanNimi = tapahtumanNimi;
    }
    public String getTapahtumaAika() {
        return tapahtumaAika;
    }
    public void setTapahtumaAika(String tapahtumaAika) {
        this.tapahtumaAika = tapahtumaAika;
    }
    public String getLipputyyppiId() {
        return lipputyyppiId;
    }
    public void setLipputyyppiId(String lipputyyppiId) {
        this.lipputyyppiId = lipputyyppiId;
    }
    public String getHinta() {
        return hinta;
    }
    public void setHinta(String hinta) {
        this.hinta = hinta;
    }
    public String getTapahtumaId() {
        return tapahtumaId;
    }
    public void setTapahtumaId(String tapahtumaId) {
        this.tapahtumaId = tapahtumaId;
    }
    public String getTarkistuskoodi() {
        return tarkistuskoodi;
    }
    public void setTarkistuskoodi(String tarkistuskoodi) {
        this.tarkistuskoodi = tarkistuskoodi;
    }
    public String getTapahtumaPaikka() {
        return tapahtumaPaikka;
    }
    public void setTapahtumaPaikka(String tapahtumaPaikka) {
        this.tapahtumaPaikka = tapahtumaPaikka;
    }
    public String getLipputyyppi() {
        return lipputyyppi;
    }
    public void setLipputyyppi(String lipputyyppi) {
        this.lipputyyppi = lipputyyppi;
    }
    

}
