package br.com.meli.desafioquality.services;

import br.com.meli.desafioquality.entities.District;
import br.com.meli.desafioquality.entities.Property;
import br.com.meli.desafioquality.entities.Room;
import br.com.meli.desafioquality.exceptions.PropertyNotFoundException;
import br.com.meli.desafioquality.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
public class PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    public Property create(Property property) {
        return propertyRepository.create(property);
    }

    public double calculatePropertyTotalM2(int id) {
        Property property = propertyRepository.findById(id);
        checkIfPropertyExists(property);

        return property.getRooms().stream().mapToDouble(room -> room.getWidth() * room.getLength()).sum();
    }

    public Property findById(int id) {
        Property property = propertyRepository.findById(id);
        checkIfPropertyExists(property);

        return property;
    }

    public BigDecimal calculatePropertyValue(Property property, District district) {
        double totalM2 = calculatePropertyTotalM2(property.getId());
        return district.getM2Value().multiply(BigDecimal.valueOf(totalM2));
    }

    public Room findLargestRoom(int propertyId) {
        Property property = propertyRepository.findById(propertyId);
        checkIfPropertyExists(property);

        Room largestRoom = property.getRooms().get(0);
        double largestRoomM2 = calculateRoomM2(property.getRooms().get(0));

        for (Room room : property.getRooms()) {
            double currentRoomM2 = calculateRoomM2(room);
            if (currentRoomM2 > largestRoomM2) largestRoom = room;
        }

        return largestRoom;
    }

    public List<Double> calculateM2ForAllRooms(int propertyId) {
        Property property = propertyRepository.findById(propertyId);
        checkIfPropertyExists(property);

        List<Double> roomsM2 = new ArrayList<>();

        property.getRooms().forEach(room -> {
            roomsM2.add(calculateRoomM2(room));
        });

        return roomsM2;
    }

    private double calculateRoomM2(Room room) {
        return room.getWidth() * room.getLength();
    }

    private void checkIfPropertyExists(Property property) {
        if(property == null) throw new PropertyNotFoundException();
    }

}
