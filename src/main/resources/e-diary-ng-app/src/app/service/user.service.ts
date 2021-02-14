import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserDTO} from "../registration/registration.component";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private BASE_URL = "http://localhost:4200/api";
  private ALL_USER_URL = "http://localhost:4200/api/users";
  private ADD_USER_URL = "http://localhost:8080/api/addUser";

  constructor(private http: HttpClient) {
  }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.ALL_USER_URL);
  }

  addUser(userDTO: UserDTO): Observable<any> {
    return this.http.post(this.ADD_USER_URL, userDTO, {responseType:'text' as 'json'})
  }
}

export interface User {
  email: string;
  firstName: string;
  lastName: string;
  login: string;
  password: string;
  password2: string;
}
