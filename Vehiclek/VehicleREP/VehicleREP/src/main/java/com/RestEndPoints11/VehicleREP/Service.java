package com.RestEndPoints11.VehicleREP;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import java.util.Optional;

@org.springframework.stereotype.Service

public class Service {
    @Autowired // injects the instance of main repository to vehicleRepo
    private VehicleRepository vehicleRepository;

    public Vehicle saveVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }
    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }
    public Optional<Vehicle> getVehicleById(Long id){
        return vehicleRepository.findById(id);
    }
    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
        if (vehicleRepository.existsById(id)) {
            updatedVehicle.setId(id);
            return vehicleRepository.save(updatedVehicle);
        }
        return null;
    }
        public void deleteVehicle(Long id){
            vehicleRepository.deleteById(id);
        }
    }

/*
1.declare service
2.import list optional  for methods
3.autowire main repository to the file
4.create methods for save getall optional update delete

 */