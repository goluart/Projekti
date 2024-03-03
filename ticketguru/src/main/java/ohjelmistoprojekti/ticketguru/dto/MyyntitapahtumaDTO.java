package ohjelmistoprojekti.ticketguru.dto;

import java.time.LocalDateTime;
import java.util.List;

public class MyyntitapahtumaDTO {

    private LocalDateTime myyntitapahtumaPvm;
    private String loppusumma;
    private List<LippuDto> liputDto;

    
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
    public String getLoppusumma() {
        return loppusumma;
    }
    public void setLoppusumma(String loppusumma) {
        this.loppusumma = loppusumma;
    }

    
    
      
    
}
