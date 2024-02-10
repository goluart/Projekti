package ohjelmistoprojekti.ticketguru.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AsiakasryhmaRepository extends CrudRepository<Asiakasryhma, Long> {

    List<Asiakasryhma> findByNimi(String nimi);
}
