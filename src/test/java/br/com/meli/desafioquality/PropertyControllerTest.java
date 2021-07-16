package br.com.meli.desafioquality;

import br.com.meli.desafioquality.dto.property.RoomRequestDTO;
import br.com.meli.desafioquality.dto.property.create.CreatePropertyRequestDTO;
import br.com.meli.desafioquality.entities.District;
import br.com.meli.desafioquality.repositories.DistrictRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    DistrictRepository districtRepository;

    @Test
    public void shouldCreateProperty() throws Exception {
        // arrange
        CreatePropertyRequestDTO createPropertyRequest = new CreatePropertyRequestDTO();
        RoomRequestDTO room1 = new RoomRequestDTO();
        RoomRequestDTO room2 = new RoomRequestDTO();

        room1.setRoom_name("Sala de estar");
        room1.setRoom_width(10);
        room1.setRoom_length(20);

        room2.setRoom_name("Cozinha");
        room2.setRoom_width(30);
        room2.setRoom_length(30);

        createPropertyRequest.setProp_name("Fazenda Boa Vista");
        createPropertyRequest.setProp_district_id(1);
        createPropertyRequest.setRooms(Arrays.asList(room1, room2));

        districtRepository.create(new District(1, "Laranjeiras", new BigDecimal(400)));

        String createPropertyRequestJSON = objectMapper.writeValueAsString(createPropertyRequest);

        // act
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/properties")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(createPropertyRequestJSON)
        );

        // assert
        result.andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
