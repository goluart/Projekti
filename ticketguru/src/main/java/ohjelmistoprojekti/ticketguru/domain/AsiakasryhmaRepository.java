package ohjelmistoprojekti.ticketguru.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AsiakasryhmaRepository extends JpaRepository<Asiakasryhma, Long> {

    Asiakasryhma findByNimi(String nimi);
}
