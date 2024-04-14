package ohjelmistoprojekti.ticketguru.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LipputyyppiRepository extends JpaRepository<Lipputyyppi, Long> {

    List<Lipputyyppi> findByNimi(String nimi);
    

    
}
