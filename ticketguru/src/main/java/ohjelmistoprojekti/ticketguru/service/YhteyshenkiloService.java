package ohjelmistoprojekti.ticketguru.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ohjelmistoprojekti.ticketguru.domain.Jarjestaja;
import ohjelmistoprojekti.ticketguru.domain.Tapahtumapaikka;
import ohjelmistoprojekti.ticketguru.domain.TapahtumapaikkaRepository;
import ohjelmistoprojekti.ticketguru.domain.Yhteyshenkilo;
import ohjelmistoprojekti.ticketguru.domain.YhteyshenkiloRepository;
import ohjelmistoprojekti.ticketguru.dto.TapahtumaDto;
import ohjelmistoprojekti.ticketguru.dto.YhteyshenkiloDTO;
import ohjelmistoprojekti.ticketguru.dto.YhteyshenkiloDTO.TallennaYhteyshenkiloDTO;

@Service
public class YhteyshenkiloService {

    @Autowired
    YhteyshenkiloRepository yhteyshenkiloRepository;
    @Autowired
    TapahtumapaikkaRepository tapahtumapaikkaRepository;
    @Autowired
    TapahtumaService tapahtumaService;


    public YhteyshenkiloDTO muunnaYhteyshenkilotDTO(Yhteyshenkilo yhteyshenkilo) {

        return new YhteyshenkiloDTO(yhteyshenkilo.getYhtHloId(), yhteyshenkilo.getEtunimi(), yhteyshenkilo.getSukunimi(), yhteyshenkilo.getSahkoposti(), yhteyshenkilo.getPuhelin(), yhteyshenkilo.getLisatieto(), muunnaJarjestajat(yhteyshenkilo.getJarjestajat()), tapahtumaService.muunnaPaikka(yhteyshenkilo.getTapahtumapaikka()));

    }

    public Yhteyshenkilo tallennaYhteyshenkiloDTO(TallennaYhteyshenkiloDTO yhteyshenkiloDTO) {

        Yhteyshenkilo yhteyshenkilo;

        if (yhteyshenkiloDTO.getYhtHloId() == null) {
            yhteyshenkilo = new Yhteyshenkilo();
        }else {
            yhteyshenkilo = yhteyshenkiloRepository.findById(yhteyshenkiloDTO.getYhtHloId()).orElse(new Yhteyshenkilo());
        }        
        yhteyshenkilo.setEtunimi(yhteyshenkiloDTO.getEtunimi());
        yhteyshenkilo.setSukunimi(yhteyshenkiloDTO.getSukunimi());
        yhteyshenkilo.setSahkoposti(yhteyshenkiloDTO.getSahkoposti());
        yhteyshenkilo.setPuhelin(yhteyshenkiloDTO.getPuhelin());
        yhteyshenkilo.setLisatieto(yhteyshenkiloDTO.getLisatieto());
        
        if (yhteyshenkiloDTO.getTapaikkaId() != null) {
            Tapahtumapaikka tapahtumapaikka = tapahtumapaikkaRepository.findById(yhteyshenkiloDTO.getTapaikkaId()).orElse(null);
            yhteyshenkilo.setTapahtumapaikka(tapahtumapaikka);
        }        

        yhteyshenkiloRepository.save(yhteyshenkilo);
        
        return yhteyshenkilo;
    }

    private List<TapahtumaDto.JarjestajaDTO> muunnaJarjestajat(List<Jarjestaja> jarjestajat) {
        return jarjestajat.stream()
                .map(jarjestaja -> new TapahtumaDto.JarjestajaDTO(jarjestaja.getJarjestajaId(), jarjestaja.getNimi()))
                .collect(Collectors.toList());
    }


}
