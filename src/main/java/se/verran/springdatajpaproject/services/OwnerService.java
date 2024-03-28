package se.verran.springdatajpaproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.verran.springdatajpaproject.entities.Owner;
import se.verran.springdatajpaproject.repositories.OwnerRepository;

import java.util.List;

@Service
public class OwnerService implements OwnerServiceInterface{

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }
}
