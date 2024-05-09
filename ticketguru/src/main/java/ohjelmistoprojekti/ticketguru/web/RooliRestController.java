package ohjelmistoprojekti.ticketguru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
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

import jakarta.validation.Valid;
import ohjelmistoprojekti.ticketguru.domain.Rooli;
import ohjelmistoprojekti.ticketguru.domain.RooliRepository;

@RestController
public class RooliRestController {

    @Autowired
    private RooliRepository rooliRepository;

    @PreAuthorize("hasAnyAuthority('hallinto')")
    @GetMapping("/roolit")
    public List<Rooli> haeKaikkiRoolit() {
        if (rooliRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rooleja ei löytynyt");
        }

        return rooliRepository.findAll();
    }

    @PreAuthorize("hasAnyAuthority('hallinto')")
    @GetMapping("/roolit/{id}")
    public Optional<Rooli> haeRooliById(@PathVariable("id") @NonNull Long rooliId) {
        if (rooliRepository.findById(rooliId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Roolia " + rooliId + " ei löytynyt");

        }
        return rooliRepository.findById(rooliId);
    }

    @PreAuthorize("hasAnyAuthority('hallinto')")
    @PostMapping("/roolit")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Uusi rooli luotu")
    public Rooli uusiRooli(@RequestBody @Valid @NonNull Rooli uusiRooli) {
        return rooliRepository.save(uusiRooli);
    }

    @PreAuthorize("hasAnyAuthority('hallinto')")
    @PutMapping("/roolit/{id}")
    public ResponseEntity<Rooli> editRooli(@PathVariable("id") Long rooliId, @RequestBody Rooli uusiRooli) {

        Rooli editRooli = rooliRepository.findById(rooliId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Roolia " + rooliId + " ei voi muokata, koska sitä ei löytynyt"));
        editRooli.setRooliId(uusiRooli.getRooliId());
        rooliRepository.save(uusiRooli);

        return ResponseEntity.ok(uusiRooli);
    }

    @PreAuthorize("hasAnyAuthority('hallinto')")
    @DeleteMapping("/roolit/{id}")
    public ResponseEntity<?> poistaRooli(@PathVariable("id") Long rooliId) {
        Rooli rooli = rooliRepository.findById(rooliId)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Roolia " + rooliId + " ei löytynyt"));
        try {
            rooliRepository.delete(rooli);
        } catch (DataIntegrityViolationException ex) {
            if (ex.getMessage().contains("Referential integrity constraint violation")) {
                throw new ResponseStatusException(HttpStatus.CONFLICT,
                        "Rooli " + rooliId + " ei voi poistaa, koska siihen liityy muita tietoja");
            }

            throw ex;
        }
        return ResponseEntity.ok().build();
    }
}
