package br.com.meli.desafioquality;

import br.com.meli.desafioquality.exceptions.DistrictNotFoundException;
import br.com.meli.desafioquality.services.DistrictService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DistrictServiceTest {

    @Autowired
    private DistrictService districtService;

    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldNotCreatePropertyIfDistrictNotExists() {
        Assertions.assertThrows(DistrictNotFoundException.class, () -> {
            districtService.findById(1);
        });
    }

}
