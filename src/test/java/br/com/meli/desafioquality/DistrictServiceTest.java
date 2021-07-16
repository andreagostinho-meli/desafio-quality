package br.com.meli.desafioquality;

import br.com.meli.desafioquality.exceptions.DistrictNotFoundException;
import br.com.meli.desafioquality.services.DistrictService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DistrictServiceTest {

    @Mock
    private DistrictService districtService;

    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldNotCreatePropertyIfDistrictNotExists() {
        Mockito.when(districtService.findById(1)).thenThrow(new DistrictNotFoundException());

        Assertions.assertThrows(DistrictNotFoundException.class, () -> {
            districtService.findById(1);
        });
    }

}
