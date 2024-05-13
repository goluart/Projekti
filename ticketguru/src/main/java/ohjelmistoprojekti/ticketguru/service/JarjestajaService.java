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

    // Muunnetaan jarjestaja-objekti DTO-malliksi
    public JarjestajaDTO muunnaJarjestajaDTO(Jarjestaja jarjestaja) {

        // alustetaan objektit/oliot
        JarjestajaDTO jarjestajaDTO;
        List<YhteyshenkiloYhteystiedotDTO> yhteystiedot;

        // Tarkistetaan, löytyykö järjestäjän tiedoista yhteyshenkilöitä, jos löytyy haetaan ne yhteystiedot-listaan
        if (jarjestaja.getYhteyshenkilo() == null || jarjestaja.getYhteyshenkilo().isEmpty()) {
            yhteystiedot = null;
        } else {
            yhteystiedot = jarjestaja.getYhteyshenkilo().stream()    
                .map(yhteyshenkilo -> yhteyshenkiloService.yhteystiedot(yhteyshenkilo))
                .collect(Collectors.toList());          
        }

        // Muunnetaan objekti DTO-malliksi
        jarjestajaDTO = new JarjestajaDTO(jarjestaja.getJarjestajaId(), jarjestaja.getNimi(),
                jarjestaja.getYtunnus(), jarjestaja.getOsoite(), jarjestaja.getPostitoimipaikka().getPostinumero(),
                jarjestaja.getPostitoimipaikka().getKaupunki());

        // Lisätään malliin yhteyshenkilöt
        jarjestajaDTO.setYhteyshenkilot(yhteystiedot);
        
        return jarjestajaDTO;
    }

    public JarjestajaDTO tallennaJarjestaja(TallennaJarjestajaDTO tallennaJarjestajaDTO) {

        // Alustetaan objektit
        Jarjestaja jarjestaja;
        List<Yhteyshenkilo> yhteyshenkilot = null;

        // Tarkistetaan, onko jarjestaja jo olemassa
        if (tallennaJarjestajaDTO.getJarjestajaId() != null) {
            jarjestaja = jarjestajaRepository.findById(tallennaJarjestajaDTO.getJarjestajaId())
            .orElseGet(Jarjestaja::new);
        } else {
            jarjestaja = new Jarjestaja();
        }

        // Muutetaan jarjestajan tiedot 
        jarjestaja.setNimi(tallennaJarjestajaDTO.getNimi());
        jarjestaja.setOsoite(tallennaJarjestajaDTO.getOsoite());
        jarjestaja.setYtunnus(tallennaJarjestajaDTO.getYtunnus());
        
        // Tarkistetaan postitoimipaikka. Jos postitoimipaikkaa ei ole olemassa lisätään se ensin rekisteriin.
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
        
        // Jos yhteyshenkilölista on muu kuin tyhjä, haetaan tiedot ja tallennetaan ne yhteyshenkilot-listaan
        if (tallennaJarjestajaDTO.getYhteyshenkilot() != null && !tallennaJarjestajaDTO.getYhteyshenkilot().isEmpty()) {
            yhteyshenkilot = tallennaJarjestajaDTO.getYhteyshenkilot().stream()
                .map(yhteyshenkiloDTO -> {
                    Yhteyshenkilo yhteyshenkilo = new Yhteyshenkilo(yhteyshenkiloDTO.getEtunimi(), yhteyshenkiloDTO.getSukunimi(), yhteyshenkiloDTO.getSahkoposti(), yhteyshenkiloDTO.getPuhelin(), yhteyshenkiloDTO.getLisatieto());
                    if (yhteyshenkiloDTO.getYhtHloId() != null && yhteyshenkiloRepository.existsById(yhteyshenkiloDTO.getYhtHloId())) {
                        yhteyshenkilo.setYhtHloId(yhteyshenkiloDTO.getYhtHloId());
                    }                    
                    // tarkistetaan, onko yhteyshenkilo jo olemassa, jos on, päivitetään olemassa olevan henkilon tiedot
                    yhteyshenkilo.setJarjestaja(jarjestaja);
                    return yhteyshenkilo;
                })
                .collect(Collectors.toList());
            // Tallennetaan kaikki listan yhteyshenkilot tietokantaan
            yhteyshenkiloRepository.saveAll(yhteyshenkilot); 
            // Lisätään vielä tallennetut yhteyshenkilot järjestäjän tietoihin ja tallennetaan järjestäjä uudestaan           
        } 
        jarjestaja.setYhteyshenkilo(yhteyshenkilot);
        jarjestajaRepository.save(jarjestaja);

        JarjestajaDTO jarjestajaTiedotDTO = muunnaJarjestajaDTO(jarjestaja);
        
        return jarjestajaTiedotDTO;
    }
}