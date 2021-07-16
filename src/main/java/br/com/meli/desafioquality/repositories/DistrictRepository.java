package br.com.meli.desafioquality.repositories;

import br.com.meli.desafioquality.entities.District;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DistrictRepository {

    private int id = 1;
    private List<District> districts = new ArrayList<>();

    public District create(District district) {
        district.setId(id);
        id++;

        districts.add(district);
        return district;
    }

    public District findById(int id) {
        return districts.stream().filter(district -> district.getId() == id).findFirst().orElse(null);
    }

}
