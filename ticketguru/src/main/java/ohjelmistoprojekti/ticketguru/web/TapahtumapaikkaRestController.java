package ohjelmistoprojekti.ticketguru.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ohjelmistoprojekti.ticketguru.domain.TapahtumapaikkaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TapahtumapaikkaRestController {

    @Autowired
    private TapahtumapaikkaRepository tapahtumapaikkaRepository;

}
