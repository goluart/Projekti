package ohjelmistoprojekti.ticketguru.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ohjelmistoprojekti.ticketguru.dto.LuoMyyntitapahtumaDTO;
import ohjelmistoprojekti.ticketguru.dto.LuoMyyntitapahtumaDTO.LippuTyyppiMaaraDTO;

@DataJpaTest
public class MyyntitapahtumatRepositoryTest {

    @Autowired
    private MyyntitapahtumaRepository myyntitapahtumaRepository;

    @Autowired
    private TapahtumapaikkaRepository tapahtumapaikkaRepository;

    @Autowired
    private TapahtumaRepository tapahtumaRepository;

    @Autowired
    private JarjestajaRepository jarjestajaRepository;

    @Autowired
    private LipputyyppiRepository lipputyyppiRepository;

    @Test
    void testId5EtsiKaikkiMyyntitapahtumat() {
        List<Myyntitapahtuma> myyntitapahtumat = myyntitapahtumaRepository.findAll();
        assertThat(myyntitapahtumat).hasSizeGreaterThan(0);
    }
    /*
     * @Test
     * void testId6LisaaMyyntitapahtuma() {
     * Tapahtumapaikka tapahtumapaikka = new Tapahtumapaikka("Vanha jäähalli");
     * tapahtumapaikkaRepository.save(tapahtumapaikka);
     * 
     * Jarjestaja jarjestaja = new Jarjestaja("Livemusa Oy");
     * jarjestajaRepository.save(jarjestaja);
     * 
     * Tapahtuma tapahtuma = new Tapahtuma("Testimusabileet", "Outoa musiikkia", 50,
     * tapahtumapaikka, jarjestaja, 100);
     * tapahtumaRepository.save(tapahtuma);
     * 
     * assertThat(tapahtuma.getTapahtumaId()).isEqualTo(4);
     * 
     * 
     * 
     * @SuppressWarnings("unchecked")
     * LuoMyyntitapahtumaDTO luoMyyntitapahtumaDTO = new
     * LuoMyyntitapahtumaDTO((long) 4,
     * (List<LippuTyyppiMaaraDTO>) lippuTyyppiMaaraDTO);
     * 
     * 
     * 
     * }
     */

}
