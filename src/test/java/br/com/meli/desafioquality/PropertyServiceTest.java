package br.com.meli.desafioquality;

import br.com.meli.desafioquality.entities.Property;
import br.com.meli.desafioquality.entities.Room;
import br.com.meli.desafioquality.services.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Arrays;

public class PropertyServiceTest {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private PropertyRepository propertyRepository;

    @Test
    public void shouldCalculatePropertyTotalM2() {
        // arrange
        Room room1 = new Room("Sala de Estar", 30, 40);
        Room room2 = new Room("Cozinha", 50, 50);

        Property property = new Property(1, "Fazenda Boa Vista", 1, Arrays.asList(room1, room2));

        // act
        propertyRepository.create(property);
        BigDecimal totalM2 = propertyService.calculatePropertyTotalM2(1);

        // assert
        Assertions.assertEquals(new BigDecimal(370), totalM2);
    }

}
