package ohjelmistoprojekti.ticketguru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import ohjelmistoprojekti.ticketguru.domain.Tapahtuma;
import ohjelmistoprojekti.ticketguru.domain.TapahtumaRepository;

@CrossOrigin
@RestController
public class TapahtumaRestController {

    @Autowired
    private TapahtumaRepository tapahtumaRepository;
    
    // Muutettu @RequestMapping @GetMapping muotoon
    @GetMapping("/tapahtumat") 
    public @ResponseBody List<Tapahtuma> tapahtumatListRest() {
        return (List<Tapahtuma>) tapahtumaRepository.findAll();
    }
    // Haetaan tapahtuma tunnisteen (tapahtumaId) avulla
    @GetMapping("/tapahtumat/{id}")
    public @ResponseBody Optional<Tapahtuma> findTapahtumaById(@PathVariable ("id") @NonNull Long tapahtumaId) {
        return tapahtumaRepository.findById(tapahtumaId);
    }

    // @NotNull lisätty virheilmoituksen perusteella
    @PostMapping("/tapahtumat/add")
    Tapahtuma newTapahtuma(@RequestBody @NonNull Tapahtuma newTapahtuma) {
        return tapahtumaRepository.save(newTapahtuma);
    }

    // Poista tapahtuma tapahtuma IDllä esim. "localhost:8080/delete/1"
    // @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @DeleteMapping("/delete/{id}")
    public String deleteTapahtuma(@PathVariable("id") @NonNull Long tapahtumaId) {
        tapahtumaRepository.deleteById(tapahtumaId);
        return "redirect:/tapahtumat";
    }

    // Etsi yksi tapahtuma muokkaamista varten
    @PutMapping("/tapahtumat/edit/{id}")
    public String editTapahtuma(@PathVariable("id") @NonNull Long tapahtumaId) {
        tapahtumaRepository.findById(tapahtumaId);
        return "redirect:/tapahtumat";

    }

    
}
