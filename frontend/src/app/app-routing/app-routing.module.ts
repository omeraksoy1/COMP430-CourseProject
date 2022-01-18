import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from '../app.component';
import { HeaderComponent } from '../header/header.component';
import { LoginPageComponent } from '../login-page/login-page.component';
const routes: Routes = [
  { path: '', component: LoginPageComponent, pathMatch: 'full' },
  { path: 'login', component: LoginPageComponent},
  { path: 'admin', component: HeaderComponent}
];
@NgModule({
  imports: [
  RouterModule.forRoot(routes),
  ],
  exports: [
  RouterModule
  ],
  declarations: []
  })
export class AppRoutingModule { }
