package ohjelmistoprojekti.ticketguru.dto;

public class TapahtumaDto{

    private Long tapahtumaId;
    private Long lipputyyppiId;
    private int lippuMaara;

    // Getterit ja setterit
    public Long getTapahtumaId() {
        return tapahtumaId;
    }

    public void setTapahtumaId(Long tapahtumaId) {
        this.tapahtumaId = tapahtumaId;
    }

    public Long getLipputyyppiId() {
        return lipputyyppiId;
    }

    public void setLipputyyppiId(Long lipputyyppiId) {
        this.lipputyyppiId = lipputyyppiId;
    }

    public int getLippuMaara() {
        return lippuMaara;
    }

    public void setLippuMaara(int lippuMaara) {
        this.lippuMaara = lippuMaara;
    }
}
