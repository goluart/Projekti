package ohjelmistoprojekti.ticketguru.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ohjelmistoprojekti.ticketguru.domain.Jarjestaja;
import ohjelmistoprojekti.ticketguru.domain.Lipputyyppi;
import ohjelmistoprojekti.ticketguru.domain.Tapahtuma;
import ohjelmistoprojekti.ticketguru.domain.Tapahtumapaikka;
import ohjelmistoprojekti.ticketguru.domain.Yhteyshenkilo;
import ohjelmistoprojekti.ticketguru.dto.TapahtumaDto;
import ohjelmistoprojekti.ticketguru.dto.YhteyshenkiloDTO;

@Service
public class TapahtumaService {

    public TapahtumaDto naytaTapahtumaDto(Tapahtuma tapahtuma) {

        TapahtumaDto tDto = new TapahtumaDto(tapahtuma.getTapahtumaId(), tapahtuma.getTapahtumaNimi(),
                tapahtuma.getKuvaus(), tapahtuma.getAlkaaPvm(), tapahtuma.getPaattyyPvm(), tapahtuma.getMax_lippuja(), tapahtuma.getLippujaJaljella(), muunnaPaikka(tapahtuma.getTapahtumapaikka()),
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

    private List<TapahtumaDto.JarjestajaDTO> muunnaJarjestajat(List<Jarjestaja> jarjestajat) {
        return jarjestajat.stream()
            .map(jarjestaja -> new TapahtumaDto.JarjestajaDTO(jarjestaja.getJarjestajaId(), jarjestaja.getNimi()))
            .collect(Collectors.toList());
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

    public YhteyshenkiloDTO muunnaYhteyshenkilotDTO(Yhteyshenkilo yhteyshenkilo) {

        return new YhteyshenkiloDTO(yhteyshenkilo.getYhtHloId(), yhteyshenkilo.getEtunimi(), yhteyshenkilo.getSukunimi(), yhteyshenkilo.getSahkoposti(), yhteyshenkilo.getPuhelin(), yhteyshenkilo.getLisatieto(), muunnaJarjestajat(yhteyshenkilo.getJarjestajat()));

    }

}
