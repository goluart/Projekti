package ohjelmistoprojekti.ticketguru.dto;

import java.time.ZonedDateTime;
import java.util.List;

public class TapahtumaDto {

    private Long tapahtumaId;
    private String tapahtumaNimi, kuvaus;
    private ZonedDateTime alkaaPvm, loppuuPvm;
    private int maxLippuja, lippujaJaljella;
    private PaikkaDTO tapahtumapaikka;
    private JarjestajaDTO jarjestaja;
    private Double perushinta;
    private List<LipputyyppiDto> lipputyypit;    

    public TapahtumaDto(Long tapahtumaId, String tapahtumaNimi, String kuvaus, ZonedDateTime alkaaPvm,
            ZonedDateTime loppuuPvm, int maxLippuja, int lippujaJaljella, PaikkaDTO tapahtumapaikka,
            JarjestajaDTO jarjestaja, Double perushinta, List<LipputyyppiDto> lipputyypit) {
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
    public PaikkaDTO getTapahtumapaikka() {
        return tapahtumapaikka;
    }
    public void setTapahtumapaikka(PaikkaDTO tapahtumapaikka) {
        this.tapahtumapaikka = tapahtumapaikka;
    }
    public JarjestajaDTO getJarjestaja() {
        return jarjestaja;
    }
    public void setJarjestaja(JarjestajaDTO jarjestaja) {
        this.jarjestaja = jarjestaja;
    }
    public Double getPerushinta() {
        return perushinta;
    }
    public void setPerushinta(Double perushinta) {
        this.perushinta = perushinta;
    }
    public List<LipputyyppiDto> getLipputyypit() {
        return lipputyypit;
    }
    public void setLipputyypit(List<LipputyyppiDto> lipputyypit) {
        this.lipputyypit = lipputyypit;
    }

    public static class JarjestajaDTO {

        private Long jarjestajaId;
        private String jarjestajaNimi;
    
        public JarjestajaDTO(Long jarjestajaId, String jarjestajaNimi) {
            this.jarjestajaId = jarjestajaId;
            this.jarjestajaNimi = jarjestajaNimi;
        }
    
        public Long getJarjestajaId() {
            return jarjestajaId;
        }
    
        public void setJarjestajaId(Long jarjestajaId) {
            this.jarjestajaId = jarjestajaId;
        }
    
        public String getJarjestajaNimi() {
            return jarjestajaNimi;
        }
    
        public void setJarjestajaNimi(String jarjestajaNimi) {
            this.jarjestajaNimi = jarjestajaNimi;
        }         
    
    }

    public static class LipputyyppiDto {

        private Long lipputyyppiId;
        private String lipputyyppiNimi, asiakasryhma;
        private double hintakerroin;

        public LipputyyppiDto(Long lipputyyppiId, String lipputyyppiNimi, String asiakasryhma,
                double hintakerroin) {
            this.lipputyyppiId = lipputyyppiId;
            this.lipputyyppiNimi = lipputyyppiNimi;
            this.asiakasryhma = asiakasryhma;
            this.hintakerroin = hintakerroin;
        }
    
        public Long getLipputyyppiId() {
            return lipputyyppiId;
        }
        public void setLipputyyppiId(Long lipputyyppiId) {
            this.lipputyyppiId = lipputyyppiId;
        }
        public String getLipputyyppiNimi() {
            return lipputyyppiNimi;
        }
        public void setLipputyyppiNimi(String lipputyyppiNimi) {
            this.lipputyyppiNimi = lipputyyppiNimi;
        }
        public String getAsiakasryhma() {
            return asiakasryhma;
        }
        public void setAsiakasryhma(String asiakasryhma) {
            this.asiakasryhma = asiakasryhma;
        }
        public double getHintakerroin() {
            return hintakerroin;
        }
        public void setHintakerroin(double hintakerroin) {
            this.hintakerroin = hintakerroin;
        }
    }

    public static class PaikkaDTO {

        private Long tapahtumapaikkaId;
        private String tapahtumapaikkaNimi, tapahtumapaikkaOsoite, tapahtumapaikkaKaupunki;    
    
    
        public PaikkaDTO(Long tapahtumapaikkaId, String tapahtumapaikkaNimi, String tapahtumapaikkaOsoite,
                String tapahtumapaikkaKaupunki) {
            this.tapahtumapaikkaId = tapahtumapaikkaId;
            this.tapahtumapaikkaNimi = tapahtumapaikkaNimi;
            this.tapahtumapaikkaOsoite = tapahtumapaikkaOsoite;
            this.tapahtumapaikkaKaupunki = tapahtumapaikkaKaupunki;
        }
        
        public Long getTapahtumapaikkaId() {
            return tapahtumapaikkaId;
        }
        public void setTapahtumapaikkaId(Long tapahtumapaikkaId) {
            this.tapahtumapaikkaId = tapahtumapaikkaId;
        }
        public String getTapahtumapaikkaNimi() {
            return tapahtumapaikkaNimi;
        }
        public void setTapahtumapaikkaNimi(String tapahtumapaikkaNimi) {
            this.tapahtumapaikkaNimi = tapahtumapaikkaNimi;
        }
        public String getTapahtumapaikkaOsoite() {
            return tapahtumapaikkaOsoite;
        }
        public void setTapahtumapaikkaOsoite(String tapahtumapaikkaOsoite) {
            this.tapahtumapaikkaOsoite = tapahtumapaikkaOsoite;
        }
        public String getTapahtumapaikkaKaupunki() {
            return tapahtumapaikkaKaupunki;
        }
        public void setTapahtumapaikkaKaupunki(String tapahtumapaikkaKaupunki) {
            this.tapahtumapaikkaKaupunki = tapahtumapaikkaKaupunki;
        }    
    }       
                
}
