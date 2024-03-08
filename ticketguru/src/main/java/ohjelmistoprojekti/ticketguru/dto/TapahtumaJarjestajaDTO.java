package ohjelmistoprojekti.ticketguru.dto;

public class TapahtumaJarjestajaDTO {

    private Long jarestajaId;
    private String jarestajaNimi;
   
    public TapahtumaJarjestajaDTO(Long jarestajaId, String jarestajaNimi) {
        this.jarestajaId = jarestajaId;
        this.jarestajaNimi = jarestajaNimi;
    }

    public void setJarestajaNimi(String jarestajaNimi) {
        this.jarestajaNimi = jarestajaNimi;
    }

    public Long getJarestajaId() {
        return jarestajaId;
    }
    public void setJarestajaId(Long jarestajaId) {
        this.jarestajaId = jarestajaId;
    }
    public String getJarestajaNimi() {
        return jarestajaNimi;
    }   

}
