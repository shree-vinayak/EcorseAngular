import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { GenserviceService } from 'src/app/service/genservice.service';

@Component({
  selector: 'app-show-result',
  templateUrl: './show-result.component.html',
  styleUrls: ['./show-result.component.css']
})
export class ShowResultComponent implements OnInit {

  constructor(private getservice:GenserviceService, private fb:FormBuilder) { }
  
  ngOnInit() {
  
  }
  showResult:boolean=false; 
  exampType:string=null;
  getMyResult(examtype:string)
  {
    this.showResult=true; 
    this.exampType=examtype
  }

}
