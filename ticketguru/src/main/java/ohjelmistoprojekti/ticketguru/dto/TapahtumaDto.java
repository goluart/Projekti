package ohjelmistoprojekti.ticketguru.dto;

import java.time.ZonedDateTime;
import java.util.List;

public class TapahtumaDto {

    private Long tapahtumaId;
    private String tapahtumaNimi, kuvaus;
    private ZonedDateTime alkaaPvm, loppuuPvm;
    private int maxLippuja, lippujaJaljella;
    private TapahtumaTapahtumapaikkaDTO tapahtumapaikka;
    private TapahtumaJarjestajaDTO jarjestaja;
    private Double perushinta;
    private List<TapahtumaLipputyyppiDto> lipputyypit;    

    public TapahtumaDto(Long tapahtumaId, String tapahtumaNimi, String kuvaus, ZonedDateTime alkaaPvm,
            ZonedDateTime loppuuPvm, int maxLippuja, int lippujaJaljella, TapahtumaTapahtumapaikkaDTO tapahtumapaikka,
            TapahtumaJarjestajaDTO jarjestaja, Double perushinta, List<TapahtumaLipputyyppiDto> lipputyypit) {
        this.tapahtumaId = tapahtumaId;
        this.tapahtumaNimi = tapahtumaNimi;
        this.kuvaus = kuvaus;
        this.alkaaPvm = alkaaPvm;
        this.loppuuPvm = loppuuPvm;
        this.maxLippuja = maxLippuja;
        this.lippujaJaljella = lippujaJaljella;
        this.tapahtumapaikka = tapahtumapaikka;
        this.jarjestaja = jarjestaja;
        this.perushinta = perushinta;
        this.lipputyypit = lipputyypit;
    }
    
    public Long getTapahtumaId() {
        return tapahtumaId;
    }
    public void setTapahtumaId(Long tapahtumaId) {
        this.tapahtumaId = tapahtumaId;
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
    public int getMaxLippuja() {
        return maxLippuja;
    }
    public void setMaxLippuja(int maxLippuja) {
        this.maxLippuja = maxLippuja;
    }
    public int getLippujaJaljella() {
        return lippujaJaljella;
    }
    public void setLippujaJaljella(int lippujaJaljella) {
        this.lippujaJaljella = lippujaJaljella;
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
    public Double getPerushinta() {
        return perushinta;
    }
    public void setPerushinta(Double perushinta) {
        this.perushinta = perushinta;
    }
    public List<TapahtumaLipputyyppiDto> getLipputyypit() {
        return lipputyypit;
    }
    public void setLipputyypit(List<TapahtumaLipputyyppiDto> lipputyypit) {
        this.lipputyypit = lipputyypit;
    }
        
                
}
