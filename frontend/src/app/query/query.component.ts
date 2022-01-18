import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import {CdkTextareaAutosize} from '@angular/cdk/text-field';
import { HttpClient } from '@angular/common/http';
import {HttpClientModule} from '@angular/common/http';
import { MatSelect } from '@angular/material/select';
import {MatSliderModule} from '@angular/material/slider';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label } from 'ng2-charts';





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
  @ViewChild('chart') ch : any;
  selected = '';
  private url: string;
  barChartOptions: ChartOptions = {
      responsive: true,
    };
  barChartLegend = true;
  barChartPlugins = [];
  barChartLabels: Label[] = ['Eating', 'Drinking', 'Sleeping', 'Designing', 'Coding', 'Cycling', 'Running'];
  barChartType: ChartType = 'bar';
  barChartData: ChartDataSets[] = [
                                      { data: [65, 59, 80, 81, 56, 55, 40], label: 'My First dataset' },
                                      { data: [28, 48, 40, 19, 86, 27, 90], label: 'My Second dataset' }
                                    ];

  /*public chartDatasets: Array<any> = [];
  public chartLabels: Array<any> = [];
  public chartColors: Array<any> = [
      {
        backgroundColor: [
          'rgba(255, 99, 132, 0.2)',
          'rgba(54, 162, 235, 0.2)',
          'rgba(255, 206, 86, 0.2)',
          'rgba(75, 192, 192, 0.2)',
          'rgba(153, 102, 255, 0.2)',
          'rgba(255, 159, 64, 0.2)'
        ],
        borderColor: [
          'rgba(255,99,132,1)',
          'rgba(54, 162, 235, 1)',
          'rgba(255, 206, 86, 1)',
          'rgba(75, 192, 192, 1)',
          'rgba(153, 102, 255, 1)',
          'rgba(255, 159, 64, 1)'
        ],
        borderWidth: 2,
      }
    ];

    public chartOptions: any = {
      responsive: true
    };
    public chartClicked(e: any): void { }
    public chartHovered(e: any): void { }*/


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
    this.http.get<any>("http://localhost:8080/api/budget/get").subscribe(data => {
      this.budget = data;
})

  }

  /*parseObject(obj: any)
  {
     for(var key in obj)
     {
        console.log("key: " + key + ", value: " + obj[key])
        if(obj[key] instanceof Object)
        {
          this.parseObject(obj[key]);
        }
     }
  }*/

  getAll() {
            /*this.http.get(this.url).subscribe((results) => {
              console.log('Data is received - Result - ', results);
              this.result = results;
            })*/
            /*this.http.post<any>(this.url, 1).subscribe(data => {
                       this.result = data;
            })*/
            this.result = "";
            if(this.budget <=0)
            {
                    this.result = "Not enough budget!";
            }
            else
            {

            this.http.get<any>("http://localhost:8080/api/budget/get").subscribe(data => {
                                   this.budget = data;
                                   this.ch.nativeElement.style.display="none";

              })
          
            if(this.selected == "1")
            {
                this.http.post<any>("http://localhost:8080/api/db1/average-age", this.value).subscribe(data => {
                                     this.result = data;
                                     this.ch.nativeElement.style.display="none";
                })
            }
            else if(this.selected == "2")
            {
                this.http.post<any>("http://localhost:8080/api/db1/num-records-by-sex", this.value, { observe: 'response' })
                        .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                 (obj : any, key : any) => {
                                                                                   obj[key] = response.body[key];
                                                                                   return obj;
                                                                                 },
                                                                                 {}
                                                                               );
                                                                               //this.result = JSON.stringify(ordered);
                                                                               var values = [];
                                                                               var labels = [];
                                                                               for(var i in ordered){
                                                                                   values.push(ordered[i]);
                                                                                   labels.push(i);
                                                                               }
                                                                               this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                               this.barChartLabels = labels;
                                                                               this.ch.nativeElement.style.display="block";




                                        })
            }
            else if(this.selected == "3")
            {
                this.http.post<any>("http://localhost:8080/api/db1/chest-pain-type-by-hd-positive", this.value, { observe: 'response' })
               .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                         (obj : any, key : any) => {
                                                           obj[key] = response.body[key];
                                                           return obj;
                                                         },
                                                         {}
                                                       );
                                                       //this.result = JSON.stringify(ordered);
                                                       var values = [];
                                                       var labels = [];
                                                       for(var i in ordered){
                                                           values.push(ordered[i]);
                                                           labels.push(i);
                                                       }
                                                       this.barChartData = [{ data : values, label: 'Histogram'}];
                                                       this.barChartLabels = labels;
                                                       this.ch.nativeElement.style.display="block";




                })
            }
            else if(this.selected == "4")
            {
                this.http.post<any>("http://localhost:8080/api/db1/age-groups-by-hd-positive",this.value, { observe: 'response' })
                       .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                (obj : any, key : any) => {
                                                                                  obj[key] = response.body[key];
                                                                                  return obj;
                                                                                },
                                                                                {}
                                                                              );
                                                                              //this.result = JSON.stringify(ordered);
                                                                              var values = [];
                                                                              var labels = [];
                                                                              for(var i in ordered){
                                                                                  values.push(ordered[i]);
                                                                                  labels.push(i);
                                                                              }
                                                                              this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                              this.barChartLabels = labels;
                                                                              this.ch.nativeElement.style.display="block";




                                       })

            }
            else if(this.selected == "5")
            {
                this.http.post<any>("http://localhost:8080/api/db1/bp-groups-by-hd-positive", this.value, { observe: 'response' })
                                       .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                (obj : any, key : any) => {
                                                                                                  obj[key] = response.body[key];
                                                                                                  return obj;
                                                                                                },
                                                                                                {}
                                                                                              );
                                                                                              //this.result = JSON.stringify(ordered);
                                                                                              var values = [];
                                                                                              var labels = [];
                                                                                              for(var i in ordered){
                                                                                                  values.push(ordered[i]);
                                                                                                  labels.push(i);
                                                                                              }
                                                                                              this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                              this.barChartLabels = labels;
                                                                                              this.ch.nativeElement.style.display="block";




                                                       })
            }
            else if(this.selected == "6")
            {
                this.http.post<any>("http://localhost:8080/api/db1/st-slope-groups-by-hd-positive", this.value, { observe: 'response' })
                                                                                                                   .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                                                                                            (obj : any, key : any) => {
                                                                                                                                                                              obj[key] = response.body[key];
                                                                                                                                                                              return obj;
                                                                                                                                                                            },
                                                                                                                                                                            {}
                                                                                                                                                                          );
                                                                                                                                                                          //this.result = JSON.stringify(ordered);
                                                                                                                                                                          var values = [];
                                                                                                                                                                          var labels = [];
                                                                                                                                                                          for(var i in ordered){
                                                                                                                                                                              values.push(ordered[i]);
                                                                                                                                                                              labels.push(i);
                                                                                                                                                                          }
                                                                                                                                                                          this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                                                                                                          this.barChartLabels = labels;
                                                                                                                                                                          this.ch.nativeElement.style.display="block";




                                                                                                                                   })
            }
            else if(this.selected == "7")
            {
                this.http.post<any>("http://localhost:8080/api/db1/cholesterol-groups-by-hd-positive", this.value, { observe: 'response' })
                                                                                                                      .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                                                                                               (obj : any, key : any) => {
                                                                                                                                                                                 obj[key] = response.body[key];
                                                                                                                                                                                 return obj;
                                                                                                                                                                               },
                                                                                                                                                                               {}
                                                                                                                                                                             );
                                                                                                                                                                             //this.result = JSON.stringify(ordered);
                                                                                                                                                                             var values = [];
                                                                                                                                                                             var labels = [];
                                                                                                                                                                             for(var i in ordered){
                                                                                                                                                                                 values.push(ordered[i]);
                                                                                                                                                                                 labels.push(i);
                                                                                                                                                                             }
                                                                                                                                                                             this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                                                                                                             this.barChartLabels = labels;
                                                                                                                                                                             this.ch.nativeElement.style.display="block";




                                                                                                                                      })
            }
            else if(this.selected == "8")
            {
                this.http.post<any>("http://localhost:8080/api/db1/resting-ecg-groups-by-hd-positive", this.value, { observe: 'response' })
                                                                                                                      .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                                                                                               (obj : any, key : any) => {
                                                                                                                                                                                 obj[key] = response.body[key];
                                                                                                                                                                                 return obj;
                                                                                                                                                                               },
                                                                                                                                                                               {}
                                                                                                                                                                             );
                                                                                                                                                                             //this.result = JSON.stringify(ordered);
                                                                                                                                                                             var values = [];
                                                                                                                                                                             var labels = [];
                                                                                                                                                                             for(var i in ordered){
                                                                                                                                                                                 values.push(ordered[i]);
                                                                                                                                                                                 labels.push(i);
                                                                                                                                                                             }
                                                                                                                                                                             this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                                                                                                             this.barChartLabels = labels;
                                                                                                                                                                             this.ch.nativeElement.style.display="block";




                                                                                                                                      })
            }
            else if(this.selected == "9")
            {
                this.http.post<any>("http://localhost:8080/api/db1/max-hr-groups-by-hd-positive", this.value, { observe: 'response' })
.subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                         (obj : any, key : any) => {
                                                           obj[key] = response.body[key];
                                                           return obj;
                                                         },
                                                         {}
                                                       );
                                                       //this.result = JSON.stringify(ordered);
                                                       var values = [];
                                                       var labels = [];
                                                       for(var i in ordered){
                                                           values.push(ordered[i]);
                                                           labels.push(i);
                                                       }
                                                       this.barChartData = [{ data : values, label: 'Histogram'}];
                                                       this.barChartLabels = labels;
                                                       this.ch.nativeElement.style.display="block";




                })

            }
            else if(this.selected == "10")
            {
                this.http.post<any>("http://localhost:8080/api/db1/exercise-angina-groups-by-hd-positive", this.value, { observe: 'response' })
                .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                         (obj : any, key : any) => {
                                                                           obj[key] = response.body[key];
                                                                           return obj;
                                                                         },
                                                                         {}
                                                                       );
                                                                       //this.result = JSON.stringify(ordered);
                                                                       var values = [];
                                                                       var labels = [];
                                                                       for(var i in ordered){
                                                                           values.push(ordered[i]);
                                                                           labels.push(i);
                                                                       }
                                                                       this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                       this.barChartLabels = labels;
                                                                       this.ch.nativeElement.style.display="block";




                                })
            }
            else if(this.selected == "11")
            {
                console.log(this.selected);
                this.http.post<any>("http://localhost:8080/api/db2/average-age", this.value).subscribe(data => {
                                                                                                                    this.result = data;
                                                                                                                    this.ch.nativeElement.style.display="none";
                                                                                               })
            }
            else if(this.selected == "12")
            {
                this.http.post<any>("http://localhost:8080/api/db2/num-records-by-sex", this.value, { observe: 'response' })
                                       .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                                (obj : any, key : any) => {
                                                                                                                  obj[key] = response.body[key];
                                                                                                                  return obj;
                                                                                                                },
                                                                                                                {}
                                                                                                              );
                                                                                                              //this.result = JSON.stringify(ordered);
                                                                                                              var values = [];
                                                                                                              var labels = [];
                                                                                                              for(var i in ordered){
                                                                                                                  values.push(ordered[i]);
                                                                                                                  labels.push(i);
                                                                                                              }
                                                                                                              this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                                              this.barChartLabels = labels;
                                                                                                              this.ch.nativeElement.style.display="block";




                                                                       })
            }
            else if(this.selected == "13")
            {
                this.http.post<any>("http://localhost:8080/api/db2/education-groups-by-hd-positive", this.value, { observe: 'response' })
                       .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                (obj : any, key : any) => {
                                                                                                  obj[key] = response.body[key];
                                                                                                  return obj;
                                                                                                },
                                                                                                {}
                                                                                              );
                                                                                              //this.result = JSON.stringify(ordered);
                                                                                              var values = [];
                                                                                              var labels = [];
                                                                                              for(var i in ordered){
                                                                                                  values.push(ordered[i]);
                                                                                                  labels.push(i);
                                                                                              }
                                                                                              this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                              this.barChartLabels = labels;
                                                                                              this.ch.nativeElement.style.display="block";




                                                       })
            }
            else if(this.selected == "14")
            {
                this.http.post<any>("http://localhost:8080/api/db2/current-smoker-by-hd-positive", this.value, { observe: 'response' })
                        .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                 (obj : any, key : any) => {
                                                                                                   obj[key] = response.body[key];
                                                                                                   return obj;
                                                                                                 },
                                                                                                 {}
                                                                                               );
                                                                                               //this.result = JSON.stringify(ordered);
                                                                                               var values = [];
                                                                                               var labels = [];
                                                                                               for(var i in ordered){
                                                                                                   values.push(ordered[i]);
                                                                                                   labels.push(i);
                                                                                               }
                                                                                               this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                               this.barChartLabels = labels;
                                                                                               this.ch.nativeElement.style.display="block";




                                                        })
            }
            else if(this.selected == "15")
                        {
                            this.http.post<any>("http://localhost:8080/api/db2/cigs-per-day-by-hd-positive", this.value, { observe: 'response' })
                                    .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                             (obj : any, key : any) => {
                                                                                                               obj[key] = response.body[key];
                                                                                                               return obj;
                                                                                                             },
                                                                                                             {}
                                                                                                           );
                                                                                                           //this.result = JSON.stringify(ordered);
                                                                                                           var values = [];
                                                                                                           var labels = [];
                                                                                                           for(var i in ordered){
                                                                                                               values.push(ordered[i]);
                                                                                                               labels.push(i);
                                                                                                           }
                                                                                                           this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                                           this.barChartLabels = labels;
                                                                                                           this.ch.nativeElement.style.display="block";




                                                                    })
                        }
else if(this.selected == "16")
            {
                this.http.post<any>("http://localhost:8080/api/db2/bp-meds-groups-by-hd-positive", this.value, { observe: 'response' })
                        .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                 (obj : any, key : any) => {
                                                                                                   obj[key] = response.body[key];
                                                                                                   return obj;
                                                                                                 },
                                                                                                 {}
                                                                                               );
                                                                                               //this.result = JSON.stringify(ordered);
                                                                                               var values = [];
                                                                                               var labels = [];
                                                                                               for(var i in ordered){
                                                                                                   values.push(ordered[i]);
                                                                                                   labels.push(i);
                                                                                               }
                                                                                               this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                               this.barChartLabels = labels;
                                                                                               this.ch.nativeElement.style.display="block";




                                                        })
            }
            else if(this.selected == "17")
                        {
                            this.http.post<any>("http://localhost:8080/api/db2/prevalent-stroke-by-hd-positive", this.value, { observe: 'response' })
                                    .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                             (obj : any, key : any) => {
                                                                                                               obj[key] = response.body[key];
                                                                                                               return obj;
                                                                                                             },
                                                                                                             {}
                                                                                                           );
                                                                                                           //this.result = JSON.stringify(ordered);
                                                                                                           var values = [];
                                                                                                           var labels = [];
                                                                                                           for(var i in ordered){
                                                                                                               values.push(ordered[i]);
                                                                                                               labels.push(i);
                                                                                                           }
                                                                                                           this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                                           this.barChartLabels = labels;
                                                                                                           this.ch.nativeElement.style.display="block";




                                                                    })
                        }
           else if(this.selected == "18")
                       {
                           this.http.post<any>("http://localhost:8080/api/db2/prevalent-hypertension-by-hd-positive", this.value, { observe: 'response' })
                                   .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                            (obj : any, key : any) => {
                                                                                                              obj[key] = response.body[key];
                                                                                                              return obj;
                                                                                                            },
                                                                                                            {}
                                                                                                          );
                                                                                                          //this.result = JSON.stringify(ordered);
                                                                                                          var values = [];
                                                                                                          var labels = [];
                                                                                                          for(var i in ordered){
                                                                                                              values.push(ordered[i]);
                                                                                                              labels.push(i);
                                                                                                          }
                                                                                                          this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                                          this.barChartLabels = labels;
                                                                                                          this.ch.nativeElement.style.display="block";




                                                                   })
                       }
else if(this.selected == "19")
            {
                this.http.post<any>("http://localhost:8080/api/db2/diabetes-by-hd-positive", this.value, { observe: 'response' })
                        .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                 (obj : any, key : any) => {
                                                                                                   obj[key] = response.body[key];
                                                                                                   return obj;
                                                                                                 },
                                                                                                 {}
                                                                                               );
                                                                                               //this.result = JSON.stringify(ordered);
                                                                                               var values = [];
                                                                                               var labels = [];
                                                                                               for(var i in ordered){
                                                                                                   values.push(ordered[i]);
                                                                                                   labels.push(i);
                                                                                               }
                                                                                               this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                               this.barChartLabels = labels;
                                                                                               this.ch.nativeElement.style.display="block";




                                                        })
            }
else if(this.selected == "20")
            {
                this.http.post<any>("http://localhost:8080/api/db2/cholesterol-groups-by-hd-positive", this.value, { observe: 'response' })
                        .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                 (obj : any, key : any) => {
                                                                                                   obj[key] = response.body[key];
                                                                                                   return obj;
                                                                                                 },
                                                                                                 {}
                                                                                               );
                                                                                               //this.result = JSON.stringify(ordered);
                                                                                               var values = [];
                                                                                               var labels = [];
                                                                                               for(var i in ordered){
                                                                                                   values.push(ordered[i]);
                                                                                                   labels.push(i);
                                                                                               }
                                                                                               this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                               this.barChartLabels = labels;
                                                                                               this.ch.nativeElement.style.display="block";




                                                        })
            }
else if(this.selected == "21")
            {
                this.http.post<any>("http://localhost:8080/api/db2/bmi-groups-by-hd-positive", this.value, { observe: 'response' })
                        .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                 (obj : any, key : any) => {
                                                                                                   obj[key] = response.body[key];
                                                                                                   return obj;
                                                                                                 },
                                                                                                 {}
                                                                                               );
                                                                                               //this.result = JSON.stringify(ordered);
                                                                                               var values = [];
                                                                                               var labels = [];
                                                                                               for(var i in ordered){
                                                                                                   values.push(ordered[i]);
                                                                                                   labels.push(i);
                                                                                               }
                                                                                               this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                               this.barChartLabels = labels;
                                                                                               this.ch.nativeElement.style.display="block";




                                                        })
            }
else if(this.selected == "22")
            {
                this.http.post<any>("http://localhost:8080/api/db3/high-bp-by-hd-positive", this.value, { observe: 'response' })
                        .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                 (obj : any, key : any) => {
                                                                                                   obj[key] = response.body[key];
                                                                                                   return obj;
                                                                                                 },
                                                                                                 {}
                                                                                               );
                                                                                               //this.result = JSON.stringify(ordered);
                                                                                               var values = [];
                                                                                               var labels = [];
                                                                                               for(var i in ordered){
                                                                                                   values.push(ordered[i]);
                                                                                                   labels.push(i);
                                                                                               }
                                                                                               this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                               this.barChartLabels = labels;
                                                                                               this.ch.nativeElement.style.display="block";




                                                        })
            }
else if(this.selected == "23")
            {
                this.http.post<any>("http://localhost:8080/api/db3/high-chol-by-hd-positive", this.value, { observe: 'response' })
                        .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                 (obj : any, key : any) => {
                                                                                                   obj[key] = response.body[key];
                                                                                                   return obj;
                                                                                                 },
                                                                                                 {}
                                                                                               );
                                                                                               //this.result = JSON.stringify(ordered);
                                                                                               var values = [];
                                                                                               var labels = [];
                                                                                               for(var i in ordered){
                                                                                                   values.push(ordered[i]);
                                                                                                   labels.push(i);
                                                                                               }
                                                                                               this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                               this.barChartLabels = labels;
                                                                                               this.ch.nativeElement.style.display="block";




                                                        })
            }
else if(this.selected == "24")
            {
                this.http.post<any>("http://localhost:8080/api/db3/bmi-groups-by-hd-positive", this.value, { observe: 'response' })
                        .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                 (obj : any, key : any) => {
                                                                                                   obj[key] = response.body[key];
                                                                                                   return obj;
                                                                                                 },
                                                                                                 {}
                                                                                               );
                                                                                               //this.result = JSON.stringify(ordered);
                                                                                               var values = [];
                                                                                               var labels = [];
                                                                                               for(var i in ordered){
                                                                                                   values.push(ordered[i]);
                                                                                                   labels.push(i);
                                                                                               }
                                                                                               this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                               this.barChartLabels = labels;
                                                                                               this.ch.nativeElement.style.display="block";




                                                        })
            }
else if(this.selected == "25")
            {
                this.http.post<any>("http://localhost:8080/api/db3/smoker-by-hd-positive", this.value, { observe: 'response' })
                        .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                 (obj : any, key : any) => {
                                                                                                   obj[key] = response.body[key];
                                                                                                   return obj;
                                                                                                 },
                                                                                                 {}
                                                                                               );
                                                                                               //this.result = JSON.stringify(ordered);
                                                                                               var values = [];
                                                                                               var labels = [];
                                                                                               for(var i in ordered){
                                                                                                   values.push(ordered[i]);
                                                                                                   labels.push(i);
                                                                                               }
                                                                                               this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                               this.barChartLabels = labels;
                                                                                               this.ch.nativeElement.style.display="block";




                                                        })
            }
else if(this.selected == "26")
            {
                this.http.post<any>("http://localhost:8080/api/db3/stroke-by-hd-positive", this.value, { observe: 'response' })
                        .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                 (obj : any, key : any) => {
                                                                                                   obj[key] = response.body[key];
                                                                                                   return obj;
                                                                                                 },
                                                                                                 {}
                                                                                               );
                                                                                               //this.result = JSON.stringify(ordered);
                                                                                               var values = [];
                                                                                               var labels = [];
                                                                                               for(var i in ordered){
                                                                                                   values.push(ordered[i]);
                                                                                                   labels.push(i);
                                                                                               }
                                                                                               this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                               this.barChartLabels = labels;
                                                                                               this.ch.nativeElement.style.display="block";




                                                        })
            }
else if(this.selected == "27")
            {
                this.http.post<any>("http://localhost:8080/api/db3/diabetes-by-hd-positive", this.value, { observe: 'response' })
                        .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                 (obj : any, key : any) => {
                                                                                                   obj[key] = response.body[key];
                                                                                                   return obj;
                                                                                                 },
                                                                                                 {}
                                                                                               );
                                                                                               //this.result = JSON.stringify(ordered);
                                                                                               var values = [];
                                                                                               var labels = [];
                                                                                               for(var i in ordered){
                                                                                                   values.push(ordered[i]);
                                                                                                   labels.push(i);
                                                                                               }
                                                                                               this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                               this.barChartLabels = labels;
                                                                                               this.ch.nativeElement.style.display="block";




                                                        })
            }
else if(this.selected == "28")
            {
                this.http.post<any>("http://localhost:8080/api/db3/physical-activity-by-hd-positive", this.value, { observe: 'response' })
                        .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                 (obj : any, key : any) => {
                                                                                                   obj[key] = response.body[key];
                                                                                                   return obj;
                                                                                                 },
                                                                                                 {}
                                                                                               );
                                                                                               //this.result = JSON.stringify(ordered);
                                                                                               var values = [];
                                                                                               var labels = [];
                                                                                               for(var i in ordered){
                                                                                                   values.push(ordered[i]);
                                                                                                   labels.push(i);
                                                                                               }
                                                                                               this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                               this.barChartLabels = labels;
                                                                                               this.ch.nativeElement.style.display="block";




                                                        })
            }
else if(this.selected == "29")
            {
                this.http.post<any>("http://localhost:8080/api/db3/fruits-by-hd-positive", this.value, { observe: 'response' })
                        .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                 (obj : any, key : any) => {
                                                                                                   obj[key] = response.body[key];
                                                                                                   return obj;
                                                                                                 },
                                                                                                 {}
                                                                                               );
                                                                                               //this.result = JSON.stringify(ordered);
                                                                                               var values = [];
                                                                                               var labels = [];
                                                                                               for(var i in ordered){
                                                                                                   values.push(ordered[i]);
                                                                                                   labels.push(i);
                                                                                               }
                                                                                               this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                               this.barChartLabels = labels;
                                                                                               this.ch.nativeElement.style.display="block";




                                                        })
            }
else if(this.selected == "30")
            {
                this.http.post<any>("http://localhost:8080/api/db3/veggies-by-hd-positive", this.value, { observe: 'response' })
                        .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                 (obj : any, key : any) => {
                                                                                                   obj[key] = response.body[key];
                                                                                                   return obj;
                                                                                                 },
                                                                                                 {}
                                                                                               );
                                                                                               //this.result = JSON.stringify(ordered);
                                                                                               var values = [];
                                                                                               var labels = [];
                                                                                               for(var i in ordered){
                                                                                                   values.push(ordered[i]);
                                                                                                   labels.push(i);
                                                                                               }
                                                                                               this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                               this.barChartLabels = labels;
                                                                                               this.ch.nativeElement.style.display="block";




                                                        })
            }
else if(this.selected == "31")
            {
                this.http.post<any>("http://localhost:8080/api/db3/heavy-alcohol-by-hd-positive", this.value, { observe: 'response' })
                        .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                 (obj : any, key : any) => {
                                                                                                   obj[key] = response.body[key];
                                                                                                   return obj;
                                                                                                 },
                                                                                                 {}
                                                                                               );
                                                                                               //this.result = JSON.stringify(ordered);
                                                                                               var values = [];
                                                                                               var labels = [];
                                                                                               for(var i in ordered){
                                                                                                   values.push(ordered[i]);
                                                                                                   labels.push(i);
                                                                                               }
                                                                                               this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                               this.barChartLabels = labels;
                                                                                               this.ch.nativeElement.style.display="block";




                                                        })
            }
else if(this.selected == "32")
            {
                this.http.post<any>("http://localhost:8080/api/db3/any-healthcare-by-hd-positive", this.value, { observe: 'response' })
                        .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                 (obj : any, key : any) => {
                                                                                                   obj[key] = response.body[key];
                                                                                                   return obj;
                                                                                                 },
                                                                                                 {}
                                                                                               );
                                                                                               //this.result = JSON.stringify(ordered);
                                                                                               var values = [];
                                                                                               var labels = [];
                                                                                               for(var i in ordered){
                                                                                                   values.push(ordered[i]);
                                                                                                   labels.push(i);
                                                                                               }
                                                                                               this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                               this.barChartLabels = labels;
                                                                                               this.ch.nativeElement.style.display="block";




                                                        })
            }
else if(this.selected == "33")
            {
                this.http.post<any>("http://localhost:8080/api/db3/no-doc-cost-by-hd-positive", this.value, { observe: 'response' })
                        .subscribe(response => { const ordered = Object.keys(response.body).sort().reduce(
                                                                                                 (obj : any, key : any) => {
                                                                                                   obj[key] = response.body[key];
                                                                                                   return obj;
                                                                                                 },
                                                                                                 {}
                                                                                               );
                                                                                               //this.result = JSON.stringify(ordered);
                                                                                               var values = [];
                                                                                               var labels = [];
                                                                                               for(var i in ordered){
                                                                                                   values.push(ordered[i]);
                                                                                                   labels.push(i);
                                                                                               }
                                                                                               this.barChartData = [{ data : values, label: 'Histogram'}];
                                                                                               this.barChartLabels = labels;
                                                                                               this.ch.nativeElement.style.display="block";




                                                        })
            }


  }

  }


}
