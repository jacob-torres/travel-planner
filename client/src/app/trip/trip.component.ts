import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { TripService } from '../service/trip.service';

export class Trip {

  constructor(
    public tripId: number,
    public tripUsername: string,
    public tripName: string,
    public startDate: Date,
    public endDate: Date,
    public startingPlace: string,
    public destination: string
  ) {}

}

@Component({
  selector: 'app-trip',
  templateUrl: './trip.component.html',
  styleUrls: ['./trip.component.css']
})
export class TripComponent implements OnInit {

  id: number;
  username: string;
  trip: Trip;
  isEditing: boolean;

  constructor(
    private service: TripService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.username = this.route.snapshot.params['username'];
    this.isEditing = this.route.snapshot.queryParamMap.has('edit');

    this.trip = new Trip(
      this.id, this.username, '',
      new Date(), new Date(),
      '', '');

    if (this.id != -1) {
      this.service.getTrip(this.id, this.username).subscribe(
        data => {
          this.trip = data;
        }
      );
    }
  }

  toggleEditing() {
    this.isEditing = !this.isEditing;
  }

  goBackToTripList() {
    this.router.navigate(['trips']);
  }

  deleteTrip() {
    this.service.deleteTrip(this.id, this.username).subscribe(
      response => {
        this.goBackToTripList();
      }
    );
  }

  saveTrip() {
    if (this.id == -1) {
      this.service.createTrip(this.username, this.trip).subscribe(
        response => {
          this.goBackToTripList();
        }
      );
    }
    else {
      this.service.updateTrip(this.id, this.username, this.trip).subscribe(
        response => {
          this.goBackToTripList();
        }
      );
    }
  }

}
