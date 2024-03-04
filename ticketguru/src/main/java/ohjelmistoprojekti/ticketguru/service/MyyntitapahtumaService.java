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
import ohjelmistoprojekti.ticketguru.dto.LippuDto;
import ohjelmistoprojekti.ticketguru.dto.LippuTyyppiMaaraDTO;
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
            .mapToInt(LippuTyyppiMaaraDTO::getLippuMaara)
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
        for (LippuTyyppiMaaraDTO lippuInfo : lmDto.getLippuTyyppiMaarat()) {
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
        MyyntitapahtumaDTO myyntiDto = new MyyntitapahtumaDTO();
        myyntiDto.setMyyntitapahtumaId(myyntitapahtuma.getMyyntitapahtumaId());
        myyntiDto.setMyyntitapahtumaPvm(myyntitapahtuma.getMyyntitapahtumaPvm());
        myyntiDto.setLoppusumma(String.format("%.2f", myyntitapahtuma.getLoppusumma()));
        List<Lippu> liput = myyntitapahtuma.getLiput();

        // Lisätään listaan kaikki myyntitapahtuman liput tekstinä
        List<LippuDto> lippuDtoList = liput.stream().map(lippu -> {
            LippuDto lippuDto = new LippuDto();
            lippuDto.setTapahtumaId(lippu.getTapahtuma().getTapahtumaId().toString());
            lippuDto.setTapahtumanNimi(lippu.getTapahtuma().getTapahtumaNimi());
            lippuDto.setTapahtumaAika(lippu.getTapahtuma().getAlkaaPvm().toString());
            lippuDto.setTapahtumaPaikka(lippu.getTapahtuma().getTapahtumapaikka().getPaikkaNimi());
            lippuDto.setLipputyyppiId(lippu.getLipputyyppi().getLipputyyppiId().toString());
            lippuDto.setLipputyyppi(lippu.getLipputyyppi().getNimi());
            lippuDto.setHinta(String.format("%.2f", lippu.getHinta()));
            lippuDto.setTarkistuskoodi(lippu.getTarkistuskoodi());
            return lippuDto;
        }).collect(Collectors.toList());

        // Tallennetaan lista MyyntitapahtumaDTO olioon
        myyntiDto.setLiputDto(lippuDtoList);

        // Palautetaan luotu olio
        return myyntiDto;

    }

}
