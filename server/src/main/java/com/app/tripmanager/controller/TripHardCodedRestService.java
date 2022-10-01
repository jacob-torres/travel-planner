package com.app.tripmanager.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.tripmanager.model.Trip;

@Service
public class TripHardCodedRestService {

    private static List<Trip> trips = new ArrayList<>();
    private static long idCounter = 0;

    // Static hard-coded list of trips
        static {
            trips.add(
                new Trip(
                    ++idCounter, "jaketorres", "Trip 1",
                    LocalDate.parse("2022-12-29"),
                    LocalDate.parse("2023-01-30"),
                    "Denver", "Berlin"
                )
            );
    
            trips.add(
                new Trip(
                    ++idCounter, "jaketorres", "Trip 2",
                    LocalDate.parse("2023-01-30"),
                    LocalDate.parse("2023-02-25"),
                    "Berlin", "Tokyo"
                )
            );
    
            trips.add(
                new Trip(
                    ++idCounter, "jaketorres", "Trip 3",
                    LocalDate.parse("2023-02-25"),
                    LocalDate.parse("2023-03-12"),
                    "Tokyo", "Rome"
                )
            );
    
            trips.add(
                new Trip(
                    ++idCounter, "jaketorres", "Trip 4",
                    LocalDate.parse("2023-03-12"),
                    LocalDate.parse("2023-04-20"),
                    "Rome", "London"
                )
            );
        }    

    /********************************************************************************/
    // Methods

    public List<Trip> findAll() {
        return trips;
    }

    public Trip findById(long id) {
        for (Trip trip : trips) {
            if (id == trip.getTripId()) {
                return trip;
            }
        }

        return null;
    }
    
    public Trip deleteById(long id) {
        Trip trip = findById(id);

        if (trip == null) {
            return null;
        }

        if (trips.remove(trip)) {
            return trip;
        }

        return null;
    }

    public Trip save(Trip trip) {
        if (trip.getTripId() == -1 || trip.getTripId() == 0) {
            trip.setTripId(++idCounter);
            trips.add(trip);
        }
        else {
            deleteById(trip.getTripId());
            trips.add(trip);
        }

        return trip;
    }

}
