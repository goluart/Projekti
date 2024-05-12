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
import ohjelmistoprojekti.ticketguru.dto.JarjestajaDTO.JarjestajaNimiDTO;
import ohjelmistoprojekti.ticketguru.dto.TapahtumaDto.PaikkaDTO;
import ohjelmistoprojekti.ticketguru.dto.YhteyshenkiloDTO.TallennaYhteyshenkiloDTO;
import ohjelmistoprojekti.ticketguru.dto.YhteyshenkiloDTO.YhteyshenkiloYhteystiedotDTO;

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
            JarjestajaNimiDTO jarjestajaDTO = new JarjestajaNimiDTO(yhteyshenkilo.getJarjestaja().getJarjestajaId(), yhteyshenkilo.getJarjestaja().getNimi());
            yhteyshenkiloDTO.setJarjestaja(jarjestajaDTO);;
        }
        if (yhteyshenkilo.getTapahtumapaikka() != null) {
            PaikkaDTO tapahtumapaikka = new PaikkaDTO(yhteyshenkilo.getTapahtumapaikka().getTapaikkaId(), yhteyshenkilo.getTapahtumapaikka().getPaikkaNimi(), yhteyshenkilo.getTapahtumapaikka().getOsoite(), yhteyshenkilo.getTapahtumapaikka().getPostitoimipaikka().getKaupunki());
            yhteyshenkiloDTO.setTapahtumapaikka(tapahtumapaikka);
        }

        return yhteyshenkiloDTO;
    }

    public YhteyshenkiloDTO tallennaYhteyshenkiloDTO(TallennaYhteyshenkiloDTO yhteyshenkiloDTO) {

        Yhteyshenkilo yhteyshenkilo;
        if (yhteyshenkiloDTO.getYhtHloId() != null) {
            yhteyshenkilo = yhteyshenkiloRepository.findById(yhteyshenkiloDTO.getYhtHloId())
            .orElseGet(Yhteyshenkilo::new);
        } else {
            yhteyshenkilo = new Yhteyshenkilo();
        }

        yhteyshenkilo.setEtunimi(yhteyshenkiloDTO.getEtunimi());
        yhteyshenkilo.setSukunimi(yhteyshenkiloDTO.getSukunimi());
        yhteyshenkilo.setSahkoposti(yhteyshenkiloDTO.getSahkoposti());
        yhteyshenkilo.setPuhelin(yhteyshenkiloDTO.getPuhelin());
        yhteyshenkilo.setLisatieto(yhteyshenkiloDTO.getLisatieto());
        
        if (yhteyshenkiloDTO.getJarjestajaId() == null) {
            yhteyshenkilo.setJarjestaja(null);
        } else {
            Jarjestaja jarjestaja = jarjestajaRepository.findById(yhteyshenkiloDTO.getJarjestajaId()).orElse(null);
            yhteyshenkilo.setJarjestaja(jarjestaja);
        }
        if (yhteyshenkiloDTO.getTapaikkaId() == null) {
            yhteyshenkilo.setTapahtumapaikka(null);
        } else {
            Tapahtumapaikka tapahtumapaikka = tapahtumapaikkaRepository.findById(yhteyshenkiloDTO.getTapaikkaId()).orElse(null);
            yhteyshenkilo.setTapahtumapaikka(tapahtumapaikka);
        }

        yhteyshenkiloRepository.save(yhteyshenkilo);
        YhteyshenkiloDTO tallennettuYhteyshenkiloDTO  = muunnaYhteyshenkilotDTO(yhteyshenkilo);
        
        return tallennettuYhteyshenkiloDTO;
    }

    public YhteyshenkiloYhteystiedotDTO yhteystiedot(Yhteyshenkilo yhteyshenkilo) {

        if (yhteyshenkiloRepository.existsById(yhteyshenkilo.getYhtHloId())) {

            YhteyshenkiloYhteystiedotDTO yhteystiedot = new YhteyshenkiloYhteystiedotDTO(yhteyshenkilo.getYhtHloId(), yhteyshenkilo.getEtunimi(), yhteyshenkilo.getSukunimi(), yhteyshenkilo.getSahkoposti(), yhteyshenkilo.getPuhelin(), yhteyshenkilo.getLisatieto());

            return yhteystiedot;
        }

        return null;
    }


}
