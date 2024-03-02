package ohjelmistoprojekti.ticketguru.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LippuRepository extends JpaRepository<Lippu, Long> {

    List<Lippu> findByTarkistuskoodi(String tarkistuskoodi);
}
