package br.com.meli.desafioquality;

import br.com.meli.desafioquality.dto.district.create.CreateDistrictRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class DistrictControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void shouldCreateDistrict() throws Exception {
        // arrange
        CreateDistrictRequestDTO createDistrictRequest = new CreateDistrictRequestDTO();
        createDistrictRequest.setDistrict_name("Laranjeiras");
        createDistrictRequest.setValue_district_m2(new BigDecimal(400));

        String createDistrictRequestJSON = objectMapper.writeValueAsString(createDistrictRequest);

        // act
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/districts")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(createDistrictRequestJSON)
        );

        // assert
        result.andExpect(MockMvcResultMatchers.status().isCreated());
    }

}
