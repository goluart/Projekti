package ohjelmistoprojekti.ticketguru.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ohjelmistoprojekti.ticketguru.domain.Rooli;
import ohjelmistoprojekti.ticketguru.domain.RooliRepository;
import ohjelmistoprojekti.ticketguru.dto.RooliDTO;
import ohjelmistoprojekti.ticketguru.dto.RooliKayttajaDTO;

@Service
public class RooliKayttajaService {

    @Autowired
    private RooliRepository rooliRepository;

    public List<RooliDTO> haeKaikkiRoolit() {
        return rooliRepository.findAll()
                .stream()
                .map(this::muutaRooliDTO)
                .collect(Collectors.toList());
    }

    public Optional<RooliDTO> haeRooliById(Long rooliId) {
        Optional<Rooli> rooli = rooliRepository.findById(rooliId);
        return rooli.map(this::muutaRooliDTO);
    }

    private RooliDTO muutaRooliDTO(Rooli rooli) {
        RooliDTO rooliDTO = new RooliDTO();
        rooliDTO.setRooliId(rooli.getRooliId());
        rooliDTO.setRooliNimi(rooli.getRooliNimi());
        List<RooliKayttajaDTO> kayttajatDTO = rooli.getKayttajat().stream()
                .map(kayttaja -> new RooliKayttajaDTO(kayttaja.getHloId(), kayttaja.getEnimi(), kayttaja.getSnimi()))
                .collect(Collectors.toList());
        rooliDTO.setKayttajat(kayttajatDTO);
        return rooliDTO;

    }
}
