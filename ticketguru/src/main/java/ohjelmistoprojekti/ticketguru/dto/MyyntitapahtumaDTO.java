package ohjelmistoprojekti.ticketguru.dto;

public class MyyntitapahtumaDTO {

    private String tapahtumaId;
    private String tapahtumanNimi;
    private String tapahtumaAika;
    private String lipputyyppiId;
    private String hinta;



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
    
    
    
}
