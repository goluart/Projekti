package ohjelmistoprojekti.ticketguru.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class TapahtumatRepositoryTest {

    @Autowired
    private TapahtumaRepository tapahtumaRepository;
    private TapahtumapaikkaRepository tapahtumapaikkaRepository;
    private JarjestajaRepository jarjestajaRepository;
    private LippuRepository lippuRepository;
    private LipputyyppiRepository lipputyyppiRepository;

    @Test
    void etsiKaikkiTapahtumat() {

        List<Tapahtuma> tapahtumat = tapahtumaRepository.findAll();
        assertThat(tapahtumat).isEmpty();
    }

}
