package ohjelmistoprojekti.ticketguru.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ohjelmistoprojekti.ticketguru.domain.Jarjestaja;
import ohjelmistoprojekti.ticketguru.domain.JarjestajaRepository;
import ohjelmistoprojekti.ticketguru.domain.Postitoimipaikka;
import ohjelmistoprojekti.ticketguru.domain.PostitoimipaikkaRepository;
import ohjelmistoprojekti.ticketguru.domain.Yhteyshenkilo;
import ohjelmistoprojekti.ticketguru.domain.YhteyshenkiloRepository;
import ohjelmistoprojekti.ticketguru.dto.JarjestajaDTO;
import ohjelmistoprojekti.ticketguru.dto.JarjestajaDTO.TallennaJarjestajaDTO;
import ohjelmistoprojekti.ticketguru.dto.YhteyshenkiloDTO.YhteyshenkiloYhteystiedotDTO;

@Service
public class JarjestajaService {

    @Autowired
    private JarjestajaRepository jarjestajaRepository;
    @Autowired
    private PostitoimipaikkaRepository postitoimipaikkaRepository;
    @Autowired
    private YhteyshenkiloService yhteyshenkiloService;
    @Autowired
    private YhteyshenkiloRepository yhteyshenkiloRepository;

    public JarjestajaDTO muunnaJarjestajaDTO(Jarjestaja jarjestaja) {

        JarjestajaDTO jarjestajaDTO;
        List<YhteyshenkiloYhteystiedotDTO> yhteystiedot;

        if (jarjestaja.getYhteyshenkilo() == null || jarjestaja.getYhteyshenkilo().isEmpty()) {
            yhteystiedot = null;
        } else {
            yhteystiedot = jarjestaja.getYhteyshenkilo().stream()    
                .map(yhteyshenkilo -> yhteyshenkiloService.yhteystiedot(yhteyshenkilo))
                .collect(Collectors.toList());          
        }

        jarjestajaDTO = new JarjestajaDTO(jarjestaja.getJarjestajaId(), jarjestaja.getNimi(),
                jarjestaja.getYtunnus(), jarjestaja.getOsoite(), jarjestaja.getPostitoimipaikka().getPostinumero(),
                jarjestaja.getPostitoimipaikka().getKaupunki());

        jarjestajaDTO.setYhteyshenkilot(yhteystiedot);
        
        return jarjestajaDTO;
    }

    public JarjestajaDTO tallennaJarjestaja(TallennaJarjestajaDTO tallennaJarjestajaDTO) {

        Jarjestaja jarjestaja;
        List<Yhteyshenkilo> yhteyshenkilot;

        if (tallennaJarjestajaDTO.getJarjestajaId() != null) {
            jarjestaja = jarjestajaRepository.findById(tallennaJarjestajaDTO.getJarjestajaId())
            .orElseGet(Jarjestaja::new);
        } else {
            jarjestaja = new Jarjestaja();
        }

        jarjestaja.setNimi(tallennaJarjestajaDTO.getNimi());
        jarjestaja.setOsoite(tallennaJarjestajaDTO.getOsoite());
        jarjestaja.setYtunnus(tallennaJarjestajaDTO.getYtunnus());
        
        if (postitoimipaikkaRepository.findByPostinumero(tallennaJarjestajaDTO.getPostinumero()) != null) {
            Postitoimipaikka postitoimipaikka = postitoimipaikkaRepository
            .findByPostinumero(tallennaJarjestajaDTO.getPostinumero());
            jarjestaja.setPostitoimipaikka(postitoimipaikka);
        } else {
            Postitoimipaikka postitoimipaikka = new Postitoimipaikka(tallennaJarjestajaDTO.getPostinumero(),
            tallennaJarjestajaDTO.getKaupunki());
            jarjestaja.setPostitoimipaikka(postitoimipaikka);
        }
        
        jarjestajaRepository.save(jarjestaja);
        
        if (tallennaJarjestajaDTO.getYhteyshenkilot() != null && !tallennaJarjestajaDTO.getYhteyshenkilot().isEmpty()) {
            yhteyshenkilot = tallennaJarjestajaDTO.getYhteyshenkilot().stream()
                .map(yhteyshenkiloDTO -> {
                    Yhteyshenkilo yhteyshenkilo = new Yhteyshenkilo(yhteyshenkiloDTO.getEtunimi(), yhteyshenkiloDTO.getSukunimi(), yhteyshenkiloDTO.getSahkoposti(), yhteyshenkiloDTO.getPuhelin(), yhteyshenkiloDTO.getLisatieto());
                    if (yhteyshenkiloDTO.getYhtHloId() != null) {
                        yhteyshenkilo.setYhtHloId(yhteyshenkiloDTO.getYhtHloId());
                    }                    
                    yhteyshenkilo.setJarjestaja(jarjestaja);
                    return yhteyshenkilo;

                })
                .collect(Collectors.toList());
            yhteyshenkiloRepository.saveAll(yhteyshenkilot);            
            jarjestaja.setYhteyshenkilo(yhteyshenkilot);
            jarjestajaRepository.save(jarjestaja);
        }

        JarjestajaDTO jarjestajaTiedotDTO = muunnaJarjestajaDTO(jarjestaja);
        
        return jarjestajaTiedotDTO;
    }
}