package ohjelmistoprojekti.ticketguru.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KayttajaRepository extends JpaRepository<Kayttaja, Long>{
	
	// Antaa virheilmoituksen:Kayttaja-entiteetissä ei ole name-nimistä ominaisuutta, johon kysely yrittää viitata.
	// -> name vaihdettu tunnus, jonka pitäisi löytyä Kayttaja-luokasta
	Kayttaja findByTunnus(String tunnus);

}
