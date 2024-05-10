package ohjelmistoprojekti.ticketguru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import ohjelmistoprojekti.ticketguru.domain.Kayttaja;
import ohjelmistoprojekti.ticketguru.domain.KayttajaRepository;
import ohjelmistoprojekti.ticketguru.dto.KayttajaDTO;
import ohjelmistoprojekti.ticketguru.service.KayttajaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class KayttajaRestController {

    @Autowired
    private KayttajaRepository kayttajaRepository;

    @Autowired
    private KayttajaService kayttajaService;

    @PreAuthorize("hasAnyAuthority('hallinto')")
    @GetMapping("/kayttajat")
    public List<KayttajaDTO> haeKaikkiKayttajatDTO() {
        if (kayttajaRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Käyttäjiä ei löytynyt");
        }
        return kayttajaService.haeKaikkiKayttajat();
    }

    @PreAuthorize("hasAnyAuthority('hallinto')")
    @GetMapping("/kayttajat/{id}")
    public ResponseEntity<KayttajaDTO> haeYksiKayttaja(@PathVariable("id") @NonNull Long hloId) {
        Optional<KayttajaDTO> kayttaja = kayttajaService.haeKayttajaById(hloId);

        if (kayttaja.isPresent()) {
            return ResponseEntity.ok(kayttaja.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Käyttäjää " + hloId + " ei löytynyt.");
        }
    }

    @PreAuthorize("hasAnyAuthority('hallinto')")
    @PostMapping("/kayttajat")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Uusi käyttäjä luotu")
    public Kayttaja uusiKayttaja(@RequestBody @Valid @NonNull Kayttaja uusiKayttaja) {
        return kayttajaRepository.save(uusiKayttaja);
    }

    @PreAuthorize("hasAnyAuthority('hallinto')")

    @PutMapping("/kayttajat/{id}")
    public ResponseEntity<Kayttaja> editKayttaja(@PathVariable("id") Long hloId,
            @Validated @RequestBody Kayttaja uusiKayttaja, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                throw new IllegalArgumentException("Pyynnön sisältö on virheellinen");
            }

            Kayttaja editKayttaja = kayttajaRepository.findById(hloId)
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Henkiöä " + hloId + " ei voi muokata, koska häntä ei ole olemassa."));
            editKayttaja.setHloId(uusiKayttaja.getHloId());
            kayttajaRepository.save(uusiKayttaja);

            return ResponseEntity.ok(editKayttaja);

        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

    @PreAuthorize("hasAnyAuthority('hallinto')")
    @DeleteMapping("/kayttajat/{id}")
    public ResponseEntity<?> poistaKayttaja(@PathVariable("id") Long hloId) {
        if (!kayttajaRepository.existsById(hloId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Käyttäjää " + hloId + " ei löytynyt");

        }
        kayttajaRepository.deleteById(hloId);
        return ResponseEntity.ok().build();
    }

}
