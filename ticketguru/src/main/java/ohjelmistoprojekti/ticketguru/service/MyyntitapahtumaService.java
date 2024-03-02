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


    // Oletetaan, että tässä on riippuvuuksina tarvittavat repositoryt
    @Autowired private TapahtumaRepository tapahtumaRepository;
    @Autowired private LipputyyppiRepository lipputyyppiRepository;
    @Autowired private LippuRepository lippuRepository;
    @Autowired private MyyntitapahtumaRepository myyntitapahtumaRepository;

    // @Transactional
    public MyyntitapahtumaDTO luoMyyntitapahtuma(LuoMyyntitapahtumaDTO lmDto) {
        // Haetaan tapahtuma ja lipputyyppi
        Tapahtuma tapahtuma = tapahtumaRepository.findById(lmDto.getTapahtumaId()).orElseThrow(() -> new RuntimeException("Tapahtumaa ei löydy"));
        int lippujaYht = lmDto.getLippuTyyppiMaarat().stream()
            .mapToInt(LippuTyyppiMaaraDTO::getLippuMaara)
            .sum();
            
            // Tarkistetaan, onko riittävästi lippuja jäljellä
            if (tapahtuma.getLippujaJaljella() < lippujaYht) {
                throw new RuntimeException("Ei tarpeeksi lippuja jäljellä");
            }
            
        Myyntitapahtuma myyntitapahtuma = new Myyntitapahtuma(LocalDateTime.now());
        myyntitapahtumaRepository.save(myyntitapahtuma);
        
        List<Lippu> luodutLiput = new ArrayList<>();

        // Luodaan liput lipputyyppien mukaan, tallennetaan lippu ja lisätään ne luodutLiput listaan
        for (LippuTyyppiMaaraDTO lippuInfo : lmDto.getLippuTyyppiMaarat()) {
            for (int i=0; i < lippuInfo.getLippuMaara(); i++) {
                Lipputyyppi lipputyyppi = lipputyyppiRepository.findById(lippuInfo.getLipputyyppiId()).orElseThrow(() -> new RuntimeException("Lipputyyppiä ei löydy"));
                double hinta = tapahtuma.getPerushinta() * lipputyyppi.getHintakerroin();
                Lippu lippu = new Lippu(tapahtuma, lipputyyppi, myyntitapahtuma, hinta);
                luodutLiput.add(lippuRepository.save(lippu));
                
            }
        }
        // Luodaan ja tallennetaan varsinainen myyntitapahtuma
        myyntitapahtuma.setLiput(luodutLiput);

        return muunnaMyyntitapahtumaDtoon(myyntitapahtuma, luodutLiput);
    }

    private MyyntitapahtumaDTO muunnaMyyntitapahtumaDtoon(Myyntitapahtuma myyntitapahtuma, List<Lippu> liput) {
        
        // Muodostetaan ja palautetaan MyyntitapahtumaDTO
        MyyntitapahtumaDTO myyntiDto = new MyyntitapahtumaDTO();
        myyntiDto.setMyyntitapahtumaPvm(myyntitapahtuma.getMyyntitapahtumaPvm());

        List<LippuDto> lippuDtoList = liput.stream().map(lippu -> {
            LippuDto lippuDto = new LippuDto();
            lippuDto.setTapahtumaId(lippu.getTapahtuma().getTapahtumaId().toString());
            lippuDto.setTapahtumanNimi(lippu.getTapahtuma().getTapahtumaNimi());
            lippuDto.setTapahtumaAika(lippu.getTapahtuma().getAlkaaPvm().toString());;
            lippuDto.setTapahtumaPaikka(lippu.getTapahtuma().getTapahtumapaikka().getPaikkaNimi());
            lippuDto.setLipputyyppiId(lippu.getLipputyyppi().getLipputyyppiId().toString());
            lippuDto.setLipputyyppi(lippu.getLipputyyppi().getNimi());
            lippuDto.setHinta(String.format("%.2f", lippu.getHinta()));
            lippuDto.setTarkistuskoodi(lippu.getTarkistuskoodi());
            return lippuDto;
        }).collect(Collectors.toList());

        myyntiDto.setLiputDto(lippuDtoList);

        return myyntiDto;

    }

}


    // @Autowired
    // private MyyntitapahtumaRepository myyntitapahtumaRepository;
    // @Autowired
    // private LippuService lippuService;
    // @Autowired
    // private TapahtumaRepository tapahtumaRepository;
    // @Autowired
    // private LipputyyppiRepository lipputyyppiRepository;

    // @Transactional
    // public Myyntitapahtuma suoritaMyyntitapahtuma(MyyntitapahtumaDTO dto) {
    //     Tapahtuma tapahtuma = tapahtumaRepository.findById(dto.getTapahtumaId());
    //     Lipputyyppi lipputyyppi = lipputyyppiRepository.findById(dto.getLipputyyppiId());
    //     Lippu uusilippu = lippuService.luoLippu(tapahtuma, lipputyyppi);
    //     Myyntitapahtuma myyntitapahtuma = new Myyntitapahtuma();
    //     // Aseta tarvittavat tiedot myyntitapahtumalle

        

    //     return myyntitapahtumaRepository.save(myyntitapahtuma);
    // }



    


