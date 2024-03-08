package ohjelmistoprojekti.ticketguru.web;

import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    @GetMapping("/tapahtumat")
    public ResponseEntity<List<TapahtumaDto>> naytaTapahtumaDto() {
        List<TapahtumaDto> tapatumaDtos = tapahtumaRepository.findAll().stream()
            .map(tapahtuma -> tapahtumaService.naytaTapahtumaDto(tapahtuma))
            .collect(Collectors.toList());
        return ResponseEntity.ok(tapatumaDtos);
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

    // Poista tapahtuma tapahtuma IDllä esim. "localhost:8080/tapahtumat/1"
    // @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @DeleteMapping("/tapahtumat/{id}")
    List<Tapahtuma> deleteTapahtuma(@PathVariable("id") @NonNull Long tapahtumaId) {
        tapahtumaRepository.deleteById(tapahtumaId);
        return tapahtumaRepository.findAll();
    }

    // Etsi yksi tapahtuma muokkaamista varten
    // Muokkaa tunniteella yksilöityä tapahtumaa ja tallenna tehdyt muutokset
    @PutMapping("tapahtumat/{id}")
    Tapahtuma editTapahtuma(@RequestBody Tapahtuma editedTapahtuma, @PathVariable Long id) {
        editedTapahtuma.setTapahtumaId(id);
        return tapahtumaRepository.save(editedTapahtuma);

    }
}
