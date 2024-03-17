package ohjelmistoprojekti.ticketguru.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Kayttaja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hlo_id")
	private Long hloId;
	//@Size(min = 6)
	private String tunnus;
	@NotBlank(message = "Salasana ei saa olla tyhjä")
    //@Size(min = 8, message = "Salasanan on oltava vähintään 8 merkkiä pitkä")
    //@Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-\\[\\]{}|;:'\",.<>\\/?]).+$", message = "Salasanan on sisällettävä vähintään yksi iso kirjain ja yksi erikoismerkki")
	private String salasana;
	@NotBlank(message = "Sukunimi ei saa olla tyhjä")
	private String snimi;
	@NotBlank(message = "Etunimi ei saa olla tyhjä")
	private String enimi;
	@Size(max = 500, message = "Lisätietojen maksimipituus on 500 merkkiä")
	private String lisatiedot;

	@ManyToOne
	@JoinColumn(name = "rooli_id")
	private Rooli rooli;

	public Kayttaja() {
	}

	public Kayttaja(String tunnus, String salasana, String snimi, String enimi, String lisatiedot, Rooli rooli) {
		super();
		this.tunnus = tunnus;
		this.salasana = salasana;
		this.snimi = snimi;
		this.enimi = enimi;
		this.lisatiedot = lisatiedot;
		this.rooli = rooli;
	}
	
	public Long getHloId() {
		return hloId;
	}
	
	public void setHloId(Long hloId) {
		this.hloId = hloId;
	}
	
	public String getTunnus() {
		return tunnus;
	}

	public void setTunnus(String tunnus) {
		this.tunnus = tunnus;
	}

	public String getSalasana() {
		return salasana;
	}

	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}

	public String getSnimi() {
		return snimi;
	}

	public void setSnimi(String snimi) {
		this.snimi = snimi;
	}

	public String getEnimi() {
		return enimi;
	}

	public void setEnimi(String enimi) {
		this.enimi = enimi;
	}

	public String getLisatiedot() {
		return lisatiedot;
	}

	public void setLisatiedot(String lisatiedot) {
		this.lisatiedot = lisatiedot;
	}

	public Rooli getRooli() {
		return rooli;
	}

	public void setRooli(Rooli rooli) {
		this.rooli = rooli;
	}

	@Override
	public String toString() {
		return "Kayttaja [hloId=" + hloId + ", tunnus=" + tunnus + ", snimi=" + snimi + ", enimi=" + enimi
				+ ", lisatiedot=" + lisatiedot + ", rooli=" + rooli + "]";
	}

}
