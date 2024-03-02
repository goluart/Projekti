package ohjelmistoprojekti.ticketguru.domain;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Myyntitapahtuma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "myyntitapahtuma_id")
    private Long myyntitapahtumaId;

    @OneToMany(mappedBy = "myyntitapahtuma", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="myyntitapahtuma_id")
    private List<Lippu> liput = new ArrayList<>();

    public Myyntitapahtuma() {
        super();
    }

    public Myyntitapahtuma(Long myyntitapahtumaId, List<Lippu> liput) {
        this.myyntitapahtumaId = myyntitapahtumaId;
        this.liput = liput;
    }

    public Long getMyyntitapahtumaId() {
        return myyntitapahtumaId;
    }

    public void setMyyntitapahtumaId(Long myyntitapahtumaId) {
        this.myyntitapahtumaId = myyntitapahtumaId;
    }

    public List<Lippu> getLiput() {
        return liput;
    }

    public void setLiput(List<Lippu> liput) {
        this.liput = liput;
    }

    @Override
    public String toString() {
        return "Myyntitapahtuma [myyntitapahtumaId=" + myyntitapahtumaId + "]";
    }

    

    



    

    


}
