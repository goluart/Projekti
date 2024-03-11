package ohjelmistoprojekti.ticketguru.dto;

import java.time.ZonedDateTime;

public class LuoTapahtumaDTO {
    private String tapahtumaNimi;
    private ZonedDateTime luontiPvm;
    private ZonedDateTime alkaaPvm;
    private ZonedDateTime paattyyPvm;
    private String kuvaus;
    private int max_lippuja;
    private double perushinta;

    public LuoTapahtumaDTO() {
        super();
        this.tapahtumaNimi = null;
        this.luontiPvm = null;
        this.alkaaPvm = null;
        this.paattyyPvm = null;
        this.kuvaus = null;
        this.max_lippuja = 0;
        this.perushinta = 0;

    }

    public LuoTapahtumaDTO(String tapahtumaNimi, ZonedDateTime luontiPvm, ZonedDateTime alkaaPvm,
            ZonedDateTime paattyyPvm, String kuvaus, int max_lippuja, double perushinta) {

        this.tapahtumaNimi = tapahtumaNimi;
        this.luontiPvm = luontiPvm;
        this.alkaaPvm = alkaaPvm;
        this.paattyyPvm = paattyyPvm;
        this.kuvaus = kuvaus;
        this.max_lippuja = max_lippuja;
        this.perushinta = perushinta;
    }

    public String getTapahtumaNimi() {
        return tapahtumaNimi;
    }

    public void setTapahtumaNimi(String tapahtumaNimi) {
        this.tapahtumaNimi = tapahtumaNimi;
    }

    public ZonedDateTime getLuontiPvm() {
        return luontiPvm;
    }

    public void setLuontiPvm(ZonedDateTime luontiPvm) {
        this.luontiPvm = luontiPvm;
    }

    public ZonedDateTime getAlkaaPvm() {
        return alkaaPvm;
    }

    public void setAlkaaPvm(ZonedDateTime alkaaPvm) {
        this.alkaaPvm = alkaaPvm;
    }

    public ZonedDateTime getPaattyyPvm() {
        return paattyyPvm;
    }

    public void setPaattyyPvm(ZonedDateTime paattyyPvm) {
        this.paattyyPvm = paattyyPvm;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public int getMax_lippuja() {
        return max_lippuja;
    }

    public void setMax_lippuja(int max_lippuja) {
        this.max_lippuja = max_lippuja;
    }

    public double getPerushinta() {
        return perushinta;
    }

    public void setPerushinta(double perushinta) {
        this.perushinta = perushinta;
    }

    @Override
    public String toString() {
        return "LuoTapahtumaDTO [tapahtumaNimi=" + tapahtumaNimi + ", luontiPvm=" + luontiPvm + ", alkaaPvm=" + alkaaPvm
                + ", paattyyPvm=" + paattyyPvm + ", kuvaus=" + kuvaus + ", max_lippuja=" + max_lippuja + ", perushinta="
                + perushinta + "]";
    }

}
