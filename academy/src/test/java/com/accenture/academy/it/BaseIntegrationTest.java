package com.accenture.academy.it;

import com.accenture.academy.church.ChurchDto;
import com.accenture.academy.priest.PriestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class BaseIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void baseTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/hello"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string("Hello World from Accenture"));
    }

    @Test
    void basePostPriestTest() throws Exception {

        //Given
        PriestDto priestDto = new PriestDto(
                "Zbyszek Zbyszek",
                180.0,
                45);

        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc
                .perform(MockMvcRequestBuilders
                                .post("http://localhost:8080/api/priests")
                                .content(objectMapper.writeValueAsString(priestDto))
                                .header("Content-Type", "application/json")
                        //.contentType("application/json")
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(202));
    }

    @Test
    void basePutTest() throws Exception {

        //Given
        int id = 1;
        PriestDto priestDto = new PriestDto(
                "Zbyszek Zbyszek",
                180.0,
                45);

        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("http://localhost:8080/api/priests/" + id)
                        .content(objectMapper.writeValueAsString(priestDto))
                        .contentType("application/json")
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(204));
    }

    @Test
    void baseDeleteTest() throws Exception {

        //Given
        int id = 4;
        PriestDto priestDto = new PriestDto(
                "Zbyszek Zbyszek",
                180.0,
                45);
        ObjectMapper objectMapper = new ObjectMapper();


        mockMvc
                .perform(MockMvcRequestBuilders.post("http://localhost:8080/api/priests")
                        .content(objectMapper.writeValueAsString(priestDto))
                        .header("Content-Type", "application/json"));
        mockMvc
                .perform(MockMvcRequestBuilders.delete("http://localhost:8080/api/priests/" + id))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(204));
    }

    @Test
    void basePostChurchTest() throws Exception {

        //Given
        ChurchDto churchDto = new ChurchDto(
                "Kosciol",
                "Gniezno",
                2000,
                10000,
                10000.00
        );

        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/api/churches")
                        .content(objectMapper.writeValueAsString(churchDto))
                        .header("Content-Type", "application/json")
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(202));
    }

    @Test
    void baseGetChurchTest() throws Exception {

        //Given
        int id = 1;

        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc
//                .perform(MockMvcRequestBuilders.post("http://localhost:8080/api/churches/"))
                .perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/churches/" + id)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {"id":1,"name":"Kościół św. Krzyża","nameOfCity":"Warszawa","numberOfSeats":150,"numberOfMembers":50000,"budget":20000.0}
                        """));
    }
}
