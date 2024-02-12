package ohjelmistoprojekti.ticketguru.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface YhteyshenkiloRepository extends CrudRepository<Yhteyshenkilo, Long> {

    List<Yhteyshenkilo> findByEtunimi(String etunimi);

    List<Yhteyshenkilo> findBySukunimi(String sukunimi);
}
