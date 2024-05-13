package ohjelmistoprojekti.ticketguru.domain;

import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;

public interface RooliRepository extends JpaRepository<Rooli, Long> {

	// Antaa virheilmoituksen:Kayttaja-entiteetissä ei ole name-nimistä
	// ominaisuutta, johon kysely yrittää viitata.
	// List<Rooli> findByName(String rooli);

}
