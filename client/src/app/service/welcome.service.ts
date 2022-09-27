import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

export class WelcomeBean {
  constructor (public message: string) {}
}

@Injectable({
  providedIn: 'root'
})
export class WelcomeService {

  constructor(private http: HttpClient) { }

  executeWelcomeBeanService(name: string) {
    return this.http.get<WelcomeBean>(
      `http://localhost:8080/welcomebean/${name}`
    );
  }
}
