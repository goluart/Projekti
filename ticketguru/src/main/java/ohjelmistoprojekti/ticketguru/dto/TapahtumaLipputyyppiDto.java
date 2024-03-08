package ohjelmistoprojekti.ticketguru.dto;

public class TapahtumaLipputyyppiDto {

    private Long lipputyyppiId;
    private String lipputyyppiNimi, asiakasryhma;
    private double hintakerroin;

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
