import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.css']
})
export class ButtonComponent implements OnInit {
  private url: string;
  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/api/average-age';
  }


      getAll() {
          this.http.get(this.url).subscribe((results) => {
            console.log('Data is received - Result - ', results);
          })
      }


  ngOnInit(): void {
  }

}
