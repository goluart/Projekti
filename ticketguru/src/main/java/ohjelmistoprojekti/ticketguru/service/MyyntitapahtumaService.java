package ohjelmistoprojekti.ticketguru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ohjelmistoprojekti.ticketguru.domain.LippuRepository;
import ohjelmistoprojekti.ticketguru.domain.Myyntitapahtuma;
import ohjelmistoprojekti.ticketguru.domain.MyyntitapahtumaRepository;

@Service
public class MyyntitapahtumaService {

    @Autowired
    private MyyntitapahtumaRepository myyntitapahtumaRepository;

    @Transactional
    public Myyntitapahtuma luoMyyntitapahtuma(Myyntitapahtuma myyntitapahtuma) {
        // Tässä voi olla lisälogiikkaa esim. tarkistuksia ennen tallennusta
        return myyntitapahtumaRepository.save(myyntitapahtuma);
    }

}
