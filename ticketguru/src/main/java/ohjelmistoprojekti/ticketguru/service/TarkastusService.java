package ohjelmistoprojekti.ticketguru.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ohjelmistoprojekti.ticketguru.domain.Tarkastus;
import ohjelmistoprojekti.ticketguru.domain.TarkastusRepository;
import ohjelmistoprojekti.ticketguru.dto.TarkastusDTO;

@Service
public class TarkastusService {

    @Autowired
    TarkastusRepository tarkastusRepository;

    public List<TarkastusDTO> haeKaikkiTarkastukset() {
        return tarkastusRepository.findAll()
                .stream()
                .map(this::muutaLuokkaDtoksi)
                .collect(Collectors.toList());
    }

    private TarkastusDTO muutaLuokkaDtoksi(Tarkastus tarkastus) {
        TarkastusDTO tarkastusDTO = new TarkastusDTO();
        tarkastusDTO.setTarkastusId(tarkastus.getTarkastusId());
        tarkastusDTO.setKayttoPvm(tarkastus.getKayttoPvm());
        tarkastusDTO.setTarkistuskoodi(tarkastus.getLippu().getTarkistuskoodi());
        tarkastusDTO.setTapahtumaNimi(tarkastus.getLippu().getTapahtuma().getTapahtumaNimi());
        tarkastusDTO.setLipputyyppi(tarkastus.getLippu().getLipputyyppi().getNimi());
        tarkastusDTO.setPaikkaNimi(tarkastus.getLippu().getTapahtuma().getTapahtumapaikka().getPaikkaNimi());
        return tarkastusDTO;

    }
}