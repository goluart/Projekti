package ohjelmistoprojekti.ticketguru.service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ohjelmistoprojekti.ticketguru.domain.Lippu;
import ohjelmistoprojekti.ticketguru.domain.LippuRepository;
import ohjelmistoprojekti.ticketguru.domain.Tarkastus;
import ohjelmistoprojekti.ticketguru.domain.TarkastusRepository;
import ohjelmistoprojekti.ticketguru.dto.TarkastusDTO;

@Service
public class TarkastusService {

    @Autowired
    TarkastusRepository tarkastusRepository;
    @Autowired
    LippuRepository lippuRepository;

    public List<TarkastusDTO> haeKaikkiTarkastukset() {
        return tarkastusRepository.findAll()
                .stream()
                .map(this::muutaLuokkaDtoksi)
                .collect(Collectors.toList());
    }

    private TarkastusDTO muutaLuokkaDtoksi(Tarkastus tarkastus) {
        TarkastusDTO tarkastusDTO = new TarkastusDTO();
        tarkastusDTO.setKayttoPvm(tarkastus.getKayttoPvm());
        tarkastusDTO.setTarkistuskoodi(tarkastus.getLippu().getTarkistuskoodi());
        tarkastusDTO.setTapahtumaNimi(tarkastus.getLippu().getTapahtuma().getTapahtumaNimi());
        tarkastusDTO.setLipputyyppi(tarkastus.getLippu().getLipputyyppi().getNimi());
        tarkastusDTO.setPaikkaNimi(tarkastus.getLippu().getTapahtuma().getTapahtumapaikka().getPaikkaNimi());
        return tarkastusDTO;

    }

    public Boolean haeLippuTarkistuskoodilla(String tarkistuskoodi) {
        Lippu lippu = lippuRepository.findByTarkistuskoodi(tarkistuskoodi);
        System.out.println(lippu.getKayttoPvm());
        // TarkastusDTO tarkastusDTO = new TarkastusDTO();
        if (lippu != null) {
            System.out.println("Lippu ok");
            if (lippu.getKayttoPvm() == null) {   
                System.out.println("Käyttöpäivämäärä tyhjä");
                // tarkastusDTO.setKayttoPvm(lippu.getKayttoPvm());
                // tarkastusDTO.setTarkistuskoodi(lippu.getTarkistuskoodi());
                // tarkastusDTO.setTapahtumaNimi(lippu.getTapahtuma().getTapahtumaNimi());
                // tarkastusDTO.setLipputyyppi(lippu.getLipputyyppi().getNimi());
                // tarkastusDTO.setPaikkaNimi(lippu.getTapahtuma().getTapahtumapaikka().getPaikkaNimi()); 
                lippu.setKayttoPvm(ZonedDateTime.now());
                lippuRepository.save(lippu);
                return true;
            } 
        } 
        return false;           
    }

    public Boolean tarkastaLippu(TarkastusDTO tarkastusDTO) {
        Lippu lippu = lippuRepository.findByTarkistuskoodi(tarkastusDTO.getTarkistuskoodi());
        if (lippu != null) {
            System.out.println("Lippu ok");
            if (lippu.getKayttoPvm() == null && lippu.getTapahtuma().getTapahtumaNimi() == tarkastusDTO.getTapahtumaNimi()) {   
                System.out.println("Käyttöpäivämäärä tyhjä");
                // tarkastusDTO.setKayttoPvm(lippu.getKayttoPvm());
                // tarkastusDTO.setTarkistuskoodi(lippu.getTarkistuskoodi());
                // tarkastusDTO.setTapahtumaNimi(lippu.getTapahtuma().getTapahtumaNimi());
                // tarkastusDTO.setLipputyyppi(lippu.getLipputyyppi().getNimi());
                // tarkastusDTO.setPaikkaNimi(lippu.getTapahtuma().getTapahtumapaikka().getPaikkaNimi()); 
                lippu.setKayttoPvm(ZonedDateTime.now());
                lippuRepository.save(lippu);
                return true;
            } 
        } 
        return false;         
    }
}