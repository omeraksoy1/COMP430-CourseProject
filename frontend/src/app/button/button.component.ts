import { Component, OnInit, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';

@Component({
  selector: 'app-button',
  template: `<app-query [childMessage]="parentMessage"></app-query>`,
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.css']
})
export class ButtonComponent implements OnInit {
  private url: string;
  public result:any;
  parentMessage = ""
  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/api/db1/average-age';
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

      db1()
      {
          this.parentMessage="Database1";
      }
      db2()
      {
          this.parentMessage="Database2";
      }
      db3()
      {
          this.parentMessage="Database3";
      }


  ngOnInit(): void {
  }

}
