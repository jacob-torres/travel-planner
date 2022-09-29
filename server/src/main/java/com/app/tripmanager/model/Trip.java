package com.app.tripmanager.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * This class defines a single planned trip.
 * 
 * @author Jake Torres
 */

@Entity
public class Trip {
    
    @Id
    @GeneratedValue
    private Long tripId;
    private String tripUsername;
    private String tripName;
    private Date startDate;
    private Date endDate;
    private String startingPlace;
    private String destination;

    /********************************************************************************/
    // Constructors

    protected Trip() {
        this.tripId = 0L;
    }

    public Trip(Long tripId, String tripUsername, String tripName,
            Date startDate, Date endDate, String startingPlace, String destination) {
        super();
        this.tripId = tripId;
        this.tripUsername = tripUsername;
        this.tripName = tripName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startingPlace = startingPlace;
        this.destination = destination;
            }

    /********************************************************************************/
    // Getters and setters

    public long getTripId() {
        return this.tripId;
    }

    public void setTripId(long tripId) {
        this.tripId = tripId;
    }

    public String getTripUsername() {
        return this.tripUsername;
    }

    public void setTripUsername(String tripUsername) {
        this.tripUsername = tripUsername;
    }

    public String getTripName() {
        return this.tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStartingPlace() {
        return this.startingPlace;
    }

    public void setStartingPlace(String startingPlace) {
        this.startingPlace = startingPlace;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    /********************************************************************************/
    // Methods

    /*
     * Formats the trip into a string.
     * 
     * @return String
     */
     @Override
    public String toString() {
        return "{" +
            " tripId='" + getTripId() + "'" +
            ", tripUsername='" + getTripUsername() + "'" +
            ", tripName='" + getTripName() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", startingPlace='" + getStartingPlace() + "'" +
            ", destination='" + getDestination() + "'" +
            "}";
    }

}
