package com.springboot.car.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.car.model.Driver;
import com.springboot.car.model.Location;
import com.springboot.car.model.Ride;
import com.springboot.car.model.User;
import com.springboot.car.service.DriverService;
import com.springboot.car.service.RideService;
import com.springboot.car.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private RideService rideService;
	
	@PostMapping("/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
	@GetMapping("/users/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }
	@GetMapping("/users")
	public List<User> getAllUsers() {
	    return userService.getAllUsers();
	}

	@PostMapping("/drivers")
	public void addDriver(@RequestBody Driver driver) {
	    driverService.addDriver(driver);
	}
	
	@GetMapping("/drivers")
	public List<Driver> getAllDrivers() {
	    return driverService.getAllDrivers();
	}
	@GetMapping("/rides")
	public List<Ride> findRides(@RequestParam String username, @RequestParam double sourceX,
            @RequestParam double sourceY, @RequestParam double destX, @RequestParam double destY){
		Location source=new Location(sourceX,sourceY);
		Location destination=new Location(destX, destY);
		List<Driver> nearestDrivers = driverService.findNearestDrivers(source);
		List<Ride> rides = new ArrayList<>();
        for (Driver driver : nearestDrivers) {
            Ride ride = new Ride(username, driver, source, destination, destY);
            rides.add(ride);
        }
        return rides;
	}
	   @PostMapping("/rides")
	    public void chooseRide(@RequestParam String username, @RequestParam String driverName) {
	        Driver driver = driverService.getDriver(driverName);
	        if (driver == null) {
	            throw new IllegalArgumentException("Driver not found: " + driverName);
	        }
	        List<Ride> userRides = rideService.getRides(username);
	        if (userRides == null) {
	            throw new IllegalArgumentException("User not found: " + username);
	        }
	        Ride chosenRide = null;
	        for (Ride ride : userRides) {
	            if (ride.getDriver().getName().equals(driverName)) {
	                chosenRide = ride;
	                break;
	            }
	        }
	        if (chosenRide == null) {
	            throw new IllegalArgumentException("Ride not found for user: " + username + ", driver: " + driverName);
	        }
	        userRides.remove(chosenRide);
	        driverService.bookRide(driverName, chosenRide);
	    }
}
