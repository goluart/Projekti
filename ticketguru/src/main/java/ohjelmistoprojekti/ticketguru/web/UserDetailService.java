package ohjelmistoprojekti.ticketguru.web;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ohjelmistoprojekti.ticketguru.domain.Kayttaja;
import ohjelmistoprojekti.ticketguru.domain.KayttajaRepository;

@Service
public class UserDetailService implements UserDetailsService {

	private final KayttajaRepository kRepository;
<<<<<<< HEAD
	
=======

	@Autowired
>>>>>>> a541187f68e7a5913050866e2b68babf26910f87
	public UserDetailService(KayttajaRepository kayttajaRepository) {
		this.kRepository = kayttajaRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String tunnus) throws UsernameNotFoundException {
		Kayttaja nytKayttaja = kRepository.findByTunnus(tunnus);
		UserDetails kayttaja = new org.springframework.security.core.userdetails.User(tunnus, nytKayttaja.getSalasana(),
				AuthorityUtils.createAuthorityList(nytKayttaja.getRooli().getRooliNimi()));
		return kayttaja;
	}

}
