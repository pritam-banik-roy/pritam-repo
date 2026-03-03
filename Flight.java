package com.flightreservation.model;

public class Flight {

    private int id;
    private String flightNumber;
    private String source;
    private String destination;
    private String departureTime;
    private double price;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public String getDepartureTime() { return departureTime; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
