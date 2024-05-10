package ohjelmistoprojekti.ticketguru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
import ohjelmistoprojekti.ticketguru.dto.RooliDTO;
import ohjelmistoprojekti.ticketguru.service.RooliKayttajaService;

@RestController
public class RooliRestController {

    @Autowired
    private RooliRepository rooliRepository;

    @Autowired
    private RooliKayttajaService rooliKayttajaService;

    @PreAuthorize("hasAnyAuthority('hallinto')")
    @GetMapping("/roolit")
    public List<RooliDTO> haeKaikkiRoolit() { // Haetaan kaikki rooli
        if (rooliRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rooleja ei löytynyt");
            // Virheenkäsittely, jos rooleja ei ole
        }
        return rooliKayttajaService.haeKaikkiRoolit();
    }

    @PreAuthorize("hasAnyAuthority('hallinto')")
    @GetMapping("/roolit/{id}")
    public ResponseEntity<RooliDTO> haeRooliById(@PathVariable("id") @NonNull Long rooliId) { // Haetaan yksi rooli
        Optional<RooliDTO> rooli = rooliKayttajaService.haeRooliById(rooliId);
        if (rooli.isPresent()) {
            return ResponseEntity.ok(rooli.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Roolia " + rooliId + " ei löytynyt.");
            // Virheenkäsittely jos pyydettyä roolia ei ole
        }
    }

    @PreAuthorize("hasAnyAuthority('hallinto')")
    @PostMapping("/roolit")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Uusi rooli luotu") // Luodaan uusi rooli
    public Rooli uusiRooli(@RequestBody @Valid @NonNull Rooli uusiRooli) {
        return rooliRepository.save(uusiRooli);
    }

    @PreAuthorize("hasAnyAuthority('hallinto')")
    @PutMapping("/roolit/{id}") // Muokataan valittua roolia
    public ResponseEntity<Rooli> editRooli(@PathVariable("id") Long rooliId, @Validated @RequestBody Rooli uusiRooli,
            BindingResult bindingResult) {

        try {
            if (bindingResult.hasErrors()) { // Virheenkäsittely, jos JSON on virheellinen
                throw new IllegalArgumentException("Pyynnön sisältö on virheellinen");
            }

            Rooli editRooli = rooliRepository.findById(rooliId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, // Virheenkäsittely jos roolia
                                                                                         // ei löydy
                            "Roolia " + rooliId + " ei voi muokata, koska sitä ei löytynyt"));
            editRooli.setRooliId(uusiRooli.getRooliId());
            rooliRepository.save(uusiRooli);

            return ResponseEntity.ok(uusiRooli);

        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

    @PreAuthorize("hasAnyAuthority('hallinto')")
    @DeleteMapping("/roolit/{id}")
    public ResponseEntity<?> poistaRooli(@PathVariable("id") Long rooliId) { // Roolin poisto
        Rooli rooli = rooliRepository.findById(rooliId)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Roolia " + rooliId + " ei löytynyt"));
        // Virheenkäsittely jos roolia ei löydy
        try {
            rooliRepository.delete(rooli);
        } catch (DataIntegrityViolationException ex) {
            if (ex.getMessage().contains("Referential integrity constraint violation")) {
                // Virheekäsittely, jos yritetään poistoa, joka ei ole sallittu
                throw new ResponseStatusException(HttpStatus.CONFLICT,
                        "Rooli " + rooliId + " ei voi poistaa, koska siihen liityy muita tietoja");
            }

            throw ex;
        }
        return ResponseEntity.ok().build();
    }
}
