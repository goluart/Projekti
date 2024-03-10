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

        // Set<Lipputyyppi> lipputyypit = tapahtuma.getLipputyypit();
        // List<TapahtumaLipputyyppiDto> ltDtot = lipputyypit.stream()
        //     .map(lipputyyppi -> {
        //         TapahtumaLipputyyppiDto ltDto = new TapahtumaLipputyyppiDto();
        //         ltDto.setLipputyyppiId(lipputyyppi.getLipputyyppiId());
        //         ltDto.setLipputyyppiNimi(lipputyyppi.getNimi());
        //         ltDto.setAsiakasryhma(lipputyyppi.getAsiakasryhma().getNimi());
        //         ltDto.setHintakerroin(lipputyyppi.getHintakerroin());
        //         return ltDto;
        //     }).collect(Collectors.toList());

        // tDto.setLipputyypit(ltDtot);
        // tDto.setLippujaJaljella(tapahtuma.getLippujaJaljella());

        // TapahtumaTapahtumapaikkaDTO tpDto = new TapahtumaTapahtumapaikkaDTO(tapahtuma.getTapahtumapaikka().getTapaikkaId(), tapahtuma.getTapahtumapaikka().getPaikkaNimi(), tapahtuma.getTapahtumapaikka().getOsoite(), tapahtuma.getTapahtumapaikka().getPostitoimipaikka().getKaupunki());
        // tDto.setTapahtumapaikka(tpDto);
        
        // TapahtumaJarjestajaDTO jDto = new TapahtumaJarjestajaDTO(tapahtuma.getJarjestaja().getJarjestajaId(), tapahtuma.getJarjestaja().getNimi());

        // tDto.setJarjestaja(jDto);

        // TapahtumaDto tDto = new TapahtumaDto(tapahtuma.getTapahtumaId(), tapahtuma.getTapahtumaNimi(), tapahtuma.getKuvaus(), tapahtuma.getAlkaaPvm(), tapahtuma.getPaattyyPvm(), tapahtuma.getMax_lippuja(), tapahtuma.getLippujaJaljella(), tpDto, jDto, tapahtuma.getPerushinta(), ltDtot);

        TapahtumaDto tDto = new TapahtumaDto(tapahtuma.getTapahtumaId(), tapahtuma.getTapahtumaNimi(), tapahtuma.getKuvaus(), tapahtuma.getAlkaaPvm(), tapahtuma.getPaattyyPvm(), tapahtuma.getMax_lippuja(), tapahtuma.getLippujaJaljella(), muunnaPaikka(tapahtuma.getTapahtumapaikka()), muunnaJarjestaja(tapahtuma.getJarjestaja()), tapahtuma.getPerushinta(), muunnaLipputyyppiLista(tapahtuma.getLipputyypit()));

        return tDto;
    }

    private TapahtumaDto.PaikkaDTO muunnaPaikka(Tapahtumapaikka paikka) {
        return new TapahtumaDto.PaikkaDTO(paikka.getTapaikkaId(), paikka.getPaikkaNimi(), paikka.getOsoite(), paikka.getPostitoimipaikka().getKaupunki());

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
                    lipputyyppi.getHintakerroin())
                ).collect(Collectors.toList());
    }
}
