package se.verran.springdatajpaproject.services;

import se.verran.springdatajpaproject.entities.Car;

import java.util.List;

public interface CarServiceInterface {
    List<Car> getAllCars();
    Car getCarById(int id);
    Car addNewCar(Car car);
    void deleteCarById(int id);
    Car updateCar(int id, Car car);
}
