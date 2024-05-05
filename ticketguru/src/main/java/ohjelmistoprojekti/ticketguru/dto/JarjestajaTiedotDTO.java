package ohjelmistoprojekti.ticketguru.dto;

public class JarjestajaTiedotDTO {

    private Long jarjestajaId;
    private String nimi, ytunnus, osoite, postinumero, kaupunki;

    public JarjestajaTiedotDTO() {

    }

    public JarjestajaTiedotDTO(Long jarjestajaId, String nimi, String ytunnus, String osoite, String postinumero,
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

    
}
