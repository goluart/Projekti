package ohjelmistoprojekti.ticketguru.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostitoimipaikkaRepository extends JpaRepository<Postitoimipaikka, Long> {

    Postitoimipaikka findByPostinumero(String postinumero); 

}
