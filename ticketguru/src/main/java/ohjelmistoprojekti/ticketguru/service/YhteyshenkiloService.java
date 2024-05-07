package ohjelmistoprojekti.ticketguru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ohjelmistoprojekti.ticketguru.domain.Jarjestaja;
import ohjelmistoprojekti.ticketguru.domain.JarjestajaRepository;
import ohjelmistoprojekti.ticketguru.domain.Tapahtumapaikka;
import ohjelmistoprojekti.ticketguru.domain.TapahtumapaikkaRepository;
import ohjelmistoprojekti.ticketguru.domain.Yhteyshenkilo;
import ohjelmistoprojekti.ticketguru.domain.YhteyshenkiloRepository;
import ohjelmistoprojekti.ticketguru.dto.YhteyshenkiloDTO;
import ohjelmistoprojekti.ticketguru.dto.TapahtumaDto.JarjestajaDTO;
import ohjelmistoprojekti.ticketguru.dto.TapahtumaDto.PaikkaDTO;
import ohjelmistoprojekti.ticketguru.dto.YhteyshenkiloDTO.TallennaYhteyshenkiloDTO;

@Service
public class YhteyshenkiloService {

    @Autowired
    YhteyshenkiloRepository yhteyshenkiloRepository;
    @Autowired
    TapahtumapaikkaRepository tapahtumapaikkaRepository;
    @Autowired
    TapahtumaService tapahtumaService;
    @Autowired
    JarjestajaRepository jarjestajaRepository;


    public YhteyshenkiloDTO muunnaYhteyshenkilotDTO(Yhteyshenkilo yhteyshenkilo) {

        YhteyshenkiloDTO yhteyshenkiloDTO = new YhteyshenkiloDTO(yhteyshenkilo.getYhtHloId(), yhteyshenkilo.getEtunimi(), yhteyshenkilo.getSukunimi(), yhteyshenkilo.getSahkoposti(), yhteyshenkilo.getPuhelin(), yhteyshenkilo.getLisatieto());

        if (yhteyshenkilo.getJarjestaja() != null) {
            JarjestajaDTO jarjestajaDTO = new JarjestajaDTO(yhteyshenkilo.getJarjestaja().getJarjestajaId(), yhteyshenkilo.getJarjestaja().getNimi());
            yhteyshenkiloDTO.setJarjestaja(jarjestajaDTO);
        }
        if (yhteyshenkilo.getTapahtumapaikka() != null) {
            PaikkaDTO tapahtumapaikka = new PaikkaDTO(yhteyshenkilo.getTapahtumapaikka().getTapaikkaId(), yhteyshenkilo.getTapahtumapaikka().getPaikkaNimi(), yhteyshenkilo.getTapahtumapaikka().getOsoite(), yhteyshenkilo.getTapahtumapaikka().getPostitoimipaikka().getKaupunki());
            yhteyshenkiloDTO.setTapahtumapaikka(tapahtumapaikka);
        }

        return yhteyshenkiloDTO;
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
        
        if (yhteyshenkiloDTO.getTapaikkaId() != null || yhteyshenkiloDTO.getTapaikkaId() != 0) {
            Tapahtumapaikka tapahtumapaikka = tapahtumapaikkaRepository.findById(yhteyshenkiloDTO.getTapaikkaId()).orElse(null);
            yhteyshenkilo.setTapahtumapaikka(tapahtumapaikka);
        }    
        if (yhteyshenkiloDTO.getJarjestajaId() != null || yhteyshenkiloDTO.getJarjestajaId() != 0) {
            Jarjestaja jarjestaja = jarjestajaRepository.findById(yhteyshenkiloDTO.getJarjestajaId()).orElse(null);
            yhteyshenkilo.setJarjestaja(jarjestaja);
        }    

        yhteyshenkiloRepository.save(yhteyshenkilo);
        
        return yhteyshenkilo;
    }


}
