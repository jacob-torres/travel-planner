package com.app.tripmanager.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.tripmanager.model.Trip;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TripController {

    @Autowired
    private TripHardCodedRestService tripService;

    @GetMapping("/users/{username}/trips")
    public List<Trip> getTrips(@PathVariable String username) {
        return tripService.findAll();
    }

    @GetMapping("/users/{username}/trips/{id}")
    public Trip getTrip(@PathVariable long id, @PathVariable String username) {
        return tripService.findById(id);
    }

    @DeleteMapping("/users/{username}/trips/{id}")
    public ResponseEntity<Void> deleteTrip(
            @PathVariable long id,
            @PathVariable String username) {
        Trip trip = this.tripService.deleteById(id);

        if (trip != null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/users/{username}/trips/{id}")
    public ResponseEntity<Trip> updateTrip(
            @PathVariable long id,
            @PathVariable String username,
            @RequestBody Trip trip) {
        Trip updatedTrip = this.tripService.save(trip);
        return new ResponseEntity<Trip>(updatedTrip, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/trips")
    public ResponseEntity<Void> createTrip(
            @PathVariable String username,
            @RequestBody Trip trip) {
        Trip createdTrip = tripService.save(trip);

        // Get new trip location
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTrip.getTripId())
                .toUri();

                return ResponseEntity.created(uri).build();
    }

}
