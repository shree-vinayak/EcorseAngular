import { Component, OnInit } from '@angular/core';
import { resetFakeAsyncZone } from '@angular/core/testing';
import { FormBuilder } from '@angular/forms';
import { GenserviceService } from 'src/app/service/genservice.service';

@Component({
  selector: 'app-add-marks',
  templateUrl: './add-marks.component.html',
  styleUrls: ['./add-marks.component.css']
})
export class AddMarksComponent implements OnInit {

  constructor(private genservice:GenserviceService,private fb:FormBuilder) { }
  enterMarksResp:any=null;
  ngOnInit() {

    this.getStudentForEnterMarks();
  }

  getStudentForEnterMarks()
  {
     this.genservice.getStudentForEnterMarks().subscribe((response:any)=>
     {
         this.enterMarksResp=response;
     })
  }

}
