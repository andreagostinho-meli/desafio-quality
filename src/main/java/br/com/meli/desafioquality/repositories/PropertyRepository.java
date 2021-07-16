package br.com.meli.desafioquality.repositories;

import br.com.meli.desafioquality.entities.Property;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PropertyRepository {

    private int id = 1;
    private List<Property> properties = new ArrayList<>();

    public Property create(Property property) {
        property.setId(id);
        id++;

        properties.add(property);
        return property;
    }

    public Property findById(int id) {
        return properties.stream().filter(property -> property.getId() == id).findFirst().orElse(null);
    }

}
