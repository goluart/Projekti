package ohjelmistoprojekti.ticketguru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import ohjelmistoprojekti.ticketguru.domain.Kayttaja;
import ohjelmistoprojekti.ticketguru.domain.KayttajaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class KayttajaRestController {

    @Autowired
    private KayttajaRepository kayttajaRepository;

    @PreAuthorize("hasAnyAuthority('hallinto')")
    @GetMapping("/kayttajat")
    public List<Kayttaja> haeKaikkiKayttajat() {
        if (kayttajaRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Käyttäjiä ei löytynyt");

        }
        return kayttajaRepository.findAll();
    }

    @PreAuthorize("hasAnyAuthority('hallinto')")
    @GetMapping("/kayttajat/{id}")
    public Optional<Kayttaja> haeKayttajaById(@PathVariable("id") @NonNull Long hloId) {
        if (kayttajaRepository.findById(hloId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Käyttäjää " + hloId + " ei löytynyt");

        }
        return kayttajaRepository.findById(hloId);
    }

    @PreAuthorize("hasAnyAuthority('hallinto')")
    @PostMapping("/kayttajat")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Uusi käyttäjä luotu")
    public Kayttaja uusiKayttaja(@RequestBody @Valid @NonNull Kayttaja uusiKayttaja) {
        return kayttajaRepository.save(uusiKayttaja);
    }

    @PreAuthorize("hasAnyAuthority('hallinto')")
    @PutMapping("/kayttajat/{id}")
    public ResponseEntity<Kayttaja> editKayttaja(@PathVariable("id") Long hloId, @RequestBody Kayttaja uusiKayttaja) {
        @SuppressWarnings("null")
        Kayttaja editKayttaja = kayttajaRepository.findById(hloId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Henkiöä " + hloId + " ei voi muokata, koska häntä ei ole olemassa."));
        editKayttaja.setHloId(uusiKayttaja.getHloId());
        kayttajaRepository.save(uusiKayttaja);

        return ResponseEntity.ok(editKayttaja);
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