package ohjelmistoprojekti.ticketguru.web;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.lang.NonNull;
import jakarta.validation.Valid;
import ohjelmistoprojekti.ticketguru.domain.Tapahtumapaikka;
import ohjelmistoprojekti.ticketguru.domain.TapahtumapaikkaRepository;

@RestController
public class TapahtumapaikkaRestController {

    @Autowired
    private TapahtumapaikkaRepository tapahtumapaikkaRepository;

    @PreAuthorize("hasAnyAuthority('myyja', 'hallinto')") // Haetaan kaikki tapahtumat repositorysta
    @GetMapping("/tapahtumapaikat") // Jos repository on tyhjä näytetään virheilmoitus
    public List<Tapahtumapaikka> haeKaikkiTapahtumapaikat() {
        if (tapahtumapaikkaRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tapahtumapaikkoja, ei löytynyt");
        }
        return tapahtumapaikkaRepository.findAll();
    }

    @PreAuthorize("hasAnyAuthority('myyja', 'hallinto')") // Haetaan yksi tapahtuma reposta
    @GetMapping("/tapahtumapaikat/{id}") // Jos repossa ei ole pyydettyä tapahtumapaikkaa, näytetään virheilmoitus
    public Optional<Tapahtumapaikka> haeTaphtumapaikkaById(@PathVariable("id") @NonNull Long tapaikkaId) {
        if (tapahtumapaikkaRepository.findById(tapaikkaId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tapahtumaa " + tapaikkaId + " ei löytynyt");
        }
        return tapahtumapaikkaRepository.findById(tapaikkaId);
    }

    @PreAuthorize("hasAnyAuthority('hallinto')") // Poistetaan valittu tapahtumapaikka reposta
    @DeleteMapping("/tapahtumapaikat/{id}") // Jos tapahtumaa ei löydy näytetään virheilmoitus
    public ResponseEntity<?> poistaTapahtumapaikka(@PathVariable("id") Long tapaikkaId) {
        if (!tapahtumapaikkaRepository.existsById(tapaikkaId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Tapahtumapaikkaa " + tapaikkaId + " ei löytynyt.");
        }

        tapahtumapaikkaRepository.deleteById(tapaikkaId);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAnyAuthority('myyja', 'hallinto')") // Muokataan valittua tapahtumapaikkaa
    @PutMapping("/tapahtumapaikat/{id}") // Jos tapahtumaa ei löydy näytetään virheilmoitus
    public ResponseEntity<Tapahtumapaikka> editTapahtumapaikka(@PathVariable("id") Long tapaikkaId,
            @RequestBody Tapahtumapaikka uusiTapahtumapaikka) {
        //@SuppressWarnings("null")
        Tapahtumapaikka editTapahtumapaikka = tapahtumapaikkaRepository.findById(tapaikkaId)
                .orElseThrow(() -> new ResponseStatusException( // 404 virhekoodin käsittely
                        HttpStatus.NOT_FOUND,
                        "Tapahtumaa " + tapaikkaId + " ei voi muokata, koska sitä ei ole olemassa"));
        editTapahtumapaikka.setTapaikkaId(uusiTapahtumapaikka.getTapaikkaId());
        tapahtumapaikkaRepository.save(uusiTapahtumapaikka);

        return ResponseEntity.ok(editTapahtumapaikka);
    }

    @PreAuthorize("hasAuthority('hallinto')") // Luodaan uusi tapahtumapaikka
    @PostMapping("/tapahtumapaikat") // Luonnin jälkeen näytetään HTTP-status ilmoitus onnistuneesta luonnista
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Uusi tapahtumapaikka luotu")
    public Tapahtumapaikka uusiTapahtumapaikka(@RequestBody @Valid @NonNull Tapahtumapaikka uusiTapahtumapaikka) {
        return tapahtumapaikkaRepository.save(uusiTapahtumapaikka);
    }
}