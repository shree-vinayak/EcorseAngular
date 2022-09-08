import { Component, OnInit } from '@angular/core';
import { GenericService } from 'src/app/service/generic.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-get-all-students',
  templateUrl: './get-all-students.component.html',
  styleUrls: ['./get-all-students.component.css']
})
export class GetAllStudentsComponent implements OnInit {

  studentResp:any=null;
  showTeacherUpdateForm:boolean=false;
  teacherForm:FormGroup;
  constructor(private gen:GenericService,private fb:FormBuilder) { }

  ngOnInit() {
    this.teacherForm=this.fb.group({
      name:['',Validators.required]
    })

    this.gen.getAllStudents().subscribe((response)=>
    {
       this.studentResp= response; 
       
    });
  }

  updateTeacher(data)
  {

    this.teacherForm.patchValue({
      name:data.name
      
     });
     this.showTeacherUpdateForm=true;
  }

  updateTeacherApi()
  {
    this.showTeacherUpdateForm=false; 

  }

}
