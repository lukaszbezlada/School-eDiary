import {Component, OnInit} from '@angular/core';
import {User} from "../registration/registration.component";
import {UserService} from "../service/user.service";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users: User[] = [];

  constructor(private userService: UserService) {
  }

  ngOnInit() {

  }

  public getAllUsers() {
    let resp = this.userService.getAllUsers().subscribe(
      (data) => this.users = data,
      err => {
        alert("Błąd w pobieraniu listy użytkowników")
      }
    );
  }

}
