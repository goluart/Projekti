package ohjelmistoprojekti.ticketguru.service;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
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

        // Muunnetaan yhteyshenkilö-objekti DTO-malliksi
        YhteyshenkiloDTO yhteyshenkiloDTO = new YhteyshenkiloDTO(yhteyshenkilo.getYhtHloId(), yhteyshenkilo.getEtunimi(), yhteyshenkilo.getSukunimi(), yhteyshenkilo.getSahkoposti(), yhteyshenkilo.getPuhelin(), yhteyshenkilo.getLisatieto());

        // Lisätään DTO-malliin järjestäjän tiedot, jos ne on tallennettu tietokantaan
        if (yhteyshenkilo.getJarjestaja() != null) {
            JarjestajaNimiDTO jarjestajaDTO = new JarjestajaNimiDTO(yhteyshenkilo.getJarjestaja().getJarjestajaId(), yhteyshenkilo.getJarjestaja().getNimi());
            yhteyshenkiloDTO.setJarjestaja(jarjestajaDTO);;
        }
        // Lisätään DTO-malliin tapahtumapaikan tiedot, jos ne on tallennettu tietokantaan
        if (yhteyshenkilo.getTapahtumapaikka() != null) {
            PaikkaDTO tapahtumapaikka = new PaikkaDTO(yhteyshenkilo.getTapahtumapaikka().getTapaikkaId(), yhteyshenkilo.getTapahtumapaikka().getPaikkaNimi(), yhteyshenkilo.getTapahtumapaikka().getOsoite(), yhteyshenkilo.getTapahtumapaikka().getPostitoimipaikka().getKaupunki());
            yhteyshenkiloDTO.setTapahtumapaikka(tapahtumapaikka);
        }

        return yhteyshenkiloDTO;
    }

    @Transactional
    public YhteyshenkiloDTO tallennaYhteyshenkiloDTO(TallennaYhteyshenkiloDTO yhteyshenkiloDTO) {

        // Alustetaan objekti
        Yhteyshenkilo yhteyshenkilo;

        // Tarkistetaan onko DTO-mallissa yhtHloId, jos on päivitetään olemassa olevaa objektia, muuten luodaan uusi
        if (yhteyshenkiloDTO.getYhtHloId() != null) {
            yhteyshenkilo = yhteyshenkiloRepository.findById(yhteyshenkiloDTO.getYhtHloId())
            .orElseGet(Yhteyshenkilo::new);
        } else {
            yhteyshenkilo = new Yhteyshenkilo();
        }

        // Muutetaan yhteyshenkilön tietoja
        yhteyshenkilo.setEtunimi(yhteyshenkiloDTO.getEtunimi());
        yhteyshenkilo.setSukunimi(yhteyshenkiloDTO.getSukunimi());
        yhteyshenkilo.setSahkoposti(yhteyshenkiloDTO.getSahkoposti());
        yhteyshenkilo.setPuhelin(yhteyshenkiloDTO.getPuhelin());
        yhteyshenkilo.setLisatieto(yhteyshenkiloDTO.getLisatieto());
        
        // Jos jarjestaja on muu kuin null, haetaan jarjestajan tiedot tietokannasta, muuten järjestäjä on null
        if (yhteyshenkiloDTO.getJarjestajaId() == null) {
            yhteyshenkilo.setJarjestaja(null);
        } else {
            Jarjestaja jarjestaja= null;            
            if (jarjestajaRepository.existsById(yhteyshenkiloDTO.getJarjestajaId())) {
                jarjestaja = jarjestajaRepository.findById(yhteyshenkiloDTO.getJarjestajaId()).orElseGet(Jarjestaja::new);
            } if (yhteyshenkilo.getJarjestaja() != null && !yhteyshenkilo.getJarjestaja().equals(jarjestaja)) {
                yhteyshenkilo.getJarjestaja().getYhteyshenkilo().remove(yhteyshenkilo);
            } 
            yhteyshenkilo.setJarjestaja(jarjestaja);
            if (jarjestaja != null) {
                jarjestaja.getYhteyshenkilo().add(yhteyshenkilo);
                jarjestajaRepository.save(jarjestaja);
            }
        }
        // Jos tapahtumapaikka on muu kuin null, haetaan tapahtumapaikan tiedot tietokannasta, muuten tapahtumapaikka on null
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

        // Muutetaan yhteyshenkilön tiedot DTO-malliksi, joka näyttää yhteyshenkilön nimen ja yhteystiedot
        if (yhteyshenkiloRepository.existsById(yhteyshenkilo.getYhtHloId())) {

            YhteyshenkiloYhteystiedotDTO yhteystiedot = new YhteyshenkiloYhteystiedotDTO(yhteyshenkilo.getYhtHloId(), yhteyshenkilo.getEtunimi(), yhteyshenkilo.getSukunimi(), yhteyshenkilo.getSahkoposti(), yhteyshenkilo.getPuhelin(), yhteyshenkilo.getLisatieto());

            return yhteystiedot;
        }
        return null;
    }
}
