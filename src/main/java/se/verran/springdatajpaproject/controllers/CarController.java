package se.verran.springdatajpaproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.verran.springdatajpaproject.entities.Car;
import se.verran.springdatajpaproject.services.CarService;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/addcar") // TODO create custom exception
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        return new ResponseEntity<>(carService.addNewCar(car), HttpStatus.CREATED);
    }

    @GetMapping("/allcars")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping("/getcarbyid/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable int id){
        return ResponseEntity.ok(carService.getCarById(id));
    }
    @DeleteMapping("/deletecar/{id}")
    public ResponseEntity<String> deleteCarById(@PathVariable("id") int id){
        carService.deleteCarById(id);
        return new ResponseEntity<>("Car deleted!", HttpStatus.OK);
    }

    @PutMapping("/updatecar/{id}")
    public ResponseEntity<Car> updateCarById(@PathVariable("id") int id, @RequestBody Car car){
        return ResponseEntity.ok(carService.updateCar(id, car));
    }
}
