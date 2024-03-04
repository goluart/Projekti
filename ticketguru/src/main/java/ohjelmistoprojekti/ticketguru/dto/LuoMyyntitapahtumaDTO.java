package ohjelmistoprojekti.ticketguru.dto;

import java.util.List;

public class LuoMyyntitapahtumaDTO {

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
}
