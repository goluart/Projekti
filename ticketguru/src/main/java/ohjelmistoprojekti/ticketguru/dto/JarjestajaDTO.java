package ohjelmistoprojekti.ticketguru.dto;

import java.util.List;

import ohjelmistoprojekti.ticketguru.dto.YhteyshenkiloDTO.TallennaYhteyshenkiloDTO;
import ohjelmistoprojekti.ticketguru.dto.YhteyshenkiloDTO.YhteyshenkiloYhteystiedotDTO;

public class JarjestajaDTO {

    private Long jarjestajaId;
    private String nimi, ytunnus, osoite, postinumero, kaupunki;
    private List<YhteyshenkiloYhteystiedotDTO> yhteyshenkilot;

    public JarjestajaDTO() {

    }    

    public JarjestajaDTO(Long jarjestajaId, String nimi, String ytunnus, String osoite, String postinumero,
            String kaupunki, List<YhteyshenkiloYhteystiedotDTO> yhteyshenkilot) {
        this.jarjestajaId = jarjestajaId;
        this.nimi = nimi;
        this.ytunnus = ytunnus;
        this.osoite = osoite;
        this.postinumero = postinumero;
        this.kaupunki = kaupunki;
        this.yhteyshenkilot = yhteyshenkilot;
    }

    public JarjestajaDTO(Long jarjestajaId, String nimi, String ytunnus, String osoite, String postinumero,
            String kaupunki) {
        this.jarjestajaId = jarjestajaId;
        this.nimi = nimi;
        this.ytunnus = ytunnus;
        this.osoite = osoite;
        this.postinumero = postinumero;
        this.kaupunki = kaupunki;
    }
    
    public Long getJarjestajaId() {
        return jarjestajaId;
    }
    
    public void setJarjestajaId(Long jarjestajaId) {
        this.jarjestajaId = jarjestajaId;
    }
    
    public String getNimi() {
        return nimi;
    }
    
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    public String getYtunnus() {
        return ytunnus;
    }
    
    public void setYtunnus(String ytunnus) {
        this.ytunnus = ytunnus;
    }
    
    public String getOsoite() {
        return osoite;
    }
    
    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }
    
    public String getPostinumero() {
        return postinumero;
    }
    
    public void setPostinumero(String postinumero) {
        this.postinumero = postinumero;
    }
    
    public String getKaupunki() {
        return kaupunki;
    }
    
    public void setKaupunki(String kaupunki) {
        this.kaupunki = kaupunki;
    }
    
    public List<YhteyshenkiloYhteystiedotDTO> getYhteyshenkilot() {
        return yhteyshenkilot;
    }

    public void setYhteyshenkilot(List<YhteyshenkiloYhteystiedotDTO> yhteyshenkilot) {
        this.yhteyshenkilot = yhteyshenkilot;
    }    
    
    @Override
    public String toString() {
        return "JarjestajaDTO [jarjestajaId=" + jarjestajaId + ", nimi=" + nimi + ", ytunnus=" + ytunnus + ", osoite="
                + osoite + ", postinumero=" + postinumero + ", kaupunki=" + kaupunki + "]";
    }

    public static class JarjestajaNimiDTO {
    
        private Long jarjestajaId;
        private String jarjestajaNimi;
    
        public JarjestajaNimiDTO(Long jarjestajaId, String jarjestajaNimi) {
            this.jarjestajaId = jarjestajaId;
            this.jarjestajaNimi = jarjestajaNimi;
        }
    
        public JarjestajaNimiDTO() {
            
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

    public static class TallennaJarjestajaDTO {
        private Long jarjestajaId;
        private String nimi, ytunnus, osoite, postinumero, kaupunki;
        private List<TallennaYhteyshenkiloDTO> yhteyshenkilot;
        
        public TallennaJarjestajaDTO() {
        }

        public TallennaJarjestajaDTO(Long jarjestajaId, String nimi, String ytunnus, String osoite, String postinumero,
                String kaupunki, List<TallennaYhteyshenkiloDTO> yhteyshenkilot) {
            this.jarjestajaId = jarjestajaId;
            this.nimi = nimi;
            this.ytunnus = ytunnus;
            this.osoite = osoite;
            this.postinumero = postinumero;
            this.kaupunki = kaupunki;
            this.yhteyshenkilot = yhteyshenkilot;
        }

        public Long getJarjestajaId() {
            return jarjestajaId;
        }

        public void setJarjestajaId(Long jarjestajaId) {
            this.jarjestajaId = jarjestajaId;
        }

        public String getNimi() {
            return nimi;
        }

        public void setNimi(String nimi) {
            this.nimi = nimi;
        }

        public String getYtunnus() {
            return ytunnus;
        }

        public void setYtunnus(String ytunnus) {
            this.ytunnus = ytunnus;
        }

        public String getOsoite() {
            return osoite;
        }

        public void setOsoite(String osoite) {
            this.osoite = osoite;
        }

        public String getPostinumero() {
            return postinumero;
        }

        public void setPostinumero(String postinumero) {
            this.postinumero = postinumero;
        }

        public String getKaupunki() {
            return kaupunki;
        }

        public void setKaupunki(String kaupunki) {
            this.kaupunki = kaupunki;
        }

        public List<TallennaYhteyshenkiloDTO> getYhteyshenkilot() {
            return yhteyshenkilot;
        }

        public void setYhteyshenkilo(List<TallennaYhteyshenkiloDTO> yhteyshenkilot) {
            this.yhteyshenkilot = yhteyshenkilot;
        }

        

        

    }

}
