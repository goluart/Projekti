package ohjelmistoprojekti.ticketguru.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface YhteyshenkiloRepository extends JpaRepository<Yhteyshenkilo, Long> {

    List<Yhteyshenkilo> findByEtunimi(String etunimi);

    List<Yhteyshenkilo> findBySukunimi(String sukunimi);
}
