package br.com.meli.desafioquality.controllers;

import br.com.meli.desafioquality.dto.district.create.CreateDistrictRequestDTO;
import br.com.meli.desafioquality.dto.district.create.CreateDistrictResponseDTO;
import br.com.meli.desafioquality.entities.District;
import br.com.meli.desafioquality.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/districts")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CreateDistrictResponseDTO createDistrict(@RequestBody @Valid CreateDistrictRequestDTO createDistrictRequestDTO) {
        District districtToCreate = new District(
            0,
            createDistrictRequestDTO.getDistrict_name(),
            createDistrictRequestDTO.getValue_district_m2()
        );

        District createdDistrict = districtService.create(districtToCreate);

        return new CreateDistrictResponseDTO(createdDistrict.getId(), createdDistrict.getName(), createdDistrict.getM2Value());
    }

}
