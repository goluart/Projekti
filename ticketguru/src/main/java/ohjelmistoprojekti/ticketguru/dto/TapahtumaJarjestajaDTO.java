package ohjelmistoprojekti.ticketguru.dto;

public class TapahtumaJarjestajaDTO {

    private Long jarjestajaId;
    private String jarjestajaNimi;

    public TapahtumaJarjestajaDTO(Long jarjestajaId, String jarjestajaNimi) {
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
