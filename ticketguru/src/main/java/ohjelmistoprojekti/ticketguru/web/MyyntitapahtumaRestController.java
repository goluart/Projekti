package ohjelmistoprojekti.ticketguru.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import ohjelmistoprojekti.ticketguru.domain.Lipputyyppi;
import ohjelmistoprojekti.ticketguru.domain.LipputyyppiRepository;

import ohjelmistoprojekti.ticketguru.domain.MyyntitapahtumaRepository;
import ohjelmistoprojekti.ticketguru.domain.Tapahtuma;
import ohjelmistoprojekti.ticketguru.domain.TapahtumaRepository;
import ohjelmistoprojekti.ticketguru.dto.LuoMyyntitapahtumaDTO;
import ohjelmistoprojekti.ticketguru.dto.MyyntitapahtumaDTO;
import ohjelmistoprojekti.ticketguru.service.MyyntitapahtumaService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

// @CrossOrigin
@RestController
@RequestMapping("/myyntitapahtumat")
public class MyyntitapahtumaRestController {

    @Autowired
    private MyyntitapahtumaService myyntitapahtumaService;
    @Autowired
    private MyyntitapahtumaRepository myyntitapahtumaRepository;
    @Autowired
    private TapahtumaRepository tapahtumaRepository;
    @Autowired
    private LipputyyppiRepository lipputyyppiRepository;

    // Haetaan kaikki myynitapahtumat
    @PreAuthorize("hasAnyAuthority('myyja', 'hallinto')")
    @GetMapping
    public ResponseEntity<List<MyyntitapahtumaDTO>> haeKaikkiMyyntitapahtumat() {
        List<MyyntitapahtumaDTO> myyntitapahtumatDtot = myyntitapahtumaRepository.findAll().stream()
                .map(myyntitapahtuma -> myyntitapahtumaService.muunnaMyyntitapahtumaDtoon(myyntitapahtuma))
                .collect(Collectors.toList());
        return ResponseEntity.ok(myyntitapahtumatDtot);
    }

    @PreAuthorize("hasAnyAuthority('myyja', 'hallinto')")
    //@SuppressWarnings("null")
    @GetMapping("/{id}")
    public ResponseEntity<MyyntitapahtumaDTO> haeYksiMyyntitapahtuma(@PathVariable("id") Long myyntitapahtumaId) {
        return myyntitapahtumaRepository.findById(myyntitapahtumaId)
                .map(myyntitapahtuma -> myyntitapahtumaService.muunnaMyyntitapahtumaDtoon(myyntitapahtuma))
                .map(ResponseEntity::ok) // Muunna MyyntitapahtumaDTO ResponseEntity-olioksi
                .orElse(ResponseEntity.notFound().build()); // Palauta 404 Not Found, jos Myyntitapahtumaa ei löydy
    }

    // Lisätään tietokantaan myyntitapahtuma ja luodaan jokainen myyntitapahtumassa
    // myyty lippu
    @PreAuthorize("hasRole('myyja')")
    @PostMapping
    public ResponseEntity<?> luoMyyntitapahtuma(@RequestBody @NonNull LuoMyyntitapahtumaDTO mtDto) {
        /*
         * Hakee tapahtuman tietokannasta, käyttämällä tapahtumaId:tä POST-pyynnön
         * Body'sta. Jos tapahtumaId:tä ei löydy palautetaan poikkeus
         */
        //@SuppressWarnings("null")
        Tapahtuma tapahtuma = tapahtumaRepository.findById(mtDto.getTapahtumaId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Tapahtumaa " + mtDto.getTapahtumaId() + " ei löydy"));
        /*
         * Käydään läpi kaikki LuoMyyntitapahtumaDTO-objektin sisältämät
         * LippuTyyppiMaaraDTO-objektit.
         * Jokainen LippuTyyppiMaaraDTO sisältää tiedon yhdestä lipputyypistä ja siitä,
         * kuinka monta lippua kyseisestä lipputyypistä halutaan ostaa.
         */
        for (LuoMyyntitapahtumaDTO.LippuTyyppiMaaraDTO ltm : mtDto.getLippuTyyppiMaarat()) {
            // Tarkistetaan, että lipputyyppiId on määritelty
            if (ltm.getLipputyyppiId() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "LipputyyppiId on virheellinen");
            }
            /*
             * Haetaan lipputyyppi tietokannasta käyttäen LippuTyyppiMaaraDTO:ssa
             * määriteltyä lipputyyppiId:tä.
             * findById-metodi palauttaa Optional-objektin, joka voi sisältää
             * Lipputyyppi-objektin tai olla tyhjä, jos lipputyyppiä ei löydy annetulla
             * ID:llä.
             */
            //@SuppressWarnings("null")
            Lipputyyppi lt = lipputyyppiRepository.findById(ltm.getLipputyyppiId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "Lipputyyppiä " + ltm.getLipputyyppiId() + " ei löytynyt"));

            /*
             * Tarkistetaan, kuuluuko lipputyyppi kyseiseen tapahtumaan. Arvo False
             * aiheuttaa poikkeuksen
             */
            boolean kuuluuTapahtumaan = tapahtuma.getLipputyypit().contains(lt);
            if (!kuuluuTapahtumaan) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Lipputyypillä " + ltm.getLipputyyppiId() + " ei voi myydä tapahtumaan lippuja");
            }
        }

        // Luodaan myyntitapahtuma, jos ei poikkeuksia
        MyyntitapahtumaDTO myyntitapahtumaDto = myyntitapahtumaService.luoMyyntitapahtuma(mtDto);
        return ResponseEntity.ok(myyntitapahtumaDto);
    }

}
