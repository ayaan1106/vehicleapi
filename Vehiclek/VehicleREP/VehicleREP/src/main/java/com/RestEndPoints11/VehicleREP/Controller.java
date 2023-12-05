package com.RestEndPoints11.VehicleREP;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    private final Producer kafkaProducer;
    private final Service vehicleService;

    public Controller(Producer kafkaProducer, Service vehicleService) {
        this.kafkaProducer = kafkaProducer;
        this.vehicleService = vehicleService;
    }

    @PostMapping("/kafka/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }

    @PostMapping("/vehicles")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Optional<Vehicle> vehicle = vehicleService.getVehicleById(id);
        return vehicle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle updatedVehicleDetails) {
        Optional<Vehicle> optionalVehicle = vehicleService.getVehicleById(id);

        if (optionalVehicle.isPresent()) {
            Vehicle existingVehicle = optionalVehicle.get();
            existingVehicle.setId(updatedVehicleDetails.getId());
            existingVehicle.setModel(updatedVehicleDetails.getModel());
            existingVehicle.setMake(updatedVehicleDetails.getMake());
            existingVehicle.setColor(updatedVehicleDetails.getColor());
            existingVehicle.setYear(updatedVehicleDetails.getYear());

            Vehicle updatedVehicle = vehicleService.saveVehicle(existingVehicle);
            return ResponseEntity.ok(updatedVehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

