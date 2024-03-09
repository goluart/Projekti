package ohjelmistoprojekti.ticketguru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import ohjelmistoprojekti.ticketguru.domain.Tapahtuma;
import ohjelmistoprojekti.ticketguru.domain.TapahtumaRepository;

@CrossOrigin
@RestController
public class TapahtumaRestController {

    @Autowired
    private TapahtumaRepository tapahtumaRepository;

    // Haetaan kaikki järjestelmän tapahtumat
    // Muutettu @RequestMapping @GetMapping muotoon
    @GetMapping("/tapahtumat")
    public List<Tapahtuma> tapahtumatListRest() {
        return tapahtumaRepository.findAll();
    }

    // Haetaan tapahtuma tunnisteen (tapahtumaId) avulla
    @GetMapping("/tapahtumat/{id}")
    public Optional<Tapahtuma> findTapahtumaById(@PathVariable("id") @NonNull Long tapahtumaId) {
        return tapahtumaRepository.findById(tapahtumaId);
    }

    // @NotNull lisätty virheilmoituksen perusteella
    @PostMapping("/tapahtumat")
    Tapahtuma newTapahtuma(@RequestBody @NonNull Tapahtuma newTapahtuma) {
        return tapahtumaRepository.save(newTapahtuma);
    }

    // Poista tapahtuma, tapahtuma IDllä esim. "localhost:8080/tapahtumat/1"
    // Palautetaan "204 No Content" status koodi onnistuessa, sopivampi tilakoodi
    // onnistuneille DELETE-pyynnöille, koska niitä resursseja ei enää ole olemassa.
    @DeleteMapping("/tapahtumat/{id}")
    public ResponseEntity<Void> deleteTapahtuma(@PathVariable("id") @NonNull Long tapahtumaId) {
        Optional<Tapahtuma> tapahtumaOptional = tapahtumaRepository.findById(tapahtumaId);

        if (tapahtumaOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tapahtumaa " + tapahtumaId + " ei löytynyt.");
        }

        // Tarkistetaan onko lippuja, jos lippuja löytyy tapahtumaa ei voida poistaa
        // koska siihen on myyty lippuja. Tällä hetkellä voidaan vaan poistaa jos
        // lippuja on 0 tai max määrä.
        Tapahtuma tapahtuma = tapahtumaOptional.get();
        int jaljellaLippuja = tapahtuma.getMax_lippuja() - tapahtuma.getLiput().size();

        if (jaljellaLippuja != 0 && jaljellaLippuja != tapahtuma.getMax_lippuja()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Tapahtumaa " + tapahtumaId + " ei voi poistaa, koska tapahtumaan on myyty lippuja.");
        }

        tapahtumaRepository.delete(tapahtuma);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Etsi yksi tapahtuma muokkaamista varten
    // Muokkaa tunniteella yksilöityä tapahtumaa ja tallenna tehdyt muutokset
    @PutMapping("tapahtumat/{id}")
    Tapahtuma editTapahtuma(@RequestBody Tapahtuma editedTapahtuma, @PathVariable Long id) {
        editedTapahtuma.setTapahtumaId(id);
        return tapahtumaRepository.save(editedTapahtuma);

    }
}
