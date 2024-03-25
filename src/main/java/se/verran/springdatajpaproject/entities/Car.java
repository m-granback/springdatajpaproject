package se.verran.springdatajpaproject.entities;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30, nullable = false)
    private String brand;
    private String model;
    private String plateNo;

    public Car() {
    }

    public Car(String brand, String model, String plateNo) {
        this.brand = brand;
        this.model = model;
        this.plateNo = plateNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }
}
