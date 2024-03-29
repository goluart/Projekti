package ohjelmistoprojekti.ticketguru.web;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import ohjelmistoprojekti.ticketguru.domain.Tapahtuma;
import ohjelmistoprojekti.ticketguru.domain.TapahtumaRepository;
import ohjelmistoprojekti.ticketguru.dto.TapahtumaDto;
import ohjelmistoprojekti.ticketguru.service.TapahtumaService;

@CrossOrigin
@RestController
public class TapahtumaRestController {

	@Autowired
	private TapahtumaRepository tapahtumaRepository;
	@Autowired
	private TapahtumaService tapahtumaService;

	// Haetaan kaikki järjestelmän tapahtumat
	// Muutettu @RequestMapping @GetMapping muotoon
	// Jos get-metodi palauttaa tyhjän listan, palautetaan 404
	@PreAuthorize("hasAnyAuthority('myyja', 'hallinto')")
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
	@PreAuthorize("hasAnyAuthority('myyja', 'hallinto')")
	@GetMapping("/tapahtumat/{id}")
	public Optional<Tapahtuma> findTapahtumaById(@PathVariable("id") @NonNull Long tapahtumaId) {
		if (tapahtumaRepository.findById(tapahtumaId).isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tapahtumaa " + tapahtumaId + " ei löytynyt.");
		}
		return tapahtumaRepository.findById(tapahtumaId);
	}

	// @NotNull lisätty virheilmoituksen perusteella
	@PreAuthorize("hasAnyAuthority('myyja', 'hallinto')")
	@PostMapping("/tapahtumat")
	@ResponseStatus(value = HttpStatus.CREATED, reason = "Uusi tapahtuma luotu")
	public Tapahtuma newTapahtuma(@RequestBody @Valid @NonNull Tapahtuma newTapahtuma) {
		return tapahtumaRepository.save(newTapahtuma);

	}

	// Poista tapahtuma, tapahtuma IDllä esim. "localhost:8080/tapahtumat/1"
	@PreAuthorize("hasAuthority('hallinto')")
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
	@PreAuthorize("hasAuthority('hallinto')")
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