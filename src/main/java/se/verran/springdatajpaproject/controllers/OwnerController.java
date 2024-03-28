package se.verran.springdatajpaproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.verran.springdatajpaproject.entities.Owner;
import se.verran.springdatajpaproject.services.OwnerService;

import java.util.List;

@RestController
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping("/allowners")
    public List<Owner> getAllOwners(){
        return ownerService.getAllOwners();
    }
}
