package ohjelmistoprojekti.ticketguru.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import ohjelmistoprojekti.ticketguru.dto.TarkastusDTO;
import ohjelmistoprojekti.ticketguru.service.TarkastusService;

@RestController
public class TarkastusRestController {

    @Autowired
    private TarkastusService tarkastusService;

    @PreAuthorize("hasAnyAuthority('lipuntarkastaja','myyja')")
    @GetMapping("/tarkastukset")
    public List<TarkastusDTO> haeKaikkiTarkastukset() {
        return tarkastusService.haeKaikkiTarkastukset();
    }
    @PreAuthorize("hasAnyAuthority('lipuntarkastaja','myyja')")
    @GetMapping("/tarkastukset/{tarkistuskoodi}")
    public Boolean findTarkistuskoodi(@PathVariable("tarkistuskoodi") String tarkistuskoodi) {
        return tarkastusService.haeLippuTarkistuskoodilla(tarkistuskoodi);
    }

    @PreAuthorize("hasAnyAuthority('myyja', 'hallinto')")
	@PostMapping("/tarkastukset")
	// @ResponseStatus(value = HttpStatus.CREATED, reason = "Uusi tapahtuma luotu")
	public Boolean tarkastaLippu(@RequestBody TarkastusDTO tarkastusDTO) {
        return tarkastusService.tarkastaLippu(tarkastusDTO);
		 

	}
}
