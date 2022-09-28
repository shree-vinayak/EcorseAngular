import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GenserviceService } from 'src/app/service/genservice.service';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent implements OnInit {


  studentform: FormGroup;

  constructor(private genservice: GenserviceService, private fb: FormBuilder) { }

  ngOnInit() {

    this.studentform = this.fb.group({
      studentusername: ['', Validators.required],
      studentname: ['', Validators.required],
      studentpassword: ['', Validators.required],
      studentclass: ['', Validators.required],
      studentage: ['', Validators.required],
      studentmobile: ['', Validators.required],
      role: ['STUDENT', Validators.required],
      createdby: [sessionStorage.getItem("username"), Validators.required],
      studentschool: ['', Validators.required]
    });
  }


  submitstudentDetails() {
    if (this.studentform.invalid) {
      return;
    }
    console.log(this.studentform.value);

  }

}
