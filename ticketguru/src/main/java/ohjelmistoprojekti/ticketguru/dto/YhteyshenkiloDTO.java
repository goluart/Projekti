package ohjelmistoprojekti.ticketguru.dto;

import ohjelmistoprojekti.ticketguru.domain.Postitoimipaikka;
import ohjelmistoprojekti.ticketguru.dto.JarjestajaDTO.JarjestajaNimiDTO;
import ohjelmistoprojekti.ticketguru.dto.TapahtumaDto.PaikkaDTO;


public class YhteyshenkiloDTO {
    private Long yhtHloId;
    private String etunimi, sukunimi, sahkoposti, puhelin, lisatieto;
    private JarjestajaNimiDTO jarjestaja;
    private PaikkaDTO tapahtumapaikka;    


    public YhteyshenkiloDTO() {
    }


    public YhteyshenkiloDTO(Long yhtHloId, String etunimi, String sukunimi, String sahkoposti, String puhelin,
            String lisatieto) {
        this.yhtHloId = yhtHloId;
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


    public JarjestajaNimiDTO getJarjestaja() {
        return jarjestaja;
    }


    public void setJarjestaja(JarjestajaNimiDTO jarjestaja) {
        this.jarjestaja = jarjestaja;
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

        private Long yhtHloId, tapaikkaId, jarjestajaId;
        private String etunimi, sukunimi, sahkoposti, puhelin, lisatieto;

        public TallennaYhteyshenkiloDTO() {
        }

        public TallennaYhteyshenkiloDTO(Long yhtHloId, Long tapaikkaId, Long jarjastajaId, String etunimi, String sukunimi,
                String sahkoposti, String puhelin, String lisatieto) {
            this.yhtHloId = yhtHloId;
            this.tapaikkaId = tapaikkaId;
            this.jarjestajaId = jarjastajaId;
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
        public Long getJarjestajaId() {
            return jarjestajaId;
        }

        public void setJarjestajaId(Long jarjestajaId) {
            this.jarjestajaId = jarjestajaId;
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
