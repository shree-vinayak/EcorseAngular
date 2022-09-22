import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GenserviceService } from 'src/app/service/genservice.service';

@Component({
  selector: 'app-teacher-sidebar',
  templateUrl: './teacher-sidebar.component.html',
  styleUrls: ['./teacher-sidebar.component.css']
})
export class TeacherSidebarComponent implements OnInit {

  constructor(private gen:GenserviceService,private router:Router) { }

  ngOnInit() {
  }

  logout()
  {
    this.gen.logOut();
    this.router.navigate(['login']);
  }
}
