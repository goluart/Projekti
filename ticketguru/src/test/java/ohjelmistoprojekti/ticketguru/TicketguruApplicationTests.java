package ohjelmistoprojekti.ticketguru;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ohjelmistoprojekti.ticketguru.web.TapahtumaRestController;

@SpringBootTest
class TicketguruApplicationTests {

	@Autowired
	TapahtumaRestController tapahtumaRestController;

	@Test
	void contextLoads() {
		assertThat(tapahtumaRestController).isNotNull();
	}

}
