import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import {CdkTextareaAutosize} from '@angular/cdk/text-field';
import { HttpClient } from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import { MatSelect } from '@angular/material/select';
import {MatSliderModule} from '@angular/material/slider';



@Component({
  selector: 'app-query',
  template: `
        Say {{ message }}
    `,
  templateUrl: './query.component.html',
  styleUrls: ['./query.component.css']
})
export class QueryComponent implements OnInit {
  @ViewChild('database1') d1 : any;
  @ViewChild('database2') d2 : any;
  @ViewChild('database3') d3 : any;
  @ViewChild('selectedDB1') mySelect: any;
  selected = '';
  private url: string;
  public result:any;
  public budget: any;
  @Input() childMessage = '';
  autoTicks = true;
    disabled = false;
    invert = false;
    max = 15;
    min = 0;
    showTicks = true;
    step = 1;
    thumbLabel = true;
    value = 5;
    vertical = false;
    tickInterval = 1;
  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/api/db1/average-age';
    this.budget = 15;
  }

  getSliderTickInterval(): number | 'auto' {
        if (this.showTicks) {
          return this.autoTicks ? 'auto' : this.tickInterval;
        }

        return 0;
      }

  ngOnChanges(): void {
       if(this.childMessage=="Database1")
       {
           this.d1.nativeElement.style.display="block";
           this.d2.nativeElement.style.display="none";
           this.d3.nativeElement.style.display="none";
       }
       if(this.childMessage=="Database2")
       {
           this.d1.nativeElement.style.display="none";
           this.d2.nativeElement.style.display="block";
           this.d3.nativeElement.style.display="none";
       }
       if(this.childMessage=="Database3")
       {
           this.d1.nativeElement.style.display="none";
           this.d2.nativeElement.style.display="none";
           this.d3.nativeElement.style.display="block";
       }
  }


  ngOnInit(): void {
  }

  getAll() {
            /*this.http.get(this.url).subscribe((results) => {
              console.log('Data is received - Result - ', results);
              this.result = results;
            })*/
            /*this.http.post<any>(this.url, 1).subscribe(data => {
                       this.result = data;
            })*/
            this.result = "";
            if(this.budget < 0 || this.budget - this.value <0)
            {
                    this.result = "Not enough budget!";
            }
            else
            {
            this.budget -= this.value;
            if(this.selected == "1")
            {
                this.http.post<any>("http://localhost:8080/api/db1/average-age", this.value).subscribe(data => {
                                     this.result = data;
                })
            }
            else if(this.selected == "2")
            {
                this.http.post<any>("http://localhost:8080/api/db1/num-records-by-sex", this.value, { observe: 'response' })
                        .subscribe(response => {
                              this.result = JSON.stringify(response.body);
                                               })
            }
            else if(this.selected == "3")
            {
                this.http.post<any>("http://localhost:8080/api/db1/chest-pain-type-by-hd-positive", this.value, { observe: 'response' })
               .subscribe(response => {this.result = JSON.stringify(response.body);
                })
            }
            else if(this.selected == "4")
            {
                this.http.post<any>("http://localhost:8080/api/db1/age-groups-by-hd-positive",this.value, { observe: 'response' })
                       .subscribe(response => {this.result = JSON.stringify(response.body);
                    })

            }
            else if(this.selected == "5")
            {
                this.http.post<any>("http://localhost:8080/api/db1/bp-groups-by-hd-positive", this.value, { observe: 'response' })
                                                                                                             .subscribe(response => {this.result = JSON.stringify(response.body);
                                                                                                              })
            }
            else if(this.selected == "6")
            {
                this.http.post<any>("http://localhost:8080/api/db1/st-slope-groups-by-hd-positive", this.value, { observe: 'response' })
                                                                                                                   .subscribe(response => {this.result = JSON.stringify(response.body);
                                                                                                                    })
            }
            else if(this.selected == "7")
            {
                this.http.post<any>("http://localhost:8080/api/db1/cholesterol-groups-by-hd-positive", this.value, { observe: 'response' })
                                                                                                                      .subscribe(response => {this.result = JSON.stringify(response.body);
                                                                                                                       })
            }
            else if(this.selected == "8")
            {
                this.http.post<any>("http://localhost:8080/api/db1/resting-ecg-groups-by-hd-positive", this.value, { observe: 'response' })
                                                                                                                      .subscribe(response => {this.result = JSON.stringify(response.body);
                                                                                                                       })
            }
            else if(this.selected == "9")
            {
                this.http.post<any>("http://localhost:8080/api/db1//max-hr-groups-by-hd-positive", this.value, { observe: 'response' })
                                                                                                                                                                                                                         .subscribe(response => {this.result = JSON.stringify(response.body);
                                                                                                                                                                                                                          })
            }
            else if(this.selected == "10")
            {
                this.http.post<any>("http://localhost:8080/api/db1/exercise-angina-groups-by-hd-positive", this.value, { observe: 'response' })
                                                                                                                          .subscribe(response => {this.result = JSON.stringify(response.body);
                                                                                                                           })
            }
            else if(this.selected == "11")
            {
                console.log(this.selected);
                this.http.post<any>("http://localhost:8080/api/db2/average-age", this.value, { observe: 'response' })
                                                                                                .subscribe(response => {this.result = JSON.stringify(response.body);
                                                                                                 })
            }
            else if(this.selected == "12")
            {
                this.http.post<any>("http://localhost:8080/api/db2/num-records-by-sex", this.value, { observe: 'response' })
                                                                                                       .subscribe(response => {this.result = JSON.stringify(response.body);
                                                                                                        })
            }
            else if(this.selected == "13")
            {
                this.http.post<any>("http://localhost:8080/api/db2/education-groups-by-hd-positive", this.value, { observe: 'response' })
                                                                                                                    .subscribe(response => {this.result = JSON.stringify(response.body);
                                                                                                                     })
            }
            else if(this.selected == "14")
            {
                this.http.post<any>("http://localhost:8080/api/db2/current-smoker-by-hd-positive", this.value, { observe: 'response' })
                                                                                                                  .subscribe(response => {this.result = JSON.stringify(response.body);
                                                                                                                   })
            }

  }

  }


}
