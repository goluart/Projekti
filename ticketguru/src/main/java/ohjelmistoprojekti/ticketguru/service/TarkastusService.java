package ohjelmistoprojekti.ticketguru.service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ohjelmistoprojekti.ticketguru.domain.Lippu;
import ohjelmistoprojekti.ticketguru.domain.LippuRepository;
import ohjelmistoprojekti.ticketguru.domain.TarkastusRepository;
import ohjelmistoprojekti.ticketguru.dto.TarkastusDTO;
import ohjelmistoprojekti.ticketguru.dto.MyyntitapahtumaDTO.LippuDto;

@Service
public class TarkastusService {

    @Autowired
    TarkastusRepository tarkastusRepository;
    @Autowired
    LippuRepository lippuRepository;

    public List<TarkastusDTO> haeKaikkiTarkastukset() {
        return lippuRepository.findAll()
                .stream()
                .map(this::muutaLuokkaDtoksi)
                .collect(Collectors.toList());
    }

    private TarkastusDTO muutaLuokkaDtoksi(Lippu lippu) {
        TarkastusDTO tarkastusDTO = new TarkastusDTO();
        tarkastusDTO.setKayttoPvm(lippu.getKayttoPvm());
        tarkastusDTO.setTarkistuskoodi(lippu.getTarkistuskoodi());
        tarkastusDTO.setTapahtumaNimi(lippu.getTapahtuma().getTapahtumaNimi());
        tarkastusDTO.setLipputyyppi(lippu.getLipputyyppi().getNimi());
        tarkastusDTO.setPaikkaNimi(lippu.getTapahtuma().getTapahtumapaikka().getPaikkaNimi());
        return tarkastusDTO;

    }

    public TarkastusDTO haeLippuTarkistuskoodilla(String tarkistuskoodi) {
        Lippu lippu = lippuRepository.findByTarkistuskoodi(tarkistuskoodi);
        TarkastusDTO vastausDTO = new TarkastusDTO();
        // TarkastusDTO tarkastusDTO = new TarkastusDTO();
        if (lippu != null) {
            if (lippu.getKayttoPvm() == null) {   
                System.out.println("Käyttöpäivämäärä tyhjä");
                // tarkastusDTO.setKayttoPvm(lippu.getKayttoPvm());
                // tarkastusDTO.setTarkistuskoodi(lippu.getTarkistuskoodi());
                // tarkastusDTO.setTapahtumaNimi(lippu.getTapahtuma().getTapahtumaNimi());
                // tarkastusDTO.setLipputyyppi(lippu.getLipputyyppi().getNimi());
                // tarkastusDTO.setPaikkaNimi(lippu.getTapahtuma().getTapahtumapaikka().getPaikkaNimi()); 
                lippu.setKayttoPvm(ZonedDateTime.now());
                lippuRepository.save(lippu);
                vastausDTO.setResponse(true);
                return vastausDTO;
            } 
        } 
        vastausDTO.setResponse(false);
        return vastausDTO;           
    }

    public TarkastusDTO tarkastaLippu(TarkastusDTO tarkastusDTO) {
        Lippu lippu = lippuRepository.findByTarkistuskoodi(tarkastusDTO.getTarkistuskoodi());
        TarkastusDTO vastausDTO = new TarkastusDTO();
        if (lippu != null) {
            System.out.println("Lippu ok. Tapahtuman nimi " + lippu.getTapahtuma().getTapahtumaNimi() + " | " + tarkastusDTO.getTapahtumaNimi() + " | " + lippu.getKayttoPvm());
            if (lippu.getKayttoPvm() == null && lippu.getTapahtuma().getTapahtumaNimi().equals(tarkastusDTO.getTapahtumaNimi())) {   
                System.out.println("Käyttöpäivämäärä tyhjä");
                lippu.setKayttoPvm(ZonedDateTime.now());
                lippuRepository.save(lippu);
                vastausDTO.setResponse(true);
                return vastausDTO;
            }             
        } 
        vastausDTO.setResponse(false);
        return vastausDTO;         
    }

    public LippuDto haeLippuId(Long id) {
        if (lippuRepository.existsById(id)) {
            Lippu lippu = lippuRepository.findById(id).orElse(null);
            LippuDto vastausDto = new LippuDto(lippu.getTapahtuma().getTapahtumaId().toString(), lippu.getTapahtuma().getTapahtumaNimi(), lippu.getTapahtuma().getAlkaaPvm().toString(), lippu.getTapahtuma().getTapahtumapaikka().getPaikkaNimi(), lippu.getLipputyyppi().getLipputyyppiId().toString(), lippu.getLipputyyppi().getNimi(), String.format("%.2f", lippu.getHinta()), lippu.getTarkistuskoodi());
            return vastausDto;
        } 
        return null;
    }


}