import { Component, OnInit } from '@angular/core';
import { resetFakeAsyncZone } from '@angular/core/testing';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GenserviceService } from 'src/app/service/genservice.service';

@Component({
  selector: 'app-add-marks',
  templateUrl: './add-marks.component.html',
  styleUrls: ['./add-marks.component.css']
})
export class AddMarksComponent implements OnInit {

  constructor(private genservice: GenserviceService, private fb: FormBuilder) { }
  enterMarksResp: any = null;

  exampMarksForm: FormGroup = null;

  showForm: boolean = false;

  ngOnInit() {

    this.getStudentForEnterMarks();
  }



  getStudentForEnterMarks() {
    this.enterMarksResp=null;
    this.genservice.getStudentForEnterMarks().subscribe((response: any) => {
      if (response.flag === true) {
        this.enterMarksResp = response.data;
      }
      else {
        alert(response.msg);
        this.enterMarksResp=null;
      }

    })
  }

  entermarks(examptype, studentObj: any) {
    this.exampMarksForm = this.fb.group({
      studentusername: [{ value: studentObj.studentusername, disabled: true }, Validators.required],
      marks: [0, Validators.required],
      examptype: [examptype, Validators.required],
      enteredby: [sessionStorage.getItem('username')]
    });
    this.showForm = true;
  }

  submitmarks() {
   debugger
    if (this.exampMarksForm.invalid) {
      return;
    }
    var marksObj:any= this.exampMarksForm.getRawValue();
    console.log(this.exampMarksForm.getRawValue())
    this.genservice.updateMarks(marksObj).subscribe((respons: any) => {
      debugger
      if (respons.flag === true) {
        this.showForm = false;
        this.exampMarksForm.reset();
      }
      else {
        alert(respons.msg);

      }
      this.getStudentForEnterMarks();
    })
  }

}
