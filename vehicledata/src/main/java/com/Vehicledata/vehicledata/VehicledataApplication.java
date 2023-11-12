package com.Vehicledata.vehicledata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.Vehicledata.vehicledata.dao.VehicleDao;

@SpringBootApplication
public class VehicledataApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicledataApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(VehicleDao vehicleDao) {
        return args -> {
            vehicleDao.createTable(); 

            vehicleDao.insertData(5, "baleno"); 
        };
    }
}
