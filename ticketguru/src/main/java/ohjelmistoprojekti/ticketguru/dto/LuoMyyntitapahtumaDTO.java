package ohjelmistoprojekti.ticketguru.dto;

import java.util.List;

public class LuoMyyntitapahtumaDTO {

    private Long tapahtumaId;
    private List<LippuTyyppiMaaraDTO> lippuTyyppiMaarat;

    public LuoMyyntitapahtumaDTO() {
    }

    public LuoMyyntitapahtumaDTO(Long tapahtumaId, List<LippuTyyppiMaaraDTO> lippuTyyppiMaarat) {
        this.tapahtumaId = tapahtumaId;
        this.lippuTyyppiMaarat = lippuTyyppiMaarat;
    }

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

        public LippuTyyppiMaaraDTO(Long lipputyyppiId, int lippuMaara) {
            this.lipputyyppiId = lipputyyppiId;
            this.lippuMaara = lippuMaara;
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
}
