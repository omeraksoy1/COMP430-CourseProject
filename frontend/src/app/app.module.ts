import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ButtonComponent } from './button/button.component';
import {MatButtonModule } from '@angular/material/button';
import {MatSelectModule} from '@angular/material/select';
import { HeaderComponent } from './header/header.component';
import { QueryComponent } from './query/query.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {TextFieldModule} from '@angular/cdk/text-field';
import {MatSliderModule} from '@angular/material/slider';
import { LoginPageComponent } from './login-page/login-page.component';
import { AppRoutingModule } from './app-routing/app-routing.module'; // CLI imports
import { RouterModule } from '@angular/router';
import {MatInputModule} from '@angular/material/input';
import {MatIconModule} from '@angular/material/icon';
import { ChartsModule } from 'ng2-charts';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpConfigInterceptor } from './interceptor/httpconfig.interceptor';

const MaterialComponents= [MatButtonModule];
@NgModule({
  declarations: [
    AppComponent,
    ButtonComponent,
    HeaderComponent,
    QueryComponent,
    LoginPageComponent
  ],
  imports: [
    MatInputModule,
    FormsModule,
    MatIconModule,
    RouterModule,
    AppRoutingModule,
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialComponents,
    MatSelectModule,
    FormsModule,
    ReactiveFormsModule,
    TextFieldModule,
    MatSliderModule,
    ChartsModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: HttpConfigInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
