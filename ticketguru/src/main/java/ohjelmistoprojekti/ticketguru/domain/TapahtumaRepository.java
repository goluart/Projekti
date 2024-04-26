package ohjelmistoprojekti.ticketguru.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TapahtumaRepository extends JpaRepository<Tapahtuma, Long> {
    List<Tapahtuma> findByTapahtumaId(Long tapahtumaId);

    List<Tapahtuma> findByTapahtumaNimi(String tapahtumaNimi);

}
