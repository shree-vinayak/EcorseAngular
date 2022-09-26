import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GenserviceService } from 'src/app/service/genservice.service';

@Component({
  selector: 'app-create-teacher',
  templateUrl: './create-teacher.component.html',
  styleUrls: ['./create-teacher.component.css']
})
export class CreateTeacherComponent implements OnInit {

  teacherform: FormGroup;

  constructor(private genservice: GenserviceService, private fb: FormBuilder) { }

  ngOnInit() {
    this.teacherform = this.fb.group({
      teacherusername: ['', Validators.required],
      teachername: ['', Validators.required],
      teacherrole: ['TEACHER', Validators.required],
      school: ['', Validators.required],
      teacherage: ['', Validators.required],
      teachersubject: ['', Validators.required],
      teachermobile: ['', Validators.required],
      teacheraddress: ['', Validators.required],
      teacherexp: ['', Validators.required],
      teacherpassword: ['', Validators.required],
      createby: [sessionStorage.getItem('username'), Validators.required],
      assignedClass1: ['', Validators.required],
      assignedClass2: ['', Validators.required],
      assignedClass3: ['', Validators.required]
    })
  }

  submitTeacherDetails() {
    if (this.teacherform.invalid) {
      return;
    }
    console.log("this.teacherform.value", this.teacherform.value);
  }

}
