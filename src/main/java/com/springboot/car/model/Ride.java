package com.springboot.car.model;

public class Ride {
	private String username;
    private Driver driver;
    private Location source;
    private Location destination;
    private double distance;
	public Ride(String username, Driver driver, Location source, Location destination, double distance) {
		super();
		this.username = username;
		this.driver = driver;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
	}
//	private double calculateDistance(Location source, Location destination) {
//        // Euclidean distance between two points in 2D space
//        double dx = source.getX() - destination.getX();
//        double dy = source.getY() - destination.getY();
//        return Math.sqrt(dx * dx + dy * dy);
//    }
	public String getUsername() {
        return username;
    }

    public Driver getDriver() {
        return driver;
    }

    public Location getSource() {
        return source;
    }

    public Location getDestination() {
        return destination;
    }

    public double getDistance() {
        return distance;
    }
}
