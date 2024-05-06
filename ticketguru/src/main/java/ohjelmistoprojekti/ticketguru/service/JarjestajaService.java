package ohjelmistoprojekti.ticketguru.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ohjelmistoprojekti.ticketguru.domain.Jarjestaja;
import ohjelmistoprojekti.ticketguru.domain.JarjestajaRepository;
import ohjelmistoprojekti.ticketguru.domain.Postitoimipaikka;
import ohjelmistoprojekti.ticketguru.domain.PostitoimipaikkaRepository;
import ohjelmistoprojekti.ticketguru.dto.JarjestajaTiedotDTO;

@Service
public class JarjestajaService {

    @Autowired
    JarjestajaRepository jarjestajaRepository;
    @Autowired
    PostitoimipaikkaRepository postitoimipaikkaRepository;

    public JarjestajaTiedotDTO muunnaJarjestajaDTO(Jarjestaja jarjestaja) {
        
        JarjestajaTiedotDTO jarjestajaDTO = new JarjestajaTiedotDTO(jarjestaja.getJarjestajaId(), jarjestaja.getNimi(), jarjestaja.getYtunnus(), jarjestaja.getOsoite(), jarjestaja.getPostitoimipaikka().getPostinumero(), jarjestaja.getPostitoimipaikka().getKaupunki());
        return jarjestajaDTO;
    }

    public Map<String, Object> tallennaJarjestaja(JarjestajaTiedotDTO jarjestajaDTO) {

        System.out.println(jarjestajaDTO);

        boolean uusiTieto = false;

        Jarjestaja jarjestaja;
        
        if (jarjestajaDTO.getJarjestajaId() != null && jarjestajaRepository.existsById(jarjestajaDTO.getJarjestajaId())) {
            jarjestaja = jarjestajaRepository.findById(jarjestajaDTO.getJarjestajaId()).orElse(new Jarjestaja());
        } else {
            jarjestaja = new Jarjestaja();
            uusiTieto = true;
        }
        
        if (jarjestajaDTO.getNimi() == null || jarjestajaDTO.getNimi() == "") {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nimi on tyhjä"); 
        }

        jarjestaja.setNimi(jarjestajaDTO.getNimi());
        jarjestaja.setOsoite(jarjestajaDTO.getOsoite());
        jarjestaja.setYtunnus(jarjestajaDTO.getYtunnus());

        if (postitoimipaikkaRepository.findByPostinumero(jarjestajaDTO.getPostinumero()) != null) {
            Postitoimipaikka postitoimipaikka = postitoimipaikkaRepository.findByPostinumero(jarjestajaDTO.getPostinumero());
            jarjestaja.setPostitoimipaikka(postitoimipaikka);
        } else {
            Postitoimipaikka postitoimipaikka = new Postitoimipaikka(jarjestajaDTO.getPostinumero(), jarjestajaDTO.getKaupunki());
            jarjestaja.setPostitoimipaikka(postitoimipaikka);
        }

        jarjestajaRepository.save(jarjestaja);

        JarjestajaTiedotDTO jarjestajaTiedotDTO = muunnaJarjestajaDTO(jarjestaja);

        Map<String, Object> vastaus = new HashMap<>();
        vastaus.put("Status", uusiTieto);
        vastaus.put("DTO", jarjestajaTiedotDTO);


        return vastaus;
    }
}
