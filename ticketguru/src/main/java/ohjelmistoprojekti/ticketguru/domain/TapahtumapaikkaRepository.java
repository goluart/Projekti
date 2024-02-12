package ohjelmistoprojekti.ticketguru.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TapahtumapaikkaRepository extends CrudRepository<Tapahtumapaikka, Long> {

}
