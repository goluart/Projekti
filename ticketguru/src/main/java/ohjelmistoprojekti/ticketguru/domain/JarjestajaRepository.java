package ohjelmistoprojekti.ticketguru.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JarjestajaRepository extends JpaRepository<Jarjestaja, Long> {

    List<Jarjestaja> findByNimi(String nimi);

}
