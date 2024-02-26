package ohjelmistoprojekti.ticketguru;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ohjelmistoprojekti.ticketguru.domain.Asiakasryhma;
import ohjelmistoprojekti.ticketguru.domain.AsiakasryhmaRepository;
import ohjelmistoprojekti.ticketguru.domain.Jarjestaja;
import ohjelmistoprojekti.ticketguru.domain.JarjestajaRepository;
import ohjelmistoprojekti.ticketguru.domain.Kayttaja;
import ohjelmistoprojekti.ticketguru.domain.KayttajaRepository;
import ohjelmistoprojekti.ticketguru.domain.LippuRepository;
import ohjelmistoprojekti.ticketguru.domain.Lipputyyppi;
import ohjelmistoprojekti.ticketguru.domain.Postitoimipaikka;
import ohjelmistoprojekti.ticketguru.domain.PostitoimipaikkaRepository;
import ohjelmistoprojekti.ticketguru.domain.Rooli;
import ohjelmistoprojekti.ticketguru.domain.RooliRepository;
import ohjelmistoprojekti.ticketguru.domain.Tapahtuma;
import ohjelmistoprojekti.ticketguru.domain.TapahtumaRepository;
import ohjelmistoprojekti.ticketguru.domain.Tapahtumapaikka;
import ohjelmistoprojekti.ticketguru.domain.TapahtumapaikkaRepository;
import ohjelmistoprojekti.ticketguru.domain.Yhteyshenkilo;
import ohjelmistoprojekti.ticketguru.domain.YhteyshenkiloRepository;

@SpringBootApplication
public class TicketguruApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketguruApplication.class, args);		

	}
	
	@Configuration
	public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(TapahtumaRepository tapahtumaRepository, 
                                    TapahtumapaikkaRepository tapahtumapaikkaRepository, 
                                    JarjestajaRepository jarjestajaRepository,
                                    YhteyshenkiloRepository yhteyshenkiloRepository,
                                    PostitoimipaikkaRepository postitoimipaikkaRepository, AsiakasryhmaRepository asryhRepository, KayttajaRepository kayttajaRepository, RooliRepository rooliRepository, LippuRepository lipputyyppiRepository) {
        return args -> {
            // Luodaan postitoimipaikat
            Postitoimipaikka helsinki = postitoimipaikkaRepository.save(new Postitoimipaikka("00100", "Helsinki"));
			Postitoimipaikka helsinki2 = postitoimipaikkaRepository.save(new Postitoimipaikka("00600", "Helsinki"));
			
            // Luodaan yhteyshenkilöitä
            Yhteyshenkilo yhteys1 = yhteyshenkiloRepository.save(new Yhteyshenkilo("Matti", "Meikäläinen", "matti@example.com", "0401234567", "Markkinointipäällikkö"));
			Yhteyshenkilo yhteys2 = yhteyshenkiloRepository.save(new Yhteyshenkilo("Liisa", "Laaksonen", "liisa@example.com", "0501234567", "Tuotantopäällikkö"));
			Yhteyshenkilo yhteys3 = yhteyshenkiloRepository.save(new Yhteyshenkilo("Jukka", "Järvinen", "jukka@example.com", "0451234567", "Tapahtumakoordinaattori"));

            
            // Luodaan tapahtumapaikkoja
            Tapahtumapaikka paikka1 = tapahtumapaikkaRepository.save(new Tapahtumapaikka("Kulttuuritalo", "Sturenkatu 4, Helsinki", "Kulttuuritapahtumien keskus", "1234567-8", "info@kulttuuritalo.fi", "Esteetön pääsy", new ArrayList<>(), new ArrayList<>(), helsinki));
            Tapahtumapaikka paikka2 = tapahtumapaikkaRepository.save(new Tapahtumapaikka("Messukeskus", "Messuaukio 1, Helsinki", "Suomen suurin messukeskus", "2345678-9", "contact@messukeskus.fi", "Pysäköintitilaa saatavilla", new ArrayList<>(), new ArrayList<>(), helsinki2));
            Tapahtumapaikka paikka3 = tapahtumapaikkaRepository.save(new Tapahtumapaikka("Linnanmäki", "Tivolikuja 1, Helsinki", "Huvipuisto kaikenikäisille", "3456789-0", "info@linnanmaki.fi", "Koirat sallittu hihnassa", new ArrayList<>(), new ArrayList<>(), helsinki));
			
            // Luodaan järjestäjiä
            Jarjestaja jarjestaja1 = jarjestajaRepository.save(new Jarjestaja("Musiikki Oy", "1234567-8", "Mannerheimintie 13", helsinki, yhteys1));
			Jarjestaja jarjestaja2 = jarjestajaRepository.save(new Jarjestaja("Festivaali Oy", "2234567-8", "Bulevardi 14", helsinki, yhteys2));
			Jarjestaja jarjestaja3 = jarjestajaRepository.save(new Jarjestaja("Konsertti Oy", "3234567-8", "Fredrikinkatu 15", helsinki2, yhteys3));


            // Luodaan tapahtumia
            tapahtumaRepository.save(new Tapahtuma("Rock Festivaali", ZonedDateTime.now().plusDays(10), ZonedDateTime.now().plusDays(10).plusHours(5), "Suurin rock tapahtuma vuonna", 50.00, paikka1, jarjestaja1, new HashSet<>(), null));
			tapahtumaRepository.save(new Tapahtuma("Jazz-ilta", ZonedDateTime.now().plusDays(20), ZonedDateTime.now().plusDays(20).plusHours(4), "Nauti rennosta jazz-musiikista", 40.00, paikka2, jarjestaja2, new HashSet<>(), null));
        	tapahtumaRepository.save(new Tapahtuma("Stand-up show", ZonedDateTime.now().plusDays(30), ZonedDateTime.now().plusDays(30).plusHours(3), "Naurua koko illaksi", 35.00, paikka3, jarjestaja3, new HashSet<>(), null));

            // Luodaan asiakaryhmiä
            Asiakasryhma aikuinen = asryhRepository.save(new Asiakasryhma("Aikuinen", "Yli 18-vuotiaat", true));
            Asiakasryhma lapsi = asryhRepository.save(new Asiakasryhma("Lapsi", "Alle 18-vuotiaat", true));
            Asiakasryhma elakelainen = asryhRepository.save(new Asiakasryhma("Elakelainen", "Eläkkeellä olevat henkilöt", true));
            Asiakasryhma tyoton = asryhRepository.save(new Asiakasryhma("Tyoton", "Työttömät henkilöt", true));

            // Luodaan roolit
            Rooli myyja = rooliRepository.save(new Rooli("Myyjä"));
            Rooli lipuntarkastaja = rooliRepository.save(new Rooli("Lipuntarkastaja"));
            Rooli hallinto = rooliRepository.save(new Rooli("Hallinto"));

            // Luodaan käyttäjät ja liitetään roolit
            kayttajaRepository.save(new Kayttaja("salasana123", "Mäkinen", "Matti", "Myyntialue", myyja));
            kayttajaRepository.save(new Kayttaja("salasana456", "Virtanen", "Veera", "Tarkastusaluella", lipuntarkastaja));
            kayttajaRepository.save(new Kayttaja("salasana789", "Laaksonen", "Liisa", "Hallinnossa", hallinto));

            // Luodaan lipputyypit
            lipputyyppiRepository.save(new Lipputyyppi("Normaali", 0.0, aikuinen));
            lipputyyppiRepository.save(new Lipputyyppi("Lapsi", -5.0, lapsi));
            lipputyyppiRepository.save(new Lipputyyppi("Eläkeläinen", -3.0, elakelainen));
            lipputyyppiRepository.save(new Lipputyyppi("Työtön", -2.0, tyoton));

        };
    }
}
}
