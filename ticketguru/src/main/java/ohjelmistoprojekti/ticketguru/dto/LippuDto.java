package ohjelmistoprojekti.ticketguru.dto;

import java.util.List;

public class LippuDto {

    String tapahtumanNimi;
    String tapahtumanPaikka;
    String tapahtumanAika;
    String tapahtumanHinta;
    List<String> lipputyypit;
    
    public String getTapahtumanNimi() {
        return tapahtumanNimi;
    }
    public void setTapahtumanNimi(String tapahtumanNimi) {
        this.tapahtumanNimi = tapahtumanNimi;
    }
    public String getTapahtumanPaikka() {
        return tapahtumanPaikka;
    }
    public void setTapahtumanPaikka(String tapahtumanPaikka) {
        this.tapahtumanPaikka = tapahtumanPaikka;
    }
    public String getTapahtumanAika() {
        return tapahtumanAika;
    }
    public void setTapahtumanAika(String tapahtumanAika) {
        this.tapahtumanAika = tapahtumanAika;
    }
    public String getTapahtumanHinta() {
        return tapahtumanHinta;
    }
    public void setTapahtumanHinta(String tapahtumanHinta) {
        this.tapahtumanHinta = tapahtumanHinta;
    }
    public List<String> getLipputyypit() {
        return lipputyypit;
    }
    public void setLipputyypit(List<String> lipputyypit) {
        this.lipputyypit = lipputyypit;
    }
      

}
