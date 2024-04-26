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

    // Testing a single tapahtuma with tapahtumat/1 endpoint (get)
    @Test
    void testFindTapahtumaById_WithValidId_ReturnsTapahtuma() throws Exception {
        Tapahtuma tapahtuma = new Tapahtuma("TapahtumaTesti", "Kuvaus tapahtuma testille", 25, null, null, 3000);
        tapahtuma.setTapahtumaId(1L);
        Optional<Tapahtuma> tapahtumaOptional = Optional.of(tapahtuma);
        when(tapahtumaRepository.findById(1L)).thenReturn(tapahtumaOptional);

        // Debugging output for request JSON
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

    // Tapahtuma with non existing ID returns 404 Not Found
    @Test
    void testFindTapahtumaById_NonExistingId_Returns404() throws Exception {
        when(tapahtumaRepository.findById(1L)).thenReturn(Optional.empty());
        // Log before performing the HTTP request
        System.out.println("Sending GET request to /tapahtumat/1...");

        mockMvc.perform(get("/tapahtumat/1"))
                .andExpect(status().isNotFound());
    }

    // Uuden tapahtuma lisäys (post)
    @Test
    void testNewTapahtuma_CreatesEvent() throws Exception {
        Tapahtuma tapahtuma = new Tapahtuma("Uusi Testi Tapahtuma", "Kuvaus uudelle testi tapahtumalle", 50, null, null,
                500);
        when(tapahtumaRepository.save(any(Tapahtuma.class))).thenReturn(tapahtuma);

        ObjectMapper objectMapper = new ObjectMapper();
        String tapahtumaJson = objectMapper.writeValueAsString(tapahtuma);
        System.out.println("Uusi Tapahtuma JSON: " + tapahtumaJson);

        mockMvc.perform(post("/tapahtumat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(tapahtumaJson))
                .andExpect(status().isCreated());
    }

    // Tapahtuman poisto (delete)
    @Test
    void testDeleteTapahtuma_DeleteExisting() throws Exception {
        Tapahtuma tapahtuma = new Tapahtuma("Poistettava Testi Tapahtuma", "Kuvaus poistettavalle testi tapahtumalle",
                75, null, null, 1300);
        when(tapahtumaRepository.findById(1L)).thenReturn(Optional.of(tapahtuma));

        // Debugging output for request JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String tapahtumaJson = objectMapper.writeValueAsString(tapahtuma);
        System.out.println("Request JSON: " + tapahtumaJson);

        mockMvc.perform(delete("/tapahtumat/1"))
                .andExpect(status().isNoContent());
    }

}