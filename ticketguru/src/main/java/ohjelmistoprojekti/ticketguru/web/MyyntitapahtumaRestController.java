package ohjelmistoprojekti.ticketguru.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ohjelmistoprojekti.ticketguru.domain.MyyntitapahtumaRepository;
import ohjelmistoprojekti.ticketguru.dto.LuoMyyntitapahtumaDTO;
import ohjelmistoprojekti.ticketguru.dto.MyyntitapahtumaDTO;
import ohjelmistoprojekti.ticketguru.service.MyyntitapahtumaService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@RestController
@RequestMapping("/myyntitapahtumat")
public class MyyntitapahtumaRestController {

    @Autowired
    private MyyntitapahtumaService myyntitapahtumaService;
    @Autowired
    private MyyntitapahtumaRepository myyntitapahtumaRepository;

    // Haetaan kaikki myynitapahtumat
    @GetMapping
    public ResponseEntity<List<MyyntitapahtumaDTO>> haeKaikkiMyyntitapahtumat() {
        List<MyyntitapahtumaDTO> myyntitapahtumatDtos = myyntitapahtumaRepository.findAll().stream()
                .map(myyntitapahtuma -> myyntitapahtumaService.muunnaMyyntitapahtumaDtoon(myyntitapahtuma))
                .collect(Collectors.toList());
        return ResponseEntity.ok(myyntitapahtumatDtos);
    }

    @SuppressWarnings("null")
    @GetMapping("/{id}")
    public ResponseEntity<MyyntitapahtumaDTO> haeYksiMyyntitapahtuma(@PathVariable("id") Long myyntitapahtumaId) {
        return myyntitapahtumaRepository.findById(myyntitapahtumaId)
                .map(myyntitapahtuma -> myyntitapahtumaService.muunnaMyyntitapahtumaDtoon(myyntitapahtuma))
                .map(ResponseEntity::ok) // Muunna MyyntitapahtumaDTO ResponseEntity-olioksi
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Myyntitapahtumaa " + myyntitapahtumaId + " ei löytynyt."));
        // ResponseEntity.notFound().build()); // Palauta 404 Not Found, jos
        // Myyntitapahtumaa ei löydy

    }

    // Lisätään tietokantaan myyntitapahtuma ja luodaan jokainen myyntitapahtumassa
    // myyty lippu
    @PostMapping
    public ResponseEntity<MyyntitapahtumaDTO> luoMyyntitapahtuma(@RequestBody LuoMyyntitapahtumaDTO mtDto) {
        MyyntitapahtumaDTO myyntitapahtumaDto = myyntitapahtumaService.luoMyyntitapahtuma(mtDto);
        return ResponseEntity.ok(myyntitapahtumaDto);
    }

}
