package com.modfinal.modfinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
class VehicleController {

    @Autowired
    private Service vehicleService;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public VehicleController(KafkaTemplate<String, String> kafkaTemplate, Service vehicleService) {
        this.kafkaTemplate = kafkaTemplate;
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        // Save vehicle details to the database
        Vehicle savedVehicle = vehicleService.saveVehicle(vehicle);

        // Publish the vehicle details to Kafka topic
        String message = "New Vehicle ID: " + savedVehicle.getId() + ", Make: " + savedVehicle.getMake() + ", Model: " + savedVehicle.getModel()+"Color : " + savedVehicle.getColor();
        kafkaTemplate.send("t1", message);

        return savedVehicle;
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Optional<Vehicle> vehicle = vehicleService.getVehicleById(id);
        return vehicle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle updatedVehicleDetails) {
        Optional<Vehicle> optionalVehicle = vehicleService.getVehicleById(id);

        if (optionalVehicle.isPresent()) {
            Vehicle existingVehicle = optionalVehicle.get();

            // Update the existing vehicle with the new details
            existingVehicle.setId(updatedVehicleDetails.getId());
            existingVehicle.setModel(updatedVehicleDetails.getModel());
            existingVehicle.setMake(updatedVehicleDetails.getMake());
            existingVehicle.setColor(updatedVehicleDetails.getColor());
            existingVehicle.setYear(updatedVehicleDetails.getYear());

            // Save the updated vehicle back to the service/repository
            Vehicle updatedVehicle = vehicleService.saveVehicle(existingVehicle);

            return ResponseEntity.ok(updatedVehicle); // Return the updated vehicle
        } else {
            return ResponseEntity.notFound().build(); // Vehicle with given ID not found
        }
    }
}
