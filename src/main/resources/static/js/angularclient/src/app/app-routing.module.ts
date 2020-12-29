import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {RegistrationComponent} from "./component/registration/registration.component";

const routes: Routes = [
  {path: "", redirectTo: "app.component.html", pathMatch: "full"},
  {path: "addUser", component: RegistrationComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
