import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class GenericService {

  constructor(private httpclient:HttpClient,private router:Router) { }
baseurl:string='http://localhost:8080/'
 
 
login(loginObj:any)
  {
   return   this.httpclient.post(this.baseurl+'login',loginObj);
  }

  getAllStudents()
  {
  const headers= new HttpHeaders().set('Authorization', sessionStorage.getItem('token'))
   return   this.httpclient.get(this.baseurl+'admin/get-students', { 'headers': headers });
  }


  isUserLoggedIn() {
    let user = sessionStorage.getItem('emailid');
    console.log(!(user === null))
    return !(user === null)
  }

  isUserAdmin() {
    let role = sessionStorage.getItem('role');
    if(role==='ADMIN')
    {
      return true;
    }
    return false;
  }

  isUserTeacher() {
    let role = sessionStorage.getItem('role');
    if(role==='TEACHER')
    {
      return true;
    }
    return false;
  }

  logOut() {
    sessionStorage.removeItem('emailid')
    sessionStorage.removeItem('token')
  }

  
}

 
