package ohjelmistoprojekti.ticketguru.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface JarjestajaRepository extends CrudRepository<Jarjestaja, Long> {

    List<Jarjestaja> findByNimi(String nimi);

}
