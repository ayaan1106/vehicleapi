package com.RestEndPoints11.VehicleREP;
import org.springframework.data.jpa.repository.JpaRepository;
public interface VehicleRepository extends JpaRepository<Vehicle,Long>{
}

/*
imports jpa repository that helps in performing crud operations
basic database operations
extends vehicle --> jpa repository is handling the class vehicle
Spring Data JPA provides actual implementation
used to interact with a database for managing vehicle-related-data
 */