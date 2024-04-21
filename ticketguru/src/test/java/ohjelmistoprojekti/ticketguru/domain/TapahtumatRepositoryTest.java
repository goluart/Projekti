package ohjelmistoprojekti.ticketguru.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class TapahtumatRepositoryTest {

    @Autowired
    private TapahtumaRepository tapahtumaRepository;
    @Autowired
    private TapahtumapaikkaRepository tapahtumapaikkaRepository;
    @Autowired
    private JarjestajaRepository jarjestajaRepository;

    @Test
    void testId1EtsiKaikkiTapahtumat() {

        List<Tapahtuma> tapahtumat = tapahtumaRepository.findAll();
        assertThat(tapahtumat).hasSize(3);
    }

    @Test
    void testId2EtsiYksiTapahtuma() {
        Optional<Tapahtuma> tapahtuma = tapahtumaRepository.findById((long) 1);
        assertThat(tapahtuma.get().getTapahtumaNimi()).isEqualTo("Rock Festivaali");
    }

    @Test
    void testId3LisaaYksiTapahtuma() {
        Tapahtumapaikka tapahtumapaikka = new Tapahtumapaikka("Tavastia");
        tapahtumapaikkaRepository.save(tapahtumapaikka);

        Jarjestaja jarjestaja = new Jarjestaja("Live-nation");
        jarjestajaRepository.save(jarjestaja);

        assertThat(tapahtumaRepository.count()).isEqualTo(3);

        Tapahtuma tapahtuma = new Tapahtuma("Poppibileet", "Kevyttä poppia", 50, tapahtumapaikka, jarjestaja, 100);
        tapahtumaRepository.save(tapahtuma);
        assertThat(tapahtumaRepository.count()).isEqualTo(4);
    }

    @Test
    void testId4MuokkaaTapahtumaa() {
        Optional<Tapahtuma> tapahtuma = tapahtumaRepository.findById((long) 1);
        assertThat(tapahtuma.get().getTapahtumaNimi()).isEqualTo("Rock Festivaali");

        tapahtuma.get().setTapahtumaNimi("Humppafest");
        assertThat(tapahtuma.get().getTapahtumaNimi()).isEqualTo("Humppafest");

    }

}
