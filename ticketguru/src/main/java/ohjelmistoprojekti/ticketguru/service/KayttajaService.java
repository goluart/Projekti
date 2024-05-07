package ohjelmistoprojekti.ticketguru.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ohjelmistoprojekti.ticketguru.domain.Kayttaja;
import ohjelmistoprojekti.ticketguru.domain.KayttajaRepository;
import ohjelmistoprojekti.ticketguru.dto.KayttajaDTO;

@Service
public class KayttajaService {

    @Autowired
    private KayttajaRepository kayttajaRepository;

    public List<KayttajaDTO> haeKaikkiKayttajat() {
        return kayttajaRepository.findAll()
                .stream()
                .map(this::muutaKayttajaDTO)
                .collect(Collectors.toList());
    }

    public Optional<KayttajaDTO> haeKayttajaById(Long hloId) {
        Optional<Kayttaja> kayttaja = kayttajaRepository.findById(hloId);
        return kayttaja.map(this::muutaKayttajaDTO);
    }

    private KayttajaDTO muutaKayttajaDTO(Kayttaja kayttaja) {
        KayttajaDTO kayttajaDTO = new KayttajaDTO();
        kayttajaDTO.setHloId(kayttaja.getHloId());
        kayttajaDTO.setTunnus(kayttaja.getTunnus());
        kayttajaDTO.setSnimi(kayttaja.getSnimi());
        kayttajaDTO.setEnimi(kayttaja.getEnimi());
        kayttajaDTO.setLisatiedot(kayttaja.getLisatiedot());
        kayttajaDTO.setRooliNimi(kayttaja.getRooli().getRooliNimi());
        return kayttajaDTO;
    }
}
