package se.verran.springdatajpaproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.verran.springdatajpaproject.entities.Car;
import se.verran.springdatajpaproject.entities.Owner;
import se.verran.springdatajpaproject.exceptions.ResourceNotFoundException;
import se.verran.springdatajpaproject.repositories.CarRepository;
import se.verran.springdatajpaproject.repositories.OwnerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements CarServiceInterface{

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(int id) {
        if(carRepository.existsById(id)){
            Optional<Car> existingCar = carRepository.findById(id);
            if(existingCar.isPresent()){
                return existingCar.get();
            }
        }
        throw new ResourceNotFoundException("Car", "id", id);
    }

    @Override
    public Car addNewCar(Car car) {
        Owner owner = car.getOwner();
        if(owner != null){
            if(owner.getId() == 0){
                ownerRepository.save(owner);
            } else {
                Optional<Owner> existingOwner = ownerRepository.findById(owner.getId());
                if(!existingOwner.isPresent()){
                    throw new ResourceNotFoundException("Owner", "id", owner.getId());
                }
            }
        }
        return carRepository.save(car);
    }

    @Override
    public void deleteCarById(int id) {
        carRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Car", "id", id));
        carRepository.deleteById(id);
/*        Optional<Car> existingCar = carRepository.findById(id);
        if(existingCar.isPresent()){
            carRepository.deleteById(id);
            return;
        }
        throw new ResourceNotFoundException("Car", "id", id);*/
    }

    @Override
    public Car updateCar(int id, Car car) {
        Car existingCar = carRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Car", "id", id));
/*        existingCar.setBrand(car.getBrand());
        existingCar.setModel(car.getModel());
        existingCar.setPlateNo(car.getPlateNo());*/
        return carRepository.save(car);
        // save är en hybrid från Hibernates .merge() och .save()
    }


}
