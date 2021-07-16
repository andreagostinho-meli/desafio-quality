package br.com.meli.desafioquality;

import br.com.meli.desafioquality.entities.District;
import br.com.meli.desafioquality.entities.Property;
import br.com.meli.desafioquality.entities.Room;
import br.com.meli.desafioquality.repositories.DistrictRepository;
import br.com.meli.desafioquality.repositories.PropertyRepository;
import br.com.meli.desafioquality.services.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootTest
public class PropertyServiceTest {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Test
    public void shouldCalculatePropertyTotalM2() {
        // arrange
        districtRepository.create(new District(1, "Laranjeiras", new BigDecimal(400)));

        Room room1 = new Room("Sala de Estar", 20, 20);
        Room room2 = new Room("Cozinha", 30, 30);

        propertyRepository.create(new Property(1, "Fazenda Boa Vista", 1, Arrays.asList(room1, room2)));

        // act
        double totalM2 = propertyService.calculatePropertyTotalM2(1);

        // assert
        Assertions.assertEquals(1300, totalM2);
    }

    @Test
    public void shouldCalculatePropertyValue() {
        // arrange
        District district = districtRepository.create(new District(1, "Laranjeiras", new BigDecimal(400)));

        Room room1 = new Room("Sala de Estar", 20, 20);
        Room room2 = new Room("Cozinha", 30, 30);

        Property property = propertyRepository.create(
            new Property(
                1,
                "Fazenda Boa Vista",
                1,
                Arrays.asList(room1, room2)
            )
        );

        // act
        BigDecimal propertyValue = propertyService.calculatePropertyValue(property, district);

        // assert
        Assertions.assertEquals(BigDecimal.valueOf(520000.0), propertyValue);
    }

}
