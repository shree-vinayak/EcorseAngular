import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GenserviceService } from 'src/app/service/genservice.service';

@Component({
  selector: 'app-teacher-header',
  templateUrl: './teacher-header.component.html',
  styleUrls: ['./teacher-header.component.css']
})
export class TeacherHeaderComponent implements OnInit {

  constructor(private gen:GenserviceService,private router:Router) { }

  ngOnInit() {
  }

  logout()
  {
    this.gen.logOut();
    this.router.navigate(['login']);
  }
  

}
