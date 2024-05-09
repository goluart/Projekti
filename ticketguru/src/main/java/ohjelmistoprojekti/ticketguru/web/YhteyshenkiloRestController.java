package ohjelmistoprojekti.ticketguru.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ohjelmistoprojekti.ticketguru.domain.Yhteyshenkilo;
import ohjelmistoprojekti.ticketguru.domain.YhteyshenkiloRepository;
import ohjelmistoprojekti.ticketguru.dto.YhteyshenkiloDTO;
import ohjelmistoprojekti.ticketguru.dto.YhteyshenkiloDTO.TallennaYhteyshenkiloDTO;
import ohjelmistoprojekti.ticketguru.service.YhteyshenkiloService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/yhteyshenkilot")
public class YhteyshenkiloRestController {

    @Autowired
    private YhteyshenkiloRepository yhtHloRepo;
    @Autowired
    private YhteyshenkiloService yhteyshenkiloService;


    @GetMapping
    @PreAuthorize("hasAnyAuthority('hallinto', 'myyja')")
    public ResponseEntity<List<YhteyshenkiloDTO>> haeYhteyshenkilot() {
        List<YhteyshenkiloDTO> yhteyshenkilotDTO = yhtHloRepo.findAll().stream()
            .map(yhteyshenkilo -> yhteyshenkiloService.muunnaYhteyshenkilotDTO(yhteyshenkilo))
            .collect(Collectors.toList());
        return ResponseEntity.ok(yhteyshenkilotDTO);

    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('hallinto', 'myyja')")
    public ResponseEntity<YhteyshenkiloDTO> haeYhteyshenkilo(@PathVariable("id") Long yhtHloId) {
        if (!yhtHloRepo.existsById(yhtHloId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Yhteyshenkilöä " + yhtHloId + " ei löytynyt");
        }
        Yhteyshenkilo yhteyshenkilo = yhtHloRepo.findById(yhtHloId).orElse(null);
        return ResponseEntity.ok(yhteyshenkiloService.muunnaYhteyshenkilotDTO(yhteyshenkilo));
    }


    // tallentaa uuden tai päivitää tietokannassa olevan tiedon
    @PostMapping
    @PreAuthorize("hasAuthority('hallinto')")
    public ResponseEntity<YhteyshenkiloDTO> lisaaYhteyshenkilo(@RequestBody TallennaYhteyshenkiloDTO yhteyshenkiloDTO) {

        if (yhteyshenkiloDTO.getYhtHloId() != null) {
            return yhtHloRepo.findById(yhteyshenkiloDTO.getYhtHloId())
                    .map(yhteyshenkilo ->  {
                        YhteyshenkiloDTO tallennettuYhteyshenkiloDTO = yhteyshenkiloService.tallennaYhteyshenkiloDTO(yhteyshenkiloDTO);
                        return ResponseEntity.ok(tallennettuYhteyshenkiloDTO);
                    })
                    .orElseGet(() -> {
                        YhteyshenkiloDTO tallennettuYhteyshenkiloDTO = yhteyshenkiloService.tallennaYhteyshenkiloDTO(yhteyshenkiloDTO);
                        return ResponseEntity.status(HttpStatus.CREATED).body(tallennettuYhteyshenkiloDTO);
                    });
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(yhteyshenkiloService.tallennaYhteyshenkiloDTO(yhteyshenkiloDTO));
        }        
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('hallinto')")
    public ResponseEntity<YhteyshenkiloDTO> tallennaYhteyshenkilo(@RequestBody TallennaYhteyshenkiloDTO yhteyshenkiloDTO) {
        if (!yhtHloRepo.existsById(yhteyshenkiloDTO.getYhtHloId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Yhteyshenkilöä " + yhteyshenkiloDTO.getYhtHloId() + " ei löytynyt");
        }
        YhteyshenkiloDTO tallennettuYhteyshenkiloDTO = yhteyshenkiloService.tallennaYhteyshenkiloDTO(yhteyshenkiloDTO);
        return ResponseEntity.ok(tallennettuYhteyshenkiloDTO);
    }

    // Yhteyshenkilön voi poistaa, vaikka se olisi kiinnitettynä Järjestäjä tai Tapahtumapaikka -entiteetteihin
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('hallinto')")
    public ResponseEntity<?> deleteYhteyshenkilo(@PathVariable("id") Long yhtHloId) {
        if (!yhtHloRepo.existsById(yhtHloId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Yhteyshenkilöä " + yhtHloId + " ei löytynyt");
        }
        yhtHloRepo.deleteById(yhtHloId);
            return ResponseEntity.noContent().build();
    }
}
