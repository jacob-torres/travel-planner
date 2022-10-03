import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { TripService } from '../service/trip.service';
import { Trip } from '../trip/trip.component';

@Component({
  selector: 'app-trip-list',
  templateUrl: './trip-list.component.html',
  styleUrls: ['./trip-list.component.css']
})
export class TripListComponent implements OnInit {

  trips: Trip[];
  username: string;
  message: string;

  constructor(
    private service: TripService,
    private router: Router
  ) { }

  ngOnInit(): void {
    // Username hard-coded until auth service is complete
    this.username = 'jaketorres';
    this.refreshTripList();
  }

  refreshTripList() {
    this.service.getTrips(this.username).subscribe(
      response => {
        this.trips = response;
      }
    );
  }

  addTrip() {
    this.router.navigate(['trips', -1]);
  }

  viewTrip(id: number) {
    this.router.navigate(['trips', id]);
  }

  updateTrip(id: number) {
    this.router.navigate(
      ['trips', id],
      { queryParams: { 'edit': true }}
    );
  }

  deleteTrip(id: number) {
    this.service.deleteTrip(id, this.username).subscribe(
      response => {
        this.message = `Trip ${id} has been deleted.`;
        this.refreshTripList();
      }
    );
  }

}
