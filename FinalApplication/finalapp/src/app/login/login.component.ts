import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GenserviceService } from '../service/genservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login: FormGroup
  constructor(private formbuilder: FormBuilder,
    private router: Router, private genservice: GenserviceService) { }

  ngOnInit() {
    this.login = this.formbuilder.group({
      username: ['', [Validators.email, Validators.required]],
      passoword: ['', Validators.required],
      // confirmpassword:['',Validators.required]
    });
    // /,{validator: validatepassord}
    // this.login.reset();
  }

  loginapi() {
    this.genservice.login(this.login.value).subscribe((response: any) => {

      if (response.flag === true) {
        sessionStorage.setItem("username", response.data.username);
        sessionStorage.setItem("token", response.token);
        sessionStorage.setItem("role", response.data.role);
        sessionStorage.setItem("token", response.token);
        if (response.data.role === 'ADMIN') {
          this.router.navigate(['/admin-home'])
        }
        if (response.data.role === 'TEACHER') {
          this.router.navigate(['/teacher-home'])
        }

        if (response.data.role === 'STUDENT') {
          this.router.navigate(['/student-home'])
        }
      }

      else {
        alert(response.msg);
      }

    });
  }




}
