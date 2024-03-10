package ohjelmistoprojekti.ticketguru.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

    @SuppressWarnings("null")
    @Transactional
    public MyyntitapahtumaDTO luoMyyntitapahtuma(LuoMyyntitapahtumaDTO lmDto) {
        // Haetaan tapahtuma
        Tapahtuma tapahtuma = tapahtumaRepository.findById(lmDto.getTapahtumaId()).orElseThrow(() -> new RuntimeException("Tapahtumaa ei löydy"));
        // Lasketaan myyntitapahtuman liput yhteensä 
        int lippujaYht = lmDto.getLippuTyyppiMaarat().stream()
            .mapToInt(LuoMyyntitapahtumaDTO.LippuTyyppiMaaraDTO::getLippuMaara)
            .sum();            
        // Tarkistetaan, onko riittävästi lippuja jäljellä haluttu määrä
            if (tapahtuma.getLippujaJaljella() < lippujaYht) {
                throw new RuntimeException("Ei tarpeeksi lippuja jäljellä (" + tapahtuma.getLippujaJaljella() +")");
            }
        // Alustetaan uusi myyntitapahtuma ja tallennetaan se tietokantaan (tämä tarvitaan, jotta myyntitapahtuman voi liittää lippuhin)
        Myyntitapahtuma myyntitapahtuma = new Myyntitapahtuma(LocalDateTime.now());
        myyntitapahtumaRepository.save(myyntitapahtuma);

        // Luodaan lista kaikille myyntitapahtuman lipuille
        List<Lippu> luodutLiput = new ArrayList<>();

        // Luotujen lippujen hinta yhteensä
        double loppusumma = 0;

        // Luupataan halutut liput: Luodaan liput lipputyyppien mukaan, tallennetaan lippu ja lisätään ne luodutLiput listaan
        for (LuoMyyntitapahtumaDTO.LippuTyyppiMaaraDTO lippuInfo : lmDto.getLippuTyyppiMaarat()) {
            for (int i=0; i < lippuInfo.getLippuMaara(); i++) {
                Lipputyyppi lipputyyppi = lipputyyppiRepository.findById(lippuInfo.getLipputyyppiId()).orElseThrow(() -> new RuntimeException("Lipputyyppiä ei löydy"));
                double hinta = tapahtuma.getPerushinta() * lipputyyppi.getHintakerroin();
                Lippu lippu = new Lippu(tapahtuma, lipputyyppi, myyntitapahtuma, hinta);
                loppusumma += hinta;
                luodutLiput.add(lippuRepository.save(lippu));
                
            }
        }
        // Tallennetaan liput ja loppusumma myyntitapahtumaan
        myyntitapahtuma.setLiput(luodutLiput);
        myyntitapahtuma.setLoppusumma(loppusumma);

        // Palautetaan vastauksena funktion mukainen DTO json
        return muunnaMyyntitapahtumaDtoon(myyntitapahtuma);
    }

    public MyyntitapahtumaDTO muunnaMyyntitapahtumaDtoon(Myyntitapahtuma myyntitapahtuma) {
        
        // Muodostetaan ja palautetaan MyyntitapahtumaDTO
        MyyntitapahtumaDTO myyntiDto = new MyyntitapahtumaDTO(myyntitapahtuma.getMyyntitapahtumaId(),myyntitapahtuma.getMyyntitapahtumaPvm(), String.format("%.2f", myyntitapahtuma.getLoppusumma()), muunnaLiputDto(myyntitapahtuma.getLiput()));
       
        // List<Lippu> liput = myyntitapahtuma.getLiput();

        // // Lisätään listaan kaikki myyntitapahtuman liput tekstinä
        // List<LippuDto> lippuDtoList = liput.stream().map(lippu -> {
        //     LippuDto lippuDto = new LippuDto(lippu.getTapahtuma().getTapahtumaId().toString(), lippu.getTapahtuma().getTapahtumaNimi(), lippu.getTapahtuma().getAlkaaPvm().toString(), lippu.getTapahtuma().getTapahtumapaikka().getPaikkaNimi(), lippu.getLipputyyppi().getLipputyyppiId().toString(), lippu.getLipputyyppi().getNimi(), String.format("%.2f", lippu.getHinta()), lippu.getTarkistuskoodi());
        //     return lippuDto;
        // }).collect(Collectors.toList());

        // Tallennetaan lista MyyntitapahtumaDTO olioon
        // myyntiDto.setLiputDto(lippuDtoList);

        // Palautetaan luotu olio
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
