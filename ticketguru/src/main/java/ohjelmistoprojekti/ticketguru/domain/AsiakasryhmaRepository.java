package ohjelmistoprojekti.ticketguru.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AsiakasryhmaRepository extends JpaRepository<Asiakasryhma, Long> {

    List<Asiakasryhma> findByNimi(String nimi);
}
