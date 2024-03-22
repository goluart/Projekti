package ohjelmistoprojekti.ticketguru.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti.ticketguru.dto.TarkastusDTO;
import ohjelmistoprojekti.ticketguru.service.TarkastusService;

@RestController
public class TarkastusRestController {

    @Autowired
    private TarkastusService tarkastusService;

    @PreAuthorize("hasRole('lipuntarkastaja')")
    @GetMapping("/tarkastukset")
    public List<TarkastusDTO> haeKaikkiTarkastukset() {
        return tarkastusService.haeKaikkiTarkastukset();
    }
}
