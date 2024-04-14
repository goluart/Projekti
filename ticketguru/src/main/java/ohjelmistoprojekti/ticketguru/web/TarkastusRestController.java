package ohjelmistoprojekti.ticketguru.web;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti.ticketguru.domain.LippuRepository;
import ohjelmistoprojekti.ticketguru.dto.TarkastusDTO;
import ohjelmistoprojekti.ticketguru.service.TarkastusService;

@RestController
public class TarkastusRestController {

    @Autowired
    private TarkastusService tarkastusService;
    @Autowired 
    private LippuRepository lippuRepository;

    @PreAuthorize("hasAnyAuthority('lipuntarkastaja','myyja')")
    @GetMapping("/tarkastukset")
    public List<TarkastusDTO> haeKaikkiTarkastukset() {
        return tarkastusService.haeKaikkiTarkastukset();
    }

    @PreAuthorize("hasAnyAuthority('lipuntarkastaja','myyja')")
    @GetMapping("/tarkastukset/{tarkistuskoodi}")
    public TarkastusDTO haeTarkistuskoodilla(@PathVariable("tarkistuskoodi") String tarkistuskoodi) {
        return tarkastusService.haeLippuTarkistuskoodilla(tarkistuskoodi);
    }

    @PreAuthorize("hasAnyAuthority('myyja', 'hallinto')")
	@PostMapping("/tarkastukset")
	public TarkastusDTO tarkastaLippu(@RequestBody TarkastusDTO tarkastusDTO) {
        return tarkastusService.tarkastaLippu(tarkastusDTO);
	}

    @PreAuthorize("hasAnyAuthority('myyja', 'hallinto')")
    @PatchMapping("/tarkastukset/{id}")
    public ResponseEntity<?> merkitseKaytetyksi(@PathVariable("tarkistuskoodi") Long id) {
        return lippuRepository.findById(id)
            .map(lippu -> {
                if(lippu.getKayttoPvm() == null) {
                    lippu.setKayttoPvm(ZonedDateTime.now());
                    lippuRepository.save(lippu);
                    return ResponseEntity.ok(Map.of("response", true));
                } else {
                    return ResponseEntity.badRequest().body(Map.of("response", false));
                }
            })
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("response", false)));
        }
}
