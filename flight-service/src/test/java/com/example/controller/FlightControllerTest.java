package com.example.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class FlightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAddFlight() throws Exception {

        String flightJson = """
        {
            "carrier":"Indigo",
            "source":"Nagpur",
            "destination":"Mumbai",
            "cost":4500
        }
        """;

        mockMvc.perform(post("/api/flights/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(flightJson))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllFlights() throws Exception {

        mockMvc.perform(get("/api/flights"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetFlightById() throws Exception {

        mockMvc.perform(get("/api/flights/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteFlight() throws Exception {

        mockMvc.perform(delete("/api/flights/1"))
                .andExpect(status().isOk());
    }
}