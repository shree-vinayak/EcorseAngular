import { HttpClient, HttpHeaders } from '@angular/common/http';
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
    return !(user === null)
  }


  //USED FOR CLEAR SESSION 
  logOut() {
    sessionStorage.removeItem('username')
    sessionStorage.removeItem('role')
    sessionStorage.removeItem('token')
  }
//THIS METHOD IS USED TO CHECK USER ROLE IS ADMIN
  isUserAdmin() {
    let role = sessionStorage.getItem('role');
    if(role==='ADMIN')
    {
      return true;
    }
    return false;
  }
//THIS METHOD IS USED TO CHECK USER ROLE IS TEACHER
  isUserTeacher() {
    let role = sessionStorage.getItem('role');
    if(role==='TEACHER')
    {
      return true;
    }
    return false;
  }


  //THIS METHOD IS USED TO CHECK USER ROLE IS STUDENT
  isUserStudent() {
    let role = sessionStorage.getItem('role');
    if(role==='STUDENT')
    {
      return true;
    }
    return false;
  }


  saveTeachersDetails(teachersdata:any)
  {
      const headers= new HttpHeaders().set('Authorization', sessionStorage.getItem('token'))
    return  this.http.post(environment.baseurl+"teacher/saveTeacher",teachersdata, {headers:headers})
  }


}
