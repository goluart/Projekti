package ohjelmistoprojekti.ticketguru.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@Entity
public class Myyntitapahtuma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "myyntitapahtuma_id")
	private Long myyntitapahtumaId;
	@NotNull
	@Column(name = "myyntitapahtuma_pvm")
	private LocalDateTime myyntitapahtumaPvm;

	@JsonIgnore
	// CascadeType.ALL poistaa myös siihen liitetyt liput, kun myyntitapahtuma poistetaan. 
	// Myyntitapahtuman voi poistaa, jos yhtään lippua ei ole käytetty
	@OneToMany(mappedBy = "myyntitapahtuma", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Column(name = "myyntitapahtuma_id")
	private List<Lippu> liput = new ArrayList<>();
	@DecimalMin(value = "0.1", inclusive = true)
	private double loppusumma;

	public Myyntitapahtuma() {
		super();
	}    

	public Myyntitapahtuma(@NotNull LocalDateTime myyntitapahtumaPvm, List<Lippu> liput,
            @DecimalMin(value = "0.01", inclusive = true) double loppusumma) {
        this.myyntitapahtumaPvm = myyntitapahtumaPvm;
        this.liput = liput;
        this.loppusumma = loppusumma;
    }

    public Myyntitapahtuma(LocalDateTime myyntitapahtumaPvm, double loppusumma) {
		this.myyntitapahtumaPvm = myyntitapahtumaPvm;
        this.loppusumma = loppusumma;       
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

	public LocalDateTime getMyyntitapahtumaPvm() {
		return myyntitapahtumaPvm;
	}

	public void setMyyntitapahtumaPvm(LocalDateTime myyntitapahtumaPvm) {
		this.myyntitapahtumaPvm = myyntitapahtumaPvm;
	}

	public double getLoppusumma() {
		return loppusumma;
	}

	public void setLoppusumma(double loppusumma) {
		this.loppusumma = loppusumma;
	}

	@Override
	public String toString() {
		return "Myyntitapahtuma [myyntitapahtumaId=" + myyntitapahtumaId + ", myyntitapahtumaPvm=" + myyntitapahtumaPvm
				+ ", loppusumma=" + loppusumma + "]";
	}

}
