<<<<<<< HEAD
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
=======
package ohjelmistoprojekti.ticketguru.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ohjelmistoprojekti.ticketguru.domain.Jarjestaja;
import ohjelmistoprojekti.ticketguru.domain.Lipputyyppi;
import ohjelmistoprojekti.ticketguru.domain.Tapahtuma;
import ohjelmistoprojekti.ticketguru.domain.Tapahtumapaikka;
import ohjelmistoprojekti.ticketguru.dto.TapahtumaDto;

@Service
public class TapahtumaService {

    public TapahtumaDto naytaTapahtumaDto(Tapahtuma tapahtuma) {

        TapahtumaDto tDto = new TapahtumaDto(tapahtuma.getTapahtumaId(), tapahtuma.getTapahtumaNimi(),
                tapahtuma.getKuvaus(), tapahtuma.getAlkaaPvm(), tapahtuma.getPaattyyPvm(), tapahtuma.getMax_lippuja(),
                tapahtuma.getLippujaJaljella(), muunnaPaikka(tapahtuma.getTapahtumapaikka()),
                muunnaJarjestaja(tapahtuma.getJarjestaja()), tapahtuma.getPerushinta(),
                muunnaLipputyyppiLista(tapahtuma.getLipputyypit()));

        return tDto;
    }

    private TapahtumaDto.PaikkaDTO muunnaPaikka(Tapahtumapaikka paikka) {
        return new TapahtumaDto.PaikkaDTO(paikka.getTapaikkaId(), paikka.getPaikkaNimi(), paikka.getOsoite(),
                paikka.getPostitoimipaikka().getKaupunki());

    }

    private TapahtumaDto.JarjestajaDTO muunnaJarjestaja(Jarjestaja jarjestaja) {
        return new TapahtumaDto.JarjestajaDTO(jarjestaja.getJarjestajaId(), jarjestaja.getNimi());
    }

    private List<TapahtumaDto.LipputyyppiDto> muunnaLipputyyppiLista(Set<Lipputyyppi> lipputyypit) {
        return lipputyypit.stream()
                .map(lipputyyppi -> new TapahtumaDto.LipputyyppiDto(
                        lipputyyppi.getLipputyyppiId(),
                        lipputyyppi.getNimi(),
                        lipputyyppi.getAsiakasryhma().getNimi(),
                        lipputyyppi.getHintakerroin()))
                .collect(Collectors.toList());
    }

}
>>>>>>> 215c97ed6d15fc82a99d64f5caedf1f0ffaa6562
