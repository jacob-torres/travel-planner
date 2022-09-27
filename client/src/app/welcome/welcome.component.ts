import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { WelcomeService } from '../service/welcome.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  message: string = '';
  name: string = '';
  welcomeMessageFromService: boolean = false;

  constructor(
    private rout: ActivatedRoute,
    private service: WelcomeService
  ) { }

  ngOnInit(): void {
    // this.name = this.rout.snapshot.params['name'];
  }

  getWelcomeMessage() {
    this.service.executeWelcomeBeanService(this.name).subscribe(
      response => this.handleSuccessfulResponse(response),
      error => this.handleErrorResponse(error)
    );
  }

  handleSuccessfulResponse(response: any) {
    this.message = response.message;
    this.welcomeMessageFromService = true;
  }

  handleErrorResponse(error: any) {
    this.message = error.error.message;
    this.welcomeMessageFromService = false;
  }

}
