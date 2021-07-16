package br.com.meli.desafioquality.services;

import br.com.meli.desafioquality.entities.Property;
import br.com.meli.desafioquality.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    public Property create(Property property) {
        return propertyRepository.create(property);
    }

}
