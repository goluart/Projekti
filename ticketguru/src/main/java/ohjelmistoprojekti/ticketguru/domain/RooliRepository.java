package ohjelmistoprojekti.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RooliRepository extends CrudRepository<Rooli, Long> {
	
	List<Rooli> findByName(String rooli);

}
