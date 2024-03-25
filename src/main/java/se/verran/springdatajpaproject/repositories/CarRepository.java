package se.verran.springdatajpaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.verran.springdatajpaproject.entities.Car;
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    Car findCarByModelIsContainingAndPlateNo(String var1, String var2);
}
