package ohjelmistoprojekti.ticketguru.web;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import ohjelmistoprojekti.ticketguru.domain.Tapahtuma;
import ohjelmistoprojekti.ticketguru.domain.TapahtumaRepository;
import ohjelmistoprojekti.ticketguru.service.TapahtumaService;

@ExtendWith(MockitoExtension.class)
public class TapahtumaRestControllerTest {

    @Mock
    private TapahtumaRepository tapahtumaRepository;

    @Mock
    private TapahtumaService tapahtumaService;

    @InjectMocks
    private TapahtumaRestController tapahtumaRestController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(tapahtumaRestController).build();
    }

    @Test
    void testFindTapahtumaById_WithValidId_ReturnsTapahtuma() throws Exception {
        Tapahtuma tapahtuma = new Tapahtuma("TapahtumaTesti", "Kuvaus tapahtuma testille", 25, null, null, 3000);
        tapahtuma.setTapahtumaId(1L);
        Optional<Tapahtuma> tapahtumaOptional = Optional.of(tapahtuma);
        when(tapahtumaRepository.findById(1L)).thenReturn(tapahtumaOptional);

        // Print JSON representation of tapahtuma
        ObjectMapper objectMapper = new ObjectMapper();
        String tapahtumaJson = objectMapper.writeValueAsString(tapahtuma);
        System.out.println("Tapahtuma JSON: " + tapahtumaJson);

        // Act & Assert
        mockMvc.perform(get("/tapahtumat/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.tapahtumaId").value(1));

        assertTrue(tapahtumaOptional.isPresent(), "Event should be found");
        assertEquals("TapahtumaTesti", tapahtumaOptional.get().getTapahtumaNimi(), "Event name should match");
    }
}
