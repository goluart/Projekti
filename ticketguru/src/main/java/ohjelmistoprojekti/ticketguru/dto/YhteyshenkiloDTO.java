package ohjelmistoprojekti.ticketguru.dto;

import java.util.List;

import ohjelmistoprojekti.ticketguru.domain.Postitoimipaikka;
import ohjelmistoprojekti.ticketguru.dto.TapahtumaDto.JarjestajaDTO;
import ohjelmistoprojekti.ticketguru.dto.TapahtumaDto.PaikkaDTO;


public class YhteyshenkiloDTO {
    private Long yhtHloId;
    private String etunimi, sukunimi, sahkoposti, puhelin, lisatieto;
    private List<TapahtumaDto.JarjestajaDTO> jarjestajat;
    private PaikkaDTO tapahtumapaikka;    


    public YhteyshenkiloDTO() {
    }


    public YhteyshenkiloDTO(Long yhtHloId, String etunimi, String sukunimi, String sahkoposti, String puhelin,
            String lisatieto, List<JarjestajaDTO> jarjestajat, PaikkaDTO tapahtumapaikka) {
        this.yhtHloId = yhtHloId;
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.sahkoposti = sahkoposti;
        this.puhelin = puhelin;
        this.lisatieto = lisatieto;
        this.jarjestajat = jarjestajat;
        this.tapahtumapaikka = tapahtumapaikka;
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

    public void setJarjestajat(List<TapahtumaDto.JarjestajaDTO> jarjestajat) {
        this.jarjestajat = jarjestajat;
    }   
    
    public PaikkaDTO getTapahtumapaikka() {
        return tapahtumapaikka;
    }


    public void setTapahtumapaikka(PaikkaDTO tapahtumapaikka) {
        this.tapahtumapaikka = tapahtumapaikka;
    }
    
    public static class TapahtumapaikkaDTO {

        private Long tapaikkaId;
        private String paikkaNimi, osoite, ytunnus, sposti;
        
        public TapahtumapaikkaDTO() {
        }        

        public TapahtumapaikkaDTO(Long tapaikkaId, String paikkaNimi, String osoite, String ytunnus, String sposti,
                Postitoimipaikka postitoimipaikka) {
            this.tapaikkaId = tapaikkaId;
            this.paikkaNimi = paikkaNimi;
            this.osoite = osoite;
            this.ytunnus = ytunnus;
            this.sposti = sposti;
        }

        public Long getTapaikkaId() {
            return tapaikkaId;
        }

        public void setTapaikkaId(Long tapaikkaId) {
            this.tapaikkaId = tapaikkaId;
        }

        public String getPaikkaNimi() {
            return paikkaNimi;
        }

        public void setPaikkaNimi(String paikkaNimi) {
            this.paikkaNimi = paikkaNimi;
        }

        public String getOsoite() {
            return osoite;
        }

        public void setOsoite(String osoite) {
            this.osoite = osoite;
        }

        public String getYtunnus() {
            return ytunnus;
        }

        public void setYtunnus(String ytunnus) {
            this.ytunnus = ytunnus;
        }

        public String getSposti() {
            return sposti;
        }

        public void setSposti(String sposti) {
            this.sposti = sposti;
        }      

    }

    public static class TallennaYhteyshenkiloDTO {

        private Long yhtHloId, tapaikkaId;
        private String etunimi, sukunimi, sahkoposti, puhelin, lisatieto;

        public TallennaYhteyshenkiloDTO() {
        }

        public TallennaYhteyshenkiloDTO(Long yhtHloId, Long tapaikkaId, String etunimi, String sukunimi,
                String sahkoposti, String puhelin, String lisatieto) {
            this.yhtHloId = yhtHloId;
            this.tapaikkaId = tapaikkaId;
            this.etunimi = etunimi;
            this.sukunimi = sukunimi;
            this.sahkoposti = sahkoposti;
            this.puhelin = puhelin;
            this.lisatieto = lisatieto;
        }

        public Long getYhtHloId() {
            return yhtHloId;
        }

        public void setYhtHloId(Long yhtHloId) {
            this.yhtHloId = yhtHloId;
        }

        public Long getTapaikkaId() {
            return tapaikkaId;
        }

        public void setTapaikkaId(Long tapaikkaId) {
            this.tapaikkaId = tapaikkaId;
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
        
    }
    
}
