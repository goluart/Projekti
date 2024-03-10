package ohjelmistoprojekti.ticketguru.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;

public class LuoMyyntitapahtumaDTO {

    @NotNull
    private Long tapahtumaId;
    private List<LippuTyyppiMaaraDTO> lippuTyyppiMaarat;

    public Long getTapahtumaId() {
        return tapahtumaId;
    }
    public void setTapahtumaId(Long tapahtumaId) {
        this.tapahtumaId = tapahtumaId;
    }
    public List<LippuTyyppiMaaraDTO> getLippuTyyppiMaarat() {
        return lippuTyyppiMaarat;
    }
    public void setLippuTyyppiMaarat(List<LippuTyyppiMaaraDTO> lippuTyyppiMaarat) {
        this.lippuTyyppiMaarat = lippuTyyppiMaarat;
    }   

    public static class LippuTyyppiMaaraDTO {

        @NotNull
        private Long lipputyyppiId;
        @NotNull
        private int lippuMaara;
        
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
}
