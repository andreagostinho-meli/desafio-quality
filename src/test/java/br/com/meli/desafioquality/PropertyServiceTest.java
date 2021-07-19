package br.com.meli.desafioquality;

import br.com.meli.desafioquality.entities.District;
import br.com.meli.desafioquality.entities.Property;
import br.com.meli.desafioquality.entities.Room;
import br.com.meli.desafioquality.repositories.PropertyRepository;
import br.com.meli.desafioquality.services.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class PropertyServiceTest {

    @InjectMocks
    private PropertyService propertyService;

    @Mock
    private PropertyRepository propertyRepository;

    @Test
    public void shouldCalculatePropertyTotalM2() {
        // arrange
        Room room1 = new Room("Sala de Estar", 20, 20);
        Room room2 = new Room("Cozinha", 30, 30);

        Property property = new Property(1, "Fazenda Boa Vista", 1, Arrays.asList(room1, room2));

        Mockito.when(propertyRepository.findById(1)).thenReturn(property);

        // act
        double totalM2 = propertyService.calculatePropertyTotalM2(1);
        Mockito.verify(propertyRepository).findById(1);

        // assert
        Assertions.assertEquals(1300, totalM2);
    }

    @Test
    public void shouldCalculatePropertyValue() {
        // arrange
        District district = new District(1, "Laranjeiras", new BigDecimal(400));

        Room room1 = new Room("Sala de Estar", 20, 20);
        Room room2 = new Room("Cozinha", 30, 30);

        Property property = new Property(
            1,
            "Fazenda Boa Vista",
            1,
            Arrays.asList(room1, room2)
        );

        Mockito.when(propertyRepository.findById(1)).thenReturn(property);

        // act
        BigDecimal propertyValue = propertyService.calculatePropertyValue(property, district);
        Mockito.verify(propertyRepository).findById(1);

        // assert
        Assertions.assertEquals(BigDecimal.valueOf(520000.0), propertyValue);
    }

    @Test
    public void shouldFindLargestRoom() {
        // arrange
        Room room1 = new Room("Sala de Estar", 20, 20);
        Room room2 = new Room("Cozinha", 30, 30);

        Property property = new Property(
            1,
            "Fazenda Boa Vista",
            1,
            Arrays.asList(room1, room2)
        );

        Mockito.when(propertyRepository.findById(1)).thenReturn(property);

        // act
        Room largestRoom = propertyService.findLargestRoom(property.getId());
        Mockito.verify(propertyRepository).findById(1);

        // assert
        Assertions.assertEquals(room2, largestRoom);
    }

    @Test
    public void shouldCalculateM2ForAllRooms() {
        // arrange
        Room room1 = new Room("Sala de Estar", 20, 20);
        Room room2 = new Room("Cozinha", 30, 30);

        Property property = new Property(
            1,
            "Fazenda Boa Vista",
            1,
            Arrays.asList(room1, room2)
        );

        Mockito.when(propertyRepository.findById(1)).thenReturn(property);

        // act
        List<Double> m2Values = propertyService.calculateM2ForAllRooms(property.getId());
        Mockito.verify(propertyRepository).findById(1);

        // assert
        Assertions.assertEquals(400, m2Values.get(0));
        Assertions.assertEquals(900, m2Values.get(1));
    }

}
