package ohjelmistoprojekti.ticketguru.domain;

// import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RooliRepository extends CrudRepository<Rooli, Long> {
	
	// Antaa virheilmoituksen:Kayttaja-entiteetissä ei ole name-nimistä ominaisuutta, johon kysely yrittää viitata.
	// List<Rooli> findByName(String rooli);

}
