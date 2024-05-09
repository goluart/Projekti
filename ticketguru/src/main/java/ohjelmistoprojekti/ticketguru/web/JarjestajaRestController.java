package ohjelmistoprojekti.ticketguru.web;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ohjelmistoprojekti.ticketguru.domain.JarjestajaRepository;
import ohjelmistoprojekti.ticketguru.dto.JarjestajaDTO;
import ohjelmistoprojekti.ticketguru.dto.YhteyshenkiloDTO;
import ohjelmistoprojekti.ticketguru.service.JarjestajaService;
import ohjelmistoprojekti.ticketguru.domain.Jarjestaja;


@RestController
@RequestMapping("/jarjestajat")
public class JarjestajaRestController {

    @Autowired
    private JarjestajaRepository jarjestajaRepository;
    @Autowired
    private JarjestajaService jarjestajaService;


    @GetMapping
    @PreAuthorize("hasAnyAuthority('hallinto', 'myyja')")
    public ResponseEntity<List<JarjestajaDTO>> haeKaikkiJarjestajat() {
        List<JarjestajaDTO> jarjestajatDTO = jarjestajaRepository.findAll().stream()
            .map(jarjestaja -> jarjestajaService.muunnaJarjestajaDTO(jarjestaja))
            .collect(Collectors.toList());
        return ResponseEntity.ok(jarjestajatDTO);
        
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('hallinto', 'myyja')")
    public ResponseEntity<JarjestajaDTO> haeJarjestaja(@PathVariable("id") Long id) {
        if (!jarjestajaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Järjestäjää " + id + " ei löytynyt");
        }
        Jarjestaja jarjestaja = jarjestajaRepository.findById(id).orElse(null);
        JarjestajaDTO jarjestajaDTO = jarjestajaService.muunnaJarjestajaDTO(jarjestaja);

        return ResponseEntity.ok(jarjestajaDTO);
    }


    // tallentaa uuden ja jo olemassa olevan tiedon tietokantaan
    @PostMapping
    @PreAuthorize("hasAuthority('hallinto')")
    public ResponseEntity<JarjestajaDTO> tallennaPostJarjestaja(@RequestBody JarjestajaDTO jarjestajaTiedotDTO) { 

          if (jarjestajaTiedotDTO.getJarjestajaId() != null) {
            return jarjestajaRepository.findById(jarjestajaTiedotDTO.getJarjestajaId())
                    .map(jarjestaja ->  {
                        JarjestajaDTO tallennettuJarjestajaDTO = jarjestajaService.tallennaJarjestaja(jarjestajaTiedotDTO);
                        return ResponseEntity.ok(tallennettuJarjestajaDTO);
                    })
                    .orElseGet(() -> {
                        JarjestajaDTO tallennettuJarjestajaDTO = jarjestajaService.tallennaJarjestaja(jarjestajaTiedotDTO);
                        return ResponseEntity.status(HttpStatus.CREATED).body(tallennettuJarjestajaDTO);
                    });
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(jarjestajaService.tallennaJarjestaja(jarjestajaTiedotDTO));
        }        
        
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('hallinto')")
    public ResponseEntity<JarjestajaDTO> muutaJarjestaja(@PathVariable("id") Long id, @RequestBody JarjestajaDTO jarjestajaDTO) {
        if (!jarjestajaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Järjestäjää " + id + " ei löytynyt");
        }
        JarjestajaDTO tallennettuJarjestaja = jarjestajaService.tallennaJarjestaja(jarjestajaDTO);
        return ResponseEntity.ok(tallennettuJarjestaja);
    }


    // Yhteyshenkilön voi poistaa, vaikka se olisi kiinnitettynä Järjestäjä tai Tapahtumapaikka -entiteetteihin
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('hallinto')")
    public ResponseEntity<?> deleteJarjestaja(@PathVariable("id") Long id) {
        if (!jarjestajaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Järjestäjää " + id + " ei löytynyt");
        } else {
            try {
                jarjestajaRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } catch (DataIntegrityViolationException e) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Järjestäjää ei voi poistaa");
            }
        }
    }


}
