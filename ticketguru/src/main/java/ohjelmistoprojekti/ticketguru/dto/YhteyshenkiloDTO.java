package ohjelmistoprojekti.ticketguru.dto;

import java.util.List;

import ohjelmistoprojekti.ticketguru.dto.TapahtumaDto.JarjestajaDTO;
import ohjelmistoprojekti.ticketguru.dto.TapahtumaDto.PaikkaDTO;

public class YhteyshenkiloDTO {
    private Long yhtHloId;
    private String etunimi, sukunimi, sahkoposti, puhelin, lisatieto;
    private List<TapahtumaDto.JarjestajaDTO> jarjestajat;
    private TapahtumaDto.PaikkaDTO tapahtumapaikka;    


    public YhteyshenkiloDTO() {
    }


    public YhteyshenkiloDTO(Long yhtHloId, String etunimi, String sukunimi, String sahkoposti, String puhelin,
            String lisatieto, List<JarjestajaDTO> jarjestajat) {
        this.yhtHloId = yhtHloId;
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.sahkoposti = sahkoposti;
        this.puhelin = puhelin;
        this.lisatieto = lisatieto;
        this.jarjestajat = jarjestajat;
    }

    public Long getYhtHloId() {
        return yhtHloId;
    }


    public void setYhtHloId(Long yhtHloId) {
        this.yhtHloId = yhtHloId;
    }


    public String getEtunimi() {
        return etunimi;
    }


    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }


    public String getSukunimi() {
        return sukunimi;
    }


    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }


    public String getSahkoposti() {
        return sahkoposti;
    }


    public void setSahkoposti(String sahkoposti) {
        this.sahkoposti = sahkoposti;
    }


    public String getPuhelin() {
        return puhelin;
    }


    public void setPuhelin(String puhelin) {
        this.puhelin = puhelin;
    }


    public String getLisatieto() {
        return lisatieto;
    }


    public void setLisatieto(String lisatieto) {
        this.lisatieto = lisatieto;
    }


    public List<TapahtumaDto.JarjestajaDTO> getJarjestajat() {
        return jarjestajat;
    }


    public void setJarjestaja(List<TapahtumaDto.JarjestajaDTO> jarjestajat) {
        this.jarjestajat = jarjestajat;
    }


    public PaikkaDTO getTapahtumapaikka() {
        return tapahtumapaikka;
    }


    public void setTapahtumapaikka(PaikkaDTO tapahtumapaikka) {
        this.tapahtumapaikka = tapahtumapaikka;
    }        
    
}
