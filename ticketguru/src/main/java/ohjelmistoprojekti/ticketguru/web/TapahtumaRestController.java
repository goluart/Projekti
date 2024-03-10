package ohjelmistoprojekti.ticketguru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.MissingRequestValueException;
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
    public ResponseEntity<List<Tapahtuma>> tapahtumatListRest() {
        if (tapahtumaRepository.count() < 1) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Järjestelmässä ei ole yhtään tapahtumaa.");
        } else {

            return ResponseEntity.ok(tapahtumaRepository.findAll());
        }

    }

    // Haetaan tapahtuma tunnisteen (tapahtumaId) avulla
    @GetMapping("/tapahtumat/{id}")
    public ResponseEntity<Tapahtuma> findTapahtumaById(@PathVariable("id") @NonNull Long tapahtumaId) {
        return tapahtumaRepository
                .findById(tapahtumaId)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Tapahtumaa " + tapahtumaId + " ei löytynyt."));
    }

    // @NotNull lisätty virheilmoituksen perusteella
    @PostMapping("/tapahtumat")
    public Tapahtuma newTapahtuma(@RequestBody @NonNull Tapahtuma newTapahtuma) {
        return tapahtumaRepository.save(newTapahtuma);
    }

    // Poista tapahtuma tapahtuma IDllä esim. "localhost:8080/tapahtumat/1"
    @SuppressWarnings("null")
    @DeleteMapping("tapahtumat/{id}")
    public ResponseEntity<Tapahtuma> deleteTapahtuma(@PathVariable("id") @NonNull Long tapahtumaId) {
        Tapahtuma tapahtuma = tapahtumaRepository.findById(tapahtumaId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Tapahtumaa " + tapahtumaId + " ei voi poistaa, koska sitä ei ole olemassa"));
        tapahtumaRepository.delete(tapahtuma);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Etsi yksi tapahtuma muokkaamista varten
    // Muokkaa tunnsiteella yksilöityä tapahtumaa ja tallenna tehdyt muutokset
    @PutMapping("tapahtumat/{id}")
    public ResponseEntity<Tapahtuma> editTapahtuma(@PathVariable Long id,
            @RequestBody Tapahtuma tapahtumanTiedot) {
        @SuppressWarnings("null")
        Tapahtuma editTapahtuma = tapahtumaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException( // 404 virhekoodin käsittely
                        HttpStatus.NOT_FOUND,
                        "Tapahtumaa " + id + " ei voi muokata, koska sitä ei ole olemassa"));

        editTapahtuma.setTapahtumaId(tapahtumanTiedot.getTapahtumaId());
        tapahtumaRepository.save(tapahtumanTiedot);
        return ResponseEntity.ok(editTapahtuma);
    }

}
