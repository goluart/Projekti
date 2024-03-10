package ohjelmistoprojekti.ticketguru.dto;

import java.util.List;

import io.micrometer.common.lang.NonNull;

public class LuoMyyntitapahtumaDTO {

    @NonNull
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

        private Long lipputyyppiId;
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
