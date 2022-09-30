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

//THIS APIS IS USED TO REGISETER TEACHERS DETAILS INSIDE THE DATABASE 
  saveTeachersDetails(teachersdata:any)
  {
      const headers= new HttpHeaders().set('Authorization', sessionStorage.getItem('token'))
    return  this.http.post(environment.baseurl+"teacher/saveTeacher",teachersdata, {headers:headers})
  }

  //THIS APIS IS USED TO REGISETER STUDENT DETAILS INSIDE THE DATABASE 
  saveStudentDetails(studentData:any)
  {
     const headers= new HttpHeaders().set('Authorization', sessionStorage.getItem('token'))
     return  this.http.post(environment.baseurl+"student-ops/savestudent",studentData, {headers:headers})
  }


  getStudentForEnterMarks()
  {
    const headers= new HttpHeaders().set('Authorization', sessionStorage.getItem('token'))
    return this.http.get(environment.baseurl+"student-ops/getstudentforentermarks?teacherusername="+sessionStorage.getItem('username'), {headers:headers})
  }


}
