package com.app.tripmanager.model;

import java.time.LocalDate;

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
    private LocalDate startDate;
    private LocalDate endDate;
    private String startingPlace;
    private String destination;

    /********************************************************************************/
    // Constructors

    protected Trip() {
        this.tripId = 0L;
    }

    public Trip(Long tripId, String tripUsername, String tripName,
            LocalDate startDate, LocalDate endDate, String startingPlace, String destination) {
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

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
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
     * Calculates a unique hash code for identifying the trip.
     * 
     * @return hash
     */
    @Override
    public int hashCode() {
        final int prime = 29;
        int hash = 7;

        hash = prime * hash + (int) (tripId ^ (tripId >>> 32));
        hash = prime * hash + (tripUsername == null ? 0 : tripUsername.hashCode());
        hash = prime * hash + (tripName == null ? 0 : tripName.hashCode());
        return hash;
    }

    /*
     * Evaluates whether or not the trip object
     * is equal to another trip object using the ID.
     * 
     * @param object
     * @return boolean
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;

        Trip otherTrip = (Trip) object;
        return tripId == otherTrip.tripId;
    }

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
