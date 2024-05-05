package ohjelmistoprojekti.ticketguru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ohjelmistoprojekti.ticketguru.domain.Jarjestaja;
import ohjelmistoprojekti.ticketguru.domain.JarjestajaRepository;
import ohjelmistoprojekti.ticketguru.dto.JarjestajaTiedotDTO;

@Service
public class JarjestajaService {

    @Autowired
    JarjestajaRepository jarjestajaRepository;

    public JarjestajaTiedotDTO muunnaJarjestajaDTO(Jarjestaja jarjestaja) {
        
        JarjestajaTiedotDTO jarjestajaDTO = new JarjestajaTiedotDTO(jarjestaja.getJarjestajaId(), jarjestaja.getNimi(), jarjestaja.getYtunnus(), jarjestaja.getOsoite(), jarjestaja.getPostitoimipaikka().getPostinumero(), jarjestaja.getPostitoimipaikka().getKaupunki());
        return jarjestajaDTO;
    }
}
