package ohjelmistoprojekti.ticketguru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ohjelmistoprojekti.ticketguru.domain.Lippu;
import ohjelmistoprojekti.ticketguru.domain.LippuRepository;
import ohjelmistoprojekti.ticketguru.domain.Lipputyyppi;
import ohjelmistoprojekti.ticketguru.domain.Tapahtuma;

@Service
public class LippuService {

    @Autowired
    private LippuRepository lippuRepository;

    public Lippu luoLippu(Tapahtuma tapahtuma, Lipputyyppi lipputyyppi) {
        Lippu uusiLippu = new Lippu();
        uusiLippu.setTapahtuma(tapahtuma);
        uusiLippu.setLipputyyppi(lipputyyppi);
        // Aseta muut tarvittavat tiedot lippuun
        uusiLippu.setHinta(laskeLipunHinta(tapahtuma, lipputyyppi));
        return lippuRepository.save(uusiLippu);
    }

    // Metodi lipun hinnan laskemiseksi
    private double laskeLipunHinta(Tapahtuma tapahtuma, Lipputyyppi lipputyyppi) {
        // Oletetaan, että hinta lasketaan tapahtuman perushinnan ja lipputyypin hintakertoimen perusteella
        return tapahtuma.getPerushinta() * lipputyyppi.getHintakerroin();
    }
}

    
