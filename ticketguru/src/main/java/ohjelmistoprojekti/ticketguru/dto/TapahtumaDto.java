package ohjelmistoprojekti.ticketguru.dto;

import java.time.ZonedDateTime;
import java.util.List;

public class TapahtumaDto {

    private Long tapahtumaId;
    private List<TapahtumaLipputyyppiDto> lipputyypit;
    private TapahtumaTapahtumapaikkaDTO tapahtumapaikka;
    private TapahtumaJarjestajaDTO jarjestaja;
    private int max_lippuja, lippujaJaljella;
    private String tapahtumaNimi, kuvaus;
    private Double perushinta;
    private ZonedDateTime alkaaPvm, loppuuPvm;
    
    public Long getTapahtumaId() {
        return tapahtumaId;
    }
    public void setTapahtumaId(Long tapahtumaId) {
        this.tapahtumaId = tapahtumaId;
    }
    public List<TapahtumaLipputyyppiDto> getLipputyypit() {
        return lipputyypit;
    }
    public void setLipputyypit(List<TapahtumaLipputyyppiDto> lipputyypit) {
        this.lipputyypit = lipputyypit;
    }
    public TapahtumaTapahtumapaikkaDTO getTapahtumapaikka() {
        return tapahtumapaikka;
    }
    public void setTapahtumapaikka(TapahtumaTapahtumapaikkaDTO tapahtumapaikka) {
        this.tapahtumapaikka = tapahtumapaikka;
    }
    public TapahtumaJarjestajaDTO getJarjestaja() {
        return jarjestaja;
    }
    public void setJarjestaja(TapahtumaJarjestajaDTO jarjestaja) {
        this.jarjestaja = jarjestaja;
    }
    public int getMax_lippuja() {
        return max_lippuja;
    }
    public void setMax_lippuja(int max_lippuja) {
        this.max_lippuja = max_lippuja;
    }
    public int getLippujaJaljella() {
        return lippujaJaljella;
    }
    public void setLippujaJaljella(int lippujaJaljella) {
        this.lippujaJaljella = lippujaJaljella;
    }
    public String getTapahtumaNimi() {
        return tapahtumaNimi;
    }
    public void setTapahtumaNimi(String tapahtumaNimi) {
        this.tapahtumaNimi = tapahtumaNimi;
    }
    public String getKuvaus() {
        return kuvaus;
    }
    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }
    public Double getPerushinta() {
        return perushinta;
    }
    public void setPerushinta(Double perushinta) {
        this.perushinta = perushinta;
    }
    public ZonedDateTime getAlkaaPvm() {
        return alkaaPvm;
    }
    public void setAlkaaPvm(ZonedDateTime alkaaPvm) {
        this.alkaaPvm = alkaaPvm;
    }
    public ZonedDateTime getLoppuuPvm() {
        return loppuuPvm;
    }
    public void setLoppuuPvm(ZonedDateTime loppuuPvm) {
        this.loppuuPvm = loppuuPvm;
    }
    
    
            
}
