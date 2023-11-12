package service;

import org.springframework.stereotype.Service;
import com.Vehicledata.vehicledata.dao.VehicleDao;

@Service
public class VehicleService {
    private final VehicleDao vehicleDao;

    public VehicleService(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    public void createTableAndInsertData() {
        vehicleDao.createTable(); // Create the table if it doesn't exist

        // Insert an entry with a specific ID and make
        Long id = 6L; // Replace with your desired ID
        String make = "suzuki"; // Replace with the make
        vehicleDao.insertVehicle(id, make);
    }
}
