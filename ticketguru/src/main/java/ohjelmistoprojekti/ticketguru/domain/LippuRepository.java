package ohjelmistoprojekti.ticketguru.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LippuRepository extends JpaRepository<Lippu, Long> {

    Lippu findByTarkistuskoodi(String tarkistuskoodi);
}
