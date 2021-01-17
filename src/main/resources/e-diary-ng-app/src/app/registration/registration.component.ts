import {Component, OnInit} from '@angular/core';

import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  model: User = {
    email: '',
    firstName: '',
    lastName: '',
    login: '',
    password: '',
  };

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
  }

  addUser(): void {
    let url = "http://localhost:8080/api/addUser";
    this.http.post(url, this.model).subscribe(
      res => {
        // @ts-ignore
        location.reload();
      },
      err => {
        // @ts-ignore
        alert("Błąd w rejestracji użytkownika")
      }
    )
  }
}

export interface User {
  email: string;
  firstName: string;
  lastName: string;
  login: string;
  password: string;
}
