package ohjelmistoprojekti.ticketguru.domain;

import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;

public interface KayttajaRepository extends JpaRepository<Kayttaja, Long>{
	
	// Antaa virheilmoituksen:Kayttaja-entiteetissä ei ole name-nimistä ominaisuutta, johon kysely yrittää viitata.
	// List<Kayttaja> findByName(String salasana);

}
