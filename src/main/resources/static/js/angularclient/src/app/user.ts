export class User {
  constructor(id: number, login: string, password: string, password2: string, firstName: string, lastName: string, email: string, roles: string) {
    this.id = id;
    this.login = login;
    this.password = password;
    this.password2 = password2;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.roles = roles;
  }

  id: number;
  login: string;
  password: string;
  password2: string;
  firstName: string;
  lastName: string;
  email: string;
  roles: string
}

