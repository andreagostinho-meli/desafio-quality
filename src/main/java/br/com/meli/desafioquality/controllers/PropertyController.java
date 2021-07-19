package br.com.meli.desafioquality.controllers;

import br.com.meli.desafioquality.dto.property.create.CreatePropertyRequestDTO;
import br.com.meli.desafioquality.dto.property.create.CreatePropertyResponseDTO;
import br.com.meli.desafioquality.dto.property.getlargestroom.GetLargestRoomResponseDTO;
import br.com.meli.desafioquality.dto.property.getroomsm2.GetRoomsM2ResponseDTO;
import br.com.meli.desafioquality.dto.property.getroomsm2.RoomM2DTO;
import br.com.meli.desafioquality.dto.property.gettotalm2.GetPropertyTotalM2ResponseDTO;
import br.com.meli.desafioquality.dto.property.getvalue.GetPropertyValueResponseDTO;
import br.com.meli.desafioquality.entities.District;
import br.com.meli.desafioquality.entities.Property;
import br.com.meli.desafioquality.entities.Room;
import br.com.meli.desafioquality.services.DistrictService;
import br.com.meli.desafioquality.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
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

    @GetMapping("/total_m2/{id}")
    @ResponseBody
    public GetPropertyTotalM2ResponseDTO getPropertyTotalM2(@PathVariable int id) {
        double totalM2 = propertyService.calculatePropertyTotalM2(id);
        return new GetPropertyTotalM2ResponseDTO(totalM2);
    }

    @GetMapping("/value/{id}")
    @ResponseBody
    public GetPropertyValueResponseDTO getPropertyValue(@PathVariable int id) {
        Property property = propertyService.findById(id);
        District district = districtService.findById(property.getDistrict_id());

        BigDecimal propertyValue = propertyService.calculatePropertyValue(property, district);

        return new GetPropertyValueResponseDTO(propertyValue);
    }

    @GetMapping("/{propertyId}/largest_room")
    @ResponseBody
    public GetLargestRoomResponseDTO getLargestRoom(@PathVariable int propertyId) {
        Room largestRoom = propertyService.findLargestRoom(propertyId);
        return new GetLargestRoomResponseDTO(largestRoom);
    }

    @GetMapping("/{propertyId}/rooms_m2")
    @ResponseBody
    public GetRoomsM2ResponseDTO getRoomsM2(@PathVariable int propertyId) {
        Property property = propertyService.findById(propertyId);
        List<Room> propertyRooms = property.getRooms();
        List<Double> m2Values = propertyService.calculateM2ForAllRooms(propertyId);
        GetRoomsM2ResponseDTO getRoomsM2ResponseDTO = new GetRoomsM2ResponseDTO(new ArrayList<>());

        for(int i = 0; i < propertyRooms.size(); i++) {
            Room room = propertyRooms.get(i);
            RoomM2DTO roomM2DTO = new RoomM2DTO(room.getName(), room.getWidth(), room.getLength(), m2Values.get(i));

            List<RoomM2DTO> roomsList = getRoomsM2ResponseDTO.getRooms();
            roomsList.add(roomM2DTO);

            getRoomsM2ResponseDTO.setRooms(roomsList);
        }

        return getRoomsM2ResponseDTO;
    }

}
