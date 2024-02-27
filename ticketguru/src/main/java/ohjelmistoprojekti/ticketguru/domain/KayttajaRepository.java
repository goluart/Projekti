package ohjelmistoprojekti.ticketguru.domain;

// import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface KayttajaRepository extends CrudRepository<Kayttaja, Long>{
	
	// Antaa virheilmoituksen:Kayttaja-entiteetissä ei ole name-nimistä ominaisuutta, johon kysely yrittää viitata.
	// List<Kayttaja> findByName(String salasana);

}
