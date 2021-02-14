import {Component, OnInit} from '@angular/core';

import {UserService} from "../service/user.service";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  model: UserDTO = {
    email: '',
    firstName: '',
    lastName: '',
    login: '',
    password: '',
    password2: '',
    subject: '',
  };

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
  }

  addUser(): void {
    let resp = this.userService.addUser(this.model).subscribe(
    resp => {
      location.reload();
    },
      err => {
        alert("Błąd w rejestracji użytkownika")
      }
  )
  }
}

export interface UserDTO {
  email: string;
  firstName: string;
  lastName: string;
  login: string;
  password: string;
  password2: string;
  subject: any;
  // parent: string;
  // grades: number;
  // classType: any;
  // childs: any;
}
