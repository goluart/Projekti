package ohjelmistoprojekti.ticketguru.service;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ohjelmistoprojekti.ticketguru.domain.Jarjestaja;
import ohjelmistoprojekti.ticketguru.domain.JarjestajaRepository;
import ohjelmistoprojekti.ticketguru.domain.Postitoimipaikka;
import ohjelmistoprojekti.ticketguru.domain.PostitoimipaikkaRepository;
import ohjelmistoprojekti.ticketguru.dto.JarjestajaDTO;

@Service
public class JarjestajaService {

    @Autowired
    JarjestajaRepository jarjestajaRepository;
    @Autowired
    PostitoimipaikkaRepository postitoimipaikkaRepository;

    public JarjestajaDTO muunnaJarjestajaDTO(Jarjestaja jarjestaja) {

        JarjestajaDTO jarjestajaDTO = new JarjestajaDTO(jarjestaja.getJarjestajaId(), jarjestaja.getNimi(),
                jarjestaja.getYtunnus(), jarjestaja.getOsoite(), jarjestaja.getPostitoimipaikka().getPostinumero(),
                jarjestaja.getPostitoimipaikka().getKaupunki());
        return jarjestajaDTO;
    }

    public JarjestajaDTO tallennaJarjestaja(JarjestajaDTO jarjestajaDTO) {

        Jarjestaja jarjestaja;

        if (jarjestajaDTO.getJarjestajaId() != null) {
            jarjestaja = jarjestajaRepository.findById(jarjestajaDTO.getJarjestajaId())
            .orElseGet(Jarjestaja::new);
        } else {
            jarjestaja = new Jarjestaja();
        }

        if (jarjestajaDTO.getNimi() == null || jarjestajaDTO.getNimi() == "") {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nimi on tyhjä");
        }

        jarjestaja.setNimi(jarjestajaDTO.getNimi());
        jarjestaja.setOsoite(jarjestajaDTO.getOsoite());
        jarjestaja.setYtunnus(jarjestajaDTO.getYtunnus());

        if (postitoimipaikkaRepository.findByPostinumero(jarjestajaDTO.getPostinumero()) != null) {
            Postitoimipaikka postitoimipaikka = postitoimipaikkaRepository
                    .findByPostinumero(jarjestajaDTO.getPostinumero());
            jarjestaja.setPostitoimipaikka(postitoimipaikka);
        } else {
            Postitoimipaikka postitoimipaikka = new Postitoimipaikka(jarjestajaDTO.getPostinumero(),
                    jarjestajaDTO.getKaupunki());
            jarjestaja.setPostitoimipaikka(postitoimipaikka);
        }

        jarjestajaRepository.save(jarjestaja);

        JarjestajaDTO jarjestajaTiedotDTO = muunnaJarjestajaDTO(jarjestaja);

        return jarjestajaTiedotDTO;
    }

}