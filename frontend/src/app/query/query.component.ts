import { Component, OnInit } from '@angular/core';
import {CdkTextareaAutosize} from '@angular/cdk/text-field';
import { HttpClient } from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
@Component({
  selector: 'app-query',
  templateUrl: './query.component.html',
  styleUrls: ['./query.component.css']
})
export class QueryComponent implements OnInit {
  private url: string;
  public result:any;

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/api/db1/average-age';
  }

  ngOnInit(): void {
  }

  getAll() {
            /*this.http.get(this.url).subscribe((results) => {
              console.log('Data is received - Result - ', results);
              this.result = results;
            })*/
            this.http.post<any>(this.url, 1).subscribe(data => {
                       this.result = data;
            })
        }

}
