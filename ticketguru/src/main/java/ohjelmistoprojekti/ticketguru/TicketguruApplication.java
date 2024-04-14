package ohjelmistoprojekti.ticketguru;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import ohjelmistoprojekti.ticketguru.domain.Asiakasryhma;
import ohjelmistoprojekti.ticketguru.domain.AsiakasryhmaRepository;
import ohjelmistoprojekti.ticketguru.domain.Jarjestaja;
import ohjelmistoprojekti.ticketguru.domain.JarjestajaRepository;
import ohjelmistoprojekti.ticketguru.domain.Kayttaja;
import ohjelmistoprojekti.ticketguru.domain.KayttajaRepository;
import ohjelmistoprojekti.ticketguru.domain.Lippu;
import ohjelmistoprojekti.ticketguru.domain.LippuRepository;
import ohjelmistoprojekti.ticketguru.domain.Lipputyyppi;
import ohjelmistoprojekti.ticketguru.domain.LipputyyppiRepository;
import ohjelmistoprojekti.ticketguru.domain.Myyntitapahtuma;
import ohjelmistoprojekti.ticketguru.domain.MyyntitapahtumaRepository;
import ohjelmistoprojekti.ticketguru.domain.Postitoimipaikka;
import ohjelmistoprojekti.ticketguru.domain.PostitoimipaikkaRepository;
import ohjelmistoprojekti.ticketguru.domain.Rooli;
import ohjelmistoprojekti.ticketguru.domain.RooliRepository;
import ohjelmistoprojekti.ticketguru.domain.Tapahtuma;
import ohjelmistoprojekti.ticketguru.domain.TapahtumaRepository;
import ohjelmistoprojekti.ticketguru.domain.Tapahtumapaikka;
import ohjelmistoprojekti.ticketguru.domain.TapahtumapaikkaRepository;
import ohjelmistoprojekti.ticketguru.domain.Tarkastus;
import ohjelmistoprojekti.ticketguru.domain.TarkastusRepository;
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
		@Profile("dev")
		CommandLineRunner initDatabase(TapahtumaRepository tapahtumaRepository,
				TapahtumapaikkaRepository tapahtumapaikkaRepository,
				JarjestajaRepository jarjestajaRepository,
				YhteyshenkiloRepository yhteyshenkiloRepository,
				PostitoimipaikkaRepository postitoimipaikkaRepository,
				AsiakasryhmaRepository asryhRepository,
				KayttajaRepository kayttajaRepository, RooliRepository rooliRepository,
				LipputyyppiRepository lipputyyppiRepository,
				MyyntitapahtumaRepository myyntitapahtumaRepository,
				LippuRepository lippuRepository, TarkastusRepository tarkastusRepository) {
			return args -> {
				// Luodaan postitoimipaikat
				Postitoimipaikka helsinki = postitoimipaikkaRepository
						.save(new Postitoimipaikka("00100", "Helsinki"));
				Postitoimipaikka helsinki2 = postitoimipaikkaRepository
						.save(new Postitoimipaikka("00600", "Helsinki"));

				// Luodaan yhteyshenkilöitä
				Yhteyshenkilo yhteys1 = yhteyshenkiloRepository.save(new Yhteyshenkilo("Matti",
						"Meikäläinen",
						"matti@example.com", "0401234567", "Markkinointipäällikkö"));
				Yhteyshenkilo yhteys2 = yhteyshenkiloRepository.save(new Yhteyshenkilo("Liisa",
						"Laaksonen",
						"liisa@example.com", "0501234567", "Tuotantopäällikkö"));
				Yhteyshenkilo yhteys3 = yhteyshenkiloRepository.save(new Yhteyshenkilo("Jukka",
						"Järvinen",
						"jukka@example.com", "0451234567", "Tapahtumakoordinaattori"));

				// Luodaan roolit
				Rooli myyja = rooliRepository.save(new Rooli("myyja"));
				Rooli lipuntarkastaja = rooliRepository.save(new Rooli("lipuntarkastaja"));
				Rooli hallinto = rooliRepository.save(new Rooli("hallinto"));

				// Luodaan käyttäjät ja liitetään roolit
				// Tunnus ja salasana vaihdettu rooleiksi testausta varten
				kayttajaRepository.save(new Kayttaja("myyja", "myyja", "Mäkinen", "Matti", "Myyntialue", myyja));
				kayttajaRepository.save(new Kayttaja("lipuntarkastaja", "lipuntarkastaja", "Virtanen", "Veera",
						"Tarkastusaluella", lipuntarkastaja));
				kayttajaRepository
						.save(new Kayttaja("hallinto", "hallinto", "Laaksonen", "Liisa", "Hallinnossa", hallinto));
				kayttajaRepository.save(new Kayttaja("testi", "testi", "Testaaja", "Liisa", "Myyntialue", myyja));

				// Luodaan tapahtumapaikkoja
				Tapahtumapaikka paikka1 = tapahtumapaikkaRepository.save(new Tapahtumapaikka(
						"Kulttuuritalo",
						"Sturenkatu 4, Helsinki", "Kulttuuritapahtumien keskus", "1234567-8",
						"info@kulttuuritalo.fi",
						"Esteetön pääsy", new ArrayList<>(), new ArrayList<>(), helsinki));
				Tapahtumapaikka paikka2 = tapahtumapaikkaRepository
						.save(new Tapahtumapaikka("Messukeskus",
								"Messuaukio 1, Helsinki", "Suomen suurin messukeskus",
								"2345678-9", "contact@messukeskus.fi",
								"Pysäköintitilaa saatavilla", new ArrayList<>(),
								new ArrayList<>(), helsinki2));
				Tapahtumapaikka paikka3 = tapahtumapaikkaRepository
						.save(new Tapahtumapaikka("Linnanmäki",
								"Tivolikuja 1, Helsinki", "Huvipuisto kaikenikäisille",
								"3456789-0", "info@linnanmaki.fi",
								"Koirat sallittu hihnassa", new ArrayList<>(),
								new ArrayList<>(), helsinki));

				// Luodaan järjestäjiä
				Jarjestaja jarjestaja1 = jarjestajaRepository
						.save(new Jarjestaja("Musiikki Oy", "1234567-8", "Mannerheimintie 13",
								helsinki, yhteys1));
				Jarjestaja jarjestaja2 = jarjestajaRepository
						.save(new Jarjestaja("Festivaali Oy", "2234567-8", "Bulevardi 14",
								helsinki, yhteys2));
				Jarjestaja jarjestaja3 = jarjestajaRepository
						.save(new Jarjestaja("Konsertti Oy", "3234567-8", "Fredrikinkatu 15",
								helsinki2, yhteys3));

				// Luodaan asiakaryhmiä
				Asiakasryhma aikuinen = asryhRepository
						.save(new Asiakasryhma("Aikuinen", "Yli 18-vuotiaat"));
				Asiakasryhma lapsi = asryhRepository
						.save(new Asiakasryhma("Lapsi", "Alle 18-vuotiaat"));
				Asiakasryhma elakelainen = asryhRepository
						.save(new Asiakasryhma("Elakelainen", "Eläkkeellä olevat henkilöt"));
				Asiakasryhma tyoton = asryhRepository
						.save(new Asiakasryhma("Tyoton", "Työttömät henkilöt"));

				Lipputyyppi normaali = lipputyyppiRepository
						.save(new Lipputyyppi("Aikuinen", 0.5, aikuinen));
				Lipputyyppi lapsi5 = lipputyyppiRepository.save(new Lipputyyppi("Lapsi", 0.5, lapsi));
				Lipputyyppi elakelainen3 = lipputyyppiRepository
						.save(new Lipputyyppi("Eläkeläinen", 0.7, elakelainen));

				Set<Lipputyyppi> lipputyypit = new HashSet<>();
				lipputyypit.add(normaali);
				// lipputyypit.add(lapsi5);
				lipputyypit.add(elakelainen3);

				// Luodaan tapahtumia
				Tapahtuma tapahtuma = tapahtumaRepository.save(new Tapahtuma("Rock Festivaali",
						ZonedDateTime.of(LocalDateTime.of(2025, 3, 22, 19, 0),
								ZoneId.of("Europe/Helsinki")),
						ZonedDateTime.of(LocalDateTime.of(2025, 3, 23, 01, 0),
								ZoneId.of("Europe/Helsinki")),
						"Suurin rock tapahtuma vuonna 2025", 50.00, paikka1, jarjestaja1,
						lipputyypit, 15000));
				tapahtumaRepository.save(new Tapahtuma("Jazz-ilta",
						ZonedDateTime.of(LocalDateTime.of(2025, 4, 20, 21, 30),
								ZoneId.of("Europe/Helsinki")),
						ZonedDateTime.of(LocalDateTime.of(2025, 4, 21, 02, 0),
								ZoneId.of("Europe/Helsinki")),
						"Nauti rennosta jazz-musiikista", 40.00, paikka2, jarjestaja2,
						lipputyypit, 70));
				tapahtumaRepository.save(new Tapahtuma("Stand-up show",
						ZonedDateTime.of(LocalDateTime.of(2025, 5, 15, 18, 0),
								ZoneId.of("Europe/Helsinki")),
						ZonedDateTime.of(LocalDateTime.of(2025, 5, 15, 22, 0),
								ZoneId.of("Europe/Helsinki")),
						"Naurua koko illaksi", 35.00, paikka3, jarjestaja3, lipputyypit, 150));

				// Alustetaan myyntitapahtuma
				Myyntitapahtuma myyntitapahtuma = new Myyntitapahtuma(LocalDateTime.now(), 0.1);
				myyntitapahtumaRepository.save(myyntitapahtuma);

				List<Lippu> myydytLiput = new ArrayList<>();

				Lippu lippu1 = new Lippu(tapahtuma, myyntitapahtuma, normaali, 60.00);
				Lippu lippu2 = new Lippu(tapahtuma, myyntitapahtuma, lapsi5, 30.00);
				Lippu lippu3 = new Lippu(tapahtuma, myyntitapahtuma, elakelainen3, 45.00);
				lippuRepository.save(lippu1);
				lippuRepository.save(lippu2);
				lippuRepository.save(lippu3);
				myydytLiput.add(lippu1);
				myydytLiput.add(lippu2);
				myydytLiput.add(lippu3);

				// Viimeistellään myyntitapahtuma
				myyntitapahtuma.setLiput(myydytLiput);
				myyntitapahtuma.setLoppusumma(135.0);
				myyntitapahtumaRepository.save(myyntitapahtuma);

				// Generoidaan tarkastustapahtuma tietokantaan testejä varten
				Tarkastus tarkastus = new Tarkastus();
				tarkastus.setKayttoPvm(ZonedDateTime.now());
				tarkastus.setLippu(lippu1);
				tarkastus.setTapahtuma(lippu1.getTapahtuma());
				tarkastus.setLipputyyppi(lippu1.getLipputyyppi());
				tarkastus.setTapahtumapaikka(lippu1.getTapahtuma().getTapahtumapaikka());
				tarkastusRepository.save(tarkastus);

				Tarkastus tarkastus2 = new Tarkastus();
				tarkastus2.setKayttoPvm(ZonedDateTime.now());
				tarkastus2.setLippu(lippu2);
				tarkastus2.setTapahtuma(lippu2.getTapahtuma());
				tarkastus2.setLipputyyppi(lippu2.getLipputyyppi());
				tarkastus2.setTapahtumapaikka(lippu2.getTapahtuma().getTapahtumapaikka());
				tarkastusRepository.save(tarkastus2);

			};
		}
	}

}