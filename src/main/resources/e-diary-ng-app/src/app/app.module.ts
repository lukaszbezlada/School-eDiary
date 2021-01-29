import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {NavigationComponent} from './navigation/navigation.component';
import {RegistrationComponent} from './registration/registration.component';
import {LoginComponent} from './login/login.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {Router, Routes, RouterModule} from '@angular/router';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {UsersComponent} from './users/users.component';
import { ValidateEqualModule } from 'ng-validate-equal';

const routes: Routes = [
  {
    path: 'registration',
    component: RegistrationComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: '**',
    component: NotFoundComponent
  },
  {
    path: '',
    component: LoginComponent,
    pathMatch: 'full'
  }
]

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    RegistrationComponent,
    LoginComponent,
    NotFoundComponent,
    UsersComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes, {enableTracing: true}),
    ValidateEqualModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
