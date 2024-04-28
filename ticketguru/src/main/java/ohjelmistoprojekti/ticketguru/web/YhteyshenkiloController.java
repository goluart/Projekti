package ohjelmistoprojekti.ticketguru.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti.ticketguru.domain.YhteyshenkiloRepository;
import ohjelmistoprojekti.ticketguru.dto.YhteyshenkiloDTO;
import ohjelmistoprojekti.ticketguru.service.TapahtumaService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/yhteyshenkilot")
public class YhteyshenkiloController {

    @Autowired
    private YhteyshenkiloRepository yhtHloRepo;
    @Autowired
    private TapahtumaService tapahtumaService;

    @GetMapping
    @PreAuthorize("hasAuthority('hallinto')")
    public ResponseEntity<List<YhteyshenkiloDTO>> haeYhteyshenkilot() {

        List<YhteyshenkiloDTO> yhteyshenkilotDTO = yhtHloRepo.findAll().stream()
            .map(yhteyshenkilo -> tapahtumaService.muunnaYhteyshenkilotDTO(yhteyshenkilo))
            .collect(Collectors.toList());
        return ResponseEntity.ok(yhteyshenkilotDTO);

    }





}
