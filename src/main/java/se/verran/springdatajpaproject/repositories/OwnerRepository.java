package se.verran.springdatajpaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.verran.springdatajpaproject.entities.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {

}
