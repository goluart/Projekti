package ohjelmistoprojekti.ticketguru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ohjelmistoprojekti.ticketguru.domain.Tapahtuma;
import ohjelmistoprojekti.ticketguru.domain.TapahtumaRepository;
import ohjelmistoprojekti.ticketguru.dto.LuoTapahtumaDTO;

import java.util.List;
import java.util.Optional;

@Service
public class TapahtumaService {

    @Autowired
    private TapahtumaRepository tapahtumaRepository;

    public Tapahtuma saveTapahtuma(LuoTapahtumaDTO luoTapahtumaDTO) {
        Tapahtuma tapahtuma = new Tapahtuma(luoTapahtumaDTO.getTapahtumaNimi(),
                luoTapahtumaDTO.getLuontiPvm(),
                luoTapahtumaDTO.getAlkaaPvm(), luoTapahtumaDTO.getPaattyyPvm(), luoTapahtumaDTO.getKuvaus(),
                luoTapahtumaDTO.getMax_lippuja(), luoTapahtumaDTO.getPerushinta());

        return tapahtumaRepository.save(tapahtuma);
    }

    public List<Tapahtuma> haeKaikkiTapahtumat() {
        return tapahtumaRepository.findAll();
    }

    @SuppressWarnings("null")
    public Optional<Tapahtuma> haeTapahtuma(Long id) {
        return tapahtumaRepository.findById(id);
    }
}
