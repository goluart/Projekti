package ohjelmistoprojekti.ticketguru.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

import org.assertj.core.api.LocalDateTimeAssert;
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
        List<Tapahtuma> tapahtumat = tapahtumaRepository.findAll();
        assertThat(tapahtumat.get(2).getTapahtumaId()).isEqualTo(3);
        assertThat(tapahtumat.get(2).getTapahtumaNimi()).isEqualTo("Stand-up show");
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
}
