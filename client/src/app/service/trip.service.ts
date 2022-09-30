import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { API_URL } from '../app.constants';
import { Trip } from '../trip/trip.component';

@Injectable({
  providedIn: 'root'
})
export class TripService {

  constructor(private http: HttpClient) { }

  getTrips(username: string) {
    return this.http.get<Trip[]>(
      `${API_URL}/users/${username}/trips`
    );
  }

  getTrip(id: number, username: string) {
    return this.http.get<Trip>(
      `${API_URL}/users/${username}/trips/${id}`
    );
  }

  deleteTrip(id: number, username: string) {
    return this.http.delete<Trip>(
      `${API_URL}/users/{username}/trips/{id}`
    );
  }

  updateTrip(id: number, username: string, trip: Trip) {
    return this.http.put(
      `${API_URL}/users/${username}/trips/${id}`, trip
    );
  }

  createTrip(username: string, trip: Trip) {
    return this.http.post(
      `${API_URL}/users/${username}/trips`, trip
    );
  }

}
