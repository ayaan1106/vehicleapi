package com.enpoints.vehicle_ep;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service

public class Service {
    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
        if (vehicleRepository.existsById(id)) {
            updatedVehicle.setId(id); // Ensuring the ID in the request body matches the path variable
            return vehicleRepository.save(updatedVehicle);
        }
        return null;     }

    
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
