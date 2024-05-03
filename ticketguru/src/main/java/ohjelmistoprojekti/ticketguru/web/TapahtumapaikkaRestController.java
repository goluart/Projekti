package ohjelmistoprojekti.ticketguru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.web.server.ServerHttpSecurity.HttpsRedirectSpec;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.micrometer.common.lang.NonNull;
import ohjelmistoprojekti.ticketguru.domain.Tapahtumapaikka;
import ohjelmistoprojekti.ticketguru.domain.TapahtumapaikkaRepository;

@RestController
public class TapahtumapaikkaRestController {

    @Autowired
    private TapahtumapaikkaRepository tapahtumapaikkaRepository;

    @PreAuthorize("hasAnyAuthority('myyja', 'hallinto')")
    @GetMapping("/tapahtumapaikat")
    public List<Tapahtumapaikka> haeKaikkiTapahtumapaikat() {
        if (tapahtumapaikkaRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tapahtumapaikkoja, ei löytynyt");
        }
        return tapahtumapaikkaRepository.findAll();
    }

    @PreAuthorize("hasAnyAuthority('myyja', 'hallinto')")
    @GetMapping("/tapahtumapaikat/{id}")
    public Optional<Tapahtumapaikka> haeTaphtumapaikkaById(@PathVariable("id") @NonNull Long tapaikkaId) {
        if (tapahtumapaikkaRepository.findById(tapaikkaId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tapahtumaa " + tapaikkaId + " ei löytynyt");
        }
        return tapahtumapaikkaRepository.findById(tapaikkaId);
    }
}
