package ohjelmistoprojekti.ticketguru.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ohjelmistoprojekti.ticketguru.domain.Lippu;
import ohjelmistoprojekti.ticketguru.domain.LippuRepository;
import ohjelmistoprojekti.ticketguru.domain.Lipputyyppi;
import ohjelmistoprojekti.ticketguru.domain.LipputyyppiRepository;
import ohjelmistoprojekti.ticketguru.domain.Myyntitapahtuma;
import ohjelmistoprojekti.ticketguru.domain.MyyntitapahtumaRepository;
import ohjelmistoprojekti.ticketguru.domain.Tapahtuma;
import ohjelmistoprojekti.ticketguru.domain.TapahtumaRepository;
import ohjelmistoprojekti.ticketguru.dto.LuoMyyntitapahtumaDTO;
import ohjelmistoprojekti.ticketguru.dto.MyyntitapahtumaDTO;


@Service
public class MyyntitapahtumaService {

    @Autowired private TapahtumaRepository tapahtumaRepository;
    @Autowired private LipputyyppiRepository lipputyyppiRepository;
    @Autowired private LippuRepository lippuRepository;
    @Autowired private MyyntitapahtumaRepository myyntitapahtumaRepository;

    // @SuppressWarnings("null")
    @Transactional
    public MyyntitapahtumaDTO luoMyyntitapahtuma(LuoMyyntitapahtumaDTO lmDto) {

        // Haetaan tapahtuma
        Tapahtuma tapahtuma = tapahtumaRepository.findById(lmDto.getTapahtumaId()).orElseThrow(() -> new ResourceNotFoundException("Tapahtumaa ei löydy"));

        // Lasketaan myyntitapahtuman liput yhteensä 
        int lippujaYht = lmDto.getLippuTyyppiMaarat().stream()
            .mapToInt(LuoMyyntitapahtumaDTO.LippuTyyppiMaaraDTO::getLippuMaara)
            .sum();            

        // Tarkistetaan, onko riittävästi lippuja jäljellä haluttu määrä
            if (tapahtuma.getLippujaJaljella() < lippujaYht) {
                throw new IllegalStateException("Ei tarpeeksi lippuja jäljellä (" + tapahtuma.getLippujaJaljella() +")");
            }
        // Alustetaan uusi myyntitapahtuma ja tallennetaan se tietokantaan (tämä tarvitaan, jotta myyntitapahtuman voi liittää lippuhin)
        Myyntitapahtuma myyntitapahtuma = new Myyntitapahtuma(LocalDateTime.now(), 0.1);
        myyntitapahtumaRepository.save(myyntitapahtuma);
        // myyntitapahtumaRepository.save(myyntitapahtuma);

        // Luodaan lista kaikille myyntitapahtuman lipuille
        List<Lippu> luodutLiput = new ArrayList<>();

        // Luotujen lippujen hinta yhteensä
        double loppusumma = 0;

        // Luupataan halutut liput: Luodaan liput lipputyyppien mukaan, tallennetaan lippu ja lisätään ne luodutLiput listaan
        for (LuoMyyntitapahtumaDTO.LippuTyyppiMaaraDTO lippuInfo : lmDto.getLippuTyyppiMaarat()) {
            Lipputyyppi lipputyyppi = lipputyyppiRepository.findById(lippuInfo.getLipputyyppiId()).orElseThrow(() -> new RuntimeException("Lipputyyppiä ei löydy"));
            for (int i=0; i < lippuInfo.getLippuMaara(); i++) {
                double hinta = tapahtuma.getPerushinta() * lipputyyppi.getHintakerroin();
                Lippu lippu = new Lippu(tapahtuma, myyntitapahtuma, lipputyyppi, hinta);
                loppusumma += hinta;
                luodutLiput.add(lippu);
                lippuRepository.save(lippu);                
            }
        }
        // Tallennetaan liput ja loppusumma myyntitapahtumaan
        myyntitapahtuma.setMyyntitapahtumaPvm(LocalDateTime.now());
        myyntitapahtuma.setLiput(luodutLiput);
        myyntitapahtuma.setLoppusumma(loppusumma);

        // Myyntitapahtuma myyntitapahtuma = new Myyntitapahtuma(LocalDateTime.now(), luodutLiput, loppusumma);
        myyntitapahtumaRepository.save(myyntitapahtuma);


        // Palautetaan vastauksena funktion mukainen DTO json
        return muunnaMyyntitapahtumaDtoon(myyntitapahtuma);
    }

    public MyyntitapahtumaDTO muunnaMyyntitapahtumaDtoon(Myyntitapahtuma myyntitapahtuma) {
        
        // Muodostetaan ja palautetaan MyyntitapahtumaDTO
        MyyntitapahtumaDTO myyntiDto = new MyyntitapahtumaDTO(myyntitapahtuma.getMyyntitapahtumaId(),myyntitapahtuma.getMyyntitapahtumaPvm(), String.format("%.2f", myyntitapahtuma.getLoppusumma()), muunnaLiputDto(myyntitapahtuma.getLiput()));
       
        return myyntiDto;

    }

    private List<MyyntitapahtumaDTO.LippuDto> muunnaLiputDto(List<Lippu> liput) {

        return liput.stream().map(lippu -> new MyyntitapahtumaDTO.LippuDto(
            lippu.getTapahtuma().getTapahtumaId().toString(), 
            lippu.getTapahtuma().getTapahtumaNimi(), 
            lippu.getTapahtuma().getAlkaaPvm().toString(), 
            lippu.getTapahtuma().getTapahtumapaikka().getPaikkaNimi(), 
            lippu.getLipputyyppi().getLipputyyppiId().toString(), 
            lippu.getLipputyyppi().getNimi(), String.format("%.2f", lippu.getHinta()), 
            lippu.getTarkistuskoodi())
        ).collect(Collectors.toList());
    }
}
