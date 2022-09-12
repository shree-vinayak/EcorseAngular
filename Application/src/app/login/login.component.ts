import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { GenericService } from '../service/generic.service';
import { Router } from '@angular/router';
import { validatepassord } from '../admin/password.validator';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  login: FormGroup
  constructor(private formbuilder: FormBuilder,
    private generic: GenericService, private router: Router) { }

  ngOnInit() {
    this.login = this.formbuilder.group({
      email: ['', [Validators.email, Validators.required]],
      password: ['', Validators.required],
      // confirmpassword:['',Validators.required]
    });
    // /,{validator: validatepassord}
    this.login.reset();
  }


  loginapi() {
    // this.loader=true;
    console.log(this.login.value);
    this.generic.login(this.login.value).subscribe((response: any) => {
      // this.loader=false
      if (response.flag === true) {
        console.log(response.data.emailid);
        sessionStorage.setItem('emailid', response.data.emailid);
        sessionStorage.setItem('token',response.token);
        sessionStorage.setItem('role',response.role);
        if(response.role==='ADMIN')
        {
          this.router.navigate(['/home'])
        }
        if(response.role==='TEACHER')
        {
          this.router.navigate(['/teacher-home'])
        }
        
      }
      else {
        this.router.navigate(['/login'])
      }
    });
  }
}
