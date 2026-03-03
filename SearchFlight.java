package com.flightreservation.model;

import javax.validation.constraints.NotEmpty;

public class SearchFlight {

    @NotEmpty(message = "Source city is required")
    private String source;

    @NotEmpty(message = "Destination city is required")
    private String destination;

    // getters and setters

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
