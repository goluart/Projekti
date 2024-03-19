package ohjelmistoprojekti.ticketguru.dto;

import java.time.LocalDateTime;
import java.util.List;

public class MyyntitapahtumaDTO {

    private Long myyntitapahtumaId;
    private LocalDateTime myyntitapahtumaPvm;
    private String loppusumma;
    private List<LippuDto> liputDto;   

    
    public MyyntitapahtumaDTO(Long myyntitapahtumaId, LocalDateTime myyntitapahtumaPvm, String loppusumma,
            List<LippuDto> liputDto) {
        this.myyntitapahtumaId = myyntitapahtumaId;
        this.myyntitapahtumaPvm = myyntitapahtumaPvm;
        this.loppusumma = loppusumma;
        this.liputDto = liputDto;
    }
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
    public Long getMyyntitapahtumaId() {
        return myyntitapahtumaId;
    }
    public void setMyyntitapahtumaId(Long myyntitapahtumaId) {
        this.myyntitapahtumaId = myyntitapahtumaId;
    }

    public static class LippuDto {

        private String tapahtumaId;
        private String tapahtumanNimi;
        private String tapahtumaAika;
        private String tapahtumaPaikka;
        private String lipputyyppiId;
        private String lipputyyppi;
        private String hinta;
        private String tarkistuskoodi;    
        
        public LippuDto(String tapahtumaId, String tapahtumanNimi, String tapahtumaAika, String tapahtumaPaikka,
                String lipputyyppiId, String lipputyyppi, String hinta, String tarkistuskoodi) {
            this.tapahtumaId = tapahtumaId;
            this.tapahtumanNimi = tapahtumanNimi;
            this.tapahtumaAika = tapahtumaAika;
            this.tapahtumaPaikka = tapahtumaPaikka;
            this.lipputyyppiId = lipputyyppiId;
            this.lipputyyppi = lipputyyppi;
            this.hinta = hinta;
            this.tarkistuskoodi = tarkistuskoodi;
        }
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
    
}
