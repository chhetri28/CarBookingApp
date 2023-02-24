package com.springboot.car.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.springboot.car.model.Driver;
import com.springboot.car.model.Location;
import com.springboot.car.model.Ride;
import com.springboot.car.model.User;

@Service
public class DriverService {
	private Map<String, Driver> drivers = new HashMap<>();

    public void addDriver(Driver driver) {
        drivers.put(driver.getName(), driver);
    }
    
    public Driver getDriver(String name) {
        return drivers.get(name);
    }
    
    public List<Driver> getAllDrivers() {
        return new ArrayList<>(drivers.values());
    }

    
    public List<Driver> findNearestDrivers(Location location) {
        List<Driver> nearestDrivers = new ArrayList<>(drivers.values());
        Collections.sort(nearestDrivers, Comparator.comparingDouble(d -> distance(d.getCurrentLocation(), location)));
        return nearestDrivers;
    }

    private double distance(Location l1, Location l2) {
        double dx = l1.getX() - l2.getX();
        double dy = l1.getY() - l2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

	public void bookRide(String driverName, Ride chosenRide) {
		// TODO Auto-generated method stub
		
	}

  
    
}
