import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ButtonComponent } from './button/button.component';
import { HttpClientModule } from '@angular/common/http';
import {MatButtonModule } from '@angular/material/button';
import {MatSelectModule} from '@angular/material/select';
import { HeaderComponent } from './header/header.component';
import { QueryComponent } from './query/query.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {TextFieldModule} from '@angular/cdk/text-field';
import {MatSliderModule} from '@angular/material/slider';
import { ChartsModule } from 'ng2-charts';



const MaterialComponents= [MatButtonModule];
@NgModule({
  declarations: [
    AppComponent,
    ButtonComponent,
    HeaderComponent,
    QueryComponent,

  ],
  imports: [
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
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
