package br.com.meli.desafioquality;

import br.com.meli.desafioquality.exceptions.DistrictNotFoundException;
import br.com.meli.desafioquality.services.DistrictService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DistrictServiceTest {

    @Autowired
    private DistrictService districtService;

    @Test
    public void shouldNotCreatePropertyIfDistrictNotExists() {
        Assertions.assertThrows(DistrictNotFoundException.class, () -> {
            districtService.findById(1);
        });
    }

}
