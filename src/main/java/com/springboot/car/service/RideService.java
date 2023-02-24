package com.springboot.car.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.springboot.car.model.Ride;

@Service
public class RideService {
	private Map<String, List<Ride>> rides;

    public RideService() {
        this.rides = new HashMap<>();
    }
    public void addRide(String username, Ride ride) {
        List<Ride> userRides = rides.get(username);
        if (userRides == null) {
            userRides = new ArrayList<>();
            rides.put(username, userRides);
        }
        userRides.add(ride);
    }

    public List<Ride> getRides(String username) {
        return rides.get(username);
    }
}
