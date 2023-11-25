package com.modfinal.modfinal;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Stores instance as a row in database

public class Vehicle {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String make;
    private String model;
    private int year;
    private String color;

    // Getters and Setters :
// Used to Retrieve values of the private fields.
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    //  No Argument Constructor :
// gives Starting point to the object
    public Vehicle() {
    }

    // Constructors :
    // helps in intializing the object
    public Vehicle(long id, String make, String model, int year, String color) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }
}
/*
1. Declare class as entity
2.import id inside the class for id variable to store it as a primary key
3. @Genrate id for generating unique id value
4. Declare variables
5. Create getters and setters and constructors

 */