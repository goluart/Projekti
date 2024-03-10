package ohjelmistoprojekti.ticketguru.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ohjelmistoprojekti.ticketguru.domain.Lipputyyppi;
import ohjelmistoprojekti.ticketguru.domain.Tapahtuma;
import ohjelmistoprojekti.ticketguru.dto.TapahtumaJarjestajaDTO;
import ohjelmistoprojekti.ticketguru.dto.TapahtumaLipputyyppiDto;
import ohjelmistoprojekti.ticketguru.dto.TapahtumaDto;
import ohjelmistoprojekti.ticketguru.dto.TapahtumaTapahtumapaikkaDTO;

@Service
public class TapahtumaService {

    public TapahtumaDto naytaTapahtumaDto(Tapahtuma tapahtuma) {

        // Muodostetaan ja palautetaan tapahtumaDto
        // TapahtumaDto tDto = new TapahtumaDto();
        // tDto.setTapahtumaId(tapahtuma.getTapahtumaId());
        // tDto.setTapahtumaNimi(tapahtuma.getTapahtumaNimi());
        // tDto.setAlkaaPvm(tapahtuma.getAlkaaPvm());
        // tDto.setLoppuuPvm(tapahtuma.getPaattyyPvm());
        // tDto.setKuvaus(tapahtuma.getKuvaus());
        // tDto.setMaxLippuja(tapahtuma.getMax_lippuja());
        // tDto.setPerushinta(tapahtuma.getPerushinta());

        Set<Lipputyyppi> lipputyypit = tapahtuma.getLipputyypit();
        List<TapahtumaLipputyyppiDto> ltDtot = lipputyypit.stream()
            .map(lipputyyppi -> {
                TapahtumaLipputyyppiDto ltDto = new TapahtumaLipputyyppiDto();
                ltDto.setLipputyyppiId(lipputyyppi.getLipputyyppiId());
                ltDto.setLipputyyppiNimi(lipputyyppi.getNimi());
                ltDto.setAsiakasryhma(lipputyyppi.getAsiakasryhma().getNimi());
                ltDto.setHintakerroin(lipputyyppi.getHintakerroin());
                return ltDto;
            }).collect(Collectors.toList());

        // tDto.setLipputyypit(ltDtot);
        // tDto.setLippujaJaljella(tapahtuma.getLippujaJaljella());

        TapahtumaTapahtumapaikkaDTO tpDto = new TapahtumaTapahtumapaikkaDTO(tapahtuma.getTapahtumapaikka().getTapaikkaId(), tapahtuma.getTapahtumapaikka().getPaikkaNimi(), tapahtuma.getTapahtumapaikka().getOsoite(), tapahtuma.getTapahtumapaikka().getPostitoimipaikka().getKaupunki());
        // tDto.setTapahtumapaikka(tpDto);
        
        TapahtumaJarjestajaDTO jDto = new TapahtumaJarjestajaDTO(tapahtuma.getJarjestaja().getJarjestajaId(), tapahtuma.getJarjestaja().getNimi());

        // tDto.setJarjestaja(jDto);

        TapahtumaDto tDto = new TapahtumaDto(tapahtuma.getTapahtumaId(), tapahtuma.getTapahtumaNimi(), tapahtuma.getKuvaus(), tapahtuma.getAlkaaPvm(), tapahtuma.getPaattyyPvm(), tapahtuma.getMax_lippuja(), tapahtuma.getLippujaJaljella(), tpDto, jDto, tapahtuma.getPerushinta(), ltDtot);

        return tDto;
    }
}
