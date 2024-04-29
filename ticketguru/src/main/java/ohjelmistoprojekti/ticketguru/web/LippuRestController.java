package ohjelmistoprojekti.ticketguru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import ohjelmistoprojekti.ticketguru.domain.Lippu;
import ohjelmistoprojekti.ticketguru.domain.LippuRepository;
import ohjelmistoprojekti.ticketguru.dto.MyyntitapahtumaDTO.LippuDto;
import ohjelmistoprojekti.ticketguru.service.TarkastusService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LippuRestController {

    @Autowired
    private LippuRepository lippuRepository;
    @Autowired
    private TarkastusService tarkastusService;

    // Hakee kaikki liput
    @PreAuthorize("hasAnyAuthority('lipuntarkastaja','myyja')")
    @GetMapping("/lippu")
    public ResponseEntity<List<LippuDto>> getAllTickets() {
        List<Lippu> allTickets = lippuRepository.findAll();
        if (!allTickets.isEmpty()) {
            List<LippuDto> kaikkiLiputDto = allTickets.stream()
                    .map(lippu -> tarkastusService.haeLippuId(lippu.getLippuId()))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(kaikkiLiputDto);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lippuja ei löytynyt.");
        }
    }

    // Hakee lipun ID:n perusteella
    @PreAuthorize("hasAnyAuthority('myyja', 'hallinto')")
    @GetMapping("/lippu/{id}")
    public ResponseEntity<LippuDto> getTicketById(@PathVariable Long id) {
        Lippu lippu = lippuRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lippua " + id + " ei löytynyt."));
        LippuDto lippuDto = tarkastusService.haeLippuId(lippu.getLippuId());
        return ResponseEntity.ok(lippuDto);
    }

    // Luo uuden lipun
    @PreAuthorize("hasAnyAuthority('myyja', 'hallinto')")
    @PostMapping("/lippu")
    public ResponseEntity<Lippu> createTicket(@RequestBody Lippu lippu) {
        Lippu savedLippu = lippuRepository.save(lippu);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLippu);
    }

    // Päivittää lipun
    @PreAuthorize("hasAnyAuthority('myyja', 'hallinto')")
    @PutMapping("/lippu/{id}")
    public ResponseEntity<Lippu> updateTicket(@PathVariable Long id, @RequestBody Lippu updatedLippu) {
        updatedLippu.setLippuId(id);
        Lippu savedLippu = lippuRepository.save(updatedLippu);
        return ResponseEntity.ok(savedLippu);
    }

    // Poistaa lipun
    @PreAuthorize("hasAnyAuthority('myyja', 'hallinto')")
    @DeleteMapping("/lippu/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        lippuRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Tarkistetaan lippu tarkistuskoodilla
    // /liput?tarkistuskoodi=TARKISTUSKOODI
    @PreAuthorize("hasAnyAuthority('lipuntarkastaja','myyja')")
    @GetMapping("/liput")
    public ResponseEntity<?> haeLippuId(@RequestParam(name = "tarkistuskoodi") String tarkistuskoodi) {
        Lippu lippu = lippuRepository.findByTarkistuskoodi(tarkistuskoodi);
        if (lippu != null) {
            LippuDto lippuDto = tarkastusService.haeLippuId(lippu.getLippuId());
            return ResponseEntity.ok(lippuDto);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lippua ei löytynyt.");
        }
    }
}
