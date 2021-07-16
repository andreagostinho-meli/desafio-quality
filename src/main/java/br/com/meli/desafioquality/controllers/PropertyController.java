package br.com.meli.desafioquality.controllers;

import br.com.meli.desafioquality.dto.property.create.CreatePropertyRequestDTO;
import br.com.meli.desafioquality.dto.property.create.CreatePropertyResponseDTO;
import br.com.meli.desafioquality.entities.District;
import br.com.meli.desafioquality.entities.Property;
import br.com.meli.desafioquality.entities.Room;
import br.com.meli.desafioquality.services.DistrictService;
import br.com.meli.desafioquality.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @Autowired
    DistrictService districtService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CreatePropertyResponseDTO createProperty(@Valid @RequestBody CreatePropertyRequestDTO createPropertyRequestDTO) {
        District district = districtService.findById(createPropertyRequestDTO.getProp_district_id());

        List<Room> rooms = new ArrayList<>();

        createPropertyRequestDTO.getRooms().forEach(room -> {
            rooms.add(new Room(room.getRoom_name(), room.getRoom_width(), room.getRoom_length()));
        });

        Property propertyToCreate = new Property(
        0,
            createPropertyRequestDTO.getProp_name(),
            createPropertyRequestDTO.getProp_district_id(),
            rooms
        );

        Property createdProperty = propertyService.create(propertyToCreate);

        return new CreatePropertyResponseDTO(
                createdProperty.getId(),
                createdProperty.getName(),
                district.getName(),
                district.getM2Value(),
                createPropertyRequestDTO.getRooms()
        );
    }

}
