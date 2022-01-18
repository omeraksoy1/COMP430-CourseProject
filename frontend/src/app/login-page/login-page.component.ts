import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { helpers } from 'chart.js';

import { Observable } from 'rxjs';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})

export class LoginPageComponent implements OnInit {
  model: any = {};
  hide = true;
  result:any;
  output:any;


  constructor(private http: HttpClient, private route: ActivatedRoute, private formBuilder: FormBuilder,
    private router: Router,
    ) {
  }
  ngOnInit(): void {
    sessionStorage.setItem('token', '');
  }
  login(){
    let url ='http://localhost:8080/api/login';
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(this.model.username +':'+ this.model.password)
      })
    };

    this.http.get<any>(url,httpOptions).subscribe(data => {
      this.result = data;
      if (data) {
        sessionStorage.setItem(
          'token', 
          btoa(this.model.username + ':' + this.model.password)
        );
        this.router.navigate(['/admin']);
    } else {
        alert("Authentication failed.")
    }
})


this.output = this.result
   

    

  

  }

}
