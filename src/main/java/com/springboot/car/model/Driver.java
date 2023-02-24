package com.springboot.car.model;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	private String name;
    private String vehicleNumber;
    private String vehicleType;
    private Location currentLocation;
    private List<Ride> rides;
	public Driver(String name, String vehicleNumber, String vehicleType, Location currentLocation) {
		super();
		this.name = name;
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
		this.currentLocation = currentLocation;
		this.rides=new ArrayList<>();
	}
	public void addRide(Ride ride) {
        rides.add(ride);
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Location getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}
    

}
