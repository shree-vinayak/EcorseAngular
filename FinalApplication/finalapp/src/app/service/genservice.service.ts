import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GenserviceService {

  constructor(private http:HttpClient) { }


  //LOGIN API
  login(loginFormValue:any)
  {
    return this .http.post(environment.baseurl+"login-ops/login",loginFormValue);
  }


  //CHECK WHEATHER THE USER IS LOGIN OR NOT
  isUserLoggedIn() {
    let user = sessionStorage.getItem('username');
    console.log(!(user === null))
    return !(user === null)
  }


}
