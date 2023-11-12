package com.Vehicledata.vehicledata.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Vehicledata.Vehicle;

@Repository
public class VehicleDao {
    private final JdbcTemplate jdbcTemplate;

    public VehicleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTable() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS vehicle (" +
                "id SERIAL PRIMARY KEY, " +
                "make VARCHAR(255) NOT NULL" +
                ")";

        jdbcTemplate.execute(createTableQuery);
    }

    public void insertData(int id ,String make ) 
    {
    	String q ="insert into vehicle (id,make) values(?,?)";
    	int update =  this.jdbcTemplate.update(q,id,make);
        System.out.println(update + "rows added");
    }

	public void insertVehicle(Long id, String make) {
		
	}

	}
