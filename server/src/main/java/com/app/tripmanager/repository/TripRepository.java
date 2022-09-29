package com.app.tripmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.tripmanager.model.Trip;

/*
 * This interface defines a JPA repository of trip objects.
 * 
 * @author Jake Torres
 */
@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    /*
     * Get all trips belonging to the given username.
     * 
     * @param username
     * @return trips
     */
    List<Trip> getTripsByUsername(String username);

}
