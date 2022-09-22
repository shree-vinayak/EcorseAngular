import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GenserviceService } from 'src/app/service/genservice.service';

@Component({
  selector: 'app-student-sidebar',
  templateUrl: './student-sidebar.component.html',
  styleUrls: ['./student-sidebar.component.css']
})
export class StudentSidebarComponent implements OnInit {

  constructor(private gen: GenserviceService, private router: Router) { }

  ngOnInit() {
  }

  logout() {
    this.gen.logOut();
    this.router.navigate(['login']);
  }

}
