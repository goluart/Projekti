package ohjelmistoprojekti.ticketguru.web;

<<<<<<< HEAD
import org.hibernate.ObjectNotFoundException;
import org.hibernate.query.IllegalQueryOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
=======
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
>>>>>>> 215c97ed6d15fc82a99d64f5caedf1f0ffaa6562
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
<<<<<<< HEAD
import org.springframework.web.server.MissingRequestValueException;
=======
>>>>>>> 215c97ed6d15fc82a99d64f5caedf1f0ffaa6562
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import ohjelmistoprojekti.ticketguru.domain.Tapahtuma;
import ohjelmistoprojekti.ticketguru.domain.TapahtumaRepository;
<<<<<<< HEAD
=======
import ohjelmistoprojekti.ticketguru.dto.TapahtumaDto;
>>>>>>> 215c97ed6d15fc82a99d64f5caedf1f0ffaa6562
import ohjelmistoprojekti.ticketguru.service.TapahtumaService;

@CrossOrigin
@RestController
public class TapahtumaRestController {

<<<<<<< HEAD
    @Autowired
    private TapahtumaRepository tapahtumaRepository;
    @Autowired
    private TapahtumaService tapahtumaService;

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
    @SuppressWarnings("null")
    @PutMapping("tapahtumat/{id}")
    public ResponseEntity<Tapahtuma> editTapahtuma(@PathVariable Long id,
            @RequestBody Tapahtuma tapahtumanTiedot) {
        Tapahtuma editedTapahtuma = tapahtumaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException( // 404 virhekoodin käsittely
                        HttpStatus.NOT_FOUND,
                        "Tapahtumaa " + id + " ei voi muokata, koska sitä ei ole olemassa"));

        editedTapahtuma.setTapahtumaId(tapahtumanTiedot.getTapahtumaId());
        tapahtumaRepository.save(tapahtumanTiedot);
        return ResponseEntity.ok(editedTapahtuma);
    }

}
=======
	@Autowired
	private TapahtumaRepository tapahtumaRepository;
	@Autowired
	private TapahtumaService tapahtumaService;

	// Haetaan kaikki järjestelmän tapahtumat
	// Muutettu @RequestMapping @GetMapping muotoon
	// Jos get-metodi palauttaa tyhjän listan, palautetaan 404
	@GetMapping("/tapahtumat")
	public ResponseEntity<List<TapahtumaDto>> naytaTapahtumaDto() {
		if (tapahtumaRepository.findAll().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tapahtumia ei löytynyt.");
		}
		List<TapahtumaDto> tapatumaDtot = tapahtumaRepository.findAll().stream()
				.map(tapahtuma -> tapahtumaService.naytaTapahtumaDto(tapahtuma))
				.collect(Collectors.toList());
		return ResponseEntity.ok(tapatumaDtot);

	}

	// Haetaan tapahtuma tunnisteen (tapahtumaId) avulla
	// Jos get-metodi palauttaa tyhjän vastauksen, palautetaan 404
	@GetMapping("/tapahtumat/{id}")
	public Optional<Tapahtuma> findTapahtumaById(@PathVariable("id") @NonNull Long tapahtumaId) {
		if (tapahtumaRepository.findById(tapahtumaId).isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tapahtumaa " + tapahtumaId + " ei löytynyt.");
		}
		return tapahtumaRepository.findById(tapahtumaId);
	}

	// @NotNull lisätty virheilmoituksen perusteella
	@PostMapping("/tapahtumat")
	@ResponseStatus(value = HttpStatus.CREATED, reason = "Uusi tapahtuma luotu")
	public Tapahtuma newTapahtuma(@RequestBody @Valid @NonNull Tapahtuma newTapahtuma) {
		return tapahtumaRepository.save(newTapahtuma);

	}

	// Poista tapahtuma, tapahtuma IDllä esim. "localhost:8080/tapahtumat/1"
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
	public ResponseEntity<Tapahtuma> editTapahtuma(@PathVariable Long id,
			@RequestBody @Valid Tapahtuma tapahtumanTiedot) {
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
>>>>>>> 215c97ed6d15fc82a99d64f5caedf1f0ffaa6562
