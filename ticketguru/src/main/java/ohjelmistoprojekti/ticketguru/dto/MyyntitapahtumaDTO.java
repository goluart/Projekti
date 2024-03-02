package ohjelmistoprojekti.ticketguru.dto;

import java.time.LocalDateTime;
import java.util.List;

public class MyyntitapahtumaDTO {

    // private String tapahtumaId;
    // private String tapahtumanNimi;
    // private String tapahtumaAika;
    // private String lipputyyppiId;
    // private String hinta;
    // private String tarkistuskoodi;
    private LocalDateTime myyntitapahtumaPvm;
    private List<LippuDto> liputDto;

    
    // public String getTapahtumanNimi() {
    //     return tapahtumanNimi;
    // }
    // public void setTapahtumanNimi(String tapahtumanNimi) {
    //     this.tapahtumanNimi = tapahtumanNimi;
    // }
    // public String getTapahtumaAika() {
    //     return tapahtumaAika;
    // }
    // public void setTapahtumaAika(String tapahtumaAika) {
    //     this.tapahtumaAika = tapahtumaAika;
    // }
    // public String getLipputyyppiId() {
    //     return lipputyyppiId;
    // }
    // public void setLipputyyppiId(String lipputyyppiId) {
    //     this.lipputyyppiId = lipputyyppiId;
    // }
    // public String getHinta() {
    //     return hinta;
    // }
    // public void setHinta(String hinta) {
    //     this.hinta = hinta;
    // }
    // public String getTapahtumaId() {
    //     return tapahtumaId;
    // }
    // public void setTapahtumaId(String tapahtumaId) {
    //     this.tapahtumaId = tapahtumaId;
    // }
    // public String getTarkistuskoodi() {
    //     return tarkistuskoodi;
    // }
    // public void setTarkistuskoodi(String tarkistuskoodi) {
    //     this.tarkistuskoodi = tarkistuskoodi;
    // }
    
    public List<LippuDto> getLiputDto() {
        return liputDto;
    }
    public void setLiputDto(List<LippuDto> liputDto) {
        this.liputDto = liputDto;
    }
    public LocalDateTime getMyyntitapahtumaPvm() {
        return myyntitapahtumaPvm;
    }
    public void setMyyntitapahtumaPvm(LocalDateTime myyntitapahtumaPvm) {
        this.myyntitapahtumaPvm = myyntitapahtumaPvm;
    }
    
      
    
}
