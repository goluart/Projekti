package ohjelmistoprojekti.ticketguru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import ohjelmistoprojekti.ticketguru.domain.Asiakasryhma;
import ohjelmistoprojekti.ticketguru.domain.AsiakasryhmaRepository;
import ohjelmistoprojekti.ticketguru.domain.Lipputyyppi;
import ohjelmistoprojekti.ticketguru.domain.LipputyyppiRepository;
import ohjelmistoprojekti.ticketguru.dto.TapahtumaDto.LipputyyppiDto;
import ohjelmistoprojekti.ticketguru.service.TapahtumaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LipputyyppiRestController {

    @Autowired
    private LipputyyppiRepository lipputyyppiRepository;

    @Autowired
    private TapahtumaService tapahtumaService;

    @Autowired
private AsiakasryhmaRepository asiakasryhmaRepository;

    @PreAuthorize("hasAnyAuthority('myyja', 'hallinto')")
    @GetMapping("/lipputyyppi")
    public ResponseEntity<List<LipputyyppiDto>> getAllLipputyypit() {
        List<Lipputyyppi> allLipputyypit = lipputyyppiRepository.findAll();
        if (!allLipputyypit.isEmpty()) {
            List<LipputyyppiDto> kaikkiLipputyypitDto = allLipputyypit.stream()
                    .map(lipputyyppi -> tapahtumaService.muunnaLipputyyppiDto(lipputyyppi))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(kaikkiLipputyypitDto);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lipputyyppejä ei löytynyt.");
        }
    }

    @PreAuthorize("hasAnyAuthority('myyja', 'hallinto')")
    @GetMapping("/lipputyyppi/{id}")
    public ResponseEntity<LipputyyppiDto> getLipputyyppiById(@PathVariable Long id) {
        Lipputyyppi lipputyyppi = lipputyyppiRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Lipputyyppiä " + id + " ei löytynyt."));
        LipputyyppiDto lipputyyppiDto = tapahtumaService.muunnaLipputyyppiDto(lipputyyppi);
        return ResponseEntity.ok(lipputyyppiDto);
    }

@PostMapping("/lipputyyppi")
public ResponseEntity<Lipputyyppi> createLipputyyppi(@RequestBody Lipputyyppi lipputyyppi) {
    Long asiakasryhmaId = lipputyyppi.getAsiakasryhma().getId(); // Assuming getId() returns the ID of Asiakasryhma
    Asiakasryhma asiakasryhma = asiakasryhmaRepository.findById(asiakasryhmaId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Asiakasryhma with ID " + asiakasryhmaId + " not found"));

    lipputyyppi.setAsiakasryhma(asiakasryhma);

    Lipputyyppi savedLipputyyppi = lipputyyppiRepository.save(lipputyyppi);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedLipputyyppi);
}

    @PreAuthorize("hasAnyAuthority('hallinto')")
    @PutMapping("/lipputyyppi/{id}")
    public ResponseEntity<Lipputyyppi> updateLipputyyppi(@PathVariable Long id,
            @RequestBody Lipputyyppi updatedLipputyyppi) {
        updatedLipputyyppi.setLipputyyppiId(id);
        Lipputyyppi savedLipputyyppi = lipputyyppiRepository.save(updatedLipputyyppi);
        return ResponseEntity.ok(savedLipputyyppi);
    }

    @PreAuthorize("hasAnyAuthority('hallinto')")
    @DeleteMapping("/lipputyyppi/{id}")
    public ResponseEntity<Void> deleteLipputyyppi(@PathVariable Long id) {
        lipputyyppiRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
