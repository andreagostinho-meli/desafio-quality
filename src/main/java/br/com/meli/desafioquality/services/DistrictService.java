package br.com.meli.desafioquality.services;

import br.com.meli.desafioquality.entities.District;
import br.com.meli.desafioquality.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    public District create(District district) {
        return districtRepository.create(district);
    }

}
